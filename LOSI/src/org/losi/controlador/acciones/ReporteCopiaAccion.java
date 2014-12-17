package org.losi.controlador.acciones;

import java.awt.Container;
import javax.swing.JOptionPane;
import org.losi.modelos.bo.PDFHelper;
import org.losi.vistas.VistaPrincipal;

public class ReporteCopiaAccion extends Accion {

    @Override
    public void tarea(Container contenedor, Object... args) {
        PDFHelper pdfHelper = new PDFHelper();
        pdfHelper.generarReporteCopiasPelicula();
        int opcion = JOptionPane.showConfirmDialog(contenedor, "¿Desea abrir el reporte?");
        if (opcion == JOptionPane.OK_OPTION) {
            ((VistaPrincipal) contenedor).addReporteFrame(pdfHelper.getRuta() + ".pdf");
        }
    }

}
