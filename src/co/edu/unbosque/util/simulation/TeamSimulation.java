package co.edu.unbosque.util.simulation;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import co.edu.unbosque.model.CyclistDTO;


public class TeamSimulation extends JFrame{
	
	private JPanel panelFondo;
	private JLabel lblImagen;
	private JButton btnVolver;
	private JButton btnStart;
	private JButton btnSeleccion;
	private JButton btnDeseleccion;
	private ArrayList<CyclistDTO> Seleccion= new ArrayList<>();;
	public ArrayList<CyclistDTO> getSeleccion() {
		return Seleccion;
	}
	public void setSeleccion(ArrayList<CyclistDTO> seleccion) {
		Seleccion = seleccion;
	}
	private JTable tabla2;
	private JScrollPane scrollExtra;
	private DefaultTableModel t_lista = null;
	private String nombresColmnas[] = { "ID","Name","Email","Gender","Nacionality","Hytory Equipment","Experience Age","Identification Card"};
	private JTable tabla;
	private JLabel lblTituloTabla;
	private String[][] datos,datos2;
    private String[] items= {"Id_Cicla","Name Team","Country. Team","Name. User's","Type User"};
    private int fil = 0;

    private DefaultTableModel modeloTabla; 
    private DefaultTableModel modeloTabla2; 
	
	public TeamSimulation() {
		setResizable(false);
		setTitle("Team Selection");
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Panel de Fondo
		
		panelFondo = new JPanel();
		panelFondo.setBounds(0, 0, 800, 700);
		panelFondo.setLayout(null);
		panelFondo.setBackground(new Color(95, 85, 110));
		
		
		
	datos = new String[fil][3];
	        modeloTabla = new DefaultTableModel(datos, items){
	            public boolean isCellEditable(int row, int column) {
	                return false;
	            }
	        };
	        datos2 = new String[fil][3];
	        modeloTabla2 = new DefaultTableModel(datos2, items){
	            public boolean isCellEditable(int row, int column) {
	                return false;
	            }
	        };
	        tabla = new JTable(modeloTabla);
	        tabla.getTableHeader().setReorderingAllowed(false);
	        tabla.getTableHeader().setFont(new Font("arial", Font.BOLD, 8));
	        
	        tabla2 = new JTable(modeloTabla2);
	        tabla2.getTableHeader().setReorderingAllowed(false);
	        tabla2.getTableHeader().setFont(new Font("arial", Font.BOLD, 8));

	        JScrollPane jsPanel = new JScrollPane(tabla);
	        jsPanel.setBounds(100, 100, 500, 200);
	        
	        JScrollPane jsPanel2 = new JScrollPane(tabla2);
	        jsPanel2.setBounds(100, 350, 500, 200);

	        panelFondo.add(jsPanel);
	        panelFondo.add(jsPanel2);
	        panelFondo.revalidate();

//		
		btnVolver = new JButton("Go Back");
		btnVolver.setBackground(new Color(223, 234, 231));
		btnVolver.setForeground(new Color(95, 85, 110));
		btnVolver.setBounds(600, 600, 150, 50);
		btnVolver.setFont(new Font("Arial", Font.BOLD, 20));
		panelFondo.add(btnVolver);
		
		btnStart = new JButton("START");
		btnStart.setBackground(new Color(223, 234, 231));
		btnStart.setForeground(new Color(95, 85, 110));
		btnStart.setBounds(300, 600, 150, 50);
		btnStart.setFont(new Font("Arial", Font.BOLD, 20));
		panelFondo.add(btnStart);
		
		btnSeleccion = new JButton(">");
		btnSeleccion.setBackground(new Color(223, 234, 231));
		btnSeleccion.setForeground(new Color(95, 85, 110));
		btnSeleccion.setBounds(250, 300, 50, 50);
		btnSeleccion.setFont(new Font("Arial", Font.BOLD, 20));
		panelFondo.add(btnSeleccion);
		
		btnDeseleccion = new JButton("<");
		btnDeseleccion.setBackground(new Color(223, 234, 231));
		btnDeseleccion.setForeground(new Color(95, 85, 110));
		btnDeseleccion.setBounds(350, 300, 50, 50);
		btnDeseleccion.setFont(new Font("Arial", Font.BOLD, 20));
		panelFondo.add(btnDeseleccion);
		
		lblImagen = new JLabel();
		lblImagen.setBounds(0, 0, 800, 700);
	    Image img = new ImageIcon("Image/fondote.jpg").getImage();
	    ImageIcon imgT = new ImageIcon(img.getScaledInstance(800, 700,Image.SCALE_SMOOTH));
	    lblImagen.setIcon(imgT);
	    panelFondo.add(lblImagen);		
		add(panelFondo);
}
public String[][] getDatos2() {
		return datos2;
	}
	public void setDatos2(String[][] datos2) {
		this.datos2 = datos2;
	}
public JButton getBtnSeleccion() {
		return btnSeleccion;
	}
	public void setBtnSeleccion(JButton btnSeleccion) {
		this.btnSeleccion = btnSeleccion;
	}
	public JButton getBtnDeseleccion() {
		return btnDeseleccion;
	}
	public void setBtnDeseleccion(JButton btnDeseleccion) {
		this.btnDeseleccion = btnDeseleccion;
	}
	public DefaultTableModel getModeloTabla2() {
		return modeloTabla2;
	}
	public void setModeloTabla2(DefaultTableModel modeloTabla2) {
		this.modeloTabla2 = modeloTabla2;
	}
public int getFil() {
		return fil;
	}
	public void setFil(int fil) {
		this.fil = fil;
	}
	public DefaultTableModel getModeloTabla() {
		return modeloTabla;
	}
	public void setModeloTabla(DefaultTableModel modeloTabla) {
		this.modeloTabla = modeloTabla;
	}	
	public void actualizarTabla() {
        modeloTabla.setDataVector(datos, items);
    }
	public void actualizarTabla2() {
        modeloTabla2.setDataVector(datos2, items);
    }
public DefaultTableModel getT_lista() {
		return t_lista;
	}
	

public JButton getBtnStart() {
	return btnStart;
}
public void setBtnStart(JButton btnStart) {
	this.btnStart = btnStart;
}
public JTable getTabla2() {
	return tabla2;
}
public void setTabla2(JTable tabla2) {
	this.tabla2 = tabla2;
}
public JScrollPane getScrollExtra() {
	return scrollExtra;
}

public void setScrollExtra(JScrollPane scrollExtra) {
	this.scrollExtra = scrollExtra;
}

	public void setT_lista(DefaultTableModel t_lista) {
		this.t_lista = t_lista;
	}
	public String[][] getDatos() {
		return datos;
	}
	public void setDatos(String[][] datos) {
		this.datos = datos;
	}
	public String[] getNombresColmnas() {
		return nombresColmnas;
	}
	public void setNombresColmnas(String[] nombresColmnas) {
		this.nombresColmnas = nombresColmnas;
	}
	public JTable getTabla() {
		return tabla;
	}
	public void setTabla(JTable tabla) {
		this.tabla = tabla;
	}
	public JLabel getLblTituloTabla() {
		return lblTituloTabla;
	}
	public void setLblTituloTabla(JLabel lblTituloTabla) {
		this.lblTituloTabla = lblTituloTabla;
	}
public String[] getItems() {
		return items;
	}
	public void setItems(String[] items) {
		this.items = items;
	}
	public JPanel getPanelFondo() {
		return panelFondo;
	}
	public void setPanelFondo(JPanel panelFondo) {
		this.panelFondo = panelFondo;
	}
	public JLabel getLblImagen() {
		return lblImagen;
	}
	public void setLblImagen(JLabel lblImagen) {
		this.lblImagen = lblImagen;
	}
	public JButton getBtnVolver() {
		return btnVolver;
	}
	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}

	
}
