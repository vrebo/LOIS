package org.losi.controlador.acciones;

import java.awt.Container;
import java.util.List;
import org.losi.vistas.catalogos.Catalogo;
import org.losi.vistas.componentes.ClienteTableModel;
import org.losi.modelos.bo.Cliente;

public class ActualizaCatClienteAccion extends Accion{

    @Override
    public void tarea(Container contenedor) {
        Catalogo catalogo = (Catalogo)contenedor;
        List<Cliente> lista = servicios.catalogoClientes();
        ClienteTableModel modelo = (ClienteTableModel) catalogo.getjXTable().getModel();
        modelo.setData(lista);
    }

}
