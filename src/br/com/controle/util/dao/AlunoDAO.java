package br.com.controle.util.dao;

import br.com.controle.util.ConexaoUtil;
import br.com.controle.util.modelo.Aluno;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 *
 * @author Otavio Costa
 */
public class AlunoDAO extends DAOGenerico<Aluno> {

    public Aluno pesquisarPorMatricula(String matricula) {
        EntityManager em = ConexaoUtil.getEntityManager();
        String consulta = "select a from Aluno a where a.matricula = :matricula";
        TypedQuery<Aluno> query = em.createQuery(consulta, Aluno.class);
        query.setParameter("matricula", matricula);
        Aluno aluno = null;
        try {
            return aluno = query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public Aluno buscarPorMatricula(String matricula) {
        EntityManager em = ConexaoUtil.getEntityManager();
        return em.find(Aluno.class, matricula);
    }

    public long getTotalDeAlunos() {
        EntityManager em = ConexaoUtil.getEntityManager();
        String consulta = "SELECT COUNT(matricula) FROM Aluno a ";
        TypedQuery<Long> query = em.createQuery(consulta, Long.class);
        long result = query.getSingleResult();
        return result;
    }

    public long getChamadaUltimoAluno(Aluno aluno) {
        EntityManager em = ConexaoUtil.getEntityManager();
        String consulta = "SELECT MAX(a.numeroChamada) FROM Aluno a JOIN a.turma t WHERE t.descricao= :nomeTurma order by a.numeroChamada DESC";
        TypedQuery<Integer> query = em.createQuery(consulta, Integer.class);
        query.setParameter("nomeTurma", aluno.getTurma().getDescricao());
        Integer result = query.getSingleResult();
        if (result == null) {
            result = 0;
        }
        aluno.setNumeroChamada(++result);
        return result;
    }
}
