package atividade5;

import java.util.Scanner;

public class Atividade5 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        
        System.out.println("Soma\t= " + soma(x, y));
        System.out.println("Sub\t= " + sub(x, y));
        System.out.println("Mult\t= " + mult(x, y));
        System.out.println("Div\t= " + div(x, y));
    }
    
    static int soma(int x, int y) {
        return x + y;
    }
    
    static int sub(int x, int y) {
        return x - y;
    }
    
    static int mult(int x, int y) {
        return x * y;
    }
    
    static float div(float x, float y) {
        return x / y;
    }

}
