package visitas;

import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.EventListener;
import javax.swing.JButton;

public final class VistaOpciones extends VistaPlantilla{

    private JButton jbAgregar;
    private JButton jbEliminar;
    private JButton jbConsultar;
    
    
    public VistaOpciones(){
        addComponentes();
    }
    
    @Override
    protected void addComponentes() {
        jbAgregar = new JButton("Agregar Alumnos");
        jbEliminar = new JButton("Eliminar Alumnos");
        jbConsultar = new JButton("Consultar Alumnos");
        setGBC(0, 0, new Insets(10, 5, 10, 5));
        add(jbAgregar, gbc);
        setGBC(0, 1);
        add(jbEliminar, gbc);
        setGBC(0, 2);
        add(jbConsultar, gbc);
    }

    @Override
    public void addEventos(EventListener controlador) {
        jbAgregar.addActionListener((ActionListener) controlador);
        jbEliminar.addActionListener((ActionListener) controlador);
        jbConsultar.addActionListener((ActionListener) controlador);
    }
    
}
