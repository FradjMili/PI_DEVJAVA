/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import utils.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Entities.Categorie;

/**
 *
 * @author Ala-y
 */
public class CategorieCRUD {

    private static CategorieCRUD instance;
    private Statement st;
    private ResultSet rs;
    
    public CategorieCRUD() {
        DataSource cs = DataSource.getInstance();
        try {
            st = cs.getConnection().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(CategorieCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static CategorieCRUD getInstance() {
        if (instance == null) {
            instance = new CategorieCRUD();
        }
        return instance;
    }
    
    Connection cnx = DataSource.getInstance().getConnection();

    public ObservableList<Categorie> getAllArticleCategories() throws SQLException {
        ObservableList<Categorie> list = FXCollections.observableArrayList();
        Statement st = cnx.createStatement();
        String req = "SELECT * FROM `categorie`";
        ResultSet rs = st.executeQuery(req);

        while (rs.next()) {
            Categorie cat = new Categorie();
            cat.setId(rs.getInt(1));
            cat.setNom(rs.getString(2));

            list.add(cat);
        }
        return list;
    }

    public ArrayList<Categorie> showAllCategories() {
        ArrayList<Categorie> l = new ArrayList<>();
        String req = "select * from categorie";
        Categorie s = new Categorie();
        try {
            System.out.println("okkkkkkkkkkkkkkkkkkk ");
            rs = st.executeQuery(req);

            while (rs.next()) {

                s = new Categorie(rs.getInt("id"), rs.getString("nom"));
                System.out.println(s.toString());
                l.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategorieCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }
}
