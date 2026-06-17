package Deposito.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    private static final String URL = "jdbc:sqlite:database/deposito.db";
    
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL);
    }
}
