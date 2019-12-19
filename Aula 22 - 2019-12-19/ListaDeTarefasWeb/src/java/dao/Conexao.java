package dao;

import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static Driver driver = null;

    private static void registrarDriver() throws SQLException {

        if (driver == null) {
            Driver d = new Driver();
            DriverManager.registerDriver(d);

            driver = d;
        }
    }

    public static Connection abrirConexao() throws SQLException {

        registrarDriver();

        return DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
    }

}
