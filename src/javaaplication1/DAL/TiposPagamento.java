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
@Table(name = "TIPOS_PAGAMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TiposPagamento.findAll", query = "SELECT t FROM TiposPagamento t")
    , @NamedQuery(name = "TiposPagamento.findByIdTipoPagamento", query = "SELECT t FROM TiposPagamento t WHERE t.idTipoPagamento = :idTipoPagamento")
    , @NamedQuery(name = "TiposPagamento.findByDesignacao", query = "SELECT t FROM TiposPagamento t WHERE t.designacao = :designacao")})
public class TiposPagamento implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_TIPO_PAGAMENTO")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idTipoPagamento;
    @Basic(optional = false)
    @Column(name = "DESIGNACAO")
    private String designacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "meioPagamento")
    private List<Servico> servicoList;

    public TiposPagamento() {
    }

    public TiposPagamento(Integer idTipoPagamento) {
        this.idTipoPagamento = idTipoPagamento;
    }

    public TiposPagamento(Integer idTipoPagamento, String designacao) {
        this.idTipoPagamento = idTipoPagamento;
        this.designacao = designacao;
    }

    public Integer getIdTipoPagamento() {
        return idTipoPagamento;
    }

    public void setIdTipoPagamento(Integer idTipoPagamento) {
        this.idTipoPagamento = idTipoPagamento;
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
        hash += (idTipoPagamento != null ? idTipoPagamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposPagamento)) {
            return false;
        }
        TiposPagamento other = (TiposPagamento) object;
        if ((this.idTipoPagamento == null && other.idTipoPagamento != null) || (this.idTipoPagamento != null && !this.idTipoPagamento.equals(other.idTipoPagamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication1.TiposPagamento[ idTipoPagamento=" + idTipoPagamento + " ]";
    }
    
}
