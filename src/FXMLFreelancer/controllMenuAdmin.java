/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXMLFreelancer;

import animation.FadeInLeftTransition;
import entities.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import util.Authentification;
import Template.Template;
/**
 * FXML Controller class
 *
 * @author user
 */
public class controllMenuAdmin implements Initializable {
    @FXML
    private ImageView LBimguser;
    @FXML
    private Label lblClose;
    @FXML
    private Button LBusers;
    @FXML
    private Button LBstatistique;
    private Button LBreclamation;
    @FXML
    private Button LBadvertising;
    @FXML
    private Button Lforum;
    @FXML
    private Text lblWelcome11;
    @FXML
    private Text lblWelcome111;
    @FXML
    private Text lblWelcome112;
    @FXML
    private Text lblWelcome113;
    @FXML
    private Label lbTitre;
    @FXML
    private Label AhmedLabel;
      private final User currentUser=Authentification.user;
    @FXML
    private Text lblWelcome12;
    @FXML
    private Button LBadvertising1;
    @FXML
    private Text lblWelcome1131;
    @FXML
    private Button LBBoutique;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       new FadeInLeftTransition(LBusers).play();
       new FadeInLeftTransition(LBBoutique).play();
       new FadeInLeftTransition(LBadvertising).play();
       new FadeInLeftTransition(AhmedLabel).play();
       new FadeInLeftTransition(lbTitre).play();
       new FadeInLeftTransition(LBimguser).play();
       new FadeInLeftTransition(Lforum).play();
           AhmedLabel.setText("aaaaaaaaaaa");
        lblClose.setOnMouseClicked((MouseEvent event) -> {
            Platform.exit();
                System.exit(0);
            });
    }    

    @FXML
    private void ButtonForumAction(MouseEvent event) throws IOException {
                       
        
        Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/FXMLFreelancer/MenuClient.fxml"))));
                       
//        Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/FXMLFreelancer/MenuClient.fxml"))));
                       
                                              //Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/GUI/MenuDemande.fxml"))));
                                                      
                                                      }   
        
    
    
    
    
    private void ButtonUserAction(MouseEvent event) throws IOException {
        Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/FXMLArticle/ArticleList.fxml"))));
    }
  

    private void ButtonReclamationAction(MouseEvent event) throws IOException {
        Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("FXMLFreelancer/MenuClient.fxml"))));
    }

    @FXML
    private void ButtonPubAction(MouseEvent event) throws IOException {
       Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/FXMLArticle/ArticleList.fxml"))));
        System.out.println("EVENEMENT...........................");
        ///////
    }

    @FXML
    private void ToMenuDonation(MouseEvent event) throws IOException {
        //MyMenuDoFXML
                      Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("FXMLFreelancer/MenuClient.fxml"))));

        System.out.println("jjjjjjjjjjjj");
    }

    @FXML
    private void forum(MouseEvent event) throws IOException {
        
                              Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/GUI/Forum.fxml"))));

    }

    @FXML
    private void gotoshop(MouseEvent event) throws IOException {
    /* if (currentUser.getRoles().equals("a:1:{i:0;s:12:\"ROLE_VENDEUR\";}"))
        {   
       
                               Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/views/fournisseur.fxml"))));
 }
        else {
                                       Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/views/produitsFXML.fxml"))));

        }*/
    }

    @FXML
    private void admin(MouseEvent event) throws IOException {
        Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/GUI/interfaceghadaFXML.fxml"))));
    }
        
    
    }


    

