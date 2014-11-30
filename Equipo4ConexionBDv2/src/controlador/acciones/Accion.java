package controlador.acciones;

import visitas.VistaPlantilla;

public abstract class Accion {

    public abstract void ejecutar(VistaPlantilla vista);

    public static Accion getAccion(String tipo) {
        Accion accion = null;
        try {
            accion = (Accion) Class.forName(
                    Accion.class.getPackage().toString().substring(8) + "."
                    + tipo + "Accion").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return accion;
    }
}
