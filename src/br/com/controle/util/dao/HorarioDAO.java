package br.com.controle.util.dao;

import br.com.controle.util.ConexaoUtil;
import br.com.controle.util.modelo.Horario;
import br.com.controle.util.modelo.HorarioPK;
import javax.persistence.EntityManager;

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

}
