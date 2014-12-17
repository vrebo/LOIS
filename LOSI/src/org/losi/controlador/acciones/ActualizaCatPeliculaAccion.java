package org.losi.controlador.acciones;

import java.awt.Container;
import java.util.List;
import org.losi.vistas.catalogos.Catalogo;
import org.losi.vistas.componentes.PeliculaTableModel;
import org.losi.modelos.bo.Pelicula;
import org.losi.modelos.servicios.ServiciosLOIS;

public class ActualizaCatPeliculaAccion extends Accion {

    @Override
    public void tarea(Container contenedor, Object... args) {
            Catalogo catalogo = (Catalogo) contenedor;
            List<Pelicula> lista = ServiciosLOIS.getServicios().catalogoPeliculas();
            PeliculaTableModel modelo = (PeliculaTableModel) catalogo.getjXTable().getModel();
            modelo.setData(lista);           
    }

}
