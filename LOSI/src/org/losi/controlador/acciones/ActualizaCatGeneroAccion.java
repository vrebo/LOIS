package org.losi.controlador.acciones;

import java.awt.Container;
import java.util.List;
import org.losi.vistas.catalogos.Catalogo;
import org.losi.vistas.componentes.GeneroTableModel;
import org.losi.modelos.bo.Genero;
import org.losi.modelos.servicios.ServiciosLOIS;

public class ActualizaCatGeneroAccion extends Accion{

    @Override
    public void tarea(Container contenedor, Object... args) {
        Catalogo catalogo = (Catalogo)contenedor;
        List<Genero> lista = ServiciosLOIS.getServicios().catalogoGeneros();
        GeneroTableModel modelo = (GeneroTableModel) catalogo.getjXTable().getModel();
        modelo.setData(lista);
    }
    
}
