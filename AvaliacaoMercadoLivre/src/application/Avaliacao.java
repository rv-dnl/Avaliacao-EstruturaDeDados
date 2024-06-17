package application;

public class Avaliacao {
    private Object avaliado;
    private int nota;

    public Avaliacao(Object avaliado, int nota) {
        this.avaliado = avaliado;
        this.nota = nota;
    }

    public Object getAvaliado() {
        return avaliado;
    }

    public int getNota() {
        return nota;
    }
}
