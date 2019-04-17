/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;


import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author USER
 */

public class Reclamation {

   
    private Integer id;
    
    private Timestamp date;
    
    private String statut;
   
    private String text;
   
    private Boolean treated;
    
    private int claimerId;
   
    private FosUser fosUser;
    
    private int id_ban;

    public int getId_ban() {
        return id_ban;
    }

    public void setId_ban(int id_ban) {
        this.id_ban = id_ban;
    }

    public Reclamation() {
    }

    public Reclamation(Integer id) {
        this.id = id;
    }

    public Reclamation(String statut, String text, int claimerId) {
        
       
        this.statut = statut;
        this.text = text;
        this.claimerId = claimerId;
    }
    
    public Reclamation(String statut, String text, FosUser fosUser ) {
        
       
        this.statut = statut;
        this.text = text;
           this.fosUser=fosUser;
           this.id_ban=0;
    }
    
    public Reclamation(String statut, String text, FosUser fosUser,int id_ban ) {
        
       
        this.statut = statut;
        this.text = text;
           this.fosUser=fosUser;
           this.id_ban = id_ban;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getTreated() {
        return treated;
    }

    public void setTreated(Boolean treated) {
        this.treated = treated;
    }

    public int getClaimerId() {
        return claimerId;
    }

    public void setClaimerId(int claimerId) {
        this.claimerId = claimerId;
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
        if (!(object instanceof Reclamation)) {
            return false;
        }
        Reclamation other = (Reclamation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "id=" + id + ", date=" + date + ", statut=" + statut + ", text=" + text + ", treated=" + treated + ", claimerId=" + claimerId + ", fosUser=" + fosUser + '}';
    }

 
}
