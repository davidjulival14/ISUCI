package co.edu.unbosque.model.persistence;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import co.edu.unbosque.model.CyclistDTO;
import co.edu.unbosque.model.MassageTherapistDTO;
import co.edu.unbosque.model.SportsDirectorDTO;
import co.edu.unbosque.model.TeamDTO;

public class TeamDAO implements CRUDOperation<TeamDTO>, TeamCRUDOperation {

	private ArrayList<TeamDTO> listTeams;
	private final String FILE_NAME = "filesProject/Teams.csv";
	private final String SERIALIZED_FILE_NAME = "filesProject/Teams.jav";

	public TeamDAO() {
		listTeams = new ArrayList<>();
		readFromFile();
	}
	public void writeFile() {
	    String contenido = "";
	    for (int i = 0; i < listTeams.size(); i++) {
	        TeamDTO teamDTO = listTeams.get(i);
	        if (teamDTO != null) {
	            String teamName = teamDTO.getTeamName();
	            String country = teamDTO.getCountry();
	            String id_Clicla = teamDTO.getId_Cicla();
	            if (teamName != null && country != null) {
	                contenido += country + ";" + teamName + ";"+ id_Clicla + ";";
	                if (i < listTeams.size() - 1) {
	                    contenido += "\n";
	                }
	            }
	        }
	    }
	    try (FileWriter fw = new FileWriter(FILE_NAME);
	         BufferedWriter bw = new BufferedWriter(fw);
	         PrintWriter out = new PrintWriter(bw)) {
	        out.println(contenido);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	public void readFromFile() {
		
		String contenido = "";
		contenido= FileHandler.openAndReadFile(FILE_NAME);
		if (contenido.equals("")) {
			listTeams = new ArrayList<>();
			return;		
		}
		listTeams = new ArrayList<>();
		String [] filas = contenido.split("\n");
		for (int i = 0; i < filas.length; i++) {
			String [] columnas = filas [i].split(";");
			TeamDTO temp = new TeamDTO(contenido, contenido, contenido,null, null, null);
			
			temp.setCountry(columnas[0]);
			temp.setTeamName(columnas[1]);
			temp.setId_Cicla(columnas[2]);
			listTeams.add(temp);
		}
	}
	public ArrayList<TeamDTO> getListTeams() {
		return listTeams;
	}
	public void setListTeams(ArrayList<TeamDTO> listTeams) {
		this.listTeams = listTeams;
	}
	public String getDataCyclist() {
		return dataCyclist;
	}
	public void setDataCyclist(String dataCyclist) {
		this.dataCyclist = dataCyclist;
	}
	public String getFILE_NAME() {
		return FILE_NAME;
	}
	public String getSERIALIZED_FILE_NAME() {
		return SERIALIZED_FILE_NAME;
	}
	private void esribirEnSerializado() {
		FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listTeams);
	}
	@Override
	public String readAll() {
		StringBuilder sb = new StringBuilder();
		listTeams.forEach((e) -> {
			sb.append(e.toString());
		});
		return sb.toString();
	}
	private void cargarDesdeSerializado() {
		if (FileHandler.checkSerializedFile(SERIALIZED_FILE_NAME)) {
			Object o = FileHandler.abrirLeerSerializado(SERIALIZED_FILE_NAME);
			listTeams = (ArrayList<TeamDTO>) o;
		} else {
			listTeams = new ArrayList<>();
		}

	}	
	public void leerArchivoSerializado() {
		Object contenido = FileHandler.abrirLeerSerializado(SERIALIZED_FILE_NAME);
		if (contenido == null) {
			listTeams = new ArrayList<>();
		} else {
			listTeams = (ArrayList<TeamDTO>) contenido;
		}
	}
	public String delete(int index) {
		if (index < 0) {
			return "Posiciones no pueden ser negativas";
		}
		if (index >= listTeams.size()) {
			return "El indice se ha pasado del tamaño de la lista, tamaño actual: " + listTeams.size()
					+ " datos";
		}
		listTeams.remove(index);
		writeFile();
		FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listTeams);
		return "Equipo en el indice " + index + " eliminado con exito";

	}
	public String checkIndex(int index) {
		if (index < 0) {
			return "n";
		}
		if (index >= listTeams.size()) {
			return "o";
		}
		return "g";
	}
	private String dataCyclist = "";
	private String dataMassage = "";
	private String dataDirector = "";
	public ArrayList<TeamDTO> getListaEquipos() {
		return listTeams;
	}
	public void setListaDepartamentos(ArrayList<TeamDTO> lisTeams) {
		this.listTeams = lisTeams;
	}
	@Override
	public void addCyclistToTeam(int depIndex, CyclistDTO e) {
		listTeams.get(depIndex).getListCyclists().add(e);
		writeFile();
		FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listTeams);
	}
	@Override
	public String readAllCyclistFromTeam(int depIndex) {
		switch (checkIndex(depIndex)) {
		case "n": {
			return "Posiciones no pueden ser negativas";
		}
		case "o": {
			return "El indice se ha pasado del tamaño de la lista, tamaño actual: " + listTeams.size()
					+ " datos";
		}
		case "g": {
			listTeams.get(depIndex).getListCyclists().forEach((e) -> {
				dataCyclist += e.toString();
			});
			return dataCyclist;
		}
		}
		return "Error en impresion de ciclista";
		
	}
	@Override
	public String updateCyclist(int depIndex, int indexEmp, CyclistDTO e) {
		switch (checkIndex(depIndex)) {
		case "n": {
			return "Posiciones no pueden ser negativas";
		}
		case "o": {
			return "El indice se ha pasado del tamaño de la lista, tamaño actual: " + listTeams.size()
					+ " datos";
		}
		case "g": {
			listTeams.get(depIndex).getListCyclists().set(indexEmp, e);
			return " ciclista actualizado con exito";
		}
		}
		
		return "Error en impresion de ciclistas";
	}
	@Override
	public String deleteCyclist(int depIndex, int indexEmp) {
		switch (checkIndex(depIndex)) {
		case "n": {
			return "Posiciones no pueden ser negativas";
		}
		case "o": {
			return "El indice se ha pasado del tamaño de la lista, tamaño actual: " + listTeams.size()
					+ " datos";
		}
		case "g": {
			listTeams.get(depIndex).getListCyclists().remove(indexEmp);
			writeFile();
			FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listTeams);
			return "ciclista eliminado con exito";
		}
		}
		return "Error en impresion de ciclistas";
	}
	@Override
	public void create(TeamDTO data) {
		listTeams.add(data);
		writeFile();
		esribirEnSerializado();
	}
	public int getLast() {
		return listTeams.size() - 1;
	}
	@Override
	public String update(int index, TeamDTO newData) {
		if (index < 0) {
			return "Posiciones no pueden ser negativas";
		}
		if (index >= listTeams.size()) {
			return "El indice se ha pasado del tamaño de la lista, tamaño actual: " + listTeams.size()
					+ " datos";
		}
		listTeams.set(index, newData);
		writeFile();
		FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listTeams);
		return "Equipo actualizado con exito";
	}
	public String eliminarNombre(String nom) {
		String msj = "No existe un equipo con ese nombre";
		for (int i = 0; i < listTeams.size(); i++) {
			if (listTeams.get(i).getTeamName().toLowerCase().equals(nom.toLowerCase())) {
				listTeams.remove(i);
				FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listTeams);
				msj = "El equipo se ha eliminado con exito";
				break;
			}
		}
		
		return msj;
	}
	public int buscarTeamName(String teamName) {
        for (int i = 0; i < listTeams.size(); i++) {
            if (listTeams.get(i).getTeamName().toLowerCase().equals(teamName.toLowerCase())) {
                return i;
            }
        }
        return -1;
    }
	@Override
	public String eliminarId(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<String> buscarNumeroId(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void addMassageToTeam(int depIndex, MassageTherapistDTO e) {
		listTeams.get(depIndex).getAssignedMasseuse().add(e);
		writeFile();
		FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listTeams);
		// TODO Auto-generated method stub
		
	}
	@Override
	public String readAllMassageFromTeam(int depIndex) {
		switch (checkIndex(depIndex)) {
		case "n": {
			return "Posiciones no pueden ser negativas";
		}
		case "o": {
			return "El indice se ha pasado del tamaño de la lista, tamaño actual: " + listTeams.size()
					+ " datos";
		}
		case "g": {
			listTeams.get(depIndex).getAssignedMasseuse().forEach((e) -> {
				dataMassage += e.toString();
			});
			return dataMassage;
		}
		}
		return "Error en impresion de masajista";
	}
	@Override
	public String updateMassage(int depIndex, int indexEmp, MassageTherapistDTO e) {
		switch (checkIndex(depIndex)) {
		case "n": {
			return "Posiciones no pueden ser negativas";
		}
		case "o": {
			return "El indice se ha pasado del tamaño de la lista, tamaño actual: " + listTeams.size()
					+ " datos";
		}
		case "g": {
			listTeams.get(depIndex).getAssignedMasseuse().set(indexEmp, e);
			return " ciclista actualizado con exito";
		}
		}
		
		return "Error en impresion de ciclistas";
		
	}
	@Override
	public String deleteMassage(int depIndex, int indexEmp) {
		switch (checkIndex(depIndex)) {
		case "n": {
			return "Posiciones no pueden ser negativas";
		}
		case "o": {
			return "El indice se ha pasado del tamaño de la lista, tamaño actual: " + listTeams.size()
					+ " datos";
		}
		case "g": {
			listTeams.get(depIndex).getAssignedMasseuse().remove(indexEmp);
			writeFile();
			FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listTeams);
			return "msajista eliminado con exito";
		}
		}
		return "Error en impresion de masajista";
	}
	@Override
	public void addDirectorToTeam(int depIndex, SportsDirectorDTO e) {
		listTeams.get(depIndex).getDirector().add(e);
		writeFile();
		FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listTeams);
		
		// TODO Auto-generated method stub
		
	}
	@Override
	public String readAllDirectorFromTeam(int depIndex) {
		switch (checkIndex(depIndex)) {
		case "n": {
			return "Posiciones no pueden ser negativas";
		}
		case "o": {
			return "El indice se ha pasado del tamaño de la lista, tamaño actual: " + listTeams.size()
					+ " datos";
		}
		case "g": {
			listTeams.get(depIndex).getDirector().forEach((e) -> {
				dataDirector += e.toString();
			});
			return dataDirector;
		}
		}
		return "Error en impresion de masajista";
		// TODO Auto-generated method stub
	}	
	@Override
	public String deleteDirector(int depIndex, int indexEmp) {
		switch (checkIndex(depIndex)) {
		case "n": {
			return "Posiciones no pueden ser negativas";
		}
		case "o": {
			return "El indice se ha pasado del tamaño de la lista, tamaño actual: " + listTeams.size()
					+ " datos";
		}
		case "g": {
			listTeams.get(depIndex).getDirector().remove(indexEmp);
			writeFile();
			FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listTeams);
			return "director eliminado con exito";
		}
		}
		return "Error en impresion de directores";
	}
	@Override
	public String updateDirector(int depIndex, int indexEmp, SportsDirectorDTO e) {
		switch (checkIndex(depIndex)) {
		case "n": {
			return "Posiciones no pueden ser negativas";
		}
		case "o": {
			return "El indice se ha pasado del tamaño de la lista, tamaño actual: " + listTeams.size()
					+ " datos";
		}
		case "g": {
			listTeams.get(depIndex).getDirector().set(indexEmp, e);
			return " director actualizado con exito";
		}
		}
		
		return "Error en impresion de directores";
	}

}
