package br.com.controle.visao;

import br.com.controle.util.modelo.Disciplina;
import br.com.controle.util.modelo.Professor;
import br.com.controle.util.negocio.ProfessorRN;
import br.com.controle.visao.abstractModels.TabelaProfessor;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author Otavio Costa
 */
public class PainelProfessor extends javax.swing.JInternalFrame {

    private final TabelaProfessor TABELA_PROFESSOR = new TabelaProfessor();
    private static PainelProfessor painelProfessor;
    private final DefaultListModel<Disciplina> listModel = new DefaultListModel<>();
    private String urlfoto;

    /**
     * Creates new form PainelProfessor
     */
    private PainelProfessor() {
        initComponents();
        ((BasicInternalFrameUI) getUI()).setNorthPane(null);
        jListDisciplinas.setModel(listModel);
        tabelaPesquisarProfessor();
        TextPrompt prompt = new TextPrompt("Nome do Professor", textoNomeProfessor);
        prompt.setForeground(Color.GRAY);
    }

    public static PainelProfessor getInstancia() {
        if (painelProfessor == null) {
            painelProfessor = new PainelProfessor();
        }
        return painelProfessor;
    }

    private Professor encapsular() {
        Professor professor = new Professor();
        professor.setMatricula(textoMatriculaProfessor.getText());
        professor.setNome(textoNomeProfessor.getText());
        List<Disciplina> disciplinas;
        if (!listModel.isEmpty()) {
            disciplinas = new ArrayList<>();
            for (int i = 0; i < listModel.getSize(); i++) {
                disciplinas.add(listModel.get(i));
            }
            professor.setDisciplinas(disciplinas);
        }
        return professor;
    }

    private void tabelaPesquisarProfessor() {
        TABELA_PROFESSOR.addListaProfessor(new ProfessorRN().buscarTodos());
        tabelaPesquisaprofessor.setModel(TABELA_PROFESSOR);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        painelCadastroProfessor = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        textoNomeProfessor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textoMatriculaProfessor = new javax.swing.JTextField();
        checkStatus = new javax.swing.JCheckBox();
        campoImagemProfessor = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListDisciplinas = new javax.swing.JList();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        btnSalvar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        btnSalvar1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaPesquisaprofessor = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();

        setBorder(null);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setBackground(new java.awt.Color(158, 158, 158));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("X");
        jButton1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 1034, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        getContentPane().add(jPanel5, java.awt.BorderLayout.NORTH);

        jPanel1.setLayout(new java.awt.CardLayout());

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        painelCadastroProfessor.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Professor"));

        textoNomeProfessor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));

        jLabel1.setText("Nome: *");

        jLabel2.setText("Matrícula: *");

        textoMatriculaProfessor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));

        checkStatus.setBackground(new java.awt.Color(255, 255, 255));
        checkStatus.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        checkStatus.setForeground(new java.awt.Color(204, 0, 0));
        checkStatus.setText("Ativo");
        checkStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkStatusActionPerformed(evt);
            }
        });

        campoImagemProfessor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        campoImagemProfessor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/controle/visao/icones/professor.png"))); // NOI18N
        campoImagemProfessor.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        campoImagemProfessor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        campoImagemProfessor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        campoImagemProfessor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoImagemProfessorMouseClicked(evt);
            }
        });

        jListDisciplinas.setBorder(javax.swing.BorderFactory.createTitledBorder("Disciplinas"));
        jScrollPane1.setViewportView(jListDisciplinas);

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/controle/visao/icones/line32.png"))); // NOI18N
        jButton8.setContentAreaFilled(false);
        jButton8.setFocusable(false);
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/controle/visao/icones/add64.png"))); // NOI18N
        jButton9.setContentAreaFilled(false);
        jButton9.setFocusable(false);
        jButton9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(textoMatriculaProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(checkStatus)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(textoNomeProfessor)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 795, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoImagemProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textoMatriculaProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(checkStatus))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(textoNomeProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton9)
                                .addGap(18, 18, 18)
                                .addComponent(jButton8))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(campoImagemProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        btnSalvar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalvar.setForeground(new java.awt.Color(255, 0, 0));
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/controle/visao/icones/save32px.png"))); // NOI18N
        btnSalvar.setText("SALVAR");
        btnSalvar.setContentAreaFilled(false);
        btnSalvar.setFocusable(false);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 0, 0));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/controle/visao/icones/erase7.png"))); // NOI18N
        jButton3.setText("EXCLUIR");
        jButton3.setContentAreaFilled(false);
        jButton3.setFocusable(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 0, 0));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/controle/visao/icones/carteirinha.png"))); // NOI18N
        jButton4.setText("GERAR CARTEIRINHA");
        jButton4.setContentAreaFilled(false);
        jButton4.setFocusable(false);

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 0, 0));
        jButton5.setText("LIMPAR");
        jButton5.setContentAreaFilled(false);
        jButton5.setFocusable(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        btnSalvar1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalvar1.setForeground(new java.awt.Color(255, 0, 0));
        btnSalvar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/controle/visao/icones/save32px.png"))); // NOI18N
        btnSalvar1.setText("SALVAR");
        btnSalvar1.setContentAreaFilled(false);
        btnSalvar1.setFocusable(false);
        btnSalvar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5))
                    .addComponent(btnSalvar1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalvar1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        tabelaPesquisaprofessor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabelaPesquisaprofessor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaPesquisaprofessorMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelaPesquisaprofessor);

        javax.swing.GroupLayout painelCadastroProfessorLayout = new javax.swing.GroupLayout(painelCadastroProfessor);
        painelCadastroProfessor.setLayout(painelCadastroProfessorLayout);
        painelCadastroProfessorLayout.setHorizontalGroup(
            painelCadastroProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCadastroProfessorLayout.createSequentialGroup()
                .addGroup(painelCadastroProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(painelCadastroProfessorLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(painelCadastroProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1037, Short.MAX_VALUE))))
                .addContainerGap())
        );
        painelCadastroProfessorLayout.setVerticalGroup(
            painelCadastroProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCadastroProfessorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Professor", painelCadastroProfessor);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1061, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 522, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Dados", jPanel3);

        jPanel1.add(jTabbedPane1, "card3");

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        painelProfessor = null;
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void checkStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkStatusActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        ProfessorRN professorRN = new ProfessorRN();
        if (professorRN.salvar(encapsular())) {
            limparCampos();
            TABELA_PROFESSOR.inserirAlunos(professorRN.buscarTodos());
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (!textoMatriculaProfessor.getText().isEmpty() && tabelaPesquisaprofessor.isRowSelected(tabelaPesquisaprofessor.getSelectedRow())) {
            ProfessorRN professorRN = new ProfessorRN();
            if (professorRN.remover(textoMatriculaProfessor.getText())) {
                TABELA_PROFESSOR.delProfessor(tabelaPesquisaprofessor.getSelectedRow());
                limparCampos();
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        if (!textoMatriculaProfessor.getText().trim().isEmpty()) {
            SelecionarDisciplina disciplina = new SelecionarDisciplina(null, true);
            disciplina.buscarDisciplinas(textoMatriculaProfessor.getText());
            disciplina.setVisible(true);
            listModel.insertElementAt(disciplina.getDisciplina(), listModel.size());
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecione um Professor!", "Nenhum Professor selecionado!", JOptionPane.INFORMATION_MESSAGE);
        }
// TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        if (jListDisciplinas.getSelectedIndex() > -1) {
            listModel.remove(jListDisciplinas.getSelectedIndex());
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void campoImagemProfessorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoImagemProfessorMouseClicked
        if (evt.getClickCount() == 2) {
            GerenteDeArquivos gerenteDeArquivos = new GerenteDeArquivos();
            urlfoto = gerenteDeArquivos.escolherImagem(campoImagemProfessor);
        }   // TODO add your handling code here:
    }//GEN-LAST:event_campoImagemProfessorMouseClicked

    private void tabelaPesquisaprofessorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaPesquisaprofessorMouseClicked
        if (tabelaPesquisaprofessor.isRowSelected(tabelaPesquisaprofessor.getSelectedRow())) {
            Professor professor = TABELA_PROFESSOR.getProfessor(tabelaPesquisaprofessor.getSelectedRow());
            textoNomeProfessor.setText(professor.getNome());
            textoMatriculaProfessor.setText(professor.getMatricula());
            listModel.clear();
            for (Disciplina disciplina : professor.getDisciplinas()) {
                listModel.addElement(disciplina);
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_tabelaPesquisaprofessorMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        limparCampos();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnSalvar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalvar1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnSalvar1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel campoImagemProfessor;
    private javax.swing.JCheckBox checkStatus;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList jListDisciplinas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel painelCadastroProfessor;
    private javax.swing.JTable tabelaPesquisaprofessor;
    private javax.swing.JTextField textoMatriculaProfessor;
    private javax.swing.JTextField textoNomeProfessor;
    // End of variables declaration//GEN-END:variables

    private void limparCampos() {
        textoMatriculaProfessor.setText(null);
        textoNomeProfessor.setText(null);
        listModel.clear();
    }
}
