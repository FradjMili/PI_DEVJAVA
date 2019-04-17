/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXMLArticle;

import com.jfoenix.controls.JFXTextArea;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import Entities.Article;
import Entities.Categorie;
import static FXMLArticle.ArticleUpdateController.article;
import utils.Routes;
import Service.ArticleCRUD;
import Service.CategorieCRUD;
import utils.StaticData;

/**
 * FXML Controller class
 *
 * @author Ala-y
 */
public class ShowArticleInfoController extends ListCell<Article> implements Initializable {
//That Imelement is necessary to the initialize methode 

    //ArticleListController Controller;
    private FXMLLoader mLLoader;
    ArticleCRUD crud;

    @FXML
    private JFXTextArea articleDescription_TextField;
    @FXML
    private Label articleCategorie;
    @FXML
    private Label articleAuteur;
    @FXML
    private Label articledateCreation;

    ArticleListController Controller;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Platform.runLater(() -> {
            ArrayList<Categorie> categories = CategorieCRUD.getInstance().showAllCategories();

            ArticleCRUD crud = new ArticleCRUD();

            articleAuteur.setText(article.getTitre());
            articleCategorie.setText(ArticleCRUD.getInstance().getCategories(article.getCategorieId()));
            articledateCreation.setText(article.getDateEdition()+"");

        });
    }

    /*  public ShowArticleInfoController(ArticleListController controller) {
        Controller = controller;
        crud = new ArticleCRUD();
    }*/
    @Override
    protected void updateItem(Article article, boolean empty) {

        super.updateItem(article, empty);

        if (empty || article == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {

                mLLoader = new FXMLLoader(getClass().getResource(Routes.ArticleCell));
                mLLoader.setController(this);

                try {
                    mLLoader.load();
                } catch (IOException e) {

                    e.printStackTrace();
                }

            }
            CategorieCRUD crudArticleCategorie = new CategorieCRUD();
            articleCategorie.setText(crud.getCategories(article.getCategorieId()));
            articleAuteur.setText(article.getAuteur());
            articledateCreation.setText(article.getDateCreation().toString());
            ///////////////////
            System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        }

    }

    //These ill help us to identifie the article which we are indexing
    /**
     * @return the article
     */
    public static Article getArticle() {
        return article;
    }

    /**
     * @param aArticle the article to set
     */
    public static void setArticle(Article aArticle) {
        article = aArticle;
    }
}
