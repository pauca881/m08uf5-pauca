package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Conversor extends JFrame {

	
	private JTextField textQuantitat;
	private JRadioButton euro_a_Dolar, dolar_a_Euro;
	private JButton botoConvertir;
	private JLabel labelResultat;
	
	
	public Conversor() {
		
	    setTitle("Conversor de Monedes Euro - Dòlar");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setSize(300, 300);
	    setLayout(new GridLayout(5, 1));
		
        textQuantitat = new JTextField();
        add(new JLabel("Introdueix la quantitat:"));
        add(textQuantitat);

        euro_a_Dolar = new JRadioButton("Euros a Dòlars");
        dolar_a_Euro = new JRadioButton("Dòlars a Euros");
        ButtonGroup grup = new ButtonGroup();
        grup.add(euro_a_Dolar);
        grup.add(dolar_a_Euro);
        
        
        JPanel panelRadio = new JPanel();
        panelRadio.add(euro_a_Dolar);
        panelRadio.add(dolar_a_Euro);
        add(panelRadio);
        
        botoConvertir = new JButton("Convertir");
        add(botoConvertir);
        
        labelResultat = new JLabel("Resultat: ");
        add(labelResultat);

	//actionlistener
	botoConvertir.addActionListener(new ActionListener(){


		
	}
        
		
	}
	
}
