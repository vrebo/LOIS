package org.losi.vistas.catalogos;

import org.losi.vistas.componentes.VentaTableModel;

public class VentaCatalogo extends Catalogo{

    public VentaCatalogo() {
        super("Catálogo de ventas", "ActualizaCatVenta", new VentaTableModel());
    }
    
}
