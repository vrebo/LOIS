package losi.vistas.catalogos;

import losi.vistas.componentes.ClienteTableModel;

public class ClienteCatalogo extends Catalogo{

    public ClienteCatalogo() {
        super("Catálogo de clientes", "ActualizaCatCliente", new ClienteTableModel());
    }
}
