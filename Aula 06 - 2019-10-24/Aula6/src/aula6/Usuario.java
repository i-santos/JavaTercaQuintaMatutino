/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula6;

import java.util.Scanner;

/**
 *
 * @author Professor
 */
public class Usuario {
    /**
     * Uma variável com static:
     * 1. Já é criada na memória ANTES do programa começar a executar
     * 2. É um espaço na memória COMPARTILHADO
     */
    static String cidade;
    
    /**
     * Sem static agora: ou seja, NÃO são criadas na memória de antemão e NÃO 
     * são compartilhadas
     */
    String email;
    String nome;
    String senha;
    
    void pedirEmail() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o email: ");
        email = sc.nextLine();
    }
    void pedirNome() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome: ");
        nome = sc.nextLine();
    }
    void pedirSenha() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a senha: ");
        senha = sc.nextLine();
    }
    
    void mostrarEmail() {
        System.out.println("Email: " + email);
    }
    void mostrarNome() {
        System.out.println("Nome: " + nome);
    }
    void mostrarSenha() {
        System.out.println("Senha: " + senha);
    }
}
