package org.losi.controlador.acciones;

import java.awt.Container;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JOptionPane;
import org.losi.modelos.bo.Empleado;
import org.losi.modelos.servicios.ServiciosLOIS;
import org.losi.vistas.procesos.AltaEmpleadoFrame;

public class AltaEmpleadoAccion extends Accion {

    @Override
    public void tarea(Container contenedor, Object... args) {
        AltaEmpleadoFrame frame = ((AltaEmpleadoFrame) contenedor);
        HashMap<String, Object> datos = frame.getDatos();
        Empleado empleado = new Empleado();
        empleado.setIdEmpleado(getClave(datos));
        empleado.setNombre((String) datos.get("nombre"));
        empleado.setApellidoPaterno((String) datos.get("apellidopaterno"));
        empleado.setApellidoMaterno((String) datos.get("apellidomaterno"));
        empleado.setFechaNacimiento((String) datos.get("fechanacimiento"));
        empleado.setHoraEntrada((String) datos.get("horaentrada"));
        empleado.setHoraSalida((String) datos.get("horasalida"));
        empleado.setPuesto(((String) datos.get("puesto")).toUpperCase());
        empleado.setEstado("TRABAJANDO");
        empleado.setFechaRegistro("now()");
        if (ServiciosLOIS.getServicios().altaEmpleado(empleado)) {
            JOptionPane.showMessageDialog(frame, "Empleado registrado con éxito",
                    "Información", JOptionPane.INFORMATION_MESSAGE);
            frame.dispose();
        } else {
            System.out.println("Tu cliente da problemas chabo");
        }
    }

    public String getClave(HashMap<String, Object> datos) {
        String clave = "E";
        Date fecha = new Date();
        clave += fecha.getYear() + 1900;
        clave += fecha.getHours();
        clave += fecha.getMinutes();
        clave += fecha.getSeconds();
        return clave;
    }

}
