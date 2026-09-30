package co.edu.unbosque.model.persistence;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.Scanner;

public class FileHandler {
	
		private static FileInputStream fis;
		private static ObjectInputStream ois;
		private static ObjectOutputStream oos;
		private static FileOutputStream fos;
		private static Scanner fileReader;
		private static PrintWriter fileWriter;
		private static File myFile;

		public FileHandler() {
			
		}
		
		public static void verificarFolderDatos() {
			myFile = new File("archivosProyecto");
			if (myFile.mkdir()) {
				System.out.println("folder created for the first time in " + myFile.toURI()); // Verificar si la carpeta
																							// existe
			}
		}
		public static boolean checkSerializedFile(String url) {
			myFile = new File(url);
			return myFile.exists() ? true : false;

		}


		public static void openAndWriteFile(String url, String contentToWrite) {
			myFile = new File(url);
			try {
				
				if (!myFile.exists()) {
					myFile.createNewFile();
				}
				fileWriter = new PrintWriter(myFile);
				fileWriter.write(contentToWrite);
				
			} catch (IOException e) {
				System.out.println("Problem creating the file, check access problems.");
			}
			fileWriter.close();
		}

//		public static Object serilizableOpenAndReadFile(String fileName) {
//
//			try {
//				fis = new FileInputStream(new File("src/co/edu/unbosque/model/persistence/" + fileName));
//			} catch (FileNotFoundException e) {
//				System.out.println("Archivo serializado no encontado pero creado");
//				File temp = new File("src/co/edu/unbosque/model/persistence/" + fileName);
//				try {
//					temp.createNewFile();
//					fis = new FileInputStream(new File("src/co/edu/unbosque/model/persistence/" + fileName));
//				} catch (IOException e1) {
//					System.out.println("Error, el serilizado no pudo ser creado");
//					e1.printStackTrace();
//				}
//			}
//
//			Object content = null;
//			try {
//				ois = new ObjectInputStream(fis);
//				content = ois.readObject();
//				ois.close();
//
//			} catch (IOException e) {
//				System.out.println("No se puede leer el archivo serializado (Input");
//				e.printStackTrace();
//
//			} catch (ClassNotFoundException e) {
//				System.out.println("Error al obtener el contenido");
//				e.printStackTrace();
//
//			}
//			return content;
//		}
		
		
		
//		public static void serializableOpenAndWriteFile(String fileName, Object content) {
//			try {
//				fos = new FileOutputStream(new File("src/co/edu/unbosque/model/persistence/" + fileName));
//			} catch (FileNotFoundException e) {
//				System.out.println("Archivo serializado no encontado pero creado");
//				File temp = new File("src/co/edu/unbosque/modeI/persistence/" + fileName);
//				e.printStackTrace();
//				
//				try {
//					temp.createNewFile();
//					fos = new FileOutputStream(new File("src/co/edu/unbosque/model/persistence/" + fileName));
//				} catch (IOException e1) {
//					System.out.println("Error, el serilizado no pudo ser creado");
//					e1.printStackTrace();
//				}
//			}
//			try {
//				oos = new ObjectOutputStream(fos);
//				oos.writeObject(content);
//				oos.close();
//				
//			} catch (IOException e) {
//				
//				e.printStackTrace();
//			}
//		
//		}
		public static void abrirEscribirSerializable(String url, Object cont) {
			myFile = new File(url);

			try {
				if (!myFile.exists()) {
					myFile.createNewFile();
				}
				fos = new FileOutputStream(myFile);
				oos = new ObjectOutputStream(fos);

				oos.writeObject(cont);

				fos.close();
				oos.close();
			} catch (IOException e) {
				System.out.println("Problems opening serialized file (Write)");
			}

		}
		public static Object abrirLeerSerializado(String url) {
			Object contenido = null;

			myFile = new File(url);

			try {
				if (!myFile.exists()) {
					myFile.createNewFile();
				}

				fis = new FileInputStream(myFile);
				ois = new ObjectInputStream(fis);

				contenido = ois.readObject();

				fis.close();
				ois.close();

			} catch (IOException e) {
				System.out.println("Could not read serialized file (Input): " + url);
			} catch (ClassNotFoundException e) {
				System.out.println("Error getting content: " + url);
				e.printStackTrace();
			}

			return contenido;
		}
		public static String openAndReadFile(String url) {

			String contenido = "";

			try {
				myFile = new File(url);
				if (!myFile.exists()) {
					myFile.createNewFile();
				}

				fileReader = new Scanner(myFile);

				while (fileReader.hasNext()) {
					contenido += fileReader.nextLine() + "\n";
				}

			} catch (IOException e) {
				e.printStackTrace();
			}

			fileReader.close();

			return contenido;
		}
		public static Properties cargarArchivoPropiedades(String url) {
			Properties prop = null;
			try {
				
				prop = new Properties();
				prop.load(new FileInputStream(url));
			} catch (IOException e) {
				System.out.println("Error loading properties file");
				e.printStackTrace();
			}
			return prop;
		}
		public static void guardarArchivoPropiedades(String url, Properties prop) {
			try {
				prop.store(new FileWriter(url), " Writing property data");
			} catch (IOException e) {
				System.out.println("Error saving properties file");
				e.printStackTrace();
			}
		}
}
