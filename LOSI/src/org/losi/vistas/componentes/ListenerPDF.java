/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.losi.vistas.componentes;

import com.sun.pdfview.PDFPage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import org.losi.vistas.componentes.PanelPDF;

/**
 *
 * @author Adrián
 */
public class ListenerPDF implements ActionListener, KeyListener {

    private final PanelPDF panelPDF;

    public ListenerPDF(PanelPDF panelPDF) {
        this.panelPDF = panelPDF;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String etiqueta = e.getActionCommand();
        switch (etiqueta) {
            case "Siguiente":
                paginaSiguiente();
                break;
            case "Anterior":
                paginaAnterior();
                break;
        }
    }

    private void paginaAnterior() {
        if (panelPDF.getIndice() > 1) {
            panelPDF.setIndice(panelPDF.getIndice() - 1);
            PDFPage pagina = panelPDF.getFile().getPage(panelPDF.getIndice());
            panelPDF.getPanel().showPage(pagina);
            panelPDF.getJlPaginaActual().setText(Integer.toString(panelPDF.getIndice()));
        }
    }

    private void paginaSiguiente() {
        if (panelPDF.getIndice() < panelPDF.getFile().getNumPages()) {
            panelPDF.setIndice(panelPDF.getIndice() + 1);
            PDFPage pagina = panelPDF.getFile().getPage(panelPDF.getIndice());
            panelPDF.getPanel().showPage(pagina);
            panelPDF.getJlPaginaActual().setText(Integer.toString(panelPDF.getIndice()));
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int codigo = e.getKeyCode();
        switch(codigo) {
            case KeyEvent.VK_RIGHT:
                paginaSiguiente();
                break;
            case KeyEvent.VK_LEFT:
                paginaAnterior();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
