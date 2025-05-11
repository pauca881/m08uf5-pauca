package vista;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


//JFrame: Ventana principal de una aplicación gráfica Swing. Contiene otros componentes.
//
//JPanel: Contenedor sin decoración que organiza y agrupa componentes dentro de un JFrame.
//
//JLabel: Etiqueta que muestra texto o imágenes estáticas (no editables) en la interfaz.
//
//JTextField: Campo de texto de una sola línea donde el usuario puede escribir.


public class InitApp extends JPanel {

	public InitApp() {
		
		initComponents();
		
	}

	private void initComponents() {

		String titulo = "CALCULADORA IMC V 1.0";
        this.setLayout(new BorderLayout());
        
        
        JLabel texto = new JLabel(titulo, SwingConstants.CENTER);
        //texto.setAlignmentX(CENTER_ALIGNMENT);
        this.add(texto);
        
		
	}
	
	
}
