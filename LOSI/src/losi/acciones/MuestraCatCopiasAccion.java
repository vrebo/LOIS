package losi.acciones;

import java.awt.Container;
import losi.vistas.VistaPrincipal;
import losi.vistas.catalogos.Catalogo;

public class MuestraCatCopiasAccion extends Accion{

    @Override
    public void tarea(Container contenedor) {
        Catalogo catalogo = ((VistaPrincipal)contenedor).getCopiaCatalogo();
        catalogo.show();
        catalogo.toFront();
    }
    
}
