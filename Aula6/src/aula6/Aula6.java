/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula6;

/**
 *
 * @author Professor
 */
public class Aula6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /**
         * A classe Usuario possui variáveis e métodos que NÃO SÃO static
         * Então, precisamos criar as variáveis e os métodos da classe na memória
         * 
         * Fazemos isso com o "new Usuario()"
         */
        Usuario u = new Usuario();
        Usuario u2 = new Usuario();
        
        // Chamar os métodos pra pedir as entradas do u e do u2
        u.pedirEmail();
        u.pedirNome();
        u.pedirSenha();
        u2.pedirEmail();
        u2.pedirNome();
        u2.pedirSenha();
        
        // Chamar os métodos pra mostrar os dados
        u.mostrarEmail();
        u.mostrarNome();
        u.mostrarSenha();
        u2.mostrarEmail();
        u2.mostrarNome();
        u2.mostrarSenha();
    }
    
}
