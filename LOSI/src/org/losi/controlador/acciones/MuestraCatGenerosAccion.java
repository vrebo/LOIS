package org.losi.controlador.acciones;

import java.awt.Container;
import org.losi.vistas.VistaPrincipal;
import org.losi.vistas.catalogos.Catalogo;

public class MuestraCatGenerosAccion extends Accion {

    @Override
    public void tarea(Container contenedor) {
        Catalogo catalogo = ((VistaPrincipal) contenedor).getGeneroCatalogo();
        catalogo.show();
        catalogo.toFront();
    }

}
