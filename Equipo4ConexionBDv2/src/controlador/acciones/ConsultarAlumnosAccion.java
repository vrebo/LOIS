package controlador.acciones;

import java.util.List;
import modelos.bo.Alumno;
import modelos.dao.AlumnoDAO;
import visitas.Ventana;
import visitas.VistaConsulta;
import visitas.VistaPlantilla;

public class ConsultarAlumnosAccion extends Accion {

    @Override
    public void ejecutar(VistaPlantilla vista) {
        List<Alumno> lista = AlumnoDAO.listaAlumnos();
        Object[][] datos = new Object[lista.size()][6];
        for (int i = 0; i < lista.size(); i++) {
            Alumno alumno = lista.get(i);
            datos[i][0] = alumno.getIdAlumno();
            datos[i][1] = alumno.getNombre();
            datos[i][2] = alumno.getApPaterno();
            datos[i][3] = alumno.getApMaterno();
            datos[i][4] = alumno.getSexo();
            datos[i][5] = alumno.getEdad();
        }
        new Ventana("Consulta de alumnos", 400, 300, new VistaConsulta(datos));
    }

}
