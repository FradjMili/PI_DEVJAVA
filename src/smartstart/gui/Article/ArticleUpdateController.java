/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartstart.gui.Article;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import smartstart.entities.Article;
import smartstart.entities.Categorie;
import smartstart.services.ArticleCRUD;
import smartstart.services.CategorieCRUD;
import smartstart.utils.StaticData;

/**
 * FXML Controller class
 *
 * @author Ala-y
 */
public class ArticleUpdateController implements Initializable {

    private String imageFile;

    @FXML
    private StackPane rootPane;
    @FXML
    private AnchorPane mainContainer;
    @FXML
    private JFXTextField articleTitreTextField;
    @FXML
    private JFXTextField articleAuteurTextField;
    @FXML
    private JFXTextField articleDescriptionTextField;
    @FXML
    private JFXButton articleImageButton;
    @FXML
    private JFXTextField articleContenuTextField;
    @FXML
    private ComboBox<Categorie> articleCategorieComboBox;
    @FXML
    private JFXButton saveAddArticleButton;
    @FXML
    private JFXButton cancelAddArticleButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Platform.runLater(() -> {
            articleDescriptionTextField.setStyle("-fx-text-fill: black;");
            articleTitreTextField.setStyle("-fx-text-fill: black;");

            articleTitreTextField.setText(StaticData.ArticleTitre);
            articleAuteurTextField.setText(StaticData.ArticleAuteur);
            articleDescriptionTextField.setText(StaticData.ArticleDesc);
            articleImageButton.setText(StaticData.ArticleImage);
            articleContenuTextField.setText(StaticData.ArticleContenu);

            CategorieCRUD crudArticleCategorie = new CategorieCRUD();
            try {
                articleCategorieComboBox.setItems(crudArticleCategorie.getAllArticleCategories());

            } catch (SQLException ex) {
                Logger.getLogger(ArticleAddController.class.getName()).log(Level.SEVERE, null, ex);
            }
            //To set A Value in the ComboBox From the beginnig
            articleCategorieComboBox.getSelectionModel().selectFirst();
        });
    }

    @FXML
    private void AjouterArticle(ActionEvent event) {
        java.sql.Date updatedAt = Date.valueOf(LocalDate.now()); //Date Systeme

        String articleTitre = articleTitreTextField.getText();
        String articleAuteur = articleAuteurTextField.getText();
        String articleDescription = articleDescriptionTextField.getText();
        String articleImage = articleImageButton.getText();
        String articleContenu = articleContenuTextField.getText();
        int articleCategorie = articleCategorieComboBox.getValue().getId();
        ArticleCRUD articleCRUD = new ArticleCRUD();
        Article article = new Article(articleTitre, articleAuteur, articleDescription, updatedAt, updatedAt, imageFile, updatedAt, articleContenu, articleCategorie);
        article.setId(Integer.parseInt(StaticData.ArticleId));
        // article.setId(4);
        //articleCategorieComboBox.getSelectionModel().select(articleCategorie.getType());

        articleCRUD.Update(article);
    }

    @FXML
    private void handleUploadImage(ActionEvent event) {

        FileChooser fc = new FileChooser();
        File f = fc.showOpenDialog(null);

        if (f != null) {
            imageFile = f.getAbsolutePath();
        }

    }

    @FXML
    private void cancel(ActionEvent event) {
    }

}
