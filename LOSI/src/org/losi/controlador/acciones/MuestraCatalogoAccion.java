package org.losi.controlador.acciones;

import java.awt.Container;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.losi.vistas.catalogos.Catalogo;

public class MuestraCatalogoAccion extends Accion{

    @Override
    public void tarea(Container contenedor, Object... args) {
        Catalogo catalogo = (Catalogo)args[0];
        if(!catalogo.isVisible()){
            catalogo.show();
            System.out.println("cerrado");
        }else{
            catalogo.toFront();
            try {
                catalogo.setSelected(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(MuestraCatalogoAccion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
