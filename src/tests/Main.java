
package tests;

import entities.FosUser;
import entities.InfoG;
import entities.Reclamation;
import java.sql.SQLException;
import java.util.Date;
import services.InfoServices;
import services.ReclamationServices;
import tools.MyConnection;

public class Main {
    
     public static FosUser U2 = new FosUser();
    
    public static void main(String[] args) throws SQLException {
        MyConnection mc =  MyConnection.getInstance();
       
        
        //Reclamation rec = new Reclamation("bug","hhh",2);
        
        
        ReclamationServices recc = new ReclamationServices();
         
       // recc.ajouter(rec);
     //  System.out.println(recc.afficherPersonne());
    
       Date D= new Date ("1997/02/16");
        InfoG info = new InfoG("ii", "kjkj", D, 5157, ",kk", "ekfkce");
         InfoServices po =new InfoServices();
       po.ajouter(info);
    }
}
