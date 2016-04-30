package br.com.controle.visao;

import br.com.controle.util.dao.DisciplinaDAO;
import br.com.controle.util.dao.NotaDAO;
import br.com.controle.util.dao.ProfessorDAO;
import br.com.controle.util.modelo.Aluno;
import br.com.controle.util.modelo.Disciplina;
import br.com.controle.util.modelo.Nota;
import br.com.controle.util.modelo.Professor;
import br.com.controle.util.modelo.Turma;
import br.com.controle.util.negocio.NotaRN;
import br.com.controle.util.negocio.TurmaRN;
import br.com.controle.visao.abstractModels.GenericComboBoxModel;
import br.com.controle.visao.abstractModels.TabelaAluno;
import br.com.controle.visao.abstractModels.TabelaProfessor;
import java.awt.Component;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author Otavio Costa
 */
public final class PainelNotas extends javax.swing.JInternalFrame {

    Nota nota = null;
    private final TabelaAluno tabelaAluno = new TabelaAluno();
    private final TabelaProfessor tabelaProfessor = new TabelaProfessor();
    private GenericComboBoxModel<String> boxModelAno;
    private GenericComboBoxModel<Turma> comboBoxTurma;
    GenericComboBoxModel<Disciplina> comboBoxDisciplina;
    /**
     * Creates new form PainelNotas
     */
    private static PainelNotas painelNotas;

    public void listarAnos() {
        List<String> anos = new TurmaRN().listarAnos();
        boxModelAno = new GenericComboBoxModel(anos);
        comboAno.setModel(boxModelAno);
    }

    public void listarTurmasPorAno() {
        List<Turma> turma = new TurmaRN().listarTurmaPorAno(String.valueOf(boxModelAno.getSelectedItem()));
        comboBoxTurma = new GenericComboBoxModel(turma);
        comboTurma.setModel(comboBoxTurma);
    }

    private PainelNotas() {
        initComponents();
        ((BasicInternalFrameUI) getUI()).setNorthPane(null);
        listarAnos();
    }

    public static PainelNotas getInstancia() {
        if (painelNotas == null) {
            painelNotas = new PainelNotas();
        }
        return painelNotas;
    }

    private Nota encapsular() {
        if (nota == null) {
            nota = new Nota();
        }
        Professor professor;
        Aluno aluno;
        if ((aluno = getAlunoSelecionado()) != null && (professor = getProfessorSelecionado()) != null) {
            nota.setAluno(aluno);
            nota.setDisciplina(comboBoxDisciplina.get(comboDisciplina.getSelectedIndex()));
            nota.setProfessor(professor);
            nota.setExtra(Double.valueOf(jTExtra.getText()));
            nota.setQualitativo(Double.valueOf(jTQualitativo.getText()));
            nota.setProvaBimestral(Double.valueOf(notaBimestral.getText()));
            nota.setProvaMensal(Double.valueOf(notaMensal.getText()));
            nota.setBimestre(comboBimestre.getSelectedItem().toString());
            nota.setMedia(Double.valueOf(jTMedia.getText()));
            return nota;
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        comboDisciplina = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        comboAno = new javax.swing.JComboBox();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        comboTurma = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTbProfessor = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTbAluno = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTExtra = new javax.swing.JTextField();
        notaMensal = new javax.swing.JTextField();
        notaBimestral = new javax.swing.JTextField();
        jTQualitativo = new javax.swing.JTextField();
        comboBimestre = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTMedia = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setBorder(null);
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Disciplinas:");

        comboDisciplina.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        comboDisciplina.setForeground(new java.awt.Color(255, 0, 51));
        comboDisciplina.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboDisciplinaItemStateChanged(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Ano:");

        comboAno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2015" }));
        comboAno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboAnoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("Aluno:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("Turma:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("Professor:");

        comboTurma.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboTurmaItemStateChanged(evt);
            }
        });
        comboTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTurmaActionPerformed(evt);
            }
        });

        jTbProfessor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTbProfessor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTbProfessorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTbProfessor);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboAno, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboTurma, 0, 332, Short.MAX_VALUE)
                            .addComponent(comboDisciplina, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane1)
                                .addContainerGap())))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextField1)
                        .addContainerGap())))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel3, jLabel5, jLabel6});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboAno)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {comboAno, comboDisciplina, comboTurma, jLabel3});

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 0, 0));
        jButton6.setText("ADICIONAR");
        jButton6.setContentAreaFilled(false);
        jButton6.setFocusable(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 0, 0));
        jButton7.setText("REMOVER");
        jButton7.setContentAreaFilled(false);
        jButton7.setFocusable(false);

        jTbAluno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Matricula", "Aluno"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTbAluno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTbAlunoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTbAluno);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "NOTAS"));

        jLabel2.setText("Mensal");

        jLabel8.setText("Bimestral");

        jLabel9.setText("Extra");

        jLabel10.setText("Qualitativo");

        jTExtra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTExtraKeyReleased(evt);
            }
        });

        notaMensal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                notaMensalKeyReleased(evt);
            }
        });

        notaBimestral.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                notaBimestralKeyReleased(evt);
            }
        });

        jTQualitativo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTQualitativoKeyReleased(evt);
            }
        });

        comboBimestre.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        comboBimestre.setForeground(new java.awt.Color(255, 0, 51));
        comboBimestre.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1° BIMESTRE", "2° BIMESTRE", "3° BIMESTRE", "4° BIMESTRE" }));
        comboBimestre.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBimestreItemStateChanged(evt);
            }
        });
        comboBimestre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBimestreActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Bimestre:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("MÉDIA");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10)
                    .addComponent(jLabel2)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jTQualitativo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboBimestre, 0, 254, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(notaBimestral, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(notaMensal, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTExtra, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTMedia, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jTExtra, jTQualitativo, notaBimestral, notaMensal});

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel10, jLabel11, jLabel2, jLabel8, jLabel9});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBimestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(notaMensal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(notaBimestral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTExtra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTQualitativo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTMedia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jTExtra, jTQualitativo, notaBimestral, notaMensal});

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel10, jLabel11, jLabel2, jLabel8, jLabel9});

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jButton7))
                .addContainerGap())
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton6, jButton7});

        jButton1.setBackground(new java.awt.Color(158, 158, 158));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("X");
        jButton1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        painelNotas = null;
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void comboAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboAnoActionPerformed
        listarTurmasPorAno();        // TODO add your handling code here:
    }//GEN-LAST:event_comboAnoActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        Nota novaNota = encapsular();
        if (novaNota != null) {
            new NotaRN().salvar(novaNota);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void comboTurmaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboTurmaItemStateChanged
        Turma turma = getTurmaSelecionada();
        if (turma != null) {
            List<Disciplina> disciplinas = new DisciplinaDAO().getdDsciplinaPorTurma(turma.getId());
            comboBoxDisciplina = new GenericComboBoxModel<>(disciplinas);
            comboDisciplina.setModel(comboBoxDisciplina);
            List<Aluno> alunos = turma.getAlunos();
            tabelaAluno.inserirAlunos(alunos);
            jTbAluno.setModel(tabelaAluno);
            if (comboDisciplina.getItemCount() > 0) {
                comboDisciplina.setSelectedIndex(0);
            }

        }          // TODO add your handling code here:
    }//GEN-LAST:event_comboTurmaItemStateChanged

    private void comboDisciplinaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboDisciplinaItemStateChanged
        tabelaProfessor.inserirProfessores(new ProfessorDAO().getProfessorTurmaDisciplina(comboBoxDisciplina.get(comboDisciplina.getSelectedIndex()).getId(), comboBoxTurma.get(comboTurma.getSelectedIndex()).getId()));
        jTbProfessor.setModel(tabelaProfessor);        // TODO add your handling code here:
    }//GEN-LAST:event_comboDisciplinaItemStateChanged

    private void comboTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTurmaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboTurmaActionPerformed

    private void jTbAlunoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTbAlunoMouseClicked
        getNotas();

    }//GEN-LAST:event_jTbAlunoMouseClicked

    private void comboBimestreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBimestreActionPerformed

    }//GEN-LAST:event_comboBimestreActionPerformed

    private void jTbProfessorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTbProfessorMouseClicked
        getNotas();        // TODO add your handling code here:
    }//GEN-LAST:event_jTbProfessorMouseClicked

    private void comboBimestreItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBimestreItemStateChanged
        getNotas();        // TODO add your handling code here:
    }//GEN-LAST:event_comboBimestreItemStateChanged

    private void notaMensalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_notaMensalKeyReleased
        calcularMedia();        // TODO add your handling code here:
    }//GEN-LAST:event_notaMensalKeyReleased

    private void notaBimestralKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_notaBimestralKeyReleased
        calcularMedia();          // TODO add your handling code here:
    }//GEN-LAST:event_notaBimestralKeyReleased

    private void jTExtraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTExtraKeyReleased
        calcularMedia();          // TODO add your handling code here:
    }//GEN-LAST:event_jTExtraKeyReleased

    private void jTQualitativoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTQualitativoKeyReleased
        calcularMedia();          // TODO add your handling code here:
    }//GEN-LAST:event_jTQualitativoKeyReleased

    private void getNotas() {
        Aluno aluno;
        Professor professor;
        if ((aluno = getAlunoSelecionado()) != null && (professor = getProfessorSelecionado()) != null) {
            long idDisciplina = 0;
            if (comboDisciplina.getSelectedIndex() >= 0) {
                idDisciplina = comboBoxDisciplina.get(comboDisciplina.getSelectedIndex()).getId();
            }
            nota = new NotaDAO().getNota(professor.getMatricula(), idDisciplina, aluno.getMatricula(), comboBimestre.getSelectedItem().toString());
            if (nota != null) {
                notaBimestral.setText(nota.getProvaBimestral().toString());
                notaMensal.setText(nota.getProvaMensal().toString());
                jTExtra.setText(nota.getExtra().toString());
                jTQualitativo.setText(nota.getQualitativo().toString());
                jTMedia.setText(nota.getMedia().toString());
            } else {
                notaBimestral.setText("");
                notaMensal.setText("");
                jTExtra.setText("");
                jTQualitativo.setText("");
                jTMedia.setText("");
            }

        }        // TODO add your handling code here:
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox comboAno;
    private javax.swing.JComboBox comboBimestre;
    private javax.swing.JComboBox comboDisciplina;
    private javax.swing.JComboBox comboTurma;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTExtra;
    private javax.swing.JTextField jTMedia;
    private javax.swing.JTextField jTQualitativo;
    private javax.swing.JTable jTbAluno;
    private javax.swing.JTable jTbProfessor;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField notaBimestral;
    private javax.swing.JTextField notaMensal;
    // End of variables declaration//GEN-END:variables

    private Aluno getAlunoSelecionado() {
        int indexAluno = jTbAluno.getSelectedRow();
        if (jTbAluno.isRowSelected(indexAluno)) {
            return tabelaAluno.getAluno(indexAluno);
        }
        return null;
    }

    private Professor getProfessorSelecionado() {
        int indexProfessor = jTbProfessor.getSelectedRow();
        if (jTbProfessor.isRowSelected(indexProfessor)) {
            return tabelaProfessor.getProfessor(indexProfessor);
        }
        return null;
    }

    private Turma getTurmaSelecionada() {
        int index = comboTurma.getSelectedIndex();
        if (index >= 0) {
            return comboBoxTurma.get(index);
        } else {
            JOptionPane.showMessageDialog(null, "Turma não encontrada!");
        }
        return null;
    }

    private void calcularMedia() {
        Double media = 0.0;
        JTextField components[] = {notaBimestral, notaMensal, jTExtra, jTQualitativo};
        for (JTextField component : components) {
            if (!component.getText().isEmpty()) {
                double nota = Double.valueOf(component.getText());
                media += nota;
            }
        }
        if (media != null) {
            jTMedia.setText("" + media / 2);
        }

    }

}
