package losi.acciones;

import java.awt.Container;
import losi.vistas.VistaPrincipal;
import losi.vistas.catalogos.Catalogo;

public class MuestraCatClientesAccion extends Accion{

    @Override
    public void tarea(Container contenedor) {
        Catalogo catalogo = ((VistaPrincipal)contenedor).getClienteCatalogo();
        catalogo.show();
        catalogo.toFront();
    }
    
}
