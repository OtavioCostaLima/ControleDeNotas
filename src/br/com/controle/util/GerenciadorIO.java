package br.com.controle.util;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Otavio Costa
 */
public class GerenciadorIO {

    public void SalvarImagens(String caminho) throws IOException {
        File arquivo = new File(caminho);
        if (arquivo.isFile()) {
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }
        }

    }

    public void excluirImagens(String caminho) {
    }

    public void rollback() {
    }

    public void comint() {
    }

}
