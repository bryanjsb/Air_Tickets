/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.logic.InfoUser;

/**
 *
 * @author bryan
 */
public enum QueryInfoUser {

    //Procedures
    PROCEDURE_GET_INFOUSER_ID("{call getInfoUser(?)}"),
    CREATE("INSERT INTO InfoUser (User_ID,Name,LastName,email,DateBirthday,"
            + "Address,PhoneWork,CellPhone) VALUES (?,?,?,?,?,?,?,?); "),
    GET_BY_ID("SELECT User_ID,Name,LastName,email,DateBirthday,"
            + "Address,PhoneWork,CellPhone FROM infoUser WHERE User_ID=?; "),
    UPDATE("UPDATE InfoUser SET Name=?,LastName=?,email=?,DateBirthday=?,"
            + "Address=?,PhoneWork=?,CellPhone=? WHERE User_ID=?; "),
    VERIFY_ID("SELECT User_ID FROM InfoUser WHERE User_ID=?;");

    QueryInfoUser(String procedure) {
        this.query = procedure;
    }

    public String getQuery() {
        return query;
    }

    private final String query;
}
