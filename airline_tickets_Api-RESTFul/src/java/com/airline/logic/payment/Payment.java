/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.logic.payment;

/**
 *
 * @author Bryan
 */
public class Payment {

    int creditCardNumber;
    String idUser;
    int expirationDay, expirationMonth, cvvCard;

    public Payment(int creditCardNumber, String idUser, int expirationCard, int expirationMonth, int cvvCard) {
        this.creditCardNumber = creditCardNumber;
        this.idUser = idUser;
        this.expirationDay = expirationCard;
        this.expirationMonth = expirationMonth;
        this.cvvCard = cvvCard;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(String.format("Id User: %s"
                + "Credit Card Number: %d"
                + "Expiration: %d / %d"
                + "CVV: %d", getIdUser(), getCreditCardNumber(),
                getExpirationDay(), getExpirationMonth(), getCvvCard()));
        return s.toString();
    }

    // <editor-fold defaultstate="collapsed" desc="gets and sets. Click on the + sign on the left to edit the code.">
    public int getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(int creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public int getExpirationDay() {
        return expirationDay;
    }

    public void setExpirationDay(int expirationDay) {
        this.expirationDay = expirationDay;
    }

    public int getCvvCard() {
        return cvvCard;
    }

    public void setCvvCard(int cvvCard) {
        this.cvvCard = cvvCard;
    }

    public int getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(int expirationMonth) {
        this.expirationMonth = expirationMonth;
    }
    // </editor-fold>

}
