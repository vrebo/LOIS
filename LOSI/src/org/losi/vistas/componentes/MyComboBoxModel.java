/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.losi.vistas.componentes;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.MutableComboBoxModel;

/**
 *
 * @author VREBO
 * @param <Genero>
 */
public class MyComboBoxModel<Genero> extends AbstractListModel<Genero> implements MutableComboBoxModel<Genero> {

    private List<Genero> objects;
    private Genero selectedObject;

    public MyComboBoxModel() {
        objects = new ArrayList<>();
    }

    public void setDatos(List<Genero> objects) {
        this.objects = objects;
        selectedObject = objects.get(0);
        fireContentsChanged(this, -1, -1);
    }

    @Override
    public void setSelectedItem(Object anObject) {
        if ((selectedObject != null && !selectedObject.equals(anObject))
                || selectedObject == null && anObject != null) {
            selectedObject = (Genero) anObject;
            fireContentsChanged(this, -1, -1);
        }else{
            System.out.println("no");
        }
    }

    @Override
    public int getSize() {
        return objects.size();
    }

    @Override
    public Genero getElementAt(int index) {
        if (index >= 0 && index < objects.size()) {
            return objects.get(index);
        } else {
            return null;
        }
    }

    @Override
    public void addElement(Genero item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeElement(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertElementAt(Genero item, int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeElementAt(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getSelectedItem() {
        if (selectedObject != null) {
            return ((org.losi.modelos.bo.Genero) selectedObject);
        } else {
            return null;
        }
    }

}
