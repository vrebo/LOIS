package org.losi.vistas.catalogos;

import java.awt.event.ActionEvent;
import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.table.TableModel;
import org.losi.controlador.acciones.Accion;
import org.jdesktop.swingx.JXTable;

public class Catalogo extends JInternalFrame {
    
    protected JXTable jXTable;
    protected JScrollPane jScrollPane;
    private BarraMenu menu;
    private TableModel modelo;
    protected final String nombre;
    
    public Catalogo(String titulo, String nombre, TableModel modelo) {
        this.setTitle(titulo);
        this.setName(nombre);
        this.nombre = nombre;
        this.modelo = modelo;
        addComponentes();
        addEventos(this);
    }
    
    private void addComponentes() {
        jScrollPane = new JScrollPane();
        jXTable = new JXTable(modelo);
        menu = new BarraMenu();
        
        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setJMenuBar(menu);
        add(jScrollPane);
        
        jXTable.setColumnControlVisible(true);
        jXTable.setShowGrid(false);
        jScrollPane.setViewportView(jXTable);
        jXTable.packTable(5);
        pack();
    }
    
    private void addEventos(JComponent componenete){
        menu.addEventos(componenete);
    }
    
    @Override
    public void show(){
        super.show();
        Accion.getAccion(nombre).ejecutar(this);
    }

    public JXTable getjXTable() {
        return jXTable;
    }
    
    class BarraMenu extends JMenuBar {
        
        private JMenu jMenuOpciones;
        private JMenuItem jMenuItemActualizar;
        
        public BarraMenu() {
            addComponentes();
        }
        
        private void addComponentes() {
            jMenuOpciones = new JMenu("Opciones");
            jMenuItemActualizar = new JMenuItem("Actualizar");
            jMenuItemActualizar.setName(nombre);
            jMenuOpciones.add(jMenuItemActualizar);
            add(jMenuOpciones);
        }
        
        public void addEventos(JComponent componente){
            jMenuItemActualizar.addActionListener((ActionEvent e) -> {
                String tipo = ((JComponent)e.getSource()).getName();
                Accion accion = Accion.getAccion(tipo);
                accion.ejecutar(componente);
            });            
        }
    }
    
}
