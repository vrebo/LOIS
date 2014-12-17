package org.losi.modelos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.losi.modelos.bo.CopiaPelicula;
import org.losi.modelos.bo.Pelicula;

public class CopiaPeliculaDAO extends GenericDAO<CopiaPelicula, Long> {

    public final static String nombreTabla = propiedades.getProperty("copia-tabla");
    public final static String idCopiaPeliculaDAO = propiedades.getProperty("copia-id");
    public final static String codigoDAO = propiedades.getProperty("copia-codigo");
    public final static String formatoDAO = propiedades.getProperty("copia-formato");
    public final static String fechaAdquisicionDAO = propiedades.getProperty("copia-fecha-adquisicion");
    public final static String precioDAO = propiedades.getProperty("copia-precio");
    public final static String estadoDAO = propiedades.getProperty("copia-estado");

    @Override
    public boolean persistir(CopiaPelicula e, Connection con) {
        boolean result = false;
        try {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO " + nombreTabla + " ("
                    + codigoDAO + ", "
                    + formatoDAO + ", "
                    + fechaAdquisicionDAO + ", "
                    + precioDAO + ", "
                    + estadoDAO + ", "
                    + PeliculaDAO.idPeliculaDAO + " "
                    + ") VALUES (?, ?::copia_formato, ?::date, ?, ?::copia_estado, ?, ?);");

            ps.setString(1, e.getCodigo());
            ps.setString(2, e.getFormato());
            ps.setString(3, e.getFechaAdquisicion());
            ps.setDouble(4, e.getPrecio());
            ps.setString(5, e.getEstado());
            ps.setLong(6, e.getPelicula().getIdPelicula());
            ps.executeUpdate();
            ps.close();
            result = true;
        } catch (SQLException ex) {
        }
        return result;
    }

    @Override
    public boolean actualizar(CopiaPelicula e, Connection con) {
        boolean result = false;
        try {
            PreparedStatement ps = con.prepareStatement(
                    "UPDATE " + nombreTabla + " SET "
                    + codigoDAO + " = ?, "
                    + formatoDAO + " = ?::copia_formato, "
                    + fechaAdquisicionDAO + " = ?::date, "
                    + precioDAO + " = ?, "
                    + estadoDAO + " = ?::copia_estado "
                    + " WHERE "
                    + idCopiaPeliculaDAO + " = ? ;");
            ps.setString(1, e.getCodigo());
            ps.setString(2, e.getFormato());
            ps.setString(3, e.getFechaAdquisicion());
            ps.setDouble(4, e.getPrecio());
            ps.setString(5, e.getEstado());
            ps.setLong(6, e.getIdCopiaPelicula());
            ps.executeUpdate();
            ps.close();
            result = true;
        } catch (SQLException ex) {
        }
        return result;
    }

    @Override
    public boolean eliminar(CopiaPelicula e, Connection con) {
        boolean result = false;
        try {
            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM " + nombreTabla + " WHERE "
                    + idCopiaPeliculaDAO + " = ?;");
            ps.setLong(1, e.getIdCopiaPelicula());
            ps.execute();
            ps.close();
            result = true;
        } catch (SQLException ex) {
        }
        return result;
    }

    @Override
    public List<CopiaPelicula> buscarTodos(Connection con) {
        ArrayList<CopiaPelicula> lista = new ArrayList<>();
        String statement
                = "SELECT * FROM " + nombreTabla + ";";
        try {
            PreparedStatement ps = con.prepareStatement(statement);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                long idCopiaPelicula = rs.getLong(idCopiaPeliculaDAO);
                String formato = rs.getString(formatoDAO);
                String fechaAdquisicion = rs.getString(fechaAdquisicionDAO);
                String codigo = rs.getString(codigoDAO);
                String estado = rs.getString(estadoDAO);
                double precio = rs.getDouble(precioDAO);
                long idPelicula = rs.getLong(PeliculaDAO.idPeliculaDAO);
                PeliculaDAO peliculaDAO = new PeliculaDAO();
                Pelicula pelicula = peliculaDAO.buscarPorId(idPelicula, con);
                lista.add(new CopiaPelicula(idCopiaPelicula, pelicula, codigo, formato, fechaAdquisicion, precio, estado));
            }
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    @Override
    public CopiaPelicula buscarPorId(Long id, Connection con) {
        CopiaPelicula e = null;
        String statement
                = "SELECT * FROM " + nombreTabla + " WHERE "
                + idCopiaPeliculaDAO + " = ? ;";
        try {
            PreparedStatement ps = con.prepareStatement(statement);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            long idCopiaPelicula = rs.getLong(idCopiaPeliculaDAO);
            String formato = rs.getString(formatoDAO);
            String fechaAdquisicion = rs.getString(fechaAdquisicionDAO);
            String codigo = rs.getString(codigoDAO);
            String estado = rs.getString(estadoDAO);
            double precio = rs.getLong(precioDAO);
            long idPelicula = rs.getLong(PeliculaDAO.idPeliculaDAO);
            PeliculaDAO peliculaDAO = new PeliculaDAO();
            Pelicula pelicula = peliculaDAO.buscarPorId(idPelicula, con);
            ps.close();
            e = new CopiaPelicula(idCopiaPelicula, pelicula, codigo, formato, fechaAdquisicion, precio, estado);
        } catch (SQLException ex) {
        }
        return e;
    }

}
