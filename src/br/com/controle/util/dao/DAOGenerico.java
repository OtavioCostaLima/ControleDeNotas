package br.com.controle.util.dao;

import br.com.controle.util.ConexaoUtil;
import br.com.controle.util.modelo.BeanBase;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Otavio Costa
 * @param <T>
 */
public abstract class DAOGenerico<T extends BeanBase> {

    public boolean salvar(T t) throws Exception {
        EntityManager em = ConexaoUtil.getEntityManager();
        boolean aux = false;
        try {
            em.getTransaction().begin();

            for (T t1 : buscarTodos()) {
                if (t.equals(t1)) {
                    aux = true;
                }
            }
            if (!aux) {
                em.persist(t);
                em.getTransaction().commit();
            } else {
                em.getTransaction().rollback();
                JOptionPane.showMessageDialog(null, getTypeClass().getSimpleName() + " já Cadastrada!", "INFORMAÇÃO", JOptionPane.INFORMATION_MESSAGE);
            }
        } finally {
            em.close();
        }
        return !aux;
    }

    public boolean atualizar(T t) throws Exception {
        EntityManager em = ConexaoUtil.getEntityManager();
        boolean aux = false;
        try {
            em.getTransaction().begin();
            em.merge(t);
            em.getTransaction().commit();
            aux = true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Erro na classe: " + getTypeClass().getSimpleName() + "\nErro: " + e.getMessage(), "INFORMAÇÃO", JOptionPane.ERROR_MESSAGE);
        } finally {
            em.close();
        }
        return !aux;
    }

    public void remover(Long id) {
        EntityManager em = ConexaoUtil.getEntityManager();
        T t = (T) em.find(getTypeClass(), id);
        try {
            em.getTransaction().begin();
            em.remove(t);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void remover(String matricula) {
        EntityManager em = ConexaoUtil.getEntityManager();
        T t = (T) em.find(getTypeClass(), matricula);
        try {
            em.getTransaction().begin();
            em.remove(t);
            em.getTransaction().commit();
                  System.out.println("matricula: "+ matricula);
        } finally {
            em.close();
        }
    }

    public T buscarPorId(Long id) {
        EntityManager em = ConexaoUtil.getEntityManager();
        return (T) em.find(getTypeClass(), id);
    }

    public List<T> buscarTodos() {
        EntityManager em = ConexaoUtil.getEntityManager();
        return (List<T>) em.createQuery(("FROM " + getTypeClass().getName())).getResultList();
    }

    @SuppressWarnings("unchecked")
    private Class<?> getTypeClass() {
        Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        return clazz;
    }

}
