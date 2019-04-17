
package gui;

import entities.Competences;
import entities.InfoG;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import services.CompetenceServices;
import services.InfoServices;

public class ModifCController implements Initializable {

    @FXML
    private TextField competences;
    @FXML
    private TextField certificats;
    @FXML
    private TextField langues;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        CompetenceServices crud = new CompetenceServices();
        Competences g = new Competences();
        try {
            g = crud.afficherComp();
            // System.out.println(g);
            competences.setText(g.getNomCompetence());
            certificats.setText(g.getNomCertif());
            langues.setText(g.getLangues());
            
        } catch (SQLException ex) {
            Logger.getLogger(AffichageCVController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }    

    @FXML
    private void update(ActionEvent event)throws IOException, SQLException {
        
           Competences comp = new Competences();

        comp.setNomCompetence(competences.getText());
        comp.setNomCertif(certificats.getText());
         comp.setLangues(langues.getText());
       

        CompetenceServices cru = new CompetenceServices();
        cru.modifierComp(comp);

        Alert updatePartnerAlert = new Alert(Alert.AlertType.INFORMATION);
        updatePartnerAlert.setTitle("Update Partner");
        updatePartnerAlert.setHeaderText("Results:");
        updatePartnerAlert.setContentText("Partner updated successfully!");

        updatePartnerAlert.showAndWait();
    }
    
    
    }
    

