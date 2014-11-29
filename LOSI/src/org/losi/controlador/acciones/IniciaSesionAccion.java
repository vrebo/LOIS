package org.losi.controlador.acciones;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import org.losi.vistas.VistaPrincipal;

public class IniciaSesionAccion extends Accion{

    @Override
    public void tarea(Container contenedor, Object... args) {
        System.out.println("IniciarSesionAccion");
        VistaPrincipal vista = (VistaPrincipal)contenedor;
        vista.setExtendedState(JFrame.MAXIMIZED_BOTH);
        vista.getJMenuBar().setVisible(true);
        vista.setContentPane(vista.getjDesktopPane1());
        vista.setMinimumSize(new Dimension(700, 600));
    }
    
}
