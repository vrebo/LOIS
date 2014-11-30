package controlador.acciones;

import javax.swing.JOptionPane;
import modelos.bo.Conexion;
import modelos.dao.DataBaseHelper;
import visitas.VistaPlantilla;
import visitas.VistaPrincipal;

public class ProbarConexionAccion extends Accion {

    @Override
    public void ejecutar(VistaPlantilla vista) {
        VistaPrincipal vPrincipal = (VistaPrincipal) vista;
        Conexion conexion = vPrincipal.getConexion();
        boolean prueba = DataBaseHelper.testConexion(conexion);
        String mensaje = "";
        if (prueba) {
            mensaje = "Conexión Éxitosa.";
        } else {
            mensaje = "Datos erroneos.";
        }
        JOptionPane.showMessageDialog(vPrincipal, mensaje);
    }

}
