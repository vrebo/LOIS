package losi.acciones;

import java.awt.Container;
import java.util.List;
import losi.vistas.catalogos.Catalogo;
import losi.vistas.componentes.GeneroTableModel;
import org.losi.bo.Genero;

public class ActualizaCatGeneroAccion extends Accion{

    @Override
    public void tarea(Container contenedor) {
        Catalogo catalogo = (Catalogo)contenedor;
        List<Genero> lista = servicios.catalogoGeneros();
        GeneroTableModel modelo = (GeneroTableModel) catalogo.getjXTable().getModel();
        modelo.setData(lista);
    }
    
}
