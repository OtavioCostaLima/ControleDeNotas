package br.com.controle.util.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author Otavio Costa
 */
@Entity
public class Professor implements BeanBase, Serializable {

    public Professor() {
    }

    @Id
    @Column(name = "matricula", nullable = false, unique = true,updatable = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long matricula;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(length = 25)
    private String cpf;
    @Column(length = 25)
    private String rg;
    private String tituloDeEleitor;
    private String secao;
    private String ctps;
    private String serie;
    private String rua;
    private String bairro;
    private String citade;
    @Column(length = 25)
    private String numeroResidencia;
    private String estadoCivil;
    @Column(length = 2)
    private String uf;
    private String posGraduacao;
    private String grauInstrucao;
    private String raca;
    private String pisPasep;
    private String orgaoEmissor;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataEmissao;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataNascimento;

    private String situacao;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "professor")
    private List<Nota> notas;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "professor")
    private List<Horario> horarios;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public List<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getTituloDeEleitor() {
        return tituloDeEleitor;
    }

    public void setTituloDeEleitor(String tituloDeEleitor) {
        this.tituloDeEleitor = tituloDeEleitor;
    }

    public String getSecao() {
        return secao;
    }

    public void setSecao(String secao) {
        this.secao = secao;
    }

    public String getCtps() {
        return ctps;
    }

    public void setCtps(String ctps) {
        this.ctps = ctps;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
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

    public String getCitade() {
        return citade;
    }

    public void setCitade(String citade) {
        this.citade = citade;
    }

    public String getNumeroResidencia() {
        return numeroResidencia;
    }

    public void setNumeroResidencia(String numeroResidencia) {
        this.numeroResidencia = numeroResidencia;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getPosGraduacao() {
        return posGraduacao;
    }

    public void setPosGraduacao(String posGraduacao) {
        this.posGraduacao = posGraduacao;
    }

    public String getGrauInstrucao() {
        return grauInstrucao;
    }

    public void setGrauInstrucao(String grauInstrucao) {
        this.grauInstrucao = grauInstrucao;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getPisPasep() {
        return pisPasep;
    }

    public void setPisPasep(String pisPasep) {
        this.pisPasep = pisPasep;
    }

    public String getOrgaoEmissor() {
        return orgaoEmissor;
    }

    public void setOrgaoEmissor(String orgaoEmissor) {
        this.orgaoEmissor = orgaoEmissor;
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

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(long matricula) {
        this.matricula = matricula;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.matricula);
        hash = 67 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("oi");
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Professor other = (Professor) obj;
        if (this.matricula != other.matricula) {
            return false;
        }
        return true;
    }

  

}
