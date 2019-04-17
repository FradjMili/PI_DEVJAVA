/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXMLArticle;

import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.util.Callback;
import javax.mail.Service;
import Entities.Article;
import Service.ArticleCRUD;

/**
 * FXML Controller class
 *
 * @author Ala-y
 */
public class ArticleListController implements Initializable {

    @FXML
    private JFXListView<Article> Articles_ListView;
    @FXML
    private ListView<Article> servicelist;
    @FXML
    private JFXTextField articleRechercheField;

    private ObservableList<Article> articleObservableList;
    private ObservableList<Article> inversedObservableList;
    ArrayList<Article> mesarticles;

    public ArticleListController() {
        mesarticles = ArticleCRUD.getInstance().showAllServices();
        ArrayList<Article> articles = ArticleCRUD.getInstance().showAllServices();

        /////////////The reverse of articles///// ShowAllArticles Reversed ////////////
        Collections.reverse(articles);

        // ??????????????????Count par stream ??????????????????????????? //
        try {
            //Here we load the observalble lists
            this.articleObservableList = FXCollections.observableArrayList();
            articleObservableList.addAll(articles);
        } catch (Exception ex) {
            System.out.println("Probleme de chargement des demandes ");
        }
        try {

            this.inversedObservableList = FXCollections.observableArrayList();
            inversedObservableList.addAll(mesarticles);
        } catch (Exception ex) {
            System.out.println("Probleme de chargement des demandes ");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Image icon = new Image(getClass().getResource("/Image/recherche.png").toExternalForm());
        // searchicon.setImage(icon);
        /*----------------------------------------------------------------*/
        Articles_ListView.setItems(articleObservableList);
        Articles_ListView.setCellFactory(demandeListView -> new ArticleCellController(this));
        //Like in a table view we initilaze the content on the ListView
        servicelist.setItems(inversedObservableList);
        servicelist.setCellFactory(new Callback<ListView<Article>, ListCell<Article>>() {
            //WichCell we will use in ower treatment
            @Override
            public ListCell<Article> call(ListView<Article> demandeListView) {
                return new ArticleCellController() {

                };
            }
        });
        //Add a lisntener to the the chap articleRechercheField tout en load the loadDataRecherche
        articleRechercheField.textProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("textfield changed from " + oldValue + " to " + newValue);
            loadDataRecherche();
        });

    }

    public void loadData() {
        articleObservableList.clear();
        articleObservableList.addAll(ArticleCRUD.getInstance().showAllServices());
        Articles_ListView.setItems(articleObservableList);
        Articles_ListView.setCellFactory(demandeListView -> new ArticleCellController(this));
        Articles_ListView.refresh();

        /*We have to DO IT OR IT WILL CRASH WHY ,,????????????*/
      /*  inversedObservableList.clear();
        inversedObservableList.addAll(ArticleCRUD.getInstance().showAllServices());
        servicelist.setItems(articleObservableList);
        servicelist.setCellFactory(demandeListView -> new ArticleCellController(this));
        servicelist.refresh();*/
    }

    public void edit(int index) {
        Articles_ListView.edit(index);
    }

    public void delete(int index) {
        Articles_ListView.getItems().remove(index);
        //Articles_ListView.refresh();
    }

    ///////////////////////////////Recherche//////////////////////////////////
    public void loadDataRecherche() {
        articleObservableList.clear();
        List<Article> result2 = mesarticles.stream()
                .filter(x -> x.getAuteur().toLowerCase().contains(articleRechercheField.getText().toLowerCase()))
                .collect(Collectors.toList());
        if (result2 != null) {

            articleObservableList.addAll(result2);
            Articles_ListView.setItems(articleObservableList);

            Articles_ListView.setCellFactory(demandeListView -> new ArticleCellController());
            Articles_ListView.refresh();
        } else {
            articleObservableList.addAll(mesarticles);
            Articles_ListView.setItems(articleObservableList);

            Articles_ListView.setCellFactory(demandeListView -> new ArticleCellController());
            Articles_ListView.refresh();
        }
    }
    ///////////////////////////////Recherche//////////////////////////////////
}
