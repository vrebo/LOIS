package losi.acciones;

import java.awt.Container;
import java.util.List;
import losi.vistas.catalogos.Catalogo;
import losi.vistas.componentes.PeliculaTableModel;
import org.losi.bo.Pelicula;

public class ActualizaCatPeliculaAccion extends Accion {

    @Override
    public void tarea(Container contenedor) {
            Catalogo catalogo = (Catalogo) contenedor;
            List<Pelicula> lista = servicios.catalogoPeliculas();
            PeliculaTableModel modelo = (PeliculaTableModel) catalogo.getjXTable().getModel();
            modelo.setData(lista);
    }

}
