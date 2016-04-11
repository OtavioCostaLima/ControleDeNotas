/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controle.util;

import java.util.List;
import java.util.Map;
import javax.swing.JDialog;

/**
 *
 * @author Suporte Técnico
 */
public class ReportUtil {
    //mandando para o Jasper

    public void imprimeRelatorioJasper(String arquivo, List list, Map parametros) 
        JRException, SQLException{
               java.io.InputStream file = getClass().getClassLoader().getResourceAsStream(arquivo);

        JRDataSource dados = new JRBeanCollectionDataSource(list);
        JasperPrint printer = JasperFillManager.fillReport(file, parametros, dados);
        JRViewer view = new JRViewer(printer);
        JDialog dialog = new JDialog();
        dialog.getContentPane().add(view);
        dialog.setVisible(true);
    }
}
