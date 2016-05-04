/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controle.util.negocio;

import br.com.controle.util.dao.UsuarioDAO;
import br.com.controle.util.modelo.Usuario;
import java.util.List;

/**
 *
 * @author Otavio Costa
 */
public class UsuarioRN implements GenericoRN<Usuario> {

    UsuarioDAO usuarioDAO;

    @Override
    public boolean salvar(Usuario t) {
        usuarioDAO = new UsuarioDAO();
        return usuarioDAO.salvar(t);
    }

    @Override
    public boolean remover(Long id) {
        usuarioDAO = new UsuarioDAO();
        return usuarioDAO.remover(id);
    }

    @Override
    public Usuario buscarPorId(Long id) {
        usuarioDAO = new UsuarioDAO();
        return usuarioDAO.buscarPorId(id);
    }

    @Override
    public List<Usuario> buscarTodos() {
        usuarioDAO = new UsuarioDAO();
        return usuarioDAO.buscarTodos();
    }

    public Usuario validaUsuario(String nome, String senha) {
        usuarioDAO = new UsuarioDAO();
        return usuarioDAO.validarUsuario(nome, senha);
    }

}
