package br.com.controle.util.negocio;

import br.com.controle.util.dao.NotaDAO;
import br.com.controle.util.modelo.Nota;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Otavio Costa
 */
public class NotaRN implements GenericoRN<Nota> {

    NotaDAO notaDAO;

    @Override
    public boolean salvar(Nota nota) {
        try {
            notaDAO = new NotaDAO();
            if (nota.equals(notaDAO.buscarPorId(nota.getId()))) {
                return notaDAO.atualizar(nota);
            }
            return notaDAO.salvar(nota);
        } catch (Exception ex) {
            Logger.getLogger(AlunoRN.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean remover(Long id) {
        notaDAO = new NotaDAO();
        return notaDAO.remover(id);
    }

    @Override
    public Nota buscarPorId(Long id) {
        notaDAO = new NotaDAO();
        return notaDAO.buscarPorId(id);
    }

    @Override
    public List<Nota> buscarTodos() {
        notaDAO = new NotaDAO();
        return notaDAO.buscarTodos();
    }

}
