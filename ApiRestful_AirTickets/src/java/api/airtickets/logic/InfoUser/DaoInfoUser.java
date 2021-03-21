/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.airtickets.logic.InfoUser;

/**
 *
 * @author bryan
 */
import cr.ac.database.connection.ConnectionDB;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoInfoUser implements java.io.Serializable {

    public Optional<InfoUser> getInfoUserById(String id) {
        Optional<InfoUser> r = Optional.empty();
        try (Connection cnx = getConnection();
                PreparedStatement stm = cnx.prepareStatement(QueryInfoUser.READ.getQuery())) //CallableStatement stm = cnx.prepareCall(QueryInfoUser.READ.getProcedure());) 
        {
            stm.clearParameters();
            stm.setString(1, id);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    r = Optional.of(new InfoUser(
                            rs.getString("ID"),
                            rs.getString("Name"),
                            rs.getString("LastName"),
                            rs.getString("e-mail"),
                            rs.getDate("DateBirthday"),
                            rs.getString("Address"),
                            rs.getInt("PhoneWork"),
                            rs.getInt("CellPhone")
                    ));
                }
            }
        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        } finally {
            bd.closeConnection();
        }
        return r;
    }

    // <editor-fold defaultstate="collapsed" desc="CONNECTION. Click on the + sign on the left to edit the code.">
    private Connection getConnection() throws
            ClassNotFoundException,
            IllegalAccessException,
            InstantiationException,
            IOException,
            SQLException {
        bd = ConnectionDB.getInstance();
        Connection cnx = bd.getConnection();
        return cnx;
    }

    private DaoInfoUser() {
        try {
            this.bd = ConnectionDB.getInstance();
            bd.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DaoInfoUser.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }

    public static DaoInfoUser getInstance() {
        if (instance == null) {
            instance = new DaoInfoUser();
        }
        return instance;
    }

    private static DaoInfoUser instance = null;
    private ConnectionDB bd = null;
    // </editor-fold>

}
