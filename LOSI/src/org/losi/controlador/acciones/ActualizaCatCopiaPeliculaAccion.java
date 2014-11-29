package org.losi.controlador.acciones;

import java.awt.Container;
import java.util.List;
import org.losi.vistas.catalogos.Catalogo;
import org.losi.vistas.componentes.CopiaPeliculaTableModel;
import org.losi.modelos.bo.CopiaPelicula;

public class ActualizaCatCopiaPeliculaAccion extends Accion {

    @Override
    public void tarea(Container contenedor, Object... args) {
        Catalogo catalogo = (Catalogo) contenedor;
        List<CopiaPelicula> lista = servicios.catalogoCopias();
        CopiaPeliculaTableModel modelo = (CopiaPeliculaTableModel) catalogo.getjXTable().getModel();
        modelo.setData(lista);
    }

}