package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class FinestraPrincipal extends JFrame implements ActionListener{

    JTextField textoentrada;
    PanelRadioButtons opciones_conversion;

    ActionListener listener;
    ActionListener lis1;

    //constructor
    public class FinestraPrincipal(String title){
    
    //todo entendre
    listener = this;

    //Cuando se pulse a un botón enlazado al actionListener lis1, se imprimirá esto
    lis1 = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            System.out.println("Soy independiente");
            
        }       
    };

        initComponents(title);
    
    }

    private void initComponents(String title){
        
        //this hace referenncia alm objeto actual, es decir, al JFrame   
        this.setTitle(title);
        this.setSize(80, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        afegirComponents();
        this.setVisible(true);        
    }

    // Components que estaràn dins la finestra
    private void afegirComponents(){

        disposicioConversorMoneda();
        crearMenu();

        
    }
    

  
}
