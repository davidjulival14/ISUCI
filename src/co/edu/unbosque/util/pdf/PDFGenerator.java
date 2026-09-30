package co.edu.unbosque.util.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PDFGenerator {
		
		Document document;
		String PDFName;
		Phrase header;
		
		public String crearPDF(String nombrePDF, String mensaje) throws DocumentException {
			String path = "";
			try {
        	PDFName = nombrePDF + ".pdf";
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(PDFName));
            document.open();
            header = new Phrase(mensaje);
            document.add(header);
             
            document.close();
             
            System.out.println("PDF creado");
            
            path = "data/" + PDFName;
            
             
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PDFGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return PDFName;
    }
	
}