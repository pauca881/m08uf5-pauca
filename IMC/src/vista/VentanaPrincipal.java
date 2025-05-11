package vista;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaPrincipal extends JFrame implements ActionListener {

    JTextField inpPes;
    JTextField inpAlt;
    JTextField inpIMC; 
    
    private ActionListener listener;

	
	public VentanaPrincipal() {
		
		
		listener = this;
        initComponents();
        crearMenu();
        this.setVisible(true);
		
	}


	private void crearMenu() {
		
        JMenuBar barra = new JMenuBar();
        JMenu menu = new JMenu("Principal");
        JMenuItem ventana = new JMenuItem("Ventana Calculo");
        ventana.setActionCommand("ventanaprincipal");
        ventana.addActionListener(listener);
        menu.add(ventana);
        JMenuItem exit = new JMenuItem("Exit...");
        menu.add(exit);
        JMenu menu2 = new JMenu("Calculos");
        JMenuItem calc = new JMenuItem("Calcular");
        menu2.add(calc);
        barra.add(menu);
        barra.add(menu2);
        this.setJMenuBar(barra);
        
		
	}


	private void initComponents() {

		 this.setTitle("Calculadora IMC");
	        this.setSize(300, 125);
	        
	        //falta centrar-ho al mig de la pantalla
	        this.setLocationRelativeTo(null); //centrar a la pantalla
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
	        carregarPanel();
		
		
	}


	private void carregarPanel() {

		this.setContentPane(new InitApp());
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {

		 String accion = e.getActionCommand();
	        switch(accion)
	        {
	            case "ventanaprincipal":
	                cambiarPanelPrincipal();
	                break;
	        }
		
	}


	private void cambiarPanelPrincipal() {


        this.setContentPane(new PanelPrincipal());
        this.validate();
        
   
	}
	
	
	
}
