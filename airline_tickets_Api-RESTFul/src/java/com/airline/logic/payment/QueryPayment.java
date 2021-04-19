/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.logic.payment;

/**
 *
 * @author bryan
 */
public enum QueryPayment {

    //QUERIES
    CREATE("INSERT INTO Payment (creditCardNumber,User_ID,expirationDay,"
            + "expirationMonth,cvv) VALUES (?,?,?,?,?); "),
    GET_ID("SELECT creditCardNumber,User_ID,expirationDay,"
            + "expirationMonth,cvv FROM Payment WHERE creditCardNumber=?; "),
    GET_USER("SELECT creditCardNumber,User_ID,expirationDay,"
            + "expirationMonth,cvv FROM Payment WHERE User_ID=?; "),
    UPDATE("UPDATE Payment SET creditCardNumber=?,User_ID=?,expirationDay=?, "
            + "expirationMonth=?,cvv=? WHERE creditCardNumber=?; "),
    DELETE("DELETE FROM Payment WHERE creditCardNumber=?; ");

    QueryPayment(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    private final String query;
}
