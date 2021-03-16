/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.airTicket.logic.Login;

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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoUser implements java.io.Serializable {

    public boolean addUser(User user) {
        boolean insertado = false;
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(QueryUser.CREATE.getQuery())) {

            stm.clearParameters();
            stm.setString(1, user.getUser());
            stm.setString(2, user.getPassword());
            stm.setString(3, user.getRole());

            if (stm.executeUpdate() != 1) {
                throw new SQLException();
            } else {
                insertado = true;
            }
        } catch (IOException | ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException ex) {
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return insertado;
    }

    public Optional<User> getUserById(String id) {
        Optional<User> r = Optional.empty();
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(QueryUser.READ.getQuery());) {
            stm.clearParameters();
            stm.setString(1, id);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    r = Optional.of(new User(
                            rs.getString("User"),
                            rs.getString("Password"),
                            rs.getString("Role")
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
    private Connection obtenerConexion() throws
            ClassNotFoundException,
            IllegalAccessException,
            InstantiationException,
            IOException,
            SQLException {
        bd = ConnectionDB.getInstance();
        Connection cnx = bd.getConnection();
        return cnx;
    }

    private DaoUser() {
        try {
            this.bd = ConnectionDB.getInstance();
            bd.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DaoUser.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }

    public static DaoUser obtenerInstancia() {
        if (instancia == null) {
            instancia = new DaoUser();
        }
        return instancia;
    }

    private static DaoUser instancia = null;
    private ConnectionDB bd = null;
    // </editor-fold>

    public static void main(String[] args) {
        DaoUser se = new DaoUser();
        //System.out.println("add User");
        //se.addUser(new User("bryanjsb", "123456", "Admin"));

        System.out.println("Get User");
        Optional<User> ptr = se.getUserById("bryanjsb");
        System.out.println(ptr.get());
    }
}
