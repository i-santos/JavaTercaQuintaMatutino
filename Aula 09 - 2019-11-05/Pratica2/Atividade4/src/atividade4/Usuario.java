package atividade4;

import java.util.Scanner;

public class Usuario {

    static String pedirNome() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o nome: ");
        String nome = sc.nextLine();
        return nome;
    }
}
