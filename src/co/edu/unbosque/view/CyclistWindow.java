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

public class CyclistWindow extends JFrame {

	private JPanel panelFondo;
	private JLabel lblTitulo;
	private JLabel lblSubtitulo;
	private JLabel lblImagen;
	private JButton btnCrear;
	private JButton btnExit;

	public CyclistWindow() {
		setSize(800, 700);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Cyclist Window");
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		panelFondo = new JPanel();
		panelFondo.setBounds(0, 0, 800, 700);
		panelFondo.setLayout(null);

		lblTitulo = new JLabel("Welcome to the Cyclist's menu");
		lblTitulo.setBounds(100, 80, 600, 40);
		lblTitulo.setForeground(Color.white);
//		lblTitulo.setBackground(new Color(174, 250, 200));
//		lblTitulo.setForeground(new Color(51, 156, 255 ));
		lblTitulo.setFont(new Font("Arial ", Font.BOLD, 35));

		panelFondo.add(lblTitulo);

		lblSubtitulo = new JLabel("Select the option you want to make: ");
		lblSubtitulo.setBounds(100, 150, 500, 40);
		lblSubtitulo.setBackground(new Color(174, 214, 241));
		lblSubtitulo.setForeground(Color.white);
		lblSubtitulo.setFont(new Font("Arial ", Font.BOLD, 25));

		panelFondo.add(lblSubtitulo);

		btnCrear = new JButton("");
		btnCrear.setContentAreaFilled(false);
		btnCrear.setBorderPainted(false);
		btnCrear.setCursor(new Cursor(HAND_CURSOR));
//		btnCrear.setBounds(100, 280, 300, 50);
		btnCrear.setToolTipText("Enter a new window to add a cyclist");

		panelFondo.add(btnCrear);

		btnExit = new JButton("Go Back");
		btnExit.setFont(new Font("Arial", Font.BOLD, 20));
		btnExit.setBounds(600, 600, 150, 50);
		btnExit.setForeground(Color.white);
		btnExit.setBackground(new Color(137, 142, 143));
		panelFondo.add(btnExit);

		lblImagen = new JLabel();
		lblImagen.setBounds(0, 0, 800, 700);
		Image img = new ImageIcon("Image/create.png").getImage();
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

	public JButton getBtnCrear() {
		return btnCrear;
	}

	public void setBtnCrear(JButton btnCrear) {
		this.btnCrear = btnCrear;
	}

	public JButton getBtnExit() {
		return btnExit;
	}

	public void setBtnExit(JButton btnExit) {
		this.btnExit = btnExit;
	}

}
