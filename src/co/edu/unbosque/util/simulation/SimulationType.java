package co.edu.unbosque.util.simulation;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SimulationType extends JFrame{
	
	private JPanel panelFondo;
	private JLabel lblTitulo;
	private JLabel lblSubtitulo;
	private JLabel lblImagen;
	private JButton btnMountain;
	private JButton btnFWCurves;
	private JButton btnSemiFlat;
	private JButton btnSingleDay;
	private JButton btnExit;
	private JButton btnFlatStraight;
	
	public SimulationType() {
		setSize(800,700);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Simulation Type");
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        panelFondo = new JPanel();
        panelFondo.setBounds(0, 0, 800, 700);
        panelFondo.setLayout(null);
        panelFondo.setBackground(Color.BLACK);

        btnMountain= new JButton("");
        btnMountain.setBounds(95, 140, 110, 110);
        btnMountain.setContentAreaFilled(false);
        btnMountain.setBorderPainted(false);
        btnMountain.setCursor(new Cursor(HAND_CURSOR));
        btnMountain.setToolTipText("Enter a new window to add a teams");
        
        panelFondo.add(btnMountain);

        btnFWCurves = new JButton("");
        btnFWCurves.setBounds(600, 140, 110, 110);
        btnFWCurves.setContentAreaFilled(false);
        btnFWCurves.setBorderPainted(false);
        btnFWCurves.setCursor(new Cursor(HAND_CURSOR));
        btnFWCurves.setToolTipText("Enter a new window to delete a teams");
        
        panelFondo.add(btnFWCurves);

        btnSemiFlat = new JButton("");
        btnSemiFlat.setBounds(80, 380, 110, 110);
        btnSemiFlat.setContentAreaFilled(false);
        btnSemiFlat.setBorderPainted(false);
        btnSemiFlat.setCursor(new Cursor(HAND_CURSOR));
        btnSemiFlat.setToolTipText("Enter a new window to delete a teams");
        
        panelFondo.add(btnSemiFlat);

        btnSingleDay = new JButton("");
        btnSingleDay.setBounds(600, 380, 110, 110);
        btnSingleDay.setContentAreaFilled(false);
        btnSingleDay.setBorderPainted(false);
        btnSingleDay.setCursor(new Cursor(HAND_CURSOR));
        btnSingleDay.setToolTipText("Enter a new window to add user for teams");
        
        panelFondo.add(btnSingleDay);
        
        btnFlatStraight= new JButton("");
        btnFlatStraight.setBounds(350, 250, 110, 110);
        btnFlatStraight.setContentAreaFilled(false);
        btnFlatStraight.setBorderPainted(false);
        btnFlatStraight.setCursor(new Cursor(HAND_CURSOR));
        btnFlatStraight.setToolTipText("Enter a new window to show a carrer simulation");
        
        panelFondo.add(btnFlatStraight);

        btnExit = new JButton("Go Back");
        btnExit.setFont(new Font("Arial", Font.BOLD, 20));
        btnExit.setBounds(600, 600, 150, 50);
        btnExit.setForeground(Color.white);
        btnExit.setBackground(new Color(137, 142, 143));
        panelFondo.add(btnExit);
        
        lblImagen = new JLabel();
		lblImagen.setBounds(0, 0, 800, 700);
		Image img = new ImageIcon("Image/terreno.png").getImage();
		ImageIcon imgT = new ImageIcon(img.getScaledInstance(800,700,Image.SCALE_SMOOTH));
		lblImagen.setIcon(imgT);
		
		panelFondo.add(lblImagen);
		
        add(panelFondo);

    }

	public JButton getbtnFlatStraight() {
		return btnFlatStraight;
	}

	public void setbtnFlatStraight(JButton btnFlatStraight) {
		this.btnFlatStraight = btnFlatStraight;
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

	public JButton getbtnMountain() {
		return btnMountain;
	}

	public void setbtnMountain(JButton btnMountain) {
		this.btnMountain = btnMountain;
	}

	public JButton getbtnFWCurves() {
		return btnFWCurves;
	}

	public void setbtnFWCurves(JButton btnFWCurves) {
		this.btnFWCurves = btnFWCurves;
	}

	public JButton getbtnSemiFlat() {
		return btnSemiFlat;
	}

	public void setbtnSemiFlat(JButton btnSemiFlat) {
		this.btnSemiFlat = btnSemiFlat;
	}

	public JButton getbtnSingleDay() {
		return btnSingleDay;
	}

	public void setBtbtnSingleDay(JButton btnMostrar) {
		this.btnSingleDay = btnMostrar;
	}

	public JButton getBtnExit() {
		return btnExit;
	}

	public void setBtnExit(JButton btnExit) {
		this.btnExit = btnExit;
	}
	
}
		

