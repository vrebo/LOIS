package org.losi.modelos.dao;

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
    public boolean persistir(Venta e) {
        boolean result = false;
        try {
            String statement = "INSERT INTO " + nombreTabla + " ("
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
            statement = "INSERT INTO detalle_venta ("
                    + idVentaDAO + ", "
                    + CopiaPeliculaDAO.idCopiaPeliculaDAO
                    + ") VALUES (?, ?);";
            for (CopiaPelicula copia : e.getDetalleVenta()) {
                ps = con.prepareStatement(statement);
                ps.setLong(1, e.getIdVenta());
                ps.setLong(2, copia.getIdCopiaPelicula());
                ps.execute();
            }
            result = true;
        } catch (SQLException ex) {
        }
        return result;
    }

    @Override
    public boolean actualizar(Venta e) {
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
            result = true;
        } catch (SQLException ex) {
        }
        return result;
    }

    @Override
    public boolean eliminar(Venta e) {
        boolean result = false;
        try {
            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM venta WHERE "
                    + idVentaDAO + " = ?;");
            ps.setLong(1, e.getIdVenta());
            ps.execute();
            result = true;
        } catch (SQLException ex) {
        }
        return result;
    }

    @Override
    public List<Venta> buscarTodos() {
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
                    Cliente cliente = clienteDAO.buscarPorId(idCliente);
                    Empleado empleado = empleadoDAO.buscarPorId(idEmpleado);
                    lista.add(new Venta(idVenta, cliente, empleado, fechaVenta, netoVenta));
                }
            }

        } catch (SQLException ex) {
        }
        return lista;
    }

    @Override
    public Venta buscarPorId(Long id) {
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

            ClienteDAO clienteDAO = new ClienteDAO(con);
            EmpleadoDAO empleadoDAO = new EmpleadoDAO(con);

            Cliente cliente = clienteDAO.buscarPorId(idCliente);
            Empleado empleado = empleadoDAO.buscarPorId(idEmpleado);

            e = new Venta(idVenta, cliente, empleado, fechaVenta, netoVenta);
        } catch (SQLException ex) {
        }
        return e;
    }
}
