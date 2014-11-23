package losi.vistas.componentes;

import org.losi.bo.CopiaPelicula;

public class CopiaPeliculaTableModel extends MyTableModel<CopiaPelicula> {

    public CopiaPeliculaTableModel() {
        columnNames = new String[]{
            "ID",
            "Código",
            "Título",
            "Fecha de adquisición",
            "Precio",
            "Estado",
            "Formato",
            "Comentarios"
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
                return data.get(rowIndex).getFechaAdquisicion();
            case 4:
                return data.get(rowIndex).getPrecio();
            case 5:
                return data.get(rowIndex).getEstado();
            case 6:
                return data.get(rowIndex).getFormato();
            default:
                return data.get(rowIndex).getComentarios();

        }
    }
}
