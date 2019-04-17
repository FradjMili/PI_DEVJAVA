package gui;

import entities.Competences;
import entities.Experiences;
import entities.Formations;
import entities.InfoG;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import services.CompetenceServices;
import services.ExperienceServices;
import services.FormationServices;
import services.InfoServices;


public class AffichageCVController implements Initializable {

    @FXML
    private Tab info;
    @FXML
    private Tab forma;
    @FXML
    private Tab ex;
    @FXML
    private Tab comp;
    @FXML
    private TableColumn<Formations, String> titre;
    @FXML
    private TableColumn<Formations, Date> date_debut;
    @FXML
    private TableColumn<Formations, Date> date_fin;
    @FXML
    private TableColumn<Formations, String> description;
    
    
    @FXML
    private TableColumn<Experiences,String > titre1;
    @FXML
    private TableColumn<Experiences, Date> date_debut1;
    @FXML
    private TableColumn<Experiences, Date> date_fin1;
    @FXML
    private TableColumn<Experiences, String> description1;
    @FXML
    private Text phone;
    @FXML
    private Text adresse;
    @FXML
    private Text mail;
    @FXML
    private Text prenom;
    @FXML
    private Text dateN;
    @FXML
    private Text nom;
    @FXML
    private TableView<Formations> formationTable;
    @FXML
    private TableView<Experiences> experienceTable;
    @FXML
    private Text nom1;
    @FXML
    private Text dateN1;
    @FXML
    private Text prenom1;
    @FXML
    private Button modif1;
    @FXML
    private Button modif2;
    @FXML
    private Button modif3;
    @FXML
    private Button modif4;
    @FXML
    private Text competence;
    @FXML
    private Text certificat;
    @FXML
    private Text langue;
    @FXML
    private Button suppFor;
    @FXML
    private Button suppEx;
    
private FormationServices crudd;
private ExperienceServices cruddd;
private InfoServices crudddd;
private CompetenceServices cruddddd;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       crudd = new FormationServices();
       cruddd = new ExperienceServices();
       crudddd = new InfoServices();
       cruddddd = new CompetenceServices();
       
     // suppFor.setDisable(true);
       // suppEx.setDisable(true);
        
 ExperienceServices crud1 = new ExperienceServices();     
ObservableList arraylist1 = (ObservableList)crud1.afficherExperiences();
ObservableList observableList1 = FXCollections.observableArrayList(arraylist1);
experienceTable.setItems(observableList1);

titre1.setCellValueFactory(new PropertyValueFactory<>("titre"));
date_debut1.setCellValueFactory(new PropertyValueFactory<>("dateDebut"));
date_fin1.setCellValueFactory(new PropertyValueFactory<>("dateFin"));
description1.setCellValueFactory(new PropertyValueFactory<>("description"));


        
 FormationServices crud = new FormationServices();     
ObservableList arraylist = (ObservableList)crud.afficherFormations();
ObservableList observableList = FXCollections.observableArrayList(arraylist);
formationTable.setItems(observableList);

titre.setCellValueFactory(new PropertyValueFactory<>("titre"));
date_debut.setCellValueFactory(new PropertyValueFactory<>("dateDebut"));
date_fin.setCellValueFactory(new PropertyValueFactory<>("dateFin"));
description.setCellValueFactory(new PropertyValueFactory<>("description"));


 InfoServices crud2 = new InfoServices();
InfoG g = new InfoG();
        try {
            g=crud2.afficherInfog();
           // System.out.println(g);
            nom.setText(g.getNom());
            prenom.setText(g.getPrenom());
           dateN.setText(String.valueOf(g.getDateNais().getYear())+"-"+String.valueOf(g.getDateNais().getMonth())+"-"+String.valueOf(g.getDateNais().getDate()));
          phone.setText(String.valueOf(g.getTele()));
            adresse.setText(g.getAdresse());
            mail.setText(g.getAdrMail());
            
        } catch (SQLException ex) {
            Logger.getLogger(AffichageCVController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        
        
        
        
 CompetenceServices crud3 = new CompetenceServices();
Competences co = new Competences();
        try {
            co=crud3.afficherComp();
        
            competence.setText(co.getNomCompetence());
           certificat.setText(co.getNomCertif());
            langue.setText(co.getLangues());
         
            
        } catch (SQLException ex) {
            Logger.getLogger(AffichageCVController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }  
    

    @FXML
    private void modifierInfo(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifI.fxml"));
                        Parent root = (Parent) loader.load();
                        ModifIController adm = loader.getController();

                        //hide actual window
                        final Node source = (Node) event.getSource();
                        final Stage stage = (Stage) source.getScene().getWindow();
                       // stage.close();

                        //Show next window
                        Scene newScene = new Scene(root);
                        Stage newStage = new Stage();
                        newStage.setScene(newScene);
                        newStage.show();
    }
    
    
    

    @FXML
    private void modifierF(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifF.fxml"));
                        Parent root = (Parent) loader.load();
                        ModifIController adm = loader.getController();

                        //hide actual window
                        final Node source = (Node) event.getSource();
                        final Stage stage = (Stage) source.getScene().getWindow();
                       // stage.close();

                        //Show next window
                        Scene newScene = new Scene(root);
                        Stage newStage = new Stage();
                        newStage.setScene(newScene);
                        newStage.show();
    }

    
    @FXML
    private void modifierE(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifE.fxml"));
                        Parent root = (Parent) loader.load();
                        ModifIController adm = loader.getController();

                        //hide actual window
                        final Node source = (Node) event.getSource();
                        final Stage stage = (Stage) source.getScene().getWindow();
                       // stage.close();

                        //Show next window
                        Scene newScene = new Scene(root);
                        Stage newStage = new Stage();
                        newStage.setScene(newScene);
                        newStage.show();
                        
    }

    @FXML
    private void modifierC(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifC.fxml"));
                        Parent root = (Parent) loader.load();
                        ModifCController adm = loader.getController();

                        //hide actual window
                        final Node source = (Node) event.getSource();
                        final Stage stage = (Stage) source.getScene().getWindow();
                       // stage.close();

                        //Show next window
                        Scene newScene = new Scene(root);
                        Stage newStage = new Stage();
                        newStage.setScene(newScene);
                        newStage.show();
    }

   

    @FXML
    private void supprimerEX(ActionEvent event) throws SQLException {
         if(experienceTable.getSelectionModel().getSelectedItem()!= null){
            
           //  suppEx.setDisable(false);
             
            //Alert Delete Partner :
            Alert deletePartnerAlert = new Alert(Alert.AlertType.CONFIRMATION);
            deletePartnerAlert.setTitle("Delete Partner");
            deletePartnerAlert.setHeaderText(null);
            deletePartnerAlert.setContentText("Are you sure want to delete this partner ?");
            
            Optional<ButtonType> optionDeletePartnerAlert = deletePartnerAlert.showAndWait();
            if(optionDeletePartnerAlert.get() == ButtonType.OK){
               // System.out.println("salut ichrak");
                cruddd.supprimerEX(experienceTable.getSelectionModel().getSelectedItem().getId());
                
            }else if(optionDeletePartnerAlert.get() == ButtonType.CANCEL){
                
            }
            //Alert Delete Partner !
        }else{
            //Alert Select Partner :
            Alert selectPartnerAlert = new Alert(Alert.AlertType.WARNING);
            selectPartnerAlert.setTitle("Select Partner");
            selectPartnerAlert.setHeaderText(null);
            selectPartnerAlert.setContentText("You need to select partner first!");
            selectPartnerAlert.showAndWait();
            //Alert Select Partner !
        }
          experienceTable.setItems(cruddd.afficherExperiences());
   
    }
    
 @FXML
    private void supprimerFO (ActionEvent event) throws SQLException {
        
        if(formationTable.getSelectionModel().getSelectedItem()!= null){
            
            // suppFor.setDisable(false);
             
            //Alert Delete Partner :
            Alert deletePartnerAlert = new Alert(Alert.AlertType.CONFIRMATION);
            deletePartnerAlert.setTitle("Delete Partner");
            deletePartnerAlert.setHeaderText(null);
            deletePartnerAlert.setContentText("Are you sure want to delete this partner ?");
            
            Optional<ButtonType> optionDeletePartnerAlert = deletePartnerAlert.showAndWait();
            if(optionDeletePartnerAlert.get() == ButtonType.OK){
               // System.out.println("salut ichrak");
                crudd.supprimerFO(formationTable.getSelectionModel().getSelectedItem().getId());
                
            }else if(optionDeletePartnerAlert.get() == ButtonType.CANCEL){
                
            }
            
            
            //Alert Delete Partner !
        }else{
            //Alert Select Partner :
            Alert selectPartnerAlert = new Alert(Alert.AlertType.WARNING);
            selectPartnerAlert.setTitle("Select Partner");
            selectPartnerAlert.setHeaderText(null);
            selectPartnerAlert.setContentText("You need to select partner first!");
            selectPartnerAlert.showAndWait();
            //Alert Select Partner !
        }
          formationTable.setItems(crudd.afficherFormations());
        
  
    }

    @FXML
    private void supprimerInfo(ActionEvent event) throws SQLException {
         InfoServices crud2 = new InfoServices();
        InfoG gg = new InfoG();
         gg=crud2.afficherInfog();
        
        
         Alert deletePartnerAlert = new Alert(Alert.AlertType.CONFIRMATION);
            deletePartnerAlert.setTitle("Delete Partner");
            deletePartnerAlert.setHeaderText(null);
            deletePartnerAlert.setContentText("Are you sure want to delete this partner ?");
            
            Optional<ButtonType> optionDeletePartnerAlert = deletePartnerAlert.showAndWait();
            if(optionDeletePartnerAlert.get() == ButtonType.OK){
               // System.out.println("salut ichrak");
               crudddd.supprimerIN(gg.getId());
                
            }else if(optionDeletePartnerAlert.get() == ButtonType.CANCEL){
                
            }
          //  formationTable.setItems(crudd.afficherFormations());

    }

   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}

    
    

    
   

