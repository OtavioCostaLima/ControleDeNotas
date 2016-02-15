package br.com.controle.visao.abstractModels;

import br.com.controle.util.modelo.BeanBase;
import java.util.ArrayList;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Otavio Costa
 * @param <T>
 */
public class GenericComboBoxModel<T extends BeanBase> extends AbstractListModel implements ComboBoxModel {

    private Object selectedItem;
    private final ArrayList<T> listaGenerica;

    public GenericComboBoxModel(ArrayList<T> arrayList) {
        listaGenerica = arrayList;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }

    @Override
    public void setSelectedItem(Object newValue) {
        fireContentsChanged(newValue, 0, listaGenerica.size());
        selectedItem = newValue;
    }

    @Override
    public int getSize() {
        return listaGenerica.size();
    }

    @Override
    public Object getElementAt(int i) {
        return listaGenerica.get(i).toString();
    }

    public T get(int selectedIndex) {
        return listaGenerica.get(selectedIndex);
    }

}
