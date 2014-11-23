package losi.acciones;

import java.awt.Container;
import java.util.List;
import losi.vistas.catalogos.Catalogo;
import losi.vistas.componentes.EmpleadoTableModel;
import org.losi.bo.Empleado;

public class ActualizaCatEmpleadoAccion extends Accion{

    @Override
    public void tarea(Container contenedor) {
        Catalogo catalogo = (Catalogo)contenedor;
        List<Empleado> lista = servicios.catalogoEmpleados();
        EmpleadoTableModel modelo = (EmpleadoTableModel) catalogo.getjXTable().getModel();
        modelo.setData(lista);
    }
    
}
