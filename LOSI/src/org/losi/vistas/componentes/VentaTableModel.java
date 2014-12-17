package org.losi.vistas.componentes;

import org.losi.modelos.bo.Venta;

public class VentaTableModel extends MyTableModel<Venta> {

    public VentaTableModel() {
        columnNames = new String[]{
            "ID",
            "ID Empleado",
            "Empleado",
            "ID Cliente",
            "Cliente",
            "Neto de la venta",
            "Fecha registro"};
    }

    @Override
    public Object getValueAt(int row, int col) {
        switch (col) {
            case 0:
                return data.get(row).getIdVenta();
            case 1:
                return data.get(row).getEmpleado().getIdEmpleado();
            case 2:
                return data.get(row).getEmpleado().getNombreCompleto();
            case 3:
                return data.get(row).getCliente().getIdCliente();
            case 4:
                return data.get(row).getCliente().getNombreCompleto();
            case 5:
                return data.get(row).getNetoVenta();
            default:
                return data.get(row).getFechaVenta();
        }
    }
}