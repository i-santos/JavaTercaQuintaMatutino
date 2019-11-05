package atividade4;

public class Usuario {

    private String email;
    private String nome;
    
    void atribuirEmail(String email) {
        this.email = email;
    }
    
    void atribuirNome(String nome) {
        this.nome = nome;
    }
    
    String pegarEmail() {
        return email;
    }
    
    String pegarNome() {
        return nome;
    }
}
