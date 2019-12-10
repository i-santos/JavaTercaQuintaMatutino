package dao;

import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static Driver driver = null;

    private static void registrarDriver() {

        if (driver == null) {
            try {
                Driver driver = new Driver();
                DriverManager.registerDriver(driver);

                Conexao.driver = driver;

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    protected static Connection abrirConexao() throws SQLException {
        
        registrarDriver();
        
        Connection connection = null;

        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");

        return connection;
    }
}
