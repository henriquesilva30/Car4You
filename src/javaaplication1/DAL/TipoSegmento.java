/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaaplication1.DAL;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author utilizador
 */
@Entity
@Table(name = "TIPO_SEGMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoSegmento.findAll", query = "SELECT t FROM TipoSegmento t")
    , @NamedQuery(name = "TipoSegmento.findByIdSegmento", query = "SELECT t FROM TipoSegmento t WHERE t.idSegmento = :idSegmento")
    , @NamedQuery(name = "TipoSegmento.findByDesignacao", query = "SELECT t FROM TipoSegmento t WHERE t.designacao = :designacao")})
public class TipoSegmento implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_SEGMENTO")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idSegmento;
    @Basic(optional = false)
    @Column(name = "DESIGNACAO")
    private String designacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSegmento")
    private List<Anuncio> anuncioList;

    public TipoSegmento() {
    }

    public TipoSegmento(Integer idSegmento) {
        this.idSegmento = idSegmento;
    }

    public TipoSegmento(Integer idSegmento, String designacao) {
        this.idSegmento = idSegmento;
        this.designacao = designacao;
    }

    public Integer getIdSegmento() {
        return idSegmento;
    }

    public void setIdSegmento(Integer idSegmento) {
        this.idSegmento = idSegmento;
    }

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    @XmlTransient
    public List<Anuncio> getAnuncioList() {
        return anuncioList;
    }

    public void setAnuncioList(List<Anuncio> anuncioList) {
        this.anuncioList = anuncioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSegmento != null ? idSegmento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoSegmento)) {
            return false;
        }
        TipoSegmento other = (TipoSegmento) object;
        if ((this.idSegmento == null && other.idSegmento != null) || (this.idSegmento != null && !this.idSegmento.equals(other.idSegmento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication1.TipoSegmento[ idSegmento=" + idSegmento + " ]";
    }
    
}
