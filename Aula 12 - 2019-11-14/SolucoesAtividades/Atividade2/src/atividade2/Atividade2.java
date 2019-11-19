package atividade2;

import java.util.ArrayList;
import java.util.Scanner;

public class Atividade2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Usuario> usuarios = new ArrayList();

        for (int i = 0; i < 2; i++) {
            Usuario u = new Usuario();
            System.out.print("Digite o email do u" + i + ": ");
            u.setEmail(scanner.nextLine());
            System.out.print("Digite a senha do u" + i + ": ");
            u.setSenha(scanner.nextLine());

            ArrayList<Tarefa> tarefas = new ArrayList();

            for (int j = 0; j < 2; j++) {
                Tarefa t = new Tarefa();
                System.out.print("Digite a descricao da t" + j + ": ");
                t.setDescricao(scanner.nextLine());
                System.out.print("Digite se t" + j + " foi finalizada: ");
                t.setFinalizada(scanner.nextBoolean());
                scanner.nextLine();

                tarefas.add(t);

            }

            u.setTarefas(tarefas);
            usuarios.add(u);
        }

        for (int i = 0; i < usuarios.size(); i++) {
            Usuario u = usuarios.get(i);
            System.out.println("Usuario " + i + ": ");
            System.out.println("\tEmail: " + u.getEmail());
            System.out.println("\tSenha: " + u.getSenha());
            System.out.println("\tTarefas:");
            
            ArrayList<Tarefa> tarefas = u.getTarefas();
            
            for(int j = 0; j < tarefas.size(); j++) {
                Tarefa t = tarefas.get(j);
                System.out.println("\tTarefa " + j + ": ");
                System.out.println("\t\tDescrição: " + t.getDescricao());
                System.out.println("\t\tFinalizada: " + t.isFinalizada());
            }
            
        }

    }

}
