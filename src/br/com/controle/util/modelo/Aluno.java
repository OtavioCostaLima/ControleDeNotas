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

    @Column(name = "nomeAluno")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "idTurma", nullable = false)
    private Turma turma;

    private transient String uRLImagem;

    @Column(name = "numeroChamada", nullable = false)
    private int numeroChamada;
    /**
     * o Aluno pode está cursando, desistente, reprovado, aprovado"
     */
    private String situacaoAluno;

    /**
     * ATIVO/INATIVO
     */
    private String status;

    private String registroNascimento;
    private String folha;
    private String livro;
    private String nacionalidade;

    @Column(length = 25)
    private String cor;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataEmissao;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataNascimento;

    @Column(length = 25)
    private String cep;
    private String rua;
    private String bairro;
    private String cidade;

    @Column(length = 10)
    private String numeroResidencia;

    private String telefone;
    private String celular;
    private String whatsapp;
    private String email;

    private char sexo;

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

    public String getSituacaoAluno() {
        return situacaoAluno;
    }

    public void setSituacaoAluno(String situacaoAluno) {
        this.situacaoAluno = situacaoAluno;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public int getNumeroChamada() {
        return numeroChamada;
    }

    public void setNumeroChamada(int numeroChamada) {
        this.numeroChamada = numeroChamada;
    }

    public List<Falta> getFaltas() {
        return faltas;
    }

    public void setFaltas(List<Falta> faltas) {
        this.faltas = faltas;
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

    public boolean isAtivo() {
        return this.getStatus().equals("ATIVO");
    }

    public String getRegistroNascimento() {
        return registroNascimento;
    }

    public void setRegistroNascimento(String registroNascimento) {
        this.registroNascimento = registroNascimento;
    }

    public String getFolha() {
        return folha;
    }

    public void setFolha(String folha) {
        this.folha = folha;
    }

    public String getLivro() {
        return livro;
    }

    public void setLivro(String livro) {
        this.livro = livro;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getNumeroResidencia() {
        return numeroResidencia;
    }

    public void setNumeroResidencia(String numeroResidencia) {
        this.numeroResidencia = numeroResidencia;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
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

    @Override
    public int compareTo(Aluno outro) {
        return this.nome.compareTo(outro.getNome());
    }

}
