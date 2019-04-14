package smartstart.gui.Article;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import smartstart.entities.Article;
import smartstart.main.Routes;
import javafx.scene.control.ListCell;
import smartstart.services.ArticleCRUD;
import smartstart.utils.StaticData;

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
    
    ArticleListController Controller ;
    private FXMLLoader mLLoader;



    public ArticleCellController(ArticleListController controller) {
        Controller = controller;
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
                } catch (IOException e) {

                    e.printStackTrace();
                }

            }
            // Affichage dans la Cell
            categorie.setText(article.getTitre());
            date.setText(article.getDateCreation().toString());
            pro.setText(article.getAuteur());
            System.out.println(article.getId());

            Supprimer.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
                ArticleCRUD crud = new ArticleCRUD();
                crud.Supprimer(article);
                Controller.delete(this.getIndex());

            });
///Update the Cell
            Modifier.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
                Controller.edit(getIndex());
                Stage s = new Stage(StageStyle.DECORATED);
                try {
                    Parent p = FXMLLoader.load(getClass().getResource(Routes.ArticleUpdate));
                    Scene scene = new Scene(p);
                    s.setScene(scene);
                    s.show();

                } catch (IOException ex) {
                    Logger.getLogger(ArticleCellController.class.getName()).log(Level.SEVERE, null, ex);
                }
                StaticData.ArticleCategorie = "" +article.getCategorieId();
                StaticData.ArticleDesc = article.getDescription();
                StaticData.ArticleTitre = article.getTitre();
                StaticData.ArticleAuteur = article.getAuteur();
                StaticData.ArticleImage = article.getImage();
                StaticData.ArticleContenu = article.getContenu();
                
                StaticData.ArticleId = "" + article.getId();

                s.setOnHiding((f) -> {
                    Controller.loadData();
                    s.close();
                });

            });

            //pro.setText(String.valueOf(pro));
           setText(null);
            setGraphic(GridPane);
        }

    }
}
