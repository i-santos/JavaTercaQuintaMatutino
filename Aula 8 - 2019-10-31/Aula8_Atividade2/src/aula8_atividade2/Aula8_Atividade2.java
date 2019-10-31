package aula8_atividade2;

import java.util.Scanner;

/**
 * =========================== ATIVIDADE 2 ===========================
 * 
 * 1. Pedir para o usuário digitar valores para x e y
 * 2. Criar a classe Calculadora
 * 3. Criar métodos para mostrar na tela a soma, subtração, divisão e multiplicação
 * 
 * @author Professor
 */
public class Aula8_Atividade2 {

      public static void main(String[] args) {
        
          // Instanciar objeto da classe Scanner
          Scanner scanner = new Scanner(System.in);
          
          // Pedir os valores de x e y
          int x;
          int y;
          // x
          System.out.print("Digite o valor de x: ");
          x = scanner.nextInt();
          // y
          System.out.print("Digite o valor de y: ");
          y = scanner.nextInt();
          
          // Chamar os métodos da classe Calculadora para mostrar os resultados
          // Para isso, precisa instanciar um objeto da classe Calculadora
          Calculadora c = new Calculadora();
          
          // Chamar cada um dos métodos, passando x e y como PARÂMETROS
          c.soma(x, y);
          c.subtracao(x, y);
          c.multiplicacao(x, y);
          c.divisao(x, y);
    }
    
}
