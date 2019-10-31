/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula8_atividade5;

/**
 *
 * @author Professor
 */
public class Usuario {
    private String email;
    private String senha;
    private String nome;
    
    void atribuirEmail(String e) {
        email = e;
    }
    
    void atribuirSenha(String s) {
        senha = s;
    }
    
    void atribuirNome(String n) {
        nome = n;
    }
    
    String pegarEmail() {
        return email;
    }
    
    String pegarSenha() {
        return senha;
    }
    
    String pegarNome() {
        return nome;
    }
}
