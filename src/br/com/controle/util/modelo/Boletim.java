package br.com.controle.util.modelo;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Otavio Costa
 */
@Entity
public class Boletim implements BeanBase, Serializable {

    @Id
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Aluno aluno;
    private long provaRecuperacao;
    private long notaFiinal;
    private long mediaGlobal;
    private long notalTotal;
    private String situacao;

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public long getProvaRecuperacao() {
        return provaRecuperacao;
    }

    public void setProvaRecuperacao(long provaRecuperacao) {
        this.provaRecuperacao = provaRecuperacao;
    }

    public long getNotaFiinal() {
        return notaFiinal;
    }

    public void setNotaFiinal(long notaFiinal) {
        this.notaFiinal = notaFiinal;
    }

    public long getMediaGlobal() {
        return mediaGlobal;
    }

    public void setMediaGlobal(long mediaGlobal) {
        this.mediaGlobal = mediaGlobal;
    }

    public long getNotalTotal() {
        return notalTotal;
    }

    public void setNotalTotal(long notalTotal) {
        this.notalTotal = notalTotal;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

}
