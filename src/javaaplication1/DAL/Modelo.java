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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "MODELO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Modelo.findAll", query = "SELECT m FROM Modelo m")
    , @NamedQuery(name = "Modelo.findByIdModelo", query = "SELECT m FROM Modelo m WHERE m.idModelo = :idModelo")
    , @NamedQuery(name = "Modelo.findByDesignacao", query = "SELECT m FROM Modelo m WHERE m.designacao = :designacao")})
public class Modelo implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_MODELO")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idModelo;
    @Basic(optional = false)
    @Column(name = "DESIGNACAO")
    private String designacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idModelo")
    private List<Anuncio> anuncioList;
    @JoinColumn(name = "ID_MARCA", referencedColumnName = "ID_MARCA")
    @ManyToOne(optional = false)
    private Marcas idMarca;

    public Modelo() {
    }

    public Modelo(Integer idModelo) {
        this.idModelo = idModelo;
    }

    public Modelo(Integer idModelo, String designacao) {
        this.idModelo = idModelo;
        this.designacao = designacao;
    }

    public Integer getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(Integer idModelo) {
        this.idModelo = idModelo;
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

    public Marcas getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Marcas idMarca) {
        this.idMarca = idMarca;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idModelo != null ? idModelo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modelo)) {
            return false;
        }
        Modelo other = (Modelo) object;
        if ((this.idModelo == null && other.idModelo != null) || (this.idModelo != null && !this.idModelo.equals(other.idModelo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication1.Modelo[ idModelo=" + idModelo + " ]";
    }
    
}
