package org.losi.controlador.acciones;

import java.awt.Container;
import java.util.List;
import org.losi.modelos.bo.Genero;
import org.losi.modelos.servicios.ServiciosLOIS;
import org.losi.vistas.VistaPrincipal;
import org.losi.vistas.procesos.AltaPeliculaFrame;

public class MuestraAltaPeliculaFrameAccion extends Accion{

    @Override
    public void tarea(Container contenedor, Object... args) {
         VistaPrincipal vista = (VistaPrincipal) contenedor;
        AltaPeliculaFrame frame = vista.getAltaPeliculaFrame();
        if (frame.getDesktopPane() == null) {
            AltaPeliculaFrame vFrame = new AltaPeliculaFrame();
            vista.getjDesktopPane1().add(vFrame);
            vista.setAltaPeliculaFrame(frame);
            frame = vFrame;
        }
        List<Genero> generos = ServiciosLOIS.getServicios().catalogoGeneros();
        frame.setGeneros(generos);
        Accion.getAccion("MuestraInternalFrame").ejecutar(contenedor, frame);
    }
    
}
