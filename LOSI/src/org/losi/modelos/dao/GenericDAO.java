package org.losi.modelos.dao;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class GenericDAO<E, P> {

    private static final Properties defaultProps = new Properties();
    protected static final Properties propiedades = new Properties(defaultProps);
    
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

    public abstract boolean persistir(E e);

    public abstract boolean actualizar(E e);

    public abstract boolean eliminar(E e);

    public abstract List<E> buscarTodos();

    public abstract E buscarPorId(P id);
}
