/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Config.ConnexionDB;
import Entities.Annonce;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class ServiceAnnonce { 
      Connection conn;

    public ServiceAnnonce() {
        conn = ConnexionDB.getInstance().getCon();
    }
    
         public void AjouterAnnonce(Annonce a) {
       
        String query="insert into annonces_posts (iduserA,speciality,description,titre,salaire,etatannonce,datedebut,datefin) values (?,?,?,?,?,?,?,?)";
        PreparedStatement ps;
        try {
            ps = ConnexionDB.getInstance().getCon().prepareStatement(query);
            ps.setInt(1, a.getIduserA());
            ps.setString(2, a.getSpeciality());
            ps.setString(3, a.getDescription());
            ps.setString(4, a.getTitre());
            ps.setInt(5, a.getSalaire());
            ps.setInt(6, a.getEtatannonce());
            ps.setString(7,a.getDatedebut());
            
            ps.setString(8, a.getDatefin());
            
           
        ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ServiceAnnonce.class.getName()).log(Level.SEVERE, null, ex);
        }            
    
    
    }
          public void modifierAnnonce(int iduserA,String speciality,String description,String titre,float salaire,int etatannonce){
         try {
         String update = "UPDATE annonces_posts SET speciality = ? , "
         + "description = ? , titre = ? ,salaire  = ? WHERE id = 38  ";
         PreparedStatement st2 = conn.prepareStatement(update);
         st2.setString(1,speciality);
         st2.setString(2,description);
         st2.setString(3,titre);
         st2.setFloat(4,salaire);
         
         st2.executeUpdate();
         
         System.out.println("Modification demande avec succé");
         
         } catch(SQLException e){
         System.out.println(e.getMessage());
         }
         
         }
       
     public void SupprimerAnnonce(int id)  {
           try{
               
           
        String requete = "DELETE FROM annonces_posts WHERE id = ?";
              PreparedStatement preparedStmt = conn.prepareStatement(requete);
              preparedStmt.setInt(1,id);
              preparedStmt.execute(); 
              System.out.println("Demande supprimé avec sucée");

 
        }
          catch(SQLException e){
            System.out.println(e.getMessage());
        }
       }
    public List<Annonce> listAnnonce() {
        List<Annonce> lm = new ArrayList<>();
        try {
            String select = "SELECT  * FROM annonces_posts where etatannonce = 0 ;";

            Statement statement1 = conn.createStatement();

            ResultSet result = statement1.executeQuery(select);

            while (result.next()) {
                Annonce m = new Annonce();
                m.setIduserA(result.getInt("iduserA"));
                m.setSpeciality(result.getString("speciality"));
                m.setDescription(result.getString("description"));
                m.setTitre(result.getString("titre"));
                m.setSalaire(result.getInt("salaire"));
                m.setEtatannonce(result.getInt("etatannonce"));
                m.setDatedebut(result.getString("datedebut"));
                m.setDatefin(result.getString("datefin"));
                 m.setId(result.getInt("id"));
                

                lm.add(m);

            }
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            System.err.println("SQLSTATE: " + ex.getSQLState());
            System.err.println("VnedorError: " + ex.getErrorCode());
        }
        return lm;
    }
      public void afficherAnnonce(){
        PreparedStatement pt;
        try {
            pt = conn.prepareStatement("select * from annonces_posts");
            ResultSet rs = pt.executeQuery();
            while(rs.next()){
                System.out.println("\niduserA : "+rs.getString(2)
                        +"\nspeciality : "+rs.getString(3)+"\ndescription : "+rs.getString(6)+"\ntitre : "+rs.getString(7));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceAnnonce.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
      
      
      
      public boolean verifDemande(String db,String df,int userid)
      {
        List<Annonce> lm = new ArrayList<>();
        try {
            String select = "SELECT datedebutD,datefinD FROM demande where iduserD="+userid+";";

            Statement statement1 = conn.createStatement();

            ResultSet result = statement1.executeQuery(select);

            while (result.next()) {
                Annonce m = new Annonce();
              
                m.setDatedebut(result.getString("datedebutD"));
                m.setDatefin(result.getString("datefinD"));
                lm.add(m);

            }
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            System.err.println("SQLSTATE: " + ex.getSQLState());
            System.err.println("VnedorError: " + ex.getErrorCode());
        }
                    
        boolean test=true;
        
        for(int k=0 ;k<lm.size();k++){
            try {
                Date date1=new SimpleDateFormat("yyyy/MM/dd").parse(lm.get(k).getDatedebut());
                Date date2=new SimpleDateFormat("yyyy/MM/dd").parse(lm.get(k).getDatefin());
                Date date3=new SimpleDateFormat("yyyy/MM/dd").parse(db);
                Date date4=new SimpleDateFormat("yyyy/MM/dd").parse(df);
                System.out.println(date1);
                System.out.println(date2);
                System.out.println(date3);
                System.out.println(date4);
                System.out.println(date1.after(date3));
                System.out.println(date2.before(date4));
               
                if((date1.before(date3)) && (date2.before(date3)) || (date1.after(date4)) && (date2.after(date4)) ){
                 test= true;
                }
                else
                {
                    
                       return false;
                    
                }
            } catch (ParseException ex) {
                Logger.getLogger(ServiceAnnonce.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
   
       
          
          return test;}
}
