package cadastrodeusuarios;

import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class CadastroDeUsuarios {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        boolean running = true;

        while (running) {

            System.out.println("");
            System.out.println("************************");
            System.out.println("* Cadastro de Usuários *");
            System.out.println("************************");
            System.out.println("[1] Adicionar Novo Usuário");
            System.out.println("[2] Listar Todos Usuários");
            System.out.println("[3] Procurar Usuário por E-mail");
            System.out.println("[4] Remover Usuário por E-mail");
            System.out.println("[5] Finalizar Programa");
            System.out.print("Digite a opção: ");
            int opcao = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (opcao) {
                case 1: {

                    Usuario u = new Usuario();

                    System.out.print("Digite o e-mail: ");
                    u.setEmail(sc.nextLine());
                    System.out.print("Digite a senha: ");
                    u.setSenha(sc.nextLine());

                    boolean cadastrado = inserirUsuario(u);
                    if (cadastrado) {
                        System.out.println("Usuário cadastrado!");
                    } else {
                        System.out.println("Aconteceu algum erro. Tente novamente");
                    }
                    break;
                }
                case 2: {

                    ArrayList<Usuario> usuarios = buscarUsuarios();

                    if (usuarios.isEmpty()) {
                        System.out.println("Nenhum usuário cadastrado.");
                        break;
                    }

                    for (int i = 0; i < usuarios.size(); i++) {
                        Usuario u = usuarios.get(i);
                        System.out.println("Usuario " + (i + 1) + ": ");
                        System.out.println("\tEmail: " + u.getEmail());
                        System.out.println("\tSenha: " + u.getSenha());
                    }

                    System.out.println("[Fim da lista de usuários]");
                    break;
                }
                case 3: {

                    System.out.print("Digite o email do usuário: ");
                    String uEmail = sc.nextLine();

                    Usuario u = procurarUsuarioPorEmail(uEmail);

                    if (u != null) {
                        System.out.println("Usuário encontrado:");
                        System.out.println("\tEmail: " + u.getEmail());
                        System.out.println("\tSenha: " + u.getSenha());
                        break;
                    } else {
                        System.out.println("Usuário não cadastrado.");
                    }

                    break;
                }
                case 4: {

                    System.out.print("Digite o email do usuário: ");
                    String uEmail = sc.nextLine();

                    Usuario u = procurarUsuarioPorEmail(uEmail);

                    if (u == null) {
                        System.out.println("Usuário não cadastrado.");
                    } else {

                        boolean removido = removerUsuario(u);

                        if (removido) {
                            System.out.println("Usuário removido com sucesso.");
                        } else {
                            System.out.println("Algum erro aconteceu. Tente novamente");
                        }
                    }
                    break;
                }
                case 5: {
                    System.out.println("Encerrando programa...");
                    running = false;
                    break;
                }
                default:
                    System.out.println("Opção inválida!");
            }

            if (running) {

                System.out.println("Pressione enter para continuar");
                sc.nextLine();
            }

        }

        System.out.println("Programa encerrado.");
    }

    public static boolean inserirUsuario(Usuario u) {
        boolean sucesso = false;

        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO lista_tarefas.usuario (email, senha) VALUES (?, ?)");
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

    public static Usuario procurarUsuarioPorEmail(String email) {
        Usuario u = null;

        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM lista_tarefas.usuario WHERE email = ?");

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

    public static ArrayList<Usuario> buscarUsuarios() {
        ArrayList<Usuario> usuarios = new ArrayList();

        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
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

    public static boolean removerUsuario(Usuario u) {
        boolean sucesso = false;

        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM lista_tarefas.usuario WHERE id = ?");

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
