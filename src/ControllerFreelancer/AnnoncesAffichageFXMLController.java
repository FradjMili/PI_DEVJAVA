/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerFreelancer;

import Template.Template;
import Entities.Annonce;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;
import Service.ServiceAnnonce;


/**
 * FXML Controller class
 *
 * @author ASUS
 */


public class AnnoncesAffichageFXMLController implements Initializable {
   
   
    private boolean Verif;
    public static int nombreproduits=0;
   
     ServiceAnnonce service_pr=new ServiceAnnonce();
     Annonce p = new Annonce();
    @FXML
    private JFXListView<Pane> ListView_Produits ;
 
    @FXML
    private JFXDrawer drawer2;
    @FXML
    private JFXHamburger hamburger;
    @FXML
    private TextField rechercher;
    
    public String recherche="";
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
       
        try {
            AnchorPane box = FXMLLoader.load(getClass().getResource("/FXMLFreelancer/drawer.fxml"));
            drawer2.open();
            drawer2.setSidePane(box);
            
            HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(hamburger);
            transition.setRate(1);
            hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
                transition.setRate(transition.getRate() * 1);
                transition.play();
                
                if (drawer2.isShown()) {
                    drawer2.close();
                }
                else
                {
                    drawer2.open();
                }
                
            });
            
            ListView_Produits.setFocusTraversable( false );
            
            //affichage
            getShowPane();
        } catch (IOException ex) {
            Logger.getLogger(AnnoncesAffichageFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
         
         
      
       }
    

    public void getShowPane()
    {
        List <Annonce> AllProducts  = new ArrayList();
       if(recherche.equals("")){
            for (Annonce p:service_pr.listAnnonce())
        {
            AllProducts.add(p);
        }}
       else{
         for (Annonce p:service_pr.listAnnonceRecherche(recherche))
        {
            AllProducts.add(p);
        }
       
       }
              System.out.println(AllProducts); 
        int i=0;
        int j=0;
        ObservableList<Pane> Panes = FXCollections.observableArrayList();  

        List <Annonce> ThreeProducts= new ArrayList();
        for (Annonce p:AllProducts )
        {
            if(i==0)
            {
                ThreeProducts.add(p);
                i++;
                j++;
            
                   if(j==AllProducts.size())
                {
                    Panes.add(AddPane(ThreeProducts));
                
                    ThreeProducts.clear();
                }
            
            
            }
            else
            {
                ThreeProducts.add(p);
                    i++;
                    j++;
                if((i%3==0)||(j==AllProducts.size()))
                {
                    Panes.add(AddPane(ThreeProducts));
                
                    ThreeProducts.clear();
                    
                }
            }
        }
       
         ObservableList<Pane> refresh = FXCollections.observableArrayList();  
       ListView_Produits.setItems(refresh);
       ListView_Produits.setItems(Panes);
}
    public Pane AddPane( List<Annonce> ThreeProduct)
    {
        Pane pane = new Pane();
        pane.setStyle(" -fx-background-color: white");
                    int k =1;
                    for (Annonce p3:ThreeProduct )
                        {
                         if(k == 1)
                            {
                                Pane pane2=new Pane();
                                pane2.setLayoutX(25);
                                pane2.setLayoutY(50);
                                pane2.setPrefWidth(pane2.getWidth() + 215); 
                                pane2.setPrefHeight(pane2.getHeight() + 200);
                                
                                //pane2.setStyle("-fx-background-radius: 50;");
        pane2.setStyle(" -fx-border-radius: 10;-fx-border-color: #383d3b ;-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 8, 0, 0, 0); ");
                         
                        JFXButton t1=new JFXButton("Postuler");    
                        
                        t1.setStyle("-fx-font-weight: bold;");
                        
                      
                        HBox hb2=new HBox(t1);
                        
                        
                              
                                hb2.setLayoutX(155);
                                hb2.setLayoutY(170);
                              
                                hb2.setStyle("-fx-background-color: #ea7066; ; -fx-background-radius: 10 10 10 10;");
                                pane2.getChildren().addAll(hb2);
                                
                                
                                Text nomt=new Text("Titre : ");
                                Label nom = new Label(p3.getTitre());
                                Text prixt=new Text("Salaire : ");
                                Label prix = new Label(String.valueOf(p3.getSalaire())+" DT");
                                nomt.setLayoutX(50);
                                nomt.setLayoutY(160);
                                nom.setLayoutX(100);
                                nom.setLayoutY(145);
                                prixt.setLayoutX(50);
                                prixt.setLayoutY(180);
                                prix.setLayoutX(100);
                                prix.setLayoutY(165);
                                nomt.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
                                prixt.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
                              
                            t1.setOnMouseClicked((MouseEvent event) -> {
                           //courant   
                             Annonce.Annoncecourant=p3;
                                    try {
                                        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/FXMLFreelancer/DetailAnnonce.fxml")));
                                        
                                        Stage stage = new Stage();
                                        stage.setScene(scene);
                                        stage.show();               } catch (IOException ex) {
                                        Logger.getLogger(AnnoncesAffichageFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                
                                
                            });                         
                        pane.getChildren().addAll(pane2,nomt,prixt,nom,prix);
                            }
           ///////////////////////////////////              
           ///////////////////////////////////              
           ///////////////////////////////////              
           ///////////////////////////////////              
           ///////////////////////////////////              
                            if(k == 2)
                            {
                               Pane pane2=new Pane();
                                pane2.setLayoutX(300);
                                pane2.setLayoutY(50);
                                pane2.setPrefWidth(pane2.getWidth() + 215); 
                                pane2.setPrefHeight(pane2.getHeight() + 200);
                                //pane2.setStyle("-fx-background-radius: 50;");
        pane2.setStyle(" -fx-border-radius: 10 ;-fx-border-color: #383d3b ;-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 8, 0, 0, 0); ");
                            
                   
                        JFXButton t1=new JFXButton("Postuler");    
                       
                        t1.setStyle("-fx-font-weight: bold;");
                        
                        HBox hb2=new HBox(t1);
                        
                        
                              
                                hb2.setLayoutX(155);
                                hb2.setLayoutY(170);
                               
                                hb2.setStyle("-fx-background-color: #ea7066; ; -fx-background-radius: 10 10 10 10;");
                                pane2.getChildren().addAll(hb2);
                                Text nomt=new Text("Titre : ");
                                Label nom = new Label(p3.getTitre());
                                Text prixt=new Text("Salaire : ");
                                Label prix = new Label(String.valueOf(p3.getSalaire())+" DT");
                                nomt.setLayoutX(325);
                                nomt.setLayoutY(160);
                                nom.setLayoutX(375);
                                nom.setLayoutY(145);
                                prixt.setLayoutX(325);
                                prixt.setLayoutY(180);
                                prix.setLayoutX(375);
                                prix.setLayoutY(165);
                                nomt.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
                                prixt.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
                            t1.setOnMouseClicked((MouseEvent event) -> { 
                                 
                                 //courant   
                             Annonce.Annoncecourant=p3;
                                    try {
                                        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/FXMLFreelancer/DetailAnnonce.fxml")));
                                        
                                        Stage stage = new Stage();
                                        stage.setScene(scene);
                                        stage.show();               } catch (IOException ex) {
                                        Logger.getLogger(AnnoncesAffichageFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                
                            
                                
                                
                                
                                });
                          
                        pane.getChildren().addAll(pane2,nomt,prixt,nom,prix);                    
                            }
                            
                            if(k == 3)
                                {
                                   Pane pane2=new Pane();
                                pane2.setLayoutX(575);
                                pane2.setLayoutY(50);
                                pane2.setPrefWidth(pane2.getWidth() + 215); 
                                pane2.setPrefHeight(pane2.getHeight() + 200);
                                //pane2.setStyle("-fx-background-radius: 50;");
        pane2.setStyle(" -fx-border-radius: 10;-fx-border-color: #383d3b ;-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 8, 0, 0, 0); ");
                            
                      
                        JFXButton t1=new JFXButton("Postuler");    
                      
                        t1.setStyle("-fx-font-weight: bold;");
                     
                        HBox hb2=new HBox(t1);
                        
                        
                                hb2.setLayoutX(130);
                                hb2.setLayoutY(170);
                              
                                hb2.setStyle("-fx-background-color: #ea7066; ; -fx-background-radius: 10 10 10 10;");
                                pane2.getChildren().addAll(hb2);
                                
                                Text nomt=new Text("Titre : ");
                                Label nom = new Label(p3.getTitre());
                                Text prixt=new Text("Salaire : ");
                                Label prix = new Label(String.valueOf(p3.getSalaire())+" DT");
                                nomt.setLayoutX(600);
                                nomt.setLayoutY(160);
                                nom.setLayoutX(650);
                                nom.setLayoutY(145);
                                prixt.setLayoutX(600);
                                prixt.setLayoutY(180);
                                prix.setLayoutX(650);
                                prix.setLayoutY(165);
                                nomt.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
                                prixt.setStyle("-fx-font-weight: bold;-fx-fill : #ce3b67");
                            t1.setOnMouseClicked((MouseEvent event) -> { 
                                 //courant   
                             Annonce.Annoncecourant=p3;
                                    try {
                                        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/FXMLFreelancer/DetailAnnonce.fxml")));
                                        
                                        Stage stage = new Stage();
                                        stage.setScene(scene);
                                        stage.show();               } catch (IOException ex) {
                                        Logger.getLogger(AnnoncesAffichageFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                
                                  
                                });
   
                        pane.getChildren().addAll(pane2,nomt,prixt,nom,prix);
                                    
                                }
                            k++;
                            
                            }
                    return pane;
    }

   @FXML
    private void search(KeyEvent event) {
        
        recherche=rechercher.getText();
        getShowPane();
        
    }
} 