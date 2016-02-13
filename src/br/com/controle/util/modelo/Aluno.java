package br.com.controle.util.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Otavio Costa
 */
@Entity
public class Aluno implements BeanBase, Serializable, Comparable<Aluno> {

    public Aluno() {
    }

    @Id
    @Column(name = "matricula", nullable = false, unique = true)
    private String matricula;

    @Column(name = "nome_aluno")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "id_turma")
    private Turma turma;

    @Column(name = "url_imagem")
    private String uRLImagem;

    @Column(name = "numero_chamada")
    private int numeroChamada;
    /**
     * o Aluno pode está cursando, desistente, reprovado, aprovado"
     */
    private String situacao;

    /**
     * ATIVO/INATIVO
     */
    private String status;

    @Temporal(TemporalType.DATE)
    private Date dataCadastro;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aluno")

    private List<Nota> notas;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aluno")
    private List<Falta> faltas;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

        public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public String getuRLImagem() {
        return uRLImagem;
    }

    public void setuRLImagem(String uRLImagem) {
        this.uRLImagem = uRLImagem;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.matricula);
        hash = 83 * hash + Objects.hashCode(this.nome);
        hash = 83 * hash + Objects.hashCode(this.turma);
        hash = 83 * hash + this.numeroChamada;
        return hash;
    }

    public List<Falta> getFaltas() {
        return faltas;
    }

    public void setFaltas(List<Falta> faltas) {
        this.faltas = faltas;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Aluno other = (Aluno) obj;
        if (!Objects.equals(this.matricula, other.matricula)) {
            return false;
        }

        if (!Objects.equals(this.turma, other.turma)) {
            return false;
        }
        return true;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void gerarMatriculaAluno() {
        if (this.getTurma() != null) {
            this.matricula = this.getTurma().getAno() + this.getTurma().getDescricao().replaceAll("[^0-9]", "") + this.turma.getSigla() + this.numeroChamada;
        }
    }

    @Override
    public int compareTo(Aluno outro) {
        return this.nome.compareTo(outro.getNome());
    }

    public boolean isAtivo() {
        return this.getStatus().equals("ATIVO");
    }

    public int getNumeroChamada() {
        return numeroChamada;
    }

    public void setNumeroChamada(int numeroChamada) {
        this.numeroChamada = numeroChamada;
    }

}
