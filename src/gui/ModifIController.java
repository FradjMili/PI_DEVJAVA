/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import services.InfoServices;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class ModifIController implements Initializable {

    private String action;

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
    @FXML
    private Button update;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        LocalDate date = date_nais.getValue();
        InfoServices crud = new InfoServices();
        InfoG g = new InfoG();
        try {
            g = crud.afficherInfog();
            // System.out.println(g);
            nom.setText(g.getNom());
            prenom.setText(g.getPrenom());
            //     date_nais.setText(g.getDateNais().toString());
            tele.setText(String.valueOf(g.getTele()));
            adresse.setText(g.getAdresse());
            adrMail.setText(g.getAdrMail());
        } catch (SQLException ex) {
            Logger.getLogger(AffichageCVController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void update(ActionEvent event) throws IOException, SQLException {
        InfoG infG = new InfoG();

        infG.setNom(nom.getText());
        infG.setPrenom(prenom.getText());
        // info.setDateNais(date_nais.get);
        infG.setTele(Integer.parseInt(tele.getText()));
        infG.setAdrMail(adrMail.getText());
        infG.setAdresse(adresse.getText());

        InfoServices cru = new InfoServices();
        cru.modifierInfo(infG);

        Alert updatePartnerAlert = new Alert(AlertType.INFORMATION);
        updatePartnerAlert.setTitle("Update Partner");
        updatePartnerAlert.setHeaderText("Results:");
        updatePartnerAlert.setContentText("Partner updated successfully!");

        updatePartnerAlert.showAndWait();
    }

}
