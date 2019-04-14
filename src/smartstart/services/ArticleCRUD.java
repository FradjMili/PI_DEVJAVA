/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartstart.services;

import SmartStart.utils.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import smartstart.entities.Article;

/**
 *
 * @author Ala-y
 */
public class ArticleCRUD {

    Connection cnx = DataSource.getInstance().getConnection();
    Connection connection = null;

    public ArticleCRUD() {
        connection = DataSource.getInstance().getConnection();
    }

    public void Ajouter(Article article) {
        String req = "INSERT INTO `article`(`titre`, `auteur`, `description`, `dateCreation`, `dateEdition`, `image`, "
                + "`categorie_id`, `updated_at`, `contenu`)"
                + " VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedstatement = connection.prepareStatement(req);
            preparedstatement.setString(1, article.getTitre());
            preparedstatement.setString(2, article.getAuteur());
            preparedstatement.setString(3, article.getDescription());
            preparedstatement.setDate(4, article.getDateCreation());
            preparedstatement.setDate(5, article.getDateEdition());
            preparedstatement.setString(6, article.getImage());
            preparedstatement.setInt(7, article.getCategorieId());
            preparedstatement.setDate(8, article.getUpdatedAt());
            preparedstatement.setString(9, article.getContenu());

            preparedstatement.execute();
            System.out.println("Article addded");
        } catch (SQLException ex) {
            Logger.getLogger(ArticleCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ObservableList<Article> AfficherAllArticles() {
        String query = "SELECT * FROM article ORDER BY titre, dateEdition DESC";
        ObservableList<Article> ServiceObservableList = FXCollections.observableArrayList();;
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Integer aID = rs.getInt("id");
                String aTitle = rs.getString("titre");
                String aAuthor = rs.getString("auteur");
                String aDescription = rs.getString("description");
                Date aDateCreation = rs.getDate("dateCreation");
                Date aDateEdition = rs.getDate("dateEdition");
                String aImage = rs.getString("image");
                Integer aCategorie = rs.getInt("categorie_id");
                Date aUpdateAt = rs.getDate("updated_at");
                String aContenu = rs.getString("contenu");

                Article article = new Article(aTitle, aAuthor, aDescription, aDateCreation, aDateEdition, aImage, aUpdateAt, aContenu, aCategorie);
                article.setId(aID);
                ServiceObservableList.add(article);

            }
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(ArticleCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ServiceObservableList;
    }

    public void Update(Article article) {

        String query = "UPDATE article SET titre=?,auteur=?,description=?,"
                + "dateEdition=? ,image=?,categorie_id=?,"
                + "`contenu`=? WHERE id=?";
        try {

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, article.getTitre());
            statement.setString(2, article.getAuteur());
            statement.setString(3, article.getDescription());
            statement.setDate(4, article.getDateEdition());
            statement.setString(5, article.getImage());
            statement.setInt(6, article.getCategorieId());
            //  statement.setDate(5, article.getUpdatedAt());
            statement.setString(7, article.getContenu());
            statement.setInt(8, article.getId());

            System.out.println(article.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ArticleCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void Supprimer(Article article) {
        /*String req1 = "ALTER TABLE commentaire__blog \n"
                + "DROP FOREIGN KEY IDX_18BCE9447294869C";*/
        String query = "DELETE FROM `article` WHERE id=?";
        //String req = "DELETE article,commentaire__blog FROM article INNER JOIN commentaire__blog \n"
        //      + "ON commentaire__blog= article_id WHERE article.id = ?";
        try {
            PreparedStatement statement;
            statement = connection.prepareStatement(query);
            statement.setInt(1, article.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ArticleCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
//If we delete the Item with id it won't work because we have show the id in the table view 
//it's connected to the DBB but it depends on what we show in the table view
/*  try {
            String deleteStatement = "DELETE FROM `article` WHERE `article`.`id` = ?";
            PreparedStatement stmt = cnx.prepareStatement(deleteStatement);
            stmt.setInt(1, article.getId());
            int res = stmt.executeUpdate();
            System.out.println(res);
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(ArticleCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }*/
