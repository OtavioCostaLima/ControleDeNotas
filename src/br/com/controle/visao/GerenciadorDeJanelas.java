package br.com.controle.visao;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseMotionListener;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

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
            bloquearIFrames(janela);
        }
    }

    public static JDesktopPane getDESKTOP_PANE() {
        if (DESKTOP_PANE == null) {
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

    private void bloquearIFrames(JInternalFrame jInternalFrame) {
        BasicInternalFrameUI ui = (BasicInternalFrameUI) jInternalFrame.getUI();
        Component north = ui.getNorthPane();
        if (north != null) {
            MouseMotionListener[] actions = (MouseMotionListener[]) north.getListeners(MouseMotionListener.class);
            for (MouseMotionListener action : actions) {
                north.removeMouseMotionListener(action);
            }
        }
    }
}
