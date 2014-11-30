package controlador;

import controlador.acciones.Accion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import visitas.VistaOpciones;

public class Controlador implements ActionListener {

    private VistaOpciones vista;

    public Controlador(VistaOpciones vista) {
        this.vista = vista;
    }

    public void ejecutar() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String origen = e.getActionCommand().replaceAll(" ", "");
        Accion accion = Accion.getAccion(origen);
        accion.ejecutar(vista);
    }
}
