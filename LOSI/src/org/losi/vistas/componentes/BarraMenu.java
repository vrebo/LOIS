package org.losi.vistas.componentes;

import java.awt.Container;
import java.awt.event.ActionEvent;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import org.losi.controlador.acciones.Accion;

public class BarraMenu extends JMenuBar {

    private JMenu jMenuSesion;
    private JMenu jMenuCatalogos;

    private final JMenuItem[]  itemsMenuSesion = {
        new JMenuItem("Iniciar"),
        new JMenuItem("Salir")
    };
    
    private final JMenuItem[] itemsMenuCatalogo = {
        new JMenuItem("Clientes"),
        new JMenuItem("Empleados"),
        new JMenuItem("Películas"),
        new JMenuItem("Copias de películas"),
        new JMenuItem("Genero")
    };
    
    private final String[] accionesItemsSesion = {
        "IniciaSesion",
        "CierraSesion"
    };
    
    private final String[] accionesItemsCatalogo = {
        "MuestraCatClientes",
        "MuestraCatEmpleados",
        "MuestraCatPeliculas",
        "MuestraCatCopias",
        "MuestraCatGeneros"
    };

    public BarraMenu(Container componente) {
        addComponentes();
        addEventos(componente);
    }

    private void addComponentes() {
        jMenuSesion = new JMenu("Sesión");
        jMenuCatalogos = new JMenu("Catálogos");
        
        add(jMenuSesion);
        add(jMenuCatalogos);
        setVisible(false);
        
        for (int i = 0; i < itemsMenuSesion.length; i++) {
            jMenuSesion.add(itemsMenuSesion[i]);
            itemsMenuSesion[i].setName(accionesItemsSesion[i]);
        }
        
        for (int i = 0; i < itemsMenuCatalogo.length; i++) {
            jMenuCatalogos.add(itemsMenuCatalogo[i]);
            itemsMenuCatalogo[i].setName(accionesItemsCatalogo[i]);
        }
    }

    private void addEventos(Container contenedor) {
        for (JMenuItem jMenuItem : itemsMenuCatalogo) {
            jMenuItem.addActionListener((ActionEvent e) -> {
                String tipo = ((Container) e.getSource()).getName();
                Accion accion = Accion.getAccion(tipo);
                accion.ejecutar(contenedor);
            });
        }
        for (JMenuItem jMenuItem : itemsMenuSesion) {
            jMenuItem.addActionListener((ActionEvent e) -> {
                String tipo = ((Container) e.getSource()).getName();
                Accion accion = Accion.getAccion(tipo);
                accion.ejecutar(contenedor);
            });
        }
    }

}
