package org.losi.controlador.acciones;

import java.awt.Container;
import java.util.HashMap;
import javax.swing.JOptionPane;
import org.losi.modelos.bo.Cliente;
import org.losi.modelos.bo.Genero;
import org.losi.modelos.servicios.ServiciosLOIS;
import org.losi.vistas.procesos.AltaGeneroFrame;

public class AltaGeneroAccion extends Accion {

    @Override
    public void tarea(Container contenedor, Object... args) {
        AltaGeneroFrame frame = ((AltaGeneroFrame) contenedor);
        HashMap<String, Object> datos = frame.getDatos();
        if (!frame.isDatosOk()) {
            JOptionPane.showMessageDialog(frame, "Llene los datos del formulario",
                    "Información", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String nombre = (String) datos.get("nombre");
        String descripcion = (String) datos.get("descripcion");
        Genero genero = new Genero(nombre, descripcion);
        if (ServiciosLOIS.getServicios().altaGenero(genero)) {
            JOptionPane.showMessageDialog(frame, "Cliente registrado con éxito",
                    "Información", JOptionPane.INFORMATION_MESSAGE);
            frame.dispose();
        } else {
            System.out.println("Tu genero da problemas chabo");
        }
    }

}
