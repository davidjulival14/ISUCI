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

public class MainVideoWindow extends JFrame {

	private JPanel panelFondo;
	private JLabel lblImagen;
	private JButton btnInicioSesion;
	private JButton btnTurorial;
	private JButton btnSalir;

	public MainVideoWindow() {
		setResizable(false);
		setTitle("Main window");
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		panelFondo = new JPanel();
		panelFondo.setLayout(null);
		panelFondo.setBackground(new Color(95, 85, 110));

		btnInicioSesion = new JButton("");
		btnInicioSesion.setContentAreaFilled(false);
		btnInicioSesion.setBorderPainted(false);
		btnInicioSesion.setCursor(new Cursor(HAND_CURSOR));
		panelFondo.add(btnInicioSesion);

		btnTurorial = new JButton("");
		btnTurorial.setContentAreaFilled(false);
		btnTurorial.setBorderPainted(false);
		btnTurorial.setCursor(new Cursor(HAND_CURSOR));
		panelFondo.add(btnTurorial);

		btnSalir = new JButton("");
		btnSalir.setContentAreaFilled(false);
		btnSalir.setBorderPainted(false);
		btnSalir.setCursor(new Cursor(HAND_CURSOR));
		panelFondo.add(btnSalir);

		lblImagen = new JLabel();
		Image img = new ImageIcon("Image/inicio.png").getImage();
		ImageIcon imgT = new ImageIcon(img.getScaledInstance(800, 700, Image.SCALE_SMOOTH));
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

	public JButton getBtnInicioSesion() {
		return btnInicioSesion;
	}

	public void setBtnInicioSesion(JButton btnInicioSesion) {
		this.btnInicioSesion = btnInicioSesion;
	}

	public JButton getBtnTutorial() {
		return btnTurorial;
	}

	public void setBtnTutorial(JButton btnTutorial) {
		this.btnTurorial = btnTutorial;
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
