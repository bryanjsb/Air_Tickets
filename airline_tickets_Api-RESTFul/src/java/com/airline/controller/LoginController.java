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
import com.airline.logic.User.User;
import com.airline.model.LoginModel;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/sign")
public class LoginController {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("{id}")
    public User getUserById(@PathParam("id") String id) {
        return model.getUserById(id);
    }

    @POST
    @Path("/in")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response auth(@PathParam("id") String id) {
        return Response.accepted().build();
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response creatUser(User user) {
        model.addUser(user);

        return Response.status(Response.Status.OK).entity("Usuario Creado").build();
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(User user) {
        String ok = model.updateUser(user) ? "Usuario Actualizado"
                : "NO se actualizo el usuario";
        return Response.status(Response.Status.OK).entity(ok).build();
    }

    @DELETE
    @Path("/delete/{id}")
    public Response deleteUserById(@PathParam("id") String id) {
        String ok = model.deleteUser(id) ? "Usuario eliminado" : "NO se elimino el usuario";
        return Response.status(Response.Status.OK).entity(ok).build();
    }

    private final LoginModel model = LoginModel.getInstance();
}
