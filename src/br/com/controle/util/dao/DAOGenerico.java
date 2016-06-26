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

    public boolean salvar(T t) {
        EntityManager em = ConexaoUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(t);
            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, " Salvo com Sucesso!", "INFORMAÇÃO", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (Exception exception) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, " Erro ao cadastrar " + getTypeClass().getSimpleName(), "ERRO", JOptionPane.INFORMATION_MESSAGE);
            exception.printStackTrace();
            // JOptionPane.showMessageDialog(null, getTypeClass().getSimpleName() + " já Cadastrada!", "INFORMAÇÃO", JOptionPane.INFORMATION_MESSAGE);
        } finally {
            em.close();
        }
        return false;
    }

    public boolean atualizar(T t) {
        EntityManager em = ConexaoUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(t);
            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, " Alterado com Sucesso!", "INFORMAÇÃO", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Erro na classe: " + getTypeClass().getSimpleName() + "\nErro: " + e.getMessage(), "INFORMAÇÃO", JOptionPane.ERROR_MESSAGE);
        } finally {
            em.close();
        }
        return false;
    }

    public boolean remover(Long id) {
        EntityManager em = ConexaoUtil.getEntityManager();
        T t = (T) em.find(getTypeClass(), id);
        try {
            em.getTransaction().begin();
            em.remove(t);
            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Removido com Sucesso!", "INFORMAÇÃO", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Erro na classe: " + getTypeClass().getSimpleName() + "\nErro: " + e.getMessage(), "INFORMAÇÃO", JOptionPane.ERROR_MESSAGE);
        } finally {
            em.close();
        }
        return false;
    }

    public boolean remover(String matricula) {
        EntityManager em = ConexaoUtil.getEntityManager();
        T t = (T) em.find(getTypeClass(), matricula);
        try {
            em.getTransaction().begin();
            em.remove(t);
            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Removido com Sucesso!", "INFORMAÇÃO", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro na classe: " + getTypeClass().getSimpleName() + "\nErro: " + e.getMessage(), "INFORMAÇÃO", JOptionPane.ERROR_MESSAGE);
        } finally {
            em.close();
        }
        return false;
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
