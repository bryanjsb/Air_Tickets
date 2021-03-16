/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example;

/**
 *
 * @author bryan
 */
/*http://chuwiki.chuidiang.org/index.php?title=Ejemplo_de_servicios_REST_con_JSON_y_contenedor_JEE*/
public class Data {

    private int value;
    private String string;

    // Constructores, getters y setters
    public Data(int value, String string) {
        this.value = value;
        this.string = string;
    }

    public Data() {
        this.value = 0;
        this.string = "";
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

}
