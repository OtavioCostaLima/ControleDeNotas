package br.com.controle.util;

import java.awt.Dialog;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        try {
            //    JRDataSource dados = new JRBeanCollectionDataSource(new HorarioDAO().buscarTodos());
            String caminho = "relatorios/ireport/".concat(nomeArquivo).concat(".jasper");
            JasperPrint printer = JasperFillManager.fillReport(caminho, parametros, conn);
            System.out.println("caminho: "+caminho);
            JasperExportManager.exportReportToPdfFile(printer, caminho);
        } catch (JRException jRException) {
            jRException.printStackTrace();
        }
       
        //JasperViewer view = new JasperViewer(printer, false);
        //  view.setVisible(true);
        // view.toFront();
        // view.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);

    }
}
