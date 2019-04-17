/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXMLArticle;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import Entities.Article;
import Service.ArticleCRUD;
import utils.StaticData;

/**
 * FXML Controller class
 *
 * @author Ala-y
 */
public class ArticleConfirmationDeleteController implements Initializable {

    @FXML
    private JFXButton confirmDeleteButton;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void ConfirmAction(ActionEvent event) {
        Article article = new Article();
        article.setId(article.getId());
        ArticleCRUD articleCRUD = new ArticleCRUD();
        articleCRUD.delete(article.getId());

        Stage stage = (Stage) confirmDeleteButton.getScene().getWindow();
        stage.close();
        stage.close();
            
        return;
    }

}
