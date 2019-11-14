package atividade4;

public class Calculadora {

    private float x;
    private float y;
    private float ultimoResultado;

    void atribuirX(float x) {
        this.x = x;
    }

    void atribuirY(float y) {
        this.y = y;
    }

    float soma() {
        ultimoResultado = x + y;
        return ultimoResultado;
    }

    float sub() {
        ultimoResultado = x - y;
        return ultimoResultado;
    }

    float mult() {
        ultimoResultado = x * y;
        return ultimoResultado;
    }

    float div() {
        ultimoResultado = x / y;
        return ultimoResultado;
    }

    void mostrarUltimoResultado() {
        System.out.println("Último Resultado: " + ultimoResultado);
    }
}
