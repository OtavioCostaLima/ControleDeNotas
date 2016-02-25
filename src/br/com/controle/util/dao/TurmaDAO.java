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

}
