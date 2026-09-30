package co.edu.unbosque.util.simulation;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.LinearGradientPaint;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import javax.swing.plaf.basic.BasicProgressBarUI;

public class SimulationWindow extends JFrame{
	
	private JPanel panelFondo;
	
	private JLabel lblTitulo;
	private JLabel lblImagen;
	private JButton btnExit,btnResult;
	private double porcentaje;
	public double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
	}

	private int x=0;
	private JProgressBar recorrido;
	
	public SimulationWindow() {
		setResizable(false);
		setTitle("Simulacion");
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		panelFondo = new JPanel();
		panelFondo.setLayout(null);
		panelFondo.setBackground(new Color(31, 254, 244));

		lblTitulo = new JLabel("<html> SIMULATION MOUNTAIN");
		lblTitulo.setBounds(250, 0, 750, 100);
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 28));
		lblTitulo.setForeground(Color.black);
		panelFondo.add(lblTitulo);
		
		btnExit = new JButton("Go Back");
        btnExit.setFont(new Font("Arial", Font.BOLD, 20));
        btnExit.setBounds(600, 600, 150, 50);
        btnExit.setForeground(Color.white);
        btnExit.setBackground(new Color(137, 142, 143));
        panelFondo.add(btnExit);
        
        btnResult = new JButton("Go Results");
        btnResult.setFont(new Font("Arial", Font.BOLD, 20));
        btnResult.setBounds(40, 600, 150, 50);
        btnResult.setForeground(Color.white);
        btnResult.setBackground(new Color(137, 142, 143));
        panelFondo.add(btnResult);
		
		recorrido = new JProgressBar();
		recorrido.setBounds(140, 470, 600, 30);
		
		
		lblImagen = new JLabel();
		Image img = new ImageIcon("Image/fondote.jpg").getImage();
		ImageIcon imgT = new ImageIcon(img.getScaledInstance(600, 400,Image.SCALE_SMOOTH));
		lblImagen.setIcon(imgT);
		panelFondo.add(lblImagen);
		
		add(panelFondo);
					
}

	public JButton getBtnResult() {
		return btnResult;
	}

	public void setBtnResult(JButton btnResult) {
		this.btnResult = btnResult;
	}

	public JButton getBtnExit() {
		return btnExit;
	}

	public void setBtnExit(JButton btnExit) {
		this.btnExit = btnExit;
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

	public JLabel getLblImagen() {
		return lblImagen;
	}

	public JProgressBar getRecorrido() {
		return recorrido;
	}

	public void setRecorrido(JProgressBar recorrido) {
		this.recorrido = recorrido;
	}

	public void setLblImagen(JLabel lblImagen) {
		this.lblImagen = lblImagen;
	}
	
	public void fill(int velocidad, JProgressBar jugador)
    {
		
		Timer t;
		ActionListener ac;
		jugador.setUI(new BasicProgressBarUI() {
			@Override
			protected void paintDeterminate(Graphics g, JComponent c) {
				Graphics2D g2d=(Graphics2D)g;
				int ancho=recorrido.getWidth();
				int alto=recorrido.getHeight();
				
				int espAlto=alto;
				int espAancho=ancho-10;
			
				
				porcentaje = jugador.getPercentComplete();
				espAancho=(int) (espAancho*porcentaje);
				
				Point2D inicio =new Point2D.Double(10,10);
				Point2D fin =new Point2D.Double(10,espAlto);
				float[] posicionGradiente = {0.1f,0.5f,0.9f};
				Color[] colores = {Color.black,Color.white,Color.black};
				
				LinearGradientPaint gradiente = new LinearGradientPaint(inicio, fin, posicionGradiente, colores);
				g2d.setPaint(gradiente);
				//g2d = bi.createGraphics();
				Rectangle progreso =new Rectangle(5, 5,espAancho,espAlto);
				g2d.fill(progreso);
				Image img = new ImageIcon("Image/IconCicla.png").getImage();
				ImageIcon imgT = new ImageIcon(img.getScaledInstance(alto, alto,Image.SCALE_SMOOTH));
				g2d.drawImage(imgT.getImage(), espAancho, 3, null);
			}
		});
		
		ac=new ActionListener() {
			int x=0;
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				x=x+1;
				jugador.setValue(x);
			}
		};
		t=new Timer(velocidad,ac);
		t.start();
    }
	

}
