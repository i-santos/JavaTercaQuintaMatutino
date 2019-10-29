/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula7;

/**
 *
 * @author Professor
 */
public class Aula7ComparacaoString {
    public static void main(String[] args) {
        
        Usuario u1 = new Usuario();
        boolean igual;
     
        // Fazer a entrada de dados
        u1.pedirEmail();
        u1.pedirSenha();
        u1.pedirConfirmacaoSenha();
        
        // O método equals retorna TRUE se os valores de senha e confirmacaoSenha
        //  forem iguals; e retorna FALSE se NÃO forem iguais
        igual = u1.senha.equals(u1.confirmacaoSenha);
        
        // Mostrar o resultado na tela
        System.out.println("Senhas conferem: " + igual);
        
    }
}
