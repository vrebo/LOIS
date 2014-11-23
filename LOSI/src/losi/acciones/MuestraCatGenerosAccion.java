package losi.acciones;

import java.awt.Container;
import losi.vistas.VistaPrincipal;
import losi.vistas.catalogos.Catalogo;

public class MuestraCatGenerosAccion extends Accion {

    @Override
    public void tarea(Container contenedor) {
        Catalogo catalogo = ((VistaPrincipal) contenedor).getGeneroCatalogo();
        catalogo.show();
        catalogo.toFront();
    }

}
