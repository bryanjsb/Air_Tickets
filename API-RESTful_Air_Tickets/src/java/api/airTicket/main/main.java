package api.airTicket.main;

import api.airTicket.logic.User.User;
import api.airTicket.model.LoginModel;

/**
 * LAB01
 *
 * @author Bryan Sánchez Brenes
 * @author Alex Lopez Lopez Curso Diseño y Programación de Dispositivos Moviles
 */
public class main {

    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Tests");

        User log_in = new User("bryanjsb", "123456777", "User");
        System.out.println(log_in);

        LoginModel lm = new LoginModel();
        //System.out.println("add User");
        //lm.addUser(new User("bryanjsb", "123456", "Admin"));

        System.out.println("Get User");
        User ptr = lm.getUserById("bryanjsb");
        System.out.println(ptr);

        System.out.println("update User");
        System.out.println(lm.updateUser(ptr) ? "se actualizo user" : "no se actualizo user");
    }
}
