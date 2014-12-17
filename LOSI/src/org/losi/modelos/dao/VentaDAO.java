package org.losi.modelos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.losi.modelos.bo.Cliente;
import org.losi.modelos.bo.CopiaPelicula;
import org.losi.modelos.bo.Empleado;
import org.losi.modelos.bo.Venta;

public class VentaDAO extends GenericDAO<Venta, Long> {

    public final static String nombreTabla = propiedades.getProperty("venta-tabla");
    public final static String idVentaDAO = propiedades.getProperty("venta-id");
    public final static String fechaVentaDAO = propiedades.getProperty("venta-fecha");
    public final static String netoVentaDAO = propiedades.getProperty("venta-neto");

    @Override
    public boolean persistir(Venta e, Connection con) {
        boolean result = false;
        try {
            String statement = "SELECT MAX("
                    + idVentaDAO
                    + ") FROM "
                    + nombreTabla
                    + ";";
            long id;
            try (ResultSet rs = con.createStatement().executeQuery(statement)) {
                rs.next();
                id = rs.getLong(1);
            }
            statement
                    = "SELECT setval('venta_venta_id_seq', "
                    + id
                    + ");";
            con.createStatement().execute(statement);
            statement = "INSERT INTO " + nombreTabla + " ("
                    + fechaVentaDAO + ","
                    + netoVentaDAO + ", "
                    + ClienteDAO.idClienteDAO + ","
                    + EmpleadoDAO.idEmpleadoDAO + ") "
                    + " VALUES ("
                    + " ?::date, ?, ?, ?"
                    + ");";
            PreparedStatement ps = con.prepareStatement(statement);
            ps.setString(1, e.getFechaVenta());
            ps.setDouble(2, e.getNetoVenta());
            ps.setString(3, e.getCliente().getIdCliente());
            ps.setString(4, e.getEmpleado().getIdEmpleado());
            ps.execute();
            statement
                    = "SELECT setval('detalle_venta_detallevta_id_seq', (SELECT MAX(detallevta_id) FROM detalle_venta));";
            con.createStatement().execute(statement);
            statement = "INSERT INTO detalle_venta ("
                    + idVentaDAO + ", "
                    + CopiaPeliculaDAO.idCopiaPeliculaDAO
                    + ") VALUES (?, ?);";
            for (CopiaPelicula copia : e.getDetalleVenta()) {
                ps = con.prepareStatement(statement);
                ps.setLong(1, id);
                ps.setLong(2, copia.getIdCopiaPelicula());
                ps.execute();
            }
            ps.close();
            result = true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }

    @Override
    public boolean actualizar(Venta e, Connection con) {
        boolean result = false;
        try {
            PreparedStatement ps = con.prepareStatement(
                    "UPDATE " + nombreTabla + " SET "
                    + fechaVentaDAO + " = ?::date, "
                    + netoVentaDAO + " = ?, "
                    + ClienteDAO.idClienteDAO + " = ?, "
                    + EmpleadoDAO.idEmpleadoDAO + " = ? "
                    + "WHERE "
                    + idVentaDAO + " = ?;");
            ps.setString(1, e.getFechaVenta());
            ps.setDouble(2, e.getNetoVenta());
            ps.setString(3, e.getCliente().getIdCliente());
            ps.setString(4, e.getEmpleado().getIdEmpleado());
            ps.setLong(5, e.getIdVenta());
            ps.executeUpdate();
            ps.close();
            result = true;
        } catch (SQLException ex) {
        }
        return result;
    }

    @Override
    public boolean eliminar(Venta e, Connection con) {
        boolean result = false;
        try {
            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM venta WHERE "
                    + idVentaDAO + " = ?;");
            ps.setLong(1, e.getIdVenta());
            ps.execute();
            ps.close();
            result = true;
        } catch (SQLException ex) {
        }
        return result;
    }

    @Override
    public List<Venta> buscarTodos(Connection con) {
        ArrayList<Venta> lista = new ArrayList<>();
        String statement
                = "SELECT * FROM venta;";
        try {
            PreparedStatement ps = con.prepareStatement(statement);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    long idVenta = rs.getLong(idVentaDAO);
                    String idCliente = rs.getString(ClienteDAO.idClienteDAO);
                    String idEmpleado = rs.getString(EmpleadoDAO.idEmpleadoDAO);
                    String fechaVenta = rs.getString(fechaVentaDAO);
                    double netoVenta = rs.getDouble(netoVentaDAO);

                    ClienteDAO clienteDAO = new ClienteDAO();
                    EmpleadoDAO empleadoDAO = new EmpleadoDAO();
                    Cliente cliente = clienteDAO.buscarPorId(idCliente, con);
                    Empleado empleado = empleadoDAO.buscarPorId(idEmpleado, con);
                    lista.add(new Venta(idVenta, cliente, empleado, fechaVenta, netoVenta));
                }
            }
            ps.close();
        } catch (SQLException ex) {
        }
        return lista;
    }

    @Override
    public Venta buscarPorId(Long id, Connection con) {
        Venta e = null;
        String statement
                = "SELECT * FROM venta WHERE "
                + idVentaDAO + " = ? ;";
        try {
            PreparedStatement ps = con.prepareStatement(statement);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            rs.next();
            long idVenta = rs.getLong(idVentaDAO);
            String idCliente = rs.getString(ClienteDAO.idClienteDAO);
            String idEmpleado = rs.getString(EmpleadoDAO.idEmpleadoDAO);
            String fechaVenta = rs.getString(fechaVentaDAO);
            double netoVenta = rs.getDouble(netoVentaDAO);

            ClienteDAO clienteDAO = new ClienteDAO();
            EmpleadoDAO empleadoDAO = new EmpleadoDAO();

            Cliente cliente = clienteDAO.buscarPorId(idCliente, con);
            Empleado empleado = empleadoDAO.buscarPorId(idEmpleado, con);
            ps.close();
            e = new Venta(idVenta, cliente, empleado, fechaVenta, netoVenta);
        } catch (SQLException ex) {
        }
        return e;
    }
}
