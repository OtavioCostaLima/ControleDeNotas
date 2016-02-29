package br.com.controle.util.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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

    @EmbeddedId
    private HorarioPK horarioPK;

    private String diaDaSemana;

    @Temporal(TemporalType.TIMESTAMP)
    private Date horaInicio;

    @Temporal(TemporalType.TIMESTAMP)
    private Date horaTermino;

    @ManyToOne
    @JoinColumn(name = "id_professor", nullable = false, insertable = false, updatable = false)
    private Professor professor;

    @ManyToOne
    @JoinColumn(name = "id_disciplina", nullable = false, insertable = false, updatable = false)
    private Disciplina disciplina;

    @ManyToOne
    @JoinColumn(name = "id_turma")
    private Turma turma;

    public HorarioPK getHorarioPK() {
        return horarioPK;
    }

    public void setHorarioPK(HorarioPK horarioPK) {
        this.horarioPK = horarioPK;
    }

    public String getDiaDaSemana() {
        return diaDaSemana;
    }

    public void setDiaDaSemana(String diaDaSemana) {
        this.diaDaSemana = diaDaSemana;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraTermino() {
        return horaTermino;
    }

    public void setHoraTermino(Date horaTermino) {
        this.horaTermino = horaTermino;
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + Objects.hashCode(this.horarioPK);
        hash = 19 * hash + Objects.hashCode(this.professor);
        hash = 19 * hash + Objects.hashCode(this.disciplina);
        hash = 19 * hash + Objects.hashCode(this.turma);
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
        final Horario other = (Horario) obj;
        if (!Objects.equals(this.horarioPK, other.horarioPK)) {
            return false;
        }
        if (!Objects.equals(this.professor, other.professor)) {
            return false;
        }
        if (!Objects.equals(this.disciplina, other.disciplina)) {
            return false;
        }
        if (!Objects.equals(this.turma, other.turma)) {
            return false;
        }
        return true;
    }

}
