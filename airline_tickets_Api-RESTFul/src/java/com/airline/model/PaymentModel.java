/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.model;

import com.airline.logic.payment.DaoPayment;
import com.airline.logic.payment.Payment;

/**
 *
 * @author Bryan
 */
public class PaymentModel {

    public void addPayment(Payment pay){
        dao.addPayment(pay);
    }
    private PaymentModel() {
        dao = DaoPayment.getInstance();
    }

    public static PaymentModel getInstance() {
        return instance == null ? instance = new PaymentModel() : instance;
    }

    private static PaymentModel instance = null;
    private final DaoPayment dao;
}
