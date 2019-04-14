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
class ButtonCell extends TableCell<Record, Boolean> {
        final Button cellButton = new Button("supprimer");
        
         ServiceAnnonce service_Ann=new ServiceAnnonce();
        ButtonCell(){
        
        	//Action when the button is pressed
         cellButton.setOnAction(new EventHandler<ActionEvent>(){

                @Override
                public void handle(ActionEvent t) {
                    try {
                        // get Selected Item
                        Annonce Annoncecourant = (Annonce) ButtonCell.this.getTableView().getItems().get(ButtonCell.this.getIndex());
                        //remove selected item from the table list
                        ObservableList<Annonce> List= FXCollections.observableArrayList();
//                      
                        service_Ann.SupprimerAnnonce(Annoncecourant);
                        System.out.println(List);
                        Annonce.said=2;
                        Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/FXMLFreelancer/TableauAnnonce.fxml"))));             
                    } catch (IOException ex) {
                        Logger.getLogger(ButtonCell.class.getName()).log(Level.SEVERE, null, ex);
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