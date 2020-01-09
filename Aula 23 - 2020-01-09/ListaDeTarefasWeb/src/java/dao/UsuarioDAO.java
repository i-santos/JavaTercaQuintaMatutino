package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Usuario;

public class UsuarioDAO {
    
    private static final String INSERT_SQL = "INSERT INTO lista_tarefas.usuario (email, senha) VALUES (?, ?)";
    private static final String SELECT_BY_EMAIL_SQL = "SELECT * FROM lista_tarefas.usuario WHERE email = ?";
    
    public static boolean cadastrarUsuario(Usuario u) {
        boolean ok = false;
        
        try ( Connection c = Conexao.abrirConexao() ) {
            
            PreparedStatement stmt = c.prepareStatement(INSERT_SQL);
            
            stmt.setString(1, u.getEmail());
            stmt.setString(2, u.getSenha());
            
            int rowsAffected = stmt.executeUpdate();
            
            ok = rowsAffected > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return ok;
    }
    
    public static Usuario buscarUsuarioPorEmail(String email) {
        Usuario u = null;
        
        try (Connection c = Conexao.abrirConexao()) {
            
            PreparedStatement stmt = c.prepareStatement(SELECT_BY_EMAIL_SQL);
            
            stmt.setString(1, email);
            
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                int id = rs.getInt("id");
                String senha = rs.getString("senha");
                
                u = new Usuario();
                u.setId(id);
                u.setEmail(email);
                u.setSenha(senha);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return u;
    }
}
