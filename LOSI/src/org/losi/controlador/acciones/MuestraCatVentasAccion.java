package org.losi.controlador.acciones;

import java.awt.Container;
import org.losi.vistas.VistaPrincipal;
import org.losi.vistas.catalogos.Catalogo;

public class MuestraCatVentasAccion extends Accion{

    @Override
    public void tarea(Container contenedor, Object... args) {
        Catalogo catalogo = ((VistaPrincipal)contenedor).getVentaCatalogo();
        Accion.getAccion("MuestraInternalFrame").ejecutar(contenedor, catalogo);
        Accion.getAccion("ActualizaCatVenta").ejecutar(catalogo);
    }
    
}
