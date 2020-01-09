package dao;

import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
    private static final String DB_URL = "jdbc:mysql://localhost:3306?useTimezone=true&serverTimezone=UTC";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";
    
    private static Driver driver = null;
    
    private static void registrarDriver() throws SQLException {
        
        if (driver == null) {
            
            Driver d = new Driver();
            DriverManager.registerDriver(d);
            
            driver = d;
            
        }
        
    }
    
    protected static Connection abrirConexao() throws SQLException {
        
        registrarDriver();
        
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
}
