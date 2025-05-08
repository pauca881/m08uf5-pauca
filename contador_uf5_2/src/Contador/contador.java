package Contador;

import javax.swing.*;

import model.model_data;

import java.awt.*;
import java.awt.event.*;

public class contador extends JFrame {

	
    private JLabel label;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem menuItem;
    private JPanel counterPanel;
    private JButton incrementButton;
    private int contador;
    
    //model incrementar
    private model_data modeldata;

    public finestra_principal() {
    	
    	//configuració finestra principal
    	setTitle("Exercici contador M03 Pau");
    	setSize(400, 300);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	modeldata = new model_data();
        contador = 0;
        
        
    	
      	
    	
    	
    	
    }
	

	
}
