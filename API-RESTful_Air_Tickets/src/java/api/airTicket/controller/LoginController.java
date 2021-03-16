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
import api.airTicket.logic.Login.DaoUser;
import api.airTicket.logic.Login.User;
import api.airTicket.model.LoginModel;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/login")
public class LoginController {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("{id}")
    public User getUserById(@PathParam("id") String id) {
        return l.getUserById(id);
    }

    private final DaoUser daoUser = DaoUser.obtenerInstancia();
    private final LoginModel l = new LoginModel();
}
