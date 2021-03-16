package cr.ac.database.connection;

import cr.ac.database.managers.DBManager;
import java.io.IOException;
import java.sql.*;
import java.util.*;

public class ConnectionDB {

    // <editor-fold defaultstate="collapsed" desc="constructores">
    private ConnectionDB()
            throws ClassNotFoundException,
            IllegalAccessException,
            InstantiationException,
            IOException {
        conf = new Properties();
        try {
            conf.load(getClass().getResourceAsStream(FILE_CONF));
            try {
                bd = DBManager.getDBManager(DBManager.DB_MGR.MYSQL_SERVER,
                        conf.getProperty("server_url"));
            } catch (IOException
                    | ClassNotFoundException
                    | IllegalAccessException
                    | InstantiationException ex) {
                System.err.println("No se pudo cargar el manejador de la base de datos..");
                System.err.printf("Excepción: '%s'%n", ex.getMessage());
                throw ex;
            }
        } catch (IOException ex) {
            System.err.println("No se pudo leer el archivo de configuración..");
            throw ex;
        }
    }

    public static ConnectionDB getInstance() {
        if (instance == null) {
            try {
                instance = new ConnectionDB();
            } catch (IOException
                    | ClassNotFoundException
                    | IllegalAccessException
                    | InstantiationException ex) {
                System.err.printf("Excepción: '%s'%n", ex.getMessage());
            }
        }
        return instance;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="métodos">
    public Connection getConnection()
            throws SQLException {
        return bd.getConnection(
                conf.getProperty("database"),
                conf.getProperty("user"),
                conf.getProperty("password")
        );
    }

    public void closeConnection() {
        bd.closeConnection();
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="SINGLETON">
    private static ConnectionDB instance = null;
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="atributos BD">
    private static final String FILE_CONF = "bd.properties";
    private final Properties conf;
    private DBManager bd;
    // </editor-fold>
}
