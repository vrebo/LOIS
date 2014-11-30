
package org.losi;

import java.util.List;
import org.losi.modelos.bo.Conexion;
import org.losi.modelos.bo.Pelicula;
import org.losi.modelos.dao.DataBaseHelper;
import org.losi.modelos.servicios.ServiciosLOIS;


public class LOSI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DataBaseHelper.setConexion(new Conexion());
        ServiciosLOIS slosi = new ServiciosLOIS();
        List<Pelicula> listaPeliculas = slosi.catalogoPeliculas();
        for (Pelicula pelicula : listaPeliculas) {
            System.out.println(pelicula.getTitulo());
        }
    }
}
