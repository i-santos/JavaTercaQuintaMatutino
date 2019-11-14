package atividade4;

import java.util.Scanner;

public class Atividade4 {
    public static void main(String[] args) {
        
        String s = pegarMensagem();
        
        System.out.println("A mensagem digitada foi: " + s);
    }
    
    static String pegarMensagem() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        
        return s;
    }

}
