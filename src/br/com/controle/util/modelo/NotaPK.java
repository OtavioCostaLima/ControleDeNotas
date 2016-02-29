/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controle.util.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Suporte Técnico
 */
@Embeddable
public class NotaPK implements Serializable {

    @Column(name = "id_disciplina")
    private long disciplina;

    @Column(name = "matricula_aluno")
    private String aluno;

    @Column(name = "matricula_professor")
    private String professor;

    public NotaPK() {
    }

    public NotaPK(long disciplina, String aluno, String professor) {
        this.disciplina = disciplina;
        this.aluno = aluno;
        this.professor = professor;
    }

    public long getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(long disciplina) {
        this.disciplina = disciplina;
    }

    public String getAluno() {
        return aluno;
    }

    public void setAluno(String aluno) {
        this.aluno = aluno;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + (int) (this.disciplina ^ (this.disciplina >>> 32));
        hash = 17 * hash + Objects.hashCode(this.aluno);
        hash = 17 * hash + Objects.hashCode(this.professor);
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
        final NotaPK other = (NotaPK) obj;
        if (this.disciplina != other.disciplina) {
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
