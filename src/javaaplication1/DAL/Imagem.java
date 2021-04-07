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
@Table(name = "IMAGEM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Imagem.findAll", query = "SELECT i FROM Imagem i")
    , @NamedQuery(name = "Imagem.findByIdImagem", query = "SELECT i FROM Imagem i WHERE i.idImagem = :idImagem")
    , @NamedQuery(name = "Imagem.findByDesignacao", query = "SELECT i FROM Imagem i WHERE i.designacao = :designacao")
    , @NamedQuery(name = "Imagem.findByLink", query = "SELECT i FROM Imagem i WHERE i.link = :link")})
public class Imagem implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_IMAGEM")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idImagem;
    @Basic(optional = false)
    @Column(name = "DESIGNACAO")
    private String designacao;
    @Basic(optional = false)
    @Column(name = "LINK")
    private String link;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idImagem")
    private List<Anuncio> anuncioList;

    public Imagem() {
    }

    public Imagem(Integer idImagem) {
        this.idImagem = idImagem;
    }

    public Imagem(Integer idImagem, String designacao, String link) {
        this.idImagem = idImagem;
        this.designacao = designacao;
        this.link = link;
    }

    public Integer getIdImagem() {
        return idImagem;
    }

    public void setIdImagem(Integer idImagem) {
        this.idImagem = idImagem;
    }

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
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
        hash += (idImagem != null ? idImagem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Imagem)) {
            return false;
        }
        Imagem other = (Imagem) object;
        if ((this.idImagem == null && other.idImagem != null) || (this.idImagem != null && !this.idImagem.equals(other.idImagem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication1.Imagem[ idImagem=" + idImagem + " ]";
    }
    
}
