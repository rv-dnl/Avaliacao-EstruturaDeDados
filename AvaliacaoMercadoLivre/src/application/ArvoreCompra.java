package application;

public class ArvoreCompra {
    private class No {
        Compra compra;
        Vendedor vendedor;
        No esquerda, direita;

        No(Compra compra) {
            this.compra = compra;
            this.vendedor = null; 
        }
    }

    private No raiz;

    public void inserir(Compra compra) {
        raiz = inserirRecursivo(raiz, compra);
    }

    private No inserirRecursivo(No raiz, Compra compra) {
        if (raiz == null) {
            return new No(compra);
        }
        if (compra.getConsumidor().getNome().compareTo(raiz.compra.getConsumidor().getNome()) < 0) {
            raiz.esquerda = inserirRecursivo(raiz.esquerda, compra);
        } else {
            raiz.direita = inserirRecursivo(raiz.direita, compra);
        }
        return raiz;
    }

   
    public void inserirAssociacao(Produto produto, Vendedor vendedor) {
        raiz = inserirAssociacaoRecursivo(raiz, produto, vendedor);
    }

    private No inserirAssociacaoRecursivo(No raiz, Produto produto, Vendedor vendedor) {
        if (raiz == null) {
            return null; 
        }

      
        int comparacao = produto.getNome().compareTo(raiz.compra.getProduto().getNome());
        if (comparacao < 0) {
            raiz.esquerda = inserirAssociacaoRecursivo(raiz.esquerda, produto, vendedor);
        } else if (comparacao > 0) {
            raiz.direita = inserirAssociacaoRecursivo(raiz.direita, produto, vendedor);
        } else {
            
            raiz.vendedor = vendedor;
        }

        return raiz;
    }

    
    public Vendedor obterVendedorPorProduto(Produto produto) {
        return obterVendedorPorProdutoRecursivo(raiz, produto);
    }

    private Vendedor obterVendedorPorProdutoRecursivo(No raiz, Produto produto) {
        if (raiz == null) {
            return null; 
        }

     
        int comparacao = produto.getNome().compareTo(raiz.compra.getProduto().getNome());
        if (comparacao < 0) {
            return obterVendedorPorProdutoRecursivo(raiz.esquerda, produto);
        } else if (comparacao > 0) {
            return obterVendedorPorProdutoRecursivo(raiz.direita, produto);
        } else {
          
            return raiz.vendedor;
        }
    }
}
