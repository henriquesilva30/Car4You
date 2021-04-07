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
@Table(name = "ESTADO_ANUNCIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoAnuncio.findAll", query = "SELECT e FROM EstadoAnuncio e")
    , @NamedQuery(name = "EstadoAnuncio.findByIdEstado", query = "SELECT e FROM EstadoAnuncio e WHERE e.idEstado = :idEstado")
    , @NamedQuery(name = "EstadoAnuncio.findByDesignacao", query = "SELECT e FROM EstadoAnuncio e WHERE e.designacao = :designacao")})
public class EstadoAnuncio implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_ESTADO")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idEstado;
    @Basic(optional = false)
    @Column(name = "DESIGNACAO")
    private String designacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstado")
    private List<Anuncio> anuncioList;

    public EstadoAnuncio() {
    }

    public EstadoAnuncio(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public EstadoAnuncio(Integer idEstado, String designacao) {
        this.idEstado = idEstado;
        this.designacao = designacao;
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
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
        hash += (idEstado != null ? idEstado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoAnuncio)) {
            return false;
        }
        EstadoAnuncio other = (EstadoAnuncio) object;
        if ((this.idEstado == null && other.idEstado != null) || (this.idEstado != null && !this.idEstado.equals(other.idEstado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication1.EstadoAnuncio[ idEstado=" + idEstado + " ]";
    }
    
}
