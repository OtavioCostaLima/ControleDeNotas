package br.com.controle.util.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author otavi
 */
@Entity
public class AlunoAvalicao implements BeanBase, Serializable {

    @Id
    private long id;

    @ManyToOne
    @JoinColumn(name = "matriculaAluno",nullable = false)
    private Aluno aluno;

    @ManyToOne
     @JoinColumn(name = "idAvalicao",nullable = false)
    private Avaliacao avaliacao;

    private float nota;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataAplicacao;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public Date getDataAplicacao() {
        return dataAplicacao;
    }

    public void setDataAplicacao(Date dataAplicacao) {
        this.dataAplicacao = dataAplicacao;
    }

}
