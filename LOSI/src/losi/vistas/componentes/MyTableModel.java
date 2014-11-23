package losi.vistas.componentes;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public abstract class MyTableModel<E> extends AbstractTableModel {

    protected String[] columnNames;
    protected List<E> data = new ArrayList<>();

    public List<E> getData() {
        return data;
    }

    public void setData(List<E> data) {
        this.data = data;
        fireTableDataChanged();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    /*
     * JTable uses this method to determine the default renderer/
     * editor for each cell.  If we didn't implement this method,
     * then the last column would contain text ("true"/"false"),
     * rather than a check box.
     */
    @Override
    public Class getColumnClass(int c) {
        if(data.isEmpty()){
            return Object.class.getClass();
        }else{
            return getValueAt(0, c).getClass();
        }
    }

    /*
     * Don't need to implement this method unless your table's
     * editable.
     */
    @Override
    public boolean isCellEditable(int row, int col) {
        //Note that the data/cell address is constant,
        //no matter where the cell appears onscreen.
        return false;
    }

    /*
     * Don't need to implement this method unless your table's
     * data can change.
     */
    @Override
    public void setValueAt(Object value, int row, int col) {
//        if (DEBUG) {
//            System.out.println("Setting value at " + row + "," + col
//                    + " to " + value
//                    + " (an instance of "
//                    + value.getClass() + ")");
//        }
//
//        data[row][col] = value;
//        fireTableCellUpdated(row, col);
//
//        if (DEBUG) {
//            System.out.println("New value of data:");
//            printDebugData();
//        }
    }
}
