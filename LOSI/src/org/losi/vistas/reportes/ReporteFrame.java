/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.losi.vistas.reportes;

import org.losi.vistas.componentes.ListenerPDF;
import org.losi.vistas.componentes.MyInternalFrame;
import org.losi.vistas.componentes.PanelPDF;


public class ReporteFrame extends MyInternalFrame{
    
    PanelPDF panel;
    public ReporteFrame(String ruta){
        panel = new PanelPDF(ruta);
        panel.addEventos(new ListenerPDF(panel));
        setClosable(true);
        setSize(400, 400);
        add(panel);
    }
}