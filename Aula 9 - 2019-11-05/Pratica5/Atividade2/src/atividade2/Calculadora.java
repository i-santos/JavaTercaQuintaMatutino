package atividade2;

import java.util.Scanner;

public class Calculadora {

    private float x;
    private float y;
    
    void pedirX() {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Digite o x: ");
        x = sc.nextFloat();
    }
    
    void pedirY() {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Digite o y: ");
        y = sc.nextFloat();
    }
    
    void soma() {
        System.out.println("Soma\t= " + (x + y));
    }
    
    void sub() {
        System.out.println("Sub\t= " + (x - y));
    }
    
    void mult() {
        System.out.println("Mult\t= " + (x * y));
    }
    
    void div() {
        System.out.println("Div\t= " + (x / y));
    }
}
