package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainWindow extends JFrame{
	
	private JPanel panelFondo;
	private JLabel lblTitulo;
	private JLabel lblImagen;
	private JButton btnInicioSesion;
	private JButton btnRegistro;
	private JButton btnAdmin;
	private JButton btnSalir;

	 public MainWindow() {
			setResizable(false);
			setTitle("Main window");
			setLayout(null);
			setDefaultCloseOperation(EXIT_ON_CLOSE);

			panelFondo = new JPanel();
			panelFondo.setLayout(null);
			panelFondo.setBackground(new Color(95, 85, 110));
//
//			lblTitulo = new JLabel("<html> INFORMATION SYSTEM OF THE UNION CYCLISTE INTERNATIONALE");
//			lblTitulo.setBounds(40, 200, 750, 100);
//			lblTitulo.setFont(new Font("Arial", Font.BOLD, 28));
//			lblTitulo.setForeground(Color.WHITE);
//			panelFondo.add(lblTitulo);

			btnInicioSesion = new JButton("Login");
			btnInicioSesion.setBackground(new Color(93, 109, 126)); 
			btnInicioSesion.setForeground(new Color(23, 32, 42));
			btnInicioSesion .setFont(new Font("Arial", Font.BOLD, 20));
			panelFondo.add(btnInicioSesion );
			
			btnRegistro = new JButton("Sign In");
			btnRegistro .setBackground(new Color(93, 109, 126));
			btnRegistro .setForeground(new Color(23, 32, 42));
			btnRegistro .setFont(new Font("Arial", Font.BOLD, 20));
			panelFondo.add(btnRegistro );
			
			btnAdmin = new JButton("Admin");
			btnAdmin .setBackground(new Color(93, 109, 126));
			btnAdmin .setForeground(new Color(23, 32, 42));
			btnAdmin .setFont(new Font("Arial", Font.BOLD, 20));
			panelFondo.add(btnAdmin );
			
			btnSalir = new JButton("Exit");
			btnSalir.setBackground(new Color(23, 32, 42));
			btnSalir.setForeground(Color.white);
			btnSalir.setFont(new Font("Arial", Font.BOLD, 20));
			panelFondo.add(btnSalir);
			
			lblImagen = new JLabel();
			Image img = new ImageIcon("Image/cover.png").getImage();
			ImageIcon imgT = new ImageIcon(img.getScaledInstance(800, 700,Image.SCALE_SMOOTH));
			lblImagen.setIcon(imgT);
			panelFondo.add(lblImagen);
			
			add(panelFondo);
						
	}

	public JPanel getPanelFondo() {
		return panelFondo;
	}

	public JButton getBtnAdmin() {
		return btnAdmin;
	}

	public void setBtnAdmin(JButton btnAdmin) {
		this.btnAdmin = btnAdmin;
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

	public JButton getBtnInicioSesion() {
		return btnInicioSesion;
	}

	public void setBtnInicioSesion(JButton btnInicioSesion) {
		this.btnInicioSesion = btnInicioSesion;
	}

	public JButton getBtnRegistro() {
		return btnRegistro;
	}

	public void setBtnRegistro(JButton btnRegistro) {
		this.btnRegistro = btnRegistro;
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}

	public void setBtnSalir(JButton btnSalir) {
		this.btnSalir = btnSalir;
	}
	public JLabel getLblImagen() {
		return lblImagen;
	}

	public void setLblImagen(JLabel lblImagen) {
		this.lblImagen = lblImagen;
	}
	
	}

