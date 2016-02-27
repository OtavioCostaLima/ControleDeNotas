package br.com.controle.util.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Otavio Costa
 */
@Entity
public class Horario implements Serializable, BeanBase {

    private String diaDaSemana;

    @Temporal(TemporalType.TIMESTAMP)
    private Date hora;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_professor",nullable = false)
    private Professor professor;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_disciplina",nullable = true)
    private Disciplina disciplina;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_turma",nullable = true)
    private Turma turma;

    public String getDiaDaSemana() {
        return diaDaSemana;
    }

    public void setDiaDaSemana(String diaDaSemana) {
        this.diaDaSemana = diaDaSemana;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

}
