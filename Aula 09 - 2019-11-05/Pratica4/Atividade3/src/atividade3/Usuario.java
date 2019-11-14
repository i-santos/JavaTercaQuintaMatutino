package atividade3;

public class Usuario {

    private String email;
    private String nome;

    void atribuirEmail(String email) {
        this.email = email;
    }

    void atribuirNome(String nome) {
        this.nome = nome;
    }

    void mostrarEmail() {
        System.out.println("Email: " + email);
    }

    void mostrarNome() {
        System.out.println("Nome: " + nome);
    }

}
