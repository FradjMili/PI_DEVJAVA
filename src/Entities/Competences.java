
package entities;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USER
 */

public class Competences implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    private String nomCompetence;
    
    private String nomCertif;
  
    private String langues;
   
    private FosUser fosUser;

    public Competences() {
    }

    public Competences(Integer id) {
        this.id = id;
    }

    public Competences(Integer id, String nomCompetence, String nomCertif, String langues) {
        this.id = id;
        this.nomCompetence = nomCompetence;
        this.nomCertif = nomCertif;
        this.langues = langues;
    }
    
    
    public Competences( String nomCompetence, String nomCertif, String langues,FosUser fosUser) {
        this.id = id;
        this.nomCompetence = nomCompetence;
        this.nomCertif = nomCertif;
        this.langues = langues; 
        this.fosUser=fosUser;
        
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomCompetence() {
        return nomCompetence;
    }

    public void setNomCompetence(String nomCompetence) {
        this.nomCompetence = nomCompetence;
    }

    public String getNomCertif() {
        return nomCertif;
    }

    public void setNomCertif(String nomCertif) {
        this.nomCertif = nomCertif;
    }

    public String getLangues() {
        return langues;
    }

    public void setLangues(String langues) {
        this.langues = langues;
    }

    public FosUser getFosUser() {
        return fosUser;
    }

    public void setFosUser(FosUser fosUser) {
        this.fosUser = fosUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Competences)) {
            return false;
        }
        Competences other = (Competences) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Competences[ id=" + id + " ]";
    }
    
}
