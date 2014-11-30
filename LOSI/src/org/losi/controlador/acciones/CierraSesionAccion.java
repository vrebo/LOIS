package org.losi.controlador.acciones;

import java.awt.Container;
import javax.swing.JOptionPane;
import org.losi.vistas.VistaPrincipal;

public class CierraSesionAccion extends Accion{

    @Override
    public void tarea(Container contenedor, Object... args) {
        int opcion = JOptionPane.showConfirmDialog(contenedor, "¿De verdad desea cerrar sesión?");
        if(opcion == JOptionPane.OK_OPTION){
            VistaPrincipal vista = (VistaPrincipal)contenedor;
            vista.addComponentes();
        }
    }
    
}
