
package losi;

import java.util.List;
import org.losi.bo.Conexion;
import org.losi.bo.Pelicula;
import org.losi.dao.DataBaseHelper;
import org.losi.servicios.ServiciosLOSI;


public class LOSI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DataBaseHelper.setConexion(new Conexion());
        ServiciosLOSI slosi = new ServiciosLOSI();
        List<Pelicula> listaPeliculas = slosi.catalogoPeliculas();
        for (Pelicula pelicula : listaPeliculas) {
            System.out.println(pelicula.getTitulo());
        }
    }
}
