/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaaplication1.DAL;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author utilizador
 */
@Entity
@Table(name = "DENUNCIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Denuncia.findAll", query = "SELECT d FROM Denuncia d")
    , @NamedQuery(name = "Denuncia.findByIdDenuncia", query = "SELECT d FROM Denuncia d WHERE d.idDenuncia = :idDenuncia")
    , @NamedQuery(name = "Denuncia.findByDescricao", query = "SELECT d FROM Denuncia d WHERE d.descricao = :descricao")
    , @NamedQuery(name = "Denuncia.findByData", query = "SELECT d FROM Denuncia d WHERE d.data = :data")
    , @NamedQuery(name = "Denuncia.findByRelsovido", query = "SELECT d FROM Denuncia d WHERE d.relsovido = :relsovido")
    , @NamedQuery(name = "Denuncia.findByTitulo", query = "SELECT d FROM Denuncia d WHERE d.titulo = :titulo")
    , @NamedQuery(name = "Denuncia.findByVisto", query = "SELECT d FROM Denuncia d WHERE d.visto = :visto")})
public class Denuncia implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_DENUNCIA")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idDenuncia;
    @Basic(optional = false)
    @Column(name = "DESCRICAO")
    private String descricao;
    @Basic(optional = false)
    @Column(name = "DATA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @Basic(optional = false)
    @Column(name = "RELSOVIDO")
    private BigInteger relsovido;
    @Basic(optional = false)
    @Column(name = "TITULO")
    private String titulo;
    @Basic(optional = false)
    @Column(name = "VISTO")
    private BigInteger visto;
    @JoinColumn(name = "ID_ANUNCIO", referencedColumnName = "ID_ANUNCIO")
    @ManyToOne(optional = false)
    private Anuncio idAnuncio;

    public Denuncia() {
    }

    public Denuncia(Integer idDenuncia) {
        this.idDenuncia = idDenuncia;
    }

    public Denuncia(Integer idDenuncia, String descricao, Date data, BigInteger relsovido, String titulo, BigInteger visto) {
        this.idDenuncia = idDenuncia;
        this.descricao = descricao;
        this.data = data;
        this.relsovido = relsovido;
        this.titulo = titulo;
        this.visto = visto;
    }

    public Integer getIdDenuncia() {
        return idDenuncia;
    }

    public void setIdDenuncia(Integer idDenuncia) {
        this.idDenuncia = idDenuncia;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public BigInteger getRelsovido() {
        return relsovido;
    }

    public void setRelsovido(BigInteger relsovido) {
        this.relsovido = relsovido;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public BigInteger getVisto() {
        return visto;
    }

    public void setVisto(BigInteger visto) {
        this.visto = visto;
    }

    public Anuncio getIdAnuncio() {
        return idAnuncio;
    }

    public void setIdAnuncio(Anuncio idAnuncio) {
        this.idAnuncio = idAnuncio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDenuncia != null ? idDenuncia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Denuncia)) {
            return false;
        }
        Denuncia other = (Denuncia) object;
        if ((this.idDenuncia == null && other.idDenuncia != null) || (this.idDenuncia != null && !this.idDenuncia.equals(other.idDenuncia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication1.Denuncia[ idDenuncia=" + idDenuncia + " ]";
    }
    
}
