/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controle.util.negocio;

import br.com.controle.util.dao.DisciplinaDAO;
import br.com.controle.util.modelo.Disciplina;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Otavio Costa
 */
public class DisciplinaRN implements RNGenerico<Disciplina> {

    DisciplinaDAO disciplinaDAO;

    @Override
    public boolean salvar(Disciplina disciplina) {
        disciplinaDAO = new DisciplinaDAO();
        if (disciplina.equals(disciplinaDAO.buscarPorId(disciplina.getId()))) {
            return disciplinaDAO.atualizar(disciplina);
        }
        return disciplinaDAO.salvar(disciplina);
    }

    @Override
    public boolean remover(Long id) {
        disciplinaDAO = new DisciplinaDAO();
        try {
            return disciplinaDAO.remover(id);
        } catch (Exception ex) {
            Logger.getLogger(DisciplinaRN.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Disciplina buscarPorId(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Disciplina> buscarTodos() {
        disciplinaDAO = new DisciplinaDAO();
        return disciplinaDAO.buscarTodos();
    }

    public List<Disciplina> listarDisciplinasDisponiveisTurmaProfessor(long matriculaprofessor, long idTurma) {
        disciplinaDAO = new DisciplinaDAO();
        return disciplinaDAO.listarDisciplinasDisponiveisTurmaProfessor(matriculaprofessor, idTurma);
    }

}
