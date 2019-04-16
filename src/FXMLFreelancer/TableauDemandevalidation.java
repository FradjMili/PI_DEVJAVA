/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXMLFreelancer;
import Service.ServiceAnnonce;
import Entities.Annonce;
import Entities.Demande;
import Service.ServiceDemande;
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
public class TableauDemandevalidation implements Initializable {

 
    
        ServiceDemande ser=new ServiceDemande();
    @FXML
    private TableColumn<Demande,String> Motivation_col;
    @FXML
    private TableView<Demande> table_view;
    @FXML
    private TableColumn<Demande, String> titre_col;
    @FXML
    private TableColumn<Demande,String> datedebut_col;
    @FXML
    private TableColumn<Demande,String> datefin_col;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
         ObservableList<Demande> list= FXCollections.observableArrayList();
        for (Demande p:ser.listDemande())
        {
            list.add(p);
            
        }
      
        
 titre_col.setCellValueFactory(new PropertyValueFactory<>("titre"));
 Motivation_col.setCellValueFactory(new PropertyValueFactory<>("motivation"));
 //quantite_col.setCellValueFactory(new PropertyValueFactory<>("quantite"));
 datedebut_col.setCellValueFactory(new PropertyValueFactory<>("datedebut"));
 datefin_col.setCellValueFactory(new PropertyValueFactory<>("datefin"));

        TableColumn col_action = new TableColumn<>("Valider");
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
                return new FXMLFreelancer.ButtonCell_valider_demande();
            }
        
        });
    
        
        
        
        
        
     table_view.setItems(list);
    }    
    
}
