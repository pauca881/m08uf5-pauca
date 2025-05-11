package Vista;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class PantallaImatges extends JFrame implements ActionListener {
	
    ActionListener listener;

	
    public PantallaImatges() {
        listener = this;
        setTitle("Canviador d’Imatges");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(new PanelPrincipal());
        carregaMenu();
    }

	private void carregaMenu() {

		 // Menú superior
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Opcions");

        JMenuItem opcioImatges = new JMenuItem("Mostrar Imatges");
        opcioImatges.setActionCommand("imagen");
        opcioImatges.addActionListener(listener);
        //opcioImatges.addActionListener(e -> cardLayout.show(panellPrincipal, "IMATGES"));

        JMenuItem opcioNoms = new JMenuItem("Mostrar Noms");
        opcioNoms.setActionCommand("noms");
        opcioNoms.addActionListener(listener);
        //opcioNoms.addActionListener(e -> cardLayout.show(panellPrincipal, "NOMS"));

        menu.add(opcioImatges);
        menu.add(opcioNoms);
        menuBar.add(menu);
        setJMenuBar(menuBar);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		//aquest mètode nadiu de ActionEvent torna un string del que fem als setActionCommand
		String action = e.getActionCommand();
		
        switch(action)
        {
            case "imagen":
                  this.setContentPane(new PanelPrincipal());
                  validate();
                break;
            case "noms":
                  this.setContentPane(new LlistaNoms());
                  validate();
                break;
        }

		
	}

}
