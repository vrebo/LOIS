package losi.acciones;

import java.awt.Container;
import java.util.List;
import losi.vistas.catalogos.Catalogo;
import losi.vistas.componentes.ClienteTableModel;
import org.losi.bo.Cliente;

public class ActualizaCatClienteAccion extends Accion{

    @Override
    public void tarea(Container contenedor) {
        Catalogo catalogo = (Catalogo)contenedor;
        List<Cliente> lista = servicios.catalogoClientes();
        ClienteTableModel modelo = (ClienteTableModel) catalogo.getjXTable().getModel();
        modelo.setData(lista);
    }

}
