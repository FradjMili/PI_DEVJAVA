
package services;

import entities.Formations;
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
import tools.MyConnection;

public class FormationServices {
    
  
   Connection connection=null;  
    
    public FormationServices() {
        connection=MyConnection.getInstance().getCnx();
    }
    
    public void ajouter(Formations formation) {
        String req="INSERT INTO `formations`(`titre`, `date_debut`,`date_fin`,`description`,`user_id`) VALUES (?,?,?,?,?)";
       
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(req);
            
                preparedStatement.setString(1, formation.getTitre());
            preparedStatement.setDate(2,new java.sql.Date(formation.getDateDebut().getTime()) );
             preparedStatement.setDate(3,new java.sql.Date(formation.getDateFin().getTime()) );
          
           preparedStatement.setString(4, formation.getDescription());
           preparedStatement.setInt(5,formation.getFosUser().getId());

            preparedStatement.execute();
            
            System.out.println("formation ajouté ");
            
        } catch (SQLException ex) {
            
            Logger.getLogger(FormationServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    
    
    public List<Formations> afficherFormations() {
        List<Formations> myList = new ArrayList<>();
        
       
        try {
            String requete = "SELECT * FROM formations WHERE user_id='"+U2.getId()+"'";
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                Formations p = new Formations();
                
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
   
   
    public void supprimerFO(int idPartner) throws SQLException {
        
        
            Statement st = connection.createStatement();
            String req = "delete from formations where id=" + idPartner;
            st.executeUpdate(req);
            System.out.println("suppression ok");
        

    }
    
    
   
}
