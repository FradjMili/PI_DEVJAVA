/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXMLFreelancer;


import Entities.Annonce;
import Entities.Demande;
import Service.*;
import Template.Template;
import com.sun.prism.impl.Disposer.Record;

import javafx.scene.control.Button;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;





import java.util.Properties;  
import javax.mail.*;  
import javax.mail.internet.*;  
import org.controlsfx.control.Notifications;
  

/**
 * FXML Controller class
 *import template.Template;
 * 
 * @author USER
 */

class ButtonCell_valider_demande extends TableCell<Record, Boolean> {
        final Button cellButton = new Button("Valider");
   private String username = "allforkidssite08@gmail.com";
    private String password = "allforkidsghada";
   
         ServiceDemande service_Dem=new ServiceDemande();
         
         ServiceAnnonce service_Ann=new ServiceAnnonce();
        ButtonCell_valider_demande(){
        
        	//Action when the button is pressed
         cellButton.setOnAction(new EventHandler<ActionEvent>(){

                @Override
                public void handle(ActionEvent t) {
                    // get Selected Item
                    Demande Demandecourant = (Demande) ButtonCell_valider_demande.this.getTableView().getItems().get(ButtonCell_valider_demande.this.getIndex());
                    // remove selected item from the table list
                    ObservableList<Annonce> List= FXCollections.observableArrayList();
                    // 
                    
                    //mail
        
              

                    //mail
                    service_Ann.validerannonce(Demandecourant.getIda());
                    Demandecourant.setEtatd(1);
                    service_Dem.validerDemande(Demandecourant);
                    System.out.println(List);
              
                    
                     envoyer(Demandecourant.getDatefin());     
       
                    
                    
                    try {
 MenuClientController.page=1;
                        Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/FXMLFreelancer/MenuClient.fxml"))));
            
                    
                    
                    
                    
                    
                    
                    
                    } catch (IOException ex) {
                        Logger.getLogger(ButtonCell_valider_demande.class.getName()).log(Level.SEVERE, null, ex);
                    }
      Notifications n =Notifications.create().title("Notification")
             .text("Message envoyé avec succés")
             .graphic(null)
             .position(Pos.CENTER)
             .onAction(new  EventHandler<ActionEvent>() {
             
             public void handle (ActionEvent event){
                 System.out.println("notification");
             }
             });
     n.showConfirm();
     
                }
                      });
        }
        

        //Display button if the row is not empty
        @Override
        protected void updateItem(Boolean t, boolean empty) {
            super.updateItem(t, empty);
            if(!empty){
               // setGraphic(cellButton2);
                setGraphic(cellButton);
            }
        }

    
    public  void envoyer(String datef)
    {
     
  String host="smtp.gmail.com";  
  final String user="byounesfiras@gmail.com";//change accordingly  
  final String password="pinisulaa";//change accordingly  
    
  String to="mili.fradj@gmail.com";//change accordingly  
  
   //Get the session object  
   Properties props = new Properties();  
   props.put("mail.smtp.host",host);  
   props.put("mail.smtp.auth", "true"); 
   props.put("mail.smtp.starttls.enable", "true");
     
   Session session = Session.getDefaultInstance(props,  
    new javax.mail.Authenticator() {  
      protected PasswordAuthentication getPasswordAuthentication() {  
    return new PasswordAuthentication(user,password);  
      }  
    });  
  
   //Compose the message  
    try {  
     MimeMessage message = new MimeMessage(session);  
     message.setFrom(new InternetAddress(user));  
     message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
     message.setSubject("Annonce validée");  
     message.setText("Cette annonce a été effectué avec succees pour vous , on éspere que vous respectez la date fin: "+datef);  
       
    //send the message  
     Transport.send(message);  
  
     System.out.println("message sent successfully...");  
   
     } catch (MessagingException e) {e.printStackTrace();}  
 }  
    
    }