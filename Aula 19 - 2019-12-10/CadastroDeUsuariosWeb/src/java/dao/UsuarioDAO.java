 ,package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Usuario;

public class UsuarioDAO {

    public static boolean inserirUsuario(Usuario u) {
        boolean sucesso = false;

        // Tentar abrir conexÃ£o
        try (Connection conn = Conexao.abrirConexao()) {

            // ComeÃ§ar a preparar o comando para enviar pro Banco
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

        try (Connection connection = Conexao.abrirConexao()) {

            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM lista_tarefas.usuario");

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

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuarios;
    }

    public static Usuario procurarUsuarioPorEmail(String email) {
        Usuario u = null;

        try (Connection conexao = Conexao.abrirConexao()) {

            PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM lista_tarefas.usuario WHERE email = ?");

            stmt.setString(1, email);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

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
    
    public static Usuario procurarUsuarioPorId(int id) {
        Usuario u = null;
        
        try (Connection conexao = Conexao.abrirConexao()) {
            
            PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM lista_tarefas.usuario WHERE id = ?");
            
            stmt.setInt(1, id);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
                String email = rs.getString("email");
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

    public static boolean atualizarUsuario(Usuario u) {
        boolean sucesso = false;

        try (Connection conexao = Conexao.abrirConexao()) {

            PreparedStatement stmt = conexao.prepareStatement("UPDATE lista_tarefas.usuario SET email = ?, senha = ? WHERE id = ?");
            stmt.setString(1, u.getEmail());
            stmt.setString(2, u.getSenha());
            stmt.setInt(3, u.getId());

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                sucesso = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sucesso;
    }
    
    public static boolean removerUsuario(Usuario u) {
        boolean sucesso = false;
        
        try (Connection conexao = Conexao.abrirConexao()) {
            
            PreparedStatement stmt = conexao.prepareStatement("DELETE FROM lista_tarefas.usuario WHERE id = ?");
            
            stmt.setInt(1, u.getId());
            
            int linhasAfetadas = stmt.executeUpdate();
            
            if (linhasAfetadas > 0) {
                sucesso = true;
            }
            
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return sucesso;
    }

}
