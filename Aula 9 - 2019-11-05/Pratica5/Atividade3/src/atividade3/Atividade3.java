package atividade3;

import java.util.Scanner;

public class Atividade3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        System.out.print("Digite o x: ");
        float x = sc.nextFloat();
        
        System.out.print("Digite o y: ");
        float y = sc.nextFloat();
        
        Calculadora c = new Calculadora();
        
        c.atribuirX(x);
        c.atribuirY(y);
        
        System.out.println("Soma\t= " + c.soma());
        System.out.println("Sub\t= " + c.sub());
        System.out.println("Mult\t= " + c.mult());
        System.out.println("Div\t= " + c.div());
        
    }

}
