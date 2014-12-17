package org.losi.controlador.acciones;

import java.awt.Container;
import javax.swing.JOptionPane;
import org.losi.modelos.bo.Venta;
import org.losi.modelos.servicios.ServiciosLOIS;
import org.losi.vistas.procesos.VentaFrame;
import org.losi.vistas.procesos.VentaPanel;

public class AltaVentaAccion extends Accion {
    
    @Override
    public void tarea(Container contenedor, Object... args) {
        VentaFrame ventaFrame = (VentaFrame)contenedor;
        VentaPanel ventaPanel = (VentaPanel)args[0];
        if (ventaPanel.isClienteFlag() && ventaPanel.isMontoFlag()) {
            Venta venta = ventaPanel.getVenta();
            venta.setFechaVenta("now()");
            if (ServiciosLOIS.getServicios().altaVenta(venta)) {
                JOptionPane.showMessageDialog(ventaPanel, "Venta registrada con éxito", 
                        "Información", JOptionPane.INFORMATION_MESSAGE);
                ventaFrame.dispose();
            }
        } else {
            System.out.println("tu venta no es valida chabo");
        }
    }
    
}
