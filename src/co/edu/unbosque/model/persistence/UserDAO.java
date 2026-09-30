package co.edu.unbosque.model.persistence;

import java.util.ArrayList;


import co.edu.unbosque.model.UserDTO;

public class UserDAO implements CRUDOperation<UserDTO>{
	
	private ArrayList<UserDTO>listUsers;
	private final String FILE_NAME = "archivosProyecto/Users.csv";
	private final String SERIALIZED_FILE_NAME = "archivosProyecto/Users.jav";
	public UserDAO() {
		listUsers = new ArrayList<>();
		readFromFile ();
	}
public void writeFile () {
		
		String contenido = "";
		for (int i = 0; i < listUsers.size(); i++) {
			contenido += listUsers.get(i).getGender()+";";
			contenido += listUsers.get(i).getMail()+";";
			contenido += listUsers.get(i).getName()+";";
			contenido += listUsers.get(i).getID()+";";
			contenido += listUsers.get(i).getIdentificationCard()+";";
	
		
			if (i < listUsers.size()-1) {
				contenido += "\n";
			}
		}
		FileHandler.openAndWriteFile(FILE_NAME, contenido);
	}
	
	public void readFromFile() {
		
		String contenido = "";
		contenido= FileHandler.openAndReadFile(FILE_NAME);
		if (contenido.equals("")) {
			listUsers = new ArrayList<>();
			return;		
		}
		listUsers = new ArrayList<>();
		String [] filas = contenido.split("\n");
		for (int i = 0; i < filas.length; i++) {
			String [] columnas = filas [i].split(";");
			UserDTO temp = new UserDTO();
			
			temp.setGender(columnas [0]);
			temp.setMail(columnas[1]);
			temp.setName(columnas[2]);
			temp.setID(Long.parseLong(columnas[3]));
			temp.setIdentificationCard(Long.parseLong(columnas[4]));
			

			listUsers.add(temp);
		}
	}
	
	
	public void leerArchivoSerializado() {
		Object contenido = FileHandler.abrirLeerSerializado(SERIALIZED_FILE_NAME);
		if (contenido == null) {
			listUsers = new ArrayList<>();
		} else {
			listUsers = (ArrayList<UserDTO>) contenido;
		}
	}
	
	public String checkIndex(int index) {
		if (index < 0) {
			return "n";
		}
		if (index >= listUsers.size()) {
			return "o";
		}
		return "g";
	}


	@Override
	public void create(UserDTO data) {
		listUsers.add(data);
		writeFile();
		FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listUsers);
		
	}

	@Override
	public String readAll() {
		StringBuilder sb = new StringBuilder("---Lista de Usuarios--- \n");
		listUsers.forEach((e) -> {
			sb.append(e.toString());
		});
		return sb.toString();
	}

	@Override
	public String update(int index, UserDTO newData) {
		if (index < 0) {
			return "Posiciones no pueden ser negativas";
		}
		if (index >= listUsers.size()) {
			return "El indice se ha pasado del tamaño de la lista, tamaño actual: " + listUsers.size() + " datos";
		}
		listUsers.set(index, newData);
		writeFile();
		FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listUsers);
		return "Usuario actualizado con exito";	
	}

	@Override
	public String eliminarId(long id) {
		String msj = "No existe un Usuario con ese id";
		
		for (int i = 0; i < listUsers.size(); i++) {
			if (listUsers.get(i).getID() == id) {
				listUsers.remove(i);
				FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listUsers);
				msj = "El Usuario se ha eliminado con exito";
				break;
			}
		}

		return msj;
	}

	@Override
	public ArrayList<String> buscarNumeroId(long id) {
		ArrayList<String> usuario = null;
		for (int i = 0; i < listUsers.size(); i++) {
			if (listUsers.get(i).getID() == id) {
				usuario = listUsers.get(i).getLista();
				break;
			}
		}
		return usuario;
	}
	public ArrayList<UserDTO> getListUsers() {
		return listUsers;
	}
	public void setListUsers(ArrayList<UserDTO> listUsers) {
		this.listUsers = listUsers;
	}
	public String getSERIALIZED_FILE_NAME() {
		return SERIALIZED_FILE_NAME;
	}


}
