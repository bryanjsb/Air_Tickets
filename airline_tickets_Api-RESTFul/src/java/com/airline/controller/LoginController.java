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
@Produces({MediaType.APPLICATION_JSON})
@Consumes(MediaType.APPLICATION_JSON)
public class LoginController {

    @GET
    @Path("/getId/{id}")
    public Response getUserById(@PathParam("id") String id) {
        try {
            User u = model.getUserById(id);
            return Response.status(Response.Status.ACCEPTED).entity(u).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_ACCEPTABLE).entity("No existe el usuario").build();
        }
    }

    @GET
    @Path("/getUser/{user}")
    public Response getUserByUser(@PathParam("user") String user) {
        try {
            User u = model.getUserByUser(user);
            return Response.status(Response.Status.ACCEPTED).entity(u).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_ACCEPTABLE).entity("No existe el usuario").build();
        }
    }

    @POST
    @Path("/in")
    public Response verifyAuth(User user) {
        System.out.println();
        return model.verifyAuth(user.getUser(), user.getPassword()) ? Response.status(Response.Status.ACCEPTED)
                .entity("Usuario Autenticado").build()
                : Response.status(Response.Status.NOT_ACCEPTABLE)
                        .entity("Usuario Autenticado").build();
    }

    @POST
    @Path("/create")
    public Response creatUser(User user) {
        try {
            model.addUser(user);
            return Response.status(Response.Status.OK).entity("Usuario Creado").build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_ACCEPTABLE)
                    .entity("Usuario no se pudo Crear").build();
        }

    }

    @PUT
    @Path("/update")
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
