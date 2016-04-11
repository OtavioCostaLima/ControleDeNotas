/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controle.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JDialog;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author Suporte Técnico
 */
public class ReportUtil {
    //mandando para o Jasper

    public void imprimeRelatorio(String caminho, List lista, Map parametros) throws JRException {
        java.io.InputStream file = getClass().getClassLoader().getResourceAsStream(caminho);
        JRDataSource dados = new JRBeanCollectionDataSource(lista);
        JasperPrint printer = JasperFillManager.fillReport(file, parametros, dados);
        JRViewer view = new JRViewer(printer);
        JDialog dialog = new JDialog();
        dialog.getContentPane().add(view);
        dialog.setVisible(true);
    }

    public static void main(String[] args) throws JRException {
        ReportUtil reportUtil = new ReportUtil();
        Map parametros = new HashMap();
        parametros.put("matriculaP", "1");
        reportUtil.imprimeRelatorio("relatorios/ireport/RecebimentoProvas", null, parametros);
    }
}
