package org.losi.vistas.componentes;

import org.losi.modelos.bo.CopiaPelicula;

public class DetalleVentaTableModel extends MyTableModel<CopiaPelicula>{

    public DetalleVentaTableModel() {
    columnNames = new String[]{
            "ID",
            "Código",
            "Título",
            "Estado",
            "Formato",
            "Precio"
        };
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return data.get(rowIndex).getIdCopiaPelicula();
            case 1:
                return data.get(rowIndex).getCodigo();
            case 2:
                return data.get(rowIndex).getPelicula().getTitulo();
            case 3:
                return data.get(rowIndex).getEstado();
            case 4:
                return data.get(rowIndex).getFormato();
            default:
                return data.get(rowIndex).getPrecio();

        }
    }
}
