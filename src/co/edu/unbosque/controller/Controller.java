package co.edu.unbosque.controller;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.LinearGradientPaint;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.io.File;
import java.util.ArrayList;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import javax.swing.plaf.basic.BasicProgressBarUI;

import com.itextpdf.text.DocumentException;

import co.edu.unbosque.model.persistence.FileHandler;
import co.edu.unbosque.util.correo.Mail;
import co.edu.unbosque.model.AdminDTO;
import co.edu.unbosque.model.CyclistDTO;
import co.edu.unbosque.model.MassageTherapistDTO;
import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.SportsDirectorDTO;
import co.edu.unbosque.model.TeamDTO;
import co.edu.unbosque.util.exceptions.NameNotValidException;
import co.edu.unbosque.util.pdf.PDFGenerator;
import co.edu.unbosque.util.pdf.PDFWriter;
import co.edu.unbosque.util.simulation.SimulationResult;
import co.edu.unbosque.util.simulation.SimulationType;
import co.edu.unbosque.util.simulation.SimulationWindow;
import co.edu.unbosque.util.simulation.TeamSimulation;
import co.edu.unbosque.util.exceptions.BlankFieldException;
import co.edu.unbosque.view.ViewFacade;

public class Controller implements ActionListener {

	private Mail correo;
	private Properties mProperties;
	private Session mSeccion;
	private MimeMessage mCorreo;

	private ViewFacade vf;
	private ModelFacade mf;
	private PDFGenerator pDF;
	private PDFWriter pDFW;
	private SimulationWindow sim;
	private TeamSimulation teamSim;
	private SimulationType typeSim;
	private SimulationResult resultSim;

	public Controller() {
		pDFW = new PDFWriter();
		pDF = new PDFGenerator();
		mProperties = new Properties();
		correo = new Mail();
		vf = new ViewFacade();
		mf = new ModelFacade();
		teamSim=new TeamSimulation();
		typeSim=new SimulationType();
		resultSim=new SimulationResult();

		assignClick();
		assignFunction();
		

	}

	public void run() {
		// vf.getwM().setVisible(true);
		
		mainVideoWindow();
		pDFW.PDFGenerator(mf.getCiclistaDAO().getFILE_NAME());;
		// loginWindow();
		// signInWindow();
		// optionWindow();
		// optionTeamWindow();
		// masseuseWindow();
		// masseuseCreateWindow();
		// masseuseUpdateWindow();
		// masseuseShowAllWindow();
		// masseuseDeleteWindow();
		// directorCreateWindow();
		// directorUpdateWindow();
		// directorShowAllWindow();
		// directorDeleteWindow();
		// cyclistDeleteWindow();
		// cyclistShowAllWindow();
		// adminDeleteWindow();
		// adminSearchWindow();
	}

	public ArrayList<String> obtenerTipo(int t) {
		ArrayList<String> listaTipos = new ArrayList<>();
		return listaTipos;
	}
	
public void buscarEscuadra() {
		
		String nombre = vf.gettSAW().getModeloTabla().toString();
		TeamDTO teamSearch=null;
		
		for(TeamDTO escuadra :mf.getEquipoDAO().getListaEquipos())
		{
		   if(nombre.equals(escuadra.getTeamName()))
				   teamSearch= escuadra;  
		}
		
		if(teamSearch==null) {
			vf.getCon().imprimirTextoVE("El equipo no se encontro ");
			return;
		}
		
	
	        int i=0;
	    	for(CyclistDTO ciclistaesc :teamSearch.getListCyclists())
			{ 
	    		 vf.getcSAW().getModeloTabla().setValueAt(ciclistaesc.getID(),i,0);	
	    		 vf.getcSAW().getModeloTabla().setValueAt(ciclistaesc.getName(),i,1);	
		        i++;    
			}
	     
	    	for(MassageTherapistDTO masajista :teamSearch.getAssignedMasseuse())
			{ 
	    		 vf.getmSAW().getModeloTabla().setValueAt(masajista.getID(),i,0);	
	    		 vf.getmSAW().getModeloTabla().setValueAt(masajista.getName(),i,1);	
		        i++;    
			}	
	    	
	    	for(SportsDirectorDTO director :teamSearch.getDirector())
			{ 
	    		 vf.getdSAW().getModeloTabla().setValueAt(director.getID(),i,0);	
	    		 vf.getdSAW().getModeloTabla().setValueAt(director.getName(),i,0);	
		        i++;    
			}	
 		

	        //	vf.getV().getJpnMostrarEscuadra().add(tablaJ);
//		vf.getV().getJpnMostrarEscuadra().getTablaCiclistas().setVisible(true);
//
//		vf.getV().repaint();		
		
	}

	public int login() {
	    int retorno = -1;

	    String usuario = vf.getlW().getTxtUsuario().getText();
	    
	    
	    String contrasena = vf.getlW().getTxtContrasena().getText();
	    if (!usuario.equals(contrasena)) {
	        return 0;
	    }

	    long id = Long.parseLong(usuario);

	    for (CyclistDTO cliclista : mf.getCiclistaDAO().getListCyclists()) {
	        if (cliclista.getID() == id) {
	            mf.setUsuarioLogeado(cliclista);
	            retorno = 1;
	        }
	    }

	    for (MassageTherapistDTO masajista : mf.getMasajistaDAO().getListMasseurs()) {
	        if (masajista.getID() == id) {
	            mf.setUsuarioLogeado(masajista);
	            retorno = 2;
	        }
	    }

	    for (SportsDirectorDTO director : mf.getDirectorDAO().getListDirectors()) {
	        if (director.getID() == id) {
	            mf.setUsuarioLogeado(director);
	            retorno = 3;
	        }
	    }

	    return retorno;
	}

	public void eliminarUsuarioMasajista() {
		long iD = Long.parseLong(vf.getmDW().getTxtEliminarDoc().getText());

		int index = mf.getMasajistaDAO().buscarNumeroIde(iD);

		if (index != -1) {
			vf.getCon().imprimirTextoVE(mf.getMasajistaDAO().delete(index));
		} else {

			vf.getCon().imprimirTextoVE("Usuario no encontrado");

		}
	}

	public void eliminarEquipo() {
		String iD = vf.gettDW().getTxtEliminarDoc().getText();

		int indexName = mf.getEquipoDAO().buscarTeamName(iD);

		if (indexName != -1) {
			vf.getCon().imprimirTextoVE(mf.getMasajistaDAO().delete(indexName));
		} else {

			vf.getCon().imprimirTextoVE("Usuario no encontrado");

		}
	}

	public void eliminarUsuarioCiclista() {
		long iD = Long.parseLong(vf.getcDW().getTxtEliminarDoc().getText());

		int index = mf.getCiclistaDAO().buscarNumeroIde(iD);

		if (index != -1) {
			vf.getCon().imprimirTextoVE(mf.getCiclistaDAO().delete(index));
		} else {

			vf.getCon().imprimirTextoVE("Usuario no encontrado");

		}
	}

	public void eliminarUsuarioDirector() {
		long iD = Long.parseLong(vf.getdDW().getTxtEliminarDoc().getText());

		int index = mf.getDirectorDAO().buscarNumeroIde(iD);

		if (index != -1) {
			vf.getCon().imprimirTextoVE(mf.getDirectorDAO().delete(index));
		} else {

			vf.getCon().imprimirTextoVE("Usuario no encontrado");

		}
	}

	public void mainWindow() {
		Properties configuracion = FileHandler
				.cargarArchivoPropiedades("src/co/edu/unbosque/model/persistence/config.properties");
		vf.getmW().setSize(Integer.parseInt(configuracion.getProperty("Window.ancho")),
				Integer.parseInt(configuracion.getProperty("Window.alto")));
		vf.getmW().setLocationRelativeTo(null);
		vf.getmW().getPanelFondo().setBounds(0, 0, Integer.parseInt(configuracion.getProperty("Panel.ancho")),
				Integer.parseInt(configuracion.getProperty("Panel.alto")));
		vf.getmW().getBtnInicioSesion().setBounds(325, 220, Integer.parseInt(configuracion.getProperty("Boton.ancho")),
				Integer.parseInt(configuracion.getProperty("Boton.alto")));
		vf.getmW().getBtnRegistro().setBounds(325, 290, Integer.parseInt(configuracion.getProperty("Boton.ancho")),
				Integer.parseInt(configuracion.getProperty("Boton.alto")));
		vf.getmW().getBtnAdmin().setBounds(325, 360, Integer.parseInt(configuracion.getProperty("Boton.ancho")),
				Integer.parseInt(configuracion.getProperty("Boton.alto")));
		vf.getmW().getBtnSalir().setBounds(325, 430, Integer.parseInt(configuracion.getProperty("Boton.ancho")),
				Integer.parseInt(configuracion.getProperty("Boton.alto")));
		vf.getmW().getLblImagen().setBounds(0, 0, Integer.parseInt(configuracion.getProperty("Imagen.ancho")),
				Integer.parseInt(configuracion.getProperty("Imagen.alto")));
		vf.getmW().getPanelFondo().add(vf.getmW().getBtnInicioSesion());
		vf.getmW().getPanelFondo().add(vf.getmW().getBtnRegistro());
		vf.getmW().getPanelFondo().add(vf.getmW().getBtnAdmin());
		vf.getmW().getPanelFondo().add(vf.getmW().getBtnSalir());
		vf.getmW().getPanelFondo().add(vf.getmW().getLblImagen());
		vf.getmW().setVisible(true);

	}

	public void loginWindow() {

		Properties configuracion = FileHandler
				.cargarArchivoPropiedades("src/co/edu/unbosque/model/persistence/config.properties");
		vf.getlW().setSize(Integer.parseInt(configuracion.getProperty("Window.ancho")),
				Integer.parseInt(configuracion.getProperty("Window.alto")));
		vf.getlW().setLocationRelativeTo(null);
		vf.getlW().getPanelFondo().setBounds(0, 0, Integer.parseInt(configuracion.getProperty("Panel.ancho")),
				Integer.parseInt(configuracion.getProperty("Panel.alto")));
		vf.getlW().getBtnIniciarSesion().setBounds(430, 600, Integer.parseInt(configuracion.getProperty("Boton.ancho")),
				Integer.parseInt(configuracion.getProperty("Boton.alto")));
		vf.getlW().getPanelFondo().add(vf.getlW().getBtnIniciarSesion());
		vf.getlW().getBtnVolver().setBounds(600, 600, Integer.parseInt(configuracion.getProperty("Boton.ancho")),
				Integer.parseInt(configuracion.getProperty("Boton.alto")));
		vf.getlW().getPanelFondo().add(vf.getlW().getBtnVolver());
		vf.getlW().getLblImagen().setBounds(0, 0, Integer.parseInt(configuracion.getProperty("Imagen.ancho")),
				Integer.parseInt(configuracion.getProperty("Imagen.alto")));
		vf.getlW().getPanelFondo().add(vf.getlW().getLblImagen());
	}

	public void signInWindow() {
		Properties configuracion = FileHandler
				.cargarArchivoPropiedades("src/co/edu/unbosque/model/persistence/config.properties");
		vf.getsIW().setSize(Integer.parseInt(configuracion.getProperty("Window.ancho")),
				Integer.parseInt(configuracion.getProperty("Window.alto")));
		vf.getsIW().setLocationRelativeTo(null);
		vf.getsIW().getPanelFondo().setBounds(0, 0, Integer.parseInt(configuracion.getProperty("Panel.ancho")),
				Integer.parseInt(configuracion.getProperty("Panel.alto")));
		vf.getsIW().getBtnConfirmar().setBounds(430, 580, Integer.parseInt(configuracion.getProperty("Boton.ancho")),
				Integer.parseInt(configuracion.getProperty("Boton.alto")));
		vf.getsIW().getPanelFondo().add(vf.getsIW().getBtnConfirmar());
		vf.getsIW().getBtnVolver().setBounds(580, 580, Integer.parseInt(configuracion.getProperty("Boton.ancho")),
				Integer.parseInt(configuracion.getProperty("Boton.alto")));
		vf.getsIW().getPanelFondo().add(vf.getsIW().getBtnVolver());
		vf.getsIW().getLblImagen().setBounds(0, 0, Integer.parseInt(configuracion.getProperty("Imagen.ancho")),
				Integer.parseInt(configuracion.getProperty("Imagen.alto")));
		vf.getsIW().getPanelFondo().add(vf.getsIW().getLblImagen());
	}

	public void optionWindow() {
		Properties configuracion = FileHandler
				.cargarArchivoPropiedades("src/co/edu/unbosque/model/persistence/config.properties");
		vf.getoW().setSize(Integer.parseInt(configuracion.getProperty("Window.ancho")),
				Integer.parseInt(configuracion.getProperty("Window.alto")));
		vf.getoW().setLocationRelativeTo(null);
		vf.getoW().getPanelFondo().setBounds(0, 0, Integer.parseInt(configuracion.getProperty("Panel.ancho")),
				Integer.parseInt(configuracion.getProperty("Panel.alto")));
		vf.getoW().getBtnCiclista().setBounds(275, 220, Integer.parseInt(configuracion.getProperty("Boton.crud.ancho")),
				Integer.parseInt(configuracion.getProperty("Boton.crud.alto")));
		vf.getoW().getPanelFondo().add(vf.getoW().getBtnCiclista());
		vf.getoW().getBtnMasajista().setBounds(422, 220,
				Integer.parseInt(configuracion.getProperty("Boton.crud.ancho")),
				Integer.parseInt(configuracion.getProperty("Boton.crud.alto")));
		vf.getoW().getPanelFondo().add(vf.getoW().getBtnMasajista());
		vf.getoW().getBtnDirector().setBounds(275, 368, Integer.parseInt(configuracion.getProperty("Boton.crud.ancho")),
				Integer.parseInt(configuracion.getProperty("Boton.crud.alto")));
		vf.getoW().getPanelFondo().add(vf.getoW().getBtnDirector());
		vf.getoW().getBtnAdmin().setBounds(422, 368, Integer.parseInt(configuracion.getProperty("Boton.crud.ancho")),
				Integer.parseInt(configuracion.getProperty("Boton.crud.alto")));
		vf.getoW().getPanelFondo().add(vf.getoW().getBtnAdmin());
		vf.getoW().getBtnVolver().setBounds(600, 600, Integer.parseInt(configuracion.getProperty("Boton.ancho")),
				Integer.parseInt(configuracion.getProperty("Boton.alto")));
		vf.getoW().getPanelFondo().add(vf.getoW().getBtnVolver());
		vf.getoW().getLblImagen().setBounds(0, 0, Integer.parseInt(configuracion.getProperty("Imagen.ancho")),
				Integer.parseInt(configuracion.getProperty("Imagen.alto")));
		vf.getoW().getPanelFondo().add(vf.getoW().getLblImagen());
	}

	public void optionTeamWindow() {
		Properties configuracion = FileHandler
				.cargarArchivoPropiedades("src/co/edu/unbosque/model/persistence/config.properties");
		vf.getoTW().setSize(Integer.parseInt(configuracion.getProperty("Window.ancho")),
				Integer.parseInt(configuracion.getProperty("Window.alto")));
		vf.getoTW().setLocationRelativeTo(null);
		vf.getoTW().getPanelFondo().setBounds(0, 0, Integer.parseInt(configuracion.getProperty("Panel.ancho")),
				Integer.parseInt(configuracion.getProperty("Panel.alto")));
		vf.getoTW().getBtnConfirmar().setBounds(200, 580, Integer.parseInt(configuracion.getProperty("Boton.ancho")),
				Integer.parseInt(configuracion.getProperty("Boton.alto")));
		vf.getoTW().getPanelFondo().add(vf.getoTW().getBtnConfirmar());
		vf.getoTW().getBtnVolver().setBounds(580, 580, Integer.parseInt(configuracion.getProperty("Boton.ancho")),
				Integer.parseInt(configuracion.getProperty("Boton.alto")));
		vf.getoTW().getPanelFondo().add(vf.getoTW().getBtnVolver());
		vf.getoTW().getLblImagen().setBounds(0, 0, Integer.parseInt(configuracion.getProperty("Imagen.ancho")),
				Integer.parseInt(configuracion.getProperty("Imagen.alto")));
		vf.getoTW().getPanelFondo().add(vf.getoTW().getLblImagen());

	}

	public void masseuseWindow() {
		Properties configuracion = FileHandler
				.cargarArchivoPropiedades("src/co/edu/unbosque/model/persistence/config.properties");
		vf.getMaW().setSize(Integer.parseInt(configuracion.getProperty("Window.ancho")),
				Integer.parseInt(configuracion.getProperty("Window.alto")));
		vf.getMaW().setLocationRelativeTo(null);
		vf.getMaW().getPanelFondo().setBounds(0, 0, Integer.parseInt(configuracion.getProperty("Panel.ancho")),
				Integer.parseInt(configuracion.getProperty("Panel.alto")));
		vf.getMaW().getBtnCrear().setBounds(345, 270, Integer.parseInt(configuracion.getProperty("Boton.crud.ancho")),
				Integer.parseInt(configuracion.getProperty("Boton.crud.alto")));
		vf.getMaW().getPanelFondo().add(vf.getMaW().getBtnCrear());
//		vf.getMaW().getBtnActualizar().setBounds(450, 280,
//				Integer.parseInt(configuracion.getProperty("Boton.crud.ancho")),
//				Integer.parseInt(configuracion.getProperty("Boton.crud.alto")));
//		vf.getMaW().getPanelFondo().add(vf.getMaW().getBtnActualizar());
//		vf.getMaW().getBtnEliminar().setBounds(100, 380,
//				Integer.parseInt(configuracion.getProperty("Boton.crud.ancho")),
//				Integer.parseInt(configuracion.getProperty("Boton.crud.alto")));
//		vf.getMaW().getPanelFondo().add(vf.getMaW().getBtnEliminar());
//		vf.getMaW().getBtnMostrar().setBounds(450, 380, Integer.parseInt(configuracion.getProperty("Boton.crud.ancho")),
//				Integer.parseInt(configuracion.getProperty("Boton.crud.alto")));
//		vf.getMaW().getPanelFondo().add(vf.getMaW().getBtnMostrar());
		vf.getMaW().getBtnVolver().setBounds(600, 600, Integer.parseInt(configuracion.getProperty("Boton.ancho")),
				Integer.parseInt(configuracion.getProperty("Boton.alto")));
		vf.getMaW().getPanelFondo().add(vf.getMaW().getBtnVolver());
		vf.getMaW().getLblImagen().setBounds(0, 0, Integer.parseInt(configuracion.getProperty("Imagen.ancho")),
				Integer.parseInt(configuracion.getProperty("Imagen.alto")));
		vf.getMaW().getPanelFondo().add(vf.getMaW().getLblImagen());
	}

	public void masseuseCreateWindow() {
		Properties configuracion = FileHandler
				.cargarArchivoPropiedades("src/co/edu/unbosque/model/persistence/config.properties");
		vf.getmCW().setSize(Integer.parseInt(configuracion.getProperty("Window.ancho")),
				Integer.parseInt(configuracion.getProperty("Window.alto")));
		vf.getmCW().setLocationRelativeTo(null);
		vf.getmCW().getPanelFondo().setBounds(0, 0, Integer.parseInt(configuracion.getProperty("Panel.ancho")),
				Integer.parseInt(configuracion.getProperty("Panel.alto")));
		vf.getmCW().getBtnConfirmar().setBounds(430, 580, Integer.parseInt(configuracion.getProperty("Boton.ancho")),
				Integer.parseInt(configuracion.getProperty("Boton.alto")));
		vf.getmCW().getPanelFondo().add(vf.getmCW().getBtnConfirmar());
		vf.getmCW().getBtnVolver().setBounds(600, 580, Integer.parseInt(configuracion.getProperty("Boton.ancho")),
				Integer.parseInt(configuracion.getProperty("Boton.alto")));
		vf.getmCW().getPanelFondo().add(vf.getmCW().getBtnVolver());
		vf.getmCW().getLblImagen().setBounds(0, 0, Integer.parseInt(configuracion.getProperty("Imagen.ancho")),
				Integer.parseInt(configuracion.getProperty("Imagen.alto")));
		vf.getmCW().getPanelFondo().add(vf.getmCW().getLblImagen());
	}

	public void masseuseUpdateWindow() {
		Properties configuracion = FileHandler
				.cargarArchivoPropiedades("src/co/edu/unbosque/model/persistence/config.properties");
		vf.getmUW().setSize(Integer.parseInt(configuracion.getProperty("Window.ancho")),
				Integer.parseInt(configuracion.getProperty("Window.alto")));
		vf.getmUW().setLocationRelativeTo(null);
		vf.getmUW().getPanelFondo().setBounds(0, 0, Integer.parseInt(configuracion.getProperty("Panel.ancho")),
				Integer.parseInt(configuracion.getProperty("Panel.alto")));
		vf.getmUW().getBtnConfirmar().setBounds(430, 580, Integer.parseInt(configuracion.getProperty("Boton.ancho")),
				Integer.parseInt(configuracion.getProperty("Boton.alto")));
		vf.getmUW().getPanelFondo().add(vf.getmUW().getBtnConfirmar());
		vf.getmUW().getBtnVolver().setBounds(600, 580, Integer.parseInt(configuracion.getProperty("Boton.ancho")),
				Integer.parseInt(configuracion.getProperty("Boton.alto")));
		vf.getmUW().getPanelFondo().add(vf.getmUW().getBtnVolver());
		vf.getmUW().getLblImagen().setBounds(0, 0, Integer.parseInt(configuracion.getProperty("Imagen.ancho")),
				Integer.parseInt(configuracion.getProperty("Imagen.alto")));
		vf.getmUW().getPanelFondo().add(vf.getmUW().getLblImagen());
	}

	public void masseuseShowAllWindow() {
		Properties configuracion = FileHandler
				.cargarArchivoPropiedades("src/co/edu/unbosque/model/persistence/config.properties");
		vf.getmSAW().setSize(Integer.parseInt(configuracion.getProperty("Window.ancho")),
				Integer.parseInt(configuracion.getProperty("Window.alto")));
		vf.getmSAW().setLocationRelativeTo(null);
		vf.getmSAW().getPanelFondo().setBounds(0, 0, Integer.parseInt(configuracion.getProperty("Panel.ancho")),
				Integer.parseInt(configuracion.getProperty("Panel.alto")));
		vf.getmSAW().getBtnVolver().setBounds(600, 580, Integer.parseInt(configuracion.getProperty("Boton.ancho")),
				Integer.parseInt(configuracion.getProperty("Boton.alto")));
		vf.getmSAW().getPanelFondo().add(vf.getmSAW().getBtnVolver());
		vf.getmSAW().getLblImagen().setBounds(0, 0, Integer.parseInt(configuracion.getProperty("Imagen.ancho")),
				Integer.parseInt(configuracion.getProperty("Imagen.alto")));
		vf.getmSAW().getPanelFondo().add(vf.getmSAW().getLblImagen());
	}

	public void masseuseDeleteWindow() {
		Properties configuracion = FileHandler
				.cargarArchivoPropiedades("src/co/edu/unbosque/model/persistence/config.properties");
		vf.getmDW().setSize(Integer.parseInt(configuracion.getProperty("Window.ancho")),
				Integer.parseInt(configuracion.getProperty("Window.alto")));
		vf.getmDW().setLocationRelativeTo(null);
		vf.getmDW().getPanelFondo().setBounds(0, 0, Integer.parseInt(configuracion.getProperty("Panel.ancho")),
				Integer.parseInt(configuracion.getProperty("Panel.alto")));
		vf.getmDW().getBtnConfirmar().setBounds(430, 580, Integer.parseInt(configuracion.getProperty("Boton.ancho")),
				Integer.parseInt(configuracion.getProperty("Boton.alto")));
		vf.getmDW().getPanelFondo().add(vf.getmDW().getBtnConfirmar());
		vf.getmDW().getBtnVolver().setBounds(600, 580, Integer.parseInt(configuracion.getProperty("Boton.ancho")),
				Integer.parseInt(configuracion.getProperty("Boton.alto")));
		vf.getmDW().getPanelFondo().add(vf.getmDW().getBtnVolver());
		vf.getmDW().getLblImagen().setBounds(0, 0, Integer.parseInt(configuracion.getProperty("Imagen.ancho")),
				Integer.parseInt(configuracion.getProperty("Imagen.alto")));
		vf.getmDW().getPanelFondo().add(vf.getmDW().getLblImagen());
	}

	public void directorWindow() {
		Properties configuracion = FileHandler
				.cargarArchivoPropiedades("src/co/edu/unbosque/model/persistence/config.properties");
		vf.getdW().setSize(Integer.parseInt(configuracion.getProperty("Window.ancho")),
				Integer.parseInt(configuracion.getProperty("Window.alto")));
		vf.getdW().setLocationRelativeTo(null);
		vf.getdW().getPanelFondo().setBounds(0, 0, Integer.parseInt(configuracion.getProperty("Panel.ancho")),
				Integer.parseInt(configuracion.getProperty("Panel.alto")));
		vf.getdW().getBtnCrear().setBounds(345, 270, Integer.parseInt(configuracion.getProperty("Boton.crud.ancho")),
				Integer.parseInt(configuracion.getProperty("Boton.crud.alto")));
		vf.getdW().getPanelFondo().add(vf.getdW().getBtnCrear());
//		vf.getMaW().getBtnActualizar().setBounds(450, 280,
//				Integer.parseInt(configuracion.getProperty("Boton.crud.ancho")),
//				Integer.parseInt(configuracion.getProperty("Boton.crud.alto")));
//		vf.getMaW().getPanelFondo().add(vf.getMaW().getBtnActualizar());
//		vf.getMaW().getBtnEliminar().setBounds(100, 380,
//				Integer.parseInt(configuracion.getProperty("Boton.crud.ancho")),
//				Integer.parseInt(configuracion.getProperty("Boton.crud.alto")));
//		vf.getMaW().getPanelFondo().add(vf.getMaW().getBtnEliminar());
//		vf.getMaW().getBtnMostrar().setBounds(450, 380, Integer.parseInt(configuracion.getProperty("Boton.crud.ancho")),
//				Integer.parseInt(configuracion.getProperty("Boton.crud.alto")));
//		vf.getMaW().getPanelFondo().add(vf.getMaW().getBtnMostrar());
		vf.getdW().getBtnExit().setBounds(580, 580, Integer.parseInt(configuracion.getProperty("Boton.ancho")),
				Integer.parseInt(configuracion.getProperty("Boton.alto")));
		vf.getdW().getPanelFondo().add(vf.getdW().getBtnExit());
		vf.getdW().getLblImagen().setBounds(0, 0, Integer.parseInt(configuracion.getProperty("Imagen.ancho")),
				Integer.parseInt(configuracion.getProperty("Imagen.alto")));
		vf.getdW().getPanelFondo().add(vf.getdW().getLblImagen());
	}

	public void directorCreateWindow() {
		Properties configuracion = FileHandler
				.cargarArchivoPropiedades("src/co/edu/unbosque/model/persistence/config.properties");
		vf.getdCW().setSize(Integer.parseInt(configuracion.getProperty("Window.ancho")),
				Integer.parseInt(configuracion.getProperty("Window.alto")));
		vf.getdCW().setLocationRelativeTo(null);
		vf.getdCW().getPanelFondo().setBounds(0, 0, Integer.parseInt(configuracion.getProperty("Panel.ancho")),
				Integer.parseInt(configuracion.getProperty("Panel.alto")));
		vf.getdCW().getBtnConfirmar().setBounds(430, 580, Integer.parseInt(configuracion.getProperty("Boton.ancho")),
				Integer.parseInt(configuracion.getProperty("Boton.alto")));
		vf.getdCW().getPanelFondo().add(vf.getdCW().getBtnConfirmar());
		vf.getdCW().getBtnVolver().setBounds(600, 580, Integer.parseInt(configuracion.getProperty("Boton.ancho")),
				Integer.parseInt(configuracion.getProperty("Boton.alto")));
		vf.getdCW().getPanelFondo().add(vf.getdCW().getBtnVolver());
		vf.getdCW().getLblImagen().setBounds(0, 0, Integer.parseInt(configuracion.getProperty("Imagen.ancho")),
				Integer.parseInt(configuracion.getProperty("Imagen.alto")));
		vf.getdCW().getPanelFondo().add(vf.getdCW().getLblImagen());
	}

	public void directorUpdateWindow() {
		Properties configuracion = FileHandler
				.cargarArchivoPropiedades("src/co/edu/unbosque/model/persistence/config.properties");
		vf.getdUW().setSize(Integer.parseInt(configuracion.getProperty("Window.ancho")),
				Integer.parseInt(configuracion.getProperty("Window.alto")));
		vf.getdUW().setLocationRelativeTo(null);
		vf.getdUW().getPanelFondo().setBounds(0, 0, Integer.parseInt(configuracion.getProperty("Panel.ancho")),
				Integer.parseInt(configuracion.getProperty("Panel.alto")));
		vf.getdUW().getBtnConfirmar().setBounds(430, 580, Integer.parseInt(configuracion.getProperty("Boton.ancho")),
				Integer.parseInt(configuracion.getProperty("Boton.alto")));
		vf.getdUW().getPanelFondo().add(vf.getdUW().getBtnConfirmar());
		vf.getdUW().getBtnVolver().setBounds(600, 580, Integer.parseInt(configuracion.getProperty("Boton.ancho")),
				Integer.parseInt(configuracion.getProperty("Boton.alto")));
		vf.getdUW().getPanelFondo().add(vf.getdUW().getBtnVolver());
		vf.getdUW().getLblImagen().setBounds(0, 0, Integer.parseInt(configuracion.getProperty("Imagen.ancho")),
				Integer.parseInt(configuracion.getProperty("Imagen.alto")));
		vf.getdUW().getPanelFondo().add(vf.getdUW().getLblImagen());
	}

	public void teamUpdateWindow() {
		Properties configuracion = FileHandler
				.cargarArchivoPropiedades("src/co/edu/unbosque/model/persistence/config.properties");
		vf.gettUW().setSize(Integer.parseInt(configuracion.getProperty("Window.ancho")),
				Integer.parseInt(configuracion.getProperty("Window.alto")));
		vf.gettUW().setLocationRelativeTo(null);
		vf.gettUW().getPanelFondo().setBounds(0, 0, Integer.parseInt(configuracion.getProperty("Panel.ancho")),
				Integer.parseInt(configuracion.getProperty("Panel.alto")));
		vf.gettUW().getBtnConfirmar().setBounds(430, 580, Integer.parseInt(configuracion.getProperty("Boton.ancho")),
				Integer.parseInt(configuracion.getProperty("Boton.alto")));
		vf.gettUW().getPanelFondo().add(vf.gettUW().getBtnConfirmar());
		vf.gettUW().getBtnVolver().setBounds(600, 580, Integer.parseInt(configuracion.getProperty("Boton.ancho")),
				Integer.parseInt(configuracion.getProperty("Boton.alto")));
		vf.gettUW().getPanelFondo().add(vf.gettUW().getBtnVolver());
		vf.gettUW().getLblImagen().setBounds(0, 0, Integer.parseInt(configuracion.getProperty("Imagen.ancho")),
				Integer.parseInt(configuracion.getProperty("Imagen.alto")));
		vf.gettUW().getPanelFondo().add(vf.gettUW().getLblImagen());
	}

	public void directorShowAllWindow() {
		Properties configuracion = FileHandler
				.cargarArchivoPropiedades("src/co/edu/unbosque/model/persistence/config.properties");
		vf.getdSAW().setSize(Integer.parseInt(configuracion.getProperty("Window.ancho")),
				Integer.parseInt(configuracion.getProperty("Window.alto")));
		vf.getdSAW().setLocationRelativeTo(null);
		vf.getdSAW().getPanelFondo().setBounds(0, 0, Integer.parseInt(configuracion.getProperty("Panel.ancho")),
				Integer.parseInt(configuracion.getProperty("Panel.alto")));
		vf.getdSAW().getBtnVolver().setBounds(600, 580, Integer.parseInt(configuracion.getProperty("Boton.ancho")),
				Integer.parseInt(configuracion.getProperty("Boton.alto")));
		vf.getdSAW().getPanelFondo().add(vf.getdSAW().getBtnVolver());
		vf.getdSAW().getLblImagen().setBounds(0, 0, Integer.parseInt(configuracion.getProperty("Imagen.ancho")),
				Integer.parseInt(configuracion.getProperty("Imagen.alto")));
		vf.getdSAW().getPanelFondo().add(vf.getdSAW().getLblImagen());
	}

	public void directorDeleteWindow() {
		Properties configuracion = FileHandler
				.cargarArchivoPropiedades("src/co/edu/unbosque/model/persistence/config.properties");
		vf.getdDW().setSize(Integer.parseInt(configuracion.getProperty("Window.ancho")),
				Integer.parseInt(configuracion.getProperty("Window.alto")));
		vf.getdDW().setLocationRelativeTo(null);
		vf.getdDW().getPanelFondo().setBounds(0, 0, Integer.parseInt(configuracion.getProperty("Panel.ancho")),
				Integer.parseInt(configuracion.getProperty("Panel.alto")));
		vf.getdDW().getBtnConfirmar().setBounds(430, 580, Integer.parseInt(configuracion.getProperty("Boton.ancho")),
				Integer.parseInt(configuracion.getProperty("Boton.alto")));
		vf.getdDW().getPanelFondo().add(vf.getdDW().getBtnConfirmar());
		vf.getdDW().getBtnVolver().setBounds(600, 580, Integer.parseInt(configuracion.getProperty("Boton.ancho")),
				Integer.parseInt(configuracion.getProperty("Boton.alto")));
		vf.getdDW().getPanelFondo().add(vf.getdDW().getBtnVolver());
		vf.getdDW().getLblImagen().setBounds(0, 0, Integer.parseInt(configuracion.getProperty("Imagen.ancho")),
				Integer.parseInt(configuracion.getProperty("Imagen.alto")));
		vf.getdDW().getPanelFondo().add(vf.getdDW().getLblImagen());
	}

	public void teamDeleteWindow() {
		Properties configuracion = FileHandler
				.cargarArchivoPropiedades("src/co/edu/unbosque/model/persistence/config.properties");
		vf.gettDW().setSize(Integer.parseInt(configuracion.getProperty("Window.ancho")),
				Integer.parseInt(configuracion.getProperty("Window.alto")));
		vf.gettDW().setLocationRelativeTo(null);
		vf.gettDW().getPanelFondo().setBounds(0, 0, Integer.parseInt(configuracion.getProperty("Panel.ancho")),
				Integer.parseInt(configuracion.getProperty("Panel.alto")));
		vf.gettDW().getBtnConfirmar().setBounds(430, 580, Integer.parseInt(configuracion.getProperty("Boton.ancho")),
				Integer.parseInt(configuracion.getProperty("Boton.alto")));
		vf.gettDW().getPanelFondo().add(vf.gettDW().getBtnConfirmar());
		vf.gettDW().getBtnVolver().setBounds(600, 580, Integer.parseInt(configuracion.getProperty("Boton.ancho")),
				Integer.parseInt(configuracion.getProperty("Boton.alto")));
		vf.gettDW().getPanelFondo().add(vf.gettDW().getBtnVolver());
		vf.gettDW().getLblImagen().setBounds(0, 0, Integer.parseInt(configuracion.getProperty("Imagen.ancho")),
				Integer.parseInt(configuracion.getProperty("Imagen.alto")));
		vf.gettDW().getPanelFondo().add(vf.gettDW().getLblImagen());
	}

	public void cyclistWindow() {
		Properties configuracion = FileHandler
				.cargarArchivoPropiedades("src/co/edu/unbosque/model/persistence/config.properties");
		vf.getcW().setSize(Integer.parseInt(configuracion.getProperty("Window.ancho")),
				Integer.parseInt(configuracion.getProperty("Window.alto")));
		vf.getcW().setLocationRelativeTo(null);
		vf.getcW().getPanelFondo().setBounds(0, 0, Integer.parseInt(configuracion.getProperty("Panel.ancho")),
				Integer.parseInt(configuracion.getProperty("Panel.alto")));
		vf.getcW().getBtnCrear().setBounds(345, 270, Integer.parseInt(configuracion.getProperty("Boton.crud.ancho")),
				Integer.parseInt(configuracion.getProperty("Boton.crud.alto")));
		vf.getcW().getPanelFondo().add(vf.getcW().getBtnCrear());
//		vf.getcW().getBtnActualizar().setBounds(500, 273,
//				Integer.parseInt(configuracion.getProperty("Boton.crud.ancho")),
//				Integer.parseInt(configuracion.getProperty("Boton.crud.alto")));
//		vf.getcW().getPanelFondo().add(vf.getcW().getBtnActualizar());
//		vf.getcW().getBtnEliminar().setBounds(110, 445, Integer.parseInt(configuracion.getProperty("Boton.crud.ancho")),
//				Integer.parseInt(configuracion.getProperty("Boton.crud.alto")));
//		vf.getcW().getPanelFondo().add(vf.getcW().getBtnEliminar());
//		vf.getcW().getBtnMostrar().setBounds(500, 445, Integer.parseInt(configuracion.getProperty("Boton.crud.ancho")),
//				Integer.parseInt(configuracion.getProperty("Boton.crud.alto")));
//		vf.getcW().getPanelFondo().add(vf.getcW().getBtnMostrar());
		vf.getcW().getBtnExit().setBounds(600, 590, Integer.parseInt(configuracion.getProperty("Boton.ancho")),
				Integer.parseInt(configuracion.getProperty("Boton.alto")));
		vf.getcW().getPanelFondo().add(vf.getcW().getBtnExit());
		vf.getcW().getLblImagen().setBounds(0, 0, Integer.parseInt(configuracion.getProperty("Imagen.ancho")),
				Integer.parseInt(configuracion.getProperty("Imagen.alto")));
		vf.getcW().getPanelFondo().add(vf.getcW().getLblImagen());
	}

	public void cyclistCreateWindow() {
		Properties configuracion = FileHandler
				.cargarArchivoPropiedades("src/co/edu/unbosque/model/persistence/config.properties");
		vf.getcCFW().setSize(Integer.parseInt(configuracion.getProperty("Window.ancho")),
				Integer.parseInt(configuracion.getProperty("Window.alto")));
		vf.getcCFW().setLocationRelativeTo(null);
		vf.getcCFW().getPanelFondo().setBounds(0, 0, Integer.parseInt(configuracion.getProperty("Panel.ancho")),
				Integer.parseInt(configuracion.getProperty("Panel.alto")));
		vf.getcCFW().getBtnConfirmar().setBounds(430, 590, Integer.parseInt(configuracion.getProperty("Boton.ancho")),
				Integer.parseInt(configuracion.getProperty("Boton.alto")));
		vf.getcCFW().getPanelFondo().add(vf.getcCFW().getBtnConfirmar());
		vf.getcCFW().getBtnVolver().setBounds(600, 590, Integer.parseInt(configuracion.getProperty("Boton.ancho")),
				Integer.parseInt(configuracion.getProperty("Boton.alto")));
		vf.getcCFW().getPanelFondo().add(vf.getcCFW().getBtnVolver());
		vf.getcCFW().getLblImagen().setBounds(0, 0, Integer.parseInt(configuracion.getProperty("Imagen.ancho")),
				Integer.parseInt(configuracion.getProperty("Imagen.alto")));
		vf.getcCFW().getPanelFondo().add(vf.getcCFW().getLblImagen());
	}

	public void teamWindown() {
		Properties configuracion = FileHandler
				.cargarArchivoPropiedades("src/co/edu/unbosque/model/persistence/config.properties");
		vf.gettW().setSize(Integer.parseInt(configuracion.getProperty("Window.ancho")),
				Integer.parseInt(configuracion.getProperty("Window.alto")));
		vf.gettW().setLocationRelativeTo(null);
		vf.gettW().getPanelFondo().setBounds(0, 0, Integer.parseInt(configuracion.getProperty("Panel.ancho")),
				Integer.parseInt(configuracion.getProperty("Panel.alto")));
		vf.gettW().getBtnCrear().setBounds(113, 275, Integer.parseInt(configuracion.getProperty("Boton.crud.ancho")),
				Integer.parseInt(configuracion.getProperty("Boton.crud.alto")));
		vf.gettW().getPanelFondo().add(vf.gettW().getBtnCrear());
		vf.gettW().getBtnActualizar().setBounds(267, 275,
				Integer.parseInt(configuracion.getProperty("Boton.crud.ancho")),
				Integer.parseInt(configuracion.getProperty("Boton.crud.alto")));
		vf.gettW().getPanelFondo().add(vf.gettW().getBtnActualizar());
		vf.gettW().getBtnEliminar().setBounds(420, 275, Integer.parseInt(configuracion.getProperty("Boton.crud.ancho")),
				Integer.parseInt(configuracion.getProperty("Boton.crud.alto")));
		vf.gettW().getPanelFondo().add(vf.gettW().getBtnEliminar());
		vf.gettW().getBtnSimular().setBounds(570, 275, Integer.parseInt(configuracion.getProperty("Boton.crud.ancho")),
				Integer.parseInt(configuracion.getProperty("Boton.crud.alto")));
		vf.gettW().getPanelFondo().add(vf.gettW().getBtnSimular());
		vf.gettW().getBtnExit().setBounds(580, 580, Integer.parseInt(configuracion.getProperty("Boton.ancho")),
				Integer.parseInt(configuracion.getProperty("Boton.alto")));
		vf.gettW().getPanelFondo().add(vf.gettW().getBtnExit());
		vf.gettW().getLblImagen().setBounds(0, 0, Integer.parseInt(configuracion.getProperty("Imagen.ancho")),
				Integer.parseInt(configuracion.getProperty("Imagen.alto")));
		vf.gettW().getPanelFondo().add(vf.gettW().getLblImagen());

	}

	public void cyclistUpdateWindow() {
		Properties configuracion = FileHandler
				.cargarArchivoPropiedades("src/co/edu/unbosque/model/persistence/config.properties");
		vf.getcUW().setSize(Integer.parseInt(configuracion.getProperty("Window.ancho")),
				Integer.parseInt(configuracion.getProperty("Window.alto")));
		vf.getcUW().setLocationRelativeTo(null);
		vf.getcUW().getPanelFondo().setBounds(0, 0, Integer.parseInt(configuracion.getProperty("Panel.ancho")),
				Integer.parseInt(configuracion.getProperty("Panel.alto")));
		vf.getcUW().getBtnConfirmar().setBounds(430, 610, Integer.parseInt(configuracion.getProperty("Boton.ancho")),
				Integer.parseInt(configuracion.getProperty("Boton.alto")));
		vf.getcUW().getPanelFondo().add(vf.getcUW().getBtnConfirmar());
		vf.getcUW().getBtnVolver().setBounds(600, 610, Integer.parseInt(configuracion.getProperty("Boton.ancho")),
				Integer.parseInt(configuracion.getProperty("Boton.alto")));
		vf.getcUW().getPanelFondo().add(vf.getcUW().getBtnVolver());
		vf.getcUW().getLblImagen().setBounds(0, 0, Integer.parseInt(configuracion.getProperty("Imagen.ancho")),
				Integer.parseInt(configuracion.getProperty("Imagen.alto")));
		vf.getcUW().getPanelFondo().add(vf.getcUW().getLblImagen());
	}



	public void cyclistDeleteWindow() {
		Properties configuracion = FileHandler
				.cargarArchivoPropiedades("src/co/edu/unbosque/model/persistence/config.properties");
		vf.getcDW().setSize(Integer.parseInt(configuracion.getProperty("Window.ancho")),
				Integer.parseInt(configuracion.getProperty("Window.alto")));
		vf.getcDW().setLocationRelativeTo(null);
		vf.getcDW().getPanelFondo().setBounds(0, 0, Integer.parseInt(configuracion.getProperty("Panel.ancho")),
				Integer.parseInt(configuracion.getProperty("Panel.alto")));
		vf.getcDW().getBtnConfirmar().setBounds(430, 580, Integer.parseInt(configuracion.getProperty("Boton.ancho")),
				Integer.parseInt(configuracion.getProperty("Boton.alto")));
		vf.getcDW().getPanelFondo().add(vf.getcDW().getBtnConfirmar());
		vf.getcDW().getBtnVolver().setBounds(600, 580, Integer.parseInt(configuracion.getProperty("Boton.ancho")),
				Integer.parseInt(configuracion.getProperty("Boton.alto")));
		vf.getcDW().getPanelFondo().add(vf.getcDW().getBtnVolver());
		vf.getcDW().getLblImagen().setBounds(0, 0, Integer.parseInt(configuracion.getProperty("Imagen.ancho")),
				Integer.parseInt(configuracion.getProperty("Imagen.alto")));
		vf.getcDW().getPanelFondo().add(vf.getcDW().getLblImagen());

	}

	public void cyclistShowAllWindow() {
		Properties configuracion = FileHandler
				.cargarArchivoPropiedades("src/co/edu/unbosque/model/persistence/config.properties");
		vf.getcSAW().setSize(Integer.parseInt(configuracion.getProperty("Window.ancho")),
				Integer.parseInt(configuracion.getProperty("Window.alto")));
		vf.getcSAW().setLocationRelativeTo(null);
		vf.getcSAW().getPanelFondo().setBounds(0, 0, Integer.parseInt(configuracion.getProperty("Panel.ancho")),
				Integer.parseInt(configuracion.getProperty("Panel.alto")));
		vf.getcSAW().getBtnVolver().setBounds(600, 580, Integer.parseInt(configuracion.getProperty("Boton.ancho")),
				Integer.parseInt(configuracion.getProperty("Boton.alto")));
		vf.getcSAW().getPanelFondo().add(vf.getcSAW().getBtnVolver());
		vf.getcSAW().getLblImagen().setBounds(0, 0, Integer.parseInt(configuracion.getProperty("Imagen.ancho")),
				Integer.parseInt(configuracion.getProperty("Imagen.alto")));
		vf.getcSAW().getPanelFondo().add(vf.getcSAW().getLblImagen());

	}
	public void teamShowAllWindow() {
		Properties configuracion = FileHandler
				.cargarArchivoPropiedades("src/co/edu/unbosque/model/persistence/config.properties");
		vf.gettSAW().setSize(Integer.parseInt(configuracion.getProperty("Window.ancho")),
				Integer.parseInt(configuracion.getProperty("Window.alto")));
		vf.gettSAW().setLocationRelativeTo(null);
		vf.gettSAW().getPanelFondo().setBounds(0, 0, Integer.parseInt(configuracion.getProperty("Panel.ancho")),
				Integer.parseInt(configuracion.getProperty("Panel.alto")));
		vf.gettSAW().getBtnVolver().setBounds(600, 580, Integer.parseInt(configuracion.getProperty("Boton.ancho")),
				Integer.parseInt(configuracion.getProperty("Boton.alto")));
		vf.gettSAW().getPanelFondo().add(vf.gettSAW().getBtnVolver());
		vf.gettSAW().getLblImagen().setBounds(0, 0, Integer.parseInt(configuracion.getProperty("Imagen.ancho")),
				Integer.parseInt(configuracion.getProperty("Imagen.alto")));
		vf.gettSAW().getPanelFondo().add(vf.gettSAW().getLblImagen());

	}

	public void adminSearchWindow() {
		Properties configuracion = FileHandler
				.cargarArchivoPropiedades("src/co/edu/unbosque/model/persistence/config.properties");
		vf.getaSW().setSize(Integer.parseInt(configuracion.getProperty("Window.ancho")),
				Integer.parseInt(configuracion.getProperty("Window.alto")));
		vf.getaSW().setLocationRelativeTo(null);
		vf.getaSW().getPanelFondo().setBounds(0, 0, Integer.parseInt(configuracion.getProperty("Panel.ancho")),
				Integer.parseInt(configuracion.getProperty("Panel.alto")));
		vf.getaSW().getBtnConfirmar().setBounds(430, 580, Integer.parseInt(configuracion.getProperty("Boton.ancho")),
				Integer.parseInt(configuracion.getProperty("Boton.alto")));
		vf.getaSW().getPanelFondo().add(vf.getaSW().getBtnConfirmar());
		vf.getaSW().getBtnVolver().setBounds(600, 580, Integer.parseInt(configuracion.getProperty("Boton.ancho")),
				Integer.parseInt(configuracion.getProperty("Boton.alto")));
		vf.getaSW().getPanelFondo().add(vf.getaSW().getBtnVolver());
		vf.getaSW().getLblImagen().setBounds(0, 0, Integer.parseInt(configuracion.getProperty("Imagen.ancho")),
				Integer.parseInt(configuracion.getProperty("Imagen.alto")));
		vf.getaSW().getPanelFondo().add(vf.getaSW().getLblImagen());

	}
	public void mainVideoWindow() {
		Properties configuracion = FileHandler
				.cargarArchivoPropiedades("src/co/edu/unbosque/model/persistence/config.properties");
		vf.getmVW().setSize(Integer.parseInt(configuracion.getProperty("Window.ancho")),
				Integer.parseInt(configuracion.getProperty("Window.alto")));
		vf.getmVW().setLocationRelativeTo(null);
		vf.getmVW().getPanelFondo().setBounds(0, 0, Integer.parseInt(configuracion.getProperty("Panel.ancho")),
				Integer.parseInt(configuracion.getProperty("Panel.alto")));
		vf.getmVW().getBtnInicioSesion().setBounds(325, 260, Integer.parseInt(configuracion.getProperty("Boton.ancho")),
				Integer.parseInt(configuracion.getProperty("Boton.alto")));
		vf.getmVW().getBtnTutorial().setBounds(325, 340, Integer.parseInt(configuracion.getProperty("Boton.ancho")),
				Integer.parseInt(configuracion.getProperty("Boton.alto")));
		vf.getmVW().getBtnSalir().setBounds(325, 410, Integer.parseInt(configuracion.getProperty("Boton.ancho")),
				Integer.parseInt(configuracion.getProperty("Boton.alto")));
		vf.getmVW().getLblImagen().setBounds(0, 0, Integer.parseInt(configuracion.getProperty("Imagen.ancho")),
				Integer.parseInt(configuracion.getProperty("Imagen.alto")));
		vf.getmVW().getPanelFondo().add(vf.getmVW().getBtnInicioSesion());
		vf.getmVW().getPanelFondo().add(vf.getmVW().getBtnTutorial());
		vf.getmVW().getPanelFondo().add(vf.getmVW().getBtnSalir());
		vf.getmVW().getPanelFondo().add(vf.getmVW().getLblImagen());
		vf.getmVW().setVisible(true);

	}


	public void agregarTablaDirector() {

		ArrayList<SportsDirectorDTO> lista = mf.getDirectorDAO().getListDirectors();
		int totalFilas = lista.size();
		String[][] datos = new String[totalFilas][8];

		for (int i = 0; i < totalFilas; i++) {
			SportsDirectorDTO director = lista.get(i);

			datos[i][0] = Long.toString(director.getID());
			datos[i][1] = director.getName();
			datos[i][2] = director.getMail();
			datos[i][3] = Long.toString(director.getIdentificationCard());
			datos[i][4] = director.getGender();
			datos[i][5] = director.getNationality();
			datos[i][6] = director.getEquipmentHistory();
			datos[i][7] = Integer.toString(director.getExperienceAge());

		}
		vf.getdSAW().setFil(datos.length);
		vf.getdSAW().setDatos(datos);
		vf.getdSAW().actualizarTabla();
	}
	
	
	
	
	private String[][] combineData(String[][] data1, String[][] data2, String[][] data3) {
		

		
	    int totalRows = data1.length + data2.length + data3.length;
	    int totalCols = data1[0].length;
	    String[][] combinedData = new String[totalRows][totalCols];

	    int index = 0;
	    for (int i = 0; i < data1.length; i++) {
	        System.arraycopy(data1[i], 0, combinedData[index], 0, totalCols);
	        index++;
	    }
	    for (int i = 0; i < data2.length; i++) {
	        System.arraycopy(data2[i], 0, combinedData[index], 0, totalCols);
	        index++;
	    }
	    for (int i = 0; i < data3.length; i++) {
	        System.arraycopy(data3[i], 0, combinedData[index], 0, totalCols);
	        index++;
	    }

	    return combinedData;
	}
	
	
	
	
	
	public void agregarTablaEquipo() {

	    ArrayList<TeamDTO> lista = mf.getEquipoDAO().getListaEquipos();
	    ArrayList<CyclistDTO> lista2 = mf.getCiclistaDAO().getListCyclists();
	    ArrayList<MassageTherapistDTO> lista3 = mf.getMasajistaDAO().getListMasseurs();
	    ArrayList<SportsDirectorDTO> lista4 = mf.getDirectorDAO().getListDirectors();

	    int totalFilas2 = lista2.size();
	    int totalFilas = lista.size();
	    int totalFilas3 = lista3.size();
	    int totalFilas4 = lista4.size();
	    String[][] datos1 = new String[totalFilas][8];
	    String[][] datos2 = new String[totalFilas][8];
	    String[][] datos3 = new String[totalFilas][8];

	    for (int i = 0; i < totalFilas; i++) {
	        TeamDTO equipo = lista.get(i);
	        CyclistDTO ciclista = lista2.get(i);
	        MassageTherapistDTO masajista = lista3.get(i);
	        SportsDirectorDTO director = lista4.get(i);
	        
	        
	        

	        datos1[i][0] = Long.toString(ciclista.getID());
	        datos1[i][1] = equipo.getTeamName();
	        datos1[i][2] = equipo.getCountry();
	        datos1[i][3] = ciclista.getName();
	        datos1[i][4] = ciclista.getSpeciality();
	        
	        
	        

	        datos2[i][0] = Long.toString(masajista.getID());
	        datos2[i][1] = equipo.getTeamName();
	        datos2[i][2] = equipo.getCountry();
	        datos2[i][3] = masajista.getName();
	        datos2[i][4] = masajista.getSpeciality();
	        

	        datos3[i][0] = Long.toString(director.getID());
	        datos3[i][1] = equipo.getTeamName();
	        datos3[i][2] = equipo.getCountry();
	        datos3[i][3] = director.getName();
	        datos3[i][4] = director.getEquipmentHistory();
	       
	    }

	    String[][] combinedData = combineData(datos1, datos2, datos3);

	    vf.gettSAW().setFil(combinedData.length);
	    vf.gettSAW().setDatos(combinedData);
	    vf.gettSAW().actualizarTabla();
	}
	

//	public void agregarTablaEquipo() {
//
//		ArrayList<TeamDTO> lista = mf.getEquipoDAO().getListaEquipos();
//		ArrayList<CyclistDTO> lista2 = mf.getCiclistaDAO().getListCyclists();
//		ArrayList<MassageTherapistDTO> lista3 = mf.getMasajistaDAO().getListMasseurs();
//		
//		int totalFilas = lista.size();
//		String[][] datos = new String[totalFilas][8];
//		
//		for (int i = 0; i < totalFilas; i++) {
//			TeamDTO equipo = lista.get(i);
//			CyclistDTO ciclista = lista2.get(i);
//			
//			datos[i][0] = Long.toString(ciclista.getID());
//			datos[i][1] = equipo.getTeamName();
//			datos[i][2] = equipo.getCountry();
//			datos[i][3] = ciclista.getName();
//		}
//		vf.gettSAW().setFil(datos.length);
//		vf.gettSAW().setDatos(datos);
//		vf.gettSAW().actualizarTabla();
//	}
	public void agregarTablaEquipoMasajista() {

		ArrayList<TeamDTO> lista = mf.getEquipoDAO().getListaEquipos();
		ArrayList<MassageTherapistDTO> lista3 = mf.getMasajistaDAO().getListMasseurs();
		int totalFilas = lista.size();
		String[][] datos = new String[totalFilas][8];
		
		for (int i = 0; i < totalFilas; i++) {
			TeamDTO equipo = lista.get(i);
			MassageTherapistDTO masajista = lista3.get(i);
			
			datos[i][0] = Long.toString(masajista.getID());
			datos[i][1] = equipo.getTeamName();
			datos[i][2] = equipo.getCountry();
			datos[i][3] = masajista.getName();
		}
		vf.gettSAW().setFil(datos.length);
		vf.gettSAW().setDatos(datos);
		vf.gettSAW().actualizarTabla();
	}
	public void agregarTablaEquipoDirector() {

		ArrayList<TeamDTO> lista = mf.getEquipoDAO().getListaEquipos();
		ArrayList<SportsDirectorDTO> lista4 = mf.getDirectorDAO().getListDirectors();
		int totalFilas = lista.size();
		String[][] datos = new String[totalFilas][8];
		
		for (int i = 0; i < totalFilas; i++) {
			TeamDTO equipo = lista.get(i);
			SportsDirectorDTO directores = lista4.get(i);
			
			datos[i][0] = Long.toString(directores.getID());
			datos[i][1] = equipo.getTeamName();
			datos[i][2] = equipo.getCountry();
			datos[i][3] = directores.getName();
		}
		vf.gettSAW().setFil(datos.length);
		vf.gettSAW().setDatos(datos);
		vf.gettSAW().actualizarTabla();
	}

	public void agregarTablaMasajista() {

		ArrayList<MassageTherapistDTO> lista = mf.getMasajistaDAO().getListMasseurs();
		int totalFilas = lista.size();
		String[][] datos = new String[totalFilas][8];

		for (int i = 0; i < totalFilas; i++) {
			MassageTherapistDTO masajista = lista.get(i);

			datos[i][0] = Long.toString(masajista.getID());
			datos[i][1] = masajista.getName();
			datos[i][2] = masajista.getMail();
			datos[i][3] = Long.toString(masajista.getIdentificationCard());
			datos[i][4] = masajista.getGender();
			datos[i][5] = masajista.getSpeciality();
			datos[i][6] = Integer.toString(masajista.getExperienceAge());

		}
		vf.getmSAW().setFil(datos.length);
		vf.getmSAW().setDatos(datos);
		vf.getmSAW().actualizarTabla();
	}

	public void agregarTablaCiclista() {

		ArrayList<CyclistDTO> lista = mf.getCiclistaDAO().getListCyclists();
		int totalFilas = lista.size();
		String[][] datos = new String[totalFilas][10];

		for (int i = 0; i < totalFilas; i++) {
			CyclistDTO ciclista = lista.get(i);

			datos[i][0] = Long.toString(ciclista.getID());
			datos[i][1] = ciclista.getName();
			datos[i][2] = ciclista.getMail();
			datos[i][3] = Long.toString(ciclista.getIdentificationCard());
			datos[i][4] = ciclista.getGender();
			datos[i][5] = Integer.toString(ciclista.getRaceTime());
			datos[i][6] = ciclista.getSpeciality();
			datos[i][7] = Integer.toString(ciclista.getPedalingCadence());
			datos[i][8] = Float.toString(ciclista.getHeight());
			datos[i][9] = Float.toString(ciclista.getWeight());

		}
		vf.getcSAW().setFil(datos.length);
		vf.getcSAW().setDatos(datos);
		vf.getcSAW().actualizarTabla();
	}

	public void showViewCyclistFromList() {
		for (CyclistDTO ciclista : mf.getCiclistaDAO().getListCyclists()) {
			vf.getoTW().getJComboBox()
					.addItem(ciclista.getSpeciality() + " - " + ciclista.getID() + " - " + ciclista.getName());
		}

		// Add a JComboBox listener to get the selected index

	}

	public void showViewDirectorFromList() {
//		vf.getoTW().getJComboBox().addItem("Format is: Speciality - ID - Name ");
//		vf.getoTW().getJComboBox().addItem("-----------SELECT YOUR CYCLIST-----------");
		for (SportsDirectorDTO director : mf.getDirectorDAO().getListDirectors()) {

			vf.getoTW().getJComboBox3().addItem(director.getID() + " - " + director.getName());
		}

	}

	public void showViewMassageFromList() {
//		vf.getoTW().getJComboBox().addItem("Format is: Speciality - ID - Name ");
//		vf.getoTW().getJComboBox().addItem("-----------SELECT YOUR CYCLIST-----------");
		for (MassageTherapistDTO massage : mf.getMasajistaDAO().getListMasseurs()) {

			vf.getoTW().getJComboBox2().addItem(massage.getID() + " - " + massage.getName());
		}

	}

	// iD, nombre, correo, cardIdentificacion, selectedItem, null, tiempoCarrera,
	// tipoCiclista, cadenciaPedaleo, peso, altura

//		ArrayList<SportsDirectorDTO> lista = mf.getDirectorDAO().getListDirectors();
//		int i = 0;
//		String[][] datos = new String[lista.size()][8]; 
//		
//			for (SportsDirectorDTO director : lista) {
//				
//			
//				datos[i] = {Long.toString(director.getID()) , director.getName(), director.getMail(),
//					Long.toString(director.getIdentificationCard())	, director.getGender(), director.getNationality(),
//						director.getEquipmentHistory(), Integer.toString(director.getExperienceAge())  };
//			}

//		DefaultTableModel modeloTabla = vf.getdSAW().getT_lista();
//		while (modeloTabla.getRowCount() > 0) {
//			modeloTabla.removeRow(0);
//		}
//		for (SportsDirectorDTO director : mf.getDirectorDAO().getListDirectors()) {

//		}

	public void assignClick() {
		
		

		// MAIL WINDOW
		vf.getwM().getBtnEnviar().addActionListener(this);

		// MAIN WINDOW
		vf.getmW().getBtnInicioSesion().addActionListener(this);
		vf.getmW().getBtnSalir().addActionListener(this);
		vf.getmW().getBtnRegistro().addActionListener(this);
		vf.getmW().getBtnAdmin().addActionListener(this);

		// LOGIN WINDOW
		vf.getlW().getBtnIniciarSesion().addActionListener(this);
		vf.getlW().getBtnVolver().addActionListener(this);

		// SIGN IN WINDOW
		vf.getsIW().getBtnConfirmar().addActionListener(this);
		vf.getsIW().getBtnVolver().addActionListener(this);

		// OPTION WINDOW
		vf.getoW().getBtnCiclista().addActionListener(this);
		vf.getoW().getBtnMasajista().addActionListener(this);
		vf.getoW().getBtnDirector().addActionListener(this);
		vf.getoW().getBtnAdmin().addActionListener(this);
		vf.getoW().getBtnVolver().addActionListener(this);

		// CYCLIST WINDOW
		vf.getcW().getBtnCrear().addActionListener(this);
		vf.getcW().getBtnExit().addActionListener(this);

		// CYCLIST WINDOW LOGIN
		vf.getcWL().getBtnActualizar().addActionListener(this);
		vf.getcWL().getBtnEliminar().addActionListener(this);
		vf.getcWL().getBtnMostrar().addActionListener(this);
		vf.getcWL().getBtnExit().addActionListener(this);

		// CYCLIST CREATE WINDOW
		vf.getcCFW().getBtnConfirmar().addActionListener(this);
		vf.getcCFW().getBtnVolver().addActionListener(this);

		// CYCLIST UPDATE WINDOW
		vf.getcUW().getBtnConfirmar().addActionListener(this);
		vf.getcUW().getBtnVolver().addActionListener(this);

		// CYCLIST DELETE WINDOW
		vf.getcDW().getBtnConfirmar().addActionListener(this);
		vf.getcDW().getBtnVolver().addActionListener(this);

		// CYCLIST SHOW ALL WINDOW
		vf.getcSAW().getBtnVolver().addActionListener(this);

		// ADMIN WINDOW
//		vf.getaW().getBtnBuscar().addActionListener(this);
//		vf.getaW().getBtnEliminar().addActionListener(this);
//		vf.getaW().getBtnPDF().addActionListener(this);
//		vf.getaW().getBtnExit().addActionListener(this);
//		vf.getcCreateW().getBtnRegresar().addActionListener(this);

		// DIRECTOR WINDOW
		vf.getdW().getBtnCrear().addActionListener(this);
		vf.getdW().getBtnExit().addActionListener(this);

		// DIRECTOR WINDOW LOGIN
		vf.getdWL().getBtnActualizar().addActionListener(this);
		vf.getdWL().getBtnEliminar().addActionListener(this);
		vf.getdWL().getBtnExit().addActionListener(this);
		vf.getdWL().getBtnMostrar().addActionListener(this);

		// DIRECTOR CREATE WINDOW
		vf.getdCW().getBtnConfirmar().addActionListener(this);
		vf.getdCW().getBtnVolver().addActionListener(this);

		// DIRECTOR UPDATE WINDOW
		vf.getdUW().getBtnConfirmar().addActionListener(this);
		vf.getdUW().getBtnVolver().addActionListener(this);

		// DIRECTOR DELETE WINDOW
		vf.getdDW().getBtnConfirmar().addActionListener(this);
		vf.getdDW().getBtnVolver().addActionListener(this);

		// DIRECTOR SHOW ALL WINDOW
		vf.getdSAW().getBtnVolver().addActionListener(this);

		// MAUSSEUSE WINDOW
		vf.getMaW().getBtnCrear().addActionListener(this);
		vf.getMaW().getBtnVolver().addActionListener(this);

		// MAUSSEUSE WINDOW LOGIN
		vf.getmWL().getBtnActualizar().addActionListener(this);
		vf.getmWL().getBtnEliminar().addActionListener(this);
		vf.getmWL().getBtnVolver().addActionListener(this);
		vf.getmWL().getBtnMostrar().addActionListener(this);

		// MAUSSEUSE CREATE WINDOW
		vf.getmCW().getBtnConfirmar().addActionListener(this);
		vf.getmCW().getBtnVolver().addActionListener(this);

		// MAUSSEUSE UPDATE WINDOW
		vf.getmUW().getBtnConfirmar().addActionListener(this);
		vf.getmUW().getBtnVolver().addActionListener(this);

		// MAUSSEUSE DELETE WINDOW
		vf.getmDW().getBtnConfirmar().addActionListener(this);
		vf.getmDW().getBtnVolver().addActionListener(this);

		// MAUSSEUSE SHOW ALL WINDOW
		vf.getmSAW().getBtnVolver().addActionListener(this);

		// ADMIN WINDOW
		vf.getaSW().getBtnConfirmar().addActionListener(this);
		vf.getaSW().getBtnVolver().addActionListener(this);

		// TODO LO QUE TENCA QUE VER CON VENTANA EQUIPO

		// TEAM WINDOW

		vf.gettW().getBtnCrear().addActionListener(this);
		vf.gettW().getBtnActualizar().addActionListener(this);
		vf.gettW().getBtnEliminar().addActionListener(this);
		vf.gettW().getBtnExit().addActionListener(this);
		vf.gettW().getBtnMostrar().addActionListener(this);
		vf.gettW().getBtnSimular().addActionListener(this);

		// OPTION TEAM WINDOWN
		vf.getoTW().getBtnConfirmar().addActionListener(this);
		vf.getoTW().getBtnVolver().addActionListener(this);

		// TEAM DELETE WINDOW
		vf.gettDW().getBtnConfirmar().addActionListener(this);
		vf.gettDW().getBtnVolver().addActionListener(this);

		// TEAM UPDATE DIRECTOR
		vf.gettUW().getBtnConfirmar().addActionListener(this);
		vf.gettUW().getBtnVolver().addActionListener(this);
		
		// TEAM SHOW ALL WINDOW
		vf.gettSAW().getBtnVolver().addActionListener(this);
		
		//SIMULATION
		teamSim.getBtnVolver().addActionListener(this);
		teamSim.getBtnStart().addActionListener(this);
		teamSim.getBtnSeleccion().addActionListener(this);
		teamSim.getBtnDeseleccion().addActionListener(this);
		typeSim.getBtnExit().addActionListener(this);
		typeSim.getbtnFWCurves().addActionListener(this);
		typeSim.getbtnSingleDay().addActionListener(this);
		typeSim.getbtnFlatStraight().addActionListener(this);
		typeSim.getbtnMountain().addActionListener(this);
		typeSim.getbtnSemiFlat().addActionListener(this);
		
		// MAIN VIDEO WINDOW
		vf.getmVW().getBtnInicioSesion().addActionListener(this);
		vf.getmVW().getBtnSalir().addActionListener(this);
		vf.getmVW().getBtnTutorial().addActionListener(this);
		
	}

	public void assignFunction() {
		
		// MAIN VIDEO WINDOW
		vf.getmVW().getBtnInicioSesion().setActionCommand("Iniciar Sesion Video");
		vf.getmVW().getBtnTutorial().setActionCommand("Tutorial Video");
		vf.getmVW().getBtnSalir().setActionCommand("Salir Ventana Principal Video");

		// MAIN WINDOW
		vf.getmW().getBtnInicioSesion().setActionCommand("Iniciar Sesion");
		vf.getmW().getBtnRegistro().setActionCommand("Registro");
		vf.getmW().getBtnAdmin().setActionCommand("Admin Enter");
		vf.getmW().getBtnSalir().setActionCommand("Salir Ventana Principal");

		// LOGIN WINDOW
		vf.getlW().getBtnIniciarSesion().setActionCommand("Confirmar Inicio Sesion");
		vf.getlW().getBtnVolver().setActionCommand("Volver Inicio Sesion");

		// SIGN IN WINDOW
		vf.getsIW().getBtnConfirmar().setActionCommand("Confirmar Registrarse");
		vf.getsIW().getBtnVolver().setActionCommand("Volver Registrarse");

		// OPTION WINDOW
		vf.getoW().getBtnCiclista().setActionCommand("Ciclista");
		vf.getoW().getBtnMasajista().setActionCommand("Masajista");
		vf.getoW().getBtnDirector().setActionCommand("Director");
		vf.getoW().getBtnAdmin().setActionCommand("Team");
		vf.getoW().getBtnVolver().setActionCommand("Volver Opciones");

		// MAUSSEUSE WINDOW
		vf.getMaW().getBtnCrear().setActionCommand("Crear Masajista");
		vf.getMaW().getBtnVolver().setActionCommand("Regresar Masajista");

		// MAUSSEUSE WINDOW LOGIN
		vf.getmWL().getBtnActualizar().setActionCommand("Actualizar Masajista");
		vf.getmWL().getBtnEliminar().setActionCommand("Eliminar Masajista");
		vf.getmWL().getBtnMostrar().setActionCommand("Mostrar Masajista");
		vf.getmWL().getBtnVolver().setActionCommand("Cerrar Masajista");

		// MAUSSEUSE CREATE WINDOW
		vf.getmCW().getBtnConfirmar().setActionCommand("btnConfirmarCrearMasajista");
		vf.getmCW().getBtnVolver().setActionCommand("btnVolverCrearMasajista");

		// MAUSSEUSE UPDATE WINDOW
		vf.getmUW().getBtnConfirmar().setActionCommand("btn Confirmar Update Masajista");
		vf.getmUW().getBtnVolver().setActionCommand("btn Volver Update Masajista");

		// MAUSSEUSE DELETE WINDOW
		vf.getmDW().getBtnConfirmar().setActionCommand("btn Confirmar Delete Masajista");
		vf.getmDW().getBtnVolver().setActionCommand("btn Volver Delete Masajista");

		// MAUSSEUSE SHOW ALL WINDOW
		vf.getmSAW().getBtnVolver().setActionCommand("btn Volver Show All Masajistas");

		// CYCLIST WINDOW
		vf.getcW().getBtnCrear().setActionCommand("btn Create Cyclist");
		vf.getcW().getBtnExit().setActionCommand("btn Go Back Cyclist");

		// CYCLIST WINDOW LOGIN
		vf.getcWL().getBtnActualizar().setActionCommand("btn Update Cyclist");
		vf.getcWL().getBtnEliminar().setActionCommand("btn Delete Cyclist");
		vf.getcWL().getBtnExit().setActionCommand("Close Cyclist");
		vf.getcWL().getBtnMostrar().setActionCommand("btn Show All Cyclist");

		// CYCLIST CREATE WINDOW
		vf.getcCFW().getBtnConfirmar().setActionCommand("btn Create Create Cyclist");
		vf.getcCFW().getBtnVolver().setActionCommand("btn Go Back Create Cyclist");

		// CYCLIST UPDATE WINDOW
		vf.getcUW().getBtnConfirmar().setActionCommand("btn Update Update Cyclist");
		vf.getcUW().getBtnVolver().setActionCommand("btn Go Back Update Cyclist");

		// CYCLIST DELETE WINDOW
		vf.getcDW().getBtnConfirmar().setActionCommand("btn Delete Delete Cyclist");
		vf.getcDW().getBtnVolver().setActionCommand("btn Go Back Delete Cyclist");

		// CYCLIST SHOW ALL WINDOW
		vf.getcSAW().getBtnVolver().setActionCommand("btn Go Back Show All Cyclist");

		// ADMIN WINDOW
//		vf.getaW().getBtnExit().setActionCommand("btn Go Back Admin");

		// DIRECTOR WINDOW
		vf.getdW().getBtnCrear().setActionCommand("Crear Director");
		vf.getdW().getBtnExit().setActionCommand("Regresar Director");

		// DIRECTOR WINDOW LOGIN
		vf.getdWL().getBtnActualizar().setActionCommand("Actualizar Director");
		vf.getdWL().getBtnEliminar().setActionCommand("Eliminar Director");
		vf.getdWL().getBtnExit().setActionCommand("Close Director");
		vf.getdWL().getBtnMostrar().setActionCommand("Mostrar Director");

		// DIRECTOR CREATE WINDOW
		vf.getdCW().getBtnConfirmar().setActionCommand("btn Confirmar Crear Director");
		vf.getdCW().getBtnVolver().setActionCommand("btn Volver Crear Director");

		// DIRECTOR UPDATE WINDOW
		vf.getdUW().getBtnConfirmar().setActionCommand("btn Confirmar Update Director");
		vf.getdUW().getBtnVolver().setActionCommand("btn Volver Update Director");

		// DIRECTOR DELETE WINDOW
		vf.getdDW().getBtnConfirmar().setActionCommand("btn Confirmar Delete Director");
		vf.getdDW().getBtnVolver().setActionCommand("btn Volver Delete Director");

		// DIRECTOR SHOW ALL WINDOW
		vf.getdSAW().getBtnVolver().setActionCommand("btn Volver Show All Directors");

		// MAIL WINDOW
		vf.getwM().getBtnEnviar().setActionCommand("Enviar");

		// ADMIN SEARCH WINDOW
		vf.getaSW().getBtnConfirmar().setActionCommand("Done Admin");
		vf.getaSW().getBtnVolver().setActionCommand("Volver Admin");


		// TODO LO QUE TENCA QUE VER CON VENTANA EQUIPO

		// OPTION TEAM WINDOWN
		vf.getoTW().getBtnConfirmar().setActionCommand("btn confirmar team");
		vf.getoTW().getBtnVolver().setActionCommand("btn volver team windown");

		// TEAM WINDOW
		vf.gettW().getBtnCrear().setActionCommand("btn Create Team");
		vf.gettW().getBtnActualizar().setActionCommand("btn Update team");
		vf.gettW().getBtnEliminar().setActionCommand("btn Delete Team");
		vf.gettW().getBtnExit().setActionCommand("btn Go Back Team");
		vf.gettW().getBtnMostrar().setActionCommand("btn show Team");
		vf.gettW().getBtnSimular().setActionCommand("btn Simular");

		// TEAM DELETE WINDOW
		vf.gettDW().getBtnConfirmar().setActionCommand("btn Confirmar Delete Team");
		vf.gettDW().getBtnVolver().setActionCommand("btn Volver Delete Team");

		// TEAM UPDATE WINDOW
		vf.gettUW().getBtnConfirmar().setActionCommand("btn Confirmar Update Team");
		vf.gettUW().getBtnVolver().setActionCommand("btn Volver Update Team");
		
		// TEAM SHOW ALL WINDOW
		vf.gettSAW().getBtnVolver().setActionCommand("btn Volver Show All Teams");
		
		//SIMULATION
		teamSim.getBtnVolver().setActionCommand("btn Volver Simulacion");
		teamSim.getBtnStart().setActionCommand("btn Start Simulacion");
		teamSim.getBtnSeleccion().setActionCommand("btn Seleccion Simulacion");
		teamSim.getBtnDeseleccion().setActionCommand("btn Deseleccion Simulacion");
		typeSim.getBtnExit().setActionCommand("btn Exit Type");
		typeSim.getbtnFWCurves().setActionCommand("btn FW");
		typeSim.getbtnSingleDay().setActionCommand("btn SD");
		typeSim.getbtnFlatStraight().setActionCommand("btn FS");
		typeSim.getbtnMountain().setActionCommand("btn M");
		typeSim.getbtnSemiFlat().setActionCommand("btn SF");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		
		case "Admin Enter":
			mainWindow();
			vf.getmW().setVisible(false);
			adminSearchWindow();
			vf.getaSW().setVisible(true);
			break;
		
		case "Done Admin":
			
			long iDA = Long.parseLong(vf.getaSW().getTxtDocumento().getText());
			
			String nombreA = vf.getaSW().getTxtNombre().getText();
			
			String correoA = vf.getaSW().getTxtCorreo().getText();
			String tipoCiclista23 = "";
			String selectedItem23 = (String) vf.getaSW().getjComboBox3().getSelectedItem();
			if (selectedItem23 != null) {
				tipoCiclista23 = selectedItem23;
			}
			mf.getAdminDAO().create(new AdminDTO(nombreA, correoA, iDA));
			
			vf.getaSW().getTxtDocumento().setText("");
			vf.getaSW().getTxtNombre().setText("");
			vf.getaSW().getjComboBox3().setSelectedItem(-1);
			
			createMail("Registro ISUSCI", correoA,
					"<html><body>" + "Bienvenido " + nombreA + " a ISUSCI<br>"
							+ "Usted es tipo Admin<br>" + "Su usuario es: "
							+ iDA + "<br>" + "Su contraseña es: " + iDA + "<br>"
							+ "Su usuario y contraseña es de uso personal e intrasferible.<br>"
							+ "Gracias por usar nuestro aplicativo<br>" + "</body></html>");
			sendMail();
			
			
			JOptionPane.showMessageDialog(vf.getaSW(),
					"Data to Overwrite: " + "\n" + mf.getAdminDAO().readOnly());
			
			
			break;
			
		case "Volver Admin":
			adminSearchWindow();
			vf.getaSW().setVisible(false);
			mainWindow();
			vf.getmW().setVisible(true);
			break;	
		
		case "Iniciar Sesion Video":
			mainVideoWindow();
			vf.getmVW().setVisible(false);
			mainWindow();
			vf.getmW().setVisible(true);

			break;

		case "Tutorial Video":
			try {
				File file = new File("Video/tutorial.mkv");
				if (Desktop.isDesktopSupported()) {
					Desktop desktop = Desktop.getDesktop();
					if (desktop.isSupported(Desktop.Action.OPEN)) {
						desktop.open(file);
					}
				}
			} catch (Exception e2) {
				e2.getMessage();
			}
			break;

		case "Salir Ventana Principal Video":
			System.exit(0);
			break;

		// TODO LO QUE TENGA QUE VER CON TEAM

		case "btn volver team windown":

			optionTeamWindow();
			vf.getoTW().setVisible(false);
			teamWindown();
			vf.gettW().setVisible(true);

			break;

		case "Team":
			optionWindow();
			vf.getoW().setVisible(false);
			teamWindown();
			vf.gettW().setVisible(true);

			break;

		case "btn Update team":

			showViewMassageFromList();
			showViewDirectorFromList();
			showViewCyclistFromList();
			teamWindown();
			vf.gettW().setVisible(false);
			teamUpdateWindow();
			vf.gettUW().setVisible(true);

			break;

		case "btn Create Team":
			showViewMassageFromList();
			showViewDirectorFromList();
			showViewCyclistFromList();
			teamWindown();
			vf.gettW().setVisible(false);
			optionTeamWindow();
			vf.getoTW().setVisible(true);

			break;

		case "btn confirmar team":
			try {
				

				verifyFieldWhiteName(vf.getoTW().getTxtNombre().getText());
				String teamName = vf.getoTW().getTxtNombre().getText();
				verifyFieldWhiteName(vf.getoTW().getTxtPais().getText());
				String teamCountry = vf.getoTW().getTxtPais().getText();
				
				
				int selectedIndex = vf.getoTW().getJComboBox().getSelectedIndex();
				CyclistDTO selectedCyclist = mf.getCiclistaDAO().getListCyclists().get(selectedIndex);;
				String id_Cicla = String.valueOf(selectedCyclist.getID());
				mf.getEquipoDAO().create(new TeamDTO(teamName, teamCountry,id_Cicla,null, null, null));

				
				vf.getoTW().getTxtNombre().setText("");
				vf.getoTW().getTxtPais().setText("");
				vf.getoTW().getJComboBox().addActionListener(new ActionListener() {
				    @Override
				    public void actionPerformed(ActionEvent e) {
				        JComboBox comboBox = (JComboBox) e.getSource();
				        int selectedIndexTeam = comboBox.getSelectedIndex();
				        int selectedIndexCyclist = vf.getoTW().getJComboBox().getSelectedIndex();
				        TeamDTO selectedTeam = mf.getEquipoDAO().getListaEquipos().get(selectedIndexTeam);
				        CyclistDTO selectedCyclist = mf.getCiclistaDAO().getListCyclists().get(selectedIndexCyclist);
				        int selectedIndexMassages = vf.getoTW().getJComboBox2().getSelectedIndex();
				        int selectedIndexDirectors = vf.getoTW().getJComboBox3().getSelectedIndex();
				        
				        MassageTherapistDTO selectedMassages = mf.getMasajistaDAO().getListMasseurs().get(selectedIndexMassages);
				        SportsDirectorDTO selectedDirectors = mf.getDirectorDAO().getListDirectors().get(selectedIndexDirectors);
				        if (mf.getEquipoDAO().checkIndex(mf.getEquipoDAO().getLast()).equals("g")) {

							mf.getEquipoDAO().addCyclistToTeam(mf.getEquipoDAO().getLast(), selectedCyclist);
						} else {
							JOptionPane.showMessageDialog(vf.getoTW(), "Incorrect data entered");
						}
				        if (mf.getEquipoDAO().checkIndex(mf.getEquipoDAO().getLast()).equals("g")) {

							mf.getEquipoDAO().addMassageToTeam(mf.getEquipoDAO().getLast(), selectedMassages);
						} else {
							JOptionPane.showMessageDialog(vf.getoTW(), "Incorrect data entered");
						}
				        if (mf.getEquipoDAO().checkIndex(mf.getEquipoDAO().getLast()).equals("g")) {

							mf.getEquipoDAO().addDirectorToTeam(mf.getEquipoDAO().getLast(), selectedDirectors);
						} else {
							JOptionPane.showMessageDialog(vf.getoTW(), "Incorrect data entered");
						}
				        
				        
				    }
				});
				

				vf.getoTW().getJComboBox().addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						JComboBox comboBox = (JComboBox) e.getSource();
						int selectedIndexCyclist = comboBox.getSelectedIndex();
						CyclistDTO temp = null;
						temp = mf.getCiclistaDAO().getListCyclists().get(selectedIndexCyclist);

						

					}
				});

				JOptionPane.showMessageDialog(vf.getoTW(), "Data Entered Successfully");

			} catch (BlankFieldException e1) {
				vf.getCon().imprimirTextoVE(e1.getMessage());
			}
			optionTeamWindow();
			vf.getoTW().setVisible(false);
			mainWindow();
			vf.getmW().setVisible(true);

			break;

		case "btn show Team":
			agregarTablaEquipo();
			teamShowAllWindow();
			vf.gettSAW().setVisible(true);

			break;

		case "btn Delete Team":
			teamWindown();
			vf.gettW().setVisible(false);
			teamDeleteWindow();
			vf.gettDW().setVisible(true);

			break;

		case "btn Confirmar Delete Team":
			if (vf.getCon().confirmarTextoVE("Are you sure you want to eliminate the director?") == 0) {

				eliminarEquipo();

				vf.getCon().imprimirTextoVE("Director successfully removed ");
			} else {
				vf.getCon().imprimirTextoVE("The director with the entered id was not found");
			}
			teamDeleteWindow();
			vf.gettDW().setVisible(false);
			mainWindow();
			vf.getmW().setVisible(true);

			break;

		case "btn Volver Delete Team":
			teamDeleteWindow();
			vf.gettDW().setVisible(false);
			teamWindown();
			vf.gettW().setVisible(true);

			break;

		case "btn Go Back Team":

			teamWindown();
			vf.gettW().setVisible(false);
			optionWindow();
			vf.getoW().setVisible(true);

			break;

		case "btn Confirmar Update Team":

			int indexPosiT = Integer.parseInt(vf.gettUW().getTxtPosi().getText());
			if (mf.getEquipoDAO().checkIndex(indexPosiT).equals("g")) {

				try {

					JComboBox comboBox = vf.getoTW().getJComboBox();
					int selectedIndex = comboBox.getSelectedIndex();
					JComboBox comboBox2 = vf.getoTW().getJComboBox2();
					int selectedIndex2 = comboBox2.getSelectedIndex();
					JComboBox comboBox3 = vf.getoTW().getJComboBox3();
					int selectedIndex3 = comboBox3.getSelectedIndex();

					ArrayList<CyclistDTO> cyclists = mf.getCiclistaDAO().getListCyclists();
					CyclistDTO selectedCyclist = cyclists.get(selectedIndex);

					ArrayList<MassageTherapistDTO> massages = mf.getMasajistaDAO().getListMasseurs();
					MassageTherapistDTO selectedMassages = massages.get(selectedIndex2);

					ArrayList<SportsDirectorDTO> directors = mf.getDirectorDAO().getListDirectors();
					SportsDirectorDTO selectedDirectors = directors.get(selectedIndex3);

					verifyFieldWhiteName(vf.getoTW().getTxtNombre().getText());
					String teamName = vf.getoTW().getTxtNombre().getText();
					verifyFieldWhiteName(vf.getoTW().getTxtNombre().getText());
					String teamCountry = vf.getoTW().getTxtNombre().getText();
					String id_Cicla = String.valueOf(selectedCyclist.getID());
					mf.getEquipoDAO().create(new TeamDTO(teamName, teamCountry,id_Cicla, null, null, null));

					comboBox.setSelectedIndex(-1);
					vf.getoTW().getTxtNombre().setText("");
					vf.getoTW().getTxtPais().setText("");
					comboBox2.setSelectedIndex(-1);
					comboBox3.setSelectedIndex(-1);

					vf.getoTW().getJComboBox().addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							JComboBox comboBox = (JComboBox) e.getSource();
							int selectedIndexCyclist = comboBox.getSelectedIndex();
							CyclistDTO temp = null;
							temp = mf.getCiclistaDAO().getListCyclists().get(selectedIndexCyclist);

							if (mf.getEquipoDAO().checkIndex(mf.getEquipoDAO().getLast()).equals("g")) {

								mf.getEquipoDAO().addCyclistToTeam(mf.getEquipoDAO().getLast(), temp);
							} else {
								JOptionPane.showMessageDialog(vf.getoTW(), "Incorrect data entered");
							}

						}
					});

					JOptionPane.showMessageDialog(vf.getoTW(), "Data OverWrite Successfully");

				} catch (BlankFieldException e1) {
					vf.getCon().imprimirTextoVE(e1.getMessage());
				}
			}

			break;

		case "btn Volver Update Team":
			teamUpdateWindow();
			vf.gettUW().setVisible(false);
			teamWindown();
			vf.gettW().setVisible(true);

			break;

		// TODO LO DEMAS DEL APLICATIVO

		case "Iniciar Sesion":
			mainWindow();
			vf.getmW().setVisible(false);
			loginWindow();
			vf.getlW().setVisible(true);
			break;

		case "Confirmar Inicio Sesion":
			mainWindow();
			if (login() == 1) {
				vf.getlW().setVisible(false);
				vf.getcWL().setVisible(true);
			} else if (login() == 2) {
				vf.getlW().setVisible(false);
				vf.getmWL().setVisible(true);
			} else if (login() == 3) {
				vf.getlW().setVisible(false);
				vf.getdWL().setVisible(true);
			} else if (login() == 0) {
				JOptionPane.showMessageDialog(vf.getlW(), "el id y la contraseña no son iguales ");
			} else {
				JOptionPane.showMessageDialog(vf.getlW(), "El usuario No existe ");
			}

			break;

		case "Registro":
			mainWindow();
			vf.getmW().setVisible(false);
			optionWindow();
			vf.getoW().setVisible(true);
			break;

		case "Salir Ventana Principal":
			System.exit(0);

			break;

		case "Volver Inicio Sesion":
			loginWindow();
			vf.getlW().setVisible(false);
			mainWindow();
			vf.getmW().setVisible(true);
			break;

		case "Confirmar Registrarse":

			vf.getsIW().setVisible(false);
			optionWindow();
			vf.getoW().setVisible(true);

			break;

		case "Volver Registrarse":
			signInWindow();
			vf.getsIW().setVisible(false);
			mainWindow();
			vf.getmW().setVisible(true);
			break;

		case "btn Create Cyclist":
			cyclistWindow();
			vf.getcW().setVisible(false);
			cyclistCreateWindow();
			vf.getcCFW().setVisible(true);
			break;

		case "btn Create Create Cyclist":

			try {

				verifyFieldWhiteName(vf.getcCFW().getTxtDocumento().getText());
				long iD = Long.parseLong(vf.getcCFW().getTxtDocumento().getText());
				verifyFieldWhiteName(vf.getcCFW().getTxtNombre().getText());
				String nombre = vf.getcCFW().getTxtNombre().getText();
				String tipoGenero = "";
				String selectedItem = (String) vf.getcCFW().getjComboBox2().getSelectedItem();
				if (selectedItem != null) {
					tipoGenero = selectedItem;
				}
				verifyFieldWhiteName(tipoGenero);
				String tipoCiclista = "";
				String selectedItem2 = (String) vf.getcCFW().getjComboBox3().getSelectedItem();
				if (selectedItem2 != null) {
					tipoCiclista = selectedItem2;
				}
				verifyFieldWhiteName(tipoCiclista);
				verifyFieldWhiteName(vf.getcCFW().getTxtCorreo().getText());
				String correo = vf.getcCFW().getTxtCorreo().getText();
				verifyFieldWhiteName(vf.getcCFW().getTxtTarjetaId().getText());
				long cardIdentificacion = Long.parseLong(vf.getcCFW().getTxtTarjetaId().getText());
				verifyFieldWhiteName(vf.getcCFW().getTxtAltura().getText());
				float altura = Float.parseFloat(vf.getcCFW().getTxtAltura().getText());
				verifyFieldWhiteName(vf.getcCFW().getTxtPeso().getText());
				float peso = Float.parseFloat(vf.getcCFW().getTxtPeso().getText());
				verifyFieldWhiteName(vf.getcCFW().getTxtTiempoCarrera().getText());
				int tiempoCarrera = Integer.parseInt(vf.getcCFW().getTxtTiempoCarrera().getText());
				verifyFieldWhiteName(vf.getcCFW().getTxtCadenciaPedaleo().getText());
				int cadenciaPedaleo = Integer.parseInt(vf.getcCFW().getTxtCadenciaPedaleo().getText());

				mf.getCiclistaDAO().create(new CyclistDTO(iD, nombre, correo, cardIdentificacion, selectedItem, null,
						tiempoCarrera, tipoCiclista, cadenciaPedaleo, peso, altura));

				vf.getcCFW().getTxtDocumento().setText("");
				vf.getcCFW().getTxtNombre().setText("");
				vf.getcCFW().getjComboBox2().setSelectedItem(-1);
				vf.getcCFW().getjComboBox3().setSelectedItem(-1);
				vf.getcCFW().getTxtCorreo().setText("");
				vf.getcCFW().getTxtTarjetaId().setText("");
				vf.getcCFW().getTxtAltura().setText("");
				vf.getcCFW().getTxtPeso().setText("");
				vf.getcCFW().getTxtCadenciaPedaleo().setText("");
				vf.getcCFW().getTxtTiempoCarrera().setText("");
				
				createMail("Registro ISUSCI", correo,
						"<html><body>" + "Bienvenido " + nombre + " a ISUSCI<br>"
								+ "Usted es tipo Ciclista, con rol de: " + tipoCiclista + "<br>" + "Su usuario es: "
								+ iD + "<br>" + "Su contraseña es: " + iD + "<br>"
								+ "Su usuario y contraseña es de uso personal e intrasferible.<br>"
								+ "Gracias por usar nuestro aplicativo<br>" + "</body></html>");
				sendMail();

				JOptionPane.showMessageDialog(vf.getcCFW(),
						"Data Entered Successfully: " + "\n" + mf.getCiclistaDAO().readOnly());

			} catch (BlankFieldException e1) {
				vf.getCon().imprimirTextoVE(e1.getMessage());
			}
			cyclistCreateWindow();
			vf.getcUW().setVisible(false);
			mainWindow();
			vf.getmW().setVisible(true);
			break;

		case "btn Go Back Create Cyclist":
			cyclistCreateWindow();
			vf.getcCFW().setVisible(false);
			cyclistWindow();
			vf.getcW().setVisible(true);
			break;

		case "btn Update Cyclist":
			cyclistWindow();
			vf.getcWL().setVisible(false);
			cyclistUpdateWindow();
			vf.getcUW().setVisible(true);
			break;

		case "btn Go Back Update Cyclist":
			cyclistUpdateWindow();
			vf.getcUW().setVisible(false);
			cyclistWindow();
			vf.getcWL().setVisible(true);
			break;

		case "btn Delete Cyclist":
			cyclistWindow();
			vf.getcWL().setVisible(false);
			cyclistDeleteWindow();
			vf.getcDW().setVisible(true);
			break;

		case "btn Go Back Delete Cyclist":
			cyclistDeleteWindow();
			vf.getcDW().setVisible(false);
			cyclistWindow();
			vf.getcWL().setVisible(true);
			break;

		case "btn Update Update Cyclist":

			int indexPosiC = Integer.parseInt(vf.getcUW().getTxtPosi().getText());
			if (mf.getCiclistaDAO().checkIndex(indexPosiC).equals("g")) {

				try {

					verifyFieldWhiteName(vf.getcUW().getTxtDocumento().getText());
					long iD = Long.parseLong(vf.getcUW().getTxtDocumento().getText());
					verifyFieldWhiteName(vf.getcUW().getTxtNombre().getText());
					String nombre = vf.getcUW().getTxtNombre().getText();
					String tipoGenero = "";
					String selectedItem = (String) vf.getcUW().getjComboBox2().getSelectedItem();
					if (selectedItem != null) {
						tipoGenero = selectedItem;
					}
					verifyFieldWhiteName(tipoGenero);
					String tipoCiclista = "";
					String selectedItem2 = (String) vf.getcUW().getjComboBox3().getSelectedItem();
					if (selectedItem2 != null) {
						tipoCiclista = selectedItem2;
					}
					verifyFieldWhiteName(tipoCiclista);
					verifyFieldWhiteName(vf.getcUW().getTxtCorreo().getText());
					String correo = vf.getcUW().getTxtCorreo().getText();
					verifyFieldWhiteName(vf.getcUW().getTxtTarjetaId().getText());
					long cardIdentificacion = Long.parseLong(vf.getcUW().getTxtTarjetaId().getText());
					verifyFieldWhiteName(vf.getcUW().getTxtAltura().getText());
					float altura = Float.parseFloat(vf.getcUW().getTxtAltura().getText());
					verifyFieldWhiteName(vf.getcUW().getTxtPeso().getText());
					float peso = Float.parseFloat(vf.getcUW().getTxtPeso().getText());
					verifyFieldWhiteName(vf.getcUW().getTxtTiempoCarrera().getText());
					int tiempoCarrera = Integer.parseInt(vf.getcUW().getTxtTiempoCarrera().getText());
					verifyFieldWhiteName(vf.getcUW().getTxtCadenciaPedaleo().getText());
					int cadenciaPedaleo = Integer.parseInt(vf.getcUW().getTxtCadenciaPedaleo().getText());

					mf.getCiclistaDAO().update(indexPosiC, new CyclistDTO(iD, nombre, correo, cardIdentificacion,
							selectedItem, null, tiempoCarrera, tipoCiclista, cadenciaPedaleo, peso, altura));

					vf.getcUW().getTxtDocumento().setText("");
					vf.getcUW().getTxtNombre().setText("");
					vf.getcUW().getjComboBox2().setSelectedItem(-1);
					vf.getcUW().getjComboBox3().setSelectedItem(-1);
					vf.getcUW().getTxtCorreo().setText("");
					vf.getcUW().getTxtTarjetaId().setText("");
					vf.getcUW().getTxtAltura().setText("");
					vf.getcUW().getTxtPeso().setText("");
					vf.getcUW().getTxtCadenciaPedaleo().setText("");
					vf.getcUW().getTxtTiempoCarrera().setText("");
					
					createMail("Actualizacion de datos ISUSCI", correo,
							"<html><body>" + "Bienvenido " + nombre + " a ISUSCI<br>"
									+ "Usted es tipo Ciclista, con rol de: " + tipoCiclista + "<br>" + "Su usuario es: "
									+ iD + "<br>" + "Su contraseña es: " + iD + "<br>"
									+ "Su usuario y contraseña es de uso personal e intrasferible.<br>"
									+ "Gracias por usar nuestro aplicativo<br>" + "</body></html>");
					sendMail();

					JOptionPane.showMessageDialog(vf.getcUW(),
							"Data to Overwrite: " + "\n" + mf.getCiclistaDAO().readOnly());
				} catch (BlankFieldException e1) {
					vf.getCon().imprimirTextoVE(e1.getMessage());
				}
			}

			cyclistUpdateWindow();
			vf.getcUW().setVisible(false);
			mainWindow();
			vf.getcWL().setVisible(true);
			break;

		case "btn Delete Delete Cyclist":

			if (vf.getCon().confirmarTextoVE("Are you sure you want to eliminate the director?") == 0) {

				eliminarUsuarioCiclista();

				vf.getCon().imprimirTextoVE("Director successfully removed ");
			} else {
				vf.getCon().imprimirTextoVE("The director with the entered id was not found");
			}
			cyclistDeleteWindow();
			vf.getcDW().setVisible(false);
			mainWindow();
			vf.getcWL().setVisible(true);

		case "btn Show All Cyclist":
			agregarTablaCiclista();
			cyclistWindow();
			vf.getcWL().setVisible(false);
			cyclistShowAllWindow();
			vf.getcSAW().setVisible(true);
			break;

		case "btn Go Back Show All Cyclist":
			cyclistShowAllWindow();
			vf.getcSAW().setVisible(false);
			cyclistWindow();
			vf.getcWL().setVisible(true);
			break;

		case "Ciclista":
			optionWindow();
			vf.getoW().setVisible(false);
			cyclistWindow();
			vf.getcW().setVisible(true);

			break;

		case "btn Go Back Cyclist":
			cyclistWindow();
			vf.getcW().setVisible(false);
			mainWindow();
			vf.getmW().setVisible(true);
			break;

		case "Close Cyclist":
			cyclistWindow();
			vf.getcWL().setVisible(false);
			mainWindow();
			vf.getmW().setVisible(true);
			break;

		case "Masajista":
			optionWindow();
			vf.getoW().setVisible(false);
			masseuseWindow();
			vf.getMaW().setVisible(true);
			break;

		case "Volver Opciones":
			optionWindow();
			vf.getoW().setVisible(false);
			mainWindow();
			vf.getmW().setVisible(true);
			break;

		case "Crear Masajista":
			masseuseWindow();
			vf.getMaW().setVisible(false);
			masseuseCreateWindow();
			vf.getmCW().setVisible(true);
			break;

		case "btnConfirmarCrearMasajista":
			try {

				verifyFieldWhiteName(vf.getmCW().getTxtDocumento().getText());
				long iD = Long.parseLong(vf.getmCW().getTxtDocumento().getText());
				verifyFieldWhiteName(vf.getmCW().getTxtNombre().getText());
				String nombre = vf.getmCW().getTxtNombre().getText();
				String tipoGenero = "";
				String selectedItem = (String) vf.getmCW().getjComboBox2().getSelectedItem();
				if (selectedItem != null) {
					tipoGenero = selectedItem;
				}
				verifyFieldWhiteName(tipoGenero);
				verifyFieldWhiteName(vf.getmCW().getTxtCorreo().getText());
				String correo = vf.getmCW().getTxtCorreo().getText();
				verifyFieldWhiteName(vf.getmCW().getTxtIdentificationCard().getText());
				long cardIdentificacion = Long.parseLong(vf.getmCW().getTxtIdentificationCard().getText());
				verifyFieldWhiteName(vf.getmCW().getTxtMassage().getText());
				String massage = vf.getmCW().getTxtMassage().getText();
				verifyFieldWhiteName(vf.getmCW().getTxtAniosExperiencia().getText());
				int anio = Integer.parseInt(vf.getmCW().getTxtAniosExperiencia().getText());

				mf.getMasajistaDAO().create(new MassageTherapistDTO(iD, nombre, correo, cardIdentificacion, tipoGenero,
						null, massage, anio));

				vf.getmCW().getTxtDocumento().setText("");
				vf.getmCW().getTxtNombre().setText("");
				vf.getmCW().getjComboBox2().setSelectedItem(-1);
				vf.getmCW().getTxtCorreo().setText("");
				vf.getmCW().getTxtIdentificationCard().setText("");
				vf.getmCW().getTxtMassage().setText("");
				vf.getmCW().getTxtAniosExperiencia().setText("");
				createMail("Registro ISUSCI", correo,
						"<html><body>" + "Bienvenido " + nombre + " a ISUSCI<br>" + "Usted es tipo Masajista<br>"
								+ "Su usuario es: " + iD + "<br>" + "Su contraseña es: " + iD + "<br>"
								+ "Su usuario y contraseña es de uso personal e intrasferible<br>"
								+ "Gracias por usar nuestro aplicativo<br>" + "</body></html>");
				sendMail();

				JOptionPane.showMessageDialog(vf.getmCW(),
						"Data Entered Successfully: " + "\n" + mf.getMasajistaDAO().readOnly());

			} catch (BlankFieldException e1) {
				vf.getCon().imprimirTextoVE(e1.getMessage());
			}
			masseuseCreateWindow();
			vf.getmCW().setVisible(false);
			mainWindow();
			vf.getmW().setVisible(true);
			break;

		case "btnVolverCrearMasajista":
			masseuseCreateWindow();
			vf.getmCW().setVisible(false);
			masseuseWindow();
			vf.getMaW().setVisible(true);
			break;

		case "Actualizar Masajista":
			masseuseWindow();
			vf.getmWL().setVisible(false);
			masseuseUpdateWindow();
			vf.getmUW().setVisible(true);
			break;

		case "btn Confirmar Update Masajista":

			int indexPosiM = Integer.parseInt(vf.getmUW().getTxtPosi().getText());
			if (mf.getMasajistaDAO().checkIndex(indexPosiM).equals("g")) {

				try {

					verifyFieldWhiteName(vf.getmUW().getTxtDocumento().getText());
					long iD = Long.parseLong(vf.getmUW().getTxtDocumento().getText());
					verifyFieldWhiteName(vf.getmUW().getTxtNombre().getText());
					String nombre = vf.getmUW().getTxtNombre().getText();
					String tipoGenero = "";
					String selectedItem = (String) vf.getmUW().getjComboBox2().getSelectedItem();
					if (selectedItem != null) {
						tipoGenero = selectedItem;
					}
					verifyFieldWhiteName(tipoGenero);
					verifyFieldWhiteName(vf.getmUW().getTxtCorreo().getText());
					String correo = vf.getmUW().getTxtCorreo().getText();
					verifyFieldWhiteName(vf.getmUW().getTxtIdentificationCard().getText());
					long cardIdentificacion = Long.parseLong(vf.getmUW().getTxtIdentificationCard().getText());
					verifyFieldWhiteName(vf.getmUW().getTxtMassage().getText());
					String massage = vf.getmUW().getTxtMassage().getText();
					verifyFieldWhiteName(vf.getmUW().getTxtAniosExperiencia().getText());
					int anio = Integer.parseInt(vf.getmUW().getTxtAniosExperiencia().getText());

					mf.getMasajistaDAO().update(indexPosiM, new MassageTherapistDTO(iD, nombre, correo,
							cardIdentificacion, tipoGenero, null, massage, anio));

					vf.getmUW().getTxtDocumento().setText("");
					vf.getmUW().getTxtNombre().setText("");
					vf.getmUW().getjComboBox2().setSelectedItem(-1);
					vf.getmUW().getTxtCorreo().setText("");
					vf.getmUW().getTxtIdentificationCard().setText("");
					vf.getmUW().getTxtMassage().setText("");
					vf.getmUW().getTxtAniosExperiencia().setText("");
					
					createMail("Actializacion de datos ISUSCI", correo,
							"<html><body>" + "Bienvenido " + nombre + " a ISUSCI<br>" + "Usted es tipo Masajista<br>"
									+ "Su usuario es: " + iD + "<br>" + "Su contraseña es: " + iD + "<br>"
									+ "Su usuario y contraseña es de uso personal e intrasferible<br>"
									+ "Gracias por usar nuestro aplicativo<br>" + "</body></html>");
					sendMail();

					JOptionPane.showMessageDialog(vf.getmUW(),
							"Data to Overwrite: " + "\n" + mf.getMasajistaDAO().readOnly());

				} catch (BlankFieldException e1) {
					vf.getCon().imprimirTextoVE(e1.getMessage());
				}
			}
			directorUpdateWindow();
			vf.getdUW().setVisible(false);
			mainWindow();
			vf.getmWL().setVisible(true);

			break;

		case "btn Volver Update Masajista":
			masseuseUpdateWindow();
			vf.getmUW().setVisible(false);
			masseuseWindow();
			vf.getmWL().setVisible(true);
			break;

		case "Eliminar Masajista":
			masseuseWindow();
			vf.getmWL().setVisible(false);
			masseuseDeleteWindow();
			vf.getmDW().setVisible(true);
			break;

		case "btn Confirmar Delete Masajista":
			if (vf.getCon().confirmarTextoVE("Are you sure you want to eliminate the director?") == 0) {

				eliminarUsuarioMasajista();

				vf.getCon().imprimirTextoVE("Director successfully removed ");
			} else {
				vf.getCon().imprimirTextoVE("The director with the entered id was not found");
			}
			masseuseDeleteWindow();
			vf.getmDW().setVisible(false);
			mainWindow();
			vf.getmWL().setVisible(true);
			break;

		case "btn Volver Delete Masajista":
			masseuseDeleteWindow();
			vf.getmDW().setVisible(false);
			masseuseWindow();
			vf.getmWL().setVisible(true);
			break;

		case "Mostrar Masajista":
			agregarTablaMasajista();
			masseuseWindow();
			vf.getmWL().setVisible(false);
			masseuseShowAllWindow();
			vf.getmSAW().setVisible(true);
			break;

		case "btn Volver Show All Masajistas":
			masseuseShowAllWindow();
			vf.getmSAW().setVisible(false);
			masseuseWindow();
			vf.getmWL().setVisible(true);
			break;

		case "Regresar Masajista":
			masseuseWindow();
			vf.getMaW().setVisible(false);
			optionWindow();
			vf.getoW().setVisible(true);
			break;

		case "Cerrar Masajista":
			masseuseWindow();
			vf.getmWL().setVisible(false);
			mainWindow();
			vf.getmW().setVisible(true);
			break;

		case "Director":
			optionWindow();
			vf.getoW().setVisible(false);
			directorWindow();
			vf.getdW().setVisible(true);
			break;

		case "Crear Director":
			directorWindow();
			vf.getdW().setVisible(false);
			directorCreateWindow();
			vf.getdCW().setVisible(true);
			break;

		case "btn Confirmar Crear Director":
			try {

				verifyFieldWhiteName(vf.getdCW().getTxtDocumento().getText());
				long iD = Long.parseLong(vf.getdCW().getTxtDocumento().getText());
				verifyFieldWhiteName(vf.getdCW().getTxtNombre().getText());
				String nombre = vf.getdCW().getTxtNombre().getText();
				verifyFieldWhiteName(vf.getdCW().getTxtCorreo().getText());
				String correo = vf.getdCW().getTxtCorreo().getText();
				verifyFieldWhiteName(vf.getdCW().getTxtNacionalidad().getText());
				verifyFieldWhiteName(vf.getdCW().getTxtIdentificationCard().getText());
				long cardIdentificacion = Long.parseLong(vf.getdCW().getTxtIdentificationCard().getText());
				String tipoGenero = "";
				String selectedItem = (String) vf.getdCW().getjComboBox2().getSelectedItem();
				if (selectedItem != null) {
					tipoGenero = selectedItem;
				}
				verifyFieldWhiteName(tipoGenero);
				String nacionalidad = vf.getdCW().getTxtNacionalidad().getText();
				verifyFieldWhiteName(vf.getdCW().getTxtHistorialEquipo().getText());
				String historialEquipo = vf.getdCW().getTxtHistorialEquipo().getText();
				verifyFieldWhiteName(vf.getdCW().getTxtAniosExperiencia().getText());
				int anio = Integer.parseInt(vf.getdCW().getTxtAniosExperiencia().getText());

				mf.getDirectorDAO().create(new SportsDirectorDTO(iD, nombre, correo, cardIdentificacion, selectedItem,
						null, nacionalidad, historialEquipo, anio));

				vf.getdCW().getTxtIdentificationCard().setText("");
				vf.getdCW().getjComboBox2().setSelectedItem(-1);
				vf.getdCW().getTxtNombre().setText("");
				vf.getdCW().getTxtDocumento().setText("");
				vf.getdCW().getTxtNacionalidad().setText("");
				vf.getdCW().getTxtCorreo().setText("");
				vf.getdCW().getTxtHistorialEquipo().setText("");
				vf.getdCW().getTxtAniosExperiencia().setText("");
				
				createMail("Registro ISUSCI", correo,
						"<html><body>" + "Bienvenido " + nombre + " a ISUSCI<br>" + "Usted es tipo Director<br>"
								+ "Su usuario es: " + iD + "<br>" + "Su contraseña es: " + iD + "<br>"
								+ "Su usuario y contraseña es de uso personal e intrasferible<br>"
								+ "Gracias por usar nuestro aplicativo<br>" + "</body></html>");
				sendMail();

				JOptionPane.showMessageDialog(vf.getdCW(),
						"Data Entered Successfully: " + "\n" + mf.getDirectorDAO().readOnly());

			} catch (BlankFieldException e1) {
				vf.getCon().imprimirTextoVE(e1.getMessage());
			}
			directorCreateWindow();
			vf.getdCW().setVisible(false);
			mainWindow();
			vf.getmW().setVisible(true);

			break;

		case "btn Volver Crear Director":
			directorCreateWindow();
			vf.getdCW().setVisible(false);
			directorWindow();
			vf.getdW().setVisible(true);
			break;

		case "Actualizar Director":

			directorWindow();
			vf.getdWL().setVisible(false);
			directorUpdateWindow();
			vf.getdUW().setVisible(true);
			break;

		case "btn Confirmar Update Director":
			int indexPosi = Integer.parseInt(vf.getdUW().getTxtPosi().getText());
			if (mf.getDirectorDAO().checkIndex(indexPosi).equals("g")) {

				try {
					verifyFieldWhiteName(vf.getdUW().getTxtDocumento().getText());
					long iD = Long.parseLong(vf.getdUW().getTxtDocumento().getText());
					verifyFieldWhiteName(vf.getdUW().getTxtNombre().getText());
					String nombre = vf.getdUW().getTxtNombre().getText();
					verifyFieldWhiteName(vf.getdUW().getTxtCorreo().getText());
					String correo = vf.getdUW().getTxtCorreo().getText();
					verifyFieldWhiteName(vf.getdUW().getTxtNacionalidad().getText());
					verifyFieldWhiteName(vf.getdUW().getTxtIdentificationCard().getText());
					long cardIdentificacion = Long.parseLong(vf.getdUW().getTxtIdentificationCard().getText());
					String tipoGenero = "";
					String selectedItem = (String) vf.getdUW().getjComboBox2().getSelectedItem();
					if (selectedItem != null) {
						tipoGenero = selectedItem;
					}
					verifyFieldWhiteName(tipoGenero);
					String nacionalidad = vf.getdUW().getTxtNacionalidad().getText();
					verifyFieldWhiteName(vf.getdUW().getTxtHistorialEquipo().getText());
					String historialEquipo = vf.getdUW().getTxtHistorialEquipo().getText();
					verifyFieldWhiteName(vf.getdUW().getTxtAniosExperiencia().getText());
					int anio = Integer.parseInt(vf.getdUW().getTxtAniosExperiencia().getText());
					mf.getDirectorDAO().update(indexPosi, new SportsDirectorDTO(iD, nombre, correo, cardIdentificacion,
							selectedItem, null, nacionalidad, historialEquipo, anio));

					vf.getdUW().getTxtIdentificationCard().setText("");
					vf.getdUW().getjComboBox2().setSelectedItem(-1);
					vf.getdUW().getTxtNombre().setText("");
					vf.getdUW().getTxtDocumento().setText("");
					vf.getdUW().getTxtNacionalidad().setText("");
					vf.getdUW().getTxtCorreo().setText("");
					vf.getdUW().getTxtHistorialEquipo().setText("");
					vf.getdUW().getTxtAniosExperiencia().setText("");
					JOptionPane.showMessageDialog(vf.getdUW(),
							"Data to Overwrite: " + "\n" + mf.getDirectorDAO().readOnly());
					
					createMail("Actualizacion de datos ISUSCI", correo,
							"<html><body>" + "Bienvenido " + nombre + " a ISUSCI<br>" + "Usted es tipo Director<br>"
									+ "Su usuario es: " + iD + "<br>" + "Su contraseña es: " + iD + "<br>"
									+ "Su usuario y contraseña es de uso personal e intrasferible<br>"
									+ "Gracias por usar nuestro aplicativo<br>" + "</body></html>");
					sendMail();

				} catch (BlankFieldException e1) {
					vf.getCon().imprimirTextoVE(e1.getMessage());
				}
			}
			directorUpdateWindow();
			vf.getdUW().setVisible(false);
			mainWindow();
			vf.getdWL().setVisible(true);

			break;

		case "btn Volver Update Director":
			directorUpdateWindow();
			vf.getdUW().setVisible(false);
			directorWindow();
			vf.getdWL().setVisible(true);
			break;

		case "Eliminar Director":
			directorWindow();
			vf.getdWL().setVisible(false);
			directorDeleteWindow();
			vf.getdDW().setVisible(true);
			break;

		case "btn Confirmar Delete Director":

			if (vf.getCon().confirmarTextoVE("Are you sure you want to eliminate the director?") == 0) {

				eliminarUsuarioDirector();

				vf.getCon().imprimirTextoVE("Director successfully removed ");
			} else {
				vf.getCon().imprimirTextoVE("The director with the entered id was not found");
			}
			directorDeleteWindow();
			vf.getdDW().setVisible(false);
			mainWindow();
			vf.getdWL().setVisible(true);
			break;

		case "btn Volver Delete Director":
			directorDeleteWindow();
			vf.getdDW().setVisible(false);
			directorWindow();
			vf.getdWL().setVisible(true);
			break;

		case "Mostrar Director":
			agregarTablaDirector();
			directorWindow();
			vf.getdWL().setVisible(false);
			directorShowAllWindow();
			vf.getdSAW().setVisible(true);
			break;

		case "btn Volver Show All Directors":

			directorShowAllWindow();
			vf.getdSAW().setVisible(false);

			directorWindow();

			vf.getdWL().setVisible(true);

			break;

		case "Regresar Director":
			directorWindow();
			vf.getdW().setVisible(false);
			optionWindow();
			vf.getoW().setVisible(true);
			break;

		case "Close Director":
			directorWindow();
			vf.getdW().setVisible(false);
			mainWindow();
			vf.getmW().setVisible(true);
			break;

		case "Regresar Ciclista":
			cyclistWindow();
			vf.getcW().setVisible(false);
			optionWindow();
			vf.getoW().setVisible(true);
			break;
			
		case "btn Simular":
			ArrayList<TeamDTO> listas = mf.getEquipoDAO().getListaEquipos();
			if(listas.size()<2) {
				vf.getCon().imprimirTextoVE("Se necesitan minimo 2 Equipos para avanzar ");
				teamWindown();
			}else {
				vf.gettW().setVisible(false);
				teamSimulation();
			}
			break;
			
		case "btn Volver Simulacion":
			teamSim.setVisible(false);
			vf.gettW().setVisible(true);
			
			break;
		case "btn Start Simulacion":
			ArrayList<CyclistDTO> seleccion = teamSim.getSeleccion();
			if(seleccion.size()==0) {
				vf.getCon().imprimirTextoVE("There's no Ciclyst to Simulate ");
			}else {
				teamSim.setVisible(false);
				typeSim.setVisible(true);
			}
			
			break;
			
		case "btn Seleccion Simulacion":
			ActualizaTabla2(">");
			break;
			
		case "btn Deseleccion Simulacion":
			int rowIndex = teamSim.getTabla2().getSelectedRow();
			seleccion =teamSim.getSeleccion();
			seleccion.remove(rowIndex);
			ActualizaTabla2("<");
			break;
		
		case "btn FW":
			String tipo="FW";
			Simulacion(tipo);
			typeSim.setVisible(false);
			break;
		case "btn SD":
			String tipo2="SD";
			Simulacion(tipo2);
			typeSim.setVisible(false);
			break;
		case "btn FS":
			String tipo3="FS";
			Simulacion(tipo3);
			typeSim.setVisible(false);
			break;
		case "btn M":
			String tipo4="M";
			Simulacion(tipo4);
			typeSim.setVisible(false);
			break;
		case "btn SF":
			String tipo5="SF";
			Simulacion(tipo5);
			typeSim.setVisible(false);
			break;
		case "btn Exit Type":
			teamSim.setVisible(true);
			typeSim.setVisible(false);
			break;
		case "btn Exit Sim":
			sim.setVisible(false);
			typeSim.setVisible(true);
			break;

		case "Enviar":
//			createMail();
//			sendMail();

		}
		

	}

	public void createMail(String asusnto, String enviarA, String contenido) {

		correo.setAsunto(asusnto);
		correo.setEnviarA(enviarA);
		correo.setContenido(contenido);

		// Simple mail transfer protocol
		mProperties.put("mail.smtp.host", "smtp.gmail.com");
		mProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		mProperties.setProperty("mail.smtp.starttls.enable", "true");
		mProperties.setProperty("mail.smtp.port", "587");
		mProperties.setProperty("mail.smtp.user", correo.getCorreoDe());
		mProperties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		mProperties.setProperty("mail.smtp.auth", "true");
		mProperties.setProperty("mail.smtp.password", correo.getContrasenia());

		mSeccion = Session.getDefaultInstance(mProperties);

		try {
			mCorreo = new MimeMessage(mSeccion);
			mCorreo.setFrom(new InternetAddress(correo.getCorreoDe()));
			mCorreo.setRecipient(Message.RecipientType.TO, new InternetAddress(correo.getEnviarA()));
			mCorreo.setSubject(correo.getAsunto());
			mCorreo.setText(correo.getContenido(), "ISO-8859-1", "html");
			mCorreo.setContent(contenido, "text/html; charset=UTF-8");
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void sendMail() {

		try {
			Transport mTransport = mSeccion.getTransport("smtp");
			mTransport.connect(correo.getCorreoDe(), correo.getContrasenia());
			mTransport.sendMessage(mCorreo, mCorreo.getRecipients(Message.RecipientType.TO));
			mTransport.close();
			JOptionPane.showMessageDialog(vf.getwM(), "Mensaje Enviado");
		} catch (NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void verifyFieldWhiteNumberInt(int n) throws BlankFieldException {
		if (n == 0) {
			throw new BlankFieldException();
		}
	}

	public void verifyFieldWhiteNumberLong(long n) throws BlankFieldException {
		if (n == 0) {
			throw new BlankFieldException();
		}
	}

	public void verifyFieldWhiteNumberFloat(float n) throws BlankFieldException {
		if (n == 0) {
			throw new BlankFieldException();
		}
	}

	public void verifyFieldWhiteName(String n) throws BlankFieldException {
		if (n.equals("")) {
			throw new BlankFieldException();
		}
	}

	public void verifyName(String n) throws NameNotValidException {
		Pattern ptrn = Pattern.compile("[^A-Za-záéíóúÁÉÍÓÚñÑ6]");
		Matcher mtchr = ptrn.matcher(n);
		if (mtchr.find()) {
			throw new NameNotValidException();
		}
	}
	public void PDFGenerator(String contenido) {
		try {
			String aux = vf.getCon().readString("Ingrese el nombre del PDF");
			pDF.crearPDF(aux, contenido);
			} catch(DocumentException e) {
				System.out.println("ftg");
			}
	}	
	
	public void Simulacion(String tipo) {
		sim = new SimulationWindow();
		sim.setVisible(true);
		ArrayList<CyclistDTO> seleccion = teamSim.getSeleccion();
		 ArrayList<JProgressBar> carrera= new ArrayList<JProgressBar>();
		 ArrayList<Integer> velocidades = new ArrayList<Integer>();
		 //carrera.add(sim.getRecorrido());
		//vf.getCon().imprimirTextoVE("Nombre del primer team "+listas.get(0).getTeamName() );
		Properties configuracion = FileHandler
				.cargarArchivoPropiedades("src/co/edu/unbosque/model/persistence/config.properties");
		sim.setSize(Integer.parseInt(configuracion.getProperty("Window.ancho")),
				Integer.parseInt(configuracion.getProperty("Window.alto")));
		sim.setLocationRelativeTo(null);
		sim.getPanelFondo().setBounds(0, 0, Integer.parseInt(configuracion.getProperty("Panel.ancho")),
				Integer.parseInt(configuracion.getProperty("Panel.alto")));
		sim.getLblImagen().setBounds(140, -80, Integer.parseInt(configuracion.getProperty("Imagen.ancho")),
				Integer.parseInt(configuracion.getProperty("Imagen.alto")));
		
		sim.getPanelFondo().add(sim.getLblImagen());
		//cargar jugadores
		int y=470;
		int velocidad=300;
		for(int i=0;i<seleccion.size();i++){
			JLabel nomPlayer= new JLabel(seleccion.get(i).getName());
			nomPlayer.setBounds(40,y,100,30);
			nomPlayer.setBackground(new Color (174, 214, 241));
			nomPlayer.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
			sim.getPanelFondo().add(nomPlayer);
			JProgressBar jugador = new JProgressBar();
			jugador.setBounds(140, y, 600, 30);
			sim.getPanelFondo().add(jugador);
			velocidad=(int) (Math.random()*(600-400+1)+400);
			velocidades.add(velocidad);
			carrera.add(jugador);
			y=y+30;
			sim.fill(velocidad,jugador);
			
		}
		JLabel lblTitulo=sim.getLblTitulo();
		if(tipo=="M") {
			
			lblTitulo.setText("SIMULATION MOUNTAIN");
			Image img = new ImageIcon("Image/Montaña.png").getImage();
			ImageIcon imgT = new ImageIcon(img.getScaledInstance(600, 400,Image.SCALE_SMOOTH));
			sim.getLblImagen().setIcon(imgT);
		}
		if(tipo=="SF") {
			lblTitulo.setText("SIMULATION SEMI FLAT");
			Image img = new ImageIcon("Image/Semi-llano.png").getImage();
			ImageIcon imgT = new ImageIcon(img.getScaledInstance(600, 400,Image.SCALE_SMOOTH));
			sim.getLblImagen().setIcon(imgT);
		}
		if(tipo=="FW") {
			lblTitulo.setText("SIMULATION FLAT WITH CURVES");
			Image img = new ImageIcon("Image/llano-curvas.png").getImage();
			ImageIcon imgT = new ImageIcon(img.getScaledInstance(600, 400,Image.SCALE_SMOOTH));
			sim.getLblImagen().setIcon(imgT);
		}
		if(tipo=="FS") {
			lblTitulo.setText("SIMULATION FLAT STRAIGHT");
			Image img = new ImageIcon("Image/Llano-recto.png").getImage();
			ImageIcon imgT = new ImageIcon(img.getScaledInstance(600, 400,Image.SCALE_SMOOTH));
			sim.getLblImagen().setIcon(imgT);
		}
		if(tipo=="SD") {
			lblTitulo.setText("SIMULATION SINGLE DAY");
			Image img = new ImageIcon("Image/Un-Dia.png").getImage();
			ImageIcon imgT = new ImageIcon(img.getScaledInstance(600, 400,Image.SCALE_SMOOTH));
			sim.getLblImagen().setIcon(imgT);
		}
		//Validacion Boton Salir;
		sim.getBtnExit().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                sim.setVisible(false);
                teamSim.setVisible(true);
            }

        });
		sim.getBtnResult().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                sim.setVisible(false);
                
                Resultados(velocidades,seleccion);
            }

        });

	}
	

	public void teamSimulation() {
		
		Properties configuracion = FileHandler
				.cargarArchivoPropiedades("src/co/edu/unbosque/model/persistence/config.properties");
		teamSim.setSize(Integer.parseInt(configuracion.getProperty("Window.ancho")),
				Integer.parseInt(configuracion.getProperty("Window.alto")));
		teamSim.setLocationRelativeTo(null);
		teamSim.getPanelFondo().setBounds(0, 0, Integer.parseInt(configuracion.getProperty("Panel.ancho")),
				Integer.parseInt(configuracion.getProperty("Panel.alto")));
	
		teamSim.getPanelFondo().add(teamSim.getLblImagen());
		teamSim.setVisible(true);
		
		//A continuacion se realiza la insersion de datos en la tabla
		ArrayList<TeamDTO> lista = mf.getEquipoDAO().getListaEquipos();
	    ArrayList<CyclistDTO> lista2 = mf.getCiclistaDAO().getListCyclists();
	    
	    int totalFilas = lista.size();
	    String[][] datos1 = new String[totalFilas][8];
	    String[][] datos2 = new String[totalFilas][8];
	    String[][] datos3 = new String[totalFilas][8];
	    int ind_Cicla=0;

	    for (int i = 0; i < totalFilas; i++) {
	    		TeamDTO equipo = lista.get(i);
	    		String id_cicla=equipo.getId_Cicla();
	    		for(int j=0;j<lista2.size();j++) {
	    			CyclistDTO ciclista = lista2.get(j);
	    			if(String.valueOf(ciclista.getID()).equals(id_cicla)) {
	    				ind_Cicla=j;
	    			}
	    		}
	    		CyclistDTO ciclista = lista2.get(ind_Cicla);

	    		datos1[i][0] = id_cicla;
	    		datos1[i][1] = equipo.getTeamName();
		        datos1[i][2] = equipo.getCountry();
		        datos1[i][3] = ciclista.getName();
		        datos1[i][4] = ciclista.getSpeciality();
  
	    }

	    String[][] combinedData = combineData(datos1, datos2, datos3);

	    teamSim.setFil(combinedData.length);
	    teamSim.setDatos(combinedData);
	    teamSim.actualizarTabla();
	}
	public void ActualizaTabla2(String tipo) {
		
		int rowIndex = teamSim.getTabla().getSelectedRow();
		String ID = teamSim.getTabla().getValueAt(rowIndex, 0).toString();
		ArrayList<CyclistDTO> seleccion =teamSim.getSeleccion();
		ArrayList<TeamDTO> lista = mf.getEquipoDAO().getListaEquipos();
	    ArrayList<CyclistDTO> lista2 = mf.getCiclistaDAO().getListCyclists();
		if(tipo==">") {
			for (int i = 0; i < lista2.size(); i++) {
	    		if(String.valueOf(lista2.get(i).getID()).equals(ID)) {
	    			seleccion.add(lista2.get(i));
	    			teamSim.setSeleccion(seleccion);
	    		}
			}
		}
	    //A continuacion se Actualiza la lista
	    
	  //A continuacion se realiza la insersion de datos en la tabla
	  	    int totalFilas = seleccion.size();
	  	    if(totalFilas>0) {
	  	    	String[][] datos1 = new String[totalFilas][8];
		  	    String[][] datos2 = new String[1][8];
		  	    String[][] datos3 = new String[1][8];
		  	  
		  	    for (int i = 0; i < lista.size(); i++) {
		  	    	TeamDTO equipo = lista.get(i);
		  	    	for(int j=0;j<seleccion.size();j++) {
		  	    		if(equipo.getId_Cicla().equals(String.valueOf(seleccion.get(j).getID()))) {
	  	    				CyclistDTO ciclista = seleccion.get(j);
	  	    				datos1[j][0] = equipo.getId_Cicla();
	  		  	    		datos1[j][1] = equipo.getTeamName();
	  		  		        datos1[j][2] = equipo.getCountry();
	  		  		        datos1[j][3] = ciclista.getName();
	  		  		        datos1[j][4] = ciclista.getSpeciality();
	  	    			}
		  	    	}
		  	    }

		  	    String[][] combinedData = combineData(datos1,datos2,datos3);

		  	    teamSim.setFil(combinedData.length);
		  	    teamSim.setDatos2(combinedData);
		  	    teamSim.actualizarTabla2();
	  	    }else {
	  	    	teamSim.setFil(0);
		  	    teamSim.setDatos2(new String[1][8]);
		  	    teamSim.actualizarTabla2();
	  	    }
	  	   
	  	  
	  	    
	}

	public void Resultados(ArrayList<Integer> velocidad, ArrayList<CyclistDTO> seleccion) {
		
		Properties configuracion = FileHandler
				.cargarArchivoPropiedades("src/co/edu/unbosque/model/persistence/config.properties");
		resultSim.setSize(Integer.parseInt(configuracion.getProperty("Window.ancho")),
				Integer.parseInt(configuracion.getProperty("Window.alto")));
		resultSim.setLocationRelativeTo(null);
		resultSim.getPanelFondo().setBounds(0, 0, Integer.parseInt(configuracion.getProperty("Panel.ancho")),
				Integer.parseInt(configuracion.getProperty("Panel.alto")));
	
		resultSim.getPanelFondo().add(resultSim.getLblImagen());
		resultSim.setVisible(true);
		
		//A continuacion se realiza la insersion de datos en la tabla
		ArrayList<TeamDTO> lista = mf.getEquipoDAO().getListaEquipos();
	    ArrayList<CyclistDTO> lista2 = mf.getCiclistaDAO().getListCyclists();
	    
	    int totalFilas = lista.size();
	    String[][] datos1 = new String[totalFilas][8];
	    String[][] datos2 = new String[totalFilas][8];
	    String[][] datos3 = new String[totalFilas][8];
	    int cont=0;
	    //llenado resultados de los ciclistas en la etapa
	    for (int i = 0; i < totalFilas; i++) {
	    		TeamDTO equipo = lista.get(i);
	    		String id_cicla=equipo.getId_Cicla();
	    		for(int j=0;j<seleccion.size();j++) {
	    			CyclistDTO ciclista = seleccion.get(j);
	    			if(String.valueOf(ciclista.getID()).equals(id_cicla)) {
	    				datos1[j][0] = cont+"";
	    	    		datos1[j][1] = equipo.getTeamName();
	    		        datos1[j][2] = equipo.getCountry();
	    		        datos1[j][3] = ciclista.getName();
	    		        datos1[j][4] = String.valueOf(velocidad.get(j)*(3600/600));
	    		        cont++;
	    			}
	    		}
  
	    }

	    String[][] combinedData = combineData(datos1, datos2, datos3);

	    resultSim.setFil(combinedData.length);
	    resultSim.setDatos(combinedData);
	    resultSim.actualizarTabla();
	    
	    //Resultados por equipo
	    int acumulado=0;
	    for (int i = 0; i < totalFilas; i++) {
	    	cont++;
    		TeamDTO equipo = lista.get(i);
    		String id_cicla=equipo.getId_Cicla();
    		for(int j=0;j<seleccion.size();j++) {
    			CyclistDTO ciclista = seleccion.get(j);
    			if(String.valueOf(ciclista.getID()).equals(id_cicla)) {
    				acumulado+=velocidad.get(j);
    				 
    			}
    			
    		}
    		datos1[i][0] = String.valueOf(cont);
    		datos1[i][1] = equipo.getTeamName();
	        datos1[i][2] = equipo.getCountry();
	        datos1[i][3] = String.valueOf(acumulado);

    }
	    combinedData = combineData(datos1, datos2, datos3);
	    resultSim.setFil(datos1.length);
	    resultSim.setDatos2(datos1);
	    resultSim.actualizarTabla2();
	}

}
