/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.airtickets.controller;

import api.airtickets.logic.InfoUser.InfoUser;
import api.airtickets.model.InfoUserModel;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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

    private final InfoUserModel model = new InfoUserModel();
}
