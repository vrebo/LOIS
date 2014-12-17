package org.losi.controlador.acciones;

import java.awt.Container;
import org.losi.vistas.VistaPrincipal;
import org.losi.vistas.procesos.AltaGeneroFrame;

public class MuestraAltaGeneroFrameAccion extends Accion {

    @Override
    public void tarea(Container contenedor, Object... args) {
        VistaPrincipal vista = (VistaPrincipal) contenedor;
        AltaGeneroFrame frame = vista.getAltaGeneroFrame();
        if (frame.getDesktopPane() == null) {
            AltaGeneroFrame vFrame = new AltaGeneroFrame();
            vista.getjDesktopPane1().add(vFrame);
            vista.setAltaGeneroFrame(frame);
            frame = vFrame;
        }
        Accion.getAccion("MuestraInternalFrame").ejecutar(contenedor, frame);
    }

}
