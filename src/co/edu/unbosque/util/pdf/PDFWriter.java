package co.edu.unbosque.util.pdf;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.itextpdf.text.DocumentException;

import co.edu.unbosque.view.ViewFacade;

public class PDFWriter {
	private PDFGenerator pDF;
	private ViewFacade vf;
	public PDFWriter() {
		// TODO Auto-generated constructor stub
		pDF = new PDFGenerator();
		vf = new ViewFacade();
	}
	
	public void PDFGenerator(String archivo) {
	    try {
	        // Leer el contenido del archivo CSV
	        BufferedReader br = new BufferedReader(new FileReader(archivo));
	        StringBuilder contenido = new StringBuilder();
	        String linea;
	        
	        while ((linea = br.readLine()) != null) {
	            contenido.append(linea);
	            contenido.append("\n");
	            
	        }
	        br.close();

	        // Generar el PDF con el contenido leído
	        String aux = vf.getCon().readString("Ingrese el nombre del PDF");
	        pDF.crearPDF(aux, contenido.toString());
	    } catch (IOException | DocumentException e) {
	        System.out.println("ftg");
	    }
}
}
