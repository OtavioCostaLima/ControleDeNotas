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
public class DisciplinaRN implements RNgenerico<Disciplina> {

    DisciplinaDAO disciplinaDAO;

    @Override
    public boolean salvar(Disciplina t) {
        disciplinaDAO = new DisciplinaDAO();
        try {
            return disciplinaDAO.salvar(t);
        } catch (Exception ex) {
            Logger.getLogger(DisciplinaRN.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
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

    public List<Disciplina> listarDisciplinasDisponiveis(long matriculaprofessor) {
        disciplinaDAO = new DisciplinaDAO();
        return disciplinaDAO.listarDisciplinasDisponiveis(matriculaprofessor);
    }

}
