/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Experiences;
import static gui.NewFXMain.U2;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tools.MyConnection;

/**
 *
 * @author USER
 */
public class ExperienceServices {
    Connection connection=null;  
    
    public ExperienceServices() {
        connection=MyConnection.getInstance().getCnx();
    }
    
    public void ajouter(Experiences experience) {
        String req="INSERT INTO `experiences`(`titre`, `date_debut`,`date_fin`,`description`,`user_id`) VALUES (?,?,?,?,?)";
       
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(req);
            
                preparedStatement.setString(1, experience.getTitre());
            preparedStatement.setDate(2,new java.sql.Date(experience.getDateDebut().getTime()) );
             preparedStatement.setDate(3,new java.sql.Date(experience.getDateFin().getTime()) );
          
           preparedStatement.setString(4, experience.getDescription());

            preparedStatement.setInt(5,experience.getFosUser().getId());
            preparedStatement.execute();
            
            System.out.println("experience ajouté ");
            
        } catch (SQLException ex) {
            
            Logger.getLogger(FormationServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
      
    public ObservableList<Experiences> afficherExperiences() {
      ObservableList<Experiences> myList = FXCollections.observableArrayList();
        
       
        try {
            String requete = "SELECT * FROM experiences WHERE user_id='"+U2.getId()+"'";
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                Experiences p = new Experiences();
                
                p.setId(rs.getInt("id"));
                p.setTitre(rs.getString(2));
              p.setDateDebut(rs.getDate(3));
              p.setDateFin(rs.getDate(4));
                
                p.setDescription(rs.getString(5));
                
                myList.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return myList;
    } 
    
    
    
    public void supprimerEX(int id) throws SQLException {
        
        
            Statement st = connection.createStatement();
            String req = "delete from experiences where id=" + id;
            st.executeUpdate(req);
            System.out.println("suppression ok");
        

    }
}
