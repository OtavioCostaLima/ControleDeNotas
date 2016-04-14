package br.com.controle.util;

import java.awt.Dialog;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Suporte Técnico
 */
public class ReportUtil {
    //mandando para o Jasper

    public void imprimeRelatorio(String nomeArquivo, Map parametros) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda", "root", "root");
        } catch (SQLException sQLException) {
            sQLException.printStackTrace();
        }
        String caminho = System.getProperty("user.dir").concat(nomeArquivo);
        try {
            JasperPrint printer = JasperFillManager.fillReport(caminho, parametros, conn);
            JasperExportManager.exportReportToPdfFile(printer, System.getProperty("user.dir").concat("o.pdf"));
            JasperViewer view = new JasperViewer(printer, false);
            if (!(printer.getPages().size() <= 0)) {
                JDialog dialog = new JDialog(new javax.swing.JFrame(), "Visualização do Relatório", true);
                dialog.setSize(view.getWidth(), view.getHeight());
                dialog.setLocationRelativeTo(null);
                dialog.getContentPane().add(view.getContentPane());
                dialog.setVisible(true);
            } else {
                System.out.println("sem paginas");
            }

        } catch (JRException ex) {
            Logger.getLogger(ReportUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
