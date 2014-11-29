package org.losi.modelos.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class GenericDAO<E, P> {

    private static final Properties defaultProps = new Properties();
    protected static final Properties propiedades = new Properties(defaultProps);
    protected Connection con;

    static {
        try {
            defaultProps.load(
                    ClassLoader.class.
                    getResourceAsStream("/properties/default.properties"));
            propiedades.load(
                    ClassLoader.class.
                    getResourceAsStream("/properties/config.properties"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public GenericDAO() {
        con = DataBaseHelper.getConexion();
    }

    public GenericDAO(Connection con) {
        this.con = con;
    }

    public abstract boolean persistir(E e);

    public abstract boolean actualizar(E e);

    public abstract boolean eliminar(E e);

    public abstract List<E> buscarTodos();

    public abstract E buscarPorId(P id);

    public boolean persistirCommit(E e) {
        boolean result = false;
        try {
            con.setAutoCommit(false);
            result = persistir(e);
            con.commit();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, ex);
            try {
                con.rollback();
                con.close();
                Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return result;
    }

    public boolean actualizarCommit(E e) {
        boolean result = false;
        try {
            con.setAutoCommit(false);
            result = actualizar(e);
            con.commit();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, ex);
            try {
                con.rollback();
                con.close();
                Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return result;
    }

    public boolean eliminarCommit(E e) {
        boolean result = false;
        try {
            con.setAutoCommit(false);
            result = eliminar(e);
            con.commit();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, ex);
            try {
                con.rollback();
                con.close();
                Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return result;
    }

    public List<E> buscarTodosCommit() {
        List<E> result = null;
        try {
            con.setAutoCommit(false);
            result = buscarTodos();
            con.commit();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, ex);
            try {
                con.rollback();
                con.close();
                Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return result;
    }

    public E buscarPorIdCommit(P id) {
        E result = null;
        try {
            con.setAutoCommit(false);
            result = buscarPorId(id);
            con.commit();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, ex);
            try {
                con.rollback();
                con.close();
                Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return result;
    }
}
