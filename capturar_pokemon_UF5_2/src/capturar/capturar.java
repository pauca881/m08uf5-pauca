package capturar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class capturar extends JFrame {

	
	//constructorJFrame
	public capturar() {
		
		setTitle("Canvi d'imatge");
		setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //aquest panell conté imatge i botó, es una clase container
        setContentPane(new PanellImatge());

		
		
	}
	
	
}
