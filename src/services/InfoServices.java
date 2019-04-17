package services;

//import static entities.FosUser_1_.infoG;
import entities.InfoG;
import static gui.NewFXMain.U2;
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
import tools.MyConnection;

public class InfoServices {

    Connection connection = null;

    public InfoServices() {
        connection = MyConnection.getInstance().getCnx();
    }

    public void ajouter(InfoG info) {
        String req = "INSERT INTO `Info_G`(`nom`, `prenom`,`date_nais`,`tele`,`adrMail`,`adresse`,`user_id`) VALUES (?,?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, info.getNom());
            preparedStatement.setString(2, info.getPrenom());
            preparedStatement.setDate(3, new java.sql.Date(info.getDateNais().getTime()));
            preparedStatement.setInt(4, info.getTele());
            preparedStatement.setString(5, info.getAdrMail());
            preparedStatement.setString(6, info.getAdresse());

            preparedStatement.setInt(7, info.getFosUser().getId());
            preparedStatement.execute();

            System.out.println("info ajouté ");

        } catch (SQLException ex) {

            Logger.getLogger(ReclamationServices.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void modifierInfo(InfoG info) throws SQLException {
        Statement st = connection.createStatement();
        String req = "UPDATE `info_g` SET `nom`=?,`prenom`=?,"
                + "`tele`=?,`adrMail`=?,`adresse`=?";

        PreparedStatement ste = connection.prepareStatement(req);

        ste.setString(1, info.getNom());
        ste.setString(2, info.getPrenom());
        //ste.setDate(3, (Date) info.getDateNais());
        ste.setInt(3, info.getTele());
        ste.setString(4, info.getAdrMail());
        ste.setString(5, info.getAdresse());
        //ste.setInt(6, info.getFosUser().getId());

        System.out.println(ste);
        ste.executeUpdate();

    }

    public InfoG afficherInfog() throws SQLException {

        Statement st = MyConnection.getInstance().getCnx()
                .createStatement();
        String req = "SELECT * FROM info_g  WHERE user_id='" + U2.getId() + "'";
        ResultSet rs = st.executeQuery(req);
        InfoG p = new InfoG();

        while (rs.next()) {

            p.setId(rs.getInt("id"));

            p.setNom(rs.getString(2));
            p.setPrenom(rs.getString(3));
            p.setDateNais(rs.getDate(4));
            p.setTele(rs.getInt(5));
            p.setAdrMail(rs.getString(6));
            p.setAdresse(rs.getString(7));

        }
        return p;

    }

    public void supprimerIN(int id) throws SQLException {

        Statement st = connection.createStatement();
        String req = "delete from info_g where id=" + id;
        st.executeUpdate(req);
        System.out.println("suppression ok");

    }
   
 

}
