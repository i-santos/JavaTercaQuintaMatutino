package atividade5;

import java.util.Scanner;

public class Atividade5 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculadora c = new Calculadora();
        
        System.out.print("Digite o x: ");
        int x = sc.nextInt();
        System.out.print("Digite o y: ");
        int y = sc.nextInt();
        
        System.out.println("Soma\t=" + c.soma(x, y));
        System.out.println("Sub\t=" + c.sub(x, y));
        System.out.println("Mult\t=" + c.mult(x, y));
        System.out.println("Div\t=" + c.div(x, y));
    }

}
