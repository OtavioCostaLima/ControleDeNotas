package br.com.controle.util.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Otavio Costa
 */
@Embeddable
public class HorarioPK implements Serializable {

    @Column(name = "idProfessor")
    private long professor;
    @Column(name = "idDisciplina")
    private long disciplina;

    public HorarioPK() {
    }

    public HorarioPK(long professor, long disciplina) {
        this.professor = professor;
        this.disciplina = disciplina;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.professor);
        hash = 89 * hash + (int) (this.disciplina ^ (this.disciplina >>> 32));
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
        final HorarioPK other = (HorarioPK) obj;
        if (!Objects.equals(this.professor, other.professor)) {
            return false;
        }
        if (this.disciplina != other.disciplina) {
            return false;
        }
        return true;
    }

}
