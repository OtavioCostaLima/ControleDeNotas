package br.com.controle.util.modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Otavio Costa
 */
@Entity
@Table(name = "nota")
public class Nota implements BeanBase, Serializable {

    @Id
    private long id;
    private String bimestre;
    private double provaMensal;
    private double provaBimestral;
    private double extra;
    private double qualitativo;
    private double media;

    @ManyToOne
    @JoinColumn(name = "idDisciplina", nullable = false)
    private Disciplina disciplina;

    @ManyToOne
    @JoinColumn(name = "matriculaAluno", nullable = false)
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "matriculaProfessor", nullable = false)
    private Professor professor;

    public long getId() {
        return id;
    }

    public String getBimestre() {
        return bimestre;
    }

    public void setBimestre(String bimestre) {
        this.bimestre = bimestre;
    }

    public double getProvaMensal() {
        return provaMensal;
    }

    public void setProvaMensal(double provaMensal) {
        this.provaMensal = provaMensal;
    }

    public double getProvaBimestral() {
        return provaBimestral;
    }

    public void setProvaBimestral(double provaBimestral) {
        this.provaBimestral = provaBimestral;
    }

    public double getExtra() {
        return extra;
    }

    public void setExtra(double extra) {
        this.extra = extra;
    }

    public double getQualitativo() {
        return qualitativo;
    }

    public void setQualitativo(double qualitativo) {
        this.qualitativo = qualitativo;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

}
