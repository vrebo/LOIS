package controlador.acciones;

import controlador.Controlador;
import modelos.bo.Conexion;
import modelos.dao.DataBaseHelper;
import visitas.Ventana;
import visitas.VistaOpciones;
import visitas.VistaPlantilla;
import visitas.VistaPrincipal;

public class CrearConexionAccion extends Accion {

    @Override
    public void ejecutar(VistaPlantilla vista) {
        VistaPrincipal vPrincipal = (VistaPrincipal) vista;
        Conexion conexion = vPrincipal.getConexion();
        boolean prueba = DataBaseHelper.testConexion(conexion);
        if (prueba) {
            DataBaseHelper.setConexion(conexion);
            VistaOpciones x = new VistaOpciones();
            Controlador c = new Controlador(x);
            x.addEventos(c);
            Ventana v = new Ventana("Opciones de gestión de alumnos", 400, 300, x);
            vista.dispose();
        }
    }

}
