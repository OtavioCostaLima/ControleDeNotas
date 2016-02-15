package br.com.controle.visao;

import br.com.controle.util.modelo.Aluno;
import br.com.controle.util.modelo.Turma;
import br.com.controle.util.negocio.AlunoRN;
import br.com.controle.util.negocio.TurmaRN;
import br.com.controle.visao.abstractModels.GenericComboBoxModel;
import br.com.controle.visao.abstractModels.TabelaAluno;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author Otavio Costa
 */
public class PainelAlunos extends javax.swing.JInternalFrame {

    List<Aluno> novosAlunos = new ArrayList<>();
    private GenericComboBoxModel<Turma> boxModelTurma;
    private final TabelaAluno TABELA_ALUNO = new TabelaAluno();
    private static PainelAlunos CADASTRO_ALUNOS;
    private String urlfoto = "";

    /**
     * Creates new form CadastroAlunos
     */
    private PainelAlunos() {
        initComponents();
        ((BasicInternalFrameUI) getUI()).setNorthPane(null);
        povoartabelaAluno();
        povoarComboboxTurma();
    }

    private void povoarComboboxTurma() {
        ArrayList<Turma> turma = (ArrayList<Turma>) new TurmaRN().buscarTodos();
        boxModelTurma = new GenericComboBoxModel(turma);
        comboTurma.setModel(boxModelTurma);
    }

    public static synchronized PainelAlunos getInstancia() {
        if (CADASTRO_ALUNOS == null) {
            CADASTRO_ALUNOS = new PainelAlunos();
        }
        return CADASTRO_ALUNOS;
    }

    private void povoartabelaAluno() {
        TABELA_ALUNO.addListaAluno(new AlunoRN().buscarTodos());
        tabelaCadastro.setModel(TABELA_ALUNO);
    }

    private Aluno encapsulaAluno() {
        Aluno aluno = new Aluno();
        aluno.setMatricula(campoMatricula.getText());
        aluno.setNome(campoNomeAluno.getText());
        aluno.setTurma(boxModelTurma.get(comboTurma.getSelectedIndex()));
        aluno.setuRLImagem(urlfoto);
        aluno.setSituacao(comboSituacao.getSelectedItem().toString());
        aluno.setDataCadastro(jDateChooser1.getDate());

        if (checkStatus.isSelected()) {
            aluno.setStatus("ATIVO");
        } else {
            aluno.setStatus("INATIVO");
        }
        return aluno;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoSexo = new javax.swing.ButtonGroup();
        grupoQuestao1 = new javax.swing.ButtonGroup();
        grupoQuestao2 = new javax.swing.ButtonGroup();
        grupoQuestao3 = new javax.swing.ButtonGroup();
        grupoQuestao4 = new javax.swing.ButtonGroup();
        grupoQuestao5 = new javax.swing.ButtonGroup();
        grupoQuestao6 = new javax.swing.ButtonGroup();
        jPanel4 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        subJPanelMatricula = new javax.swing.JPanel();
        jPanelMatricula = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaCadastro = new javax.swing.JTable();
        campoImagemAluno = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        campoMatricula = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        comboTurma = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        campoNomeAluno = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel28 = new javax.swing.JLabel();
        comboSituacao = new javax.swing.JComboBox();
        checkStatus = new javax.swing.JCheckBox();
        jLabel29 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        btnSalvar = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnAdicionar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        jPanelAluno = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jPanel16 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jPanel7 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jPanel13 = new javax.swing.JPanel();
        jTextField7 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jPanelResponsavel = new javax.swing.JPanel();
        jPanelQuestionario = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jRadioButton9 = new javax.swing.JRadioButton();
        jRadioButton10 = new javax.swing.JRadioButton();
        jRadioButton11 = new javax.swing.JRadioButton();
        jRadioButton12 = new javax.swing.JRadioButton();
        jRadioButton13 = new javax.swing.JRadioButton();
        jRadioButton14 = new javax.swing.JRadioButton();
        jPanel15 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();

        setBorder(null);
        setClosable(true);
        setForeground(java.awt.Color.white);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(900, 627));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jButton4.setBackground(new java.awt.Color(158, 158, 158));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("x");
        jButton4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 915, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        getContentPane().add(jPanel4, java.awt.BorderLayout.NORTH);

        jPanel3.setLayout(new java.awt.CardLayout());

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanelMatricula.setBackground(new java.awt.Color(255, 255, 255));

        tabelaCadastro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod. Barras", "Nome", "Turma"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaCadastro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaCadastroMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabelaCadastro);

        campoImagemAluno.setBackground(new java.awt.Color(255, 255, 255));
        campoImagemAluno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        campoImagemAluno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/controle/visao/icones/aluno.png"))); // NOI18N
        campoImagemAluno.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        campoImagemAluno.setFocusable(false);
        campoImagemAluno.setOpaque(true);
        campoImagemAluno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoImagemAlunoMouseClicked(evt);
            }
        });

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Dados da Matricula"));

        jLabel1.setText("Matrícula: *");

        campoMatricula.setEditable(false);
        campoMatricula.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));

        jLabel5.setText("Data Cadastro: *");

        comboTurma.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        comboTurma.setForeground(new java.awt.Color(204, 0, 0));
        comboTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTurmaActionPerformed(evt);
            }
        });

        jLabel3.setText("Turma: *");

        campoNomeAluno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        campoNomeAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNomeAlunoActionPerformed(evt);
            }
        });

        jLabel2.setText("Nome: *");

        jLabel28.setText("Situação: *");

        comboSituacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CURSANDO", "DESISTENTE", "REPROVADO", "APROVADO" }));

        checkStatus.setBackground(new java.awt.Color(255, 255, 255));
        checkStatus.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        checkStatus.setForeground(new java.awt.Color(204, 0, 0));
        checkStatus.setText("Ativo");

        jLabel29.setText("Status: *");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel28)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(comboSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(campoMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(186, 186, 186)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel29)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(checkStatus))
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(campoNomeAluno)
                                .addComponent(comboTurma, javax.swing.GroupLayout.Alignment.LEADING, 0, 662, Short.MAX_VALUE)))
                        .addGap(0, 12, Short.MAX_VALUE))))
        );

        jPanel11Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel28, jLabel3});

        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(campoMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(checkStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(7, 7, 7)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(campoNomeAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(comboSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel11Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel28, jLabel3});

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));

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

        btnDeletar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDeletar.setForeground(new java.awt.Color(255, 0, 0));
        btnDeletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/controle/visao/icones/erase7.png"))); // NOI18N
        btnDeletar.setText("DELETAR");
        btnDeletar.setContentAreaFilled(false);
        btnDeletar.setFocusable(false);
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 0, 0));
        jButton3.setText("IMPORTAR");
        jButton3.setContentAreaFilled(false);
        jButton3.setFocusable(false);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDeletar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap(590, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeletar)
                    .addComponent(btnSalvar)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2))
        );

        btnAdicionar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAdicionar.setForeground(new java.awt.Color(255, 0, 0));
        btnAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/controle/visao/icones/add64.png"))); // NOI18N
        btnAdicionar.setText("ADICIONAR");
        btnAdicionar.setContentAreaFilled(false);
        btnAdicionar.setFocusable(false);
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnRemover.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRemover.setForeground(new java.awt.Color(255, 0, 0));
        btnRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/controle/visao/icones/line32.png"))); // NOI18N
        btnRemover.setText("REMOVER");
        btnRemover.setContentAreaFilled(false);
        btnRemover.setFocusable(false);
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelMatriculaLayout = new javax.swing.GroupLayout(jPanelMatricula);
        jPanelMatricula.setLayout(jPanelMatriculaLayout);
        jPanelMatriculaLayout.setHorizontalGroup(
            jPanelMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMatriculaLayout.createSequentialGroup()
                .addGroup(jPanelMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelMatriculaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAdicionar)
                        .addGap(10, 10, 10)
                        .addComponent(btnRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelMatriculaLayout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoImagemAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(jScrollPane3)
        );

        jPanelMatriculaLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAdicionar, btnRemover});

        jPanelMatriculaLayout.setVerticalGroup(
            jPanelMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMatriculaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(campoImagemAluno)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemover)
                    .addComponent(btnAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanelMatriculaLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAdicionar, btnRemover});

        jPanelMatriculaLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {campoImagemAluno, jPanel11});

        javax.swing.GroupLayout subJPanelMatriculaLayout = new javax.swing.GroupLayout(subJPanelMatricula);
        subJPanelMatricula.setLayout(subJPanelMatriculaLayout);
        subJPanelMatriculaLayout.setHorizontalGroup(
            subJPanelMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMatricula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        subJPanelMatriculaLayout.setVerticalGroup(
            subJPanelMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMatricula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Matrícula", subJPanelMatricula);

        jPanelAluno.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Dados"));

        jTextField1.setForeground(new java.awt.Color(204, 0, 0));
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));

        jLabel18.setText("Folha: *");

        jTextField2.setForeground(new java.awt.Color(204, 0, 0));
        jTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));

        jLabel16.setText("Livro: *");

        jLabel8.setText("Cor: *");

        jComboBox2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jComboBox2.setForeground(new java.awt.Color(204, 0, 0));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Branca", "Preta", "Parda", "Amarela", "Indígena", "Outro" }));

        jComboBox1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(255, 0, 0));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Antígua e Barbuda - Antiguano", "Argentina - Argentino", "Bahamas - Bahamense", "Barbados - Barbadiano, barbadense", "Belize - Belizenho", "Bolívia - Boliviano", "Brasil - Brasileiro", "Chile - Chileno", "Colômbia - Colombiano", "Costa Rica - Costarriquenho", "Cuba - Cubano", "Dominica - Dominicano", "Equador - Equatoriano", "El Salvador - Salvadorenho", "Granada - Granadino", "Guatemala - Guatemalteco", "Guiana - Guianês", "Guiana Francesa - Guianense", "Haiti - Haitiano", "Honduras - Hondurenho", "Jamaica - Jamaicano", "México - Mexicano", "Nicarágua - Nicaraguense", "Panamá - Panamenho", "Paraguai - Paraguaio", "Peru - Peruano", "Porto Rico - Portorriquenho", "República Dominicana - Dominicana", "São Cristóvão e Nevis - São-cristovense", "São Vicente e Granadinas - São-vicentino", "Santa Lúcia - Santa-lucense", "Suriname - Surinamês", "Trinidad e Tobago - Trindadense", "Uruguai - Uruguaio", "Venezuela - Venezuelano", "Alemanha - Alemão", "Áustria - Austríaco", "Bélgica - Belga", "Croácia - Croata", "Dinamarca - Dinamarquês", "Eslováquia - Eslovaco", "Eslovênia - Esloveno", "Espanha - Espanhol", "França - Francês", "Grécia - Grego", "Hungria - Húngaro", "Irlanda - Irlandês", "Itália - Italiano", "Noruega - Noruego", "Países Baixos - Holandês", "Polônia - Polonês", "Portugal - Português", "Reino Unido - Britânico", "Inglaterra - Inglês", "País de Gales - Galês", "Escócia - Escocês", "Romênia - Romeno", "Rússia - Russo", "Sérvio - Sérvio", "Suécia - Sueco", "Suíça - Suíço", "Turquia - Turco", "Ucrânia - Ucraniano", "Estados Unidos - Americano", "Canadá - Canadense", "Angola - Angolano", "Moçambique - Moçambicano", "África do Sul - Sul-africano", "Zimbabue - Zimbabuense", "Argélia - Argélia", "Comores - Comorense", "Egito - Egípcio", "Líbia - Líbio", "Marrocos - Marroquino", "Gana - Ganés", "Quênia - Queniano", "Ruanda - Ruandês", "Uganda - Ugandense", "Botsuana - Bechuano", "Costa do Marfim - Marfinense", "Camarões - Camaronense", "Nigéria - Nigeriano", "Somália - Somali", "Austrália - Australiano", "Nova Zelândia - Neozelandês", "Afeganistão - Afegão", "Arábia Saudita - Saudita", "Armênia - Armeno", "Armeno - Bangladesh", "China - Chinês", "Coréia do Norte - Norte-coreano, coreano", "Coréia do Sul - Sul-coreano, coreano", "Índia - Indiano", "Indonésia - Indonésio", "Iraque - Iraquiano", "Irã - Iraniano", "Israel - Israelita", "Japão - Japonês", "Malásia - Malaio", "Nepal - Nepalês", "Omã - Omanense", "Paquistão - Paquistanês", "Palestina - Palestino", "Qatar - Qatarense", "Síria - Sírio", "Sri Lanka - Cingalês", "Tailândia - Tailandês", "Timor-Leste - Timorense, maubere", "Emirados Árabes Unidos - Árabe, emiratense", "Vietnã - Vietnamita", "Iêmen - Iemenita" }));
        jComboBox1.setSelectedIndex(6);
        jComboBox1.setToolTipText("");

        jLabel7.setText("Nacionalidade: *");

        jLabel19.setText("N° Registro de Nascimento: *");

        jTextField3.setForeground(new java.awt.Color(204, 0, 0));
        jTextField3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder("Sexo"));

        jRadioButton2.setBackground(new java.awt.Color(255, 255, 255));
        grupoSexo.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jRadioButton2.setForeground(new java.awt.Color(204, 0, 0));
        jRadioButton2.setText("Feminino");

        jRadioButton1.setBackground(new java.awt.Color(255, 255, 255));
        grupoSexo.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(204, 0, 0));
        jRadioButton1.setText("Masculino");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton2)
                .addContainerGap())
        );

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder("Datas"));

        jLabel17.setText("Emissão: *");

        jDateChooser2.setForeground(new java.awt.Color(204, 0, 0));

        jLabel4.setText("Nascimento: *");

        jDateChooser3.setForeground(new java.awt.Color(204, 0, 0));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel19)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Endereço"));

        jLabel20.setText("Rua: *");

        jLabel21.setText("Bairro: *");

        jLabel22.setText("Cidade: *");

        jLabel23.setText("CEP: *");

        jLabel24.setText("N° ");

        jTextField4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));

        jTextField5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));

        jTextField6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));

        jTextField8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));

        jFormattedTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        try {
            jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel23)
                    .addComponent(jLabel22)
                    .addComponent(jLabel21)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jTextField4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jTextField6)
                    .addComponent(jTextField5))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTextField4.getAccessibleContext().setAccessibleName("");
        jTextField5.getAccessibleContext().setAccessibleName("");
        jTextField6.getAccessibleContext().setAccessibleName("");

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Contato"));

        jTextField7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));

        jTextField9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));

        jTextField10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));

        jTextField11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));

        jLabel6.setText("Telefone: *");

        jLabel25.setText("Celular: *");

        jLabel26.setText("Whatsapp: *");

        jLabel27.setText("E-mail: *");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel26)
                    .addComponent(jLabel25)
                    .addComponent(jLabel6)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField10)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelAlunoLayout = new javax.swing.GroupLayout(jPanelAluno);
        jPanelAluno.setLayout(jPanelAlunoLayout);
        jPanelAlunoLayout.setHorizontalGroup(
            jPanelAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAlunoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelAlunoLayout.setVerticalGroup(
            jPanelAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAlunoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Aluno", jPanelAluno);

        jPanelResponsavel.setBackground(new java.awt.Color(255, 255, 255));
        jPanelResponsavel.setForeground(new java.awt.Color(255, 255, 255));
        jPanelResponsavel.setLayout(new java.awt.CardLayout());
        jTabbedPane1.addTab("Responsável", jPanelResponsavel);

        jPanelQuestionario.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Responda o questionário"));

        jLabel9.setText("6. Tem problema respiratório?");

        jLabel10.setText("1. Possui Problema de saúde?");

        jLabel11.setText("2. O aluno toma algum médicamento?");

        jLabel13.setText("3. Tem alguma deficiencia?");

        jLabel14.setText("4. Possui alguma alergia?");

        jLabel15.setText("5. Possui algum problema de visão?");

        jRadioButton3.setBackground(new java.awt.Color(255, 255, 255));
        grupoQuestao1.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jRadioButton3.setForeground(new java.awt.Color(204, 0, 0));
        jRadioButton3.setText("SIM");

        jRadioButton4.setBackground(new java.awt.Color(255, 255, 255));
        grupoQuestao1.add(jRadioButton4);
        jRadioButton4.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jRadioButton4.setForeground(new java.awt.Color(204, 0, 0));
        jRadioButton4.setText("NÃO");

        jRadioButton5.setBackground(new java.awt.Color(255, 255, 255));
        grupoQuestao2.add(jRadioButton5);
        jRadioButton5.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jRadioButton5.setForeground(new java.awt.Color(204, 0, 0));
        jRadioButton5.setText("SIM");

        jRadioButton6.setBackground(new java.awt.Color(255, 255, 255));
        grupoQuestao2.add(jRadioButton6);
        jRadioButton6.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jRadioButton6.setForeground(new java.awt.Color(204, 0, 0));
        jRadioButton6.setText("NÃO");

        jRadioButton7.setBackground(new java.awt.Color(255, 255, 255));
        grupoQuestao3.add(jRadioButton7);
        jRadioButton7.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jRadioButton7.setForeground(new java.awt.Color(204, 0, 0));
        jRadioButton7.setText("SIM");

        jRadioButton8.setBackground(new java.awt.Color(255, 255, 255));
        grupoQuestao3.add(jRadioButton8);
        jRadioButton8.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jRadioButton8.setForeground(new java.awt.Color(204, 0, 0));
        jRadioButton8.setText("NÃO");

        jRadioButton9.setBackground(new java.awt.Color(255, 255, 255));
        grupoQuestao4.add(jRadioButton9);
        jRadioButton9.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jRadioButton9.setForeground(new java.awt.Color(204, 0, 0));
        jRadioButton9.setText("NÃO");

        jRadioButton10.setBackground(new java.awt.Color(255, 255, 255));
        grupoQuestao4.add(jRadioButton10);
        jRadioButton10.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jRadioButton10.setForeground(new java.awt.Color(204, 0, 0));
        jRadioButton10.setText("SIM");

        jRadioButton11.setBackground(new java.awt.Color(255, 255, 255));
        grupoQuestao5.add(jRadioButton11);
        jRadioButton11.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jRadioButton11.setForeground(new java.awt.Color(204, 0, 0));
        jRadioButton11.setText("SIM");

        jRadioButton12.setBackground(new java.awt.Color(255, 255, 255));
        grupoQuestao5.add(jRadioButton12);
        jRadioButton12.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jRadioButton12.setForeground(new java.awt.Color(204, 0, 0));
        jRadioButton12.setText("NÃO");

        jRadioButton13.setBackground(new java.awt.Color(255, 255, 255));
        grupoQuestao6.add(jRadioButton13);
        jRadioButton13.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jRadioButton13.setForeground(new java.awt.Color(204, 0, 0));
        jRadioButton13.setText("SIM");
        jRadioButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton13ActionPerformed(evt);
            }
        });

        jRadioButton14.setBackground(new java.awt.Color(255, 255, 255));
        grupoQuestao6.add(jRadioButton14);
        jRadioButton14.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jRadioButton14.setForeground(new java.awt.Color(204, 0, 0));
        jRadioButton14.setText("NÃO");

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setText("7. Como o aluno vai a escola?");

        jCheckBox1.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(204, 0, 0));
        jCheckBox1.setText("A pé");

        jCheckBox3.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jCheckBox3.setForeground(new java.awt.Color(204, 0, 0));
        jCheckBox3.setText("Bicicleta");

        jCheckBox5.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox5.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jCheckBox5.setForeground(new java.awt.Color(204, 0, 0));
        jCheckBox5.setText("Carro");

        jCheckBox2.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jCheckBox2.setForeground(new java.awt.Color(204, 0, 0));
        jCheckBox2.setText("Transporte Público");

        jCheckBox4.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox4.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jCheckBox4.setForeground(new java.awt.Color(204, 0, 0));
        jCheckBox4.setText("Moto");

        jCheckBox6.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox6.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jCheckBox6.setForeground(new java.awt.Color(204, 0, 0));
        jCheckBox6.setText("Outros");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jCheckBox5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox6))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jCheckBox3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox4))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jCheckBox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox2))
                    .addComponent(jLabel12))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel15Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jCheckBox1, jCheckBox3, jCheckBox5});

        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox3)
                    .addComponent(jCheckBox4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox5)
                    .addComponent(jCheckBox6))
                .addGap(0, 44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jRadioButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jRadioButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jRadioButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jRadioButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jRadioButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jRadioButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jRadioButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jRadioButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jRadioButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jRadioButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jRadioButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jRadioButton14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(jRadioButton4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton5)
                    .addComponent(jRadioButton6)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton7)
                    .addComponent(jRadioButton8)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jRadioButton9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton11)
                    .addComponent(jLabel15)
                    .addComponent(jRadioButton12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jRadioButton13)
                    .addComponent(jRadioButton14))
                .addGap(104, 104, 104)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(120, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelQuestionarioLayout = new javax.swing.GroupLayout(jPanelQuestionario);
        jPanelQuestionario.setLayout(jPanelQuestionarioLayout);
        jPanelQuestionarioLayout.setHorizontalGroup(
            jPanelQuestionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelQuestionarioLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 585, Short.MAX_VALUE))
        );
        jPanelQuestionarioLayout.setVerticalGroup(
            jPanelQuestionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelQuestionarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Questionário", jPanelQuestionario);

        jPanel3.add(jTabbedPane1, "card3");

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        Collections.sort(novosAlunos);
        AlunoRN alunoRN = new AlunoRN();
        if (alunoRN.salvarAlunos(novosAlunos)) {
            GerenteDeArquivos gerenteDeArquivos = new GerenteDeArquivos();
            for (Aluno novoAluno : novosAlunos) {
                if (novoAluno.getuRLImagem() != null && !novoAluno.getuRLImagem().trim().equals("")) {
                    gerenteDeArquivos.gravarImagem(novoAluno.getuRLImagem(), campoImagemAluno.getWidth(), campoImagemAluno.getHeight(), novoAluno.getMatricula());
                }
            }
        }
        limparCampos();
        TABELA_ALUNO.inserirAlunos(alunoRN.buscarTodos());
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        if (!campoMatricula.getText().isEmpty() && tabelaCadastro.isRowSelected(tabelaCadastro.getSelectedRow())) {
            AlunoRN alunoRN = new AlunoRN();
            if (alunoRN.remover(campoMatricula.getText().trim())) {
                TABELA_ALUNO.delAluno(tabelaCadastro.getSelectedRow());
            }
        }
// TODO add your handling code here:
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void campoNomeAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNomeAlunoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNomeAlunoActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed

    }//GEN-LAST:event_formInternalFrameClosed

    private void comboTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTurmaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboTurmaActionPerformed

    private void jRadioButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton13ActionPerformed

    private void campoImagemAlunoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoImagemAlunoMouseClicked
        if (evt.getClickCount() == 2) {
            GerenteDeArquivos gerenteDeArquivos = new GerenteDeArquivos();
            urlfoto = gerenteDeArquivos.escolherImagem(campoImagemAluno);
        }           // TODO add your handling code here:
    }//GEN-LAST:event_campoImagemAlunoMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        CADASTRO_ALUNOS = null;
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        if (verificaCampos()) {
            Aluno aluno = encapsulaAluno();
            novosAlunos.add(aluno);
            TABELA_ALUNO.inserirAlunos(novosAlunos);
            limparCampos();
        } else {
            JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios!");
        }

// TODO add your handling code here:
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        if (tabelaCadastro.isRowSelected(tabelaCadastro.getSelectedRow()) && !novosAlunos.isEmpty()) {
            int index = tabelaCadastro.getSelectedRow();
            novosAlunos.remove(index);
            TABELA_ALUNO.delAluno(tabelaCadastro.getSelectedRow());
        }
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void tabelaCadastroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaCadastroMouseClicked
        if (tabelaCadastro.isRowSelected(tabelaCadastro.getSelectedRow())) {
            setAlunoDEnviado(TABELA_ALUNO.getAluno(tabelaCadastro.getSelectedRow()));

        }         // TODO add your handling code here:
    }//GEN-LAST:event_tabelaCadastroMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel campoImagemAluno;
    private javax.swing.JTextField campoMatricula;
    private javax.swing.JTextField campoNomeAluno;
    private javax.swing.JCheckBox checkStatus;
    private javax.swing.JComboBox comboSituacao;
    private javax.swing.JComboBox comboTurma;
    private javax.swing.ButtonGroup grupoQuestao1;
    private javax.swing.ButtonGroup grupoQuestao2;
    private javax.swing.ButtonGroup grupoQuestao3;
    private javax.swing.ButtonGroup grupoQuestao4;
    private javax.swing.ButtonGroup grupoQuestao5;
    private javax.swing.ButtonGroup grupoQuestao6;
    private javax.swing.ButtonGroup grupoSexo;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanelAluno;
    private javax.swing.JPanel jPanelMatricula;
    private javax.swing.JPanel jPanelQuestionario;
    private javax.swing.JPanel jPanelResponsavel;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton10;
    private javax.swing.JRadioButton jRadioButton11;
    private javax.swing.JRadioButton jRadioButton12;
    private javax.swing.JRadioButton jRadioButton13;
    private javax.swing.JRadioButton jRadioButton14;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JPanel subJPanelMatricula;
    private javax.swing.JTable tabelaCadastro;
    // End of variables declaration//GEN-END:variables

    void setAlunoDEnviado(Aluno aluno) {
        campoMatricula.setText(aluno.getMatricula());
        campoNomeAluno.setText(aluno.getNome());
        boxModelTurma.setSelectedItem(aluno.getTurma().toString());
        if (aluno.getuRLImagem() == null) {
            campoImagemAluno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/controle/visao/icones/aluno.png")));
        } else {
            GerenteDeArquivos.setImagemLabel("./fotos/".concat(aluno.getuRLImagem()), campoImagemAluno);
        }
        checkStatus.setSelected(aluno.isAtivo());
        comboSituacao.setSelectedItem(aluno.getSituacao());
        jDateChooser1.setDate(aluno.getDataCadastro());

    }

    private boolean verificaCampos() {
        if (comboTurma.getSelectedIndex() == -1) {
            return false;
        }
        return !campoNomeAluno.getText().isEmpty();
    }

    public void limparCampos() {
        campoMatricula.setText(null);
        campoNomeAluno.setText(null);
        comboTurma.setSelectedIndex(0);
        urlfoto = null;
        checkStatus.setSelected(false);
        jDateChooser1.setDate(null);
    }

}
