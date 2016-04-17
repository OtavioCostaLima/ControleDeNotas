package br.com.controle.util.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String bimestre;
    private Double provaMensal;
    private Double provaBimestral;
    private Double extra;
    private Double qualitativo;
    private Double media;

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

    public Double getProvaMensal() {
        return provaMensal;
    }

    public void setProvaMensal(Double provaMensal) {
        this.provaMensal = provaMensal;
    }

    public Double getProvaBimestral() {
        return provaBimestral;
    }

    public void setProvaBimestral(Double provaBimestral) {
        this.provaBimestral = provaBimestral;
    }

    public Double getExtra() {
        return extra;
    }

    public void setExtra(Double extra) {
        this.extra = extra;
    }

    public Double getQualitativo() {
        return qualitativo;
    }

    public void setQualitativo(Double qualitativo) {
        this.qualitativo = qualitativo;
    }

    public Double getMedia() {
        return media;
    }

    public void setMedia(Double media) {
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
        hash = 67 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 67 * hash + Objects.hashCode(this.bimestre);
        hash = 67 * hash + Objects.hashCode(this.disciplina);
        hash = 67 * hash + Objects.hashCode(this.aluno);
        hash = 67 * hash + Objects.hashCode(this.professor);
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
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.bimestre, other.bimestre)) {
            return false;
        }
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
