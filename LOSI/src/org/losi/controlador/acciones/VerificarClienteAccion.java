package org.losi.controlador.acciones;

import java.awt.Container;
import javax.swing.JLabel;
import javax.swing.JTextField;
import org.losi.modelos.bo.Cliente;
import org.losi.modelos.bo.Empleado;
import org.losi.modelos.servicios.ServiciosLOIS;
import org.losi.vistas.procesos.VentaPanel;

public class VerificarClienteAccion extends Accion {

    @Override
    public void tarea(Container contenedor, Object... args) {
        VentaPanel ventaPanel = (VentaPanel) contenedor;
        JTextField codigoCliente = (JTextField) args[0];
        JLabel etiquetaCliente = (JLabel) args[1];
        String idCliente = codigoCliente.getText();
        Cliente cliente = ServiciosLOIS.getServicios().buscaClientePorID(idCliente);
        String texto;
        boolean flag = false;
        if (cliente != null) {
            texto = cliente.getNombre() + " " + cliente.getApellidoPaterno();
            ventaPanel.getVenta().setCliente(cliente);
            Empleado e = new Empleado();
            e.setIdEmpleado("E001");
            ventaPanel.getVenta().setEmpleado(e);
            flag = true;
        } else {
            texto = "Cliente no encontrado";
        }
        etiquetaCliente.setText(texto);
        ventaPanel.setClienteFlag(flag);
    }
}
