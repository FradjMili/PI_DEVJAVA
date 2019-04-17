/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.FosUser;
import entities.InfoG;
import static gui.NewFXMain.U2;
import java.io.IOException;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import services.InfoServices;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class Ajout_inforController implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField tele;
    @FXML
    private TextField adrMail;
    @FXML
    private TextField adresse;
    @FXML
    private DatePicker date_nais;

    
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       // System.out.println(U2);
    }    

    @FXML
    private void ajouter_info(ActionEvent event) throws IOException {
        
    LocalDate localDate = date_nais.getValue();
 
    
Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
Date date = Date.from(instant);

String nom1 =nom.getText();
String prenom1 =prenom.getText();
int tele1 =Integer.parseInt(tele.getText());
String adrMail1 =adrMail.getText();
String adr1 =adresse.getText();

 InfoG r =new InfoG(nom1,prenom1,date,tele1,adrMail1,adr1,U2);
       
        InfoServices po =new InfoServices();
       po.ajouter(r);
       
       FXMLLoader loader = new FXMLLoader(getClass().getResource("Ajout_formation.fxml"));
                        Parent root = (Parent) loader.load();
                        Ajout_formationController adm = loader.getController();

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
   
