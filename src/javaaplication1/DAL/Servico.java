/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaaplication1.DAL;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "SERVICO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servico.findAll", query = "SELECT s FROM Servico s")
    , @NamedQuery(name = "Servico.findByIdSevico", query = "SELECT s FROM Servico s WHERE s.idSevico = :idSevico")
    , @NamedQuery(name = "Servico.findByDesignacao", query = "SELECT s FROM Servico s WHERE s.designacao = :designacao")
    , @NamedQuery(name = "Servico.findByDataInicio", query = "SELECT s FROM Servico s WHERE s.dataInicio = :dataInicio")
    , @NamedQuery(name = "Servico.findByValor", query = "SELECT s FROM Servico s WHERE s.valor = :valor")
    , @NamedQuery(name = "Servico.findByDataFim", query = "SELECT s FROM Servico s WHERE s.dataFim = :dataFim")})
public class Servico implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_SEVICO")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idSevico;
    @Basic(optional = false)
    @Column(name = "DESIGNACAO")
    private String designacao;
    @Basic(optional = false)
    @Column(name = "DATA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInicio;
    @Basic(optional = false)
    @Column(name = "VALOR")
    private double valor;
    @Basic(optional = false)
    @Column(name = "DATA_FIM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataFim;
    @JoinColumn(name = "ID_ANUNCIO", referencedColumnName = "ID_ANUNCIO")
    @ManyToOne(optional = false)
    private Anuncio idAnuncio;
    @JoinColumn(name = "MEIO_PAGAMENTO", referencedColumnName = "ID_TIPO_PAGAMENTO")
    @ManyToOne(optional = false)
    private TiposPagamento meioPagamento;
    @JoinColumn(name = "ID_TIPO_SERVICO", referencedColumnName = "ID_TIPO_SERVICO")
    @ManyToOne(optional = false)
    private TiposServico idTipoServico;

    public Servico() {
    }

    public Servico(Integer idSevico) {
        this.idSevico = idSevico;
    }

    public Servico(Integer idSevico, String designacao, Date dataInicio, double valor, Date dataFim) {
        this.idSevico = idSevico;
        this.designacao = designacao;
        this.dataInicio = dataInicio;
        this.valor = valor;
        this.dataFim = dataFim;
    }

    public Integer getIdSevico() {
        return idSevico;
    }

    public void setIdSevico(Integer idSevico) {
        this.idSevico = idSevico;
    }

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Anuncio getIdAnuncio() {
        return idAnuncio;
    }

    public void setIdAnuncio(Anuncio idAnuncio) {
        this.idAnuncio = idAnuncio;
    }

    public TiposPagamento getMeioPagamento() {
        return meioPagamento;
    }

    public void setMeioPagamento(TiposPagamento meioPagamento) {
        this.meioPagamento = meioPagamento;
    }

    public TiposServico getIdTipoServico() {
        return idTipoServico;
    }

    public void setIdTipoServico(TiposServico idTipoServico) {
        this.idTipoServico = idTipoServico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSevico != null ? idSevico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servico)) {
            return false;
        }
        Servico other = (Servico) object;
        if ((this.idSevico == null && other.idSevico != null) || (this.idSevico != null && !this.idSevico.equals(other.idSevico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication1.Servico[ idSevico=" + idSevico + " ]";
    }
    
}
