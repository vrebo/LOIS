package org.losi.vistas.catalogos;

import org.losi.vistas.componentes.VentaTableModel;

public class VentaCatalogo extends Catalogo{

    public VentaCatalogo() {
        super("Cat�logo de ventas", "ActualizaCatVenta", new VentaTableModel());
    }
    
}
