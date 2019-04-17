package FXMLArticle;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import Entities.Article;
import utils.Routes;
import javafx.scene.control.ListCell;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import Service.ArticleCRUD;
import Service.CategorieCRUD;
import utils.StaticData;

/**
 * FXML Controller class
 *
 * @author Ala-y
 */
public class ArticleCellController extends ListCell<Article> {

    @FXML
    private GridPane GridPane;
    @FXML
    private AnchorPane ServicePane;
    @FXML
    private JFXButton Supprimer;
    @FXML
    private JFXButton Modifier;
    @FXML
    private ImageView image;
    @FXML
    private Label categorie;
    @FXML
    private Label pro;
    @FXML
    private Label date;

    ArticleListController Controller;
    ArticleListController controllerd;
    private FXMLLoader mLLoader;
    ArticleCRUD crud;

    public ArticleCellController(ArticleListController controllerd) {
        this.controllerd = controllerd;
    }

    ArticleCellController() {

    }

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
                    System.err.println("ARTICLE CELL CONTROLLER !!!!!!!!!");
                } catch (IOException e) {

                    e.printStackTrace();
                }

            }
//////////////////// Affichage dans la Cell/////////////////////////////

            /*   Image imaged = new Image(getClass().getResource("/Resources/coca.png").toExternalForm());
            image.setImage(imaged);
            image.setClip(new Circle(20, 20, 70));*/
            CategorieCRUD crudArticleCategorie = new CategorieCRUD();
            System.out.println(article.getTitre());
            categorie.setText(ArticleCRUD.getInstance().getCategories(article.getCategorieId()));
            date.setText(article.getDateCreation().toString());
            pro.setText(article.getAuteur());
//must set an image
            System.out.println(article.getId());

///////////////////////////////Delete the Cell/////////////////////////////////
            Supprimer.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
                try {
                    ArticleCRUD.getInstance().delete(article.getId());
                } catch (Exception ex) {
                    System.out.println("Probleme de suppression d'une demande ");
                }
                this.controllerd.loadData();
            });

////////////////////////////Update the Cell////////////////////////
            Modifier.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
                FXMLLoader ModifierArticle = new FXMLLoader();
                ModifierArticle.setLocation(getClass().getResource(Routes.ArticleUpdate));
                Scene scene;
                try {
                    System.out.println(";:;aaa;,ooo;:;,iids,d:;:d,");
                    scene = new Scene(ModifierArticle.load(), 774, 471);
                    System.out.println("nrjkvjkvjdkfvfndkjjfnf");
                    ArticleUpdateController modcontroller = ModifierArticle.<ArticleUpdateController>getController();
////////////?????????????/////////
                    modcontroller.setArticle(article);
                    Stage stage = new Stage();

                    stage.setTitle("Modification demandes");
                    stage.setScene(scene);
                    stage.show();
                    System.out.println("showing Article update interface");
                    stage.setOnHiding((f) -> {
                        this.controllerd.loadData();
                        stage.close();
                    });
                } catch (IOException ex) {
                    System.out.println("Chargement UpdateDemande impossible");
                }
            });
            ServicePane.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
                FXMLLoader ShowArticle = new FXMLLoader();
                ShowArticle.setLocation(getClass().getResource(Routes.ArticleShowArticleInformation));
                Scene scene;
                try {
                    System.out.println(";:;aaa;,ooo;:;,iids,d:;:d,");
                    scene = new Scene(ShowArticle.load(), 774, 471);
                    System.out.println("nrjkvjkvjdkfvfndkjjfnf");
                    ShowArticleInfoController showcontroller = ShowArticle.<ShowArticleInfoController>getController();
////////////?????????????/////////
                    showcontroller.setArticle(article);
                    Stage stage = new Stage();

                    stage.setTitle("Infos Articles");
                    stage.setScene(scene);
                    stage.show();
                    System.out.println("showing Article Info interface");
                    stage.setOnHiding((f) -> {
                        this.controllerd.loadData();
                        stage.close();
                    });
                } catch (IOException ex) {
                    System.out.println("Chargement InfoArticle impossible");
                }
              
            });

            //pro.setText(String.valueOf(pro));
            DropShadow dropShadow = new DropShadow();
            dropShadow.setRadius(5.0);
            dropShadow.setOffsetX(3.0);
            dropShadow.setOffsetY(3.0);
            dropShadow.setColor(Color.color(0.4, 0.5, 0.5));

            setText(null);
            setGraphic(GridPane);
        }

    }

}
