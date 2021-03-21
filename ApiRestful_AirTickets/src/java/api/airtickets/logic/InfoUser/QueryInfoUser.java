/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.airtickets.logic.InfoUser;

/**
 *
 * @author bryan
 */
public enum QueryInfoUser {

    //Procedures
    PROCEDURE_GET_INFOUSER_ID("{call getInfoUser(?)}"),
    READ("SELECT Id,Name,LastName,e-mail,DateBirthday,"
            + "Address,PhoneWork,CellPhone FROM InfoUser WHERE Id=?; ");

    QueryInfoUser(String procedure) {
        this.query = procedure;
    }

    public String getQuery() {
        return query;
    }

    private final String query;
}
