/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Reclamation;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import services.ReclamationServices;

public class AfficherRecController implements Initializable {

   @FXML
    private TableView<Reclamation> reclamationTable;
    
    @FXML
    private TableColumn<Reclamation, String> statut;
    @FXML
    private TableColumn<Reclamation, String> contenu;
    
    
   @Override
    public void initialize(URL url, ResourceBundle rb) {
       
       ReclamationServices crud = new ReclamationServices();     
ArrayList arraylist = (ArrayList)crud.afficherReclamation();
ObservableList observableList = FXCollections.observableArrayList(arraylist);
reclamationTable.setItems(observableList);
statut.setCellValueFactory(new PropertyValueFactory<>("statut"));
contenu.setCellValueFactory(new PropertyValueFactory<>("text"));

//affichage
      //  reclamationTable.setItems((ObservableList<Reclamation>) crud.afficherReclamation());
    }    
    
   /* public void initColumns() { //affichage
        StatutColumn.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("titre")); //titre l'attribut dans l'éentité
        ContenuColumn.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("description"));
       
        //type_TableColumn.setCellValueFactory(new PropertyValueFactory<Ar, String>("type"));
        //location_TableColumn.setCellValueFactory(new PropertyValueFactory<Partner, String>("location"));
    }*/

    
}
