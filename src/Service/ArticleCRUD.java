/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import utils.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Entities.Article;

/**
 *
 * @author Ala-y
 */
public class ArticleCRUD {

    Connection cnx = DataSource.getInstance().getConnection();
    Connection connection = null;
    DataSource connexion;

    private static ArticleCRUD instance;
    private Statement st;
    private ResultSet rs;

    public ArticleCRUD() {
        DataSource cs = DataSource.getInstance();
        try {
            st = cs.getConnection().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ArticleCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ArticleCRUD getInstance() {
        if (instance == null) {
            instance = new ArticleCRUD();
        }
        return instance;
    }

    public void Ajouter(Article article) {

        String req = "INSERT INTO `article`(`titre`, `auteur`, `description`, `dateCreation`, `dateEdition`, `image`,"
                + "`categorie_id`, `updated_at`, `contenu`)"
                + " VALUES ("
                //+ "'" + article.getId()+ "',"
                + "'" + article.getTitre() + "',"
                + "'" + article.getAuteur() + "',"
                + "'" + article.getDescription() + "',"
                + "'" + article.getDateCreation() + "',"
                + "'" + article.getDateEdition() + "',"
                + "'" + article.getImage() + "',"
                + "'" + article.getCategorieId() + "',"
                + "'" + article.getUpdatedAt() + "',"
                + "'" + article.getContenu() + "'"
                + ")";
        try {
            st.executeUpdate(req);
            System.out.println("Demande bien ajouter ");
        } catch (SQLException ex) {
            Logger.getLogger(ArticleCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Article> showAllServices() {
        ArrayList<Article> l = new ArrayList<>();
        String req = "select * from article ORDER BY `article`.`dateEdition` DESC";
        Article s = new Article();
        try {
            System.out.println("okkkkkkkkkkkkkkkkkkk ");
            rs = st.executeQuery(req);

            while (rs.next()) {

                s = new Article(rs.getString("titre"), rs.getString("auteur"), rs.getString("description"), rs.getDate("dateCreation"),
                        rs.getDate("dateEdition"), rs.getString("image"), rs.getDate("updated_at"), rs.getString("contenu"),
                        rs.getInt("categorie_id"));
                s.setId(rs.getInt("id"));
                System.out.println(s.toString());
                l.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArticleCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

    /*public void Supprimer(Article article) {
        /*String req1 = "ALTER TABLE commentaire__blog \n"
                + "DROP FOREIGN KEY IDX_18BCE9447294869C";*/
    //String query = "DELETE FROM `article` WHERE id=?";
    //String req = "DELETE article,commentaire__blog FROM article INNER JOIN commentaire__blog \n"
    //      + "ON commentaire__blog= article_id WHERE article.id = ?";

    /*   try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, article.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ArticleCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    public void delete(int id) {
        String req = "delete from article where id=" + id;
        try {
            st.executeUpdate(req);
            System.out.println("Demande bien supprimer ");
        } catch (SQLException ex) {
            Logger.getLogger(ArticleCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//To recup the categorie not in a list like in the comboBox but as a single String
//So Useful =D 
    public String getCategories(int id) {
        String query = "SELECT * FROM `categorie` WHERE id=" + id;
        String cNom = "";
        try {
            System.out.println("catttttttttttttttt ");
            rs = st.executeQuery(query);
            if (rs.next()) {
                cNom = rs.getString("nom");

            }
        } catch (SQLException ex) {
            Logger.getLogger(ArticleCRUD.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erreur getCategories");
        }
        return cNom;
    }

    public void update(Article article) {
        System.out.println("--------->" + article.getDateCreation());
        article.setDateEdition(Date.valueOf(LocalDate.now()));
        article.setUpdatedAt(Date.valueOf(LocalDate.now()));
        String query = "update article set titre='" + article.getTitre()
                + "',auteur='" + article.getAuteur() + "',description='" + article.getDescription() + "',dateEdition='" + article.getDateEdition()
                + "',image='" + article.getImage() + "',categorie_id=" + article.getCategorieId() + ",updated_at='" + article.getUpdatedAt()
                + "',contenu='" + article.getContenu() + "'";

        try {

            st.executeUpdate(query);
            System.out.println("Modifier avec succees");
        } catch (SQLException ex) {
            Logger.getLogger(ArticleCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Article show(int id) {
        String req = "select * from article where id=" + id;
        Article article = new Article();
        try {
            System.out.println("okkkkkkkkkkkkkkkkkkk ");
            rs = st.executeQuery(req);

            while (rs.next()) {
                article = new Article(rs.getString("titre"), rs.getString("auteur"), rs.getString("description"), rs.getDate("dateCreation"),
                        rs.getDate("dateEdition"), rs.getString("image"), rs.getDate("updated_at"), rs.getString("contenu"),
                        rs.getInt("categorie_id"));
                article.setId(id);
            }
            System.out.println(article.toString());
            System.out.println("Demande by id ok ");
        } catch (SQLException ex) {
            Logger.getLogger(ArticleCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return article;
    }

}
