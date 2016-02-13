package br.com.controle.util.dao;

import br.com.controle.util.ConexaoUtil;
import br.com.controle.util.modelo.Disciplina;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Otavio Costa
 */
public class DisciplinaDAO extends DAOGenerico<Disciplina> {

    public List<Disciplina> listarDisciplinasDisponiveis(String matricula) {
        EntityManager entityManager = ConexaoUtil.getEntityManager();
        String consulta = "SELECT d FROM Disciplina d WHERE d not in (SELECT ds FROM Professor p join p.disciplinas ds WHERE p.matricula= :idProfessor)";
        TypedQuery<Disciplina> query = entityManager.createQuery(consulta, Disciplina.class);
        query.setParameter("idProfessor", matricula);
        return query.getResultList();
    }
}
