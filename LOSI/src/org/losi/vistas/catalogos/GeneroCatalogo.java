package org.losi.vistas.catalogos;

import org.losi.vistas.componentes.GeneroTableModel;

public class GeneroCatalogo extends Catalogo{

    public GeneroCatalogo() {
        super("Catálogo de generos", "ActualizaCatGenero", new GeneroTableModel());
    }
}
