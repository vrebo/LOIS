/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.losi.modelos.dao.DataBaseHelper;

/**
 *
 * @author AdriÃ¡n
 */
public class PDFHelper {

    private final String[] titulosCliente;
    private final String[] titulosCopiaPelicula;
    private final String[] titulosEmpleado;
    private final String[] titulosGenero;
    private final String[] titulosPelicula;
    
    private String ruta;

    public PDFHelper() {
        titulosCliente = generarTitulosCliente();
        titulosCopiaPelicula = generarTitulosCopiaPelicula();
        titulosEmpleado = generarTitulosEmpleado();
        titulosGenero = generarTitulosGenero();
        titulosPelicula = generarTitulosPelicula();
    }

    //Creacion de reportes genÃ©ricos
    public boolean generarReporte(String[] columnas, String[] titulos, String nombreReporte, String ultimoRegistroAgregado, String primerRegistroAgregado) {
        try {
            Date date = new Date();
            String[][] matriz = splitea(columnas);
            Document doc = new Document(PageSize.LETTER);
            doc.setMargins(50, 100, 50, 50);

            String file = obtenerRuta();
            PdfWriter.getInstance(doc, new FileOutputStream(file));

            //Se empieza a escribir el documento
            doc.open();
            //Aqui va la url de donde tengas el loco :v
            Image imgLogo = Image.getInstance("C:\\Users\\VREBO\\Documents\\NetBeansProjects\\LOSI\\resources\\imagenes\\logo-lois.png");
            imgLogo.scaleToFit(150, 150);
            imgLogo.setAbsolutePosition(doc.getPageSize().getWidth() - 170, doc.getPageSize().getHeight() - 170);

            Paragraph titulo = new Paragraph();
            titulo.setFont(FontFactory.getFont("arial", 18, Font.BOLDITALIC, BaseColor.BLACK));
            titulo.setSpacingBefore(25);
            titulo.setAlignment(Paragraph.ALIGN_CENTER);

            doc.add(imgLogo);

            titulo.add("REPORTE TOTAL DE \n  " + nombreReporte.toUpperCase() + " DEL LOIS");
            doc.add(titulo);
            titulo.clear();

            titulo.setAlignment(Paragraph.ALIGN_LEFT);
            titulo.add(new Paragraph(""));
            doc.add(titulo);
            doc.add(titulo);
            titulo.clear();

            titulo.setFont(FontFactory.getFont("arial", 16, Font.ITALIC, BaseColor.BLACK));
            titulo.add("Fecha: " + date.toLocaleString());
            doc.add(titulo);
            titulo.clear();

            titulo.setAlignment(Paragraph.ALIGN_JUSTIFIED);
            titulo.add(new Paragraph(""));
            doc.add(titulo);
            doc.add(titulo);
            titulo.clear();

            titulo.add("Total de " + nombreReporte.toLowerCase() + " en el LOIS:      " + columnas.length);
            doc.add(titulo);
            titulo.clear();

            titulo.add(new Paragraph(""));
            doc.add(titulo);
            titulo.clear();

            DataBaseHelper dbh = new DataBaseHelper();
            String ultimoAgregado = dbh.select(ultimoRegistroAgregado, false).split("#")[0];
            String primerAgregado = dbh.select(primerRegistroAgregado, false).split("#")[0];

            titulo.add("Ãšltimo registro agregado :      " + ultimoAgregado);
            doc.add(titulo);
            titulo.clear();

            titulo.add(new Paragraph(""));
            doc.add(titulo);
            titulo.clear();

            titulo.add("Primer registro agregado:      " + primerAgregado);
            doc.add(titulo);
            titulo.clear();

            titulo.add(new Paragraph(""));
            doc.add(titulo);
            doc.add(titulo);
            doc.add(titulo);
            doc.add(titulo);
            doc.add(titulo);
            doc.add(titulo);
            doc.add(titulo);
            doc.add(titulo);
            titulo.clear();

            titulo.add("        ____________________          ____________________        ");
            doc.add(titulo);
            titulo.clear();

            titulo.add("                   Firma(Reporta)                        Firma(Responsable)");
            doc.add(titulo);
            titulo.clear();

            doc.newPage();

            for (int i = 0; i < columnas.length; i++) {

                for (int j = 0; j < matriz[0].length; j++) {

                    imgLogo.scaleToFit(100, 100);
                    imgLogo.setAbsolutePosition(doc.getPageSize().getWidth() - 120, doc.getPageSize().getHeight() - 120);
                    doc.add(imgLogo);

                    Paragraph parrafoTitulo;
                    Paragraph parrafoFila;

                    parrafoTitulo = new Paragraph(titulos[j],
                            FontFactory.getFont("arial", 12, Font.BOLD, BaseColor.BLUE));
                    parrafoFila = new Paragraph(matriz[i][j],
                            FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));

                    parrafoFila.setIndentationLeft(40);

                    doc.add(parrafoTitulo);
                    doc.add(parrafoFila);

                    titulo.add(new Paragraph(""));
                    doc.add(titulo);
                    titulo.clear();
                }

                doc.newPage();
            }
            //Se termina de escribir en el documento
            doc.close();
            JOptionPane.showMessageDialog(null, "Documento creado exitosamente",
                    "Aviso", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (DocumentException | FileNotFoundException ex) {
            Logger.getLogger(PDFHelper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PDFHelper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(PDFHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    //Creacion de reportes que llevan imagenes de la bd
    public boolean generarReporte(String[] columnas, String[] titulos, ArrayList<byte[]> array) {
        try {

            Date date = new Date();
            String[][] matriz = splitea(columnas);
            Document doc = new Document();
            doc.setMargins(50, 100, 50, 50);
            String file = obtenerRuta();
            PdfWriter.getInstance(doc, new FileOutputStream(file));

            //Se empieza el documento
            doc.open();

            //acÃ¡ igual :v
            Image imgLoco = Image.getInstance("C:\\Users\\VREBO\\Documents\\NetBeansProjects\\LOSI\\resources\\imagenes\\logo-lois.png");
            imgLoco.scaleToFit(150, 150);
            imgLoco.setAbsolutePosition(doc.getPageSize().getWidth() - 170, doc.getPageSize().getHeight() - 170);

            Paragraph titulo = new Paragraph();
            titulo.setFont(FontFactory.getFont("arial", 18, Font.BOLDITALIC, BaseColor.BLACK));
            titulo.setAlignment(Paragraph.ALIGN_CENTER);
            titulo.setSpacingBefore(25);

            doc.add(imgLoco);

            titulo.add("REPORTE TOTAL DE\n PELÍCULAS DEL LOIS");
            doc.add(titulo);
            titulo.clear();

            titulo.add(new Paragraph());
            doc.add(titulo);
            doc.add(titulo);
            titulo.clear();

            titulo.setFont(FontFactory.getFont("arial", 16, Font.ITALIC, BaseColor.BLACK));
            titulo.setAlignment(Paragraph.ALIGN_LEFT);

            titulo.add("Fecha: " + date.toLocaleString());
            doc.add(titulo);
            titulo.clear();

            titulo.setAlignment(Paragraph.ALIGN_JUSTIFIED);
            titulo.add("Total de películas en el LOIS:     " + columnas.length);
            doc.add(titulo);
            titulo.clear();

            DataBaseHelper dbh = new DataBaseHelper();
            String[] nombres = dbh.select("SELECT genero_nombre\n"
                    + "  FROM genero;", false).split("[#]+");
            String[] ids = dbh.select("SELECT genero_id\n"
                    + "  FROM genero;", false).split("[#]+");

            //Se aÃ±ande los nombres de los generos y el total de estos
            for (int i = 0; i < nombres.length; i++) {
                String total = dbh.select("SELECT count(pelicula_id)\n"
                        + "  FROM pelicula, genero\n"
                        + "  WHERE pelicula.genero_id = '" + ids[i] + "'\n"
                        + "  AND pelicula.genero_id = genero.genero_id;", true);

                titulo.add("Total de Películas de " + nombres[i] + ":     " + total);
                doc.add(titulo);
                titulo.clear();
            }

            titulo.add(new Paragraph(""));
            doc.add(titulo);
            doc.add(titulo);
            doc.add(titulo);
            doc.add(titulo);
            doc.add(titulo);
            doc.add(titulo);
            doc.add(titulo);
            doc.add(titulo);
            doc.add(titulo);
            titulo.clear();

            titulo.add("        ____________________          ____________________        ");
            doc.add(titulo);
            titulo.clear();

            titulo.add("                 Firma(Reporta)                      Firma(Responsable)");
            doc.add(titulo);
            titulo.clear();

            doc.newPage();

            for (int i = 0; i < columnas.length; i++) {

                for (int j = 0; j < matriz[0].length; j++) {

                    imgLoco.scaleToFit(100, 100);
                    imgLoco.setAbsolutePosition(doc.getPageSize().getWidth()
                            - 120, doc.getPageSize().getHeight() - 120);
                    doc.add(imgLoco);

                    Paragraph parrafoTitulo;
                    Paragraph parrafoFila;
                    parrafoTitulo = new Paragraph(titulos[j],
                            FontFactory.getFont("arial", 12, Font.BOLD, BaseColor.BLUE));
                    parrafoFila = new Paragraph(matriz[i][j],
                            FontFactory.getFont("arial", 10, Font.NORMAL, BaseColor.BLACK));
                    parrafoFila.setIndentationLeft(40);

                    doc.add(parrafoTitulo);
                    doc.add(parrafoFila);

                    titulo.add(new Paragraph(""));
                    doc.add(titulo);
                    titulo.clear();
                }

                Image img = Image.getInstance(array.get(i));
                img.scaleToFit(200, 200);
                img.setAlignment(Image.ALIGN_MIDDLE);

                doc.add(new Paragraph(titulos[titulos.length - 1],
                        FontFactory.getFont("arial", 13, Font.BOLD, BaseColor.BLUE)));
                doc.add(img);
                doc.newPage();
            }

            //Se termina de escribir
            doc.close();
            JOptionPane.showMessageDialog(null, "Documento creado exitosamente",
                    "Aviso", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (DocumentException | FileNotFoundException ex) {
            Logger.getLogger(PDFHelper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PDFHelper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(PDFHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean generarReporteClientes() {
        DataBaseHelper dbh = new DataBaseHelper();

        String[] columnas = dbh.seleccionarClientes();

        if (columnas.length > 0) {
            generarReporte(columnas, titulosCliente, "Clientes", "SELECT "
                    + "coalesce(cliente_nombre||' '||cliente_appater||' '||cliente_apmater)\n"
                    + "  FROM cliente\n"
                    + "  WHERE cliente_fecharegistro=(select max(cliente_fecharegistro) from cliente);",
                    "SELECT "
                    + "coalesce(cliente_nombre||' '||cliente_appater||' '||cliente_apmater)\n"
                    + "  FROM cliente\n"
                    + "  WHERE cliente_fecharegistro=(select min(cliente_fecharegistro) from cliente);");
        } else {
            JOptionPane.showMessageDialog(null, "No existe ningún registro.\nNo se puede crear el documento.");
        }
        return false;
    }

    public boolean generarReporteCopiasPelicula() {
        DataBaseHelper dbh = new DataBaseHelper();

        String[] columnas = dbh.seleccionarCopiasPelicula();

        if (columnas.length > 0) {
            generarReporte(columnas, titulosCopiaPelicula, "Copias de Películas", "SELECT copia_codigo\n"
                    + "  FROM copia_pelicula\n"
                    + "  WHERE copia_fechaadquisicion = (select max(copia_fechaadquisicion) from copia_pelicula);",
                    "SELECT copia_codigo\n"
                    + "  FROM copia_pelicula\n"
                    + "  WHERE copia_fechaadquisicion = (select min(copia_fechaadquisicion) from copia_pelicula);");
        } else {
            JOptionPane.showMessageDialog(null, "No existe ningÃºn registro.\nNo se puede crear el documento.");
        }
        return false;
    }

    public boolean generarReporteEmpleado() {
        DataBaseHelper dbh = new DataBaseHelper();

        String[] columnas = dbh.seleccionarEmpleado();

        if (columnas.length > 0) {
            generarReporte(columnas, titulosEmpleado, "Empleados", "SELECT coalesce"
                    + "(empleado_nombre||' '||empleado_appater||' '||empleado_apmater)\n"
                    + "  FROM empleado\n"
                    + "  WHERE empleado_fecharegistro = (select max(empleado_fecharegistro) from empleado);",
                    "SELECT coalesce"
                    + "(empleado_nombre||' '||empleado_appater||' '||empleado_apmater)\n"
                    + "  FROM empleado\n"
                    + "  WHERE empleado_fecharegistro = (select min(empleado_fecharegistro) from empleado);");
        } else {
            JOptionPane.showMessageDialog(null, "No existe ningÃºn registro.\nNo se puede crear el documento.");
        }
        return false;
    }

    public boolean generarReporteGenero() {
        DataBaseHelper dbh = new DataBaseHelper();

        String[] columnas = dbh.seleccionarGenero();

        if (columnas.length > 0) {
            generarReporte(columnas, titulosGenero, "Géneros", "SELECT genero_nombre\n"
                    + "  FROM genero\n"
                    + "  WHERE genero_id = (select max(genero_id) from genero);",
                    "SELECT genero_nombre\n"
                    + "  FROM genero\n"
                    + "  WHERE genero_id = (select min(genero_id) from genero);");
        } else {
            JOptionPane.showMessageDialog(null, "No existe ningún registro.\nNo se puede crear el documento.");
        }
        return false;
    }

    public boolean generarReportePeliculas() {
        DataBaseHelper dbh = new DataBaseHelper();

        String[] columnas = dbh.seleccionarPelicula();
        ArrayList<byte[]> imagenes = dbh.obtenerPortadasPelicula();

        if (imagenes.size() > 0) {
            generarReporte(columnas, titulosPelicula, imagenes);
        } else {
            JOptionPane.showMessageDialog(null, "No existe ningún registro.\nNo se puede crear el documento.");
        }
        return false;
    }

    private String[] generarTitulosCliente() {
        String[] array = new String[]{"ID: ", "Nombre: ", "Apellido Paterno: ",
            "Apellido Materno: ", "Fecha de Registro: ", "Fecha de Nacimiento: "};
        return array;
    }

    private String[] generarTitulosCopiaPelicula() {
        String[] array = new String[]{"ID: ", "Codigo: ", "Formato: ",
            "Fecha de Adquisición: ", "Precio: ", "Copia de Estado: ", "ID de Pelicula: "};
        return array;
    }

    private String[] generarTitulosEmpleado() {
        String[] array = new String[]{"ID: ", "Nombre: ", "Apellido Paterno: ",
            "Apellido Materno: ", "Hora de entrada: ", "Hora de salida: ", "Fecha de Nacimiento: ", "Fecha de registro: ",
            "Estado: ", "Puesto : ", "Sueldo($): "};
        return array;
    }

    private String[] generarTitulosGenero() {
        String[] array = new String[]{"ID: ", "Nombre: ", "Descripcion: "};
        return array;
    }

    private String[] generarTitulosPelicula() {
        String[] array = new String[]{"ID: ", "Titulo: ", "Año de estreno: ",
            "Director: ", "Estelares: ", "Duracion: ", "Clasificacion: ", "ID del Genero: ",
            "Portada: "};
        return array;
    }

    private String[][] splitea(String[] columnas) {
        String[][] matriz = new String[columnas.length][columnas[0].split("[&]+").length];
        for (int i = 0; i < columnas.length; i++) {
            matriz[i] = columnas[i].trim().split("[&]+");
        }
        return matriz;
    }

    private String obtenerRuta() throws Exception {
        JFileChooser chooser = new JFileChooser();
        chooser.showSaveDialog(chooser);
        ruta = chooser.getSelectedFile().getAbsolutePath();
        return ruta + ".pdf";
    }

    public String getRuta() {
        return ruta;
    }

}
