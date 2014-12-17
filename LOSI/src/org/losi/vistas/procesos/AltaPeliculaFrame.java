/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.losi.vistas.procesos;

import java.util.HashMap;
import java.util.List;
import org.losi.controlador.acciones.Accion;
import org.losi.modelos.bo.Genero;
import org.losi.vistas.componentes.Formulario;
import org.losi.vistas.componentes.MyInternalFrame;

/**
 *
 * @author VREBO
 */
//public class AltaPeliculaFrame extends javax.swing.JInternalFrame {
public class AltaPeliculaFrame extends MyInternalFrame implements Formulario {

    /**
     * Creates new form AltaPeliculaFrame
     */
    public AltaPeliculaFrame() {
        initComponents();
        setMaximizable(false);
        setTitle("Alta de pel�cula");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        formularioPelicula1 = new org.losi.vistas.procesos.FormularioPelicula();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();

        jToolBar1.setRollover(true);
        jToolBar1.setEnabled(false);

        jButton1.setText("Registrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(formularioPelicula1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(formularioPelicula1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Accion.getAccion("AltaPelicula").ejecutar(this);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.losi.vistas.procesos.FormularioPelicula formularioPelicula1;
    private javax.swing.JButton jButton1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
    
    public void setGeneros(List<Genero> generos) {
        formularioPelicula1.setGeneros(generos);
    }

    @Override
    public HashMap<String, Object> getDatos() {
        return formularioPelicula1.getDatos();
    }
    
    @Override
    public boolean isDatosOk() {
        return formularioPelicula1.isDatosOk();
    }

    @Override
    public void setDatosOk(boolean valor) {
        formularioPelicula1.setDatosOk(valor);
    }
}
