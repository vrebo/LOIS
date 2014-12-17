package org.losi.controlador.acciones;

import java.awt.Container;
import org.losi.modelos.bo.CopiaPelicula;
import org.losi.vistas.componentes.MyTableModel;
import org.losi.vistas.procesos.VentaPanel;

public class EliminaCopiaAccion extends Accion {

    @Override
    public void tarea(Container contenedor, Object... args) {
        VentaPanel ventaPanel = (VentaPanel) contenedor;
        int row = ventaPanel.getjTable1().getSelectedRow();
        if (row != -1) {
            MyTableModel<CopiaPelicula> modelo = ((MyTableModel) ventaPanel.getjTable1().getModel());
            modelo.remove(row);
            Accion.getAccion("ActualizaTotalVenta").ejecutar(ventaPanel, ventaPanel.getVenta());
        }
    }
}
