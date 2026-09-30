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

public class DirectorDeleteWindow extends JFrame{
	
	private JTextField txtEliminarDoc;
	private JPanel panelFondo;
	private JLabel lblTitulo;
	private JLabel lblMensaje;
	private JLabel lblImagen;
	private JButton btnVolver;
	private JButton btnConfirmar;
	
	public DirectorDeleteWindow() {
		setResizable(false);
		setTitle("Director Delete");
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	//Panel de Fondo
		
		panelFondo = new JPanel();
		panelFondo.setLayout(null);
		panelFondo.setBackground(new Color(95, 85, 110));
		
		lblTitulo = new JLabel("Remove Director");
		lblTitulo.setBounds(190, 180, 420, 40);
		lblTitulo.setBackground(new Color(223, 234, 231));
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 50));
		panelFondo.add(lblTitulo);
		
		lblMensaje = new JLabel("Enter the Director ID to delete it:");
		lblMensaje.setBounds(210, 260, 380, 40);
		lblMensaje.setBackground(new Color(223, 234, 231));
		lblMensaje.setForeground(Color.WHITE);
		lblMensaje.setFont(new Font("Arial", Font.BOLD, 24));
		panelFondo.add(lblMensaje);
		
		txtEliminarDoc = new JTextField();
		txtEliminarDoc.setBounds(310, 320, 180, 30);
		txtEliminarDoc.setOpaque(false);
		txtEliminarDoc.setForeground(Color.white);
		txtEliminarDoc.setForeground(Color.white);
		txtEliminarDoc.setFont(new Font("Arial", Font.BOLD, 20));
		panelFondo.add(txtEliminarDoc);
		
		btnVolver = new JButton("Go Back");
		btnVolver.setBackground(new Color(223, 234, 231));
		btnVolver.setForeground(new Color(95, 85, 110));
		btnVolver.setFont(new Font("Arial", Font.BOLD, 20));
		panelFondo.add(btnVolver);
		
		btnConfirmar = new JButton("Delete");
		btnConfirmar.setBackground(new Color(223, 234, 231));
		btnConfirmar.setForeground(new Color(95, 85, 110));
		btnConfirmar.setFont(new Font("Arial", Font.BOLD, 20));
		panelFondo.add(btnConfirmar);
		
		lblImagen = new JLabel();
		lblImagen.setBounds(0, 0, 800, 700);
	    Image img = new ImageIcon("Image/director.png").getImage();
	    ImageIcon imgT = new ImageIcon(img.getScaledInstance(800, 700,Image.SCALE_SMOOTH));
	    lblImagen.setIcon(imgT);
	    panelFondo.add(lblImagen);
		
		add(panelFondo);
		
//		setVisible(true);
//		
	}
//	public static void main(String[] args) {
//		
//		new MasseuseDeleteWindow();
//
//		}
	public JTextField getTxtEliminarDoc() {
		return txtEliminarDoc;
	}
	public void setTxtEliminarDoc(JTextField txtEliminarDoc) {
		this.txtEliminarDoc = txtEliminarDoc;
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
	public JLabel getLblMensaje() {
		return lblMensaje;
	}
	public void setLblMensaje(JLabel lblMensaje) {
		this.lblMensaje = lblMensaje;
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
	public JButton getBtnConfirmar() {
		return btnConfirmar;
	}
	public void setBtnConfirmar(JButton btnConfirmar) {
		this.btnConfirmar = btnConfirmar;
	}
	
}
