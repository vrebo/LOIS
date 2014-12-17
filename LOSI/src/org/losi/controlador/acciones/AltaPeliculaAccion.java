package org.losi.controlador.acciones;

import java.awt.Container;
import java.io.File;
import java.util.HashMap;
import javax.swing.JOptionPane;
import org.losi.modelos.bo.Genero;
import org.losi.modelos.bo.Pelicula;
import org.losi.modelos.servicios.ServiciosLOIS;
import org.losi.vistas.procesos.AltaPeliculaFrame;

public class AltaPeliculaAccion extends Accion {

    @Override
    public void tarea(Container contenedor, Object... args) {
        AltaPeliculaFrame frame = ((AltaPeliculaFrame) contenedor);
        HashMap<String, Object> datos = frame.getDatos();
        if (!frame.isDatosOk()) {
            JOptionPane.showMessageDialog(frame, "Llene los datos del formulario",
                    "Información", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String titulo = (String) datos.get("titulo");
        File portada = (File) datos.get("portada");
        String director = (String) datos.get("director");
        String estelares = (String) datos.get("estelares");
        String duracion = (String) datos.get("duracion");
        String anioEstreno = (String) datos.get("anioestreno");
        String clasificacion = (String) datos.get("clasificacion");
        Genero genero = (Genero) datos.get("genero");
        Pelicula pelicula = new Pelicula(genero, portada, estelares, titulo, anioEstreno, director, clasificacion, duracion);
        if (ServiciosLOIS.getServicios().altaPelicula(pelicula)) {
            JOptionPane.showMessageDialog(frame, "Película registrada con éxito",
                    "Información", JOptionPane.INFORMATION_MESSAGE);
            frame.dispose();
        } else {
            System.out.println("Tu pelicula da problemas chabo");
        }
    }

}
