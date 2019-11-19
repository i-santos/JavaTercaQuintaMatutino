package atividade1;

import java.util.ArrayList;
import java.util.Scanner;

public class Atividade1 {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        ArrayList<Usuario> usuarios = new ArrayList();
        
        for (int i = 0; i < 3; i++) {
            Usuario u = new Usuario();
            System.out.print("Digite o email do u" + i + ": ");
            u.setEmail(scanner.nextLine());
            System.out.print("Digite a senha do u" + i + ": ");
            u.setSenha(scanner.nextLine());
            
            Tarefa t = new Tarefa();
            System.out.print("Digite a tarefa do u" + i + ": ");
            t.setDescricao(scanner.nextLine());
            System.out.print("Digite se a tarefa foi finalizada: ");
            t.setFinalizada(scanner.nextBoolean());
            scanner.nextLine();
            
            u.setTarefa(t);
            
            usuarios.add(u);
        }
        
        for (int i = 0; i < usuarios.size(); i++) {
            Usuario u = usuarios.get(i);
            System.out.println("Usuario " + i + ": ");
            System.out.println("\tEmail: " + u.getEmail());
            System.out.println("\tSenha: " + u.getSenha());
            
            Tarefa t = u.getTarefa();
            System.out.println("\tTarefa:");
            System.out.println("\t\tDescrição:" + t.getDescricao());
            System.out.println("\t\tFinalizada:" + t.isFinalizada());
        }
        
    }
    
}
