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
@Table(name = "TIPOS_SERVICO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TiposServico.findAll", query = "SELECT t FROM TiposServico t")
    , @NamedQuery(name = "TiposServico.findByIdTipoServico", query = "SELECT t FROM TiposServico t WHERE t.idTipoServico = :idTipoServico")
    , @NamedQuery(name = "TiposServico.findByDesignacao", query = "SELECT t FROM TiposServico t WHERE t.designacao = :designacao")})
public class TiposServico implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_TIPO_SERVICO")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idTipoServico;
    @Basic(optional = false)
    @Column(name = "DESIGNACAO")
    private String designacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoServico")
    private List<Servico> servicoList;

    public TiposServico() {
    }

    public TiposServico(Integer idTipoServico) {
        this.idTipoServico = idTipoServico;
    }

    public TiposServico(Integer idTipoServico, String designacao) {
        this.idTipoServico = idTipoServico;
        this.designacao = designacao;
    }

    public Integer getIdTipoServico() {
        return idTipoServico;
    }

    public void setIdTipoServico(Integer idTipoServico) {
        this.idTipoServico = idTipoServico;
    }

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    @XmlTransient
    public List<Servico> getServicoList() {
        return servicoList;
    }

    public void setServicoList(List<Servico> servicoList) {
        this.servicoList = servicoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoServico != null ? idTipoServico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposServico)) {
            return false;
        }
        TiposServico other = (TiposServico) object;
        if ((this.idTipoServico == null && other.idTipoServico != null) || (this.idTipoServico != null && !this.idTipoServico.equals(other.idTipoServico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication1.TiposServico[ idTipoServico=" + idTipoServico + " ]";
    }
    
}
