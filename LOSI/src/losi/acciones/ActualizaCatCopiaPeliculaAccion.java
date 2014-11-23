package losi.acciones;

import java.awt.Container;
import java.util.List;
import losi.vistas.catalogos.Catalogo;
import losi.vistas.componentes.CopiaPeliculaTableModel;
import org.losi.bo.CopiaPelicula;

public class ActualizaCatCopiaPeliculaAccion extends Accion {

    @Override
    public void tarea(Container contenedor) {
        Catalogo catalogo = (Catalogo) contenedor;
        List<CopiaPelicula> lista = servicios.catalogoCopias();
        CopiaPeliculaTableModel modelo = (CopiaPeliculaTableModel) catalogo.getjXTable().getModel();
        modelo.setData(lista);
    }

}