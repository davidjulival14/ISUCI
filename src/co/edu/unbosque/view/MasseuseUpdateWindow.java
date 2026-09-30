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

public class MasseuseUpdateWindow extends JFrame{
	
	private JLabel lblTitulo;
	private JLabel lblMensaje;
	
	private JTextField txtDocumento;
	private JTextField txtNombre;
	private JTextField txtCorreo;
	private JTextField txtPosi;
	private JTextField txtIdentificationCard;
	private JTextField txtMassage;
	private JTextField txtAniosExperiencia;

	private JComboBox<String> jComboBox;
	private String[] tipoDocumento = { "                     Type of Document *", 
			"ID", "Passport" };
	
	private JComboBox<String> jComboBox2;
	private String[] genero = { "                             Gender" , "Women", "Man" };
	
	private JButton btnConfirmar;
	private JButton btnVolver;
	private JPanel panelFondo;
	private JLabel lblImagen;
	
	public MasseuseUpdateWindow() {
//		setSize(800,700);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Update Masseuse");
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Panel de Fondo
		
		panelFondo = new JPanel();
//		panelFondo.setBounds(0, 0, 800, 700);
		panelFondo.setLayout(null);
		panelFondo.setBackground(new Color(95, 85, 110));

		lblTitulo = new JLabel("Update masseuse");
		lblTitulo.setBounds(100, 50, 420, 80);
		lblTitulo.setBackground(new Color(223, 234, 231));
		lblTitulo.setForeground(Color.black);
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 40));
		panelFondo.add(lblTitulo);
		
		lblMensaje = new JLabel("required fields* ");
		lblMensaje.setBounds(100, 100, 320, 40);
		lblMensaje.setBackground(new Color(223, 234, 231));
		lblMensaje.setForeground(Color.black);
		lblMensaje.setFont(new Font("Arial", Font.BOLD, 16));
		panelFondo.add(lblMensaje);
		
		jComboBox = new JComboBox<String>();
		for(int i = 0; i < tipoDocumento.length; i++) {
			jComboBox.addItem(tipoDocumento[i]);
		}
		jComboBox.setFocusable(false);
		jComboBox.setBounds(200, 170, 400, 30);
		jComboBox.setBackground(new Color(0, 0, 0, 128)); // Gris con 50% de opacidad
		jComboBox.setForeground(Color.white);
		jComboBox.setFont(new Font("Arial", Font.BOLD, 20));
		panelFondo.add(jComboBox);
		
		txtDocumento = new JTextField("            Identity Document Number *");
		txtDocumento.setBounds(200, 210, 400, 30);
		txtDocumento.setBackground(Color.black);
		txtDocumento.setForeground(Color.white);
		txtDocumento.setFont(new Font("Arial", 1, 20));
		txtDocumento.setToolTipText("Identity Document Number");
		panelFondo.add(txtDocumento);
		// Agregar un FocusListener al JTextField
		txtDocumento.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				// Verificar si el texto no ha sido modificado
				if (txtDocumento.getText().equals("            Identity Document Number *")) {
					txtDocumento.setText("");
					txtDocumento.setForeground(Color.white);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// Verificar si el JTextField está vacío
				if (txtDocumento.getText().isEmpty()) {
					txtDocumento.setText("            Identity Document Number *");
					txtDocumento.setForeground(Color.white);				}
			}
		});
		
		txtNombre = new JTextField("                              Name *");
		txtNombre.setBounds(200, 250, 400, 30);
		txtNombre.setBackground(Color.black);
		txtNombre.setForeground(Color.white);
		txtNombre.setFont(new Font("Arial", 1, 20));
		panelFondo.add(txtNombre);
		// Agregar un FocusListener al JTextField
		txtNombre.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				// Verificar si el texto no ha sido modificado
				if (txtNombre.getText().equals("                              Name *")) {
					txtNombre.setText("");
					txtNombre.setForeground(Color.white);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// Verificar si el JTextField está vacío
				if (txtNombre.getText().isEmpty()) {
					txtNombre.setText("                              Name *");
					txtNombre.setForeground(Color.white);	
				}
			}
		});
		
		jComboBox2 = new JComboBox<String>();
		for(int i = 0; i < genero.length; i++) {
			jComboBox2.addItem(genero[i]);
		}
		jComboBox2.setFocusable(false);
		jComboBox2.setBounds(200, 290, 400, 30);
		jComboBox2.setBackground(new Color(0, 0, 0, 128)); // Gris con 50% de opacidad
		jComboBox2.setForeground(Color.white);
		jComboBox2.setFont(new Font("Arial", 1, 20));
		panelFondo.add(jComboBox2);
		
		txtCorreo = new JTextField("                              e-mail *");
		txtCorreo.setBounds(200, 330, 400, 30);
		txtCorreo.setBackground(Color.black);
		txtCorreo.setForeground(Color.white);
		txtCorreo.setFont(new Font("Arial", 1, 20));
		panelFondo.add(txtCorreo);
		// Agregar un FocusListener al JTextField
		txtCorreo.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				// Verificar si el texto no ha sido modificado
				if (txtCorreo.getText().equals("                              e-mail *")) {
					txtCorreo.setText("");
					txtCorreo.setForeground(Color.white);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// Verificar si el JTextField está vacío
				if (txtCorreo.getText().isEmpty()) {
					txtCorreo.setText("                              e-mail *");
					txtCorreo.setForeground(Color.white);
				}
			}
		});
		
		txtIdentificationCard = new JTextField("                       Identification Card *");
		txtIdentificationCard.setBounds(200, 370, 400, 30);
		txtIdentificationCard.setBackground(Color.black);
		txtIdentificationCard.setForeground(Color.white);
		txtIdentificationCard.setFont(new Font("Arial", 1, 20));
		panelFondo.add(txtIdentificationCard);
		// Agregar un FocusListener al JTextField
		txtIdentificationCard.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				// Verificar si el texto no ha sido modificado
				if (txtIdentificationCard.getText().equals("                       Identification Card *")) {
					txtIdentificationCard.setText("");
					txtIdentificationCard.setForeground(Color.white);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// Verificar si el JTextField está vacío
				if (txtIdentificationCard.getText().isEmpty()) {
					txtIdentificationCard.setText("                       Identification Card *");
					txtIdentificationCard.setForeground(Color.white);
				}
			}
		});
		
		txtMassage = new JTextField("                    Massage Specialty *");
		txtMassage.setBounds(200, 410, 400, 30);
		txtMassage.setBackground(Color.black);
		txtMassage.setForeground(Color.white);
		txtMassage.setFont(new Font("Arial", 1, 20));
		panelFondo.add(txtMassage);
		// Agregar un FocusListener al JTextField
		txtMassage.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				// Verificar si el texto no ha sido modificado
				if (txtMassage.getText().equals("                    Massage Specialty *")) {
					txtMassage.setText("");
					txtMassage.setForeground(Color.white);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// Verificar si el JTextField está vacío
				if (txtMassage.getText().isEmpty()) {
					txtMassage.setText("                    Massage Specialty *");
					txtMassage.setForeground(Color.white);
				}
			}
		});
		
		txtAniosExperiencia = new JTextField("                   Years of experiencie *");
		txtAniosExperiencia.setBounds(200, 450, 400, 30);
		txtAniosExperiencia.setBackground(Color.black);
		txtAniosExperiencia.setForeground(Color.white);
		txtAniosExperiencia.setFont(new Font("Arial", 1, 20));
		panelFondo.add(txtAniosExperiencia);
		// Agregar un FocusListener al JTextField
		txtAniosExperiencia.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				// Verificar si el texto no ha sido modificado
				if (txtAniosExperiencia.getText().equals("                   Years of experiencie *")) {
					txtAniosExperiencia.setText("");
					txtAniosExperiencia.setForeground(Color.white);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// Verificar si el JTextField está vacío
				if (txtAniosExperiencia.getText().isEmpty()) {
					txtAniosExperiencia.setText("                   Years of experiencie *");
					txtAniosExperiencia.setForeground(Color.white);
				}
			}
		});
		
		txtPosi = new JTextField("                   Position *");
		txtPosi.setBounds(200, 490, 400, 30);
		txtPosi.setBackground(Color.black);
		txtPosi.setForeground(Color.white);
		txtPosi.setFont(new Font("Arial", 1, 20));
		panelFondo.add(txtPosi);
		// Agregar un FocusListener al JTextField
		txtPosi.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				// Verificar si el texto no ha sido modificado
				if (txtPosi.getText().equals("                   Position *")) {
					txtPosi.setText("");
					txtPosi.setForeground(Color.white);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// Verificar si el JTextField está vacío
				if (txtPosi.getText().isEmpty()) {
					txtPosi.setText("                   Position *");
					txtPosi.setForeground(Color.white);
				}
			}
		});
		
		btnConfirmar = new JButton("Done");
//		btnConfirmar.setBounds(430, 600, 150, 50);
		btnConfirmar.setBackground(new Color(223, 234, 231));
		btnConfirmar.setForeground(new Color(95, 85, 110));
		btnConfirmar.setFont(new Font("Arial", Font.BOLD, 20));
		panelFondo.add(btnConfirmar);
		
		btnVolver = new JButton("Go Back");
//		btnVolver.setBounds(600, 600, 150, 50);	
		btnVolver.setBackground(new Color(223, 234, 231));
		btnVolver.setForeground(new Color(95, 85, 110));
		btnVolver.setFont(new Font("Arial", Font.BOLD, 20));
		panelFondo.add(btnVolver);
		
		lblImagen = new JLabel();
//		lblImagen.setBounds(0, 0, 800, 700);
	    Image img = new ImageIcon("Image/masajista.png").getImage();
	    ImageIcon imgT = new ImageIcon(img.getScaledInstance(800, 700,Image.SCALE_SMOOTH));
	    lblImagen.setIcon(imgT);
	    panelFondo.add(lblImagen);
		
		add(panelFondo);
//		setVisible(true);
//	}
//	public static void main(String[] args) {
//		
//			new MasseuseCreateWindow();
	 	}
	public JTextField getTxtPosi() {
		return txtPosi;
	}
	public void setTxtPosi(JTextField txtPosi) {
		this.txtPosi = txtPosi;
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
	public JTextField getTxtIdentificationCard() {
		return txtIdentificationCard;
	}
	public void setTxtIdentificationCard(JTextField txtIdentificationCard) {
		this.txtIdentificationCard = txtIdentificationCard;
	}
	public JTextField getTxtMassage() {
		return txtMassage;
	}
	public void setTxtMassage(JTextField txtMassage) {
		this.txtMassage = txtMassage;
	}
	public JTextField getTxtAniosExperiencia() {
		return txtAniosExperiencia;
	}
	public void setTxtAniosExperiencia(JTextField txtAniosExperiencia) {
		this.txtAniosExperiencia = txtAniosExperiencia;
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
	public JComboBox<String> getjComboBox2() {
		return jComboBox2;
	}
	public void setjComboBox2(JComboBox<String> jComboBox2) {
		this.jComboBox2 = jComboBox2;
	}
	public String[] getGenero() {
		return genero;
	}
	public void setGenero(String[] genero) {
		this.genero = genero;
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
