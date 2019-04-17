/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXMLArticle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import org.apache.commons.lang3.RandomStringUtils;
import Entities.Article;
import Entities.Categorie;
import Service.ArticleCRUD;
import Service.CategorieCRUD;

/**
 * FXML Controller class
 *
 * @author Ala-y
 */
public class ArticleUpdateController implements Initializable {

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
    private JFXTextField articleContenuTextField;
    @FXML
    private ComboBox<String> articleCategorieComboBox;
    @FXML
    private JFXButton saveAddArticleButton;
    @FXML
    private JFXButton cancelAddArticleButton;

    Categorie cat = new Categorie();
    ArticleCRUD crud = new ArticleCRUD();
    private CategorieCRUD crudArticleCategorie;
    @FXML
    private ImageView imageV;

    public static Article article;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        Platform.runLater(() -> {
            ArrayList<Categorie> categories = CategorieCRUD.getInstance().showAllCategories();

            ArticleCRUD crud = new ArticleCRUD();

            crudArticleCategorie = new CategorieCRUD();

            for (Categorie s : categories) {
                articleCategorieComboBox.getItems().add(s.getNom());
            }
            /*  Image im = new Image("/Resources/" + article.getImage(), false);
            photo.setFill(new ImagePattern(im));

            photo.setEffect(new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN));
             */
            /*
            Image image = new Image("/Resources/" + article.getImage(), 1814, 117, false, true);
            imageV.setImage(image);
*/
            articleTitreTextField.setText(article.getTitre());
            articleAuteurTextField.setText(article.getAuteur());
            articleContenuTextField.setText(article.getContenu());
            articleDescriptionTextField.setText(article.getDescription());
            articleCategorieComboBox.setValue(ArticleCRUD.getInstance().getCategories(article.getCategorieId()));
//How to set an Image
            //article = ArticleCRUD.getInstance().show(id);
            //System.err.println(article.toString()+"<-----------------------------");
            // imageV.setImage(image1);

            // articleCategorieComboBox.setValue(article.getCategorieId());
        });
    }

    @FXML
    private void cancel(ActionEvent event) {
    }

    @FXML
    private void UpdateArticle(ActionEvent event) throws SQLException, IOException {
        Article article = new Article();
        Image image1 = imageV.getImage();
        String nameImage1 = saveToFileImageNormal(image1);
        ArrayList<Categorie> categories = CategorieCRUD.getInstance().showAllCategories();

        imageV.setImage(image1);
        article.setTitre(articleTitreTextField.getText());
        article.setAuteur(articleAuteurTextField.getText());
        article.setDescription(articleDescriptionTextField.getText());
        article.setImage(nameImage1);
        article.setContenu(articleContenuTextField.getText());
        article.setCategorieId(categories.get(articleCategorieComboBox.getSelectionModel().getSelectedIndex()).getId());

        System.out.println("********" + article.toString());
        ArticleCRUD.getInstance().update(article);
    }
////////////////////////////////// Image ///////////////////////////////////

    public static String saveToFileImageNormal(Image image) throws SQLException, IOException {
        String ext = "jpg";
        File dir = new File("C:/xampp/htdocs/SmartStart/src/Resources");
        String name = String.format("%s.%s", RandomStringUtils.randomAlphanumeric(8), ext);
        File outputFile = new File(dir, name);
        BufferedImage bImage = SwingFXUtils.fromFXImage(image, null);
        ImageIO.write(bImage, "png", outputFile);
        return name;
    }

    @FXML
    private void addImage(MouseEvent event) throws IOException {
        FileChooser fc = new FileChooser();

        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (.jpg)", "*.JPG");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (.png)", "*.PNG");
        fc.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
        File selectedFile = fc.showOpenDialog(null);
        try {
            BufferedImage bufferedImage = ImageIO.read(selectedFile);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            imageV.setImage(image);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
////////////////////////////////// Image ///////////////////////////////////
    }

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
