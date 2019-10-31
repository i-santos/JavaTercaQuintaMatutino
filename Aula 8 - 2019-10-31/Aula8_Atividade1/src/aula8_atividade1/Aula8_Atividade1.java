package aula8_atividade1;

import java.util.Scanner;

/**
 * ============================= ATIVIDADE 1 =================================
 * 
 * 1. Pedir para o usuário digitar o nome
 * 2. Mostrar o nome que o usuário digitou NA CLASSE USUÁRIO
 * 
 * Para isso, vamos precisar criar a classe Usuario.
 * 
 * Na classe Usuario, definimos um método "mostrarNome(String n)", que recebe
 *      uma String como parâmetro
 * 
 * @author Professor
 */

public class Aula8_Atividade1 {

    public static void main(String[] args) {
        
        // Instanciar o Scanner
        Scanner sc = new Scanner(System.in);
        
        // Pedir para o usuário digitar o nome
        String nome = sc.nextLine();
        
        // Instanciar um objeto da classe Usuario para PODERMOS CHAMAR o método
        //      mostrarNome(String n)
        // Se não instanciar o objeto, NÃO É POSSÍVEL chamar nenhum método da classe
        //      Usuario
        Usuario u = new Usuario();
        
        // Chamar o método para mostrar o nome e passar como PARÂMETRO o valor
        //      que está na variável "nome"
        u.mostrarNome(nome);
    }
    
}
