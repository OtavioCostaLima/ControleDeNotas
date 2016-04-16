package br.com.controle.util.dao;

import br.com.controle.util.ConexaoUtil;
import br.com.controle.util.modelo.Disciplina;
import br.com.controle.util.modelo.Nota;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Otavio Costa
 */
public class NotaDAO extends DAOGenerico<Nota> {
    /* public List<Nota> getdDsciplinaTurmaProfessor(String matriculaProfessor, long idDisciplina, String matriculaProfessor) {
    EntityManager em = ConexaoUtil.getEntityManager();
    String consulta = "SELECT n FROM Nota n  WHERE n.matriculaProfessor=:matriculaP and n.idTurma=:idTurma and ";
    TypedQuery<Disciplina> query = em.createQuery(consulta, Disciplina.class);
    query.setParameter("matriculaP", matriculaProfessor);
    query.setParameter("idTurma", idTurma);
    return query.getResultList();
    }*/
}
