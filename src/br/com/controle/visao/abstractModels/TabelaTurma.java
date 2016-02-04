package br.com.controle.visao.abstractModels;

import br.com.controle.util.modelo.Turma;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Otavio Costa
 */
public class TabelaTurma extends AbstractTableModel {

    private static TabelaTurma tabelaTurma;
    private List<Turma> turmas = new ArrayList<>();
    private final String colunas[] = {"Id", "Turma", "Turno", "Ano"};

    private TabelaTurma() {
    }

    public static TabelaTurma getInstancia() {
        if (tabelaTurma == null) {
            tabelaTurma = new TabelaTurma();
        }
        return tabelaTurma;
    }

    public void addListaTurma(List<Turma> turmas) {
        this.turmas = turmas;
    }

    public void addTurma(Turma turma) {
        this.turmas.add(turma);
        fireTableRowsInserted(getRowCount(), getRowCount() - 1);
    }

    public Long delTurma(int indicde) {
        Turma turma = turmas.remove(indicde);
        fireTableRowsDeleted(indicde, indicde);
        return turma.getId();
    }

    public void limparLista() {
        turmas.clear();
        fireTableDataChanged();

    }

    @Override
    public int getRowCount() {
        return turmas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return turmas.get(rowIndex).getId();
            case 1:
                return turmas.get(rowIndex).getDescricao() + " " + turmas.get(rowIndex).getSigla();
            case 2:
                return turmas.get(rowIndex).getTurno();
            case 3:
                return turmas.get(rowIndex).getAno();
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
