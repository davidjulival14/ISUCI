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

public class CyclistUpdateWindow extends JFrame{
	
	private JLabel lblTitulo;
	private JLabel lblMensaje;
	
	private JTextField txtDocumento;
	private JTextField txtNombre;
	private JTextField txtCorreo;
	private JTextField txtTarjetaId;
	private JTextField txtTiempoCarrera;
	private JTextField txtEspecialidad;
	private JTextField txtCadenciaPedaleo;
	private JTextField txtPeso;
	private JTextField txtAltura;
	private JTextField txtPosi;
	private JComboBox<String> jComboBox;
	private String[] tipoDocumento = { "                     Type of Document *", 
			"ID", "Passport" };
	
	private JComboBox<String> jComboBox2;
	private JComboBox<String> jComboBox3;
	private String[] rankList = { "               --SELECT YOUR RANK--", "Wheelers", "Sprinters", "Gregarious", "Climbers",
			"Classicomaniacs", "Time Trialist" };
	private String[] genero = { "                             Gender" , "Women", "Man" };
	
	private JButton btnConfirmar;
	private JButton btnVolver;
	private JPanel panelFondo;
	private JLabel lblImagen;
	
	public CyclistUpdateWindow() {
//		setSize(800,700);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Update Cyclist");
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Panel de Fondo
		
		panelFondo = new JPanel();
//		panelFondo.setBounds(0, 0, 800, 700);
		panelFondo.setLayout(null);
		panelFondo.setBackground(new Color(95, 85, 110));

		lblTitulo = new JLabel("<html>Update Cyclist");
		lblTitulo.setBounds(100, 20, 420, 80);
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 40));
		panelFondo.add(lblTitulo);
		
		lblMensaje = new JLabel("required fields* ");
		lblMensaje.setBounds(100, 80, 320, 40);
		lblMensaje.setForeground(Color.WHITE);
		lblMensaje.setFont(new Font("Arial", Font.BOLD, 16));
		panelFondo.add(lblMensaje);
		
		jComboBox = new JComboBox<String>();
		for(int i = 0; i < tipoDocumento.length; i++) {
			jComboBox.addItem(tipoDocumento[i]);
		}
		jComboBox.setFocusable(false);
		jComboBox.setBounds(200, 130, 400, 30);
		jComboBox.setBackground(new Color(0, 0, 0, 128)); // Gris con 50% de opacidad
		jComboBox.setForeground(Color.white);
		jComboBox.setFont(new Font("Arial", Font.BOLD, 20));
		panelFondo.add(jComboBox);
		
		txtDocumento = new JTextField("            Identity Document Number *");
		txtDocumento.setBounds(200, 170, 400, 30);
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
		txtNombre.setBounds(200, 210, 400, 30);
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
		jComboBox2.setBounds(200, 250, 400, 30);
		jComboBox2.setBackground(new Color(0, 0, 0, 100));
		jComboBox2.setForeground(Color.white);
		jComboBox2.setFont(new Font("Arial", 1, 20));
		panelFondo.add(jComboBox2);
		
		txtCorreo = new JTextField("                              e-mail *");
		txtCorreo.setBounds(200, 290, 400, 30);
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
		
		txtTarjetaId = new JTextField("                        Identification Card *");
		txtTarjetaId.setBounds(200, 330, 400, 30);
		txtTarjetaId.setBackground(Color.black); 
		txtTarjetaId.setForeground(Color.white);
		txtTarjetaId.setFont(new Font("Arial", 1, 20));
		panelFondo.add(txtTarjetaId);
		// Agregar un FocusListener al JTextField
		txtTarjetaId.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				// Verificar si el texto no ha sido modificado
				if (txtTarjetaId.getText().equals("                        Identification Card *")) {
					txtTarjetaId.setText("");
					txtTarjetaId.setForeground(Color.white);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// Verificar si el JTextField está vacío
				if (txtTarjetaId.getText().isEmpty()) {
					txtTarjetaId.setText("                        Identification Card *");
					txtTarjetaId.setForeground(Color.white);
				}
			}
		});
		
		txtTiempoCarrera = new JTextField("                  Race Time in seconds *");
		txtTiempoCarrera.setBounds(200, 370, 400, 30);
		txtTiempoCarrera.setBackground(Color.black); 
		txtTiempoCarrera.setForeground(Color.white);
		txtTiempoCarrera.setFont(new Font("Arial", 1, 20));
		panelFondo.add(txtTiempoCarrera);
		// Agregar un FocusListener al JTextField
		txtTiempoCarrera.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				// Verificar si el texto no ha sido modificado
				if (txtTiempoCarrera.getText().equals("                  Race Time in seconds *")) {
					txtTiempoCarrera.setText("");
					txtTiempoCarrera.setForeground(Color.white);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// Verificar si el JTextField está vacío
				if (txtTiempoCarrera.getText().isEmpty()) {
					txtTiempoCarrera.setText("                  Race Time in seconds *");
					txtTiempoCarrera.setForeground(Color.white);
				}
			}
		});
		
		jComboBox3 = new JComboBox<String>();
		for(int i = 0; i < rankList.length; i++) {
			jComboBox3.addItem(rankList[i]);
		}
		jComboBox3.setFocusable(false);
		jComboBox3.setBounds(200, 410, 400, 30);
		jComboBox3.setBackground(new Color(0, 0, 0, 100));
		jComboBox3.setForeground(Color.white);
		jComboBox3.setFont(new Font("Arial", Font.BOLD, 20));
		panelFondo.add(jComboBox3);
		
		
		txtCadenciaPedaleo = new JTextField("                     Pedaling Cadence *");
		txtCadenciaPedaleo.setBounds(200, 450, 400, 30);
		txtCadenciaPedaleo.setBackground(Color.black); 
		txtCadenciaPedaleo.setForeground(Color.white);
		txtCadenciaPedaleo.setFont(new Font("Arial", 1, 20));
		panelFondo.add(txtCadenciaPedaleo);
		// Agregar un FocusListener al JTextField
		txtCadenciaPedaleo.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				// Verificar si el texto no ha sido modificado
				if (txtCadenciaPedaleo.getText().equals("                     Pedaling Cadence *")) {
					txtCadenciaPedaleo.setText("");
					txtCadenciaPedaleo.setForeground(Color.white);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// Verificar si el JTextField está vacío
				if (txtCadenciaPedaleo.getText().isEmpty()) {
					txtCadenciaPedaleo.setText("                     Pedaling Cadence *");
					txtCadenciaPedaleo.setForeground(Color.white);
				}
			}
		});
		
		txtPeso = new JTextField("                            Weight *");
		txtPeso.setBounds(200, 490, 400, 30);
		txtPeso.setBackground(Color.black);
		txtPeso.setForeground(Color.white);
		txtPeso.setFont(new Font("", 1, 20));
		panelFondo.add(txtPeso);
		// Agregar un FocusListener al JTextField
		txtPeso.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				// Verificar si el texto no ha sido modificado
				if (txtPeso.getText().equals("                            Weight *")) {
					txtPeso.setText("");
					txtPeso.setForeground(Color.white);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// Verificar si el JTextField está vacío
				if (txtPeso.getText().isEmpty()) {
					txtPeso.setText("                            Weight *");
					txtPeso.setForeground(Color.white);
				}
			}
		});
		
		txtAltura = new JTextField("                            High *");
		txtAltura.setBounds(200, 530, 400, 30);
		txtAltura.setBackground(Color.black); 
		txtAltura.setForeground(Color.white);
		txtAltura.setFont(new Font("", 1, 20));
		panelFondo.add(txtAltura);
		// Agregar un FocusListener al JTextField
		txtAltura.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				// Verificar si el texto no ha sido modificado
				if (txtAltura.getText().equals("                            High *")) {
					txtAltura.setText("");
					txtAltura.setForeground(Color.white);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// Verificar si el JTextField está vacío
				if (txtAltura.getText().isEmpty()) {
					txtAltura.setText("                            High *");
					txtAltura.setForeground(Color.white);
				}
			}
		});
		
		txtPosi = new JTextField("                            Position *");
		txtPosi.setBounds(200, 570, 400, 30);
		txtPosi.setBackground(Color.black); 
		txtPosi.setForeground(Color.white);
		txtPosi.setFont(new Font("", 1, 20));
		panelFondo.add(txtPosi);
		// Agregar un FocusListener al JTextField
		txtPosi.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				// Verificar si el texto no ha sido modificado
				if (txtPosi.getText().equals("                            Position *")) {
					txtPosi.setText("");
					txtPosi.setForeground(Color.white);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// Verificar si el JTextField está vacío
				if (txtPosi.getText().isEmpty()) {
					txtPosi.setText("                            Position *");
					txtPosi.setForeground(Color.white);
				}
			}
		});
		
		
		
		btnConfirmar = new JButton("Update");
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
	    Image img = new ImageIcon("Image/ciclista.png").getImage();
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
	public String[] getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String[] tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public JComboBox<String> getjComboBox3() {
		return jComboBox3;
	}
	public void setjComboBox3(JComboBox<String> jComboBox3) {
		this.jComboBox3 = jComboBox3;
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
	public JTextField getTxtPosi() {
		return txtPosi;
	}
	public void setTxtPosi(JTextField txtPosi) {
		this.txtPosi = txtPosi;
	}
	public JComboBox<String> getjComboBox2() {
		return jComboBox2;
	}
	public void setjComboBox2(JComboBox<String> jComboBox2) {
		this.jComboBox2 = jComboBox2;
	}
	public String[] getRankList() {
		return rankList;
	}
	public void setRankList(String[] rankList) {
		this.rankList = rankList;
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
	public JTextField getTxtTarjetaId() {
		return txtTarjetaId;
	}
	public void setTxtTarjetaId(JTextField txtTarjetaId) {
		this.txtTarjetaId = txtTarjetaId;
	}
	public JTextField getTxtTiempoCarrera() {
		return txtTiempoCarrera;
	}
	public void setTxtTiempoCarrera(JTextField txtTiempoCarrera) {
		this.txtTiempoCarrera = txtTiempoCarrera;
	}
	public JTextField getTxtEspecialidad() {
		return txtEspecialidad;
	}
	public void setTxtEspecialidad(JTextField txtEspecialidad) {
		this.txtEspecialidad = txtEspecialidad;
	}
	public JTextField getTxtCadenciaPedaleo() {
		return txtCadenciaPedaleo;
	}
	public void setTxtCadenciaPedaleo(JTextField txtCadenciaPedaleo) {
		this.txtCadenciaPedaleo = txtCadenciaPedaleo;
	}
	public JTextField getTxtPeso() {
		return txtPeso;
	}
	public void setTxtPeso(JTextField txtPeso) {
		this.txtPeso = txtPeso;
	}
	public JTextField getTxtAltura() {
		return txtAltura;
	}
	public void setTxtAltura(JTextField txtAltura) {
		this.txtAltura = txtAltura;
	}

}
