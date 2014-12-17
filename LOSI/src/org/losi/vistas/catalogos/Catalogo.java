package org.losi.vistas.catalogos;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.table.TableModel;
import org.jdesktop.swingx.JXTable;
import org.losi.controlador.acciones.Accion;
import org.losi.vistas.componentes.MyInternalFrame;

public class Catalogo extends MyInternalFrame {
    
    protected JXTable jXTable;
    protected JScrollPane jScrollPane;
    private final TableModel tableModel;
    private JToolBar toolBar;
    private JButton actualizar;
    protected final String accion;
    
    public Catalogo(String titulo, String accion, TableModel tableModel) {
        this.setTitle(titulo);
        this.setName(accion);
        this.accion = accion;
        this.tableModel = tableModel;
        addComponentes();
        addEventos();
    }
    
    private void addComponentes() {
        setLayout(new BorderLayout());
        toolBar = new JToolBar();
        actualizar = new JButton("Actualizar");
        actualizar.setActionCommand(accion);
        toolBar.add(actualizar);
        
        ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/reload-icon.png"));
        actualizar.setIcon(icon);
        add(toolBar, BorderLayout.NORTH);
        
        jScrollPane = new JScrollPane();
        jXTable = new JXTable(tableModel);
        
        add(jScrollPane, BorderLayout.CENTER);
        
        jXTable.setColumnControlVisible(true);
        jXTable.setShowGrid(false);
        jScrollPane.setViewportView(jXTable);
        jXTable.packTable(5);
        
        pack();
    }
    
    private void addEventos() {
        actualizar.addActionListener((ActionEvent e) -> {
            Accion.getAccion(e.getActionCommand()).ejecutar(this);
        });
    }
    
    public JXTable getjXTable() {
        return jXTable;
    }
    
}
