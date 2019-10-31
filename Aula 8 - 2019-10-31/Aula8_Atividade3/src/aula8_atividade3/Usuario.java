package aula8_atividade3;

import java.util.Scanner;

public class Usuario {
    
    /**
     * Para definir um método:
     * 1. Especificar o tipo de RETORNO : String
     * 2. Dar um identificador          : pedirEmail
     * 3. Parênteses                    : ()
     * 4. Definir corpo com chaves      : {}
     * 
     * 5. ou seja, juntando tudo fica: String pedirEmail() { }
     * 
     */
    String pedirEmail() {
        // Pedir para o usuário digitar o email
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o email: ");
        String email = scanner.nextLine();
        
        // Retornar o valor que o usuário digitou
        return email;
    }
    
    String pedirNome() {
        // Pedir para o usuário digitar o nome
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();
        
        // Retornar o valor que o usuário digitou
        return nome;
    }
    
    String pedirSenha() {
        // Pedir para o usuário digitar a senha
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a senha: ");
        String senha = scanner.nextLine();
        
        // Retornar o valor que o usuário digitou
        return senha;
    }
}
