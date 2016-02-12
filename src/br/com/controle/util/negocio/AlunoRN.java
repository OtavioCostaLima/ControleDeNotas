package br.com.controle.util.negocio;

import br.com.controle.util.dao.AlunoDAO;
import br.com.controle.util.modelo.Aluno;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Otavio Costa
 */
public class AlunoRN implements RNgenerico<Aluno> {

    AlunoDAO alunoDAO = new AlunoDAO();

    public void registrarEntrada() {

    }

    public void registrarSaida() {

    }

    public boolean validarAluno(String codBarras) {
        //Se aluno for válido registrar entrada ou saída

        return alunoDAO.pesquisarPorMatricula(codBarras) != null;
    }

    public boolean salvarTodos(List<Aluno> alunos) {
        for (Aluno aluno : alunos) {
            if (!this.salvar(aluno)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean salvar(Aluno aluno) {
        try {
            if (aluno.equals(alunoDAO.buscarPorMatricula(aluno.getMatricula()))) {
                return alunoDAO.atualizar(aluno);
            }
            alunoDAO.getChamadaUltimoAluno(aluno);
            aluno.gerarMatriculaAluno();
            return alunoDAO.salvar(aluno);
        } catch (Exception ex) {
            Logger.getLogger(AlunoRN.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void remover(String matricula) {
        alunoDAO.remover(matricula);
    }

    @Override
    public Aluno buscarPorId(Long id) {

        return alunoDAO.buscarPorId(id);
    }

    @Override
    public List<Aluno> buscarTodos() {
        return alunoDAO.buscarTodos();
    }

    @Override
    public boolean remover(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
