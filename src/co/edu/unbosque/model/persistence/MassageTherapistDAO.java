package co.edu.unbosque.model.persistence;

import java.util.ArrayList;


import co.edu.unbosque.model.MassageTherapistDTO;

public class MassageTherapistDAO implements CRUDOperation<MassageTherapistDTO>{
	
	private ArrayList<MassageTherapistDTO> listMasseurs;
	private final String FILE_NAME = "filesProject/Masseuses.csv";
	private final String SERIALIZED_FILE_NAME = "filesProject/Masseuses.jav";
	
	
	public MassageTherapistDAO() {
		listMasseurs = new ArrayList<>();
		readFromFile();
	}
	public void writeFile () {
		
		String contenido = "";
		for (int i = 0; i < listMasseurs.size(); i++) {
			contenido += listMasseurs.get(i).getGender()+";";
			contenido += listMasseurs.get(i).getMail()+";";
			contenido += listMasseurs.get(i).getName()+";";
			contenido += listMasseurs.get(i).getID()+";";
			contenido += listMasseurs.get(i).getIdentificationCard()+";";
			contenido += listMasseurs.get(i).getSpeciality()+";";
			contenido += listMasseurs.get(i).getExperienceAge()+";";
	
			
			if (i < listMasseurs.size()-1) {
				contenido += "\n";
			}
		}
		FileHandler.openAndWriteFile(FILE_NAME, contenido);
	}
	
	public void readFromFile() {
		
		String contenido = "";
		contenido= FileHandler.openAndReadFile(FILE_NAME);
		if (contenido.equals("")) {
			listMasseurs = new ArrayList<>();
			return;		
		}
		listMasseurs = new ArrayList<>();
		String [] filas = contenido.split("\n");
		for (int i = 0; i < filas.length; i++) {
			String [] columnas = filas [i].split(";");
			MassageTherapistDTO temp = new MassageTherapistDTO();
			
			
			temp.setGender(columnas [0]);
			temp.setMail(columnas[1]);
			temp.setName(columnas[2]);
			temp.setID(Long.parseLong(columnas[3]));
			temp.setIdentificationCard(Long.parseLong(columnas[4]));
			temp.setSpeciality(columnas[5]);
			temp.setExperienceAge(Integer.parseInt(columnas[6]));
	
			listMasseurs.add(temp);
		}
		
	}
	
	public void leerArchivoSerializado() {
		Object contenido = FileHandler.abrirLeerSerializado(SERIALIZED_FILE_NAME);
		if (contenido == null) {
			listMasseurs = new ArrayList<>();
		} else {
			listMasseurs = (ArrayList<MassageTherapistDTO>) contenido;
		}
	}
	
	public String checkIndex(int index) {
		if (index < 0) {
			return "n";
		}
		if (index >= listMasseurs.size()) {
			return "o";
		}
		return "g";
	}
	
	public String delete(int index) {
		if (index < 0) {
			return "Posiciones no pueden ser negativas";
		}
		if (index >= listMasseurs.size()) {
			return "El indice se ha pasado del tamaño de la lista, tamaño actual: " + listMasseurs.size() + " datos";
		}
		listMasseurs.remove(index);
		writeFile();
		FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listMasseurs);
		return "Empleado en el indice " + index + " eliminado con exito";

	}
	
	public int buscarNumeroIde(long id) {
	    if (listMasseurs == null) {
	        return -1; // or throw an exception, depending on your requirements
	    }

	    for (int index = 0; index < listMasseurs.size(); index++) {
	        if (listMasseurs.get(index).getID() == id) {
	            return index;
	        }
	    }

	    return -1; // not found
	}
	
	@Override
	public void create(MassageTherapistDTO data) {
		listMasseurs.add(data);
		writeFile();
		FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listMasseurs);
		
	}
	@Override
	public String readAll() {
		StringBuilder sb = new StringBuilder("---Lista de Masajistas--- \n");
		listMasseurs.forEach((e) -> {
			sb.append(e.toString());
		});
		return sb.toString();
	}
	@Override
	public String update(int index, MassageTherapistDTO newData) {
		if (index < 0) {
			return "Posiciones no pueden ser negativas";
		}
		if (index >= listMasseurs.size()) {
			return "El indice se ha pasado del tamaño de la lista, tamaño actual: " + listMasseurs.size() + " datos";
		}
		listMasseurs.set(index, newData);
		writeFile();
		FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listMasseurs);
		return "Masajista actualizado con exito";	
	}
	
	@Override
	public String eliminarId(long id) {
		String msj = "No existe un Masajista con ese id";
		
		for (int i = 0; i < listMasseurs.size(); i++) {
			if (listMasseurs.get(i).getID() == id) {
				listMasseurs.remove(i);
				FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listMasseurs);
				msj = "El Masajista se ha eliminado con exito";
				break;
			}
		}

		return msj;
	}
	@Override
	public ArrayList<String> buscarNumeroId(long id) {
		ArrayList<String> masajista = null;
		for (int i = 0; i < listMasseurs.size(); i++) {
			if (listMasseurs.get(i).getID() == id) {
				masajista = listMasseurs.get(i).getLista();
				break;
			}
		}
		return masajista;
	}
	public String readOnly() {
		String salida = " ";
		for (MassageTherapistDTO admi : listMasseurs) {
			salida = admi.toString();
		}
		return salida;
	}

	
	public ArrayList<MassageTherapistDTO> getListMasseurs() {
		return listMasseurs;
	}
	public void setListMasseurs(ArrayList<MassageTherapistDTO> listMasseurs) {
		this.listMasseurs = listMasseurs;
	}
	public String getFILE_NAME() {
		return SERIALIZED_FILE_NAME;
	}

	}


