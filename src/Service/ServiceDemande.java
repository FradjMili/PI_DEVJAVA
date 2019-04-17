/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Config.ConnexionDB;
import Entities.Annonce;

import Entities.Demande;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class ServiceDemande {
    Connection conn;
 
    public ServiceDemande() {
        conn = ConnexionDB.getInstance().getCon();
    }
     public void AjouterDemande(Demande d) {
       
        String query="insert into demande ( ida,   iduserA,  iduserD,  Titre,  etatd , Motivation,datedebutD,datefinD) values (?,?,?,?,?,?,?,?)";
        PreparedStatement ps;
        try {
            ps = ConnexionDB.getInstance().getCon().prepareStatement(query);
            ps.setInt(1, d.getIda());
            ps.setInt(2, d.getIduserA());
            ps.setInt(3, d.getIduserD());
            ps.setString(4, d.getTitre());
            ps.setInt(5, 0);
            ps.setString(6, d.getMotivation());
           
            ps.setString(7, d.getDatedebut());
           
            ps.setString(8, d.getDatefin());
        ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ServiceDemande.class.getName()).log(Level.SEVERE, null, ex);
         }     
}
       public void SupprimerDemande(int id)  {
           try{
               
           
        String requete = "DELETE FROM Demande WHERE id = ?";
              PreparedStatement preparedStmt = conn.prepareStatement(requete);
              preparedStmt.setInt(1,id);
              preparedStmt.execute(); 
              System.out.println("Demande supprimé avec sucée");

 
        }
          catch(SQLException e){
            System.out.println(e.getMessage());
        }
       }
        public void modifierDemande( int ida,  int iduserA, int iduserD, String Titre, int etatd ,String Motivation){
         try {
         String update = "UPDATE Demande SET Titre = ? , "
         + "Motivation = ?  WHERE id = 39  ";
         PreparedStatement st2 = conn.prepareStatement(update);
         st2.setString(1,Titre);
         st2.setString(2,Motivation);
         
         
         st2.executeUpdate();
         
         System.out.println("Modification demande avec succé");
         
         } catch(SQLException e){
         System.out.println(e.getMessage());
         }
         
         }
        
        
        
        
        public void validerDemande(Demande D)
        {try {
         String update = "UPDATE Demande SET etatd = ? WHERE id = ?  ";
         PreparedStatement st2 = conn.prepareStatement(update);
         st2.setInt(1,D.getEtatd());
         st2.setInt(2,D.getId());
         
         
         st2.executeUpdate();
         
         System.out.println("Modification demande avec succé");
         
         } catch(SQLException e){
         System.out.println(e.getMessage());
         }
         
         }
        
          public List<Demande> listDemande() {
        List<Demande> ld = new ArrayList<>();
        try {
            String select = "SELECT  * FROM Demande where etatd = 0 AND iduserA=1;";

            Statement statement1 = conn.createStatement();

            ResultSet result = statement1.executeQuery(select);

            while (result.next()) {
                Demande m = new Demande();
                m.setTitre(result.getString("Titre"));
                m.setMotivation(result.getString("Motivation"));
                m.setDatedebut(result.getString("datedebutD"));
                m.setDatefin(result.getString("datefinD"));
                m.setIda(result.getInt("ida"));
               m.setId(result.getInt("id"));
                ld.add(m);

            }
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            System.err.println("SQLSTATE: " + ex.getSQLState());
            System.err.println("VnedorError: " + ex.getErrorCode());
        }
        return ld;
    }
      
              public List<Demande> malistDemande(int userid) {
        List<Demande> ld = new ArrayList<>();
        try {
            String select = "SELECT  * FROM Demande where iduserD="+userid+";";

            Statement statement1 = conn.createStatement();

            ResultSet result = statement1.executeQuery(select);

            while (result.next()) {
                Demande m = new Demande();
                m.setTitre(result.getString("Titre"));
                m.setMotivation(result.getString("Motivation"));
                m.setDatedebut(result.getString("datedebutD"));
                m.setDatefin(result.getString("datefinD"));
                m.setIda(result.getInt("ida"));
               m.setId(result.getInt("id"));
               
               m.setEtatd(result.getInt("etatd"));
                ld.add(m);

            }
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            System.err.println("SQLSTATE: " + ex.getSQLState());
            System.err.println("VnedorError: " + ex.getErrorCode());
        }
        return ld;
    }
      
          
          public void afficherDemande(){
        PreparedStatement pt;
        try {
            pt = conn.prepareStatement("select * from Demande");
            ResultSet rs = pt.executeQuery();
            while(rs.next()){
                System.out.println("\ntitre : "+rs.getString(5)
                        +"\nMotivation : "+rs.getString(6));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDemande.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
