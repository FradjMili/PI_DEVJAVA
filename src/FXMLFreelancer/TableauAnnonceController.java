/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXMLFreelancer;
import Service.ServiceAnnonce;
import Entities.Annonce;
import com.sun.prism.impl.Disposer;
import entities.Produit;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class TableauAnnonceController implements Initializable {

    @FXML
    private TableView<Annonce> table_view;
    @FXML
    private TableColumn<Annonce,String> titre_col;
    @FXML
    private TableColumn<Annonce, String> Speciality_col;
    @FXML
    private TableColumn<Annonce, Integer> Salaire_col;
    @FXML
    private TableColumn<Annonce, String> datedebut_col;
    @FXML
    private TableColumn<Annonce, String> datefin_col;
    @FXML
    private TableColumn<Annonce, String> description_col;
    @FXML
    private Button supp;

    
    ServiceAnnonce ser=new ServiceAnnonce();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
         ObservableList<Annonce> list= FXCollections.observableArrayList();
        for (Annonce p:ser.listAnnonce())
        {
            list.add(p);
            
        }
      
        
 titre_col.setCellValueFactory(new PropertyValueFactory<>("titre"));
 Speciality_col.setCellValueFactory(new PropertyValueFactory<>("speciality"));
 //quantite_col.setCellValueFactory(new PropertyValueFactory<>("quantite"));
 Salaire_col.setCellValueFactory(new PropertyValueFactory<>("salaire"));
 datedebut_col.setCellValueFactory(new PropertyValueFactory<>("datedebut"));
 datefin_col.setCellValueFactory(new PropertyValueFactory<>("datefin"));
 description_col.setCellValueFactory(new PropertyValueFactory<>("description"));

        TableColumn col_action = new TableColumn<>("supprimer");
        table_view.getColumns().add(col_action);
        
        col_action.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Disposer.Record, Boolean>, 
                ObservableValue<Boolean>>() {

            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Disposer.Record, Boolean> p) {
                return new SimpleBooleanProperty(p.getValue() != null);
            }
        });

        //Adding the Button to the cell
        col_action.setCellFactory(
                new Callback<TableColumn<Disposer.Record, Boolean>, TableCell<Disposer.Record, Boolean>>() {

    
                    
             @Override
            public TableCell<Disposer.Record, Boolean> call(TableColumn<Disposer.Record, Boolean> p) {
                return new FXMLFreelancer.ButtonCell();
            }
        
        });
    
    
        
        TableColumn col_action2 = new TableColumn<>("modifier");
        table_view.getColumns().add(col_action2);
        
        col_action2.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Disposer.Record, Boolean>, 
                ObservableValue<Boolean>>() {

            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Disposer.Record, Boolean> p) {
                return new SimpleBooleanProperty(p.getValue() != null);
            }
        });

        //Adding the Button to the cell
        col_action2.setCellFactory(
                new Callback<TableColumn<Disposer.Record, Boolean>, TableCell<Disposer.Record, Boolean>>() {

    
                    
             @Override
            public TableCell<Disposer.Record, Boolean> call(TableColumn<Disposer.Record, Boolean> p) {
                return new FXMLFreelancer.ButtonCell_modifier();
            }
        
        });
    
        
        
        
        
        
        
        
        
     table_view.setItems(list);
    }    
    
}
