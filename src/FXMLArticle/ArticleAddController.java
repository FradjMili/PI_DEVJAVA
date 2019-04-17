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
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
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
public class ArticleAddController implements Initializable {

    private CategorieCRUD crudArticleCategorie;

    @FXML
    private StackPane rootPane;
    @FXML
    private AnchorPane mainContainer;
    @FXML
    private ComboBox<String> articleCategorieComboBox;
    @FXML
    private JFXTextField articleTitreTextField;
    @FXML
    private JFXTextField articleAuteurTextField;
    @FXML
    private JFXTextField articleDescriptionTextField;

    private JFXButton articleImageButton;
    @FXML
    private JFXTextField articleContenuTextField;
    @FXML
    private JFXButton saveAddArticleButton;
    @FXML
    private JFXButton cancelAddArticleButton;
    @FXML
    private ImageView imageV;
    private Stage dialogStage;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ArrayList<Categorie> categories = CategorieCRUD.getInstance().showAllCategories();

        ArticleCRUD crud = new ArticleCRUD();
        crudArticleCategorie = new CategorieCRUD();
        for (Categorie s : categories) {
            articleCategorieComboBox.getItems().add(s.getNom());
        }
    }

    @FXML
    private void AjouterOffre(ActionEvent event) throws SQLException, IOException {
         if (isInputValid()) {
        Article article = new Article();
        //java.sql.Date updatedAt = new java.sql.Date(System.currentTimeMillis());

        java.sql.Date updatedAt = Date.valueOf(LocalDate.now()); //Date Systeme

        Image image1 = imageV.getImage();
        String nameImage1 = saveToFileImageNormal(image1);
        ArrayList<Categorie> categories = CategorieCRUD.getInstance().showAllCategories();

        //article.setId(++count);
        article.setDateCreation(updatedAt);
        article.setDateEdition(updatedAt);
        article.setUpdatedAt(updatedAt);

        article.setTitre(articleTitreTextField.getText());
        article.setAuteur(articleAuteurTextField.getText());
        article.setDescription(articleDescriptionTextField.getText());
        article.setImage(nameImage1);
        article.setCategorieId(categories.get(articleCategorieComboBox.getSelectionModel().getSelectedIndex()).getId());
        article.setContenu(articleContenuTextField.getText());

        System.out.println("********" + article.toString());

        ArticleCRUD.getInstance().Ajouter(article);
         }
      /*  Alert alert = new Alert(Alert.AlertType.INFORMATION);
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.initStyle(StageStyle.TRANSPARENT);

        alert.setTitle("Success");
        alert.setContentText("=D");
        alert.showAndWait();*/
        //Create a notification
        /*Notifications n =Notifications.create().title("Notification")
             .text("Ajouter efféctué avec succés")
             .graphic(null)
             .position(Pos.BASELINE_LEFT)
             .onAction(new  EventHandler<ActionEvent>() {
             
             public void handle (ActionEvent event){
                 System.out.println("notifocation");
             }
             });*/

    }

    @FXML
    private void cancel(ActionEvent event) {
    }
/////////////////////////////// Image //////////////////////////////////////

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
    }
/////////////////////////////// Image //////////////////////////////////////

    private boolean isInputValid() {
        String errorMessage = "";

        if (articleTitreTextField.getText().length() == 0) {
            articleTitreTextField.setStyle("-fx-text-inner-color: red");
            articleTitreTextField.setStyle("-fx-prompt-text-fill: red");
            articleTitreTextField.setStyle("-fx-border-color: red");

            errorMessage += "Plz Complete the Auteur Field!\n";

            articleTitreTextField.setStyle("-fx-text-inner-color:  #663399");
            articleTitreTextField.setStyle("-fx-prompt-text-fill:  #663399");

        }
        if (articleAuteurTextField.getText() == null || articleAuteurTextField.getText().length() == 0) {
            errorMessage += "Plz Complete the Auteur Field!\n";
        }
        if (articleDescriptionTextField.getText() == null || articleDescriptionTextField.getText().length() == 0) {
            errorMessage += "Plz Complete the Description Field!\n";
        }
        /*    if (imageFile.isEmpty()) {
            errorMessage += "Plz Insert an Image!\n";
        }*/
        if (articleContenuTextField.getText() == null || articleContenuTextField.getText().length() == 0) {
            errorMessage += "Plz Complete the Content Field!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
}
