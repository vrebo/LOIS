package controlador.acciones;

import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelos.bo.Alumno;
import modelos.dao.AlumnoDAO;
import modelos.util.AlumnosAleatorios;
import visitas.VistaPlantilla;

public class AgregarAlumnosAccion extends Accion {

    @Override
    public void ejecutar(VistaPlantilla vista) {
        ImageIcon icono = new ImageIcon(getClass().getResource(
                "/recursos/imagenes/GurusHint.png"));
        String n = (String) JOptionPane.showInputDialog(vista,
                "¿Cuantos alumnos se insertarán?",
                "Inserción de alumnos",
                JOptionPane.OK_OPTION,
                icono, null, null);
        if (n != null && !n.equals("")) {
            try {
                AlumnosAleatorios aa = new AlumnosAleatorios();
                ArrayList<Alumno> listaAlumnos = aa.listaAlumnos(Integer.parseInt(n));
                AlumnoDAO.insertarListaAlumnos(listaAlumnos);
            } catch (IOException ex) {
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(vista,
                        "Valor inválido, intente de nuevo.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
