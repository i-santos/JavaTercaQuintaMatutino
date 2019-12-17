package dao;

import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static Driver driver = null;

    public static Connection abrirConexao() throws SQLException {

        registrarDriver();

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");

        return connection;

    }

    private static void registrarDriver() throws SQLException {
        if (Conexao.driver == null) {

            Driver driver = new Driver();
            DriverManager.registerDriver(driver);

            Conexao.driver = driver;

        }
    }

}
