package application;

public class ListaDuplaCliente {
    private Cliente cliente;
    private ListaDuplaCliente anterior;
    private ListaDuplaCliente proximo;
    private ArvoreCompra arvoreCompra; 

    public ListaDuplaCliente(Cliente cliente) {
        this.cliente = cliente;
        this.anterior = null;
        this.proximo = null;
        this.arvoreCompra = new ArvoreCompra(); 
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ListaDuplaCliente getAnterior() {
        return anterior;
    }

    public void setAnterior(ListaDuplaCliente anterior) {
        this.anterior = anterior;
    }

    public ListaDuplaCliente getProximo() {
        return proximo;
    }

    public void setProximo(ListaDuplaCliente proximo) {
        this.proximo = proximo;
    }

  
    public void associarVendedorProduto(Vendedor vendedor, Produto produto) {
        arvoreCompra.inserirAssociacao(produto, vendedor);
    }

    public Vendedor obterVendedorPorProduto(Produto produto) {
        return arvoreCompra.obterVendedorPorProduto(produto);
    }
}
