package org.losi.modelos.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReporteDAO {

    public ReporteDAO() {
    }

    public String[] seleccionarClientes() {
        Connection conexion = DataBaseHelper.getConexion();
        Statement statement = null;
        ArrayList<String> array = new ArrayList();
        try {
            statement = conexion.createStatement();
            ResultSet rs = statement.executeQuery("select * from vista_cliente;");
            while (rs.next()) {
                String cliente = "";
                cliente += rs.getString("cliente_id") + " ";
                cliente += rs.getString("cliente_nombre") + " ";
                cliente += rs.getString("cliente_appater") + " ";
                cliente += rs.getString("cliente_apmater") + " ";
                cliente += rs.getString("cliente_fecharegistro") + " ";
                cliente += rs.getString("cliente_fechanacimiento");
                array.add(cliente);
            }
            conexion.close();
            statement.close();
        } catch (SQLException e) {
            try {
                System.out.println(e.getMessage());
                conexion.close();
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(ReporteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return array.toArray(new String[0]);
    }

    public String[] seleccionarCopiasPelicula() {
        ArrayList<String> array = new ArrayList();
        Connection conexion = DataBaseHelper.getConexion();
        Statement statement = null;
        try {
            statement = conexion.createStatement();
            ResultSet rs = statement.executeQuery("select * from vista_copia_pelicula;");
            while (rs.next()) {
                String copiaPelicula = "";
                copiaPelicula += rs.getString("copia_id") + " ";
                copiaPelicula += rs.getString("copia_codigo") + " ";
                copiaPelicula += rs.getString("copia_fmto") + " ";
                copiaPelicula += rs.getString("copia_fechaadquisicion") + " ";
                copiaPelicula += rs.getString("copia_precio") + " ";
                copiaPelicula += rs.getString("copia_edo") + " ";
                copiaPelicula += rs.getString("pelicula_id");
                array.add(copiaPelicula);
            }
            conexion.close();
            statement.close();
        } catch (SQLException e) {
            try {
                System.out.println(e.getMessage());
                conexion.close();
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(ReporteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return array.toArray(new String[0]);
    }

    public String[] seleccionarEmpleado() {
        ArrayList<String> array = new ArrayList();
        Connection conexion = DataBaseHelper.getConexion();
        Statement statement = null;
        try {
            statement = conexion.createStatement();
            ResultSet rs = statement.executeQuery("select * from vista_empleado;");
            while (rs.next()) {
                String empleado = "";
                empleado += rs.getString("empleado_id") + " ";
                empleado += rs.getString("empleado_nombre") + " ";
                empleado += rs.getString("empleado_appater") + " ";
                empleado += rs.getString("empleado_apmater") + " ";
                empleado += rs.getString("empleado_horaentrada") + " ";
                empleado += rs.getString("empleado_horasalida") + " ";
                empleado += rs.getString("empleado_fechanacimiento") + " ";
                empleado += rs.getString("empleado_fecharegistro") + " ";
                empleado += rs.getString("empleado_edo") + " ";
                empleado += rs.getString("empleado_puesto") + " ";
                empleado += rs.getString("empleado_sueldo");
                array.add(empleado);
            }
            conexion.close();
            statement.close();
        } catch (SQLException e) {
            try {
                System.out.println(e.getMessage());
                conexion.close();
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(ReporteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return array.toArray(new String[0]);
    }

    public String[] seleccionarGenero() {
        ArrayList<String> array = new ArrayList();
        Connection conexion = DataBaseHelper.getConexion();
        Statement statement = null;
        try {
            statement = conexion.createStatement();
            ResultSet rs = statement.executeQuery("select * from vista_genero;");
            while (rs.next()) {
                String genero = "";
                genero += rs.getString("genero_id") + " ";
                genero += rs.getString("genero_nombre") + " ";
                genero += rs.getString("genero_descripcion");
                array.add(genero);
            }
            conexion.close();
            statement.close();
        } catch (SQLException e) {
            try {
                System.out.println(e.getMessage());
                conexion.close();
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(ReporteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return array.toArray(new String[0]);
    }

    public String[] seleccionarPelicula() {
        ArrayList<String> array = new ArrayList();
        Connection conexion = DataBaseHelper.getConexion();
        Statement statement = null;
        try {
            statement = conexion.createStatement();
            ResultSet rs = statement.executeQuery("select * from vista_copia_pelicula;");
            while (rs.next()) {
                String pelicula = "";
                pelicula += rs.getString("pelicula_id") + " ";
                pelicula += rs.getString("pelicula_titulo") + " ";
                pelicula += rs.getString("pelicula_anioestreno") + " ";
                pelicula += rs.getString("pelicula_director") + " ";
                pelicula += rs.getString("pelicula_estelares") + " ";
                pelicula += rs.getString("pelicula_duracion") + " ";
                pelicula += rs.getString("pelicula_clasif") + " ";
                pelicula += rs.getString("genero_id");
                array.add(pelicula);
            }
            conexion.close();
            statement.close();
        } catch (SQLException e) {
            try {
                System.out.println(e.getMessage());
                conexion.close();
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(ReporteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return array.toArray(new String[0]);
    }

    public ArrayList<byte[]> obtenerPortadasPelicula() {
        ArrayList<byte[]> array = new ArrayList();
        Connection conexion = DataBaseHelper.getConexion();
        Statement statement = null;
        try {
            statement = conexion.createStatement();
            ResultSet rs = statement.executeQuery("select * from vista_portada_pelicula;");
            while (rs.next()) {
                array.add(rs.getBytes("pelicula_portada"));
            }
            conexion.close();
            statement.close();
        } catch (SQLException e) {
            try {
                System.out.println(e.getMessage());
                conexion.close();
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(ReporteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return array;
    }

}
