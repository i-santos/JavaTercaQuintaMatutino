package atividade1;

import java.util.Scanner;

public class Atividade1 {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Usuario u = new Usuario();
        
        System.out.print("Digite o email: ");
        u.email = sc.nextLine();
        System.out.print("Digite o nome: ");
        u.nome = sc.nextLine();
        
        System.out.println("Email: " + u.email);
        System.out.println("Nome: " + u.nome);
    }

}
