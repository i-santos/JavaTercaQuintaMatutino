package codigoaula16mysql;

// Versão 5.1
//import com.mysql.jdbc.Driver;

// Versão 8
import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class CodigoAula16MySQL {

    public static void main(String[] args) {
        
        ArrayList<Usuario> usuarios = buscarUsuarios();
        
        for(int i = 0; i < usuarios.size(); i++) {
            Usuario uTemp = usuarios.get(i);
            System.out.println("Usuário " + i);
            System.out.println("\tId: " + uTemp.getId());
            System.out.println("\tEmail: " + uTemp.getEmail());
            System.out.println("\tSenha: " + uTemp.getSenha());
        }

    }
    
    public static void inserirUsuario(Usuario u) {
        
        try {
            
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);
            
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
            
            PreparedStatement stmt = 
                    conn.prepareStatement(
                            "INSERT INTO lista_tarefas.usuario (email, senha) VALUES (?, ?)"
                    );
            
            stmt.setString(1, u.getEmail());
            stmt.setString(2, u.getSenha());
            
            int linhasAfetadas = stmt.executeUpdate();
            
            if (linhasAfetadas > 0) {
                System.out.println("Usuário cadastrado com sucesso");
            } else {
                System.out.println("Não foi possível cadastrar o usuário. Tente novamente");
            }
            
            
        } catch(SQLException e ) {
            e.printStackTrace();
        }
        
    }

    public static ArrayList<Usuario> buscarUsuarios() {
        
        ArrayList<Usuario> usuarios = new ArrayList();
        try {

            Driver driver = new Driver();

            DriverManager.registerDriver(driver);

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");

            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM lista_tarefas.usuario");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("id");
                String email = rs.getString("email");
                String senha = rs.getString("senha");

                Usuario u = new Usuario();
                u.setId(id);
                u.setEmail(email);
                u.setSenha(senha);
                
                usuarios.add(u);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return usuarios;
    }
    
    public static void atualizarUsuario(Usuario u) {
        try {
            
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);
            
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
            
            PreparedStatement stmt = conn.prepareStatement("UPDATE lista_tarefas.usuario SET email = ?, senha = ? WHERE id = ?");
            
            stmt.setString(1, u.getEmail());
            stmt.setString(2, u.getSenha());
            stmt.setInt(3, u.getId());
            
            int linhasAfetadas = stmt.executeUpdate();
            
            if (linhasAfetadas > 0) {
                System.out.println("Usuário atualizado com sucesso");
            } else {
                System.out.println("Não foi possível atualizar os dados. Tente novamente");
            }
            
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void deletarUsuario(Usuario u) {
        
        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);
            
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
            
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM lista_tarefas.usuario WHERE id = ?");
            
            stmt.setInt(1, u.getId());
            
            int linhasAfetadas = stmt.executeUpdate();
            
            if (linhasAfetadas > 0) {
                System.out.println("Usuário deletado com sucesso");
            } else {
                System.out.println("Não foi possível deletar o usuário. Tente novamente");
            }
            
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

}
