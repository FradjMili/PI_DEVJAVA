/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXMLFreelancer;


import Entities.Annonce;
import Service.ServiceAnnonce;
import Template.Template;
import com.sun.prism.impl.Disposer.Record;

import javafx.scene.control.Button;
import java.io.IOException;
import java.net.URL;
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

/**
 * FXML Controller class
 *import template.Template;
 * 
 * @author USER
 */
class ButtonCell_modifier extends TableCell<Record, Boolean> {
        final Button cellButton = new Button("modifier");
        
         ServiceAnnonce service_Ann=new ServiceAnnonce();
        ButtonCell_modifier(){
        
        	//Action when the button is pressed
         cellButton.setOnAction(new EventHandler<ActionEvent>(){

                @Override
                public void handle(ActionEvent t) {
                    try {
                        // get Selected Item
                        Annonce Annoncecourant = (Annonce) ButtonCell_modifier.this.getTableView().getItems().get(ButtonCell_modifier.this.getIndex());
                       
                        
                        
                     Annonce.Annoncecourant= Annoncecourant;
                        System.out.println(Annonce.Annoncecourant);
                        System.out.println(Annoncecourant.getDatedebut());
                        Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/FXMLFreelancer/modifierAnnonce.fxml"))));             
                    } catch (IOException ex) {
                        Logger.getLogger(ButtonCell_modifier.class.getName()).log(Level.SEVERE, null, ex);
                    }

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

  
    }