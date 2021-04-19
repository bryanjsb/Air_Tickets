/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.controller;

import com.airline.model.VueloModel;
import com.google.gson.Gson;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Bryan
 */
@Path("/vuelo")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class VueloController {

    @GET
    @Path("/listaVuelos")
    public Response listaVuelos() {
        ArrayList lista = (ArrayList) model.listaVuelos();
        System.out.println(lista);
        String json = gson.toJson(lista);
        return Response.status(200).entity(json).build();
    }

    final Gson gson = new Gson();
    private final VueloModel model = VueloModel.getInstance();
}
