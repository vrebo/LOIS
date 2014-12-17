package org.losi.controlador.acciones;

import java.awt.Container;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JOptionPane;
import org.losi.modelos.bo.Cliente;
import org.losi.modelos.servicios.ServiciosLOIS;
import org.losi.vistas.procesos.AltaClienteFrame;

public class AltaClienteAccion extends Accion {

    @Override
    public void tarea(Container contenedor, Object... args) {
        AltaClienteFrame frame = ((AltaClienteFrame) contenedor);
        HashMap<String, Object> datos = frame.getDatos();
        Cliente cliente = new Cliente();
        cliente.setIdCliente(getClave(datos));
        cliente.setNombre((String) datos.get("nombre"));
        cliente.setApellidoPaterno((String) datos.get("apellidopaterno"));
        cliente.setApellidoMaterno((String) datos.get("apellidomaterno"));
        cliente.setFechaNacimiento((String) datos.get("fechanacimiento"));
        cliente.setFechaRegistro("now()");
        if (ServiciosLOIS.getServicios().altaCliente(cliente)) {
            JOptionPane.showMessageDialog(frame, "Género registrado con éxito",
                    "Información", JOptionPane.INFORMATION_MESSAGE);
            frame.dispose();
        } else {
            System.out.println("Tu cliente da problemas chabo");
        }
    }

    public String getClave(HashMap<String, Object> datos) {
        String clave = "C";
        Date fecha = new Date();
        clave += fecha.getYear() + 1900;
        clave += fecha.getHours();
        clave += fecha.getMinutes();
        clave += fecha.getSeconds();
        return clave;
    }

}
