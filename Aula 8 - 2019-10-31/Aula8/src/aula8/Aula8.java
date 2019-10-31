package aula8;

import java.util.Scanner;

public class Aula8 {

    public static void main(String[] args) {
        
        // ========================= 1. VARIÁVEL LOCAL =========================
        // Uma variável LOCAL é uma variável que só existe no escopo de um método
        // Exemplo de declaração de uma variável local:
        //  Tipo            : String
        //  Identificador   : nome
        String nome;
        // A variável "nome" acima é LOCAL porque foi declarada LOCALMENTE no 
        //  escopo da main
        
        // Outro exemplo de variável LOCAL: isto é, que foi declarada no escopo
        //  do método main e, portanto, só é acessível ao método main
        // Tipo         : Scanner
        // Identificador: sc
        Scanner sc = new Scanner(System.in);
        
        // Como declarar uma variável local??
        // 1. especificamos o TIPO da variável (int, float, double, String,
        //  Scanner, boolean, etc.)
        // 2. damos um identificado para ela
        
        // Entrada de dados
        nome = sc.nextLine();
        
        // Mais uma variável local
        // Tipo         : Usuario
        // Identificador: u
        Usuario u = new Usuario();
        
        // CHAMADA para o método "mostrarNome" de "u"
        // PASSAGEM do valor da variável "nome" como PARÂMETRO para o método
        u.mostrarNome(nome);
        
        //======================================================================
        
        
    }
    
}
