package atividade3;

import java.util.Scanner;

public class Atividade3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        System.out.print("Digite o email: ");
        String email = sc.nextLine();
        System.out.print("Digite o nome: ");
        String nome = sc.nextLine();
        
        Usuario u = new Usuario();
        
        u.atribuirEmail(email);
        u.atribuirNome(nome);
        
        u.mostrarEmail();
        u.mostrarNome();
    }

}
