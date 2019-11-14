package desafio;

import java.util.Scanner;

public class Desafio {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
       
        boolean running = true;
        
        while(running) {
            
            System.out.println("");
            System.out.println("==============");
            System.out.println("||  DESAFIO ||");
            System.out.println("==============");
            System.out.println("[1] Adicionar usuário");
            System.out.println("[2] Adicionar tarefa");
            System.out.println("[3] Encerrar programa");
            System.out.print("Digite a opção: ");
            String op = sc.nextLine();
            
            switch(op) {
                case "1": {
                    System.out.println("");
                    System.out.println("====================");
                    System.out.println("||  NOVO USUÁRIO  ||");
                    System.out.println("====================");
                    System.out.print("Digite o email: ");
                    String email = sc.nextLine();
                    System.out.print("Digite a senha: ");
                    String senha = sc.nextLine();
                    Usuario u = new Usuario();
                    u.setEmail(email);
                    u.setSenha(senha);
                    
                    System.out.println("Usuário inserido com sucesso:");
                    System.out.println("\tEmail:\t" + u.getEmail());
                    System.out.println("\tSenha:\t" + u.getSenha());
                    break;
                }
                case "2": {
                    System.out.println("");
                    System.out.println("===================");
                    System.out.println("||  NOVA TAREFA  ||");
                    System.out.println("===================");
                    System.out.print("Digite a descrição: ");
                    String descricao = sc.nextLine();
                    System.out.print("Digite a data: ");
                    String data = sc.nextLine();
                    
                    Tarefa t = new Tarefa();
                    t.setDescricao(descricao);
                    t.setData(data);
                    
                    System.out.println("Tarefa inserida com sucesso:");
                    System.out.println("\tDescrição:\t" + t.getDescricao());
                    System.out.println("\tData limite:\t" + t.getData());
                    break;
                }
                case "3": {
                    running = false;
                    System.out.println("Encerrando programa...");
                    break;
                }
                default: {
                    System.out.println("Opção inválida.");
                    break;
                }
            }
            
            System.out.println("Pressione enter para continuar...");
            sc.nextLine();
            
        }
        
        System.out.println("Programa encerrado.");
        
    }
    
}
