/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controle.util;

import br.com.controle.util.dao.HorarioDAO;
import br.com.controle.util.modelo.Horario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
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
        parametros.put("matriculaP", "1");
        reportUtil.imprimeRelatorio("relatorios/ireport/RecebimentoProvas.jasper", parametros);
    }
}
