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
public enum QueryUser {
    CREATE("INSERT INTO Login (User,Password,Role) VALUES (?,?,?); "),
    READ("SELECT User,Password,Role FROM Login WHERE User=? "),
    UPDATE("UPDATE usuario SET id_usuario=?, clave_acceso=?,clave_vencida=?,rol=? WHERE id_usuario=?; "),
    DELETE("DELETE FROM usuario WHERE id_usuario=?; "),
    LIST_USER("SELECT id_usuario, clave_acceso, clave_vencida,rol FROM usuario ORDER BY id_usuario; "),
    VERIFY("SELECT id_usuario FROM usuario WHERE id_usuario=? AND clave_acceso=?; ");

    QueryUser(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    private final String query;
}
