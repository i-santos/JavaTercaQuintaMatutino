package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Usuario;

public class UsuarioDAO {

    public static boolean inserir(Usuario u) {
        boolean sucesso = false;

        try (Connection c = Conexao.abrirConexao()) {
            PreparedStatement stmt = c.prepareStatement("INSERT INTO lista_tarefas.usuario (email, senha) VALUES (?, SHA2(?, 256))");

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

    public static ArrayList<Usuario> buscarTodos() {
        ArrayList<Usuario> usuarios = new ArrayList();

        try (Connection c = Conexao.abrirConexao()) {

            PreparedStatement stmt = c.prepareStatement("SELECT * FROM lista_tarefas.usuario");

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

    public static Usuario buscarPorEmail(String email) {
        Usuario u = null;

        try (Connection c = Conexao.abrirConexao()) {

            PreparedStatement stmt = c.prepareStatement("SELECT * FROM lista_tarefas.usuario WHERE email = ?");

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

    public static Usuario buscarPorEmailSenha(String email, String senha) {
        Usuario u = null;

        try (Connection c = Conexao.abrirConexao()) {
            PreparedStatement stmt = c.prepareStatement("SELECT * FROM lista_tarefas.usuario WHERE email = ? and senha = SHA2(?, 256)");

            stmt.setString(1, email);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");

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

    public static Usuario buscarPorId(int id) {
        Usuario u = null;

        try (Connection c = Conexao.abrirConexao()) {
            PreparedStatement stmt = c.prepareStatement("SELECT * FROM lista_tarefas.usuario WHERE id = ?");

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
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

    public static boolean atualizar(Usuario u) {
        boolean sucesso = false;

        try (Connection c = Conexao.abrirConexao()) {
            PreparedStatement stmt = c.prepareStatement("UPDATE lista_tarefas.usuario SET email = ?, senha = SHA2(?, 256) WHERE id = ?");

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

    public static boolean remover(Usuario u) {
        boolean sucesso = false;

        try (Connection c = Conexao.abrirConexao()) {
            PreparedStatement stmt = c.prepareStatement("DELETE FROM lista_tarefas.usuario WHERE id = ?");

            stmt.setInt(1, u.getId());

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
