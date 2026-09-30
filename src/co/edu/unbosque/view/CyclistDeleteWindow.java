/**
 * CyclistDeleteWindow.java
 *
 * This class represents a GUI window for deleting a cyclist. It allows the user to enter a cyclist's ID and 
 * confirm the deletion. The interface includes a background panel, title label, message label, text field for 
 * entering the ID, and buttons for confirming the deletion or going back.
 *
 * @version 1.0
 * @since 2024-05-19
 * 
 * @autor [Estefania Paredes]
 */

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

public class CyclistDeleteWindow extends JFrame {

    private JTextField txtEliminarDoc;  // Text field for entering the cyclist's ID to delete
    private JPanel panelFondo;          // Main panel for the window background
    private JLabel lblTitulo;           // Title label
    private JLabel lblMensaje;          // Message label
    private JLabel lblImagen;           // Background image label
    private JButton btnVolver;          // Button to go back to the previous window
    private JButton btnConfirmar;       // Button to confirm the deletion

    /**
     * Constructor for CyclistDeleteWindow.
     * Initializes the window components and layout.
     */
    public CyclistDeleteWindow() {
        setResizable(false);                  // Disables window resizing
        setTitle("Cyclist Delete");           // Sets the window title
        setLayout(null);                      // Disables the default layout manager
        setDefaultCloseOperation(EXIT_ON_CLOSE);  // Sets the default close operation

        // Initialize and set up the background panel
        panelFondo = new JPanel();
        panelFondo.setLayout(null);
        panelFondo.setBackground(new Color(95, 85, 110));  // Sets the background color of the panel

        // Initialize and set up the title label
        lblTitulo = new JLabel("Remove Cyclist");
        lblTitulo.setBounds(160, 160, 480, 40);  // Sets the position and size of the title label
        lblTitulo.setForeground(Color.WHITE);  // Sets the text color
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 50));  // Sets the font and size of the text
        panelFondo.add(lblTitulo);  // Adds the title label to the background panel

        // Initialize and set up the message label
        lblMensaje = new JLabel("Enter the Cyclist ID to delete it:");
        lblMensaje.setBounds(200, 280, 400, 40);  // Sets the position and size of the message label
        lblMensaje.setForeground(Color.WHITE);  // Sets the text color
        lblMensaje.setFont(new Font("Arial", Font.BOLD, 24));  // Sets the font and size of the text
        panelFondo.add(lblMensaje);  // Adds the message label to the background panel

        // Initialize and set up the text field for entering the cyclist's ID
        txtEliminarDoc = new JTextField();
        txtEliminarDoc.setBounds(310, 340, 180, 30);  // Sets the position and size of the text field
        txtEliminarDoc.setOpaque(false);// Sets the opaque property of the txtEliminarDoc JTextField to false, making it transparent.
		txtEliminarDoc.setForeground(Color.white);// Sets the text color of the txtEliminarDoc JTextField to white.
        panelFondo.add(txtEliminarDoc);  // Adds the text field to the background panel

        // Initialize and set up the "Go Back" button
        btnVolver = new JButton("Go Back");
        btnVolver.setBounds(220, 400, 150, 40);  // Sets the position and size of the button
        btnVolver.setBackground(new Color(223, 234, 231));  // Sets the background color of the button
        btnVolver.setForeground(new Color(95, 85, 110));  // Sets the text color of the button
        btnVolver.setFont(new Font("Arial", Font.BOLD, 20));  // Sets the font and size of the text
        panelFondo.add(btnVolver);  // Adds the button to the background panel

        // Initialize and set up the "Done" button
        btnConfirmar = new JButton("Done");
        btnConfirmar.setBounds(430, 400, 150, 40);  // Sets the position and size of the button
        btnConfirmar.setBackground(new Color(223, 234, 231));  // Sets the background color of the button
        btnConfirmar.setForeground(new Color(95, 85, 110));  // Sets the text color of the button
        btnConfirmar.setFont(new Font("Arial", Font.BOLD, 20));  // Sets the font and size of the text
        panelFondo.add(btnConfirmar);  // Adds the button to the background panel

        // Initialize and set up the background image label
        lblImagen = new JLabel();
        lblImagen.setBounds(0, 0, 800, 700);  // Sets the position and size of the image label
        Image img = new ImageIcon("Image/ciclista.png").getImage();  // Loads the background image
        ImageIcon imgT = new ImageIcon(img.getScaledInstance(800, 700, Image.SCALE_SMOOTH));  // Scales the image
        lblImagen.setIcon(imgT);  // Sets the icon of the image label to the scaled image
        panelFondo.add(lblImagen);  // Adds the image label to the background panel

        add(panelFondo);  // Adds the background panel to the frame
    }

    // Getter and setter methods for each component

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
