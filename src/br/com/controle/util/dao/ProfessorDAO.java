/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controle.util.dao;

import br.com.controle.util.ConexaoUtil;
import br.com.controle.util.modelo.Professor;
import javax.persistence.EntityManager;

/**
 *
 * @author Otavio Costa
 */
public class ProfessorDAO extends DAOGenerico<br.com.controle.util.modelo.Professor> {

    public boolean atualizar(Professor professor) {
        EntityManager em = ConexaoUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(professor);
        em.getTransaction().commit();
        return true;
    }

     public Professor buscarPorId(String id) {
        EntityManager em = ConexaoUtil.getEntityManager();
        return em.find(Professor.class, id);
    }
    
}
