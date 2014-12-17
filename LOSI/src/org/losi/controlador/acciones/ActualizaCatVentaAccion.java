package org.losi.controlador.acciones;

import java.awt.Container;
import java.util.List;
import org.losi.modelos.bo.Venta;
import org.losi.modelos.servicios.ServiciosLOIS;
import org.losi.vistas.catalogos.Catalogo;
import org.losi.vistas.componentes.VentaTableModel;

public class ActualizaCatVentaAccion extends Accion {

    @Override
    public void tarea(Container contenedor, Object... args) {
        Catalogo catalogo = (Catalogo) contenedor;
        List<Venta> lista = ServiciosLOIS.getServicios().catalogoVentas();
        VentaTableModel modelo = (VentaTableModel) catalogo.getjXTable().getModel();
        modelo.setData(lista);
    }

}
