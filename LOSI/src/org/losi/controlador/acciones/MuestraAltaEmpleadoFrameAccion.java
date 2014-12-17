package org.losi.controlador.acciones;

import java.awt.Container;
import org.losi.vistas.VistaPrincipal;
import org.losi.vistas.procesos.AltaEmpleadoFrame;

public class MuestraAltaEmpleadoFrameAccion extends Accion{

    @Override
    public void tarea(Container contenedor, Object... args) {
        VistaPrincipal vista = (VistaPrincipal) contenedor;
        AltaEmpleadoFrame frame = vista.getAltaEmpleadoFrame();
        if (frame.getDesktopPane() == null) {
            AltaEmpleadoFrame vFrame = new AltaEmpleadoFrame();
            vista.getjDesktopPane1().add(vFrame);
            vista.setAltaEmpleadoFrame(frame);
            frame = vFrame;
        }
        Accion.getAccion("MuestraInternalFrame").ejecutar(contenedor, frame);
    }
    
}
