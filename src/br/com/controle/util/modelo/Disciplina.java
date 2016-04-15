package br.com.controle.util.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Otavio Costa
 */
@Entity
@Table(name = "disciplina")
public class Disciplina implements BeanBase, Serializable {

    public static final int REPROVA = 0;
    public static final int NAO_REPROVA = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDisciplina")
    private long id;

    @Column(nullable = false, unique = true)
    private String descricao;

    /**
     * Pode-se adicionar comentários à disciplina através desse campo por meio
     * de seu <b>Get</b> e <b>Set</b>
     */
    private String comentario;

    /**
     * O tipo indica se a Disciplina é reprovativa ou não!
     */
    private String tipo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "disciplina")
    private List<Nota> notas;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "disciplina")
    private List<Horario> horarios;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "disciplina")
    private List<Falta> faltas;

    public List<Falta> getFaltas() {
        return faltas;
    }

    public void setFaltas(List<Falta> faltas) {
        this.faltas = faltas;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    @Override
    public String toString() {
        return descricao;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public List<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
    }

    public long getId() {
        return id;
    }

}
