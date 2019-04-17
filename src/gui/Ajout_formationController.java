
package gui;
import com.jfoenix.controls.JFXTextField;
import entities.Formations;
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
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import services.FormationServices;
import services.InfoServices;

public class Ajout_formationController implements Initializable {

    @FXML
    private DatePicker date_debut1;
    @FXML
    private DatePicker date_fin1;
    @FXML
    private TextField text1;
    @FXML
    private JFXTextField titre1;
    @FXML
    private JFXTextField titre2;
    @FXML
    private DatePicker date_debut2;
    @FXML
    private DatePicker date_fin2;
    @FXML
    private TextField text2;
    @FXML
    private JFXTextField titre3;
    @FXML
    private DatePicker date_debut3;
    @FXML
    private DatePicker date_fin3;
    @FXML
    private TextField text3;
    @FXML
    private JFXTextField titre4;
    @FXML
    private TextField text4;
    @FXML
    private DatePicker date_debut4;
    @FXML
    private DatePicker date_fin4;
     @FXML
    private Button b1;
      @FXML
    private Button b2;
       @FXML
    private Button b3;
        @FXML
    private Button b4;
     
    private int i=2;    
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        titre2.setVisible(false);
       date_debut2.setVisible(false);
       date_fin2.setVisible(false);
       text2.setVisible(false);
      
       
        titre3.setVisible(false);
       date_debut3.setVisible(false);
       date_fin3.setVisible(false);
       text3.setVisible(false);
       
       
        titre3.setVisible(false);
       date_debut3.setVisible(false);
       date_fin3.setVisible(false);
       text3.setVisible(false);
       
       
        titre4.setVisible(false);
       date_debut4.setVisible(false);
       date_fin4.setVisible(false);
       text4.setVisible(false);
       
      
         b2.setVisible(false);
          b3.setVisible(false);
   
    }    

    @FXML
    private void date(ActionEvent event) {
    }
    
    @FXML
    private void ajouter_formation(ActionEvent event) throws IOException {
        
        for (int j=1;j<i;j++)
        {
           if (j==1)
           {
            LocalDate date_debut = date_debut1.getValue();
             LocalDate date_fin = date_fin1.getValue();
             
             
Instant instant1 = Instant.from(date_debut.atStartOfDay(ZoneId.systemDefault()));
Instant instant2 = Instant.from(date_fin.atStartOfDay(ZoneId.systemDefault()));

Date date1 = Date.from(instant1);
Date date2 = Date.from(instant2);

System.out.println(date_debut + "\n" + instant1 + "\n" + date1);
 //Date D= new Date ("1997/02/16");
//System.out.println(localDate + "\n" + instant + "\n" + date);


String titre =titre1.getText();
String text =text1.getText();


Formations r =new Formations (titre,date1,date2,text,U2);
       
        FormationServices po =new FormationServices();
       po.ajouter(r);
           }
           
              if (j==2)
           {
            LocalDate date_debut = date_debut2.getValue();
             LocalDate date_fin = date_fin2.getValue();
             
             
Instant instant1 = Instant.from(date_debut.atStartOfDay(ZoneId.systemDefault()));
Instant instant2 = Instant.from(date_fin.atStartOfDay(ZoneId.systemDefault()));

Date date1 = Date.from(instant1);
Date date2 = Date.from(instant2);

System.out.println(date_debut + "\n" + instant1 + "\n" + date1);
 //Date D= new Date ("1997/02/16");
//System.out.println(localDate + "\n" + instant + "\n" + date);


String titre =titre2.getText();
String text =text2.getText();


Formations r =new Formations (titre,date1,date2,text,U2);
       
        FormationServices po =new FormationServices();
       po.ajouter(r);
           }
              
              
              
                 if (j==3)
           {
            LocalDate date_debut = date_debut3.getValue();
             LocalDate date_fin = date_fin3.getValue();
             
             
Instant instant1 = Instant.from(date_debut.atStartOfDay(ZoneId.systemDefault()));
Instant instant2 = Instant.from(date_fin.atStartOfDay(ZoneId.systemDefault()));

Date date1 = Date.from(instant1);
Date date2 = Date.from(instant2);

System.out.println(date_debut + "\n" + instant1 + "\n" + date1);
 //Date D= new Date ("1997/02/16");
//System.out.println(localDate + "\n" + instant + "\n" + date);


String titre =titre3.getText();
String text =text3.getText();


Formations r =new Formations (titre,date1,date2,text,U2);
       
        FormationServices po =new FormationServices();
       po.ajouter(r);
           }
                 
                 
                 
                    if (j==4)
           {
            LocalDate date_debut = date_debut4.getValue();
             LocalDate date_fin = date_fin4.getValue();
             
             
Instant instant1 = Instant.from(date_debut.atStartOfDay(ZoneId.systemDefault()));
Instant instant2 = Instant.from(date_fin.atStartOfDay(ZoneId.systemDefault()));

Date date1 = Date.from(instant1);
Date date2 = Date.from(instant2);

System.out.println(date_debut + "\n" + instant1 + "\n" + date1);
 //Date D= new Date ("1997/02/16");
//System.out.println(localDate + "\n" + instant + "\n" + date);


String titre =titre4.getText();
String text =text4.getText();


Formations r =new Formations (titre,date1,date2,text,U2);
       
        FormationServices po =new FormationServices();
       po.ajouter(r);
           }
                    
                    
                    
           
           
           
           
           
        }
       FXMLLoader loader = new FXMLLoader(getClass().getResource("Ajout_experience.fxml"));
                        Parent root = (Parent) loader.load();
                        Ajout_experienceController adm = loader.getController();

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
    
    
    
    
    @FXML
    private void show (ActionEvent event) throws IOException {
        
        Button btn = (Button) event.getSource();
String id = btn.getId();
        
       if ( "b1".equals(id)){ 
        titre2.setVisible(true);
       date_debut2.setVisible(true);
       date_fin2.setVisible(true);
       text2.setVisible(true); 
       b1.setVisible(false);
       b2.setVisible(true);
       i++;
       }
       
       else if ( "b2".equals(id)){ 
        titre3.setVisible(true);
       date_debut3.setVisible(true);
       date_fin3.setVisible(true);
       text3.setVisible(true); 
       b2.setVisible(false);
        b3.setVisible(true);
       i++;
       }
       
       else if ( "b3".equals(id)){ 
        titre4.setVisible(true);
       date_debut4.setVisible(true);
       date_fin4.setVisible(true);
       text4.setVisible(true);
        b3.setVisible(false);
       i++;
       }
        
    }

    }
    

