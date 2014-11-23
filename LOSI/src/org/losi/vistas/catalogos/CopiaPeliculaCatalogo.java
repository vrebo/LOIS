package org.losi.vistas.catalogos;

import org.losi.vistas.componentes.CopiaPeliculaTableModel;

public class CopiaPeliculaCatalogo extends Catalogo {

    public CopiaPeliculaCatalogo() {
        super("Catálogo de copias", "ActualizaCatCopiaPelicula", new CopiaPeliculaTableModel());
    }
}
