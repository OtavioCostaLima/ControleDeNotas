package br.com.controle.visao.abstractModels;

import br.com.controle.util.modelo.Aluno;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Otavio Costa
 */
public class TabelaAluno extends AbstractTableModel {

    private List<Aluno> alunos = new ArrayList<>();
    private final String colunas[] = {"Matricula", "Nome", "Turma", "Status", "Situação"};

    public TabelaAluno() {

    }

    public void addListaAluno(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public void insertNewAlunos(List<Aluno> alunos) {
        limparLista();
        this.alunos.addAll(alunos);

    }

    public void addAluno(Aluno aluno) {
        if (alunos == null) {
            alunos = new ArrayList<>();
        }
        this.alunos.add(aluno);
        fireTableRowsInserted(getRowCount(), getRowCount() - 1);
    }

    public String delAluno(int indicde) {
        Aluno aluno = alunos.remove(indicde);
        fireTableRowsDeleted(indicde, indicde);
        return aluno.getMatricula();
    }

    public Aluno getAluno(int index) {
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
        Aluno aluno = alunos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return aluno.getMatricula();
            case 1:
                return aluno.getNome();
            case 2:
                return aluno.getTurma().getDescricao() + " " + aluno.getTurma().getTurno();
            case 3:
                return aluno.getStatus();
            case 4:
                return aluno.getSituacao();
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
