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
@Table(name = "COMBUSTIVEL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Combustivel.findAll", query = "SELECT c FROM Combustivel c")
    , @NamedQuery(name = "Combustivel.findByIdCombustivel", query = "SELECT c FROM Combustivel c WHERE c.idCombustivel = :idCombustivel")
    , @NamedQuery(name = "Combustivel.findByDesignacao", query = "SELECT c FROM Combustivel c WHERE c.designacao = :designacao")})
public class Combustivel implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_COMBUSTIVEL")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idCombustivel;
    @Basic(optional = false)
    @Column(name = "DESIGNACAO")
    private String designacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCombustivel")
    private List<Anuncio> anuncioList;

    public Combustivel() {
    }

    public Combustivel(Integer idCombustivel) {
        this.idCombustivel = idCombustivel;
    }

    public Combustivel(Integer idCombustivel, String designacao) {
        this.idCombustivel = idCombustivel;
        this.designacao = designacao;
    }

    public Integer getIdCombustivel() {
        return idCombustivel;
    }

    public void setIdCombustivel(Integer idCombustivel) {
        this.idCombustivel = idCombustivel;
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
        hash += (idCombustivel != null ? idCombustivel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Combustivel)) {
            return false;
        }
        Combustivel other = (Combustivel) object;
        if ((this.idCombustivel == null && other.idCombustivel != null) || (this.idCombustivel != null && !this.idCombustivel.equals(other.idCombustivel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication1.Combustivel[ idCombustivel=" + idCombustivel + " ]";
    }
    
}
