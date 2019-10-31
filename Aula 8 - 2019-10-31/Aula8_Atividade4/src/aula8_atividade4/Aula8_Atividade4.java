package aula8_atividade4;

import java.util.Scanner;

/**
 * ============================= ATIVIDADE 4 ==============================
 * 
 * 1. Pedir para o usuário digitar o valor de x
 * 2. Pedir para o usuário digitar o valor de y
 * 3. Criar a classe Calculadora
 * 4. Definir os métodos "soma", "subtracao", "multiplicacao" e "divisao"
 * 5. Os métodos vão apenas CALCULAR os resultados
 * 6. Usar os resultados que os métodos RETORNAM e mostrar na main
 * 
 * 7. ou seja: 
 *      - pedir os valores de x e y NA MAIN
 *      - calcular os resultados nos MÉTODOS DA CLASSE Calculadora
 *      - mostrar os resultados NA MAIN
 * 
 * @author Professor
 */
public class Aula8_Atividade4 {

    public static void main(String[] args) {
        // Instanciar objeto da classe Scanner
        Scanner sc = new Scanner(System.in);
        
        // Pedir os valores de x e y
        // x
        int x = sc.nextInt();
        // y
        int y = sc.nextInt();
        
        // Instanciar um objeto da classe Calculadora
        Calculadora c = new Calculadora();
        
        // Chamar os métodos e pegar o RETORNO
        int resultadoSoma = c.soma(x, y);
        int resultadoSub  = c.subtracao(x, y);
        int resultadoMult = c.multiplicacao(x, y);
        int resultadoDiv  = c.divisao(x, y);
        
        // Mostrar na tela
        System.out.println("Soma = " + resultadoSoma);
        System.out.println("Sub  = " + resultadoSub);
        System.out.println("Mult = " + resultadoMult);
        System.out.println("Div  = " + resultadoDiv);
    }

}
