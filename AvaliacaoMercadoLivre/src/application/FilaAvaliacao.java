package application;

import java.util.LinkedList;
import java.util.Queue;

public class FilaAvaliacao {
    private Queue<Avaliacao> fila = new LinkedList<>();

    public void adicionarAvaliacao(Avaliacao avaliacao) {
        fila.offer(avaliacao);
    }

    public Avaliacao removerAvaliacao() {
        return fila.poll();
    }

    public boolean estaVazia() {
        return fila.isEmpty();
    }

    public int tamanho() {
        return fila.size();
    }
}
