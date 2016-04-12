package br.com.controle.util.dao;

import br.com.controle.util.ConexaoUtil;
import br.com.controle.util.modelo.Horario;
import br.com.controle.util.modelo.HorarioPK;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Otavio Costa
 */
public class HorarioDAO extends DAOGenerico<Horario> {

    public void removerHorario(HorarioPK pK) {
        EntityManager em = ConexaoUtil.getEntityManager();
        try {

            Horario horario = em.find(Horario.class, pK);
            em.getTransaction().begin();
            em.remove(horario);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public List<Horario> getTotalDeAlunos() {
        EntityManager em = ConexaoUtil.getEntityManager();
        
        String consulta = "SELECT Horario h INNER JOIN h.professor p INNER JOIN h.turma t where t.id=:idTurma and p.matricula=:matriculaP";
        return (List<Horario>) em.createQuery(consulta).getResultList();

    }

    public List<Horario> buscar() {
        EntityManager em = ConexaoUtil.getEntityManager();
        //   return (List<Horario>) em.createQuery(("FROM").getResultList();
        return null;
    }

}
