package br.com.controle.util.modelo;

import java.io.Serializable;
import java.util.Objects;
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

    private String bimestre;
    private double provaMensal;
    private double provaBimestral;
    private double extra;
    private double qualitativo;
    private double media;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_disciplina")
    private Disciplina disciplina;

    @Id
    @ManyToOne
    @JoinColumn(name = "matricula_aluno")
    private Aluno aluno;

    @Id
    @ManyToOne
    @JoinColumn(name = "matricula_professor")
    private Professor professor;

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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.disciplina);
        hash = 37 * hash + Objects.hashCode(this.aluno);
        hash = 37 * hash + Objects.hashCode(this.professor);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Nota other = (Nota) obj;
        if (!Objects.equals(this.disciplina, other.disciplina)) {
            return false;
        }
        if (!Objects.equals(this.aluno, other.aluno)) {
            return false;
        }
        if (!Objects.equals(this.professor, other.professor)) {
            return false;
        }
        return true;
    }

}
