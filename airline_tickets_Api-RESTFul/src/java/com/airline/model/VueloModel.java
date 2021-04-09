/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.model;

import com.airline.logic.vuelo.DaoVuelo;
import com.airline.logic.vuelo.Vuelo;
import java.util.List;

/**
 *
 * @author Bryan
 */
public class VueloModel {

    public List<Vuelo> listaVuelos() {
        return dao.obtenerListaVuelo();
    }

    private VueloModel() {
        dao = DaoVuelo.getInstance();
    }

    public static VueloModel getInstance() {
        return model == null ? model = new VueloModel() : model;
    }

    private static VueloModel model = null;
    private final DaoVuelo dao;
}
