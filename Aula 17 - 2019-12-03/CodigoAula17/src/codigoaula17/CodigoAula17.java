package codigoaula17;

import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class CodigoAula17 {

    public static Usuario usuarioLogado;
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        
        boolean rodando = true;
        while(rodando) {
            
            System.out.println("[1] Fazer cadastro");
            System.out.println("[2] Fazer login");
            System.out.println("[3] Sair");
            System.out.println("Digite a opção: ");
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1": {
                    System.out.println("====== CADASTRO ======");
                    System.out.print("Digite o email: ");
                    String email = scanner.nextLine();
                    System.out.print("Digite a senha: ");
                    String senha = scanner.nextLine();

                    Usuario u = new Usuario();
                    u.setEmail(email);
                    u.setSenha(senha);

                    boolean inserido = inserirUsuario(u);
                    if (inserido) {
                        System.out.println("Usuário cadastrado com sucesso");
                    } else {
                        System.out.println("Erro ao cadastrar. Tente novamente");
                    }

                    break;
                }
                case "2": {
                    System.out.println("====== LOGIN ======");
                    System.out.println("Digite o email: ");
                    String email = scanner.nextLine();
                    System.out.println("Digite a senha: ");
                    String senha = scanner.nextLine();

                    Usuario u = procurarUsuario(email);

                    if (u == null || !senha.equals(u.getSenha())) {
                        System.out.println("Email/senha inválidos.");
                    } else if (senha.equals(u.getSenha())) {
                        usuarioLogado = u;
                        homePage();
                    }

                    break;
                }
                case "3": {
                    break;
                }
                default: {
                    break;
                }
            }
        }

    }

    public static void homePage() {
        
        boolean rodando = true;
        while(rodando){
            
            System.out.println("[1] Adicionar Tarefa");
            System.out.println("[2] Mostrar Tarefas");
            System.out.println("[3] Logout");
            System.out.print("Digite a opção: ");
            String opcao = scanner.nextLine();

            switch(opcao) {
                case "1": {
                    System.out.println("====== NOVA TAREFA ======");
                    System.out.print("Digite o título: ");
                    String titulo = scanner.nextLine();

                    Tarefa t = new Tarefa();
                    t.setTitulo(titulo);
                    t.setFinalizada(false);
                    t.setIdUsuario(usuarioLogado.getId());

                    boolean inserida = inserirTarefa(t);

                    if (inserida) {
                        System.out.println("Tarefa adicionada com sucesso!");
                    } else {
                        System.out.println("Aconteceu algum erro. Tente novamente.");
                    }

                    break;
                }
                case "2": {
                    System.out.println("====== TAREFAS ======");
                    ArrayList<Tarefa> tarefas = procurarTarefasDoUsuario(usuarioLogado.getId());
                    usuarioLogado.setTarefas(tarefas);
                    for (int i = 0; i < tarefas.size(); i++) {
                        Tarefa tTemp = tarefas.get(i);
                        System.out.println("Tarefa " + i);
                        System.out.println("\tTítulo: " + tTemp.getTitulo());
                        System.out.println("\tFinalizada: " + tTemp.isFinalizada());
                    }
                    break;
                }
                case "3": {
                    rodando = false;
                    break;
                }
            }
        }
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

    public static Usuario procurarUsuario(String email) {
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
    
    public static boolean inserirTarefa(Tarefa t) {
        boolean sucesso = false;
        
        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);
            
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
            
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO lista_tarefas.tarefa (titulo, finalizada, id_usuario) VALUES (?, ?, ?)");
            
            stmt.setString(1, t.getTitulo());
            stmt.setBoolean(2, t.isFinalizada());
            stmt.setInt(3, t.getIdUsuario());
            
            int linhasAfetadas = stmt.executeUpdate();
            
            if (linhasAfetadas > 0) {
                sucesso = true;
            }
            
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return sucesso;
    }
    
    public static ArrayList<Tarefa> procurarTarefasDoUsuario(int idUsuario) {
        ArrayList<Tarefa> tarefas = new ArrayList();
        
        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);
            
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
            
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM lista_tarefas.tarefa WHERE id_usuario = ?");
            
            stmt.setInt(1, idUsuario);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                int idTarefa = rs.getInt("id");
                String titulo = rs.getString("titulo");
                boolean finalizada = rs.getBoolean("finalizada");
                
                Tarefa t = new Tarefa();
                t.setId(idTarefa);
                t.setTitulo(titulo);
                t.setFinalizada(finalizada);
                t.setIdUsuario(idUsuario);
                
                tarefas.add(t);
            }
            
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return tarefas;
    }

}
