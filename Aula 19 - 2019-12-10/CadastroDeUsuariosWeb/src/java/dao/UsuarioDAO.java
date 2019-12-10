package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Usuario;

public class UsuarioDAO {

    public static boolean inserirUsuario(Usuario u) {
        boolean sucesso = false;

        // Tentar abrir conexão
        try ( Connection conn = Conexao.abrirConexao() ) {
            
            // Começar a preparar o comando para enviar pro Banco
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO lista_tarefas.usuario (email, senha) VALUES (?, ?)");
            
            // Substituir os valores no comando
            stmt.setString(1, u.getEmail());
            stmt.setString(2, u.getSenha());
            
            // Enviar comando para ser executado
            int linhasAfetadas = stmt.executeUpdate();
            
            if (linhasAfetadas > 0) {
                sucesso = true;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return sucesso;
    }
    
    public static ArrayList<Usuario> buscarUsuarios() {
        ArrayList<Usuario> usuarios = new ArrayList();
        
        try ( Connection connection = Conexao.abrirConexao() ) {
            
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM lista_tarefas.usuario");
            
            ResultSet rs = stmt.executeQuery();
            
            while( rs.next() ) {
                
                int id = rs.getInt("id");
                String email = rs.getString("email");
                String senha = rs.getString("senha");
                
                Usuario u = new Usuario();
                u.setId(id);
                u.setEmail(email);
                u.setSenha(senha);
                
                usuarios.add(u);
            }
            
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return usuarios;
    }

}
