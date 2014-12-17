package org.losi.vistas;

import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import org.losi.controlador.acciones.Accion;
import org.losi.vistas.catalogos.ClienteCatalogo;
import org.losi.vistas.catalogos.CopiaPeliculaCatalogo;
import org.losi.vistas.catalogos.EmpleadoCatalogo;
import org.losi.vistas.catalogos.GeneroCatalogo;
import org.losi.vistas.catalogos.PeliculaCatalogo;
import org.losi.vistas.catalogos.VentaCatalogo;
import org.losi.vistas.componentes.BarraMenu;
import org.losi.vistas.logging.LoggingForm;
import org.losi.vistas.procesos.AltaClienteFrame;
import org.losi.vistas.procesos.AltaEmpleadoFrame;
import org.losi.vistas.procesos.AltaGeneroFrame;
import org.losi.vistas.procesos.AltaPeliculaFrame;
import org.losi.vistas.procesos.VentaFrame;
import org.losi.vistas.reportes.ReporteFrame;

public class VistaPrincipal extends JFrame {
    
    //Ventanas de Catálogos
    private ClienteCatalogo clienteCatalogo;
    private EmpleadoCatalogo empleadoCatalogo;
    private GeneroCatalogo generoCatalogo;
    private PeliculaCatalogo peliculaCatalogo;
    private CopiaPeliculaCatalogo copiaCatalogo;
    
    //Ventanas de Procesos
    private VentaCatalogo ventaCatalogo;
    private VentaFrame ventaFrame;
    private AltaClienteFrame altaClienteFrame;
    private AltaEmpleadoFrame altaEmpleadoFrame;
    private AltaPeliculaFrame altaPeliculaFrame;
    private AltaGeneroFrame altaGeneroFrame;
    
    private JDesktopPane jDesktopPane1;
    private LoggingForm loggingForm;

    public VistaPrincipal() {
        addComponentes();
    }

    public final void addComponentes() {
        loggingForm = new LoggingForm(this);
        jDesktopPane1 = new javax.swing.JDesktopPane();
        clienteCatalogo = new ClienteCatalogo();
        empleadoCatalogo = new EmpleadoCatalogo();
        generoCatalogo = new GeneroCatalogo();
        peliculaCatalogo = new PeliculaCatalogo();
        copiaCatalogo = new CopiaPeliculaCatalogo();
        ventaCatalogo = new VentaCatalogo();
        ventaFrame = new VentaFrame();
        altaClienteFrame = new AltaClienteFrame();
        altaEmpleadoFrame = new AltaEmpleadoFrame();
        altaPeliculaFrame = new AltaPeliculaFrame();
        altaGeneroFrame = new AltaGeneroFrame();

        setJMenuBar(new BarraMenu(this));
        setContentPane(loggingForm);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Información Lord Ordo");
        
        String url = "/imagenes/logo-lois.png";
        setIconImage(new ImageIcon(getClass().getResource(url)).getImage());
//        setUndecorated(true);//Verdadero FullScreen HD
        jDesktopPane1.add(clienteCatalogo);
        jDesktopPane1.add(empleadoCatalogo);
        jDesktopPane1.add(generoCatalogo);
        jDesktopPane1.add(peliculaCatalogo);
        jDesktopPane1.add(copiaCatalogo);
        jDesktopPane1.add(ventaCatalogo);
        jDesktopPane1.add(ventaFrame);
        jDesktopPane1.add(altaClienteFrame);
        jDesktopPane1.add(altaEmpleadoFrame);
        jDesktopPane1.add(altaPeliculaFrame);
        jDesktopPane1.add(altaGeneroFrame);
        
        setMinimumSize(new Dimension());
        pack();
        setLocationRelativeTo(null);//Centra el JFrame en la pantalla
    }
    
    public LoggingForm getLoggingForm(){
        return loggingForm;
    }

    public JDesktopPane getjDesktopPane1() {
        return jDesktopPane1;
    }

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
    
    public VentaCatalogo getVentaCatalogo() {
        return ventaCatalogo;
    }

    public VentaFrame getVentaFrame() {
        return ventaFrame;
    }

    public AltaClienteFrame getAltaClienteFrame() {
        return altaClienteFrame;
    }

    public AltaEmpleadoFrame getAltaEmpleadoFrame() {
        return altaEmpleadoFrame;
    }

    public AltaPeliculaFrame getAltaPeliculaFrame() {
        return altaPeliculaFrame;
    }

    public AltaGeneroFrame getAltaGeneroFrame() {
        return altaGeneroFrame;
    }

    public void setAltaGeneroFrame(AltaGeneroFrame altaGeneroFrame) {
        this.altaGeneroFrame = altaGeneroFrame;
    }

    public void setAltaPeliculaFrame(AltaPeliculaFrame altaPeliculaFrame) {
        this.altaPeliculaFrame = altaPeliculaFrame;
    }

    public void setAltaEmpleadoFrame(AltaEmpleadoFrame altaEmpleadoFrame) {
        this.altaEmpleadoFrame = altaEmpleadoFrame;
    }

    public void setAltaClienteFrame(AltaClienteFrame altaClienteFrame) {
        this.altaClienteFrame = altaClienteFrame;
    }
    

    public void setClienteCatalogo(ClienteCatalogo clienteCatalogo) {
        this.clienteCatalogo = clienteCatalogo;
    }

    public void setEmpleadoCatalogo(EmpleadoCatalogo empleadoCatalogo) {
        this.empleadoCatalogo = empleadoCatalogo;
    }

    public void setGeneroCatalogo(GeneroCatalogo generoCatalogo) {
        this.generoCatalogo = generoCatalogo;
    }

    public void setPeliculaCatalogo(PeliculaCatalogo peliculaCatalogo) {
        this.peliculaCatalogo = peliculaCatalogo;
    }

    public void setCopiaCatalogo(CopiaPeliculaCatalogo copiaCatalogo) {
        this.copiaCatalogo = copiaCatalogo;
    }

    public void setVentaFrame(VentaFrame ventaFrame) {
        this.ventaFrame = ventaFrame;
    }

    public void addReporteFrame(String ruta){
        ReporteFrame reporte = new ReporteFrame(ruta);
        jDesktopPane1.add(reporte);
        Accion.getAccion("MuestraInternalFrame").ejecutar(this,reporte);
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
                System.out.println(info);
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
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(VistaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
//        }

        java.awt.EventQueue.invokeLater(() -> {
            new VistaPrincipal().setVisible(true);
        });
    }
}
