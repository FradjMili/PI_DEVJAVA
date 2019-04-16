/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
/**
 *
 * @author hp
 */
public class MyConnection {
    
    private static  String url="jdbc:mysql://127.0.1:3306/pi_dev";
    private static  String user="root"; 
    private  static String pwd=""; 
    
    
    
    private Connection conn; 
    
    static MyConnection inst; 

     
    
    private  MyConnection() { 
        try {
            conn = DriverManager.getConnection(url,user,pwd); 
            System.out.println("connexion etablie");
            } catch (SQLException ex) {
            Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
      
            }

    public Connection getConn() {
        return conn;
    }   
     
      public static MyConnection getInstance() //application de singleton 
    {
     if(inst==null) 
     { 
      inst= new MyConnection();  
     
     } 
     return inst; 
    } 
    
}
