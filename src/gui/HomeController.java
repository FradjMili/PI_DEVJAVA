
package gui;

import com.itextpdf.text.DocumentException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import services.Pdf;
public class HomeController implements Initializable {

   // private Button b_aff;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    //   b_aff.setVisible(false);
    }  
    
    
    @FXML
    public void redirecCV(ActionEvent event) throws IOException
    {
            
    FXMLLoader loader = new FXMLLoader(getClass().getResource("ajout_infor.fxml"));
                        Parent root = (Parent) loader.load();
                        Ajout_inforController adm = loader.getController();

                        //hide actual window
                        final Node source = (Node) event.getSource();
                        final Stage stage = (Stage) source.getScene().getWindow();
                        stage.close();

                        //Show next window
                        Scene newScene = new Scene(root);
                        Stage newStage = new Stage();
                        newStage.setScene(newScene);
                        newStage.show();
    }
    
    
    
    @FXML
     public void redirecRE(ActionEvent event) throws IOException
    {
            
    FXMLLoader loader = new FXMLLoader(getClass().getResource("Ajout.fxml"));
                        Parent root = (Parent) loader.load();
                       Ajout_reclamationController adm = loader.getController();

                        //hide actual window
                        final Node source = (Node) event.getSource();
                        final Stage stage = (Stage) source.getScene().getWindow();
                        stage.close();

                        //Show next window
                        Scene newScene = new Scene(root);
                        Stage newStage = new Stage();
                        newStage.setScene(newScene);
                        newStage.show();
    }
     
     @FXML
     public void afficherCV(ActionEvent event) throws IOException
    {
    
      FXMLLoader loader = new FXMLLoader(getClass().getResource("affichageCV.fxml"));
                        Parent root = (Parent) loader.load();
                       AffichageCVController adm = loader.getController();

                        //hide actual window
                        final Node source = (Node) event.getSource();
                        final Stage stage = (Stage) source.getScene().getWindow();
                        stage.close();

                        //Show next window
                        Scene newScene = new Scene(root);
                        Stage newStage = new Stage();
                        newStage.setScene(newScene);
                        newStage.show();
}

    @FXML
    private void pdf(ActionEvent event) throws SQLException, FileNotFoundException, DocumentException {
        Pdf p = new Pdf();
    }
     
}
