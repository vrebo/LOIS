package losi.vistas.componentes;

import org.losi.bo.Cliente;

public class ClienteTableModel extends MyTableModel<Cliente> {

    public ClienteTableModel() {
        columnNames = new String[]{
            "ID",
            "Nombre",
            "Apellido paterno",
            "Apellido materno",
            "Fecha de nacimiento",
            "Fecha de registro"};
    }    

    @Override
    public Object getValueAt(int row, int col) {
        switch (col) {
            case 0:
                return data.get(row).getIdCliente();
            case 1:
                return data.get(row).getNombre();
            case 2:
                return data.get(row).getApellidoPaterno();
            case 3:
                return data.get(row).getApellidoMaterno();
            case 4:
                return data.get(row).getFechaNacimiento();
            default:
                return data.get(row).getFechaRegistro();
        }
    }
}
