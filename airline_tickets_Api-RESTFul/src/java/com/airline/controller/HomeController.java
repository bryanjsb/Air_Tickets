/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.controller;

/**
 *
 * @author bryan
 */
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationPath("/")
@Path("/")
public class HomeController extends Application {

    @GET
    public Response aboutAirTicketProject() {
        return Response.ok("Api restful "
                + "para la gestion de boletos de avión "
                + "Integrante: "
                + "Bryan Sánchez Brenes. ", MediaType.APPLICATION_JSON).build();
    }
}
