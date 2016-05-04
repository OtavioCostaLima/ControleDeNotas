package br.com.controle.util.negocio;

import br.com.controle.util.dao.HorarioDAO;
import br.com.controle.util.modelo.Horario;
import java.util.List;

/**
 *
 * @author Otavio Costa
 */
public class HorarioRN implements GenericoRN<Horario> {

    private HorarioDAO horarioDAO;

    @Override
    public boolean salvar(Horario t) {
        horarioDAO = new HorarioDAO();
        return horarioDAO.salvar(t);
    }

    @Override
    public boolean remover(Long id) {
        horarioDAO = new HorarioDAO();
        return horarioDAO.remover(id);
    }

    @Override
    public Horario buscarPorId(Long id) {
        horarioDAO = new HorarioDAO();
        return horarioDAO.buscarPorId(id);
    }

    @Override
    public List<Horario> buscarTodos() {
        horarioDAO = new HorarioDAO();
        return horarioDAO.buscarTodos();
    }
}
