/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaaplication1.DAL;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author utilizador
 */
@Entity
@Table(name = "UTILIZADOR")

@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Utilizador.findAll", query = "SELECT u FROM Utilizador u")
    , @NamedQuery(name = "Utilizador.findByIdUtilizador", query = "SELECT u FROM Utilizador u WHERE u.idUtilizador = :idUtilizador")
    , @NamedQuery(name = "Utilizador.findByNome", query = "SELECT u FROM Utilizador u WHERE u.nome = :nome")
    , @NamedQuery(name = "Utilizador.findByDistrito", query = "SELECT u FROM Utilizador u WHERE u.distrito = :distrito")
    , @NamedQuery(name = "Utilizador.findByCidade", query = "SELECT u FROM Utilizador u WHERE u.cidade = :cidade")
    , @NamedQuery(name = "Utilizador.findByMorada", query = "SELECT u FROM Utilizador u WHERE u.morada = :morada")
    , @NamedQuery(name = "Utilizador.findByPortaAndar", query = "SELECT u FROM Utilizador u WHERE u.portaAndar = :portaAndar")
    , @NamedQuery(name = "Utilizador.findByCodPostal", query = "SELECT u FROM Utilizador u WHERE u.codPostal = :codPostal")
    , @NamedQuery(name = "Utilizador.findByNif", query = "SELECT u FROM Utilizador u WHERE u.nif = :nif")
    , @NamedQuery(name = "Utilizador.findByTelemovel", query = "SELECT u FROM Utilizador u WHERE u.telemovel = :telemovel")
    , @NamedQuery(name = "Utilizador.findByEmail", query = "SELECT u FROM Utilizador u WHERE u.email = :email")
    , @NamedQuery(name = "Utilizador.findByPasse", query = "SELECT u FROM Utilizador u WHERE u.passe = :passe")
    , @NamedQuery(name = "Utilizador.findByDataRegisto", query = "SELECT u FROM Utilizador u WHERE u.dataRegisto = :dataRegisto")})
public class Utilizador implements Serializable {

    @Basic(optional = false)
    @Column(name = "NIF")
    private Integer nif;
    @Basic(optional = false)
    @Column(name = "TELEMOVEL")
    private Integer telemovel;

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_UTILIZADOR")
    @GeneratedValue(strategy=GenerationType.IDENTITY, generator="UtilizadorGenerator")
    @SequenceGenerator(name="UtilizadorGenerator", sequenceName ="UTILIZADOR_SEQ",allocationSize=50)
    private Integer idUtilizador;
    @Basic(optional = false)
    @Column(name = "NOME")
    private String nome;
    @Basic(optional = false)
    @Column(name = "DISTRITO")
    private String distrito;
    @Basic(optional = false)
    @Column(name = "CIDADE")
    private String cidade;
    @Basic(optional = false)
    @Column(name = "MORADA")
    private String morada;
    @Basic(optional = false)
    @Column(name = "PORTA_ANDAR")
    private String portaAndar;
    @Basic(optional = false)
    @Column(name = "COD_POSTAL")
    private String codPostal;
    @Basic(optional = false)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @Column(name = "PASSE")
    private String passe;
    @Column(name = "DATA_REGISTO")
    private String dataRegisto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUtilizador")
    private List<Anuncio> anuncioList;

    public Utilizador() {
    }

    public Utilizador(Integer idUtilizador) {
        this.idUtilizador = idUtilizador;
    }

    public Utilizador(Integer idUtilizador, String nome, String distrito, String cidade, String morada, String portaAndar, String codPostal, Integer nif, Integer telemovel, String email, String passe) {
        this.idUtilizador = idUtilizador;
        this.nome = nome;
        this.distrito = distrito;
        this.cidade = cidade;
        this.morada = morada;
        this.portaAndar = portaAndar;
        this.codPostal = codPostal;
        this.nif = nif;
        this.telemovel = telemovel;
        this.email = email;
        this.passe = passe;
    }

    public Integer getIdUtilizador() {
        return idUtilizador;
    }

    public void setIdUtilizador(Integer idUtilizador) {
        this.idUtilizador = idUtilizador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getPortaAndar() {
        return portaAndar;
    }

    public void setPortaAndar(String portaAndar) {
        this.portaAndar = portaAndar;
    }

    public String getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasse() {
        return passe;
    }

    public void setPasse(String passe) {
        this.passe = passe;
    }

    public String getDataRegisto() {
        return dataRegisto;
    }

    public void setDataRegisto(String dataRegisto) {
        this.dataRegisto = dataRegisto;
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
        hash += (idUtilizador != null ? idUtilizador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilizador)) {
            return false;
        }
        Utilizador other = (Utilizador) object;
        if ((this.idUtilizador == null && other.idUtilizador != null) || (this.idUtilizador != null && !this.idUtilizador.equals(other.idUtilizador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication1.Utilizador[ idUtilizador=" + idUtilizador + " ]";
    }

    public Integer getNif() {
        return nif;
    }

    public void setNif(Integer nif) {
        this.nif = nif;
    }

    public Integer getTelemovel() {
        return telemovel;
    }

    public void setTelemovel(Integer telemovel) {
        this.telemovel = telemovel;
    }
    
}
