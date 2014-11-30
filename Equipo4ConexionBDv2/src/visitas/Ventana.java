
package visitas;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Ventana extends JFrame{
    
    public Ventana(String titulo, int ancho, int alto, VistaPlantilla vista){
        vista.setVentana(this);
        setTitle(titulo);
        setSize(ancho, alto);
        add(vista);
        setIconImage(new ImageIcon(getClass().getResource(
                        "/recursos/imagenes/elephant-32.png")).getImage());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}