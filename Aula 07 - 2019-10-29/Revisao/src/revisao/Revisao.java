package revisao;

public class Revisao {

    /**
     * REVISÃO: Retorno
     * 
     * @param args 
     */
    public static void main(String[] args) {
        
        String emailDaMain;
        Usuario u = new Usuario();
        
        emailDaMain = u.pedirEmail();
        
        System.out.println("O email é: " + emailDaMain);
    }
    
}
