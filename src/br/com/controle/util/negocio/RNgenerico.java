package br.com.controle.util.negocio;

import br.com.controle.util.modelo.BeanBase;
import java.util.List;

/**
 *
 * @author Otavio Costa
 * @param <T>
 */
public interface RNgenerico<T extends BeanBase> {

    boolean salvar(T t);

    void remover(Long id);

    T buscarPorId(Long id);

    List<T> buscarTodos();
}
