/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi_devjava;

import Entities.Annonce;
import Entities.Demande;
import Service.ServiceAnnonce;
import Service.ServiceDemande;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.sql.Date;
import java.util.List;
import java.util.Locale;



import java.util.Properties;  
import javax.mail.*;  
import javax.mail.internet.*;  
  

/**
 *
 * @author USER
 */
public class PI_DEVJAVA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
     envoyer();


    
    }
    
    public static void envoyer()
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
     message.setText("Cette annonce a été effectué avec succees pour vous , on éspere que vous respectez la date fin");  
       
    //send the message  
     Transport.send(message);  
  
     System.out.println("message sent successfully...");  
   
     } catch (MessagingException e) {e.printStackTrace();}  
 }  
    
    
    
}