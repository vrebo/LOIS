package losi.vistas.catalogos;

import losi.vistas.componentes.CopiaPeliculaTableModel;

public class CopiaPeliculaCatalogo extends Catalogo {

    public CopiaPeliculaCatalogo() {
        super("Catálogo de copias", "ActualizaCatCopiaPelicula", new CopiaPeliculaTableModel());
    }
}
