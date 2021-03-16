/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.airTicket.logic.Login;

/**
 *
 * @author bryan
 */
public class User implements java.io.Serializable {

    private String user;
    private String password;
    private String role;
    private Person personalInfo;

    public User(String user, String password, String role, Person personalInfo) {
        this.user = user;
        this.password = password;
        this.role = role;
        this.personalInfo = personalInfo;
    }

    public User(String user, String password, String role) {
        this(user, password, role, new Person());
    }

    public User() {
        this("N/A", "N/A", "N/A", new Person());
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

    public Person getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(Person personalInfo) {
        this.personalInfo = personalInfo;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        s.append(String.format("User: %s%n"
                + "Password: %s%n"
                + "Role: %s%n"
                + "Personal Information:%n%s%n",
                this.user, this.password, this.role, this.personalInfo));

        return s.toString();
    }

}
