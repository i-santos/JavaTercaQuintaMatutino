/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package revisao;

import java.util.Scanner;

/**
 *
 * @author Professor
 */
public class Usuario {
    
    String pedirEmail() {
        // Para fazer a entrada de dados, precisamos da scanner
        Scanner sc = new Scanner(System.in);
        
        String email;
        System.out.print("Digite o email: ");
        email = sc.nextLine();
        
        // retornar o valor da variável email
        return email;
    }
    
    String pedirSenha() {
        // Para fazer a entrada de dados, precisamos da scanner
        Scanner sc = new Scanner(System.in);
        
        String senha;
        System.out.print("Digite senha: ");
        senha = sc.nextLine();
        
        // retornar o valor da variável senha
        return senha;
    }
    
    String pedirNome() {
        // Para fazer a entrada de dados, precisamos da scanner
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Digite o nome: ");
        
        // retornar o valor de retorno do método nextLine
        return sc.nextLine();
    }
    
}
