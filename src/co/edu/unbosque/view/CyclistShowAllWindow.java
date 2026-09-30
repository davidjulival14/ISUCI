package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class CyclistShowAllWindow extends JFrame{
	
	private JPanel panelFondo;
	private JLabel lblImagen;
	private JButton btnVolver;
	private JTable tablaMilitarExtra;
	private JScrollPane scrollExtra;
	private DefaultTableModel t_lista = null;
	private String nombresColmnas[] = { "ID","Name","Email","Identification Card","Gender","Race Time","Speciality","Pedaling Cadence", "Height", "Weight"};
	private JTable tabla;
	private JLabel lblTituloTabla;
	private String[][] datos;

    private int fil = 0;

    private DefaultTableModel modeloTabla; 
	
	public CyclistShowAllWindow() {
		setResizable(false);
		setTitle("Show All Cyclists");
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Panel de Fondo
		
		panelFondo = new JPanel();
		panelFondo.setBounds(0, 0, 800, 700);
		panelFondo.setLayout(null);
		panelFondo.setBackground(new Color(95, 85, 110));
		
		
		
	datos = new String[fil][10];
	        modeloTabla = new DefaultTableModel(datos, nombresColmnas){
	            public boolean isCellEditable(int row, int column) {
	                return false;
	            }
	        };
	        tabla = new JTable(modeloTabla);
	        tabla.getTableHeader().setReorderingAllowed(false);
	        tabla.getTableHeader().setFont(new Font("arial", Font.BOLD, 8));

	        JScrollPane jsPanel = new JScrollPane(tabla);
	        jsPanel.setBounds(50, 150, 690, 400);

	        panelFondo.add(jsPanel);
	        panelFondo.revalidate();
		
		
		
		
		
		
		
		
		
//		panelFondo = new JPanel();
//		panelFondo.setBounds(0, 0, 800, 700);
//		panelFondo.setLayout(null);
//		panelFondo.setBackground(new Color(95, 85, 110));
//		
		btnVolver = new JButton("Go Back");
		btnVolver.setBackground(new Color(223, 234, 231));
		btnVolver.setForeground(new Color(95, 85, 110));
		btnVolver.setFont(new Font("Arial", Font.BOLD, 20));
		panelFondo.add(btnVolver);
		
		lblImagen = new JLabel();
		lblImagen.setBounds(0, 0, 800, 700);
	    Image img = new ImageIcon("Image/ciclista.png").getImage();
	    ImageIcon imgT = new ImageIcon(img.getScaledInstance(800, 700,Image.SCALE_SMOOTH));
	    lblImagen.setIcon(imgT);
	    panelFondo.add(lblImagen);
//	  
//	    lblTituloTabla = new JLabel("Director´s");
//		lblTituloTabla.setBounds(40, 40, 300, 40);
//		lblTituloTabla.setForeground(Color.WHITE);
//		lblTituloTabla.setFont(new Font("", 1, 30));
//
//		panelFondo.add(lblTituloTabla);
//
//		scrollExtra = new JScrollPane();
//		scrollExtra.setBounds(65, 129, 653, 409);
//		panelFondo.add(scrollExtra);
//
//		t_lista = new DefaultTableModel();
//		t_lista.setColumnIdentifiers(nombresColmnas);
//
//		tablaMilitarExtra = new JTable();
//		tablaMilitarExtra.setFont(new Font("Arial", Font.BOLD, 12));
//		tablaMilitarExtra.setModel(t_lista);
//
//		scrollExtra.setViewportView(tablaMilitarExtra);
//		panelFondo.revalidate();
		

		

		

	
		
		add(panelFondo);
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
	//		setVisible(true);
//		
	public void actualizarTabla() {
        modeloTabla.setDataVector(datos, nombresColmnas);
    }		
public DefaultTableModel getT_lista() {
		return t_lista;
	}
	public JTable getTablaMilitarExtra() {
	return tablaMilitarExtra;
}

public void setTablaMilitarExtra(JTable tablaMilitarExtra) {
	this.tablaMilitarExtra = tablaMilitarExtra;
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

	//	public static void main(String[] args) {
//		
//		new MasseuseShowAllWindow();
//
//		}
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