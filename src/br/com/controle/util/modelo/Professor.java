package br.com.controle.util.modelo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Otavio Costa
 */
@Entity
public class Professor implements BeanBase, Serializable {

    public Professor() {
    }

    @Id
    @Column(name = "matricula", nullable = false, unique = true)
    private String matricula;

    @Column(name = "nome")
    private String nome;

    private String situacao;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "professor")
    private List<Nota> notas;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "professor")
    private List<Horario> horarios;

    /*  @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "ProfessorDisciplina", joinColumns = @JoinColumn(name = "matricula_professor", referencedColumnName = "matricula"),
    inverseJoinColumns = @JoinColumn(name = "id_disciplina", referencedColumnName = "id"))
    private List<Disciplina> disciplinas;*/

    /**
     * retorna o nome do Professor
     *
     * @return
     */
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.matricula);
        hash = 67 * hash + Objects.hashCode(this.nome);
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
        final Professor other = (Professor) obj;
        if (!Objects.equals(this.matricula, other.matricula)) {
            return false;
        }
        return true;
    }

}
