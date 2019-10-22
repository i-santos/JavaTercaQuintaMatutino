/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula5terqui;

import java.util.Scanner;

/**
 *
 * @author Professor
 */
public class Usuario {

    static String nome;
    static String email;
    static String senha;

    static void pedirNome() {

        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o nome: ");
        nome = sc.nextLine();
        
    }

    static void pedirEmail() {

        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o email: ");
        email = sc.nextLine();
        
    }

    static void pedirSenha() {

        Scanner sc = new Scanner(System.in);
        System.out.print("Digite a senha: ");
        senha = sc.nextLine();
        
    }
    
    static void mostrarNome() {
        System.out.println("O nome do usuário é: " + nome);
    }
    
    static void mostrarEmail() {
        System.out.println("O email do usuário é: " + email);
    }
    
    static void mostrarSenha() {
        System.out.println("A senha do usuário é: " + senha);
    }
}
