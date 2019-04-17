/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartstart.gui.Article;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import smartstart.utils.SendMail;

/**
 * FXML Controller class
 *
 * @author Ala-y
 */
public class MailController implements Initializable {

    @FXML
    private JFXTextField mail;
    @FXML
    private Button btnenv;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void envoyer(ActionEvent event) {
                String subject = "Succés Participation";
            String object = "Participation";
            SendMail.envoyer(mail.getText(), subject, object);
    }
    
}
