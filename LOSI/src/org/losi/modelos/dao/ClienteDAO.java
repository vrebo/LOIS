package org.losi.modelos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.losi.modelos.bo.Cliente;

public class ClienteDAO extends GenericDAO<Cliente, String> {

    public final static String nombreTabla = propiedades.getProperty("cliente-tabla");
    public final static String idClienteDAO = propiedades.getProperty("cliente-id");
    public final static String nombreDAO = propiedades.getProperty("cliente-nombre");
    public final static String apellidoPaternoDAO = propiedades.getProperty("cliente-apellido-paterno");
    public final static String apellidoMaternoDAO = propiedades.getProperty("cliente-apellido-materno");
    public final static String fechaNacimientoDAO = propiedades.getProperty("cliente-fecha-nacimiento");
    public final static String fechaRegistroDAO = propiedades.getProperty("cliente-fecha-registro");

    @Override
    public boolean persistir(Cliente e, Connection con) {
        try {
            try (PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO " + nombreTabla + " ("
                    + idClienteDAO + ", "
                    + nombreDAO + ", "
                    + apellidoPaternoDAO + ", "
                    + apellidoMaternoDAO + ", "
                    + fechaNacimientoDAO + ", "
                    + fechaRegistroDAO + " "
                    + ") VALUES (?, ?, ?, ?, ?::timestamp, ?::timestamp);")) {
                ps.setString(1, e.getIdCliente());
                ps.setString(2, e.getNombre());
                ps.setString(3, e.getApellidoPaterno());
                ps.setString(4, e.getApellidoMaterno());
                ps.setString(5, e.getFechaNacimiento());
                ps.setString(6, e.getFechaRegistro());
                ps.execute();
            }
        } catch (SQLException ex1) {
            Logger.getLogger(GeneroDAO.class.getName()).log(Level.SEVERE, null, ex1);
        }
        return false;
    }

    @Override
    public boolean actualizar(Cliente e, Connection con) {
        boolean result = false;
        try {
            try (PreparedStatement ps = con.prepareStatement(
                    "UPDATE " + nombreTabla + " SET "
                    + nombreDAO + " = ?, "
                    + apellidoPaternoDAO + " = ?, "
                    + apellidoMaternoDAO + " = ?, "
                    + fechaNacimientoDAO + " = ?::timestamp, "
                    + fechaRegistroDAO + " = ?::timestamp "
                    + " WHERE "
                    + idClienteDAO + " = ?;")) {
                ps.setString(1, e.getNombre());
                ps.setString(2, e.getApellidoPaterno());
                ps.setString(3, e.getApellidoMaterno());
                ps.setString(4, e.getFechaNacimiento());
                ps.setString(5, e.getFechaRegistro());
                ps.setString(6, e.getIdCliente());
                ps.executeUpdate();
            }
            result = true;
        } catch (SQLException ex) {
        }
        return result;
    }

    @Override
    public boolean eliminar(Cliente e, Connection con) {
        boolean result = false;
        try {
            try (PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM " + nombreTabla + " WHERE "
                    + idClienteDAO + " = ?;")) {
                ps.setString(1, e.getIdCliente());
                ps.execute();
            }
            result = true;
        } catch (SQLException ex) {
        }
        return result;
    }

    @Override
    public List<Cliente> buscarTodos(Connection con) {
        ArrayList<Cliente> lista = new ArrayList<>();
        String statement
                = "SELECT * FROM " + nombreTabla + ";";
        try {
            try (PreparedStatement ps = con.prepareStatement(statement); ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String idCliente = rs.getString(idClienteDAO);
                    String nombre = rs.getString(nombreDAO);
                    String apellidoPaterno = rs.getString(apellidoPaternoDAO);
                    String apellidoMaterno = rs.getString(apellidoMaternoDAO);
                    String fechaNacimiento = rs.getString(fechaNacimientoDAO);
                    String fechaRegistro = rs.getString(fechaRegistroDAO);
                    lista.add(new Cliente(idCliente, nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, fechaRegistro));
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return lista;
    }

    @Override
    public Cliente buscarPorId(String id, Connection con) {
        Cliente e = null;
        String statement
                = "SELECT * FROM " + nombreTabla + " WHERE "
                + idClienteDAO + " = ? ;";
        try {
            String idCliente, nombre, apellidoPaterno, 
                    apellidoMaterno, fechaNacimiento, fechaRegistro;
            try (PreparedStatement ps = con.prepareStatement(statement)) {
                ps.setString(1, id);
                ResultSet rs = ps.executeQuery();
                rs.next();
                idCliente = rs.getString(idClienteDAO);
                nombre = rs.getString(nombreDAO);
                apellidoPaterno = rs.getString(apellidoPaternoDAO);
                apellidoMaterno = rs.getString(apellidoMaternoDAO);
                fechaNacimiento = rs.getString(fechaNacimientoDAO);
                fechaRegistro = rs.getString(fechaRegistroDAO);
            }
            e = new Cliente(idCliente, nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, fechaRegistro);
        } catch (SQLException ex) {
        }
        return e;
    }
}
