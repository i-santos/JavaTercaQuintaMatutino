package atividade5;

public class Calculadora {

    private float ultimoX;
    private float ultimoY;
    private String ultimaOperacao;
    private float ultimoResultado;

    float soma(float x, float y) {
        ultimoX = x;
        ultimoY = y;
        ultimaOperacao = "+";
        ultimoResultado = x + y;
        return ultimoResultado;
    }

    float sub(float x, float y) {
        ultimoX = x;
        ultimoY = y;
        ultimaOperacao = "-";
        ultimoResultado = x - y;
        return ultimoResultado;
    }

    float mult(float x, float y) {
        ultimoX = x;
        ultimoY = y;
        ultimaOperacao = "*";
        ultimoResultado = x * y;
        return ultimoResultado;
    }

    float div(float x, float y) {
        ultimoX = x;
        ultimoY = y;
        ultimaOperacao = "/";
        ultimoResultado = x / y;
        return ultimoResultado;
    }

    void mostrarUltimaOperacao() {
        System.out.println("Última operação: "
                + ultimoX
                + " " + ultimaOperacao + " "
                + ultimoY
                + " = " + ultimoResultado
        );
    }
}
