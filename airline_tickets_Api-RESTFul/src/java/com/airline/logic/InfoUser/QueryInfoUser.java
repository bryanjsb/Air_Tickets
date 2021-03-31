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
    CREATE("INSERT INTO InfoUser (ID,Name,LastName,email,DateBirthday,"
            + "Address,PhoneWork,CellPhone) VALUES (?,?,?,?,?,?,?,?); "),
    READ("SELECT ID,Name,LastName,email,DateBirthday,"
            + "Address,PhoneWork,CellPhone FROM InfoUser WHERE ID=?; "),
    UPDATE("UPDATE InfoUser SET Name=?,LastName=?,email=?,DateBirthday=?,"
            + "Address=?,PhoneWork=?,CellPhone=? WHERE ID=?; ");

    QueryInfoUser(String procedure) {
        this.query = procedure;
    }

    public String getQuery() {
        return query;
    }

    private final String query;
}
