package co.edu.unbosque.model.persistence;

import java.util.ArrayList;


import co.edu.unbosque.model.CyclistDTO;


public class CyclistDAO implements CRUDOperation<CyclistDTO>{

		private ArrayList<CyclistDTO> listCyclists;
		private final String FILE_NAME = "filesProject/cyclist.csv";
		private final String SERIALIZED_FILE_NAME = "filesProject/ciclist.jav";
		
		
		public CyclistDAO() {
		
			listCyclists = new ArrayList<>();
			readFromFile();
		}
		
		public void writeFile () {
			
			String contenido = "";
			for (int i = 0; i < listCyclists.size(); i++) {
				contenido += listCyclists.get(i).getGender()+";";
				contenido += listCyclists.get(i).getMail()+";";
				contenido += listCyclists.get(i).getName()+";";
				contenido += listCyclists.get(i).getSpeciality()+";";
				contenido += listCyclists.get(i).getHeight()+ ";";
				contenido += listCyclists.get(i).getWeight()+";";
				contenido += listCyclists.get(i).getID()+";";
				contenido += listCyclists.get(i).getIdentificationCard()+";";
				contenido += listCyclists.get(i).getPedalingCadence()+";";
				contenido += listCyclists.get(i).getRaceTime()+";";
				
				if (i < listCyclists.size()-1) {
					contenido += "\n";
				}
			}
			FileHandler.openAndWriteFile(FILE_NAME, contenido);
		}
		
		public void readFromFile() {
			
			String contenido = "";
			contenido= FileHandler.openAndReadFile(FILE_NAME);
			if (contenido.equals("")) {
				listCyclists = new ArrayList<>();
				return;		
			}
			listCyclists = new ArrayList<>();
			String [] filas = contenido.split("\n");
			for (int i = 0; i < filas.length; i++) {
				String [] columnas = filas [i].split(";");
				CyclistDTO temp = new CyclistDTO();
				
				temp.setGender(columnas [0]);
				temp.setMail(columnas[1]);
				temp.setName(columnas[2]);
				temp.setSpeciality(columnas[3]);
				temp.setHeight(Float.parseFloat(columnas [4]));
				temp.setHeight(Float.parseFloat(columnas [5]));
				temp.setID(Long.parseLong(columnas[6]));
				temp.setIdentificationCard(Long.parseLong(columnas[7]));
				temp.setPedalingCadence(Integer.parseInt(columnas[8]));
				temp.setRaceTime(Integer.parseInt(columnas[9]));
				listCyclists.add(temp);
			}
		}
		public void leerArchivoSerializado() {
			Object contenido = FileHandler.abrirLeerSerializado(SERIALIZED_FILE_NAME);
			if (contenido == null) {
				listCyclists = new ArrayList<>();
			} else {
				listCyclists = (ArrayList<CyclistDTO>) contenido;
			}
		}
	
		public String checkIndex(int index) {
			if (index < 0) {
				return "n";
			}
			if (index >= listCyclists.size()) {
				return "o";
			}
			return "g";
		}
		
		public String getSERIALIZED_FILE_NAME() {
			return SERIALIZED_FILE_NAME;
		}

		public String delete(int index) {
			if (index < 0) {
				return "Posiciones no pueden ser negativas";
			}
			if (index >= listCyclists.size()) {
				return "El indice se ha pasado del tamaño de la lista, tamaño actual: " + listCyclists.size() + " datos";
			}
			listCyclists.remove(index);
			writeFile();
			FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listCyclists);
			return "Empleado en el indice " + index + " eliminado con exito";

		}
		
		public int buscarNumeroIde(long id) {
		    if (listCyclists == null) {
		        return -1; // or throw an exception, depending on your requirements
		    }

		    for (int index = 0; index < listCyclists.size(); index++) {
		        if (listCyclists.get(index).getID() == id) {
		            return index;
		        }
		    }

		    return -1; // not found
		}
		
		@Override
		public void create(CyclistDTO data) {
			listCyclists.add(data);
			writeFile();		
			FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listCyclists);
		}
		@Override
		public String readAll() {
			StringBuilder sb = new StringBuilder("---Lista de Cyclist--- \n");
			listCyclists.forEach((e) -> {
				sb.append(e.toString());
			});
			return sb.toString();
		}
		@Override
		public String update(int index, CyclistDTO newData) {
			if (index < 0) {
				return "Posiciones no pueden ser negativas";
			}
			if (index >= listCyclists.size()) {
				return "El indice se ha pasado del tamaño de la lista, tamaño actual: " + listCyclists.size() + " datos";
			}
			listCyclists.set(index, newData);
			writeFile();
			FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listCyclists);
			return "Cyclista actualizado con exito";
		}
		@Override
		public String eliminarId(long id) {
			String msj = "No existe un Cyclista con ese id";
			
			for (int i = 0; i < listCyclists.size(); i++) {
				if (listCyclists.get(i).getID() == id) {
					listCyclists.remove(i);
					writeFile();
					FileHandler.abrirEscribirSerializable(SERIALIZED_FILE_NAME, listCyclists);
					msj = "El Ciclista se ha eliminado con exito";
					break;
				}
			}

			return msj;
		}
		@Override
		public ArrayList<String> buscarNumeroId(long id) {
			ArrayList<String> ciclista = null;
			for (int i = 0; i < listCyclists.size(); i++) {
				if (listCyclists.get(i).getID() == id) {
					ciclista = listCyclists.get(i).getLista();
					break;
				}
			}
			return ciclista;
		}
		public String readOnly() {
			String salida = " ";
			for (CyclistDTO admi : listCyclists) {
				salida = admi.toString();
			}
			return salida;
		}
		

		
		public String getFILE_NAME() {
			return FILE_NAME;
		}
		public ArrayList<CyclistDTO> getListCyclists() {
			return listCyclists;
		}

		public void setListCyclists(ArrayList<CyclistDTO> listCyclists) {
			this.listCyclists = listCyclists;
		}

	

		
		}




