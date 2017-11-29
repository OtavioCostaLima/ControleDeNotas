/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controle.util.modelo;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author otavi
 */
public class AlunoTurmaId implements Serializable {

    private String aluno;
    private long turma;

    public AlunoTurmaId() {
    }

    public AlunoTurmaId(String aluno, long turma) {
        this.aluno = aluno;
        this.turma = turma;
    }

    public String getAluno() {
        return aluno;
    }

    public void setAluno(String aluno) {
        this.aluno = aluno;
    }

    public long getTurma() {
        return turma;
    }

    public void setTurma(long turma) {
        this.turma = turma;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.aluno);
        hash = 29 * hash + (int) (this.turma ^ (this.turma >>> 32));
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
        final AlunoTurmaId other = (AlunoTurmaId) obj;
        if (this.turma != other.turma) {
            return false;
        }
        if (!Objects.equals(this.aluno, other.aluno)) {
            return false;
        }
        return true;
    }

}
