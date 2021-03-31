/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.logic.User;

/**
 *
 * @author bryan
 */
public class User implements java.io.Serializable {

    private String id;
    private String user;
    private String password;
    private String role;

    // <editor-fold defaultstate="collapsed" desc="Constructor. Click on the + sign on the left to edit the code.">
    public User(String id, String user, String password, String role) {
        this.id = id;
        this.user = user;
        this.password = password;
        this.role = role;
    }

    public User() {
        this("N/A", "N/A", "N/A", "N/A");
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="gets and sets. Click on the + sign on the left to edit the code.">
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // </editor-fold>
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        s.append(String.format("ID: %s%n"
                + "User: %s%n"
                + "Password: %s%n"
                + "Role: %s%n", this.id,
                this.user, this.password, this.role));

        return s.toString();
    }

}
