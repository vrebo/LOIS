package org.losi.vistas.catalogos;

import java.awt.Dimension;
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
    private final TableModel tableModel;
    protected final String accion;

    public Catalogo(String titulo, String nombre, TableModel tableModel) {
        this.setTitle(titulo);
        this.setName(nombre);
        this.accion = nombre;
        this.tableModel = tableModel;
        addComponentes();
        addEventos(this);
    }

    private void addComponentes() {
        jScrollPane = new JScrollPane();
        jXTable = new JXTable(tableModel);
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

    private void addEventos(JComponent componenete) {
        menu.addEventos(componenete);
    }

    @Override
    public void show() {
        super.show();
        Dimension deskopSize = getDesktopPane().getSize();
        Dimension catalogoSize = getSize();
        int x = deskopSize.width/2 - catalogoSize.width/2;
        int y = deskopSize.height/2 - catalogoSize.height/2;
        setLocation(x, y);
        Accion.getAccion(accion).ejecutar(this);
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
            jMenuItemActualizar.setName(accion);
            jMenuOpciones.add(jMenuItemActualizar);
            add(jMenuOpciones);
        }

        public void addEventos(JComponent componente) {
            jMenuItemActualizar.addActionListener((ActionEvent e) -> {
                String tipo = ((JComponent) e.getSource()).getName();
                Accion accion = Accion.getAccion(tipo);
                accion.ejecutar(componente);
            });
        }
    }

}
