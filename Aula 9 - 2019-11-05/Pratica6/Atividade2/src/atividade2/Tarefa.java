package atividade2;

public class Tarefa {

    private String titulo;
    private boolean finalizada;
    
    void atribuirTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    void atribuirFinalizada(boolean finalizada) {
        this.finalizada = finalizada;
    }
    
    String pegarTitulo() {
        return titulo;
    }
    
    boolean pegarFinalizada() {
        return finalizada;
    }
}
