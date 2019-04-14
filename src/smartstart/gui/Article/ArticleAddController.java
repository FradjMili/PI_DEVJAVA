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

/**
 * FXML Controller class
 *
 * @author Ala-y
 */
public class ArticleAddController implements Initializable {

    private String imageFile;
    private CategorieCRUD crudArticleCategorie;

    @FXML
    private StackPane rootPane;
    @FXML
    private AnchorPane mainContainer;
    @FXML
    private ComboBox<Categorie> articleCategorieComboBox;
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
    private JFXButton saveAddArticleButton;
    @FXML
    private JFXButton cancelAddArticleButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ArticleCRUD crud = new ArticleCRUD();
        CategorieCRUD crudArticleCategorie = new CategorieCRUD();
        try {
            articleCategorieComboBox.setItems(crudArticleCategorie.getAllArticleCategories());

        } catch (SQLException ex) {
            Logger.getLogger(ArticleAddController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void AjouterOffre(ActionEvent event) throws SQLException {
        Article article = new Article();
        java.sql.Date updatedAt = Date.valueOf(LocalDate.now()); //Date Systeme

        String articleTitre = articleTitreTextField.getText();
        String articleAuteur = articleAuteurTextField.getText();
        String articleDescription = articleDescriptionTextField.getText();
        String articleImage = articleImageButton.getText();
        String articleContenu = articleContenuTextField.getText();
        int articleCategorie = articleCategorieComboBox.getValue().getId();
        
       /* article.setDateCreation(updatedAt);
        article.setDateEdition(updatedAt);
        article.setUpdatedAt(updatedAt);*/

        Boolean flag = articleTitre.isEmpty() || articleAuteur.isEmpty();
        if (flag) {
            return;
        } else {

            //Article article = new Article(articleTitre, articleAuteur, articleDescription, imageFile, articleContenu, articleCategorie);
            Article a = new Article(articleTitre, articleAuteur, articleDescription,updatedAt, updatedAt, imageFile, updatedAt, articleContenu, articleCategorie);

            ArticleCRUD crudArticle = new ArticleCRUD();

            crudArticle.Ajouter(a);
        }
    }

    @FXML
    private void cancel(ActionEvent event) {
    }

    @FXML
    private void handleUploadImage(ActionEvent event) {

        FileChooser fc = new FileChooser();
        File f = fc.showOpenDialog(null);

        if (f != null) {
            imageFile = f.getAbsolutePath();
        }

    }

}
