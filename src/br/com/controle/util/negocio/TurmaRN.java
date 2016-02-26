package br.com.controle.util.negocio;

import br.com.controle.util.dao.TurmaDAO;
import br.com.controle.util.modelo.Turma;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Otavio Costa
 */
public class TurmaRN implements RNgenerico<Turma> {

    TurmaDAO turmaDAO = new TurmaDAO();

    @Override
    public boolean salvar(Turma t) {
        try {
            return turmaDAO.salvar(t);
        } catch (Exception ex) {
            Logger.getLogger(AlunoRN.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean remover(Long id) {
        return turmaDAO.remover(id);
    }

    @Override
    public Turma buscarPorId(Long id) {
        return turmaDAO.buscarPorId(id);
    }

    @Override
    public List<Turma> buscarTodos() {
        return turmaDAO.buscarTodos();
    }

    public List<String> listarAnos() {
        return turmaDAO.listarAnos();
    }
    public List<Turma> listarTurmaPorAno(String ano) {
        return turmaDAO.listarTurmasPorAno(ano);
    }

}
