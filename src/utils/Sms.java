/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class Sms {
    public static void send(){
        
        String api="7C8truYduVE-nrNBnOwu7CeKjuEpZbhCIOEcpF3IAU";
         String mess="Votre demande a été effectué avec succées  ";
         String send="Fraj";
         String num="+21655004732";
         try {      
                        String user = "username=" + "Houssem.dev@gmail.com";
			String apiKey ="&apiKey="+api;
			String message = "&message="+mess;
			String sender = "&sender="+send;
			String numbers = "&numbers=" +num;
			
			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.txtlocal.com/send/?").openConnection();
			String data = user +apiKey + numbers + message + sender;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
                            JOptionPane.showMessageDialog(null,"message"+line);
			}
			rd.close();			
		} catch (Exception e) {
                    JOptionPane.showMessageDialog(null,e);
		}
     

//
//NexmoClient client = new NexmoClient.Builder()
//  .apiKey("640c3afd")
//  .apiSecret("1kj1mOnRmQ5HNKSI")
//  .build();
//
//String messageText = "Hello from Nexmo";
//TextMessage message = new TextMessage("Nexmo", "21650876896", messageText);
//
//SmsSubmissionResponse response = client.getSmsClient().submitMessage(message);
//
//for (SmsSubmissionResponseMessage responseMessage : response.getMessages()) {
//    System.out.println(responseMessage);
//}
//    }
   
}}