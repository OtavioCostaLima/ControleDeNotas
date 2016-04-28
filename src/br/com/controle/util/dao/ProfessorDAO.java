/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controle.util.dao;

import br.com.controle.util.ConexaoUtil;
import br.com.controle.util.modelo.Professor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Otavio Costa
 */
public class ProfessorDAO extends DAOGenerico<br.com.controle.util.modelo.Professor> {

    public List<Professor> getProfessorTurmaDisciplina(long idDisciplina, long idTurma) {
        EntityManager em = ConexaoUtil.getEntityManager();
        String consulta = "SELECT p FROM Horario h JOIN h.professor p JOIN h.turma t JOIN h.disciplina d WHERE d.id=:idDisciplina and t.id=:idTurma";
        TypedQuery<Professor> query = em.createQuery(consulta, Professor.class);
        query.setParameter("idDisciplina", idDisciplina);
        query.setParameter("idTurma", idTurma);
        return query.getResultList();
    }

}
