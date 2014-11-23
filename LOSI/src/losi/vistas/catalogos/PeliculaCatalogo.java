package losi.vistas.catalogos;

import losi.vistas.componentes.PeliculaTableModel;

public class PeliculaCatalogo extends Catalogo{

    public PeliculaCatalogo() {
        super("Catálogo de Películas", "ActualizaCatPelicula", new PeliculaTableModel());
    }   
}