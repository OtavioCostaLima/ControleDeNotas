/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controle.visao;

import br.com.controle.util.ReportUtil;
import br.com.controle.util.dao.DisciplinaDAO;
import br.com.controle.util.dao.ProfessorDAO;
import br.com.controle.util.dao.TurmaDAO;
import br.com.controle.util.modelo.Disciplina;
import br.com.controle.util.modelo.Turma;
import br.com.controle.visao.abstractModels.GenericComboBoxModel;
import br.com.controle.visao.abstractModels.TabelaProfessor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Otavio Costa
 */
public class PainelProtocolo extends javax.swing.JDialog {

    TabelaProfessor tabelaProfessor = new TabelaProfessor();
    GenericComboBoxModel<Turma> comboBoxModelTurma;
    GenericComboBoxModel<Disciplina> comboBoxDisciplina;

    /**
     * Creates new form RelatoriosP
     *
     * @param parent
     * @param modal
     */
    public PainelProtocolo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        tabelaProfessor.inserirProfessores(new ProfessorDAO().buscarTodos());
        jTable1.setModel(tabelaProfessor);
    }

        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jCDisciplina = new javax.swing.JComboBox<String>();
        jCTurma = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jButton2.setText("GERAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("DISCIPLINA");

        jCDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCDisciplinaActionPerformed(evt);
            }
        });

        jCTurma.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCTurmaItemStateChanged(evt);
            }
        });
        jCTurma.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                jCTurmaHierarchyChanged(evt);
            }
        });
        jCTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCTurmaActionPerformed(evt);
            }
        });

        jLabel2.setText("TURMA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jCDisciplina, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCTurma, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int index = jTable1.getSelectedRow();
        if (jTable1.isRowSelected(index)) {
            ReportUtil reportUtil = new ReportUtil();
            Map<Object, Object> parametros = new HashMap();
            parametros.put("matriculaP", tabelaProfessor.getProfessor(index).getMatricula());
            parametros.put("idTurma", comboBoxModelTurma.get(jCTurma.getSelectedIndex()).getId());
            parametros.put("idDisciplina", comboBoxDisciplina.get(jCDisciplina.getSelectedIndex()).getId());
            reportUtil.imprimeRelatorio("relatorios/ireport/RecebimentoProvas.jasper", parametros);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int index = jTable1.getSelectedRow();
        if (jTable1.isRowSelected(index)) {
            ArrayList<Turma> turmas = (ArrayList<Turma>) new TurmaDAO().tumasProfessor(tabelaProfessor.getProfessor(index).getMatricula());
            comboBoxModelTurma = new GenericComboBoxModel<>(turmas);
            jCTurma.setModel(comboBoxModelTurma);
            jCTurma.setSelectedIndex(0);
        }   // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void jCTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCTurmaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCTurmaActionPerformed

    private void jCTurmaHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_jCTurmaHierarchyChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jCTurmaHierarchyChanged

    private void jCTurmaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCTurmaItemStateChanged
        if (jCTurma.getSelectedIndex() >= 0) {
            int index = jTable1.getSelectedRow();
            ArrayList<Disciplina> disciplinas = (ArrayList<Disciplina>) new DisciplinaDAO().getdDsciplinaTurmaProfessor(tabelaProfessor.getProfessor(index).getMatricula(), comboBoxModelTurma.get(jCTurma.getSelectedIndex()).getId());
            comboBoxDisciplina = new GenericComboBoxModel<>(disciplinas);
            jCDisciplina.setModel(comboBoxDisciplina);
            jCDisciplina.setSelectedIndex(0);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jCTurmaItemStateChanged

    private void jCDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCDisciplinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCDisciplinaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PainelProtocolo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PainelProtocolo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PainelProtocolo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PainelProtocolo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PainelProtocolo dialog = new PainelProtocolo(new javax.swing.JFrame(), false);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jCDisciplina;
    private javax.swing.JComboBox jCTurma;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
