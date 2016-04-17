package br.com.controle.util.dao;

import br.com.controle.util.ConexaoUtil;
import br.com.controle.util.modelo.Nota;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Otavio Costa
 */
public class NotaDAO extends DAOGenerico<Nota> {

    public Nota getNota(String matriculaProfessor, long idDisciplina, String matriculaAluno, String bimestre) {
        try {
            EntityManager em = ConexaoUtil.getEntityManager();
            String consulta = "SELECT n FROM Nota n WHERE n.bimestre=:bimestre and n.professor.matricula=:matriculaP and n.disciplina.id=:idDisciplina and n.aluno.matricula=:matriculaAluno";
            TypedQuery<Nota> query = em.createQuery(consulta, Nota.class);
            query.setParameter("matriculaP", matriculaProfessor);
            query.setParameter("matriculaAluno", matriculaAluno);
            query.setParameter("idDisciplina", idDisciplina);
            query.setParameter("bimestre", bimestre);
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
