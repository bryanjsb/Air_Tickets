/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.controller;

import com.airline.logic.InfoUser.InfoUser;
import com.airline.model.InfoUserModel;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author bryan
 */
@Path("/infoUser")
@Produces({MediaType.APPLICATION_JSON})
@Consumes(MediaType.APPLICATION_JSON)
public class InfoUserController {

    @GET
    @Path("{id}")
    public Response getInfoUserById(@PathParam("id") String id) {
        try {
            InfoUser i = model.getInfoUserByID(id);

            return Response.status(Response.Status.ACCEPTED).entity(i).build();
        } catch (Exception e) {
            String s = String.format("No existe el id %s", id);
            return Response.status(Response.Status.NOT_FOUND).entity(s).build();
        }

    }

    @POST
    @Path("/create")
    public Response createInfoUser(InfoUser info) {
        try {
            model.addInfoUser(info);
            return Response.status(Response.Status.CREATED)
                    .entity("Informacion Usuario Almacenado").build();
        } catch (Exception e) {
            return Response.status(Response.Status.CREATED)
                    .entity("Informacion Usuario no se pudo Almacenar").build();
        }
    }

    @PUT
    @Path("/update")
    public Response putInfoUser(InfoUser infoUser) {
        try {
            if (!model.updateInfoUser(infoUser)) {
                throw new Exception("Información del Usuario NO se pudo  Actualizar");
            }
            return Response.status(Response.Status.ACCEPTED).
                    entity("Información del Usuario Actualizado").build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_MODIFIED).
                    entity(e.getMessage()).build();
        }

    }

    private final InfoUserModel model = InfoUserModel.getInstance();
}
