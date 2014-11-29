package org.losi.controlador.acciones;

import java.awt.Container;
import org.losi.modelos.servicios.ServiciosLOSI;

public abstract class Accion {
    
    protected ServiciosLOSI servicios = new ServiciosLOSI();

    public static Accion getAccion(String tipo) {
        Accion accion = null;
        String paquete = Accion.class.getPackage().getName();
        try {
            accion = (Accion) Class.forName(paquete
                    + "." + tipo + "Accion").newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return accion;
    }

    public void ejecutar(Container contenedor, Object... args){
        new Thread(() -> {
            tarea(contenedor, args);
        }).start();
    }
    
    public abstract void tarea(Container contenedor, Object... args);
}
