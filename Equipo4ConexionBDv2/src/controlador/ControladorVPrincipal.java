package controlador;

import controlador.acciones.Accion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import visitas.VistaPrincipal;

public class ControladorVPrincipal implements ActionListener, ItemListener {

    private final VistaPrincipal vPrincipal;

    public ControladorVPrincipal(VistaPrincipal vista) {
        this.vPrincipal = vista;
        this.vPrincipal.addEventos(this);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        JTextField jtfHost = vPrincipal.getJtfHost();
        JTextField jtfPuerto = vPrincipal.getJtfPuerto();
        if (vPrincipal.getJcbOpcionRemota().isSelected()) {
            jtfHost.setEnabled(true);
            jtfPuerto.setEnabled(true);
        } else {
            jtfHost.setText("");
            jtfHost.setEnabled(false);
            jtfPuerto.setText("");
            jtfPuerto.setEnabled(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String origen = e.getActionCommand().replaceAll(" ", "");;
        try {
            origen = origen.replaceAll("ó", "o");
            Accion accion = Accion.getAccion(origen);
            accion.ejecutar(vPrincipal);
        } catch (RuntimeException ex) {
            JOptionPane.showMessageDialog(vPrincipal, "Problema con la conexión\n" + ex.getMessage());
        }

    }
}
