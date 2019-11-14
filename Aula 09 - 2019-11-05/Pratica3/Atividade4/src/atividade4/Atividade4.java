package atividade4;

public class Atividade4 {
    public static void main(String[] args) {
        Usuario u = new Usuario();
        
        String nome = u.pedirNome();
        String email = u.pedirEmail();
        System.out.println("Nome: " + nome);
        System.out.println("Email: " + email);
    }

}
