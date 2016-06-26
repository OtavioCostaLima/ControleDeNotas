package br.com.controle.util.dao;

import br.com.controle.util.ConexaoUtil;
import br.com.controle.util.modelo.Aluno;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Otavio Costa
 */
public class AlunoDAO extends DAOGenerico<Aluno> {

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

    public List<Aluno> buscarPorNome(String nome) {
        EntityManager em = ConexaoUtil.getEntityManager();
        String consulta = "SELECT a FROM Aluno a WHERE nomeAluno like :nome";
        TypedQuery<Aluno> query = em.createQuery(consulta, Aluno.class);
        query.setParameter("nome", "" + nome + "%");

        return query.getResultList();
    }
}
