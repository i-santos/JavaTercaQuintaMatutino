
package aula11;

import java.util.ArrayList;
import java.util.Scanner;

public class Aula11 {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        ArrayList<Usuario> usuarios = new ArrayList();
        ArrayList<Tarefa> tarefas = new ArrayList();
        
        // Fazer um laço de repetição para pedir 3 vezes os dados de um usuario
        for(int i = 0; i < 3; i++) {
            // Pular Linha
            System.out.println("");
            // Instanciar um novo usuario (em cada laço, um novo objeto é criado)
            Usuario u = new Usuario();
            System.out.print("Digite o email do u" + i + ": ");
            u.setEmail(scanner.nextLine());
            System.out.print("Digite a senha do u" + i + ": ");
            u.setSenha(scanner.nextLine());
            
            // Adicionar usuario no array
            usuarios.add(u);
        }
        
        // Fazer a mesma coisa para as tarefas
        for(int i = 0; i < 3; i++) {
            // Pular linha
            System.out.println("");
            Tarefa t = new Tarefa();
            System.out.print("Digite a descrição da t" + i + ": ");
            t.setDescricao(scanner.nextLine());
            System.out.print("Digite o status da t" + i + ": ");
            t.setStatus(scanner.nextBoolean());
            // limpar buffer
            scanner.nextLine();
            
            tarefas.add(t);
        }
        
        // Mostrar todos os usuarios adicionados no array
        System.out.println("");
        System.out.println("======== USUARIOS ========");
        for(int i = 0; i < usuarios.size(); i++) {
            
            Usuario u = usuarios.get(i);
            System.out.println("");
            System.out.println("U" + i + ":");
            System.out.println("Email: " + u.getEmail());
            System.out.println("Senha: " + u.getSenha());
        }

        // Mostrar todas as tarefas adicionadas no array
        System.out.println("");
        System.out.println("======== TAREFAS ========");
        for(int i = 0; i < tarefas.size(); i++) {
            System.out.println("");
            System.out.println("T" + i + ":");
            System.out.println("Descrição: " + tarefas.get(i).getDescricao());
            System.out.println("Status: " + tarefas.get(i).isStatus());
        }      
        
        
    }
    
}
