package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ArregloVentana extends JFrame{
	
	private JLabel lblTitulo;
	private JLabel lblMensaje;
	
	private JTextField txtDocumento;
	private JTextField txtNombre;
	private JTextField txtCorreo;

	private JComboBox<String> jComboBox;
	private String[] tipoDocumento = { "                     Type of Document *", 
			"ID", "Passport" };
	private String[] genero = { "                             Gender" , "Women", "Man" };
	private String[] tipoUsuario = { "                         Type of user*" ,"Cyclist", "Masseuse", "Director", "Administrator", "Other" };
	
	private JButton btnConfirmar;
	private JButton btnVolver;
	private JPanel panelFondo;
	private JLabel lblImagen;
	
	public ArregloVentana() {
		setSize(800,700);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Create Masseuse");
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Panel de Fondo
		
		panelFondo = new JPanel();
		panelFondo.setBounds(0, 0, 800, 700);
		panelFondo.setLayout(null);
		panelFondo.setBackground(new Color(95, 85, 110));

		lblTitulo = new JLabel("Sign in");
		lblTitulo.setBounds(100, 70, 420, 80);
		lblTitulo.setBackground(new Color(223, 234, 231));
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 40));
		panelFondo.add(lblTitulo);
		
		lblMensaje = new JLabel("required fields* ");
		lblMensaje.setBounds(100, 120, 320, 40);
		lblMensaje.setBackground(new Color(223, 234, 231));
		lblMensaje.setForeground(Color.WHITE);
		lblMensaje.setFont(new Font("Arial", Font.BOLD, 16));
		panelFondo.add(lblMensaje);
		
		jComboBox = new JComboBox<String>();
		for(int i = 0; i < tipoDocumento.length; i++) {
			jComboBox.addItem(tipoDocumento[i]);
		}
		jComboBox.setFocusable(false);
		jComboBox.setBounds(200, 210, 400, 30);
		jComboBox.setFont(new Font("Arial", Font.BOLD, 20));
		panelFondo.add(jComboBox);
		
		txtDocumento = new JTextField("            Identity Document Number *");
		txtDocumento.setBounds(200, 250, 400, 30);
		txtDocumento.setBackground(new Color(215, 219, 221));
		txtDocumento.setFont(new Font("Arial", 1, 20));
		panelFondo.add(txtDocumento);
//		txtDocumento.addFocusListener(new FocusListener() {
//		
//		@Override
//		public void focusLost(FocusEvent e) {
//		}
//		
//		@Override
//		public void focusGained(FocusEvent e) {
//			txtDocumento.setText("");
//		}
//		});
//		
		
		txtNombre = new JTextField("                              Name *");
		txtNombre.setBounds(200, 290, 400, 30);
		txtNombre.setBackground(new Color(215, 219, 221));
		txtNombre.setFont(new Font("", 1, 20));
		panelFondo.add(txtNombre);
		txtNombre.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				txtNombre.setText("");
			}
			});
		
		jComboBox = new JComboBox<String>();
		for(int i = 0; i < genero.length; i++) {
			jComboBox.addItem(genero[i]);
		}
		jComboBox.setFocusable(false);
		jComboBox.setBounds(200, 330, 400, 30);
		jComboBox.setFont(new Font("Arial", Font.BOLD, 20));
		panelFondo.add(jComboBox);
		
		txtCorreo = new JTextField("                              e-mail *");
		txtCorreo.setBounds(200, 370, 400, 30);
		txtCorreo.setBackground(new Color(215, 219, 221));
		txtCorreo.setFont(new Font("Arial", 1, 20));
		panelFondo.add(txtCorreo);
		txtCorreo.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				txtCorreo.setText("");
			}
			});
		
		jComboBox = new JComboBox<String>();
		for(int i = 0; i < tipoUsuario.length; i++) {
			jComboBox.addItem(tipoUsuario[i]);
		}
		jComboBox.setFocusable(false);
		jComboBox.setBounds(200, 410, 400, 30);
		jComboBox.setFont(new Font("Arial", Font.BOLD, 20));
		panelFondo.add(jComboBox);
		
		btnConfirmar = new JButton("Done");
		btnConfirmar.setBounds(430, 600, 150, 50);
		btnConfirmar.setBackground(new Color(223, 234, 231));
		btnConfirmar.setForeground(new Color(95, 85, 110));
		btnConfirmar.setFont(new Font("Arial", Font.BOLD, 20));
		panelFondo.add(btnConfirmar);
		
		btnVolver = new JButton("Go Back");
		btnVolver.setBounds(600, 600, 150, 50);	
		btnVolver.setBackground(new Color(223, 234, 231));
		btnVolver.setForeground(new Color(95, 85, 110));
		btnVolver.setFont(new Font("Arial", Font.BOLD, 20));
		panelFondo.add(btnVolver);
		
		lblImagen = new JLabel();
		lblImagen.setBounds(0, 0, 800, 700);
	    Image img = new ImageIcon("Image/Inicio.jpg").getImage();
	    ImageIcon imgT = new ImageIcon(img.getScaledInstance(800, 700,Image.SCALE_SMOOTH));
	    lblImagen.setIcon(imgT);
	    panelFondo.add(lblImagen);
		
		add(panelFondo);
		setVisible(true);
	}
	public static void main(String[] args) {
		
			new ArregloVentana();
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
	public JTextField getTxtDocumento() {
		return txtDocumento;
	}
	public void setTxtDocumento(JTextField txtDocumento) {
		this.txtDocumento = txtDocumento;
	}
	public JTextField getTxtNombre() {
		return txtNombre;
	}
	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}
	public JTextField getTxtCorreo() {
		return txtCorreo;
	}
	public void setTxtCorreo(JTextField txtCorreo) {
		this.txtCorreo = txtCorreo;
	}
	public JComboBox<String> getjComboBox() {
		return jComboBox;
	}
	public void setjComboBox(JComboBox<String> jComboBox) {
		this.jComboBox = jComboBox;
	}
	public String[] getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String[] tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String[] getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(String[] tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	public JButton getBtnConfirmar() {
		return btnConfirmar;
	}
	public void setBtnConfirmar(JButton btnConfirmar) {
		this.btnConfirmar = btnConfirmar;
	}
	public JButton getBtnVolver() {
		return btnVolver;
	}
	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
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
	
	

}
