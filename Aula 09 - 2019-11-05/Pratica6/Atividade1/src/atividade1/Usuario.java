package atividade1;

public class Usuario {
    
    private String email;
    private String nome;
    private String senha;
    
    void atribuirEmail(String email) {
        this.email = email;
    }
    
    void atribuirNome(String nome) {
        this.nome = nome;
    }
    
    void atribuirSenha(String senha) {
        this.senha = senha;
    }
    
    String pegarEmail() {
        return email;
    }
    
    String pegarNome() {
        return nome;
    }
    
    String pegarSenha() {
        return senha;
    }

}
