package atividade2;

import java.util.Scanner;

public class Usuario {

    private String email;
    private String nome;

    void pedirEmail() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o email: ");
        email = sc.nextLine();
    }

    void pedirNome() {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Digite o nome: ");
        nome = sc.nextLine();
    }
    
    void mostrarEmail() {
        System.out.println("Email: " + email);
    }
    
    void mostrarNome() {
        System.out.println("Nome: " + nome);
    }
}
