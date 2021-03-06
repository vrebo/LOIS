package org.losi.vistas.componentes;

import java.awt.Container;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import org.losi.controlador.acciones.Accion;

public class BarraMenu extends JMenuBar {

    private JMenu jMenuSesion;
    private JMenu jMenuCatalogos;
    private JMenu jMenuProcesos;
    private JMenu jMenuReportes;
    private JMenu jMenuUtilerias;

    private final JMenuItem[] itemsMenuSesion = {
        //        new JMenuItem("Full Screen"),
        new JMenuItem("Salir")
    };

    private final JMenuItem[] itemsMenuCatalogo = {
        new JMenuItem("Clientes"),
        new JMenuItem("Empleados"),
        new JMenuItem("Pel�culas"),
        new JMenuItem("Copias de pel�culas"),
        new JMenuItem("Genero"),
        new JMenuItem("Venta")
    };

    private final JMenuItem[] itemsMenuProcesos = {
        new JMenuItem("Registro de venta"),
        new JMenuItem("Cambio de pel�cula")
    };
    
    private final JMenuItem[] itemsMenuAltas = {
        new JMenuItem("Clientes"),
        new JMenuItem("Empleados"),
        new JMenuItem("Pel�culas"),
        new JMenuItem("Copias de pel�culas"),
        new JMenuItem("Genero"),
    };

    private final JMenuItem[] itemsMenuModificaciones = {
        new JMenuItem("Clientes"),
        new JMenuItem("Empleados"),
        new JMenuItem("Pel�culas"),
        new JMenuItem("Copias de pel�culas"),
        new JMenuItem("Genero"),
    };

    private final JMenuItem[] itemsMenuBajas = {
        new JMenuItem("Clientes"),
        new JMenuItem("Empleados"),
        new JMenuItem("Pel�culas"),
        new JMenuItem("Copias de pel�culas"),
        new JMenuItem("Genero")
    };

    private final JMenuItem[] itemsMenuReporte = {
        new JMenuItem("Ventas mensuales"),
        new JMenuItem("Clientes"),
        new JMenuItem("Empleados"),
        new JMenuItem("Copias pel�cula"),
        new JMenuItem("Pel�culas"),
        new JMenuItem("Generos")
    };
    
    private final JMenuItem[] itemsMenuUtileria = {
        new JMenuItem("Respaldar"),
        new JMenuItem("Restaurar"),
        new JMenuItem("Bitacoras"),
        new JMenuItem("Alta de usuarios en LOIS")
    };

    private final String[] accionesItemsSesion = {
        //        "FullScreen",
        "CierraSesion"
    };

    private final String[] accionesItemsCatalogo = {
        "MuestraCatClientes",
        "MuestraCatEmpleados",
        "MuestraCatPeliculas",
        "MuestraCatCopias",
        "MuestraCatGeneros",
        "MuestraCatVentas"
    };

    private final String[] accionesItemsAltas = {
        "MuestraAltaClienteFrame",
        "MuestraAltaEmpleadoFrame",
        "MuestraAltaPeliculaFrame",
        "MuestraAltaClienteFrame",
        "MuestraAltaGeneroFrame"
    };
    
    private final String[] accionesItemsProceso = {
        "MuestraVentaFrame",
        "MuestraCambioFrame"
    };
    
    private final String[] accionesItemsReporte = {
        "MuestraVentaFrame",
        "ReporteClientes",
        "ReporteEmpleado",
        "ReporteCopia",
        "ReportePelicula",
        "ReporteGenero"
    };

    public BarraMenu(Container componente) {
        addComponentes();
        addEventos(componente);
    }

    private void addComponentes() {
        jMenuSesion = new JMenu("Sesi�n");
        jMenuCatalogos = new JMenu("Cat�logos");
        jMenuProcesos = new JMenu("Procesos");
        jMenuReportes = new JMenu("Reportes");
        jMenuUtilerias = new JMenu("Utiler�as");
        
        add(jMenuSesion);
        add(jMenuCatalogos);
        add(jMenuProcesos);
        add(jMenuReportes);
        add(jMenuUtilerias);
        setVisible(false);
        
        //Agregaci�n de los items al men� Sesi�n
        addComponentes(jMenuSesion, itemsMenuSesion, accionesItemsSesion);
        
        //Agregaci�n de los items al men� Cat�logo        
        addComponentes(jMenuCatalogos, itemsMenuCatalogo, accionesItemsCatalogo);
        
        //Agregaci�n de los items al men� Procesos

        JMenu mAltas = new JMenu("Altas");
        JMenu mModificaciones = new JMenu("Modificaciones");
        JMenu mBajas = new JMenu("Bajas");

        jMenuProcesos.add(mAltas);
        jMenuProcesos.addSeparator();
        jMenuProcesos.add(mModificaciones);
        jMenuProcesos.addSeparator();
        jMenuProcesos.add(mBajas);
        jMenuProcesos.addSeparator();
        
        addComponentes(mAltas, itemsMenuAltas, accionesItemsAltas);
                
        for (int i = 0; i < itemsMenuModificaciones.length; i++) {
            mModificaciones.add(itemsMenuModificaciones[i]);
//            itemsMenuCatalogo[i].setName(accionesItemsCatalogo[i]);
        }
        
         for (int i = 0; i < itemsMenuBajas.length; i++) {
            mBajas.add(itemsMenuBajas[i]);
//            itemsMenuCatalogo[i].setName(accionesItemsCatalogo[i]);
        }

        for (int i = 0; i < itemsMenuReporte.length; i++) {
            jMenuReportes.add(itemsMenuReporte[i]);
            itemsMenuReporte[i].setName(accionesItemsReporte[i]);
        }
        
        addComponentes(jMenuProcesos, itemsMenuProcesos, accionesItemsProceso);
               
        //Agregaci�n de los items al men� Sesi�n

        for (int i = 0; i < itemsMenuUtileria.length; i++) {
            jMenuUtilerias.add(itemsMenuUtileria[i]);
//            itemsMenuSesion[i].setName(accionesItemsSesion[i]);
        }
    }
    
    private void addComponentes(JMenu menu, JMenuItem[] items, String[] acciones){
        for (int i = 0; i < items.length; i++) {
            menu.add(items[i]);
            items[i].setName(acciones[i]);
        }
    }

    private void addEventos(Container contenedor) {
        
        addEventos(itemsMenuCatalogo, contenedor);
        
        addEventos(itemsMenuSesion, contenedor);
        
        addEventos(itemsMenuProcesos, contenedor);

        addEventos(itemsMenuAltas, contenedor);
        
        addEventos(itemsMenuReporte, contenedor);

    }
    
    private void addEventos(JMenuItem[] items, Container contenedor){
        for (JMenuItem jMenuItem : items) {
            jMenuItem.addActionListener((ActionEvent e) -> {
                String tipo = ((Container) e.getSource()).getName();
                Accion accion = Accion.getAccion(tipo);
                accion.ejecutar(contenedor);
            });
        }
    }

}
