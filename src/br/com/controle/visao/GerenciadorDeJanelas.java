package br.com.controle.visao;

import java.awt.Dimension;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Otavio Costa
 * @param <T>
 */
public class GerenciadorDeJanelas<T extends JInternalFrame> {

    private static JDesktopPane DESKTOP_PANE;
    private T t;

    public GerenciadorDeJanelas(JDesktopPane desktopPane) {
        GerenciadorDeJanelas.DESKTOP_PANE = desktopPane;

    }

    public void openInternalFrame(T janela) {
        this.t = janela;
        if (janela.isVisible()) {
            janela.toFront();
            janela.requestFocus();
        } else {
            DESKTOP_PANE.add(janela);
            janela.setVisible(true);
        }
    }

    public static JDesktopPane getDESKTOP_PANE() {
        if (DESKTOP_PANE==null) {
            JOptionPane.showMessageDialog(null, "Não extiste um painel de Area de Trabalho disponivel!");
        }
        return DESKTOP_PANE;
    }

    public void setDESKTOP_PANE(JDesktopPane DESKTOP_PANE) {
        GerenciadorDeJanelas.DESKTOP_PANE = DESKTOP_PANE;
    }

    private void setPosicao() {
        Dimension d = GerenciadorDeJanelas.getDESKTOP_PANE().getSize();
        t.setLocation((d.width - t.getSize().width) / 2, (d.height - t.getSize().height) / 2);
    }
}
