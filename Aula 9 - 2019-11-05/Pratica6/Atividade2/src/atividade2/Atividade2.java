package atividade2;

import java.util.ArrayList;
import java.util.Scanner;

public class Atividade2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Tarefa> tarefas = new ArrayList();
        
        for(int i = 0; i < 3; i++) {
            System.out.print("Digite o título: ");
            String titulo = scanner.nextLine();
            
            Tarefa t = new Tarefa();
            t.atribuirTitulo(titulo);
            t.atribuirFinalizada(false);
            
            tarefas.add(t);
        }
        
        for(int i = 0; i < tarefas.size(); i++) {
            Tarefa t = tarefas.get(i);
            
            System.out.println("Tarefa " + i);
            System.out.println("\tTítulo: " + t.pegarTitulo());
            System.out.println("\tFinalizada: " + t.pegarFinalizada());
        }
    }

}
