package org.losi.modelos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.losi.modelos.bo.Empleado;

public class EmpleadoDAO extends GenericDAO<Empleado, String> {
    
    public final static String nombreTabla = propiedades.getProperty("empleado-tabla");
    public final static String idEmpleadoDAO =propiedades.getProperty("empleado-id");
    public final static String nombreDAO = propiedades.getProperty("empleado-nombre");
    public final static String apellidoPaternoDAO = propiedades.getProperty("empleado-appater");
    public final static String apellidoMaternoDAO = propiedades.getProperty("empleado-apmater");
    public final static String horaEntradaDAO = propiedades.getProperty("empleado-horaentrada");
    public final static String horaSalidaDAO = propiedades.getProperty("empleado-horasalida");
    public final static String fechaNacimientoDAO = propiedades.getProperty("empleado-fechanacimiento");
    public final static String fechaRegistroDAO = propiedades.getProperty("empleado-fecharegistro");
    public final static String estadoDAO = propiedades.getProperty("empleado-estado");
    public final static String puestoDAO = propiedades.getProperty("empleado-puesto");
    
    @Override
    public boolean persistir(Empleado e, Connection con) {
        boolean result = false;
        try {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO " + nombreTabla + " ("
                            + idEmpleadoDAO +", "
                            + nombreDAO + ", "
                            + apellidoPaternoDAO + ", "
                            + apellidoMaternoDAO + ", "
                            + horaEntradaDAO + ", "
                            + horaSalidaDAO + ", "
                            + fechaNacimientoDAO + ", "
                            + fechaRegistroDAO + ", "
                            + estadoDAO + ", "
                            + puestoDAO + ","
                            + "empleado_sueldo )"
                            + " VALUES (?, ?, ?, ?, ?::time, ?::time, ?::timestamp, "
                            + "now(), ?::empleado_estado, ?::empleado_puesto, ?);");
            ps.setString(1, e.getIdEmpleado());
            ps.setString(2, e.getNombre());
            ps.setString(3, e.getApellidoPaterno());
            ps.setString(4, e.getApellidoMaterno());
            ps.setString(5, e.getHoraEntrada());
            ps.setString(6, e.getHoraSalida());
            ps.setString(7, e.getFechaNacimiento());
            ps.setString(8, e.getEstado());
            ps.setString(9, e.getPuesto());
            ps.setDouble(10, 500);
            ps.execute();
            ps.close();
            result = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean actualizar(Empleado e, Connection con) {
        boolean result = false;
        try {
            PreparedStatement ps = con.prepareStatement(
                    "UPDATE " + nombreTabla + " SET "
                    + nombreDAO +" = ?, "
                    + apellidoPaternoDAO + " = ?, "
                    + apellidoMaternoDAO + " = ?, "
                    + horaEntradaDAO + " = ?::time, "
                    + horaSalidaDAO + " = ?::time, "
                    + fechaNacimientoDAO+ " = ?::timestamp, "
                    + fechaRegistroDAO + " = ?::timestamp, "
                    + estadoDAO + " = ?::empleado_estado, "
                    + puestoDAO + " = ?::empleado_puesto"
                    + " WHERE "
                            + idEmpleadoDAO + " = ?;");
            ps.setString(1, e.getNombre());
            ps.setString(2, e.getApellidoPaterno());
            ps.setString(3, e.getApellidoMaterno());
            ps.setString(4, e.getHoraEntrada());
            ps.setString(5, e.getHoraSalida());
            ps.setString(6, e.getFechaNacimiento());
            ps.setString(7, e.getFechaRegistro());
            ps.setString(8, e.getEstado());
            ps.setString(9, e.getPuesto());
            ps.setString(10, e.getIdEmpleado());
            ps.executeUpdate();
            ps.close();
            result = true;
        } catch (SQLException ex) {
        }
        return result;
    }

    @Override
    public boolean eliminar(Empleado e, Connection con) {
        boolean result = false;
        try {
            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM " + nombreTabla + " WHERE "
                            + idEmpleadoDAO
                            + " = ?;");
            ps.setString(1, e.getIdEmpleado());
            ps.execute();
            ps.close();
            result = true;
        } catch (SQLException ex) {
        }
        return result;
    }

    @Override
    public List<Empleado> buscarTodos(Connection con) {
        ArrayList<Empleado> lista = new ArrayList<>();
        String statement
                = "SELECT * FROM " + nombreTabla + ";";
        try {
            PreparedStatement ps = con.prepareStatement(statement);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String idEmpleado = rs.getString(1);
                String nombre = rs.getString(2);
                String apellidoPaterno = rs.getString(3);
                String apellidoMaterno = rs.getString(4);
                String horaEntrada = rs.getString(5);
                String horaSalida = rs.getString(6);
                String fechaNacimiento = rs.getString(7);
                String fechaRegistro = rs.getString(8);
                String estado = rs.getString(9);
                String puesto = rs.getString(10);
                lista.add(new Empleado(idEmpleado, horaEntrada, horaSalida, estado, puesto, nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, fechaRegistro,500));
            }
            ps.close();
        } catch (SQLException ex) {
        }
        return lista;
    }

    @Override
    public Empleado buscarPorId(String id, Connection con) {
        Empleado e = null;
        String statement
                = "SELECT * FROM " + nombreTabla + " WHERE "
                + idEmpleadoDAO + " = ? ;";
        try {
            PreparedStatement ps = con.prepareStatement(statement);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            rs.next();
            String idEmpleado = rs.getString(1);
            String nombre = rs.getString(2);
            String apellidoPaterno = rs.getString(3);
            String apellidoMaterno = rs.getString(4);
            String horaEntrada = rs.getString(5);
            String horaSalida = rs.getString(6);
            String fechaNacimiento = rs.getString(7);
            String fechaRegistro = rs.getString(8);
            String estado = rs.getString(9);
            String puesto = rs.getString(10);
            ps.close();
            e = new Empleado(idEmpleado, horaEntrada, horaSalida, estado, puesto, nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, fechaRegistro,500);
        } catch (SQLException ex) {
        }
        return e;
    }

}
