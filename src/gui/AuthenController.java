package gui;

import entities.FosUser;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.mindrot.jbcrypt.BCrypt;
import services.UserServices;
import static gui.NewFXMain.U2;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class AuthenController implements Initializable {

    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private Button sign;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void signin(ActionEvent event) throws IOException {

        String email = username.getText();
        String pass = password.getText();

        ArrayList<FosUser> users = new ArrayList<>();
        UserServices CU = new UserServices();
        users = CU.afficherUtilisateur();
        if (!email.equals("") && !pass.equals("")) {
            for (int i = 0; i < users.size(); i++) {
                //System.out.print(users.get(i).getPassword());

                if ((users.get(i).getEmail().equalsIgnoreCase(email))
                        && BCrypt.checkpw(pass, users.get(i).getPassword().replaceFirst("y", "a"))
                        || (users.get(i).getUsername().equalsIgnoreCase(email)) && BCrypt.checkpw(pass, users.get(i).getPassword().replaceFirst("y", "a"))) {
                    //  U2 = new FosUser();
                    U2 = users.get(i);
                    System.out.print(U2);

                    // bub.setVisible(false);
                    System.out.println(users.get(i).getRoles());
                    if (users.get(i).getRoles().equals("Admin")) {
                        System.out.println("redirected to admin panel");

                        FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherRec.fxml"));
                        Parent root = (Parent) loader.load();
                        AfficherRecController adm = loader.getController();

                        //hide actual window
                        final Node source = (Node) event.getSource();
                        final Stage stage = (Stage) source.getScene().getWindow();
                        stage.close();

                        //Show next window
                        Scene newScene = new Scene(root);
                        Stage newStage = new Stage();
                        newStage.setScene(newScene);
                        newStage.show();
                    } else if (users.get(i).getRoles().equals("user")) {
                        // bub.setVisible(false);
                        // System.out.println("user");
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
                        Parent root = (Parent) loader.load();
                        HomeController cl = loader.getController();

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

                } else {
                    username.clear();
                    password.clear();
                    //System.out.println("Invalide"); 
                    // label1.setVisible(true);
                    //    bub.setVisible(true);
                }
            }
        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("login & mdp vide");

            alert.showAndWait();
            //JOptionPane.showMessageDialog(null, "Java is fun!");
            //System.out.println("aaaaaaaaaaaaaaa");
            // label1.setVisible(true);
            //bub.setVisible(true);
        }
    }

}
