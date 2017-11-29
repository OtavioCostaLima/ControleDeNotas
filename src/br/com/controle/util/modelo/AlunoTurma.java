/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controle.util.modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author otavi
 */
@Entity
@IdClass(AlunoTurmaId.class)
public class AlunoTurma implements BeanBase, Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "idTurma")
    private Turma turma;

    @Id
    @ManyToOne
    @JoinColumn(name = "matriculaAluno")
    private Aluno aluno;

    public AlunoTurma() {
    }

    private int numeroChamada;

    private String stituacao;

    private String modalidade;

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public int getNumeroChamada() {
        return numeroChamada;
    }

    public void setNumeroChamada(int numeroChamada) {
        this.numeroChamada = numeroChamada;
    }

    public String getStituacao() {
        return stituacao;
    }

    public void setStituacao(String stituacao) {
        this.stituacao = stituacao;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

  

}
