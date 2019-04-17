/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Reclamation;
import static gui.NewFXMain.U2;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tools.MyConnection;

/**
 *
 * @author USER
 */
public class ReclamationServices {
    Connection connection=null;
    
    public ReclamationServices() {
        connection=MyConnection.getInstance().getCnx();
    }
    

    
    
    
 public void ajouter(Reclamation r) {
     
     if(r.getId_ban() == 0){
         String req="INSERT INTO `Reclamation`(`statut`, `text`,`claimerId`,`date`) VALUES (?,?,?,?)";
        Timestamp today = new Timestamp(System.currentTimeMillis());
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(req);
            preparedStatement.setString(1, r.getStatut());
            preparedStatement.setString(2, r.getText());
            preparedStatement.setInt(3, r.getFosUser().getId());
            preparedStatement.setTimestamp(4,today);

            preparedStatement.execute();
            
            System.out.println("reclamation ajoutée");
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationServices.class.getName()).log(Level.SEVERE, null, ex);
        }
     }else{
          String req="INSERT INTO `Reclamation`(`statut`, `text`,`claimerId`,`date`,`id_ban`) VALUES (?,?,?,?,?)";
        Timestamp today = new Timestamp(System.currentTimeMillis());
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(req);
            preparedStatement.setString(1, r.getStatut());
            preparedStatement.setString(2, r.getText());
            preparedStatement.setInt(3, r.getFosUser().getId());
            preparedStatement.setTimestamp(4,today);
            preparedStatement.setInt(5,r.getId_ban());

            preparedStatement.execute();
          
            if (this.verif(r.getId_ban()))
            {
                this.supprimerIN(r.getId_ban());
                System.out.println("user supprimer");
            
            }
            System.out.println("reclamation ajoutée");
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationServices.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
        
    }
 
 
 
 
 
 
 
    
 public List<Reclamation> afficherReclamation() {
        List<Reclamation> myList = new ArrayList<>();
        
       
        try {
            String requete = "SELECT * FROM reclamation WHERE claimerId='"+U2.getId()+"'";
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                Reclamation p = new Reclamation();
                p.setId(rs.getInt("id"));
                 p.setDate(rs.getTimestamp(2));
                p.setStatut(rs.getString(3));
                p.setText(rs.getString(4));
                p.setTreated(rs.getBoolean(5));
                p.setClaimerId(rs.getInt(6));
                myList.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return myList;
    } 
    
     public void supprimerIN(int id) throws SQLException {

        Statement st = connection.createStatement();
        String req = "update fos_user set enabled=0 where id=" + id;
        st.executeUpdate(req);
        System.out.println("suppression ok");

    }
   
    
   public boolean verif(int ban) throws SQLException{
       boolean a=false;
       String requete = "SELECT count(DISTINCT claimerId) FROM `reclamation` WHERE id_ban=? and id_ban!=claimerId";
            PreparedStatement st = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
            st.setInt(1, ban);
            ResultSet rs = st.executeQuery();
             while (rs.next()) {
                 if (rs.getInt(1)>2)
                     a=true;
             }
             return a;
             
            
   }
   
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    }
