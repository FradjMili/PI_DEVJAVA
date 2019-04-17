/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.sun.org.apache.xpath.internal.FoundIndex;
import entities.FosUser;
import entities.Reclamation;
import static gui.NewFXMain.U2;

import javafx.event.ActionEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import services.ReclamationServices;
import tools.MyConnection;

public class Ajout_reclamationController implements Initializable {

    Connection connection=MyConnection.getInstance().getCnx();
    @FXML
    private ComboBox<String> statut;
     
    ObservableList<String>list = FXCollections.observableArrayList("bug","services","other");
    @FXML
    private TextField text;
    @FXML
    private ChoiceBox <FosUser>liste;
   
    
     ObservableList<FosUser> listacombo= FXCollections.observableArrayList();
    @FXML
    private AnchorPane tile;
     
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       statut.setItems(list);
       liste.setVisible(false);
          }    
    
 @FXML
 private void ajouterRec(ActionEvent event) throws IOException {
     
     Reclamation r;
     if (statut.getValue().equals("other")){
         r =new Reclamation (statut.getValue().toString(),text.getText(),U2,liste.getValue().getId() );
     }else{
         r =new Reclamation (statut.getValue().toString(),text.getText(),U2 );
     }
        //Reclamation r =new Reclamation (statut.getValue().toString(),text.getText(),U2 );
        ReclamationServices reclamationService=new ReclamationServices();
        reclamationService.ajouter(r);
 }
 
 
 
 
    @FXML
  private void combolist(ActionEvent event) throws SQLException{
      if (statut.getValue().equals("other")){
          
      liste.setVisible(true);
      
     //String name = "user";
     
     
          String consulta = "select id,username from fos_user where roles=? " ;
          
          PreparedStatement ps = connection.prepareStatement(consulta);
          
        
          ps.setString(1, "user");
          
           ResultSet rs = ps.executeQuery();
            while ( rs.next() ) 
             {  
                 FosUser u = new FosUser();
                 u.setId(rs.getInt(1));
                 u.setUsername(rs.getString(2));
               listacombo.add(u);
                 liste.setItems(listacombo);
               
             }
             
  }else if(statut.getValue().equals("bug") || statut.getValue().equals("service")){
          liste.setVisible(false);
          
      }
  }
    
    
    
}
