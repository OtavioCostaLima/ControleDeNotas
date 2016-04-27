package br.com.controle.util.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Otavio Costa
 */
@Entity
public class Falta implements BeanBase, Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "idDisciplina",nullable = false)
    private Disciplina disciplina;
    @Id
    @ManyToOne
    @JoinColumn(name = "idAluno",nullable = false)
    private Aluno aluno;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "idTurma",nullable = false)
    private Turma turma;

    private int faltas;

    public int getFaltas() {
        return faltas;
    }

    public void setFaltas(int faltas) {
        this.faltas = faltas;
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.disciplina);
        hash = 41 * hash + Objects.hashCode(this.aluno);
        hash = 41 * hash + Objects.hashCode(this.turma);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Falta other = (Falta) obj;
        if (!Objects.equals(this.disciplina, other.disciplina)) {
            return false;
        }
        if (!Objects.equals(this.aluno, other.aluno)) {
            return false;
        }
        if (!Objects.equals(this.turma, other.turma)) {
            return false;
        }
        return true;
    }

    
    
}
