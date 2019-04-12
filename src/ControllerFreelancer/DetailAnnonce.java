/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerFreelancer;

import Entities.*;

import Service.ServiceAnnonce;
import Service.ServiceDemande;
import com.jfoenix.controls.JFXTextArea;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class DetailAnnonce implements Initializable {

    @FXML
    private JFXTextArea MotivationValue;
    
    @FXML
    private Text TitreValue;
    
    @FXML
    private Text salairevalue;
    
    @FXML
    private Button add;
    @FXML
    private Label descriptionText;
    
        Annonce A = Annonce.Annoncecourant;
        Service.ServiceAnnonce SVA = new ServiceAnnonce();
        
        Service.ServiceDemande SVD = new ServiceDemande();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        //Pane pane=new Pane();
        TitreValue.setText(A.getTitre());
        salairevalue.setText(Integer.toString(A.getSalaire())+"DT");
        descriptionText.setText(A.getDescription());
        descriptionText.setMaxWidth(180);
        descriptionText.setWrapText(true);
       
        
    }    

    @FXML
    private void ajouter(ActionEvent event) {
        if(SVA.verifDemande(A.getDatedebut(),A.getDatefin(),15))
        { Demande d = new Demande();
         d.setIduserA(A.getIduserA());
         d.setIduserD(15);
         d.setMotivation(MotivationValue.getText());
         d.setTitre(A.getTitre());
         d.setEtatd(1);
         d.setDatedebut(A.getDatedebut());
         d.setDatefin(A.getDatefin());
         d.setIda(A.getId());
            SVD.AjouterDemande(d);
            
        }
        
        
        
    }

   
    
}
