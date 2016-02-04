package br.com.controle.visao.abstractModels;

import br.com.controle.util.modelo.Professor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Otavio Costa
 */
public final class TabelaProfessor extends AbstractTableModel {

    private static TabelaProfessor tabelaProfessor;
    private List<Professor> alunos = new ArrayList<>();
    private final String colunas[] = {"Matricula", "Nome", "Data Nasc.", "Grau de Instrução"};

    private TabelaProfessor() {

    }

    public static TabelaProfessor getInstancia() {
        if (tabelaProfessor == null) {
            tabelaProfessor = new TabelaProfessor();
        }
        return tabelaProfessor;
    }

    public void addListaProfessor(List<Professor> alunos) {
        this.alunos = alunos;
    }

    public void addProfessor(Professor professor) {
        if (alunos == null) {
            alunos = new ArrayList<>();
        }
        this.alunos.add(professor);
        fireTableRowsInserted(getRowCount(), getRowCount() - 1);
    }

    public String delProfessor(int indicde) {
        Professor professor = alunos.remove(indicde);
        fireTableRowsDeleted(indicde, indicde);
        return professor.getMatricula();
    }

    public Professor getProfessor(int index) {
        return alunos.get(index);
    }

    public void limparLista() {
        alunos.clear();
        fireTableDataChanged();

    }

    @Override
    public int getRowCount() {
        return alunos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Professor professor = alunos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return professor.getMatricula();
            case 1:
                return professor.getNome();
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
