
package services;


import entities.FosUser;
import iservices.IUserServices;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import tools.MyConnection;

public class UserServices implements IUserServices {
    
 Connection connection=null;
 
 
 public UserServices() {
        connection=MyConnection.getInstance().getCnx();
    }
 
 
 
  public ArrayList<FosUser> afficherUtilisateur() {
        
        String req = "select * from fos_user where enabled=1 ";
        ArrayList<FosUser> utilisateurs = new ArrayList<>();
                
        
        try {
            Statement ste = connection.createStatement();
            ResultSet res=  ste.executeQuery(req);
            
            while (res.next()) {
            FosUser p = new FosUser(
                   res.getInt("id"),
                    res.getString("username"),
                    
                    res.getString("email"),
                   res.getString("password"),
                    res.getString("roles")

                );
            utilisateurs.add(p);
              
            }   
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return utilisateurs;
    }
   
   public int recupererIdUser(FosUser p)
    {
        
        UserServices cu = new  UserServices();
        ArrayList<FosUser> utilisateurs = new ArrayList<>();
        utilisateurs = cu.afficherUtilisateur();
        int id =-1;
        
        for(int i=0; i<utilisateurs.size(); i++)
        {
            if(utilisateurs.get(i).getEmail().equalsIgnoreCase(p.getEmail()))
            {
                id = utilisateurs.get(i).getId();
                break;
            }
        }
        return id;  
    }
  
  
}
