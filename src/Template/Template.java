/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Template;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author akoum
 */
public class Template extends Application {
    
     private Stage stage;
    private static Template instance;
    private Scene scene;
    public Template() throws IOException, InterruptedException {
        instance = this;
 scene = new Scene(FXMLLoader.load(getClass().getResource("/FXMLFreelancer/AnnoncesFXML.fxml")));
     // scene = new Scene(FXMLLoader.load(getClass().getResource("/FXMLFreelancer/AjouterAnnonce.fxml")));
      //scene = new Scene(FXMLLoader.load(getClass().getResource("/FXMLFreelancer/DetailAnnonce.fxml")));
       
      //scene = new Scene(FXMLLoader.load(getClass().getResource("/drapodashbord/stat.fxml")));
  //scene = new Scene(FXMLLoader.load(getClass().getResource("/FXMLFreelancer/MenuClient.fxml")));
      //scene = new Scene(FXMLLoader.load(getClass().getResource("/FXMLFreelancer/TableauAnnonce.fxml")));
   //scene = new Scene(FXMLLoader.load(getClass().getResource("/FXMLFreelancer/menuAdmin.fxml")));
    
    }
     public static Template getInstance() {
        return instance;
    }

    public Stage getStage() {
        return stage;
    }
    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;

        stage.setScene(this.scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.centerOnScreen();
        stage.show();
    }
    
  public void changescene(Scene scene) {
        this.scene = scene;
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
