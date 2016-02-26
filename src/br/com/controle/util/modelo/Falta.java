package br.com.controle.util.modelo;

import java.io.Serializable;
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
    @JoinColumn(name = "id_disciplina")
    private Disciplina disciplina;
    @Id
    @ManyToOne
    @JoinColumn(name = "id_aluno")
    private Aluno aluno;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "id_turma")
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

}
