package org.losi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.losi.bo.Conexion;

public class DataBaseHelper {
    
    private static Conexion conexion;

    public static Connection getConexion(){
        return getConexion(conexion);
    }
    
    public static Connection getConexion(Conexion conexion) {
        Connection connection = null;
        try {
            Class.forName(conexion.getDriver()).newInstance();
            connection = DriverManager.getConnection(
                    conexion.getUrl() + conexion.getHost() + ":"
                    + conexion.getPort() + "/" + conexion.getBaseDatos(),
                    conexion.getUser(), conexion.getPassword());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            System.out.println("Problema con la conexion" + ex.getMessage());
        }
        return connection;
    }

    public static boolean testConexion(Conexion conexion) {
        Connection connection = null;
        try {
            Class.forName(conexion.getDriver()).newInstance();
            connection = DriverManager.getConnection(
                    conexion.getUrl() + conexion.getHost() + ":"
                    + conexion.getPort() + "/" + conexion.getBaseDatos(),
                    conexion.getUser(), conexion.getPassword());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            
        }
        return (connection != null);
    }
    
    public static void setConexion(Conexion con){
        conexion = con;
    }
}
