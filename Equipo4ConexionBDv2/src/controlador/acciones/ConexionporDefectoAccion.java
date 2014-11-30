package controlador.acciones;

import controlador.Controlador;
import visitas.Ventana;
import visitas.VistaOpciones;
import visitas.VistaPlantilla;

public class ConexionporDefectoAccion extends Accion {

    @Override
    public void ejecutar(VistaPlantilla vista) {
        VistaOpciones x = new VistaOpciones();
        Controlador c = new Controlador(x);
        x.addEventos(c);
        Ventana v = new Ventana("Opciones de gestión de alumnos", 400, 300, x);
    }

}
