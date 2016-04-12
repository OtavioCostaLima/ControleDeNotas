package br.com.controle.util.dao;

import br.com.controle.util.ConexaoUtil;
import br.com.controle.util.modelo.Turma;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Otavio Costa
 */
public class TurmaDAO extends DAOGenerico<Turma> {

    public List<String> listarAnos() {
        EntityManager entityManager = ConexaoUtil.getEntityManager();
        String consulta = "SELECT  DISTINCT t.ano FROM Turma t";
        TypedQuery<String> query = entityManager.createQuery(consulta, String.class);
        return query.getResultList();
    }

    public List<Turma> listarTurmasPorAno(String ano) {
        EntityManager entityManager = ConexaoUtil.getEntityManager();
        String consulta = "SELECT t FROM Turma t WHERE t.ano=:anoTurma";
        TypedQuery<Turma> query = entityManager.createQuery(consulta, Turma.class);
        query.setParameter("anoTurma", ano);
        return query.getResultList();
    }

    public List<Turma> tumasProfessor() {
        EntityManager em = ConexaoUtil.getEntityManager();
        String consulta = "select t from Turma t where t.id in (SELECT h.turma FROM horario h where h.id_professor=1)";
        TypedQuery<Turma> query = em.createQuery(consulta, Turma.class);
        return query.getResultList();
    }

}
