package atividade3;

import java.util.Scanner;

public class Atividade3 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        mostrarMensagem(s);
    }
    
    static void mostrarMensagem(String msg) {
        System.out.println(msg);
    }

}
