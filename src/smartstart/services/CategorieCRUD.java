/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartstart.services;

import SmartStart.utils.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import smartstart.entities.Categorie;

/**
 *
 * @author Ala-y
 */
public class CategorieCRUD {

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
}
