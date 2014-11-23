package losi.vistas.catalogos;

import losi.vistas.componentes.EmpleadoTableModel;

public class EmpleadoCatalogo extends Catalogo{

    public EmpleadoCatalogo() {
        super("Catálogo de empleados", "ActualizaCatEmpleado", new EmpleadoTableModel());
    }   
}
