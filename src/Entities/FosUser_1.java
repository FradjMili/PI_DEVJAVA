/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "fos_user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FosUser_1.findAll", query = "SELECT f FROM FosUser_1 f")
    , @NamedQuery(name = "FosUser_1.findById", query = "SELECT f FROM FosUser_1 f WHERE f.id = :id")
    , @NamedQuery(name = "FosUser_1.findByUsername", query = "SELECT f FROM FosUser_1 f WHERE f.username = :username")
    , @NamedQuery(name = "FosUser_1.findByUsernameCanonical", query = "SELECT f FROM FosUser_1 f WHERE f.usernameCanonical = :usernameCanonical")
    , @NamedQuery(name = "FosUser_1.findByEmail", query = "SELECT f FROM FosUser_1 f WHERE f.email = :email")
    , @NamedQuery(name = "FosUser_1.findByEmailCanonical", query = "SELECT f FROM FosUser_1 f WHERE f.emailCanonical = :emailCanonical")
    , @NamedQuery(name = "FosUser_1.findByEnabled", query = "SELECT f FROM FosUser_1 f WHERE f.enabled = :enabled")
    , @NamedQuery(name = "FosUser_1.findBySalt", query = "SELECT f FROM FosUser_1 f WHERE f.salt = :salt")
    , @NamedQuery(name = "FosUser_1.findByPassword", query = "SELECT f FROM FosUser_1 f WHERE f.password = :password")
    , @NamedQuery(name = "FosUser_1.findByLastLogin", query = "SELECT f FROM FosUser_1 f WHERE f.lastLogin = :lastLogin")
    , @NamedQuery(name = "FosUser_1.findByConfirmationToken", query = "SELECT f FROM FosUser_1 f WHERE f.confirmationToken = :confirmationToken")
    , @NamedQuery(name = "FosUser_1.findByPasswordRequestedAt", query = "SELECT f FROM FosUser_1 f WHERE f.passwordRequestedAt = :passwordRequestedAt")
    , @NamedQuery(name = "FosUser_1.findByHascv", query = "SELECT f FROM FosUser_1 f WHERE f.hascv = :hascv")})
public class FosUser_1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "username_canonical")
    private String usernameCanonical;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "email_canonical")
    private String emailCanonical;
    @Basic(optional = false)
    @Column(name = "enabled")
    private boolean enabled;
    @Column(name = "salt")
    private String salt;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Column(name = "last_login")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogin;
    @Column(name = "confirmation_token")
    private String confirmationToken;
    @Column(name = "password_requested_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date passwordRequestedAt;
    @Basic(optional = false)
    @Lob
    @Column(name = "roles")
    private String roles;
    @Column(name = "hascv")
    private Boolean hascv;
    @OneToMany(mappedBy = "fosUser")
    private Collection<Competences> competencesCollection;
    @OneToMany(mappedBy = "fosUser")
    private Collection<Formations> formationsCollection;
    @OneToOne(mappedBy = "fosUser")
    private InfoG infoG;
    @OneToMany(mappedBy = "fosUser")
    private Collection<Experiences> experiencesCollection;

    public FosUser_1() {
    }

    public FosUser_1(Integer id) {
        this.id = id;
    }

    public FosUser_1(Integer id, String username, String usernameCanonical, String email, String emailCanonical, boolean enabled, String password, String roles) {
        this.id = id;
        this.username = username;
        this.usernameCanonical = usernameCanonical;
        this.email = email;
        this.emailCanonical = emailCanonical;
        this.enabled = enabled;
        this.password = password;
        this.roles = roles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsernameCanonical() {
        return usernameCanonical;
    }

    public void setUsernameCanonical(String usernameCanonical) {
        this.usernameCanonical = usernameCanonical;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailCanonical() {
        return emailCanonical;
    }

    public void setEmailCanonical(String emailCanonical) {
        this.emailCanonical = emailCanonical;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getConfirmationToken() {
        return confirmationToken;
    }

    public void setConfirmationToken(String confirmationToken) {
        this.confirmationToken = confirmationToken;
    }

    public Date getPasswordRequestedAt() {
        return passwordRequestedAt;
    }

    public void setPasswordRequestedAt(Date passwordRequestedAt) {
        this.passwordRequestedAt = passwordRequestedAt;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public Boolean getHascv() {
        return hascv;
    }

    public void setHascv(Boolean hascv) {
        this.hascv = hascv;
    }

    @XmlTransient
    public Collection<Competences> getCompetencesCollection() {
        return competencesCollection;
    }

    public void setCompetencesCollection(Collection<Competences> competencesCollection) {
        this.competencesCollection = competencesCollection;
    }

    @XmlTransient
    public Collection<Formations> getFormationsCollection() {
        return formationsCollection;
    }

    public void setFormationsCollection(Collection<Formations> formationsCollection) {
        this.formationsCollection = formationsCollection;
    }

    public InfoG getInfoG() {
        return infoG;
    }

    public void setInfoG(InfoG infoG) {
        this.infoG = infoG;
    }

    @XmlTransient
    public Collection<Experiences> getExperiencesCollection() {
        return experiencesCollection;
    }

    public void setExperiencesCollection(Collection<Experiences> experiencesCollection) {
        this.experiencesCollection = experiencesCollection;
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
        if (!(object instanceof FosUser_1)) {
            return false;
        }
        FosUser_1 other = (FosUser_1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.FosUser_1[ id=" + id + " ]";
    }
    
}
