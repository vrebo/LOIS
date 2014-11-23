package losi.vistas.catalogos;

import losi.vistas.componentes.GeneroTableModel;

public class GeneroCatalogo extends Catalogo{

    public GeneroCatalogo() {
        super("Catálogo de generos", "ActualizaCatGenero", new GeneroTableModel());
    }
}
