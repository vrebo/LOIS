package org.losi.modelos.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    public final static String comentariosDAO = propiedades.getProperty("copia-comentarios");

    @Override
    public boolean persistir(CopiaPelicula e) {
        boolean result = false;
        try {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO " + nombreTabla + " ("
                    + codigoDAO + ", "
                    + formatoDAO + ", "
                    + fechaAdquisicionDAO + ", "
                    + precioDAO + ", "
                    + estadoDAO + ", "
                    + comentariosDAO + ", "
                    + PeliculaDAO.idPeliculaDAO + " "
                    + ") VALUES (?, ?::copia_formato, ?::date, ?, ?::copia_estado, ?, ?);");

            ps.setString(1, e.getCodigo());
            ps.setString(2, e.getFormato());
            ps.setString(3, e.getFechaAdquisicion());
            ps.setDouble(4, e.getPrecio());
            ps.setString(5, e.getEstado());
            ps.setString(6, e.getComentarios());
            ps.setLong(7, e.getPelicula().getIdPelicula());
            ps.executeUpdate();
            result = true;
        } catch (SQLException ex) {
        }
        return result;
    }

    @Override
    public boolean actualizar(CopiaPelicula e) {
        boolean result = false;
        try {
            PreparedStatement ps = con.prepareStatement(
                    "UPDATE " + nombreTabla + " SET "
                    + codigoDAO + " = ?, "
                    + formatoDAO + " = ?::copia_formato, "
                    + fechaAdquisicionDAO + " = ?::date, "
                    + precioDAO + " = ?, "
                    + estadoDAO + " = ?::copia_estado, "
                    + comentariosDAO + " = ? "
                    + " WHERE "
                    + idCopiaPeliculaDAO + " = ? ;");
            ps.setString(1, e.getCodigo());
            ps.setString(2, e.getFormato());
            ps.setString(3, e.getFechaAdquisicion());
            ps.setDouble(4, e.getPrecio());
            ps.setString(5, e.getEstado());
            ps.setString(6, e.getComentarios());
            ps.setLong(7, e.getIdCopiaPelicula());
            ps.executeUpdate();
            con.commit();
            con.close();
            result = true;
        } catch (SQLException ex) {
        }
        return result;
    }

    @Override
    public boolean eliminar(CopiaPelicula e) {
        boolean result = false;
        try {
            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM " + nombreTabla + " WHERE "
                    + idCopiaPeliculaDAO + " = ?;");
            ps.setLong(1, e.getIdCopiaPelicula());
            ps.execute();
            result = true;
        } catch (SQLException ex) {
        }
        return result;
    }

    @Override
    public List<CopiaPelicula> buscarTodos() {
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
                String comentarios = rs.getString(comentariosDAO);
                double precio = rs.getDouble(precioDAO);
                long idPelicula = rs.getLong(PeliculaDAO.idPeliculaDAO);
                PeliculaDAO peliculaDAO = new PeliculaDAO(con);
                Pelicula pelicula = peliculaDAO.buscarPorId(idPelicula);
                lista.add(new CopiaPelicula(idCopiaPelicula, pelicula, codigo, formato, fechaAdquisicion, precio, estado, comentarios));
            }
        } catch (SQLException ex) {
        }
        return lista;
    }

    @Override
    public CopiaPelicula buscarPorId(Long id) {
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
            String comentarios = rs.getString(comentariosDAO);
            double precio = rs.getLong(precioDAO);
            long idPelicula = rs.getLong(PeliculaDAO.idPeliculaDAO);
            PeliculaDAO peliculaDAO = new PeliculaDAO();
            Pelicula pelicula = peliculaDAO.buscarPorId(idPelicula);
            e = new CopiaPelicula(idCopiaPelicula, pelicula, codigo, formato, fechaAdquisicion, precio, estado, comentarios);
        } catch (SQLException ex) {
        }
        return e;
    }

}
