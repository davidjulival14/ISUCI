package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.AdminDTO;


public class AdminDAO implements CRUDOperation<AdminDTO> {

	private ArrayList<AdminDTO> listAdmins;
	private final String FILE_NAME = "filesProject/Admin.csv";
	private final String SERIALIZED_FILE_NAME = "filesProject/Admin.jav";

	public AdminDAO() {
		listAdmins = new ArrayList<>();
		readFromFile();
	}

	public void writeFile() {

		String contenido = "";
		for (int i = 0; i < listAdmins.size(); i++) {
			contenido += listAdmins.get(i).getiD() + ";";
			contenido += listAdmins.get(i).getMail() + ";";
			contenido += listAdmins.get(i).getName() + ";";

			if (i < listAdmins.size() - 1) {
				contenido += "\n";
			}
		}
		FileHandler.openAndWriteFile(FILE_NAME, contenido);
	}

	public void readFromFile() {

		String contenido = "";
		contenido = FileHandler.openAndReadFile(FILE_NAME);
		if (contenido.equals("")) {
			listAdmins = new ArrayList<>();
			return;
		}
		listAdmins = new ArrayList<>();
		String[] filas = contenido.split("\n");
		for (int i = 0; i < filas.length; i++) {
			String[] columnas = filas[i].split(";");
			AdminDTO temp = new AdminDTO();

			temp.setiD(Long.parseLong(columnas[0]));
			temp.setMail(columnas[1]);
			temp.setName(columnas[2]);

			listAdmins.add(temp);
		}
	}

	public void leerArchivoSerializado() {
		Object contenido = FileHandler.abrirLeerSerializado(SERIALIZED_FILE_NAME);
		if (contenido == null) {
			listAdmins = new ArrayList<>();
		} else {
			listAdmins = (ArrayList<AdminDTO>) contenido;
		}
	}

	public String checkIndex(int index) {
		if (index < 0) {
			return "n";
		}
		if (index >= listAdmins.size()) {
			return "o";
		}
		return "g";
	}

	@Override
	public void create(AdminDTO data) {
		listAdmins.add(data);
		writeFile();
		FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listAdmins);

	}

	@Override
	public String readAll() {
		StringBuilder sb = new StringBuilder("---Lista de Admins--- \n");
		listAdmins.forEach((e) -> {
			sb.append(e.toString());
		});
		return sb.toString();
	}

	@Override
	public String update(int index, AdminDTO newData) {
		if (index < 0) {
			return "Posiciones no pueden ser negativas";
		}
		if (index >= listAdmins.size()) {
			return "El indice se ha pasado del tamaño de la lista, tamaño actual: " + listAdmins.size() + " datos";
		}
		listAdmins.set(index, newData);
		writeFile();
		FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listAdmins);
		return "Admin actualizado con exito";
	}

	@Override
	public String eliminarId(long id) {
		String msj = "No existe un admin con ese id";

		for (int i = 0; i < listAdmins.size(); i++) {
			if (listAdmins.get(i).getiD() == id) {
				listAdmins.remove(i);
				FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listAdmins);
				msj = "El admin se ha eliminado con exito";
				break;
			}
		}

		return msj;
	}

	@Override
	public ArrayList<String> buscarNumeroId(long id) {

		return null;
	}
	public String readOnly() {
		String salida = " ";
		for (AdminDTO admi : listAdmins) {
			salida = admi.toString();
		}
		return salida;
	}

	public ArrayList<AdminDTO> getListUsers() {
		return listAdmins;
	}

	public void setListUsers(ArrayList<AdminDTO> listUsers) {
		this.listAdmins = listUsers;
	}

	public String getSERIALIZED_FILE_NAME() {
		return SERIALIZED_FILE_NAME;
	}

}
