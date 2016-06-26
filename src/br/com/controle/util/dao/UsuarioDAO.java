package br.com.controle.util.dao;

import br.com.controle.util.ConexaoUtil;
import br.com.controle.util.modelo.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Suporte Técnico
 */
public class UsuarioDAO extends DAOGenerico<Usuario> {

    public Usuario validarUsuario(String nome, String senha) {
        EntityManager entityManager = ConexaoUtil.getEntityManager();
        String consulta = "SELECT u FROM Usuario u WHERE u.nome=:nomeU and u.senha=:senhaU";
        TypedQuery<Usuario> query = entityManager.createQuery(consulta, Usuario.class);
        query.setParameter("nomeU", nome);
        query.setParameter("senhaU", senha);
        List<Usuario> usuarios = query.getResultList();
        if (!usuarios.isEmpty()) {
            return usuarios.get(0);
        }
        return null;
    }

}
