package org.losi.modelos.dao;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
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
            String statement = "SELECT MAX("
                    + idPeliculaDAO
                    + ") FROM "
                    + nombreTabla
                    + ";";
            long id;
            try (ResultSet rs = con.createStatement().executeQuery(statement)) {
                rs.next();
                id = rs.getLong(1);
            }
            statement
                    = "SELECT setval('pelicula_pelicula_id_seq', " + id + ");";
            con.createStatement().execute(statement);
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO " + nombreTabla + " ("
                    + tituloDAO + ", "
                    + directorDAO + ", "
                    + estelaresDAO + ", "
                    + anioEstrenoDAO + ", "
                    + duracionDAO + ", "
                    + clasificacionDAO + ", "
                    + GeneroDAO.idGeneroDAO + ", "
                    + "pelicula_portada "
                    + ") VALUES (?, ?, ?, ?::interval, ?::time, ?::pelicula_clasificacion, ?, ?);");

            ps.setString(1, e.getTitulo());
            ps.setString(2, e.getDirector());
            ps.setString(3, e.getEstelares());
            int year = Integer.parseInt(e.getAnioEstreno());
            ps.setString(4, "'" + e.getAnioEstreno() + " years'");
            ps.setString(5, e.getDuracion());
            ps.setString(6, e.getClasificacion());
            ps.setLong(7, e.getGenero().getIdGenero());
            File portada = e.getPortada();
            FileInputStream fis = new FileInputStream(portada);
            ps.setBinaryStream(8, fis, (int) portada.length());
            ps.executeUpdate();
            ps.close();
            result = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PeliculaDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                    + anioEstrenoDAO + " = ?::interval, "
                    + directorDAO + " = ?, "
                    + estelaresDAO + " = ?, "
                    + duracionDAO + " = ?::time, "
                    + clasificacionDAO + " = ?::pelicula_clasificacion, "
                    + GeneroDAO.idGeneroDAO + " = ?"
                    + "WHERE "
                    + idPeliculaDAO + " = ?;");
            ps.setString(1, e.getTitulo());
            ps.setString(2, "'" + e.getAnioEstreno() + " years'");
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
                    byte[] bytes = rs.getBytes("pelicula_portada");
                    try {
                        Image portadaImg = new ImageIcon(bytes).getImage();
                        lista.add(new Pelicula(idPelicula, genero, portadaImg, estelares, titulo, anioEstreno, director, clasificacion, duracion));
                    } catch (NullPointerException ex) {
                        lista.add(new Pelicula(idPelicula, genero, new ImageIcon().getImage(), estelares, titulo, anioEstreno, director, clasificacion, duracion));
                    }

                }
            }
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
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
            byte[] bytes = rs.getBytes("pelicula_portada");
            try {
                Image portadaImg = new ImageIcon(bytes).getImage();
                e = new Pelicula(idPelicula, genero, portadaImg, estelares, titulo, anioEstreno, director, clasificacion, duracion);
            } catch (NullPointerException ex) {
                e = new Pelicula(idPelicula, genero, new ImageIcon().getImage(), estelares, titulo, anioEstreno, director, clasificacion, duracion);
            }
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return e;
    }

}
