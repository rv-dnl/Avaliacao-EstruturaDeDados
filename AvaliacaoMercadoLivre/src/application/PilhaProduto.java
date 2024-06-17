package application;

import java.util.LinkedList;
import java.util.List;

public class PilhaProduto {
    private LinkedList<Produto> elementos = new LinkedList<>();

    public void empilhar(Produto produto) {
        elementos.push(produto);
    }

    public Produto desempilhar() {
        return elementos.pop();
    }

    public Produto topo() {
        return elementos.peek();
    }

    public boolean estaVazia() {
        return elementos.isEmpty();
    }

    public List<Produto> getElementos() {
        return new LinkedList<>(elementos);
    }

    public Produto get(int index) {
        if (index >= 0 && index < elementos.size()) {
            return elementos.get(index);
        } else {
            return null;
        }
    }

    public int getTamanho() {
        return elementos.size();
    }
}
