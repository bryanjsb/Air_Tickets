/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.logic.InfoUser;

/**
 *
 * @author bryan
 */
import com.airline.logic.InfoUser.InfoUser;
import com.airline.logic.InfoUser.QueryInfoUser;
import com.airline.logic.User.DaoUser;
import com.airline.logic.User.QueryUser;
import cr.ac.database.connection.ConnectionDB;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.conversion.DateConversion;

public class DaoInfoUser implements java.io.Serializable {

    public boolean addInfoUser(InfoUser info) {
        boolean insertado = false;
        try (Connection cnx = getConnection();
                PreparedStatement stm = cnx.prepareStatement(QueryInfoUser.CREATE.getQuery())) {
            System.out.println(info);
            stm.clearParameters();
            stm.setString(1, info.getId());
            stm.setString(2, info.getName());
            stm.setString(3, info.getLastName());
            stm.setString(4, info.getEmail());
            stm.setTimestamp(5, DateConversion.util2Timestamp((java.util.Date) info.getDateBirthDay()));
            stm.setString(6, info.getAddress());
            stm.setInt(7, info.getPhoneWork());
            stm.setInt(8, info.getCellphone());

            if (stm.executeUpdate() != 1) {
                throw new SQLException();
            } else {
                insertado = true;
            }
        } catch (IOException | ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException ex) {
            Logger.getLogger(DaoInfoUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return insertado;
    }

    public Optional<InfoUser> getInfoUserById(String id) {
        Optional<InfoUser> r = Optional.empty();
        try (Connection cnx = getConnection();
                PreparedStatement stm
                = cnx.prepareStatement(QueryInfoUser.GET_BY_ID.getQuery())) //CallableStatement stm = cnx.prepareCall(QueryInfoUser.READ.getProcedure());) 
        {
            stm.clearParameters();
            stm.setString(1, id);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    r = Optional.of(new InfoUser(
                            rs.getString("User_ID"),
                            rs.getString("Name"),
                            rs.getString("LastName"),
                            rs.getString("email"),
                            rs.getDate("DateBirthday"),
                            rs.getString("Address"),
                            rs.getInt("PhoneWork"),
                            rs.getInt("CellPhone")
                    ));
                }
            }
            System.out.println(r);
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

    public boolean updateInfoUser(InfoUser infoUser) {
        boolean update = false;
        System.out.println(infoUser);
        try (Connection cnx = getConnection();
                PreparedStatement stm
                = cnx.prepareStatement(QueryInfoUser.UPDATE.getQuery())) {

            stm.setString(1, infoUser.getName());
            stm.setString(2, infoUser.getLastName());
            stm.setString(3, infoUser.getEmail());
            stm.setTimestamp(4, DateConversion
                    .util2Timestamp((java.util.Date) infoUser.getDateBirthDay()));
            stm.setString(5, infoUser.getAddress());
            stm.setInt(6, infoUser.getPhoneWork());
            stm.setInt(7, infoUser.getCellphone());
            stm.setString(8, infoUser.getId());

            if (stm.executeUpdate() != 1) {
                throw new SQLException();
            } else {
                update = true;
            }

        } catch (IOException | ClassNotFoundException
                | IllegalAccessException | InstantiationException
                | SQLException ex) {
            Logger.getLogger(DaoInfoUser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            bd.closeConnection();
        }

        return update;
    }

    public boolean verifyID(String id) {
        boolean verify = false;
        try (Connection cnx = getConnection();
                PreparedStatement stm
                = cnx.prepareStatement(QueryInfoUser.VERIFY_ID.getQuery())) {

            stm.clearParameters();
            stm.setString(1, id);

            ResultSet rs = stm.executeQuery();

            verify = rs.next();

        } catch (IOException | ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException ex) {
            Logger.getLogger(DaoInfoUser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            bd.closeConnection();
        }

        return verify;
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
