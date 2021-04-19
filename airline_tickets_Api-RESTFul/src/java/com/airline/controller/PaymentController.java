/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.controller;

import com.airline.logic.payment.Payment;
import com.airline.model.PaymentModel;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Bryan
 */
@Path("/payment")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PaymentController {

    @POST
    @Path("/add")
    public Response addPayment(Payment payment) {
        System.out.println(payment);
        try {

            model.addPayment(payment);
            return Response.ok("payment add").build();
        } catch (Exception e) {
            return Response.status(200).entity("payment not add").build();
        }
    }

    private final PaymentModel model = PaymentModel.getInstance();
}
