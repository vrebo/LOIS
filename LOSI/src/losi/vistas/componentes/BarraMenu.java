package losi.vistas.componentes;

import java.awt.Container;
import java.awt.event.ActionEvent;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import losi.acciones.Accion;

public class BarraMenu extends JMenuBar {

    private JMenu jMenuCatalogos;
    private final JMenuItem[]  jMenuItems = {
        new JMenuItem("Clientes"),
        new JMenuItem("Empleados"),
        new JMenuItem("Películas"),
        new JMenuItem("Copias de películas"),
        new JMenuItem("Genero")
    };
    private final String [] names = {
        "MuestraCatClientes",
        "MuestraCatEmpleados",
        "MuestraCatPeliculas",
        "MuestraCatCopias",
        "MuestraCatGeneros"
    };

    public BarraMenu(Container componente){
        addComponentes();
        addEventos(componente);
    }
    
    private void addComponentes(){
        jMenuCatalogos = new JMenu("Catálogos");
        add(jMenuCatalogos);
        for (int i = 0; i < jMenuItems.length; i++) {
            jMenuCatalogos.add(jMenuItems[i]);
            jMenuItems[i].setName(names[i]);
        }
    }
    
    private void addEventos(Container componente){
        for (JMenuItem jMenuItem : jMenuItems) {
            jMenuItem.addActionListener((ActionEvent e) -> {
                String tipo = ((JComponent)e.getSource()).getName();
                Accion accion = Accion.getAccion(tipo);
                accion.ejecutar(componente);
            });
        }
    }

}

