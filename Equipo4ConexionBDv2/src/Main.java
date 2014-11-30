
import controlador.ControladorVPrincipal;
import java.io.IOException;
import visitas.Ventana;
import visitas.VistaPrincipal;

public class Main {

    public static void main(String[] args) throws IOException {

        VistaPrincipal v = new VistaPrincipal();
        Ventana y = new Ventana("Conexion al Sistema de Control de Alumnos", 600, 300, v);
        ControladorVPrincipal controlador = new ControladorVPrincipal(v);
    }
}
