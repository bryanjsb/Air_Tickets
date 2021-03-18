package api.airTicket.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author bryan
 */
import api.airTicket.logic.User.User;
import api.airTicket.logic.User.DaoUser;

public class LoginModel {

    public void addUser(User user) {
        daoUser.addUser(user);
    }

    public void addUser(String user, String pass, String Role) {
        addUser(new User(user, pass, Role));
    }

    public User getUserById(String id) {
        return daoUser.getUserById(id).get();
    }

    public boolean updateUser(User user) {
        return daoUser.updateUser(user);
    }

    public boolean deleteUser(String user) {
        return daoUser.DeleteUser(user);
    }

    public LoginModel() {
        daoUser = DaoUser.getInstance();
    }

    /*
    public LoginModel getInstance() {
        if (loginModel == null) {
            loginModel = new LoginModel();
        }
        return loginModel;
    }

    private static LoginModel loginModel = null;
     */
    private final DaoUser daoUser;
}
