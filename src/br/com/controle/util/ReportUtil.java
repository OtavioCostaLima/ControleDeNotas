package br.com.controle.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Suporte Técnico
 */
public class ReportUtil {
    //mandando para o Jasper

    public void imprimeRelatorio(String caminho, Map parametros) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda", "root", "root");
        } catch (SQLException sQLException) {
            sQLException.printStackTrace();
        }
        try {
            //    JRDataSource dados = new JRBeanCollectionDataSource(new HorarioDAO().buscarTodos());
            JasperPrint printer = JasperFillManager.fillReport(caminho, parametros, conn);
            JasperViewer view = new JasperViewer(printer, false);
            view.setVisible(true);
            view.toFront();
        } catch (JRException jRException) {
            jRException.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ReportUtil reportUtil = new ReportUtil();
        Map<String, String> parametros = new HashMap();
        parametros.put("matriculaP", "2");
        reportUtil.imprimeRelatorio("relatorios/ireport/RecebimentoProvas.jasper", parametros);
    }
}
