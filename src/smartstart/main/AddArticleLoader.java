/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartstart.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author USER
 */
public class AddArticleLoader extends Application {
  public static  Stage primaryStage;
  public static  Parent parentPage;
    @Override
    public void start(Stage primaryStage) throws Exception {
        // primaryStage.initStyle(StageStyle.UNDECORATED);
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("FixIt !");
        
         parentPage = FXMLLoader.load(getClass().getResource(Routes.ArticleList));
       //parentPage = FXMLLoader.load(getClass().getResource(Routes.ArticleAdd));
        Scene scene = new Scene(parentPage,980,570);
        this.primaryStage.setScene(scene );
        this.primaryStage.show();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public static void Launch (){
        
    }
    
}