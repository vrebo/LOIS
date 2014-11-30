package org.losi.modelos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.losi.modelos.bo.Genero;
import org.losi.modelos.bo.Pelicula;

public class PeliculaDAO extends GenericDAO<Pelicula, Long> {

    public final static String nombreTabla = propiedades.getProperty("pelicula-tabla");
    public final static String idPeliculaDAO = propiedades.getProperty("pelicula-id");
    public final static String estelaresDAO = propiedades.getProperty("pelicula-estelares");
    public final static String anioEstrenoDAO = propiedades.getProperty("pelicula-anio");
    public final static String directorDAO = propiedades.getProperty("pelicula-director");
    public final static String duracionDAO = propiedades.getProperty("pelicula-duracion");
    public final static String clasificacionDAO = propiedades.getProperty("pelicula-clasificacion");
    public final static String tituloDAO = propiedades.getProperty("pelicula-titulo");

    @Override
    public boolean persistir(Pelicula e, Connection con) {
        boolean result = false;
        try {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO " + nombreTabla + " ("
                    + tituloDAO + ", "
                    + anioEstrenoDAO + ", "
                    + directorDAO + ", "
                    + estelaresDAO + ", "
                    + duracionDAO + ", "
                    + clasificacionDAO + ", "
                    + GeneroDAO.idGeneroDAO + " "
                    + ") VALUES (?, ?::date, ?, ?, ?::time, ?::pelicula_clasificacion, ?);");

            ps.setString(1, e.getTitulo());
            ps.setString(2, e.getAnioEstreno());
            ps.setString(3, e.getDirector());
            ps.setString(4, e.getEstelares());
            ps.setString(5, e.getDuracion());
            ps.setString(6, e.getClasificacion());
            ps.setLong(7, e.getGenero().getIdGenero());
            ps.executeUpdate();
            ps.close();
            result = true;
        } catch (SQLException ex) {
        }
        return result;
    }

    @Override
    public boolean actualizar(Pelicula e, Connection con) {
        boolean result = false;
        try {
            PreparedStatement ps = con.prepareStatement(
                    "UPDATE " + nombreTabla + " SET "
                    + tituloDAO + " = ?, "
                    + anioEstrenoDAO + " = ?::date, "
                    + directorDAO + " = ?, "
                    + estelaresDAO + " = ?, "
                    + duracionDAO + " = ?::time, "
                    + clasificacionDAO + " = ?::pelicula_clasificacion, "
                    + GeneroDAO.idGeneroDAO + " = ?"
                    + "WHERE "
                    + idPeliculaDAO + " = ?;");
            ps.setString(1, e.getTitulo());
            ps.setString(2, e.getAnioEstreno());
            ps.setString(3, e.getDirector());
            ps.setString(4, e.getEstelares());
            ps.setString(5, e.getDuracion());
            ps.setString(6, e.getClasificacion());
            ps.setLong(7, e.getGenero().getIdGenero());
            ps.setLong(8, e.getIdPelicula());
            ps.executeUpdate();
            ps.close();
            result = true;
        } catch (SQLException ex) {
        }
        return result;
    }

    @Override
    public boolean eliminar(Pelicula e, Connection con) {
        boolean result = false;
        try {
            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM " + nombreTabla + " WHERE "
                    + idPeliculaDAO + " = ?;");
            ps.setLong(1, e.getIdPelicula());
            ps.execute();
            ps.close();
            result = true;
        } catch (SQLException ex) {
        }
        return result;
    }

    @Override
    public List<Pelicula> buscarTodos(Connection con) {
        ArrayList<Pelicula> lista = new ArrayList<>();
        String statement
                = "SELECT * FROM " + nombreTabla + ";";
        try {
            PreparedStatement ps = con.prepareStatement(statement);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    long idPelicula = rs.getLong(idPeliculaDAO);
                    String titulo = rs.getString(tituloDAO);
                    String estelares = rs.getString(estelaresDAO);
                    String anioEstreno = rs.getString(anioEstrenoDAO);
                    String director = rs.getString(directorDAO);
                    String clasificacion = rs.getString(clasificacionDAO);
                    String duracion = rs.getString(duracionDAO);
                    long idGenero = rs.getLong(GeneroDAO.idGeneroDAO);
                    GeneroDAO generoDAO = new GeneroDAO();
                    Genero genero = generoDAO.buscarPorId(idGenero, con);
                    lista.add(new Pelicula(idPelicula, genero, "portada", estelares, titulo, anioEstreno, director, clasificacion, duracion));
                }
            }
            ps.close();
        } catch (SQLException ex) {
        }
        return lista;
    }

    @Override
    public Pelicula buscarPorId(Long id, Connection con) {
        Pelicula e = null;
        String statement
                = "SELECT * FROM " + nombreTabla + " WHERE "
                + idPeliculaDAO + " = ? ;";
        try {
            PreparedStatement ps = con.prepareStatement(statement);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            long idPelicula = rs.getLong(idPeliculaDAO);
            String titulo = rs.getString(tituloDAO);
            String estelares = rs.getString(estelaresDAO);
            String anioEstreno = rs.getString(anioEstrenoDAO);
            String director = rs.getString(directorDAO);
            String clasificacion = rs.getString(clasificacionDAO);
            String duracion = rs.getString(duracionDAO);
            long idGenero = rs.getLong(GeneroDAO.idGeneroDAO);
            GeneroDAO generoDAO = new GeneroDAO();
            Genero genero = generoDAO.buscarPorId(idGenero, con);
            ps.close();
            e = new Pelicula(idPelicula, genero, "portada", estelares, titulo, anioEstreno, director, clasificacion, duracion);
        } catch (SQLException ex) {
        }
        return e;
    }

}
