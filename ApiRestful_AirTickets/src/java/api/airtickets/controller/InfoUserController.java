/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.airtickets.controller;

import api.airtickets.logic.InfoUser.InfoUser;
import api.airtickets.model.InfoUserModel;
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
public class InfoUserController {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("{id}")
    public InfoUser getInfoUserById(@PathParam("id") String id) {
        return model.getInfoUserByID(id);
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createInfoUser(InfoUser info) {
        if (model.addInfoUser(info)) {
            return Response.status(Response.Status.CREATED)
                    .entity("Informacion Usuario Almacenado").build();
        }

        return Response.status(Response.Status.CREATED)
                .entity("Informacion Usuario no se pudo Almacenar").build();
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)    
    @Produces(MediaType.APPLICATION_JSON)
    public Response putInfoUser(InfoUser infoUser) {
        if (model.updateInfoUser(infoUser)) {
            return Response.status(Response.Status.OK).
                    entity("Información del Usuario Actualizado").build();
        }
        return Response.status(Response.Status.NOT_MODIFIED).
                entity("Información del Usuario NO Se pudo  Actualizar").build();
    }

    private final InfoUserModel model = new InfoUserModel();
}
