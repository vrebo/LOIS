package modelos.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelos.bo.Alumno;
import modelos.exception.DataBaseException;

public class AlumnoDAO {

    public static void insertar(Alumno alumno) {

        try {
            Connection connection = DataBaseHelper.getConnetion();
            if (connection != null) {
                Statement statement = connection.createStatement();
                statement.executeUpdate(
                        "INSERT INTO \"Alumno\" (nombre, \"apP\", "
                        + "\"apM\", sexo, edad) VALUES ('"
                        + alumno.getNombre() + "','"
                        + alumno.getApPaterno() + "','"
                        + alumno.getApMaterno() + "','"
                        + alumno.getSexo() + "','"
                        + alumno.getEdad() + "');");
            } else {
                System.out.println("Problema con la conexión");
            }
        } catch (SQLException ex) {
            throw new DataBaseException("Error en SQL\n", ex);
        }
    }

    public static void insertarListaAlumnos(List<Alumno> lista) {

        try {
            Connection connection = DataBaseHelper.getConnetion();
            if (connection != null) {
                Statement statement = connection.createStatement();

                for (Alumno alumno : lista) {
                    statement.executeUpdate(
                            "INSERT INTO \"Alumno\" (nombre, \"apP\", "
                            + "\"apM\", sexo, edad) VALUES ('"
                            + alumno.getNombre() + "','"
                            + alumno.getApPaterno() + "','"
                            + alumno.getApMaterno() + "','"
                            + alumno.getSexo() + "','"
                            + alumno.getEdad() + "');");
                }
            } else {
                System.out.println("Problema con la conexión");
            }
        } catch (SQLException ex) {
            throw new DataBaseException("Error en SQL\n", ex);
        }

    }

    public static List<Alumno> listaAlumnos() {
        try {
            ArrayList<Alumno> lista = new ArrayList<>();
            Connection connection = DataBaseHelper.getConnetion();
            ResultSet resultados = connection.createStatement().executeQuery(
                    "SELECT * FROM \"Alumno\"");
            ResultSetMetaData data = resultados.getMetaData();
            while (resultados.next()) {
                Alumno alumno = new Alumno(
                        resultados.getLong("id"),
                        resultados.getString("nombre"),
                        resultados.getString("apP"),
                        resultados.getString("apM"),
                        resultados.getString("sexo"),
                        resultados.getInt("edad"));
                lista.add(alumno);
            }
            return lista;
        } catch (SQLException ex) {
            throw new DataBaseException("Error en SQL\n", ex);
        }
    }

    public static void eliminaTodosLosAlumnos() {
        try {
            Connection connection = DataBaseHelper.getConnetion();
            Statement statement = connection.createStatement();
            statement.executeUpdate(
                    "TRUNCATE \"Alumno\"");
        } catch (SQLException ex) {
            throw new DataBaseException("Error en SQL\n", ex);
        }
    }
}
