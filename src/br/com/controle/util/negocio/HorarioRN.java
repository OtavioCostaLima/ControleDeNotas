package br.com.controle.util.negocio;

import br.com.controle.util.dao.HorarioDAO;
import br.com.controle.util.modelo.HorarioPK;

/**
 *
 * @author Otavio Costa
 */
public class HorarioRN {

    private HorarioDAO horarioDAO;

    
    

public void removerHorario(HorarioPK pK){
horarioDAO = new HorarioDAO();
horarioDAO.removerHorario(pK);

}
}
