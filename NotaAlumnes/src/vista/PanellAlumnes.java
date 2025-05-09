package vista;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.GestorAlumnesDAO;
import model.Persona;


public class PanellAlumnes extends JPanel {
	
	
	private GestorAlumnesDAO model;
	
	ActionListener listener;
	
	public PanellAlumnes(GestorAlumnesDAO modelo) {
		
		initComponents();
		
	}

	private void initComponents() {

		
		carregarDadesAlumnes();

		
	}

	private void carregarDadesAlumnes() {

		
	}
	
	

}
