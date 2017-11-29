package br.com.controle.util.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author otavi
 */
@Entity
public class Avaliacao implements BeanBase, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "idBimestre", nullable = false)
    private Bimestre bimestre;

    @ManyToOne
    @JoinColumn(name = "idTipoAvaliacao", nullable = false)
    private TipoAvaliacao tipoAvaliacao;

    @ManyToOne
    @JoinColumn(name = "idTHorario", nullable = false)
    private Horario horario;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date DataPrevistaAplicacao;

    private boolean processada;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Bimestre getBimestre() {
        return bimestre;
    }

    public void setBimestre(Bimestre bimestre) {
        this.bimestre = bimestre;
    }

    public TipoAvaliacao getTipoAvaliacao() {
        return tipoAvaliacao;
    }

    public void setTipoAvaliacao(TipoAvaliacao tipoAvaliacao) {
        this.tipoAvaliacao = tipoAvaliacao;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public Date getDataPrevistaAplicacao() {
        return DataPrevistaAplicacao;
    }

    public void setDataPrevistaAplicacao(Date DataPrevistaAplicacao) {
        this.DataPrevistaAplicacao = DataPrevistaAplicacao;
    }

    public boolean isProcessada() {
        return processada;
    }

    public void setProcessada(boolean processada) {
        this.processada = processada;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 79 * hash + Objects.hashCode(this.bimestre);
        hash = 79 * hash + Objects.hashCode(this.tipoAvaliacao);
        hash = 79 * hash + Objects.hashCode(this.horario);
        hash = 79 * hash + Objects.hashCode(this.DataPrevistaAplicacao);
        hash = 79 * hash + (this.processada ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Avaliacao other = (Avaliacao) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.bimestre, other.bimestre)) {
            return false;
        }
        if (!Objects.equals(this.tipoAvaliacao, other.tipoAvaliacao)) {
            return false;
        }
        if (!Objects.equals(this.horario, other.horario)) {
            return false;
        }
        if (!Objects.equals(this.DataPrevistaAplicacao, other.DataPrevistaAplicacao)) {
            return false;
        }
        return true;
    }

}
