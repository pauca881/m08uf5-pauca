package vista;

import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class PanelRadioButtons extends JPanel{

    JRadioButton euro,dolar,peso,Yen,Dirham,Rublo;

  public PanelRadioButtons(){
      //2 filas 3 columnas
      this.setLayout(new GridLayout(2, 3));
      initComponents();
    
  }

    private void initComponents(){
    
    ButtonGroup grupo = new ButtonGroup();
        
        euro = new JRadioButton("Euros");
        dolar = new JRadioButton("Dolares");
        peso = new JRadioButton("Pesos");
        Yen = new JRadioButton("Yen");
        Dirham = new JRadioButton("Dirham");
        Rublo = new JRadioButton("Rublos");

        //Se agregan al JPanel PanelRadioButtons ( extends JPanel )
        this.add(euro);
        this.add(dolar);
        this.add(peso);
        this.add(Yen);
        this.add(Dirham);
        this.add(Rublo);

        //Se agregan al grupo de botones
        grupo.add(euro);
        grupo.add(dolar);
        grupo.add(peso);
        grupo.add(Yen);
        grupo.add(Dirham);
        grupo.add(Rublo);
        
    
    }

    //Encapsulamiento
    //Permite acceder a los botones. Por ejemplo:
    //JRadioButton botonEuro = panel.getEuro();
    //if (botonEuro.isSelected
    
    public JRadioButton getEuro() {
        return euro;
    }

    public JRadioButton getDolar() {
        return dolar;
    }

    public JRadioButton getPeso() {
        return peso;
    }

    public JRadioButton getYen() {
        return Yen;
    }

    public JRadioButton getDirham() {
        return Dirham;
    }

    public JRadioButton getRublo() {
        return Rublo;
    }
    



  
}//end
