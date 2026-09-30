package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DirectorWindowLogin extends JFrame{
	
	private JPanel panelFondo;
	private JLabel lblTitulo;
	private JLabel lblSubtitulo;
	private JLabel lblImagen;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JButton btnMostrar;
	private JButton btnExit;
	
	public DirectorWindowLogin() {
		setSize(800,700);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Director Window");
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        panelFondo = new JPanel();
        panelFondo.setBounds(0, 0, 800, 700);
        panelFondo.setLayout(null);
        panelFondo.setBackground(Color.BLACK);
        
        lblTitulo = new JLabel("Welcome to the Director's menu");
		lblTitulo.setBounds(100,70,600,40);
		lblTitulo.setBackground(new Color (174, 250, 200));
		lblTitulo.setForeground(Color.white);
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 35));
		
		panelFondo.add(lblTitulo);
		
		lblSubtitulo= new JLabel("Select the option you want to make: ");
		lblSubtitulo.setBounds(100,150,500,40);
		lblSubtitulo.setForeground(Color.white);
		lblSubtitulo.setBackground(new Color (174, 214, 241));
		lblSubtitulo.setFont(new Font("Arial", Font.BOLD, 25));
		
		panelFondo.add(lblSubtitulo);

		btnActualizar = new JButton("");
		btnActualizar.setBounds(170, 310, 110, 110);
		btnActualizar.setContentAreaFilled(false);
		btnActualizar.setBorderPainted(false);
		btnActualizar.setCursor(new Cursor(HAND_CURSOR));
		btnActualizar.setToolTipText("Enter a new window to update a cyclist");

		panelFondo.add(btnActualizar);

		btnEliminar = new JButton("");
		btnEliminar.setBounds(345, 310, 110, 110);
		btnEliminar.setContentAreaFilled(false);
		btnEliminar.setBorderPainted(false);
		btnEliminar.setCursor(new Cursor(HAND_CURSOR));
		btnEliminar.setToolTipText("Enter a new window to delete a cyclist");

		panelFondo.add(btnEliminar);

		btnMostrar = new JButton("");
		btnMostrar.setBounds(515, 310, 110, 110);
		btnMostrar.setContentAreaFilled(false);
		btnMostrar.setBorderPainted(false);
		btnMostrar.setCursor(new Cursor(HAND_CURSOR));
		btnMostrar.setToolTipText("Enter a new window to show all the cyclist");

		panelFondo.add(btnMostrar);

        btnExit = new JButton("Close Sesion");
        btnExit.setFont(new Font("Arial", Font.BOLD, 20));
        btnExit.setBounds(600, 600, 150, 50);
        btnExit.setForeground(Color.white);
        btnExit.setBackground(new Color(137, 142, 143));
        panelFondo.add(btnExit);
        
        lblImagen = new JLabel();
		lblImagen.setBounds(0, 0, 800, 700);
		Image img = new ImageIcon("Image/crud.png").getImage();
		ImageIcon imgT = new ImageIcon(img.getScaledInstance(800,700,Image.SCALE_SMOOTH));
		lblImagen.setIcon(imgT);
		
		panelFondo.add(lblImagen);
		
        add(panelFondo);
        
    }

	public JPanel getPanelFondo() {
		return panelFondo;
	}

	public void setPanelFondo(JPanel panelFondo) {
		this.panelFondo = panelFondo;
	}

	public JLabel getLblTitulo() {
		return lblTitulo;
	}

	public void setLblTitulo(JLabel lblTitulo) {
		this.lblTitulo = lblTitulo;
	}

	public JLabel getLblSubtitulo() {
		return lblSubtitulo;
	}

	public void setLblSubtitulo(JLabel lblSubtitulo) {
		this.lblSubtitulo = lblSubtitulo;
	}

	public JLabel getLblImagen() {
		return lblImagen;
	}

	public void setLblImagen(JLabel lblImagen) {
		this.lblImagen = lblImagen;
	}

	public JButton getBtnActualizar() {
		return btnActualizar;
	}

	public void setBtnActualizar(JButton btnActualizar) {
		this.btnActualizar = btnActualizar;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}

	public JButton getBtnMostrar() {
		return btnMostrar;
	}

	public void setBtnMostrar(JButton btnMostrar) {
		this.btnMostrar = btnMostrar;
	}

	public JButton getBtnExit() {
		return btnExit;
	}

	public void setBtnExit(JButton btnExit) {
		this.btnExit = btnExit;
	}
	
	
	 public static void main (String[] args) {
		 new DirectorWindowLogin();
	 }
	
	
	}
		

