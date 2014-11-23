package org.losi.vistas.catalogos;

import org.losi.vistas.componentes.EmpleadoTableModel;

public class EmpleadoCatalogo extends Catalogo{

    public EmpleadoCatalogo() {
        super("Catálogo de empleados", "ActualizaCatEmpleado", new EmpleadoTableModel());
    }   
}
