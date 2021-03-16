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
public class Person implements java.io.Serializable {

    private String name;
    private String lastName;
    private int age;

    public Person(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public Person() {
        this("N/A", "N/A", 18);
    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(String.format("Full Name: %s %s%n"
                + "Age: %d", this.name, this.lastName, this.age));
        return s.toString();
    }

}
