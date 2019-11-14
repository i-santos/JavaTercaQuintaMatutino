package atividade1;

import java.util.Scanner;

public class Atividade1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        Calculadora c = new Calculadora();
        System.out.print("Digite o x: ");
        c.x = sc.nextFloat();
        
        System.out.print("Digite o y: ");
        c.y = sc.nextFloat();
        
        c.soma();
        c.sub();
        c.mult();
        c.div();
    }

}
