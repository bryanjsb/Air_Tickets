/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.logic.vuelo;

import cr.ac.database.connection.ConnectionDB;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bryan
 */
public class DaoVuelo {

    public List<Vuelo> obtenerListaVuelo() {
        List<Vuelo> r = new ArrayList<>();
        try (Connection cnx = getConnection();
                Statement stm = cnx.createStatement();
                ResultSet rs = stm.executeQuery(QueryVuelo.LISTAR.getQuery())) {
            while (rs.next()) {
                Vuelo e = new Vuelo(
                        rs.getInt("idVuelo"),
                        rs.getString("origen"),
                        rs.getString("destino"),
                        rs.getDate("fechaIda"),
                        rs.getDate("fechaRegreso"),
                        rs.getInt("cantidadPasajeros"),
                        rs.getInt("descuento")
                );
                r.add(e);
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

    private DaoVuelo() {
        try {
            this.bd = ConnectionDB.getInstance();
            bd.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DaoVuelo.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }

    public static DaoVuelo getInstance() {
        if (instancia == null) {
            instancia = new DaoVuelo();
        }
        return instancia;
    }

    private static DaoVuelo instancia = null;
    private ConnectionDB bd = null;
    // </editor-fold>
}
