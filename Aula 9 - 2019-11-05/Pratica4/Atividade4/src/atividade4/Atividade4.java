package atividade4;

import java.util.Scanner;

public class Atividade4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        System.out.print("Digite o email: ");
        String email = sc.nextLine();
        System.out.print("Digite o nome: ");
        String nome = sc.nextLine();
        
        Usuario u = new Usuario();
        
        u.atribuirEmail(email);
        u.atribuirNome(nome);
        
        System.out.println("Email: " + u.pegarEmail());
        System.out.println("Nome: " + u.pegarNome());
    }

}
