package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Usuario;

public class UsuarioDAO {

    public static boolean inserirUsuario(Usuario u) {
        boolean sucesso = false;

        try ( Connection conn = Conexao.abrirConexao() ) {
            
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO lista_tarefas.usuario (email, senha) VALUES (?, ?)");
            
            stmt.setString(1, u.getEmail());
            stmt.setString(2, u.getSenha());
            
            int linhasAfetadas = stmt.executeUpdate();
            
            if (linhasAfetadas > 0) {
                sucesso = true;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return sucesso;
    }

}
