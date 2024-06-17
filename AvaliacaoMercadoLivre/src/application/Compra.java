package application;

public class Compra {
    private Consumidor consumidor;
    private Produto produto;

    public Compra(Consumidor consumidor, Produto produto) {
        this.consumidor = consumidor;
        this.produto = produto;
    }

    public Consumidor getConsumidor() {
        return consumidor;
    }

    public Produto getProduto() {
        return produto;
    }
}
