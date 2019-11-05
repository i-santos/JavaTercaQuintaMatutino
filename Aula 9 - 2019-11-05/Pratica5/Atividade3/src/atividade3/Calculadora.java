package atividade3;

public class Calculadora {

    private float x;
    private float y;
    
    void atribuirX(float x) {
        this.x = x;
    }
    
    void atribuirY(float y) {
        this.y = y;
    }
    
    float soma() {
        return x + y;
    }
    
    float sub() {
        return x - y;
    }
    
    float mult() {
        return x * y;
    }
    
    float div() {
        return x / y;
    }
}
