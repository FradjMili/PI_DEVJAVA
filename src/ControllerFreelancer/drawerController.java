/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerFreelancer;

import Template.Template;
import com.jfoenix.controls.JFXButton;
import Entities.Annonce;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;


/**
 * FXML Controller class
 *
 * @author said
 */
public class drawerController implements Initializable {

    @FXML
    private AnchorPane box;
    @FXML
    private ImageView imgUser;
    @FXML
    private Label labelUser;
    @FXML
    private JFXButton acceuil;
    @FXML
    private JFXButton listAnnonce;
    @FXML
    private JFXButton categorie;
    @FXML
    private JFXButton panier;
    @FXML
    private JFXButton profile;
    @FXML
    private JFXButton deconnexion;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
 
    }    

    @FXML
    private void makeAccueil(ActionEvent event) throws IOException {
        Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/FXMLFreelancer/AnnoncesFXML.fxml"))));             

    }


    @FXML
    private void makeCompte(ActionEvent event) {
    }

    @FXML
    private void makeDisconnect(ActionEvent event) {
    }

    @FXML
    private void listannonces(ActionEvent event) throws IOException {
        Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/FXMLFreelancer/AnnoncesFXML.fxml"))));         
   
    }


    @FXML
    private void mesdemandes(ActionEvent event) throws IOException {
    
        Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/FXMLFreelancer/Mesdemandes.fxml"))));  
    }



    
    @FXML
    private void logoutp(MouseEvent event) throws IOException {
                  
     //drapodashbord.Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/GUI/login_1.fxml"))));

    }
    
}
