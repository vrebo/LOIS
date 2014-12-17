package org.losi.controlador.acciones;

import java.awt.Container;
import org.losi.vistas.VistaPrincipal;
import org.losi.vistas.catalogos.Catalogo;

public class MuestraCatPeliculasAccion extends Accion{

    @Override
    public void tarea(Container contenedor, Object... args) {
        Catalogo catalogo = ((VistaPrincipal)contenedor).getPeliculaCatalogo();
        Accion.getAccion("MuestraInternalFrame").ejecutar(contenedor, catalogo);
        Accion.getAccion("ActualizaCatPelicula").ejecutar(catalogo);
    }
    
}
