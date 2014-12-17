package org.losi.controlador.acciones;

import java.awt.Container;
import org.losi.vistas.VistaPrincipal;
import org.losi.vistas.procesos.AltaClienteFrame;

public class MuestraAltaClienteFrameAccion extends Accion {

    @Override
    public void tarea(Container contenedor, Object... args) {
        VistaPrincipal vista = (VistaPrincipal) contenedor;
        AltaClienteFrame frame = vista.getAltaClienteFrame();
        if (frame.getDesktopPane() == null) {
            AltaClienteFrame vFrame = new AltaClienteFrame();
            vista.getjDesktopPane1().add(vFrame);
            vista.setAltaClienteFrame(frame);
            frame = vFrame;
        }
        Accion.getAccion("MuestraInternalFrame").ejecutar(contenedor, frame);
    }
}
