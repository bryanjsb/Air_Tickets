/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.logic.vuelo;

/**
 *
 * @author bryan
 */
public enum QueryVuelo {

    //QUERIES
    LISTAR("SELECT idvuelo, origen, destino, fechaIda, fechaRegreso,"
            + " cantidadPasajeros, descuento FROM Vuelo"
            + " ORDER BY idVuelo; ");

    QueryVuelo(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    private final String query;
}
