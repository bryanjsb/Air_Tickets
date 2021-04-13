/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.logic.User;

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

public class DaoUser implements java.io.Serializable {

    public boolean addUser(User user) {
        boolean insertado = false;
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(QueryUser.CREATE.getQuery())) {

            stm.clearParameters();
            stm.setString(1, user.getId());
            stm.setString(2, user.getUser());
            stm.setString(3, user.getPassword());
            stm.setString(4, user.getRole());

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

    //callable statemet
    public Optional<User> getUserById(String id) {
        Optional<User> r = Optional.empty();
        try (Connection cnx = obtenerConexion();
                //   CallableStatement stm = cnx.prepareCall(QueryUser.PROCEDURE_GETUSER_ID.getQuery());) 
                PreparedStatement stm = cnx.prepareStatement(QueryUser.GET_ID.getQuery())) {
            stm.clearParameters();
            stm.setString(1, id);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    r = Optional.of(new User(
                            rs.getString("Id"),
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

    public Optional<User> getUserByUser(String user) {
        Optional<User> r = Optional.empty();
        try (Connection cnx = obtenerConexion();
                //   CallableStatement stm = cnx.prepareCall(QueryUser.PROCEDURE_GETUSER_ID.getQuery());) 
                PreparedStatement stm = cnx.prepareStatement(QueryUser.GET_USER.getQuery())) {
            stm.clearParameters();
            stm.setString(1, user);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    r = Optional.of(new User(
                            rs.getString("Id"),
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

    public boolean updateUser(User user) {
        boolean update = false;
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(QueryUser.UPDATE.getQuery())) {

            stm.setString(1, user.getUser());
            stm.setString(2, user.getPassword());
            stm.setString(3, user.getRole());
            stm.setString(4, user.getId());

            if (stm.executeUpdate() != 1) {
                throw new SQLException();
            } else {
                update = true;
            }

        } catch (IOException | ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException ex) {
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            bd.closeConnection();
        }

        return update;
    }

    public boolean DeleteUser(String id) {
        boolean delete = false;
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(QueryUser.DELETE.getQuery())) {

            System.out.println(id);
            stm.setString(1, id);

            if (stm.executeUpdate() != 1) {
                throw new SQLException();
            } else {
                delete = true;
            }

        } catch (IOException | ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException ex) {
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            bd.closeConnection();
        }

        return delete;
    }

    public boolean verifyAuth(String user, String pass) {
        boolean verify = false;
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm
                = cnx.prepareStatement(QueryUser.VERIFY_AUTH.getQuery())) {

            stm.clearParameters();
            stm.setString(1, user);
            stm.setString(2, pass);

            System.out.println(user);
            System.out.println(pass);
            ResultSet rs = stm.executeQuery();

            verify = rs.next();

        } catch (IOException | ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException ex) {
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            bd.closeConnection();
        }

        return verify;
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

    public static DaoUser getInstance() {
        if (instancia == null) {
            instancia = new DaoUser();
        }
        return instancia;
    }

    private static DaoUser instancia = null;
    private ConnectionDB bd = null;
    // </editor-fold>

}
