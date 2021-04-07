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
@Table(name = "TIPO_DESGASTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoDesgaste.findAll", query = "SELECT t FROM TipoDesgaste t")
    , @NamedQuery(name = "TipoDesgaste.findByIdDesgaste", query = "SELECT t FROM TipoDesgaste t WHERE t.idDesgaste = :idDesgaste")
    , @NamedQuery(name = "TipoDesgaste.findByDesignacao", query = "SELECT t FROM TipoDesgaste t WHERE t.designacao = :designacao")})
public class TipoDesgaste implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_DESGASTE")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idDesgaste;
    @Basic(optional = false)
    @Column(name = "DESIGNACAO")
    private String designacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDesgaste")
    private List<Anuncio> anuncioList;

    public TipoDesgaste() {
    }

    public TipoDesgaste(Integer idDesgaste) {
        this.idDesgaste = idDesgaste;
    }

    public TipoDesgaste(Integer idDesgaste, String designacao) {
        this.idDesgaste = idDesgaste;
        this.designacao = designacao;
    }

    public Integer getIdDesgaste() {
        return idDesgaste;
    }

    public void setIdDesgaste(Integer idDesgaste) {
        this.idDesgaste = idDesgaste;
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
        hash += (idDesgaste != null ? idDesgaste.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDesgaste)) {
            return false;
        }
        TipoDesgaste other = (TipoDesgaste) object;
        if ((this.idDesgaste == null && other.idDesgaste != null) || (this.idDesgaste != null && !this.idDesgaste.equals(other.idDesgaste))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication1.TipoDesgaste[ idDesgaste=" + idDesgaste + " ]";
    }
    
}
