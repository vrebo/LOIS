
package visitas;

import java.awt.BorderLayout;
import java.util.EventListener;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public final class VistaConsulta extends VistaPlantilla{
    
    private final String [] titulos = {
        "id Alumno", "Nombre", "Apellido Paterno", "Apellido Materno","Sexo", "Edad"};
    private final Object [][] datos;

    public VistaConsulta(Object [][] datos) {
        this.datos = datos;
        addComponentes();
    }
    
    @Override
    protected void addComponentes() {
        setLayout(new BorderLayout());
        JTable tabla = new JTable(datos, titulos);
        tabla.setEnabled(false);
        JScrollPane pane = new JScrollPane(tabla, 
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(pane, "Center");
    }

    @Override
    public void addEventos(EventListener controlador) {
        
    }
    
}
