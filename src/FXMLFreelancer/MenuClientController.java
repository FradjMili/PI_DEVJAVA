/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXMLFreelancer;

import client.Client;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.io.IOException;
import java.net.ConnectException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import java.util.logging.Logger;
import java.util.logging.Level;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import server.Server;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class MenuClientController implements Initializable {

    @FXML
    private BorderPane BorderPane;
    @FXML
    private Text nbr;
    @FXML
    private FontAwesomeIconView notif;
    @FXML
    private Text user;
    public static int k=0;
 TextField nameField= new TextField("fraj");

    public static ArrayList<Thread> threads;

    public static int page=0;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    if (page==1)
    {
        LoadUI("TableauDemandevalidation");
        page=0;
    }
    }    

    @FXML
    private void ToHome(MouseEvent event) {
    }

    @FXML
    private void notification(MouseEvent event) {
    }

    @FXML
    private void Profile(MouseEvent event) {
    }
    
    
    public void LoadUI(String ui)
    {
        Parent root= null;
        try {
                             

            root= FXMLLoader.load(getClass().getResource("/FXMLFreelancer/"+ui+".fxml"));
        } catch (IOException ex) {
            Logger.getLogger(MenuClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
        BorderPane.setCenter(root);
        
    }

    
    
    
    @FXML
    private void AjoutAnnonce(MouseEvent event) {
        LoadUI("AjouterAnnonce");
    }

    @FXML
    private void AfficheP(MouseEvent event) {
                LoadUI("TableauAnnonce");
    }

    @FXML
    private void mesDemandes(MouseEvent event) {
              LoadUI("TableauDemandevalidation");
        
    }

   
       
    public Scene makePortUI(Stage primaryStage) {
		/* Make the root and set properties */
		GridPane rootPane = new GridPane();
		rootPane.setPadding(new Insets(20));
		rootPane.setVgap(10);
		rootPane.setHgap(10);
		rootPane.setAlignment(Pos.CENTER);

		/* Text label and field for port Number */
		Text portText = new Text("Port Number");
		Label errorLabel = new Label();
		errorLabel.setTextFill(Color.RED);
		TextField portTextField = new TextField("8888");
                portTextField.setDisable(true);
		portText.setFont(Font.font("Tahoma"));
		/*
		 * "Done" button and its click handler When clicked, another method is
		 * called
		 */
		Button portApprovalButton = new Button("Activer server");
		portApprovalButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				/* Make the server and it's thread, and run it */
				try {
					Server server = new Server(Integer.parseInt(portTextField
							.getText()));
					Thread serverThread = (new Thread(server));
					serverThread.setName("Server Thread");
					serverThread.setDaemon(true);
					serverThread.start();
					threads.add(serverThread);
					/* Change the view of the primary stage */
					primaryStage.hide();
					primaryStage.setScene(makeServerUI(server));
					primaryStage.show();
				}catch(IllegalArgumentException e){
					errorLabel.setText("Invalid port number");
				} catch (IOException ex) {
                            }
				
			}
		});
		
		/* Add the views to the pane */
		rootPane.add(portText, 0, 0);
		rootPane.add(portTextField, 0, 1);
		rootPane.add(portApprovalButton, 0, 2);
		rootPane.add(errorLabel, 0, 3);
		/*
		 * Make the Scene and return it Scene has constructor (Parent, Width,
		 * Height)
		 */
		return new Scene(rootPane, 400, 300);
	}
	public Scene makeServerUI(Server server){
		/* Make the root pane and set properties */
		GridPane rootPane = new GridPane();
		rootPane.setAlignment(Pos.CENTER);
		rootPane.setPadding(new Insets(20));
		rootPane.setHgap(10);
		rootPane.setVgap(10);
		
		/* Make the server log ListView */
		Label logLabel = new Label("Server Log");
		ListView<String> logView = new ListView<String>();
		ObservableList<String> logList = server.serverLog;
		logView.setItems(logList);
		
		/* Make the client list ListView */
		Label clientLabel = new Label("Clients Connected");
		ListView<String> clientView = new ListView<String>();
		ObservableList<String> clientList = server.clientNames;
		clientView.setItems(clientList);
		
		/* Add the view to the pane */
		rootPane.add(logLabel, 0, 0);
		rootPane.add(logView, 0, 1);
		rootPane.add(clientLabel, 0, 2);
		rootPane.add(clientView, 0, 3);
		
		/* Make scene and return it,
		 * Scene has constructor (Parent, Width, Height)
		 *  */
                
                
		return new Scene(rootPane, 400, 600);
	}
     
    @FXML
    private void chat(MouseEvent event) {
   Stage primaryStage = new Stage();
        threads = new ArrayList<Thread>();
		primaryStage.setTitle("Serveur admin");
		primaryStage.setScene(makePortUI(primaryStage));
		primaryStage.show();
        
        
        
    }
    
    
      @FXML
    private void chat2(MouseEvent event) {
        
          Stage primaryStage = new Stage();
        threads = new ArrayList<Thread>();
		primaryStage.setTitle("Messenger");
		primaryStage.setScene(makeInitScene(primaryStage));
		primaryStage.show();
        
    }
//chat2
   public Scene makeInitScene(Stage primaryStage) {
		/* Make the root pane and set properties */
		GridPane rootPane = new GridPane();
		rootPane.setPadding(new Insets(20));
		rootPane.setVgap(10);
		rootPane.setHgap(10);
		rootPane.setAlignment(Pos.CENTER);
		/* Make the text fields and set properties */
	if(k==0)
        {   nameField = new TextField("fraj");
        k=k+1;
         }  
        else{
     nameField = new TextField("firas");
         }   
        
		TextField hostNameField = new TextField("localhost");
		TextField portNumberField = new TextField("8888");
                hostNameField.setDisable(true);
                portNumberField.setDisable(true);
                nameField.setDisable(true);
		/* Make the labels and set properties */
		Label nameLabel = new Label("Nom: ");
		Label hostNameLabel = new Label("HostName");
		Label portNumberLabel = new Label("PortNumber");
		Label errorLabel = new Label();
		/* Make the button and its handler */
		Button submitClientInfoButton = new Button("Connecter");
		submitClientInfoButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent Event) {
				// TODO Auto-generated method stub
				/* Instantiate the client class and start it's thread */
				Client client;
				try {
					client = new Client(hostNameField.getText(), Integer
							.parseInt(portNumberField.getText()), nameField
							.getText());
					Thread clientThread = new Thread(client);
					clientThread.setDaemon(true);
					clientThread.start();
					threads.add(clientThread);
					
					/* Change the scene of the primaryStage */
					primaryStage.close();
					primaryStage.setScene(makeChatUI(client));
					primaryStage.show();
				}
				catch(ConnectException e){
					errorLabel.setTextFill(Color.RED);
					errorLabel.setText("Le serveur est fermer revenez plus tard");
				}
				catch (NumberFormatException | IOException e) {
					// TODO Auto-generated catch block
					errorLabel.setTextFill(Color.RED);
					errorLabel.setText("Le serveur est fermer revenez plus tard");
				}
				
			}
		});

		/*
		 * Add the components to the root pane arguments are (Node, Column
		 * Number, Row Number)
		 */
		rootPane.add(nameField, 0, 0);
		rootPane.add(nameLabel, 1, 0);
		rootPane.add(hostNameField, 0, 1);
		rootPane.add(hostNameLabel, 1, 1);
		rootPane.add(portNumberField, 0, 2);
		rootPane.add(portNumberLabel, 1, 2);
		rootPane.add(submitClientInfoButton, 0, 3, 2, 1);
		rootPane.add(errorLabel, 0, 4);
		/* Make the Scene and return it */
		return new Scene(rootPane, 400, 400);
	}


   
   
    public Scene makeChatUI(Client client) {
		/* Make the root pane and set properties */
		GridPane rootPane = new GridPane();
		rootPane.setPadding(new Insets(20));
		rootPane.setAlignment(Pos.CENTER);
		rootPane.setHgap(10);
		rootPane.setVgap(10);

		/*
		 * Make the Chat's listView and set it's source to the Client's chatLog
		 * ArrayList
		 */
		ListView<String> chatListView = new ListView<String>();
		chatListView.setItems(client.chatLog);

		/*
		 * Make the chat text box and set it's action to send a message to the
		 * server
		 */
		TextField chatTextField = new TextField();
		chatTextField.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				client.writeToServer(chatTextField.getText());
				chatTextField.clear();
             
			}
		});
 
  
		/* Add the components to the root pane */
		rootPane.add(chatListView, 0, 0);
		rootPane.add(chatTextField, 0, 1);

		/* Make and return the scene */
		return new Scene(rootPane, 400, 400);

	}
        
        




}
