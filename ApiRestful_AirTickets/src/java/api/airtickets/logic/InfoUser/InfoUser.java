/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.airtickets.logic.InfoUser;

import java.util.Date;

/**
 *
 * @author bryan
 */
public class InfoUser implements java.io.Serializable {

    private String id, name, lastName, email, address;
    private Date dateBirthDay;
    private int phoneWork, cellphone;

    // <editor-fold defaultstate="collapsed" desc="Constructor. Click on the + sign on the left to edit the code.">
    public InfoUser(String id, String name, String lastName, String email,
            Date dateBirthDay, String address,
            int phoneWork, int cellphone) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.dateBirthDay = dateBirthDay;
        this.address = address;
        this.phoneWork = phoneWork;
        this.cellphone = cellphone;
    }

    public InfoUser() {
        this("N/A", "N/A", "N/A", "N/A", new Date(), "N/A", 0, 0);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="gets and sets. Click on the + sign on the left to edit the code.">
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateBirthDay() {
        return dateBirthDay;
    }

    public void setDateBirthDay(Date dateBirthDay) {
        this.dateBirthDay = dateBirthDay;
    }

    public int getPhoneWork() {
        return phoneWork;
    }

    public void setPhoneWork(int phoneWork) {
        this.phoneWork = phoneWork;
    }

    public int getCellphone() {
        return cellphone;
    }

    public void setCellphone(int cellphone) {
        this.cellphone = cellphone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // </editor-fold>
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        s.append(String.format("Name: %s%n"
                + "LastName: %s%n"
                + "Email: %s%n"
                + "Address: %s%n"
                + "Date Birthday: %s%n"
                + "Phone Work: %d%n"
                + "Cellphone: %d%n",
                name, lastName, email, address,
                dateBirthDay, phoneWork, cellphone));

        return s.toString();
    }
}
