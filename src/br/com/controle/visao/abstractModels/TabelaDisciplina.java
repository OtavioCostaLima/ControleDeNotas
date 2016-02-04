/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controle.visao.abstractModels;

import br.com.controle.util.modelo.Disciplina;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Otavio Costa
 */
public class TabelaDisciplina extends AbstractTableModel {

    private static TabelaDisciplina tabelaDisciplina;
    private List<Disciplina> disciplinas = new ArrayList<>();
    private final String colunas[] = {"id", "Descrição", "Tipo"};

    private TabelaDisciplina() {

    }

    public static TabelaDisciplina getInstancia() {
        if (tabelaDisciplina == null) {
            tabelaDisciplina = new TabelaDisciplina();
        }
        return tabelaDisciplina;
    }

    public void addListaDisciplina(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public void addDisciplina(Disciplina disciplina) {
        if (disciplinas == null) {
            disciplinas = new ArrayList<>();
        }
        this.disciplinas.add(disciplina);
        fireTableRowsInserted(getRowCount(), getRowCount() - 1);
    }

    public String delDisciplina(int indicde) {
        Disciplina disciplina = disciplinas.remove(indicde);
        fireTableRowsDeleted(indicde, indicde);
        return disciplina.getDescricao();
    }

    public Disciplina getDisciplina(int index) {
        return disciplinas.get(index);
    }

    public void limparLista() {
        disciplinas.clear();
        fireTableDataChanged();

    }

    @Override
    public int getRowCount() {
        return disciplinas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Disciplina disciplina = disciplinas.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return disciplina.getId();
            case 1:
                return disciplina.getDescricao();
            case 2:
                return disciplina.getTipo();
            default:
                return null;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

}
