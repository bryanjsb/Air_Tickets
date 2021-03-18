/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.airTicket.controller;

/**
 *
 * @author bryan
 */
import api.airTicket.logic.User.DaoUser;
import api.airTicket.logic.User.User;
import api.airTicket.model.LoginModel;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/sign")
public class LoginController {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("{id}")
    public User getUserById(@PathParam("id") String id) {
        return l.getUserById(id);
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public void creatUser(User user) {
        l.addUser(user);
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String update(User user) {
        System.out.println(user.toString());
        return l.updateUser(user) ? "Se actualizo el usuario"
                : "NO se actualizo el usuario";
    }

    @DELETE
    @Path("/delete/{user}")
    public String deleteUserById(@PathParam("user") String user) {
        return l.deleteUser(user) ? "Usuario eliminado" : "NO se elimino el usuario";
    }

    private final LoginModel l = new LoginModel();
}
