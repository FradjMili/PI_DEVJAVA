/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXMLFreelancer;

import Entities.Annonce;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import util.Authentification;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.Instant;
import java.time.ZoneId;
//import java.util.Date;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
        
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.*;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javax.management.Notification;
import org.controlsfx.control.Notifications;
import static user.Authentification.user;


/**
 * FXML Controller class
 *
 * @author USER
 */
public class AjouterAnnonceController implements Initializable {

    

    @FXML
    private TextField salaire;
    @FXML
    private TextField speciality;
    @FXML
    private TextField titre;

    private  Service.ServiceAnnonce msE=new Service.ServiceAnnonce();
  
    @FXML
    private JFXDatePicker datedeb_ev;
    @FXML
    private JFXDatePicker datefin_ev;
    @FXML
    private JFXTextArea description;

    private Desktop desktop = Desktop.getDesktop();
    
     final FileChooser fileChooser = new FileChooser();
     
     private String file_image ;
    

     
    private Path pathfrom;
    private Path pathto;
    private File Current_file;
    @FXML
    private ImageView image_p;
    private JFXButton fichier;
    
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        


                          }
    
    
    
    
    private boolean testNumberInput(String a)
    {
        boolean b=false;
        if(a.matches("^[0-9]*"))
        {
            b=true;
        }
        return b;
    }

    
    private boolean NoDate(){
     boolean  test=false;
      System.out.println(ChronoUnit.DAYS.between(this.datedeb_ev.getValue(), this.datefin_ev.getValue()));  
      
         int a=(int) ChronoUnit.DAYS.between(this.datedeb_ev.getValue(), this.datefin_ev.getValue());
         int b=(int) ChronoUnit.DAYS.between(LocalDate.now(), this.datedeb_ev.getValue());
        System.out.println("aaaaaaaaaa"+b);
    if (a<0  || b<0)
    {
  
        test=true;
        
    }
    return test;
    }
    
    
    
   
    
    
    @FXML
    private void addButton(ActionEvent event) throws IOException {
        Annonce ev=new Annonce();
        ev.setIduserA(user.connectedUser.getId());
        ev.setEtatannonce(0);
        ev.setTitre(titre.getText());
        ev.setSpeciality(speciality.getText());
     
ev.setDescription(description.getText());
ev.setSalaire(Integer.parseInt(salaire.getText()));

Date datedeb = Date.valueOf(datedeb_ev.getValue());
   Date datefin = Date.valueOf(datefin_ev.getValue());
        System.out.println(datefin);
        
        
        
              
SimpleDateFormat formmat1 = new SimpleDateFormat("yyyy/MM/dd");

String datedebutstring = formmat1.format(datedeb);

String datefinstring = formmat1.format(datefin);

           
        
        
        
        
   ev.setDatedebut(datedebutstring);
     ev.setDatefin(datefinstring);

   

   /************ is empty verify***************/

   if(titre.getText().length()==0){
    titre.setStyle("-fx-text-inner-color: red");
            titre.setStyle("-fx-prompt-text-fill: red");
            titre.setStyle("-fx-border-color: red");
            
            Alert alert = new Alert(Alert.AlertType.WARNING);
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.initStyle(StageStyle.TRANSPARENT);
            
            alert.setTitle("Attention");
            alert.setContentText("Veuillez donner un titre!");
            alert.showAndWait();
            titre.setCursor(Cursor.WAIT);
            titre.setStyle("-fx-text-inner-color:  #663399");
            titre.setStyle("-fx-prompt-text-fill:  #663399");

   
   }
   else if(speciality.getText().length()==0){
   
  
    speciality.setStyle("-fx-text-inner-color: red");
            speciality.setStyle("-fx-prompt-text-fill: red");
            speciality.setStyle("-fx-border-color: red");
            
            Alert alert = new Alert(Alert.AlertType.WARNING);
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.initStyle(StageStyle.TRANSPARENT);
            
            alert.setTitle("Attention");
            alert.setContentText("Veuillez saisir la specialité!");
            alert.showAndWait();
            speciality.setCursor(Cursor.WAIT);
            speciality.setStyle("-fx-text-inner-color:  #663399");
            speciality.setStyle("-fx-prompt-text-fill:  #663399");

   
   }
      else if(description.getText().length()==0){
   
  
    description.setStyle("-fx-text-inner-color: red");
            description.setStyle("-fx-prompt-text-fill: red");
            description.setStyle("-fx-border-color: red");
            
            Alert alert = new Alert(Alert.AlertType.WARNING);
         
            
            alert.setTitle("Attention");
            alert.setContentText("Veuillez saisir la description!");
            alert.showAndWait();
            description.setCursor(Cursor.WAIT);
            description.setStyle("-fx-text-inner-color:  #663399");
            description.setStyle("-fx-prompt-text-fill:  #663399");

   
   }
   
 else if (NoDate()){
//     Alert alert =new Alert(Alert.AlertType.WARNING, " Date début doit étre supérieur à date fin", ButtonType.CLOSE);
//        alert.showAndWait();
//   
notif(event);
   } 
 else if (salaire.getText().equals(""))
     {
    salaire.setStyle("-fx-text-inner-color: red");
            salaire.setStyle("-fx-prompt-text-fill: red");
            salaire.setStyle("-fx-border-color: red");
            
            Alert alert = new Alert(Alert.AlertType.WARNING);
         
            
            alert.setTitle("Attention");
            alert.setContentText("Veuillez saiisr le salaire !");
            alert.showAndWait();
            salaire.setCursor(Cursor.WAIT);
            salaire.setStyle("-fx-text-inner-color:  #663399");
            salaire.setStyle("-fx-prompt-text-fill:  #663399");

     }
  

 
 
 
  else if(datedeb.equals("")){
   
  
            Alert alert = new Alert(Alert.AlertType.WARNING);
         
            
            alert.setTitle("Attention");
            alert.setContentText("Veuillez saisir la date de début de l'annonce!");
            alert.showAndWait();
        
          
         

   
   }

 
 
   else if(datefin.equals("")){
   
  
            Alert alert = new Alert(Alert.AlertType.WARNING);
         
            
            alert.setTitle("Attention");
            alert.setContentText("Veuillez saiisr la date de fin de l'annonce !");
            alert.showAndWait();
         
   }
  else if(datefin.equals(datedeb)){
   
  
            Alert alert = new Alert(Alert.AlertType.WARNING);
         
            
            alert.setTitle("Attention");
            alert.setContentText("Veuillez saiisr la date  une autre fois  !");
            alert.showAndWait();
        
          
         

   
   }
 
 
else
{ 
   file_image="/photos/"+file_image;
   ev.setImage(file_image);
        
        
            pathfrom = FileSystems.getDefault().getPath(Current_file.getPath());
            pathto = FileSystems.getDefault().getPath("C:\\wamp64\\www\\photos\\"+Current_file.getName());
        
            Path targetDir = FileSystems.getDefault().getPath("C:\\wamp64\\www\\photos\\");
                   
        Files.copy(pathfrom, pathto,StandardCopyOption.REPLACE_EXISTING);
    
    
msE.AjouterAnnonce(ev);
         Notifications n =Notifications.create().title("Notification")
             .text("Ajouter efféctué avec succés")
             .graphic(null)
             .position(Pos.BASELINE_LEFT)
             .onAction(new  EventHandler<ActionEvent>() {
             
             public void handle (ActionEvent event){
                 System.out.println("notifocation");
             }
             });
     n.showConfirm();
     
        Template.Template.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/FXMLFreelancer/MenuClient.fxml"))));             

}  
        
        
       
    
    }

    /****************************/
   
    
  
    
    @FXML
    private void checkWrittenNumber(KeyEvent event) {
        
    if(this.testNumberInput(salaire.getText()))
    {
       
        System.out.println("correct");
        
    }
    else
    {
         Alert a =new Alert(null, " please insert number in salaire field", ButtonType.CLOSE);
        a.showAndWait();
        System.out.println(" not correct");
        
        
    }
    }

    
    
    private void notif(ActionEvent event) {
     Notifications n =Notifications.create().title("")
             .text("Date début doit étre inferieur à date fin ou date début sépérieur au date d'aujourd'hui")
             .graphic(null)
             .position(Pos.CENTER)
             .onAction(new  EventHandler<ActionEvent>() {
             
             public void handle (ActionEvent event){
                 System.out.println("clicked on notification");
             }
             });
     n.showWarning();
        
    }

    

    
    
    
    
   private void fichier_image(ActionEvent event) throws MalformedURLException {
        
Current_file = fileChooser.showOpenDialog(Template.Template.getInstance().getStage());
                    if (Current_file != null) {
//                        openFile(file);
                        System.out.println(Current_file.toURI().toURL().toExternalForm());
                     file_image= Current_file.getName();
                    }
        
         
    Image image2 = new Image(Current_file.toURI().toString());
             
image_p.setImage(image2);
          
                    
                    
        final GridPane inputGridPane = new GridPane();
        GridPane.setConstraints(fichier, 0, 0);
        inputGridPane.setHgap(6);
        inputGridPane.setVgap(6);
        final Pane rootGroup = new VBox(12);
        rootGroup.getChildren().addAll(inputGridPane);
        rootGroup.setPadding(new Insets(12, 12, 12, 12));        
    }

   
   
   
   
    @FXML
    private void imageDragOver(DragEvent event) {
        
            Dragboard board = event.getDragboard();
      if (board.hasFiles()) {
        event.acceptTransferModes(TransferMode.ANY);
      }
    }

    
    
    @FXML
    private void imageDropped(DragEvent event) throws FileNotFoundException {
        
            Dragboard board = event.getDragboard();
        List<File> phil = board.getFiles();
        FileInputStream fis;
          fis = new FileInputStream(phil.get(0));
        Image image = new Image(fis);
      File selectedFile = phil.get(0);
        if (selectedFile != null) {
           
         String test = selectedFile.getAbsolutePath();
            System.out.println(test);
            
            Current_file=selectedFile.getAbsoluteFile();
            file_image=Current_file.getName();
           Annonce e= new Annonce();
           e.setImage(selectedFile.getName());
          image_p.setImage(image);
          
          
          
    }

}}

    
    
    
    
    
    
    
    
    
    
    

