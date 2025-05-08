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

    public contador() {
    	
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
    
    
    private void carregar_contador_panell() {
    	
    	
    	// Crear un nou JPanel amb botó
        counterPanel.removeAll();  // Neteja el panell existent
        counterPanel.setLayout(new FlowLayout());

        // Botó per incrementar el contador
        incrementButton = new JButton("Incrementar");
        incrementButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                contador = model_data.incrementar(contador);
                JOptionPane.showMessageDialog(null, "Contador: " + contador);
            }
        });

        // Afegir el botó al panell
        counterPanel.add(incrementButton);

        // Actualitza el panell
        counterPanel.revalidate();
        counterPanel.repaint();
    	
    	
    	
    	
    }
    
	
    
    public static void main(String[] args) {
        new contador();
    }

	
}
