/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.losi.vistas;

import java.awt.Dimension;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import org.losi.modelos.bo.Conexion;
import org.losi.modelos.dao.DataBaseHelper;
import org.losi.vistas.catalogos.ClienteCatalogo;
import org.losi.vistas.catalogos.CopiaPeliculaCatalogo;
import org.losi.vistas.catalogos.EmpleadoCatalogo;
import org.losi.vistas.catalogos.GeneroCatalogo;
import org.losi.vistas.catalogos.PeliculaCatalogo;
import org.losi.vistas.componentes.BarraMenu;

/**
 *
 * @author VREBO
 */
public class VistaPrincipal extends JFrame{
    
     private ClienteCatalogo clienteCatalogo;
    private EmpleadoCatalogo empleadoCatalogo;
    private GeneroCatalogo generoCatalogo;
    private PeliculaCatalogo peliculaCatalogo;
    private CopiaPeliculaCatalogo copiaCatalogo;
    private JDesktopPane jDesktopPane1;
    
    public VistaPrincipal() {
        DataBaseHelper.setConexion(new Conexion());
        addComponentes();
    }
    
    private void addComponentes(){
        jDesktopPane1 = new javax.swing.JDesktopPane();
        clienteCatalogo = new ClienteCatalogo();
        empleadoCatalogo = new EmpleadoCatalogo();
        generoCatalogo = new GeneroCatalogo();
        peliculaCatalogo = new PeliculaCatalogo();
        copiaCatalogo = new CopiaPeliculaCatalogo();
        
        setJMenuBar(new BarraMenu(this));
        setContentPane(jDesktopPane1);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Información Lord Ordo");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        //setUndecorated(true);//Verdadero FullScreen HD
        setMinimumSize(new Dimension(700, 600));
        
        jDesktopPane1.add(clienteCatalogo);
        jDesktopPane1.add(empleadoCatalogo);
        jDesktopPane1.add(generoCatalogo);
        jDesktopPane1.add(peliculaCatalogo);
        jDesktopPane1.add(copiaCatalogo);
        pack();
        setLocationRelativeTo(null);//Centra el JFrame en la pantalla
        
    }

//    public JDesktopPane getjDesktopPane1() {
//        return jDesktopPane1;
//    }

    public ClienteCatalogo getClienteCatalogo() {
        return clienteCatalogo;
    }

    public EmpleadoCatalogo getEmpleadoCatalogo() {
        return empleadoCatalogo;
    }

    public GeneroCatalogo getGeneroCatalogo() {
        return generoCatalogo;
    }

    public PeliculaCatalogo getPeliculaCatalogo() {
        return peliculaCatalogo;
    }

    public CopiaPeliculaCatalogo getCopiaCatalogo() {
        return copiaCatalogo;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new VistaPrincipal().setVisible(true);
        });
    }
}
