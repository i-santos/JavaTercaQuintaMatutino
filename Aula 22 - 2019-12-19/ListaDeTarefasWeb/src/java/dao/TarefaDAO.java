package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Tarefa;
import model.Usuario;

public class TarefaDAO {

    public static boolean inserir(Tarefa t) {
        boolean sucesso = false;

        try (Connection c = Conexao.abrirConexao()) {

            PreparedStatement stmt = c.prepareStatement("INSERT INTO lista_tarefas.tarefa (titulo, finalizada, id_usuario) VALUES (?, ?, ?)");

            stmt.setString(1, t.getTitulo());
            stmt.setBoolean(2, t.isFinalizada());
            stmt.setInt(3, t.getIdUsuario());

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                sucesso = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sucesso;
    }

    public static ArrayList<Tarefa> buscarTarefasDoUsuario(Usuario u) {
        ArrayList<Tarefa> tarefas = new ArrayList();

        try (Connection c = Conexao.abrirConexao()) {

            PreparedStatement stmt = c.prepareStatement("SELECT * FROM lista_tarefas.tarefa WHERE id_usuario = ?");

            stmt.setInt(1, u.getId());

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                boolean finalizada = rs.getBoolean("finalizada");

                Tarefa t = new Tarefa();
                t.setId(id);
                t.setTitulo(titulo);
                t.setFinalizada(finalizada);
                t.setIdUsuario(u.getId());

                tarefas.add(t);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tarefas;
    }

    public static boolean atualizar(Tarefa t) {
        boolean sucesso = false;

        try (Connection c = Conexao.abrirConexao()) {
            PreparedStatement stmt = c.prepareStatement("UPDATE lista_tarefas.tarefa SET titulo = ?, finalizada = ? WHERE id = ? and id_usuario = ?");

            stmt.setString(1, t.getTitulo());
            stmt.setBoolean(2, t.isFinalizada());
            stmt.setInt(3, t.getId());
            stmt.setInt(4, t.getIdUsuario());

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                sucesso = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sucesso;
    }

    public static boolean remover(Tarefa t) {
        boolean sucesso = false;

        try (Connection c = Conexao.abrirConexao()) {

            PreparedStatement stmt = c.prepareStatement("DELETE FROM lista_tarefas.tarefa WHERE id = ? and id_usuario = ?");

            stmt.setInt(1, t.getId());
            stmt.setInt(2, t.getIdUsuario());

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                sucesso = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sucesso;
    }

    public static boolean finalizar(Tarefa t) {
        boolean sucesso = false;

        try (Connection c = Conexao.abrirConexao()) {

            PreparedStatement stmt = c.prepareStatement("UPDATE lista_tarefas.tarefa SET finalizada = ? WHERE id = ? and id_usuario = ?");
            stmt.setBoolean(1, true);
            stmt.setInt(2, t.getId());
            stmt.setInt(3, t.getIdUsuario());

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
