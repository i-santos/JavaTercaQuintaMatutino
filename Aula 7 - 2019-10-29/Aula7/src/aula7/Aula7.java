package aula7;

public class Aula7 {

    public static void main(String[] args) {

        // Instanciar 3 objetos da classe Usuario
        Usuario u1 = new Usuario();
        Usuario u2 = new Usuario();
        Usuario u3 = new Usuario();

        // Pedir os dados
        u1.pedirEmail();
        u1.pedirNome();
        u1.pedirSenha();

        u2.pedirEmail();
        u2.pedirNome();
        u2.pedirSenha();

        u3.pedirEmail();
        u3.pedirNome();
        u3.pedirSenha();

        // Mostrar os dados
        System.out.println();
        System.out.println("--------------");
        System.out.println("SAIDA DE DADOS");
        System.out.println("--------------");
        System.out.println();
        
        u1.mostrarEmail();
        u1.mostrarNome();
        u1.mostrarSenha();
        
        u2.mostrarEmail();
        u2.mostrarNome();
        u2.mostrarSenha();
        
        u3.mostrarEmail();
        u3.mostrarNome();
        u3.mostrarSenha();
    }

}
