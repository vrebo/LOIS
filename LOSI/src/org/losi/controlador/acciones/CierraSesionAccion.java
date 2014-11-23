package org.losi.controlador.acciones;

import java.awt.Container;
import javax.swing.JOptionPane;

public class CierraSesionAccion extends Accion{

    @Override
    public void tarea(Container contenedor) {
        System.out.println("CerrarSesionAccion");
        JOptionPane.showConfirmDialog(contenedor, "¿De verdad desea cerrar sesión?");
    }
    
}
