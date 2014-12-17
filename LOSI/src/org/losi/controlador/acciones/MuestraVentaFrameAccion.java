package org.losi.controlador.acciones;

import java.awt.Container;
import org.losi.vistas.VistaPrincipal;
import org.losi.vistas.componentes.MyInternalFrame;
import org.losi.vistas.procesos.VentaFrame;

public class MuestraVentaFrameAccion extends Accion {

    @Override
    public void tarea(Container contenedor, Object... args) {
        VistaPrincipal vista = (VistaPrincipal) contenedor;
        MyInternalFrame frame = vista.getVentaFrame();
        if (frame.getDesktopPane() == null) {
            VentaFrame vFrame = new VentaFrame();
            vista.getjDesktopPane1().add(vFrame);
            vista.setVentaFrame(vFrame);
            frame = vFrame;
        }
        Accion.getAccion("MuestraInternalFrame").ejecutar(contenedor, frame);
    }

}
