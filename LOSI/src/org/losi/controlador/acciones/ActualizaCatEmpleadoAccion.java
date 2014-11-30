package org.losi.controlador.acciones;

import java.awt.Container;
import java.util.List;
import org.losi.vistas.catalogos.Catalogo;
import org.losi.vistas.componentes.EmpleadoTableModel;
import org.losi.modelos.bo.Empleado;
import org.losi.modelos.servicios.ServiciosLOIS;

public class ActualizaCatEmpleadoAccion extends Accion{

    @Override
    public void tarea(Container contenedor, Object... args) {
        Catalogo catalogo = (Catalogo)contenedor;
        List<Empleado> lista = ServiciosLOIS.getServicios().catalogoEmpleados();
        EmpleadoTableModel modelo = (EmpleadoTableModel) catalogo.getjXTable().getModel();
        modelo.setData(lista);
    }
    
}
