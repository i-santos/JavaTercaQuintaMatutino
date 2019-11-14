package aula8_atividade3;

/**
 * ========================= ATIVIDADE 3 ================================
 * 
 * 1. Criar uma classe Usuario
 * 
 * 2. Definir um método para pedir para o usuário digitar nome
 * 3. Mostrar o nome na MAIN
 * 4. ou seja: pegar nome no método da classe Usuario e MOSTRAR o nome na main
 * 
 * 5. Definir um método para pedir para o usuário digitar email
 * 6. Mostrar o email na main
 * 7. ou seja: pegar email no método da classe Usuario e mostrar na main
 * 
 * 8. Definir um método para pedir para o usuário digitar senha
 * 9. Mostrar a senha na main
 * 10. ou seja: pegar a senha no método da classe Usuario e mostrar na main
 *
 * @author Professor
 */
public class Aula8_Atividade3 {

    public static void main(String[] args) {
        
        // Instanciar um objeto da classe Usuario
        Usuario u = new Usuario();
        
        // Chamar os métodos e pegar o RETORNO dos métodos
        String email = u.pedirEmail();
        String nome = u.pedirNome();
        String senha = u.pedirSenha();
        
        // Mostrar na main
        System.out.println("O email é: " + email);
        System.out.println("O nome é: " + nome);
        System.out.println("A senha é: " + senha);
    }
    
}
