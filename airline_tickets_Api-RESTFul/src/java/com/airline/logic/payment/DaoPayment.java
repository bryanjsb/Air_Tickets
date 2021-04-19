/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.logic.payment;

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

public class DaoPayment implements java.io.Serializable {

    public boolean addPayment(Payment payment) {
        boolean insertado = false;
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm
                = cnx.prepareStatement(QueryPayment.CREATE.getQuery())) {

            stm.clearParameters();
            stm.setInt(1, payment.getCreditCardNumber());
            stm.setString(2, payment.getIdUser());
            stm.setInt(3, payment.getExpirationDay());
            stm.setInt(4, payment.getExpirationMonth());
            stm.setInt(5, payment.getCvvCard());

            if (stm.executeUpdate() != 1) {
                throw new SQLException();
            } else {
                insertado = true;
            }
        } catch (IOException | ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException ex) {
            Logger.getLogger(DaoPayment.class.getName()).log(Level.SEVERE, null, ex);
        }
        return insertado;
    }

    //callable statemet
    public Optional<Payment> getPaymentById(String id) {
        Optional<Payment> r = Optional.empty();
        try (Connection cnx = obtenerConexion();
                //   CallableStatement stm = cnx.prepareCall(QueryUser.PROCEDURE_GETUSER_ID.getQuery());) 
                PreparedStatement stm = cnx.prepareStatement(QueryPayment.GET_ID.getQuery())) {
            stm.clearParameters();
            stm.setString(1, id);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    r = Optional.of(new Payment(
                            rs.getInt("creditCardNumber"),
                            rs.getString("User_ID"),
                            rs.getInt("expirationDay"),
                            rs.getInt("expirationMonth"),
                            rs.getInt("cvv")
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

    public Optional<Payment> getUserByUser(String user) {
        Optional<Payment> r = Optional.empty();
        try (Connection cnx = obtenerConexion();
                //   CallableStatement stm = cnx.prepareCall(QueryUser.PROCEDURE_GETUSER_ID.getQuery());) 
                PreparedStatement stm = cnx.prepareStatement(QueryPayment.GET_USER.getQuery())) {
            stm.clearParameters();
            stm.setString(1, user);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    r = Optional.of(new Payment(
                            rs.getInt("creditCardNumber"),
                            rs.getString("User-ID"),
                            rs.getInt("expirationDay"),
                            rs.getInt("expirationMonth"),
                            rs.getInt("cvv")
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

    public boolean updatePayment(Payment payment) {
        boolean update = false;
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(QueryPayment.UPDATE.getQuery())) {

            stm.setInt(1, payment.getCreditCardNumber());
            stm.setString(2, payment.getIdUser());
            stm.setInt(3, payment.getExpirationDay());
            stm.setInt(4, payment.getExpirationMonth());
            stm.setInt(5, payment.getCvvCard());

            if (stm.executeUpdate() != 1) {
                throw new SQLException();
            } else {
                update = true;
            }

        } catch (IOException | ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException ex) {
            Logger.getLogger(DaoPayment.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            bd.closeConnection();
        }

        return update;
    }

    public boolean DeletePayment(String id) {
        boolean delete = false;
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(QueryPayment.DELETE.getQuery())) {

            System.out.println(id);
            stm.setString(1, id);

            if (stm.executeUpdate() != 1) {
                throw new SQLException();
            } else {
                delete = true;
            }

        } catch (IOException | ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException ex) {
            Logger.getLogger(DaoPayment.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            bd.closeConnection();
        }

        return delete;
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

    private DaoPayment() {
        try {
            this.bd = ConnectionDB.getInstance();
            bd.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DaoPayment.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }

    public static DaoPayment getInstance() {
        if (instancia == null) {
            instancia = new DaoPayment();
        }
        return instancia;
    }

    private static DaoPayment instancia = null;
    private ConnectionDB bd = null;
    // </editor-fold>

}
