package modelos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import modelos.bo.Conexion;
import modelos.exception.DataBaseException;

public class DataBaseHelper {

    private static Conexion conexion = new Conexion();

    public static Connection getConnetion() {
        Connection connection = null;
        try {
            System.out.println(conexion.getBaseDatos());
            Class.forName(conexion.getDriver()).newInstance();
            connection = DriverManager.getConnection(
                    conexion.getUrl() + conexion.getHost() + ":"
                    + conexion.getPuerto() + "/" + conexion.getBaseDatos(),
                    conexion.getUser(), conexion.getPassword());
        } catch (ClassNotFoundException ex) {
            throw new DataBaseException("Clase no encontrada\n", ex);
        } catch (SQLException ex) {
            throw new DataBaseException("Error en SQL\n", ex);
        } catch (InstantiationException ex) {
            throw new DataBaseException("Error al Instanciar\n", ex);
        } catch (IllegalAccessException ex) {
            throw new DataBaseException("Acceso Ilegal\n", ex);
        } finally {
            return connection;
        }
    }

    public static boolean testConexion(Conexion conexion) {
        boolean conexionExitosa = false;
        try {
            Class.forName(conexion.getDriver()).newInstance();
            Connection connection = DriverManager.getConnection(
                    conexion.getUrl() + conexion.getHost() + ":"
                    + conexion.getPuerto() + "/" + conexion.getBaseDatos(),
                    conexion.getUser(), conexion.getPassword());
            if (connection != null) {
                conexionExitosa = true;
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            throw new DataBaseException("Problema probando la conexión.", ex);
        } finally {
            return conexionExitosa;
        }
    }

    public static boolean testDefaultConexion() {
        return testConexion(conexion);
    }

    public static void setConexion(Conexion c) {
        conexion = c;
    }
}
