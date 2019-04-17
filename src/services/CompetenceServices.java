/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Competences;
import entities.InfoG;
import static gui.NewFXMain.U2;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import tools.MyConnection;

/**
 *
 * @author USER
 */
public class CompetenceServices {
    
    Connection connection=null;  
    
    public CompetenceServices() {
        connection=MyConnection.getInstance().getCnx();
    }
    
    public void ajouter(Competences competence) {
        String req="INSERT INTO `competences`(`nom_competence`, `nom_certif`,`langues`,`user_id`) VALUES (?,?,?,?)";
       
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(req);
            preparedStatement.setString(1, competence.getNomCompetence());
            preparedStatement.setString(2, competence.getNomCertif());
           preparedStatement.setString(3, competence.getLangues());
                      preparedStatement.setInt(4,competence.getFosUser().getId());

          

            preparedStatement.execute();
            
            System.out.println("competence ajouté ");
            
        } catch (SQLException ex) {
            
            Logger.getLogger(ReclamationServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
     public Competences afficherComp() throws SQLException{
 
       Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
        String req = "SELECT * FROM competences  WHERE user_id='"+U2.getId()+"'";
        ResultSet rs = st.executeQuery(req);
        Competences co = new Competences();
        
        
        while(rs.next()){
            
            co.setId(rs.getInt("id"));
            
            co.setNomCompetence(rs.getString(2));
            co.setNomCertif(rs.getString(3));
            co.setLangues(rs.getString(4));
           
            
           
        }
        return co;
        
    }       
}
