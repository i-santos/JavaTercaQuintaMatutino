package aula8;

public class Usuario {

    // ========================= 2. MÉTODO =========================
    // Um método é um PEDAÇO de código e possui seu próprio escopo
    // Precisamos DEFINIR um método para ele passar a existir no nosso código
    // Quando definimos um método, estamos CRIANDO um pedaço de código que 
    //      pertence ao escopo de uma classe
    // Esse pedaço de código NÃO é executado por padrão
    // Para executarmos esse pedaço de código (que é o método) precisamos fazer 
    //      a CHAMADA do método na main
    void mostrarNome(String n) {
        System.out.println("O nome é: " + n);
    }
}
