package br.com.controle.util.dao;

import br.com.controle.util.ConexaoUtil;
import br.com.controle.util.modelo.Aluno;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    public List<Aluno> buscar(String nome, long idTurma) {
        String consulta = "SELECT a FROM Aluno a JOIN a.turma t WHERE nomeAluno like :nome and t.id=:idTurma order by nomeAluno ASC";
        HashMap<String, Object> a = new HashMap<>();
        a.put("nome", nome + "%");
        a.put("idTurma", idTurma);
        return retur(consulta, a);
    }

    public List<Aluno> buscar(String nome, long idTurma, String status) {
        String consulta = "SELECT a FROM Aluno a JOIN a.turma t WHERE nomeAluno like :nome and status=:status and t.id=:idTurma order by nomeAluno ASC";
        HashMap<String, Object> a = new HashMap<>();
        a.put("nome", nome + "%");
        a.put("idTurma", idTurma);
        a.put("status", status);
        return retur(consulta, a);
    }

    public List<Aluno> buscar(long idTurma, String status) {
        String consulta = "SELECT a FROM Aluno a JOIN a.turma t WHERE status=:status and t.id=:idTurma order by nomeAluno ASC";
        HashMap<String, Object> a = new HashMap<>();
        a.put("idTurma", idTurma);
        a.put("status", status);
        return retur(consulta, a);

    }

    public List<Aluno> buscar(String ano, String status) {
        String consulta = "SELECT a FROM Aluno a JOIN a.turma t WHERE status=:status and t.ano=:ano order by nomeAluno ASC";
        HashMap<String, Object> a = new HashMap<>();
        a.put("ano", ano);
        a.put("status", status);
        return retur(consulta, a);
    }

    private List<Aluno> retur(String consulta, HashMap<String, Object> params) {
        EntityManager em = ConexaoUtil.getEntityManager();
        TypedQuery<Aluno> query = em.createQuery(consulta, Aluno.class);
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            query.setParameter(key, value);

        }
        return query.getResultList();
    }
}
