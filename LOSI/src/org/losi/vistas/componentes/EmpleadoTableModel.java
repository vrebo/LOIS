package org.losi.vistas.componentes;

import org.losi.modelos.bo.Empleado;

public class EmpleadoTableModel extends MyTableModel<Empleado> {

    public EmpleadoTableModel() {
        columnNames = new String[]{
            "ID",
            "Nombre",
            "Apellido paterno",
            "Apellido materno",
            "Hora entrada",
            "Hora salida",
            "Fecha de nacimiento",
            "Fecha de registro",
            "Estado",
            "Puesto"
        };
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return data.get(rowIndex).getIdEmpleado();
            case 1:
                return data.get(rowIndex).getNombre();
            case 2:
                return data.get(rowIndex).getApellidoPaterno();
            case 3:
                return data.get(rowIndex).getApellidoMaterno();
            case 4:
                return data.get(rowIndex).getHoraEntrada();
            case 5:
                return data.get(rowIndex).getHoraSalida();
            case 6:
                return data.get(rowIndex).getFechaNacimiento();
            case 7:
                return data.get(rowIndex).getFechaRegistro();
            case 8:
                return data.get(rowIndex).getEstado();
            default:
                return data.get(rowIndex).getPuesto();
        }
    }

}