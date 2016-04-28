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

    private List<Professor> professores = new ArrayList<>();
    private final String colunas[] = {"Matricula", "Nome", "Status", "Data Nasc.", "Grau de Instrução"};

    public TabelaProfessor() {

    }

    public void addListaProfessor(List<Professor> professores) {
        this.professores = professores;
    }

   /**Limpa a Lista atual de Professores e adiciona uma nova Lista
     * @param professors */
    public void inserirProfessores(List<Professor> professors) {
        limparLista();
        this.professores.addAll(professors);

    }

    public void addProfessor(Professor professor) {
        if (professores == null) {
            professores = new ArrayList<>();
        }
        this.professores.add(professor);
        fireTableRowsInserted(getRowCount(), getRowCount() - 1);
    }

    public Professor delProfessor(int indicde) {
        Professor professor = professores.remove(indicde);
        fireTableRowsDeleted(indicde, indicde);
        return professor;
    }
  
    public Professor getProfessor(int index) {
        return professores.get(index);
    }

    public void limparLista() {
        professores.clear();
        fireTableDataChanged();

    }

    @Override
    public int getRowCount() {
        return professores.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Professor professor = professores.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return professor.getMatricula();
            case 1:
                return professor.getNome();
            case 2:
                return professor.getSituacao();
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
