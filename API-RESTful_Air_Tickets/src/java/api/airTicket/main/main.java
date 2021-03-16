package api.airTicket.main;

import api.airTicket.logic.Login.User;
import api.airTicket.logic.Login.Person;

/**
 * LAB01
 *
 * @author Bryan Sánchez Brenes
 * @author Alex Lopez Lopez Curso Diseño y Programación de Dispositivos Moviles
 */
public class main {

    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Pruebas");
        Person per_Info = new Person("Bryan", "Sánchez Brenes", 27);
        User log_in = new User("bryanjsb", "123456", "User", per_Info);
        System.out.println(log_in);
    }
}
