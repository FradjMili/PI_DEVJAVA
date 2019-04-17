
package entities;


import java.util.Date;

/**
 *
 * @author USER
 */
public class InfoG {

    
    private Integer id;
   
    private String nom;
    
    private String prenom;
    
    private Date dateNais;
    
    private int tele;
   
    private String adrMail;
   
    private String adresse;
    
    private FosUser fosUser;

    public InfoG() {
    }

    public InfoG(Integer id) {
        this.id = id;
    }

    public InfoG(String nom, String prenom, Date dateNais, int tele, String adrMail, String adresse,FosUser fosUser ) {
       
        this.nom = nom;
        this.prenom = prenom;
        this.dateNais = dateNais;
        this.tele = tele;
        this.adrMail = adrMail;
        this.adresse = adresse;
        this.fosUser=fosUser;
    }
    
    
    public InfoG( String nom, String prenom, Date dateNais, int tele, String adrMail, String adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNais = dateNais;
        this.tele = tele;
        this.adrMail = adrMail;
        this.adresse = adresse;
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNais() {
        return dateNais;
    }

    public void setDateNais(Date dateNais) {
        this.dateNais = dateNais;
    }

    public int getTele() {
        return tele;
    }

    public void setTele(int tele) {
        this.tele = tele;
    }

    public String getAdrMail() {
        return adrMail;
    }

    public void setAdrMail(String adrMail) {
        this.adrMail = adrMail;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
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
        if (!(object instanceof InfoG)) {
            return false;
        }
        InfoG other = (InfoG) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.InfoG[ id=" + id + " ]";
    }
    
}
