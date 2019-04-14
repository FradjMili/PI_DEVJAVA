/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartstart.gui.Article;

import com.jfoenix.controls.JFXListView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import smartstart.entities.Article;
import smartstart.main.Routes;
import smartstart.services.ArticleCRUD;

/**
 * FXML Controller class
 *
 * @author Ala-y
 */
public class ArticleListController implements Initializable {

    @FXML
    private JFXListView<Article> Articles_ListView;

    ArticleCRUD articleCRUD;
    private ObservableList<Article> ArticleObservaleList;

    /**
     * Initializes the controller class.
     */
    public ArticleListController() {
        articleCRUD = new ArticleCRUD();
        ArticleObservaleList = articleCRUD.AfficherAllArticles();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Articles_ListView.setItems(ArticleObservaleList);
        Articles_ListView.getStylesheets().add(Routes.HamburgerCss);
        Articles_ListView.setCellFactory(articleListView -> new ArticleCellController(this));
        Articles_ListView.refresh();
    }

    public void delete(int index) {
        Articles_ListView.getItems().remove(index);
        Articles_ListView.refresh();
        
        
    }

    public void edit(int index) {
        Articles_ListView.edit(index);
    }

    public void loadData() {
        ArticleObservaleList = articleCRUD.AfficherAllArticles();
        Articles_ListView.setItems(ArticleObservaleList);
        //Articles_ListView.getStylesheets().add(Routes.HamburgerCss);
        Articles_ListView.setCellFactory(articleListView -> new ArticleCellController(this));
        Articles_ListView.refresh();
    }
}
