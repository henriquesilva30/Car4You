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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author utilizador
 */
@Entity
@Table(name = "ANUNCIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Anuncio.findAll", query = "SELECT a FROM Anuncio a")
    , @NamedQuery(name = "Anuncio.findByIdAnuncio", query = "SELECT a FROM Anuncio a WHERE a.idAnuncio = :idAnuncio")
    , @NamedQuery(name = "Anuncio.findByDesignacao", query = "SELECT a FROM Anuncio a WHERE a.designacao = :designacao")
    , @NamedQuery(name = "Anuncio.findByDataCriado", query = "SELECT a FROM Anuncio a WHERE a.dataCriado = :dataCriado")
    , @NamedQuery(name = "Anuncio.findByUrlVideo", query = "SELECT a FROM Anuncio a WHERE a.urlVideo = :urlVideo")
    , @NamedQuery(name = "Anuncio.findByDescricao", query = "SELECT a FROM Anuncio a WHERE a.descricao = :descricao")
    , @NamedQuery(name = "Anuncio.findByRenegociar", query = "SELECT a FROM Anuncio a WHERE a.renegociar = :renegociar")
    , @NamedQuery(name = "Anuncio.findByDataFim", query = "SELECT a FROM Anuncio a WHERE a.dataFim = :dataFim")
    , @NamedQuery(name = "Anuncio.findByValor", query = "SELECT a FROM Anuncio a WHERE a.valor = :valor")
    , @NamedQuery(name = "Anuncio.findByEstadoVeiculo", query = "SELECT a FROM Anuncio a WHERE a.estadoVeiculo = :estadoVeiculo")
    , @NamedQuery(name = "Anuncio.findByCor", query = "SELECT a FROM Anuncio a WHERE a.cor = :cor")
    , @NamedQuery(name = "Anuncio.findByNPortas", query = "SELECT a FROM Anuncio a WHERE a.nPortas = :nPortas")
    , @NamedQuery(name = "Anuncio.findByCaixa", query = "SELECT a FROM Anuncio a WHERE a.caixa = :caixa")
    , @NamedQuery(name = "Anuncio.findByMatricula", query = "SELECT a FROM Anuncio a WHERE a.matricula = :matricula")
    , @NamedQuery(name = "Anuncio.findByLotacao", query = "SELECT a FROM Anuncio a WHERE a.lotacao = :lotacao")
    , @NamedQuery(name = "Anuncio.findByAno", query = "SELECT a FROM Anuncio a WHERE a.ano = :ano")
    , @NamedQuery(name = "Anuncio.findByCilindrada", query = "SELECT a FROM Anuncio a WHERE a.cilindrada = :cilindrada")
    , @NamedQuery(name = "Anuncio.findByPotencia", query = "SELECT a FROM Anuncio a WHERE a.potencia = :potencia")
    , @NamedQuery(name = "Anuncio.findByKms", query = "SELECT a FROM Anuncio a WHERE a.kms = :kms")})
public class Anuncio implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_ANUNCIO")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idAnuncio;
    @Basic(optional = false)
    @Column(name = "DESIGNACAO")
    private String designacao;
    @Basic(optional = false)
    @Column(name = "DATA_CRIADO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriado;
    @Column(name = "URL_VIDEO")
    private String urlVideo;
    @Basic(optional = false)
    @Column(name = "DESCRICAO")
    private String descricao;
    @Basic(optional = false)
    @Column(name = "RENEGOCIAR")
    private Integer renegociar;
    @Basic(optional = false)
    @Column(name = "DATA_FIM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataFim;
    @Basic(optional = false)
    @Column(name = "VALOR")
    private double valor;
    @Basic(optional = false)
    @Column(name = "ESTADO_VEICULO")
    private Integer estadoVeiculo;
    @Basic(optional = false)
    @Column(name = "COR")
    private String cor;
    @Column(name = "N_PORTAS")
    private Integer nPortas;
    @Column(name = "CAIXA")
    private String caixa;
    @Basic(optional = false)
    @Column(name = "MATRICULA")
    private String matricula;
    @Column(name = "LOTACAO")
    private Integer lotacao;
    @Basic(optional = false)
    @Column(name = "ANO")
    private Integer ano;
    @Column(name = "CILINDRADA")
    private Integer cilindrada;
    @Basic(optional = false)
    @Column(name = "POTENCIA")
    private Integer potencia;
    @Basic(optional = false)
    @Column(name = "KMS")
    private Integer kms;
    @JoinColumn(name = "ID_COMBUSTIVEL", referencedColumnName = "ID_COMBUSTIVEL")
    @ManyToOne(optional = false)
    private Combustivel idCombustivel;
    @JoinColumn(name = "ID_ESTADO", referencedColumnName = "ID_ESTADO")
    @ManyToOne(optional = false)
    private EstadoAnuncio idEstado;
    @JoinColumn(name = "ID_IMAGEM", referencedColumnName = "ID_IMAGEM")
    @ManyToOne(optional = false)
    private Imagem idImagem;
    @JoinColumn(name = "ID_MODELO", referencedColumnName = "ID_MODELO")
    @ManyToOne(optional = false)
    private Modelo idModelo;
    @JoinColumn(name = "ID_DESGASTE", referencedColumnName = "ID_DESGASTE")
    @ManyToOne(optional = false)
    private TipoDesgaste idDesgaste;
    @JoinColumn(name = "ID_SEGMENTO", referencedColumnName = "ID_SEGMENTO")
    @ManyToOne(optional = false)
    private TipoSegmento idSegmento;
    @JoinColumn(name = "ID_TIPO_VEICULO", referencedColumnName = "ID_TIPO_VEICULO")
    @ManyToOne(optional = false)
    private TipoVeiculo idTipoVeiculo;
    @JoinColumn(name = "ID_UTILIZADOR", referencedColumnName = "ID_UTILIZADOR")
    @ManyToOne(optional = false)
    private Utilizador idUtilizador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAnuncio")
    private List<Servico> servicoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAnuncio")
    private List<Denuncia> denunciaList;

    public Anuncio() {
    }

    public Anuncio(Integer idAnuncio) {
        this.idAnuncio = idAnuncio;
    }
    
    public Anuncio(Integer idAnuncio, String designacao, Date dataCriado, String descricao, Integer renegociar, Date dataFim, double valor, Integer estadoVeiculo, String cor, String matricula, Integer ano, Integer potencia, Integer kms) {
        this.idAnuncio = idAnuncio;
        this.designacao = designacao;
        this.dataCriado = dataCriado;
        this.descricao = descricao;
        this.renegociar = renegociar;
        this.dataFim = dataFim;
        this.valor = valor;
        this.estadoVeiculo = estadoVeiculo;
        this.cor = cor;
        this.matricula = matricula;
        this.ano = ano;
        this.potencia = potencia;
        this.kms = kms;
    }

    public Integer getIdAnuncio() {
        return idAnuncio;
    }

    public void setIdAnuncio(Integer idAnuncio) {
        this.idAnuncio = idAnuncio;
    }

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public Date getDataCriado() {
        return dataCriado;
    }

    public void setDataCriado(Date dataCriado) {
        this.dataCriado = dataCriado;
    }

    public String getUrlVideo() {
        return urlVideo;
    }

    public void setUrlVideo(String urlVideo) {
        this.urlVideo = urlVideo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getRenegociar() {
        return renegociar;
    }

    public void setRenegociar(Integer renegociar) {
        this.renegociar = renegociar;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Integer getEstadoVeiculo() {
        return estadoVeiculo;
    }

    public void setEstadoVeiculo(Integer estadoVeiculo) {
        this.estadoVeiculo = estadoVeiculo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Integer getNPortas() {
        return nPortas;
    }

    public void setNPortas(Integer nPortas) {
        this.nPortas = nPortas;
    }

    public String getCaixa() {
        return caixa;
    }

    public void setCaixa(String caixa) {
        this.caixa = caixa;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Integer getLotacao() {
        return lotacao;
    }

    public void setLotacao(Integer lotacao) {
        this.lotacao = lotacao;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Integer getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(Integer cilindrada) {
        this.cilindrada = cilindrada;
    }

    public Integer getPotencia() {
        return potencia;
    }

    public void setPotencia(Integer potencia) {
        this.potencia = potencia;
    }

    public Integer getKms() {
        return kms;
    }

    public void setKms(Integer kms) {
        this.kms = kms;
    }

    public Combustivel getIdCombustivel() {
        return idCombustivel;
    }

    public void setIdCombustivel(Combustivel idCombustivel) {
        this.idCombustivel = idCombustivel;
    }

    public EstadoAnuncio getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(EstadoAnuncio idEstado) {
        this.idEstado = idEstado;
    }

    public Imagem getIdImagem() {
        return idImagem;
    }

    public void setIdImagem(Imagem idImagem) {
        this.idImagem = idImagem;
    }

    public Modelo getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(Modelo idModelo) {
        this.idModelo = idModelo;
    }

    public TipoDesgaste getIdDesgaste() {
        return idDesgaste;
    }

    public void setIdDesgaste(TipoDesgaste idDesgaste) {
        this.idDesgaste = idDesgaste;
    }

    public TipoSegmento getIdSegmento() {
        return idSegmento;
    }

    public void setIdSegmento(TipoSegmento idSegmento) {
        this.idSegmento = idSegmento;
    }

    public TipoVeiculo getIdTipoVeiculo() {
        return idTipoVeiculo;
    }

    public void setIdTipoVeiculo(TipoVeiculo idTipoVeiculo) {
        this.idTipoVeiculo = idTipoVeiculo;
    }

    public Utilizador getIdUtilizador() {
        return idUtilizador;
    }

    public void setIdUtilizador(Utilizador idUtilizador) {
        this.idUtilizador = idUtilizador;
    }

    @XmlTransient
    public List<Servico> getServicoList() {
        return servicoList;
    }

    public void setServicoList(List<Servico> servicoList) {
        this.servicoList = servicoList;
    }

    @XmlTransient
    public List<Denuncia> getDenunciaList() {
        return denunciaList;
    }

    public void setDenunciaList(List<Denuncia> denunciaList) {
        this.denunciaList = denunciaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAnuncio != null ? idAnuncio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Anuncio)) {
            return false;
        }
        Anuncio other = (Anuncio) object;
        if ((this.idAnuncio == null && other.idAnuncio != null) || (this.idAnuncio != null && !this.idAnuncio.equals(other.idAnuncio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication1.Anuncio[ idAnuncio=" + idAnuncio + " ]";
    }
    
}
