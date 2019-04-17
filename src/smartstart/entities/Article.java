/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartstart.entities;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Ala-y
 */
public class Article implements Serializable {

    private Integer id;
    private String titre;
    private String auteur;
    private String description;
    private Date dateCreation;
    private Date dateEdition;
    private String image;
    private Date updatedAt;
    private String contenu;
    private int categorieId;

    public Article() {
    }

    public Article(Integer id) {
        this.id = id;
    }

    public Article(Integer id, String titre, String auteur, String description, String image, String contenu) {
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
        this.description = description;
        this.image = image;
        this.contenu = contenu;
    }

    public Article(String titre, String auteur, String description, String image, String contenu, int categorieId) {
        this.titre = titre;
        this.auteur = auteur;
        this.description = description;
        this.image = image;
        this.contenu = contenu;
        this.categorieId = categorieId;
    }

    public Article(String titre, String auteur, String description, Date dateCreation, Date dateEdition, String image, Date updatedAt, String contenu, int categorieId) {
        this.dateCreation = dateCreation;
        this.dateEdition = dateEdition;
        this.updatedAt = updatedAt;
        this.titre = titre;
        this.auteur = auteur;
        this.description = description;
        this.image = image;
        this.contenu = contenu;
        this.categorieId = categorieId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateEdition() {
        return dateEdition;
    }

    public void setDateEdition(Date dateEdition) {
        this.dateEdition = dateEdition;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public int getCategorieId() {
        return categorieId;
    }

    public void setCategorieId(int categorieId) {
        this.categorieId = categorieId;
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
        if (!(object instanceof Article)) {
            return false;
        }
        Article other = (Article) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "a";
    }

}
