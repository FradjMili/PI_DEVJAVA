/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Competences;
import static gui.NewFXMain.U2;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import services.CompetenceServices;
import services.InfoServices;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class Ajout_competenceController implements Initializable {

    @FXML
    private TextField competences;
    @FXML
    private TextField certificats;
    @FXML
    private TextField langues;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    
    @FXML
    private void ajouter_competence(ActionEvent event) throws IOException {
        
        
    String comp =competences.getText();
String certif =certificats.getText();
String lan =langues.getText();


Competences c =new Competences(comp,certif,lan,U2);
       
        CompetenceServices po =new CompetenceServices();
       po.ajouter(c);
       
       FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
                        Parent root = (Parent) loader.load();
                        HomeController adm = loader.getController();

                        //hide actual window
                        final Node source = (Node) event.getSource();
                        final Stage stage = (Stage) source.getScene().getWindow();
                        stage.close();

                        //Show next window
                        Scene newScene = new Scene(root);
                        Stage newStage = new Stage();
                        newStage.setScene(newScene);
                        newStage.show();
    
    
    }

    
}
