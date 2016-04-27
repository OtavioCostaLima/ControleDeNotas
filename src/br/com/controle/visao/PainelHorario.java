package br.com.controle.visao;

import br.com.controle.util.modelo.Disciplina;
import br.com.controle.util.modelo.Horario;
import br.com.controle.util.modelo.HorarioPK;
import br.com.controle.util.modelo.Professor;
import br.com.controle.util.modelo.Turma;
import br.com.controle.util.negocio.HorarioRN;
import br.com.controle.util.negocio.ProfessorRN;
import br.com.controle.util.negocio.TurmaRN;
import br.com.controle.visao.abstractModels.GenericComboBoxModel;
import br.com.controle.visao.abstractModels.TabelaProfessor;
import com.sun.glass.events.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author Otavio Costa
 */
public class PainelHorario extends javax.swing.JInternalFrame {

    private GenericComboBoxModel<Turma> boxModelTurma;
    private final TabelaProfessor TABELA_PROFESSOR = new TabelaProfessor();
    private static PainelHorario painelHorario;
    private final DefaultListModel<Disciplina> listModelDiscipinas = new DefaultListModel<>();

    /**
     * Creates new form PainelProfessor
     */
    private PainelHorario() {
        initComponents();
        ((BasicInternalFrameUI) getUI()).setNorthPane(null);
        meuInitComponents();
    }

    private void meuInitComponents() {
        tabelaPesquisarProfessor();
        povoarComboboxTurma();
        jListDisciplinas.setModel(listModelDiscipinas);
    }

    public static PainelHorario getInstancia() {
        if (painelHorario == null) {
            painelHorario = new PainelHorario();
        }
        return painelHorario;
    }

    private void povoarComboboxTurma() {
        ArrayList<Turma> turma = (ArrayList<Turma>) new TurmaRN().buscarTodos();
        boxModelTurma = new GenericComboBoxModel(turma);
        comboTurma.setModel(boxModelTurma);
        if (comboTurma.getItemCount() > 0) {
            comboTurma.setSelectedIndex(0);
        }
    }

    private Professor encapsular() {
        ProfessorRN professorRN = new ProfessorRN();
        Professor professor = null;
        int index = tabelaPesquisaprofessor.getSelectedRow();

        if (tabelaPesquisaprofessor.isRowSelected(index)) {
            professor = professorRN.buscarPorId(TABELA_PROFESSOR.getProfessor(index).getMatricula());
            List<Disciplina> disciplinas = new ArrayList<>();
            List<Horario> horarios = new ArrayList<>();

            if (!listModelDiscipinas.isEmpty()) {
                for (int i = 0; i < listModelDiscipinas.getSize(); i++) {
                    disciplinas.add(listModelDiscipinas.get(i));
                }

                for (Disciplina disciplina : disciplinas) {
                    Horario horario = new Horario();
                    HorarioPK pK = new HorarioPK(professor.getMatricula(), disciplina.getId());
                    horario.setHorarioPK(pK);
                    horario.setDisciplina(disciplina);
                    horario.setProfessor(professor);

                    if (comboTurma.getSelectedIndex() > -1) {
                        horario.setTurma(boxModelTurma.get(comboTurma.getSelectedIndex()));
                    }
                    horarios.add(horario);
                }
                professor.setHorarios(horarios);
            }
        }
        return professor;
    }

    private List<Horario> encapsular1() {
        HorarioRN professorRN = new HorarioRN();
        Professor professor = null;
        List<Horario> horarios =null;
        int index = tabelaPesquisaprofessor.getSelectedRow();

        if (tabelaPesquisaprofessor.isRowSelected(index)) {
            professor = professorRN.buscarPorId(TABELA_PROFESSOR.getProfessor(index).getMatricula());
            List<Disciplina> disciplinas = new ArrayList<>();
            horarios = new ArrayList<>();

            if (!listModelDiscipinas.isEmpty()) {
                for (int i = 0; i < listModelDiscipinas.getSize(); i++) {
                    disciplinas.add(listModelDiscipinas.get(i));
                }

                for (Disciplina disciplina : disciplinas) {
                    Horario horario = new Horario();
                    HorarioPK pK = new HorarioPK(professor.getMatricula(), disciplina.getId());
                    horario.setHorarioPK(pK);
                    horario.setDisciplina(disciplina);
                    horario.setProfessor(professor);

                    if (comboTurma.getSelectedIndex() > -1) {
                        horario.setTurma(boxModelTurma.get(comboTurma.getSelectedIndex()));
                    }
                    horarios.add(horario);
                }
                professor.setHorarios(horarios);
            }
        }
        return horarios;
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
        campoImagemProfessor = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaPesquisaprofessor = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        btnSalvar = new javax.swing.JButton();
        jBExclir = new javax.swing.JButton();
        jBLimpar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListDisciplinas = new javax.swing.JList();
        comboTurma = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

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
                .addGap(0, 858, Short.MAX_VALUE)
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

        textoMatriculaProfessor.setEditable(false);
        textoMatriculaProfessor.setBackground(new java.awt.Color(255, 255, 255));
        textoMatriculaProfessor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));

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
        tabelaPesquisaprofessor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tabelaPesquisaprofessorKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tabelaPesquisaprofessorKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tabelaPesquisaprofessor);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textoMatriculaProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textoNomeProfessor)))
                    .addComponent(jScrollPane2))
                .addGap(10, 10, 10)
                .addComponent(campoImagemProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(campoImagemProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textoMatriculaProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(textoNomeProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)))
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

        jBExclir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBExclir.setForeground(new java.awt.Color(255, 0, 0));
        jBExclir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/controle/visao/icones/erase7.png"))); // NOI18N
        jBExclir.setText("EXCLUIR");
        jBExclir.setContentAreaFilled(false);
        jBExclir.setFocusable(false);
        jBExclir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExclirActionPerformed(evt);
            }
        });

        jBLimpar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBLimpar.setForeground(new java.awt.Color(255, 0, 0));
        jBLimpar.setText("LIMPAR");
        jBLimpar.setContentAreaFilled(false);
        jBLimpar.setFocusable(false);
        jBLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBExclir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBLimpar)
                .addContainerGap(508, Short.MAX_VALUE))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnSalvar, jBExclir, jBLimpar});

        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBExclir, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        jListDisciplinas.setBorder(javax.swing.BorderFactory.createTitledBorder("Disciplinas"));
        jScrollPane1.setViewportView(jListDisciplinas);

        comboTurma.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "turma" }));
        comboTurma.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboTurmaItemStateChanged(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Turma:");

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/controle/visao/icones/add64.png"))); // NOI18N
        jButton9.setContentAreaFilled(false);
        jButton9.setFocusable(false);
        jButton9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/controle/visao/icones/line32.png"))); // NOI18N
        jButton8.setContentAreaFilled(false);
        jButton8.setFocusable(false);
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

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
                            .addGroup(painelCadastroProfessorLayout.createSequentialGroup()
                                .addGroup(painelCadastroProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(painelCadastroProfessorLayout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(8, 8, 8)
                                        .addComponent(comboTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 786, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(painelCadastroProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton9)
                                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );

        painelCadastroProfessorLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton8, jButton9});

        painelCadastroProfessorLayout.setVerticalGroup(
            painelCadastroProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCadastroProfessorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelCadastroProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(painelCadastroProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelCadastroProfessorLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jButton8))
                    .addGroup(painelCadastroProfessorLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painelCadastroProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton9)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Professor", painelCadastroProfessor);

        jPanel1.add(jTabbedPane1, "card3");

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        painelHorario = null;
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        ProfessorRN professorRN = new ProfessorRN();
        Professor professor = encapsular();
        if (professorRN.salvar(professor)) {
            limparCampos();
            tabelaPesquisarProfessor();
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void jBExclirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExclirActionPerformed
        /*  if (!textoMatriculaProfessor.getText().isEmpty() && tabelaPesquisaprofessor.isRowSelected(tabelaPesquisaprofessor.getSelectedRow())) {
         ProfessorRN professorRN = new ProfessorRN();
         if (professorRN.remover(TABELA_PROFESSOR.delProfessor(tabelaPesquisaprofessor.getSelectedRow()).getMatricula())) {
         Professor professor = TABELA_PROFESSOR.delProfessor(tabelaPesquisaprofessor.getSelectedRow());
         GerenteDeArquivos gerenteDeArquivos = new GerenteDeArquivos();
         gerenteDeArquivos.removerImagem("./fotos/" + professor.getMatricula() + "".concat(".jpg"));
         limparCampos();
         }
         }*/
    }//GEN-LAST:event_jBExclirActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        int index = tabelaPesquisaprofessor.getSelectedRow();
        if (tabelaPesquisaprofessor.isRowSelected(index)) {
            Long matriculaProfessor = TABELA_PROFESSOR.getProfessor(index).getMatricula();
            Long idTurma = boxModelTurma.get(comboTurma.getSelectedIndex()).getId();
            SelecionarDisciplina selecionarDisciplina = new SelecionarDisciplina(null, true);
            selecionarDisciplina.buscarDisciplinas(matriculaProfessor, idTurma);
            selecionarDisciplina.setVisible(true);
            if (!listModelDiscipinas.contains(selecionarDisciplina.getDisciplina())) {
                listModelDiscipinas.insertElementAt(selecionarDisciplina.getDisciplina(), listModelDiscipinas.size());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um Professor!", "INFORMAÇÃO", JOptionPane.INFORMATION_MESSAGE);
        }

// TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        if (jListDisciplinas.getSelectedIndex() > -1) {
            Disciplina disciplina = listModelDiscipinas.get(jListDisciplinas.getSelectedIndex());
            HorarioRN horario = new HorarioRN();
            HorarioPK pK = new HorarioPK(Long.valueOf(textoMatriculaProfessor.getText()), disciplina.getId());
            horario.removerHorario(pK);
            listModelDiscipinas.remove(jListDisciplinas.getSelectedIndex());

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void campoImagemProfessorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoImagemProfessorMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_campoImagemProfessorMouseClicked

    private void tabelaPesquisaprofessorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaPesquisaprofessorMouseClicked
        selecionaProfessorNaTabela();
    }//GEN-LAST:event_tabelaPesquisaprofessorMouseClicked

    private void selecionaProfessorNaTabela() {
        int index = tabelaPesquisaprofessor.getSelectedRow();
        if (tabelaPesquisaprofessor.isRowSelected(index)) {
            Professor professor = TABELA_PROFESSOR.getProfessor(index);
            textoNomeProfessor.setText(professor.getNome());
            textoMatriculaProfessor.setText(String.valueOf(professor.getMatricula()));
            GerenteDeArquivos gerenteDeArquivos = new GerenteDeArquivos();
            if (!gerenteDeArquivos.setImagemJlabel("./fotos/" + professor.getMatricula() + "".concat(".jpg"), campoImagemProfessor)) {
                campoImagemProfessor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/controle/visao/icones/professor.png")));
            }
            if (comboTurma.getSelectedIndex() >= 0) {
                listModelDiscipinas.clear();
                if (professor.getHorarios() != null) {
                    for (Horario horario : professor.getHorarios()) {
                        if (Objects.equals(horario.getTurma().getId(), boxModelTurma.get(comboTurma.getSelectedIndex()).getId())) {
                            listModelDiscipinas.addElement(horario.getDisciplina());
                        }
                    }
                }
            }

        }        // TODO add your handling code here:
    }

    private void jBLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimparActionPerformed
        limparCampos();        // TODO add your handling code here:
    }//GEN-LAST:event_jBLimparActionPerformed

    private void comboTurmaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboTurmaItemStateChanged
        selecionaProfessorNaTabela();        // TODO add your handling code here:
    }//GEN-LAST:event_comboTurmaItemStateChanged

    private void tabelaPesquisaprofessorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaPesquisaprofessorKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelaPesquisaprofessorKeyPressed

    private void tabelaPesquisaprofessorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaPesquisaprofessorKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_DOWN) {
            selecionaProfessorNaTabela();
        }          // TODO add your handling code here:
    }//GEN-LAST:event_tabelaPesquisaprofessorKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel campoImagemProfessor;
    private javax.swing.JComboBox comboTurma;
    private javax.swing.JButton jBExclir;
    private javax.swing.JButton jBLimpar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList jListDisciplinas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
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
        listModelDiscipinas.clear();
        campoImagemProfessor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/controle/visao/icones/professor.png")));
    }
}
