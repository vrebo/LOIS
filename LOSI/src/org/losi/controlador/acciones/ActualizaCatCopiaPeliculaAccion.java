package org.losi.controlador.acciones;

import java.awt.Container;
import java.util.List;
import org.losi.vistas.catalogos.Catalogo;
import org.losi.vistas.componentes.CopiaPeliculaTableModel;
import org.losi.modelos.bo.CopiaPelicula;
import org.losi.modelos.servicios.ServiciosLOIS;

public class ActualizaCatCopiaPeliculaAccion extends Accion {

    @Override
    public void tarea(Container contenedor, Object... args) {
        Catalogo catalogo = (Catalogo) contenedor;
        List<CopiaPelicula> lista = ServiciosLOIS.getServicios().catalogoCopias();
        CopiaPeliculaTableModel modelo = (CopiaPeliculaTableModel) catalogo.getjXTable().getModel();
        modelo.setData(lista);
    }

}