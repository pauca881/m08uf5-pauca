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
	//especifica que ha de passar quan l'user fa una acció, com clicar el botó
		
	//override especifica estic sobreescribint mètode que ve d'una classe superior
	// ( actionlistener es una interficie que té el metode abstracte "actionPerformed" )
		
	//actionevent e es l'esdeveniment que passa quan l'usuari clica el botó
	// e conté info sobre hora, tipus acció, component que ho provoca, etc...

	//bàsicament: ActionListener és una interfície nativa de Java, que forma part del paquet java.awt.event
	// Només té un mètode: void actionPerformed(ActionEvent e)
		
	botoConvertir.addActionListener(new ActionListener(){
		//TO DO: ficar tot en un try per si el user no fica un num correcte
		@Override
		public void actionPerformed(ActionEvent e){

		    double quantitat = Double.parseDouble(textQuantitat.getText());
                    double resultat = 0.0;
                    String text = "";
		    double canvi = 1.09;

		    if(euro_a_Dolar.isSelected()){
			resultat = quantitat * canvi;
			//Format de string
			// .% posició on s'inserta el valor
			// 2f. Float amb 2 decimals
			text = String.format("%.2f € són %.2f $", quantitat, resultat);			    
		    }else if(dolar_a_Euro.isSelected()){
			resultat = quantitat / canvi;
			//Format de string
			// .% posició on s'inserta el valor
			// 2f. Float amb 2 decimals
			text = String.format("%.2f $ són %.2f €", quantitat, resultat);			    
		    }
	
		

			
		}
	
		
	}
        
		
	}
	
}
