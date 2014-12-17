package org.losi.controlador.acciones;

import java.awt.Container;
import org.losi.modelos.bo.Venta;
import org.losi.vistas.procesos.VentaPanel;

public class ActualizaTotalVentaAccion extends Accion {
    @Override
    public void tarea(Container contenedor, Object... args) {
        VentaPanel ventaPanel = (VentaPanel)contenedor;
        Venta venta = (Venta)args[0];
        venta.calculaNetoVenta();
        double netoVenta = venta.getNetoVenta();
        ventaPanel.setjLabelNetoVenta("$" + netoVenta);
    }
}
