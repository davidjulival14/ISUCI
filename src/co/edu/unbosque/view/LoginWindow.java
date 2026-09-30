package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginWindow extends JFrame {
	
	private JPanel panelFondo;
	private JLabel lblSubtitulo;
	private JLabel lblUsuario;
	private JLabel lblContraseña;
	private JLabel lblImagen;
	private JTextField txtUsuario;
	private JTextField txtContrasena;
	private JButton btnIniciarSesion;
	private JButton btnVolver;
	
	public LoginWindow() {
		setResizable(false);
		setTitle("WindowLogin");
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		panelFondo = new JPanel();
		panelFondo.setLayout(null);
		panelFondo.setBackground(new Color(95, 85, 110));
		
		lblSubtitulo = new JLabel("Login");
		lblSubtitulo.setBounds(200, 180, 150, 60);
		lblSubtitulo.setFont(new Font("Arial", Font.BOLD, 50));
		lblSubtitulo.setForeground(Color.WHITE);
		panelFondo.add(lblSubtitulo);
		
		lblUsuario = new JLabel("User");
		lblUsuario.setBounds(200, 300, 150, 50);
		lblUsuario.setFont(new Font("Arial", Font.BOLD, 35));
		lblUsuario.setForeground(Color.WHITE);
		panelFondo.add(lblUsuario);
		
		lblContraseña = new JLabel("Password");
		lblContraseña.setBounds(200, 370, 250, 50);
		lblContraseña .setFont(new Font("Arial", Font.BOLD, 35));
		lblContraseña .setForeground(Color.WHITE);
		panelFondo .add(lblContraseña );
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(400, 300, 150, 50);
		txtUsuario.setBackground(Color.black);
		txtUsuario .setForeground(Color.WHITE);
		txtUsuario.setOpaque(false);
		txtUsuario.setFont(new Font("Arial ", Font.BOLD, 20));
		
		panelFondo.add(txtUsuario);
		
		txtContrasena= new JTextField();
		txtContrasena.setBounds(400, 370, 150, 50);
		txtContrasena.setBackground(Color.black);
		txtContrasena .setForeground(Color.WHITE);
		txtContrasena.setOpaque(false);
		txtContrasena.setFont(new Font("Arial ", Font.BOLD, 20));
		
		panelFondo.add(txtContrasena);
		
		btnIniciarSesion = new JButton("Login");
		btnIniciarSesion.setBackground(new Color(223, 234, 231));
		btnIniciarSesion.setForeground(new Color(95, 85, 110));
		btnIniciarSesion.setFont(new Font("Arial", Font.BOLD, 20));
		panelFondo.add(btnIniciarSesion);
		
		btnVolver = new JButton("Go Back");
		btnVolver.setBackground(new Color(223, 234, 231));
		btnVolver.setForeground(new Color(95, 85, 110));
		btnVolver.setFont(new Font("Arial", Font.BOLD, 20));
		panelFondo.add(btnVolver);
		
		lblImagen = new JLabel();
		lblImagen.setBounds(0, 0, 800, 700);
		Image img = new ImageIcon("Image/fondote.jpg").getImage();
		ImageIcon imgT = new ImageIcon(img.getScaledInstance(800, 700,Image.SCALE_SMOOTH));
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

	public JLabel getLblSubtitulo() {
		return lblSubtitulo;
	}

	public void setLblSubtitulo(JLabel lblSubtitulo) {
		this.lblSubtitulo = lblSubtitulo;
	}

	public JLabel getLblUsuario() {
		return lblUsuario;
	}

	public void setLblUsuario(JLabel lblUsuario) {
		this.lblUsuario = lblUsuario;
	}

	public JLabel getLblContraseña() {
		return lblContraseña;
	}

	public void setLblContraseña(JLabel lblContraseña) {
		this.lblContraseña = lblContraseña;
	}

	public JLabel getLblImagen() {
		return lblImagen;
	}

	public void setLblImagen(JLabel lblImagen) {
		this.lblImagen = lblImagen;
	}

	public JTextField getTxtUsuario() {
		return txtUsuario;
	}

	public void setTxtUsuario(JTextField txtUsuario) {
		this.txtUsuario = txtUsuario;
	}

	public JTextField getTxtContrasena() {
		return txtContrasena;
	}

	public void setTxtContraseña(JTextField txtContrasena) {
		this.txtContrasena = txtContrasena;
	}

	public JButton getBtnIniciarSesion() {
		return btnIniciarSesion;
	}

	public void setBtnIniciarSesion(JButton btnIniciarSesion) {
		this.btnIniciarSesion = btnIniciarSesion;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}

	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}

}
