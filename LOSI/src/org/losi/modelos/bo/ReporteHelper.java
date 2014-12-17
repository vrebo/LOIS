package org.losi.modelos.bo;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.losi.modelos.dao.ReporteDAO;

public class ReporteHelper {
    private final String[] titulosCliente;
    private final String[] titulosCopiaPelicula;
    private final String[] titulosEmpleado;
    private final String[] titulosGenero;
    private final String[] titulosPelicula;

    public ReporteHelper() {
        titulosCliente = generarTitulosCliente();
        titulosCopiaPelicula = generarTitulosCopiaPelicula();
        titulosEmpleado = generarTitulosEmpleado();
        titulosGenero = generarTitulosGenero();
        titulosPelicula = generarTitulosPelicula();
    }

    public boolean generarReporte(String[] columnas, String[] titulos) {
        try {
            String[][] matriz = splitea(columnas);
            Document doc = new Document(PageSize.LETTER);
            String file = obtenerRuta();
            PdfWriter.getInstance(doc, new FileOutputStream(file));
            doc.open();
            for (int i = 0; i < columnas.length; i++) {
                for (int j = 0; j < matriz[0].length; j++) {
                    Paragraph parrafoTitulo;
                    Paragraph parrafoFila;
                    parrafoTitulo = new Paragraph(titulos[j],
                            FontFactory.getFont("arial", 22, Font.BOLDITALIC, BaseColor.BLUE));
                    parrafoFila = new Paragraph(matriz[i][j],
                            FontFactory.getFont("arial", 18, Font.BOLD, BaseColor.BLACK));
                    parrafoFila.setIndentationLeft(50);
                    doc.add(parrafoTitulo);
                    doc.add(parrafoFila);
                    doc.add(new Paragraph(""));
                }
                doc.newPage();
            }
            doc.close();
            JOptionPane.showMessageDialog(null, "Documento creado exitosamente",
                    "Aviso", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (DocumentException | FileNotFoundException ex) {
            Logger.getLogger(ReporteHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean generarReporte(String[] columnas, String[] titulos, ArrayList<byte[]> array) {
        try {
            String[][] matriz = splitea(columnas);
            Document doc = new Document(PageSize.LETTER);
            String file = obtenerRuta();
            PdfWriter.getInstance(doc, new FileOutputStream(file));
            doc.open();
            for (int i = 0; i < columnas.length; i++) {
                for (int j = 0; j < matriz[0].length; j++) {
                    Paragraph parrafoTitulo;
                    Paragraph parrafoFila;
                    parrafoTitulo = new Paragraph(titulos[j],
                            FontFactory.getFont("arial", 22, Font.BOLDITALIC, BaseColor.BLUE));
                    parrafoFila = new Paragraph(matriz[i][j],
                            FontFactory.getFont("arial", 18, Font.BOLD, BaseColor.BLACK));
                    parrafoFila.setIndentationLeft(50);
                    doc.add(parrafoTitulo);
                    doc.add(parrafoFila);
                }
                Image img = Image.getInstance(array.get(i));
                img.scaleToFit(200, 200);
                img.setAlignment(Image.ALIGN_MIDDLE);
                doc.add(new Paragraph(titulos[titulos.length - 1], FontFactory.getFont("arial", 22, Font.BOLDITALIC, BaseColor.BLUE)));
                doc.add(img);
                doc.newPage();
            }
            doc.close();
            JOptionPane.showMessageDialog(null, "Documento creado exitosamente",
                    "Aviso", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (DocumentException | FileNotFoundException ex) {
            Logger.getLogger(ReporteHelper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReporteHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean generarReporteClientes() {
        ReporteDAO reporteDAO = new ReporteDAO();
        String[] columnas = reporteDAO.seleccionarClientes();
        if (columnas.length > 0) {
            generarReporte(columnas, titulosCliente);
        } else {
            JOptionPane.showMessageDialog(null, "No existe ningún registro.\nNo se puede crear el documento.");
        }
        return false;
    }

    public boolean generarReporteCopiasPelicula() {
        ReporteDAO reporteDAO = new ReporteDAO();
        String[] columnas = reporteDAO.seleccionarCopiasPelicula();
        if (columnas.length > 0) {
            generarReporte(columnas, titulosCopiaPelicula);
        } else {
            JOptionPane.showMessageDialog(null, "No existe ningún registro.\nNo se puede crear el documento.");
        }
        return false;
    }

    public boolean generarReporteEmpleado() {
        ReporteDAO reporteDAO = new ReporteDAO();
        String[] columnas = reporteDAO.seleccionarEmpleado();
        if (columnas.length > 0) {
            generarReporte(columnas, titulosEmpleado);
        } else {
            JOptionPane.showMessageDialog(null, "No existe ningún registro.\nNo se puede crear el documento.");
        }
        return false;
    }

    public boolean generarReporteGenero() {
        ReporteDAO reporteDAO = new ReporteDAO();
        String[] columnas = reporteDAO.seleccionarGenero();
        if (columnas.length > 0) {
            generarReporte(columnas, titulosGenero);
        } else {
            JOptionPane.showMessageDialog(null, "No existe ningún registro.\nNo se puede crear el documento.");
        }
        return false;
    }

    public boolean generarReportePeliculas() {
        ReporteDAO reporteDAO = new ReporteDAO();
        String[] columnas = reporteDAO.seleccionarPelicula();
        ArrayList<byte[]> imagenes = reporteDAO.obtenerPortadasPelicula();
        if (columnas.length > 0) {
            generarReporte(columnas, titulosPelicula, imagenes);
        } else {
            JOptionPane.showMessageDialog(null, "No existe ningún registro.\nNo se puede crear el documento.");
        }
        return false;
    }

    private String[] generarTitulosCliente() {
        String[] array = new String[]{"ID", "Nombre: ", "Apellido Paterno: ",
            "Apellido Materno: ", "Fecha de Registro: ", "Fecha de Nacimiento: "};
        return array;
    }

    private String[] generarTitulosCopiaPelicula() {
        String[] array = new String[]{"ID", "Codigo: ", "Formato: ",
            "Fecha de Adquisición: ", "Precio: ", "Copia de Estado: ", "ID de Pelicula: "};
        return array;
    }

    private String[] generarTitulosEmpleado() {
        String[] array = new String[]{"ID", "Nombre: ", "Apellido Paterno: ",
            "Apellido Materno: ", "Hora de entrada: ", "Hora de salida: ", "Fecha de Nacimiento: ", "Fecha de registro: ",
            "Estado: ", "Puesto : ", "Sueldo: "};
        return array;
    }

    private String[] generarTitulosGenero() {
        String[] array = new String[]{"ID", "Nombre: ", "Descripcion: "};
        return array;
    }

    private String[] generarTitulosPelicula() {
        String[] array = new String[]{"ID", "Titulo: ", "Año de estreno: ",
            "Director: ", "Estelares: ", "Duracion: ", "Clasificacion: ", "ID del Genero: ",
            "Portada: "};
        return array;
    }

    private String[][] splitea(String[] columnas) {
        String[][] matriz = new String[columnas.length][columnas[0].split("[ ]+").length];
        for (int i = 0; i < columnas.length; i++) {
            matriz[i] = columnas[i].split("[ ]+");
        }
        return matriz;
    }

    private String obtenerRuta() {
        String ruta;
        JFileChooser chooser = new JFileChooser();
        chooser.showSaveDialog(chooser);
        ruta = chooser.getSelectedFile().getAbsolutePath();
        return ruta + ".pdf";
    }
}