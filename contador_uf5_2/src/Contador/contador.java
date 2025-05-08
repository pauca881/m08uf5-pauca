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
        
        // Crear JLabel
        label = new JLabel("Contador V1.0", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.PLAIN, 24));
        
        // Crear barra de menú
        menuBar = new JMenuBar();
        menu = new JMenu("Menú");
        menuItem = new JMenuItem("Carregar Contador");
        menu.add(menuItem);
        menuBar.add(menu);
        setJMenuBar(menuBar);
        
        menuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				carregar_contador_panell();				
			}
	
		});
        
        
 
    	
      	
        
        // Afegeix el JLabel a la finestra
        add(label, BorderLayout.NORTH);

        // Inicia amb un panell buit
        counterPanel = new JPanel();
        add(counterPanel, BorderLayout.CENTER);

        // Mostrar finestra
        setVisible(true);
        
        

    	
    	
    	
    }
	
    
    public static void main(String[] args) {
        new contador();
    }

	
}
