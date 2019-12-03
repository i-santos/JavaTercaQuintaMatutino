package listadetarefas;

import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ListaDeTarefas {

    static Usuario usuarioLogado = null;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // Inicializar o array
        ArrayList<Usuario> usuarios = new ArrayList();

        // Variáveis de controle
        String email = "";
        String senha = "";
        int nTentativas = 0;
        boolean running = true;

        while (running) {

            System.out.println("");
            System.out.println("===============");
            System.out.println("||  Index   ||");
            System.out.println("==============");
            System.out.println("[1] Fazer cadastro");
            System.out.println("[2] Fazer login");
            System.out.println("[3] Encerrar programa");
            System.out.print("Digite a opção: ");
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1": {

                    System.out.println("");
                    System.out.println("===========================");
                    System.out.println("||  Página de cadastro   ||");
                    System.out.println("===========================");
                    System.out.print("Digite o email: ");
                    email = scanner.nextLine();

                    System.out.print("Digite a senha: ");
                    senha = scanner.nextLine();

                    Usuario u = new Usuario();
                    u.setEmail(email);
                    u.setSenha(senha);

                    boolean cadastrado = inserirUsuario(u);
                    if (cadastrado) {
                        System.out.println("Usuário cadastrado com sucesso!");
                    } else {
                        System.out.println("Aconteceu algum erro. Tente novamente.");
                    }

                    break;
                }
                case "2": {

                    System.out.println("");
                    System.out.println("=======================");
                    System.out.println("||  Página de login  ||");
                    System.out.println("=======================");

                    // Pegar email e senha
                    System.out.print("Digite o email: ");
                    email = scanner.nextLine();

                    System.out.print("Digite a senha: ");
                    senha = scanner.nextLine();

                    Usuario u = procurarUsuarioPorEmail(email);

                    if (u == null || !u.getSenha().equals(senha)) {
                        System.out.println("Email/senha incorretos. Redirecionando para Index...");
                    } else {
                        usuarioLogado = u;
                        rodarMenuSecundario();
                        break;
                    }

                    break;
                }
                case "3": {
                    running = false;
                    System.out.println("Encerrando programa...");
                    break;
                }
            }

            if (running) {
                System.out.println("Pressione enter para continuar");
                scanner.nextLine();
            }

        }

        scanner.close();
        System.out.println("Programa finalizado.");

    }

    static void rodarMenuSecundario() {

        while (usuarioLogado != null) {

            System.out.println("");
            System.out.println("==================");
            System.out.println("||  Home Page   ||");
            System.out.println("==================");
            System.out.println("[1] Listar tarefas");
            System.out.println("[2] Listar tarefas finalizadas");
            System.out.println("[3] Listar tarefas não finalizadas");
            System.out.println("[4] Adicionar nova tarefa");
            System.out.println("[5] Finalizar tarefa");
            System.out.println("[6] Remover tarefa");
            System.out.println("[7] Logout");
            System.out.print("Digite a opção: ");
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1": {
                    System.out.println("");
                    System.out.println("==========================");
                    System.out.println("||  Lista de Tarefas    ||");
                    System.out.println("==========================");

                    ArrayList<Tarefa> tarefas = buscarTarefasDoUsuario(usuarioLogado.getId());
                    usuarioLogado.setTarefas(tarefas);
                    int nTarefas = usuarioLogado.getTarefas().size();

                    if (nTarefas == 0) {
                        System.out.println("Lista de tarefas VAZIA. Redirecionando para Home Page...");
                        break;
                    }

                    for (int i = 0; i < nTarefas; i++) {
                        Tarefa t = usuarioLogado.getTarefas().get(i);

                        System.out.println("Tarefa " + (i + 1) + ":");
                        System.out.println("\tTitulo:\t\t" + t.getTitulo());
                        System.out.println("\tFinalizada:\t" + t.isFinalizada());
                    }
                    break;
                }
                case "2": {
                    System.out.println("");
                    System.out.println("==========================");
                    System.out.println("||  Tarefas Finalizadas  ||");
                    System.out.println("==========================");

                    ArrayList<Tarefa> tarefas = buscarTarefasDoUsuario(usuarioLogado.getId());
                    usuarioLogado.setTarefas(tarefas);

                    int nTarefas = 0;
                    ArrayList<Tarefa> finalizadas = new ArrayList();

                    for (int i = 0; i < usuarioLogado.getTarefas().size(); i++) {
                        Tarefa t = usuarioLogado.getTarefas().get(i);

                        if (t.isFinalizada()) {
                            finalizadas.add(t);
                            nTarefas++;
                        }
                    }

                    if (nTarefas == 0) {
                        System.out.println("Nenhuma tarefa para mostrar. Redirecionando para Home Page");
                        break;
                    }

                    for (int i = 0; i < nTarefas; i++) {
                        Tarefa t = finalizadas.get(i);

                        System.out.println("Tarefa " + (i + 1) + ":");
                        System.out.println("\t\tTitulo:\t\t" + t.getTitulo());
                        System.out.println("\t\tFinalizada:\t" + t.isFinalizada());
                    }
                    break;
                }
                case "3": {
                    System.out.println("");
                    System.out.println("==========================");
                    System.out.println("||  Tarefas Em Aberto   ||");
                    System.out.println("==========================");

                    ArrayList<Tarefa> tarefas = buscarTarefasDoUsuario(usuarioLogado.getId());
                    usuarioLogado.setTarefas(tarefas);

                    int nTarefas = 0;
                    ArrayList<Tarefa> emAberto = new ArrayList();

                    for (int i = 0; i < usuarioLogado.getTarefas().size(); i++) {
                        Tarefa t = usuarioLogado.getTarefas().get(i);

                        if (!t.isFinalizada()) {
                            emAberto.add(t);
                            nTarefas++;
                        }
                    }

                    if (nTarefas == 0) {
                        System.out.println("Nenhuma tarefa para mostrar. Redirecionando para Home Page...");
                        break;
                    }

                    for (int i = 0; i < nTarefas; i++) {
                        Tarefa t = emAberto.get(i);

                        System.out.println("Tarefa " + (i + 1) + ":");
                        System.out.println("\tTitulo:\t\t" + t.getTitulo());
                        System.out.println("\tFinalizada:\t" + t.isFinalizada());
                    }
                    break;
                }
                case "4": {
                    System.out.println("");
                    System.out.println("====================");
                    System.out.println("||  Nova Tarefa   ||");
                    System.out.println("====================");
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
                case "5": {
                    System.out.println("");
                    System.out.println("=========================");
                    System.out.println("||  Finalizar Tarefa   ||");
                    System.out.println("=========================");

                    ArrayList<Tarefa> tarefas = buscarTarefasDoUsuario(usuarioLogado.getId());
                    usuarioLogado.setTarefas(tarefas);

                    int nTarefas = 0;
                    ArrayList<Tarefa> emAberto = new ArrayList();

                    for (int i = 0; i < usuarioLogado.getTarefas().size(); i++) {
                        Tarefa t = usuarioLogado.getTarefas().get(i);

                        if (!t.isFinalizada()) {
                            emAberto.add(t);
                            nTarefas++;
                        }
                    }

                    if (nTarefas == 0) {
                        System.out.println("Nenhuma tarefa que possa ser finalizada. Redirecionando para Home Page...");
                        break;
                    }

                    int numTarefa = 0;
                    int nTentativas = 0;
                    do {

                        if (nTentativas > 0) {
                            System.out.println("Número de referência inválido.");
                        }

                        for (int i = 0; i < nTarefas; i++) {
                            Tarefa t = usuarioLogado.getTarefas().get(i);

                            System.out.println("[" + (i + 1) + "] " + t.getTitulo());
                        }
                        System.out.print("Digite a tarefa que deseja finalizar: ");
                        numTarefa = scanner.nextInt();
                        scanner.nextLine(); // limpar buffer
                        nTentativas++;

                    } while (numTarefa < 1 || numTarefa > nTarefas);

                    emAberto.get(numTarefa - 1).setFinalizada(true);
                    boolean finalizada = finalizarTarefa(emAberto.get(numTarefa - 1));

                    if (finalizada) {
                        System.out.println("Tarefa finalizada com sucesso!");
                    } else {
                        System.out.println("Aconteceu algum erro. Tente novamente.");
                    }

                    break;
                }
                case "6": {
                    System.out.println("");
                    System.out.println("=========================");
                    System.out.println("||  Remover Tarefa     ||");
                    System.out.println("=========================");

                    ArrayList<Tarefa> tarefas = buscarTarefasDoUsuario(usuarioLogado.getId());
                    usuarioLogado.setTarefas(tarefas);

                    int nTarefas = usuarioLogado.getTarefas().size();

                    if (nTarefas == 0) {
                        System.out.println("Nenhuma tarefa para mostrar. Redirecionando para Home Page...");
                        break;
                    }

                    int numTarefa = 0;
                    int nTentativas = 0;
                    do {

                        if (nTentativas > 0) {
                            System.out.println("Número de referência inválido.");
                        }

                        for (int i = 0; i < nTarefas; i++) {
                            Tarefa t = usuarioLogado.getTarefas().get(i);

                            System.out.println("[" + (i + 1) + "] " + t.getTitulo());
                        }
                        System.out.print("Digite a tarefa que deseja remover: ");
                        numTarefa = scanner.nextInt();
                        scanner.nextLine(); // limpar buffer
                        nTentativas++;

                    } while (numTarefa < 1 || numTarefa > nTarefas);

                    Tarefa tRemovida = usuarioLogado.getTarefas().get(numTarefa - 1);
                    boolean removido = removerTarefa(tRemovida);
                    if (removido) {
                        System.out.println("Tarefa removida com sucesso!");
                    } else {
                        System.out.println("Aconteceu algum erro. Tente novamente");
                    }

                    break;
                }
                case "7": {
                    usuarioLogado = null;
                    System.out.println("Fazendo logout...");
                    break;
                }
            }

            if (usuarioLogado != null) {
                System.out.println("Pressione enter para voltar para Home Page");
                scanner.nextLine();
            }

        }

        System.out.println("Logout feito com sucesso. Redirecionando para Index...");

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
                u.setSenha(senha);
                u.setEmail(email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return u;
    }

    public static ArrayList<Tarefa> buscarTarefasDoUsuario(int idUsuario) {
        ArrayList<Tarefa> tarefas = new ArrayList();

        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM lista_tarefas.tarefa WHERE id_usuario = ?");
            stmt.setInt(1, idUsuario);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                boolean finalizada = rs.getBoolean("finalizada");

                Tarefa t = new Tarefa();
                t.setId(id);
                t.setTitulo(titulo);
                t.setFinalizada(finalizada);
                t.setIdUsuario(idUsuario);

                tarefas.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tarefas;
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

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sucesso;
    }

    public static boolean finalizarTarefa(Tarefa t) {
        boolean sucesso = false;

        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");

            PreparedStatement stmt = connection.prepareStatement("UPDATE lista_tarefas.tarefa SET finalizada = ? WHERE id = ? and id_usuario = ?");

            stmt.setBoolean(1, true);
            stmt.setInt(2, t.getId());
            stmt.setInt(3, t.getIdUsuario());

            int linhasAlteradas = stmt.executeUpdate();

            if (linhasAlteradas > 0) {
                sucesso = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sucesso;
    }

    public static boolean removerTarefa(Tarefa t) {
        boolean sucesso = false;

        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM lista_tarefas.tarefa WHERE id = ? and id_usuario = ?");

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
}
