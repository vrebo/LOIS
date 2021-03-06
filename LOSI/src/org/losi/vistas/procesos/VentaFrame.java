package org.losi.vistas.procesos;

import java.awt.Container;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import org.losi.controlador.acciones.Accion;
import org.losi.vistas.componentes.MyInternalFrame;

public class VentaFrame extends MyInternalFrame {

    /**
     * Creates new form VentaFrame
     */
    public VentaFrame() {
        initComponents();
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setMaximizable(false);
        addEventos(this);
    }

    public final void addEventos(Container container) {
        addInternalFrameListener(new InternalFrameAdapter() {

            @Override
            public void internalFrameClosing(InternalFrameEvent evt) {
                Accion.getAccion("CerrarInternalFrame").ejecutar(container);
            }

        });
    }

    public void setjLabelCambio(String texto) {
        ventaPanel1.setjLabelCambio(texto);
    }

    public void setjLabelCliente(String texto) {
        ventaPanel1.setjLabelCliente(texto);
    }

    public void setjLabelNetoVenta(String texto) {
        ventaPanel1.setjLabelNetoVenta(texto);
    }

    public void setjLabelVendedor(String texto) {
        ventaPanel1.setjLabelVendedor(texto);
    }

    public JTable getjTable1() {
        return ventaPanel1.getjTable1();
    }

    public JTextField getjTextFieldCodigoCliente() {
        return ventaPanel1.getjTextFieldCodigoCliente();
    }

    public JTextField getjTextFieldCodigoCopia() {
        return ventaPanel1.getjTextFieldCodigoCopia();
    }

    public JTextField getjTextFieldMonto() {
        return ventaPanel1.getjTextFieldMonto();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonRegistrarVenta = new javax.swing.JButton();
        ventaPanel1 = new org.losi.vistas.procesos.VentaPanel();
        jButtonCancelar = new javax.swing.JButton();

        jButtonRegistrarVenta.setText("Registrar");
        jButtonRegistrarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarVentaActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ventaPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jButtonRegistrarVenta)
                .addGap(91, 91, 91)
                .addComponent(jButtonCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ventaPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRegistrarVenta)
                    .addComponent(jButtonCancelar))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRegistrarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarVentaActionPerformed
        Accion.getAccion("AltaVenta").ejecutar(this, ventaPanel1);
    }//GEN-LAST:event_jButtonRegistrarVentaActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        Accion.getAccion("CerrarInternalFrame").ejecutar(this);
    }//GEN-LAST:event_jButtonCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonRegistrarVenta;
    private org.losi.vistas.procesos.VentaPanel ventaPanel1;
    // End of variables declaration//GEN-END:variables
}
