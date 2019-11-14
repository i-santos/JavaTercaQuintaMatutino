package aula8_atividade5;

import java.util.Scanner;

/**
 * ============================== Atividade 5 =============================
 * 
 * 1. Criar uma classe Usuario
 * 2. Criar uma variável de classe em Usuario: private String email;
 * 3. Criar uma variável de classe em Usuario: private String senha;
 * 4. Criar uma variável de classe em Usuario: private String nome;
 *
 * 5. Pedir para o usuário digitar valores para email, senha e nome NA MAIN
 * 6. Atribuir esses valores nas respectivas variáveis de classe
 * 7. Pegar os valores das variáveis de classe e mostrar na tela NA MAIN
 * 
 * @author Professor
 */
public class Aula8_Atividade5 {

    public static void main(String[] args) {
        // Instanciar objeto da classe Scanner
        Scanner scanner = new Scanner(System.in);
        
        // Pedir para digitar email, senha e nome
        // email
        System.out.print("Digite o email: ");
        String email = scanner.nextLine();
        // senha
        System.out.print("Digite a senha: ");
        String senha = scanner.nextLine();
        // nome
        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();
        
        // Atribuir os valores nas variáveis de classe em Usuario
        // Para isso, primeiro precisa instanciar um objeto da classe Usuario
        Usuario u = new Usuario();
        
        u.atribuirEmail(email);
        u.atribuirSenha(senha);
        u.atribuirNome(nome);
        
        // Pegar os valores das variáveis de classe em Usuario e mostrar na tela
        System.out.println("Email: " + u.pegarEmail());
        System.out.println("Senha: " + u.pegarSenha());
        System.out.println("Nome: " + u.pegarNome());
        
    }
    
}
