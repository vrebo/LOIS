package org.losi.controlador.acciones;

import java.awt.Container;
import java.util.List;
import org.losi.vistas.catalogos.Catalogo;
import org.losi.vistas.componentes.ClienteTableModel;
import org.losi.modelos.bo.Cliente;
import org.losi.modelos.servicios.ServiciosLOIS;

public class ActualizaCatClienteAccion extends Accion{

    @Override
    public void tarea(Container contenedor, Object... args) {
        Catalogo catalogo = (Catalogo)contenedor;
        List<Cliente> lista = ServiciosLOIS.getServicios().catalogoClientes();
        ClienteTableModel modelo = (ClienteTableModel) catalogo.getjXTable().getModel();
        modelo.setData(lista);
    }

}
