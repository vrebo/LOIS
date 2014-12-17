package org.losi.controlador.acciones;

import java.awt.Container;
import javax.swing.JLabel;
import javax.swing.JTextField;
import org.losi.modelos.bo.Venta;
import org.losi.vistas.procesos.VentaPanel;

public class VerificaCambioAccion extends Accion{

    @Override
    public void tarea(Container contenedor, Object... args) {
        VentaPanel ventaPanel = (VentaPanel)contenedor;
        Venta venta = (Venta)args[0];
        JTextField monto = (JTextField)args[1];
        JLabel etiquetaCambio = (JLabel)args[2];
        double pago = new Double(monto.getText());
        double cambio = pago - venta.getNetoVenta();
        String texto;
        boolean flag = false;
        if(cambio >= 0){
            texto = "$" + cambio;
            flag = true;
        }else{
            texto = "Operación inválida";
        }
        etiquetaCambio.setText(texto);
        ventaPanel.setMontoFlag(flag);
    }
    
}
