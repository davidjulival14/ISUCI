package co.edu.unbosque.model.persistence;

import java.util.ArrayList;


import co.edu.unbosque.model.SportsDirectorDTO;

public class SportsDirectorDAO implements CRUDOperation<SportsDirectorDTO> {
	
	private ArrayList<SportsDirectorDTO> listDirectors;
	private final String FILE_NAME = "filesProject/Directors.csv";
	private final String SERIALIZED_FILE_NAME = "filesProject/Directors.jav";
	
	public SportsDirectorDAO() {
	listDirectors = new ArrayList<>();
	readFromFile();
	leerArchivoSerializado();
	
	
	}
	public void writeFile () {
		
		String contenido = "";
		for (int i = 0; i < listDirectors.size(); i++) {
			contenido += listDirectors.get(i).getGender()+";";
			contenido += listDirectors.get(i).getMail()+";";
			contenido += listDirectors.get(i).getName()+";";
			contenido += listDirectors.get(i).getID()+";";
			contenido += listDirectors.get(i).getIdentificationCard()+";";
			contenido += listDirectors.get(i).getEquipmentHistory()+";";
			contenido += listDirectors.get(i).getExperienceAge()+";";
			contenido += listDirectors.get(i).getNationality()+";";
			
			if (i < listDirectors.size()-1) {
				contenido += "\n";
			}
		}
		FileHandler.openAndWriteFile(FILE_NAME, contenido);
	}
	
	public void readFromFile() {
		
		String contenido = "";
		contenido= FileHandler.openAndReadFile(FILE_NAME);
		if (contenido.equals("")) {
			listDirectors = new ArrayList<>();
			return;		
		}
		listDirectors = new ArrayList<>();
		String [] filas = contenido.split("\n");
		for (int i = 0; i < filas.length; i++) {
			String [] columnas = filas [i].split(";");
			SportsDirectorDTO temp = new SportsDirectorDTO();
			
			temp.setGender(columnas [0]);
			temp.setMail(columnas[1]);
			temp.setName(columnas[2]);
			temp.setID(Long.parseLong(columnas[3]));
			temp.setIdentificationCard(Long.parseLong(columnas[4]));
			temp.setEquipmentHistory(columnas[5]);
			temp.setExperienceAge(Integer.parseInt(columnas[6]));
			temp.setNationality(columnas[7]);

			listDirectors.add(temp);
		}
	}
	
	public void leerArchivoSerializado() {
		Object contenido = FileHandler.abrirLeerSerializado(SERIALIZED_FILE_NAME);
		if (contenido == null) {
			listDirectors = new ArrayList<>();
		} else {
			listDirectors = (ArrayList<SportsDirectorDTO>) contenido;
		}
	}
	
	public String checkIndex(int index) {
		if (index < 0) {
			return "n";
		}
		if (index >= listDirectors.size()) {
			return "o";
		}
		return "g";
	}
	
	@Override
	public void create(SportsDirectorDTO data) {
		listDirectors.add(data);
		writeFile();
		FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listDirectors);
		
	}
	int index = 0;

	@Override
	public String readAll() {
		index = 0;
		StringBuilder sb = new StringBuilder();
		listDirectors.forEach(PersonalExtranjero -> {
			sb.append(index + " -> " + (PersonalExtranjero.toString() + "\n"));
			index++;
		});
		return sb.toString();
	}

	@Override
	public String update(int index, SportsDirectorDTO newData) {
		if (index < 0) {
			return "Posiciones no pueden ser negativas";
		}
		if (index >= listDirectors.size()) {
			return "El indice se ha pasado del tamaño de la lista, tamaño actual: " + listDirectors.size() + " datos";
		}
		listDirectors.set(index, newData);
		writeFile();
		FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listDirectors);
		return "Director actualizado con exito";	
	}
	@Override
	public String eliminarId(long id) {
	String msj = "No existe un Director con ese id";
		
		for (int i = 0; i < listDirectors.size(); i++) {
			if (listDirectors.get(i).getID() == id) {
				listDirectors.remove(i);
				writeFile();
				FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listDirectors);
				msj = "El Director se ha eliminado con exito";
				
				System.out.println("holamundo");
				break;
			}
		}
		
		return msj;
	}
	
	public String delete(int index) {
		if (index < 0) {
			return "Posiciones no pueden ser negativas";
		}
		if (index >= listDirectors.size()) {
			return "El indice se ha pasado del tamaño de la lista, tamaño actual: " + listDirectors.size() + " datos";
		}
		listDirectors.remove(index);
		writeFile();
		FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listDirectors);
		return "Empleado en el indice " + index + " eliminado con exito";

	}
	public int buscarNumeroIde(long id) {
	    if (listDirectors == null) {
	        return -1; // or throw an exception, depending on your requirements
	    }

	    for (int index = 0; index < listDirectors.size(); index++) {
	        if (listDirectors.get(index).getID() == id) {
	            return index;
	        }
	    }

	    return -1; // not found
	}
	
	@Override
	public ArrayList<String> buscarNumeroId(long id) {
		ArrayList<String> director = null;
		for (int i = 0; i < listDirectors.size(); i++) {
			if (listDirectors.get(i).getID() == id) {
				director = listDirectors.get(i).getLista();
				break;
			}
		}
		return director;
	}
	public String readOnly() {
		String salida = " ";
		for (SportsDirectorDTO admi : listDirectors) {
			salida = admi.toString();
		}
		return salida;
	}
	
	public ArrayList<SportsDirectorDTO> getListDirectors() {
		return listDirectors;
	}
	public void setListDirectors(ArrayList<SportsDirectorDTO> listDirectors) {
		this.listDirectors = listDirectors;
	}
	public String getFILE_NAME() {
		return SERIALIZED_FILE_NAME;
	}


	}
	


