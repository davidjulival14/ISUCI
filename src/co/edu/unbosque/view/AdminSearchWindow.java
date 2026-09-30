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

public class AdminSearchWindow extends JFrame{
	
	private JLabel lblTitulo;
	private JLabel lblMensaje;
	
	private JTextField txtDocumento;
	private JTextField txtNombre;
	private JTextField txtCorreo;
	private JComboBox<String> jComboBox3;
	private String[] rankList = { "                --SELECT YOUR RANK--", "Admin",};
	
	private JButton btnConfirmar;
	private JButton btnVolver;
	private JPanel panelFondo;
	private JLabel lblImagen;
	
	public AdminSearchWindow() {
//		setSize(800,700);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Update Cyclist");
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Panel de Fondo
		
		panelFondo = new JPanel();
		panelFondo.setBounds(0, 0, 800, 700);
		panelFondo.setLayout(null);
		panelFondo.setBackground(new Color(95, 85, 110));

		lblTitulo = new JLabel("<html>Create one only Admin");
		lblTitulo.setBounds(100, 30, 420, 80);
		lblTitulo.setBackground(new Color(223, 234, 231));
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 40));
		panelFondo.add(lblTitulo);
		
		lblMensaje = new JLabel("required fields* ");
		lblMensaje.setBounds(100, 90, 320, 40);
		lblMensaje.setBackground(new Color(223, 234, 231));
		lblMensaje.setForeground(Color.WHITE);
		lblMensaje.setFont(new Font("Arial", Font.BOLD, 16));
		panelFondo.add(lblMensaje);
		

		
		txtDocumento = new JTextField("            Identity Document Number *");
		txtDocumento.setBounds(200, 170, 400, 30);
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
		txtNombre.setBounds(200, 210, 400, 30);
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
		
		
		txtCorreo = new JTextField("                              e-mail *");
		txtCorreo.setBounds(200, 250, 400, 30);
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
		

		
		jComboBox3 = new JComboBox<String>();
		for(int i = 0; i < rankList.length; i++) {
			jComboBox3.addItem(rankList[i]);
		}
		jComboBox3.setFocusable(false);
		jComboBox3.setBounds(200, 290, 400, 30);
		jComboBox3.setFont(new Font("Arial", Font.BOLD, 20));
		panelFondo.add(jComboBox3);

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
	    Image img = new ImageIcon("Image/fondo.png").getImage();
	    ImageIcon imgT = new ImageIcon(img.getScaledInstance(800, 700,Image.SCALE_SMOOTH));
	    lblImagen.setIcon(imgT);
	    panelFondo.add(lblImagen);
		
		add(panelFondo);

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
