package atividade1;

import java.util.ArrayList;
import java.util.Scanner;

public class Atividade1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Usuario> usuarios = new ArrayList();
        
        for(int i = 0; i < 3; i++) {
            System.out.print("Digite o email: ");
            String email = sc.nextLine();
            
            System.out.print("Digite o nome: ");
            String nome = sc.nextLine();
            
            System.out.print("Digite a senha: ");
            String senha = sc.nextLine();
            
            Usuario u = new Usuario();
            
            u.atribuirEmail(email);
            u.atribuirNome(nome);
            u.atribuirSenha(senha);
            
            usuarios.add(u);
        }
        
        for(int i = 0; i < usuarios.size(); i++) {
            Usuario u = usuarios.get(i);
            
            System.out.println("Usuario " + i);
            System.out.println("\tEmail: " + u.pegarEmail());
            System.out.println("\tNome: " + u.pegarNome());
            System.out.println("\tSenha: " + u.pegarSenha());
        }
    }

}
