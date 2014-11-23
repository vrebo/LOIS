package org.losi.controlador.acciones;

import java.awt.Container;
import java.util.List;
import org.losi.vistas.catalogos.Catalogo;
import org.losi.vistas.componentes.GeneroTableModel;
import org.losi.modelos.bo.Genero;

public class ActualizaCatGeneroAccion extends Accion{

    @Override
    public void tarea(Container contenedor) {
        Catalogo catalogo = (Catalogo)contenedor;
        List<Genero> lista = servicios.catalogoGeneros();
        GeneroTableModel modelo = (GeneroTableModel) catalogo.getjXTable().getModel();
        modelo.setData(lista);
    }
    
}
