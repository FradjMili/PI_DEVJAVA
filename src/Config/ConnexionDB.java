/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author USER
 */
public class ConnexionDB {
    private String url = "jdbc:mysql://127.0.0.1/pi_dev";
    private String login = "root";
    private  String pwd ="";
    
 //   public static User connectedUser;

     Connection conn;
    
    private static ConnexionDB instance = null;
    
    private ConnexionDB()
    {
        try{
            conn = DriverManager.getConnection(url,login,pwd);
            System.out.println("Connexion établie");
            //System.out.println(userConnected);
        
        }
        catch (SQLException ex)
                {System.out.println("Connexion non établie");
        }
        }
    
    public static ConnexionDB getInstance()
    {
        if (instance==null)
        {instance = new ConnexionDB();}
        return instance;
    }
     public Connection getCon() {
        return conn;
     }
    
}
