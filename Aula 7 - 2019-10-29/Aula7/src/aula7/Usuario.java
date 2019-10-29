package aula7;

import java.util.Scanner;

public class Usuario {

    /**
     * Declaração das variáveis de classe
     */
    String email;
    String senha;
    String confirmacaoSenha;
    String nome;

    /**
     * Métodos de classe
     */
    void pedirEmail() {

        // Instanciar o scanner
        Scanner sc = new Scanner(System.in);

        // Pedir o email para o usuário
        System.out.print("Digite o email: ");
        email = sc.nextLine();
    }

    void pedirSenha() {

        // Instanciar o scanner
        Scanner sc = new Scanner(System.in);

        // Pedir o email para o usuário
        System.out.print("Digite a senha: ");
        senha = sc.nextLine();
    }
    
    void pedirConfirmacaoSenha() {

        // Instanciar o scanner
        Scanner sc = new Scanner(System.in);

        // Pedir o email para o usuário
        System.out.print("Repita a senha: ");
        confirmacaoSenha = sc.nextLine();
    }

    void pedirNome() {

        // Instanciar o scanner
        Scanner sc = new Scanner(System.in);

        // Pedir o email para o usuário
        System.out.print("Digite o nome: ");
        nome = sc.nextLine();
    }

    void mostrarEmail() {
        System.out.println("O email é " + email);
    }

    void mostrarSenha() {

        System.out.println("O email é " + senha);
    }

    void mostrarNome() {

        System.out.println("O email é " + nome);
    }

}
