package application;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        PilhaProduto produtos = new PilhaProduto();
        ArvoreCompra compras = new ArvoreCompra();
        FilaAvaliacao filaAvaliacoes = new FilaAvaliacao(); 

 
        produtos.empilhar(new Produto("Notebook", 2500.00));
        produtos.empilhar(new Produto("Smartphone", 1500.00));
        produtos.empilhar(new Produto("Tablet", 800.00));

        int escolha;
        ListaDuplaCliente clientes = null; 

        do {
            System.out.println("\nSelecione uma opção:");
            System.out.println("1 - Consumidor");
            System.out.println("2 - Vendedor");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            escolha = scanner.nextInt();
            scanner.nextLine(); 

            switch (escolha) {
                case 1:
                    System.out.println("\nCadastrar Consumidor:");
                    System.out.print("Nome: ");
                    String nomeConsumidor = scanner.nextLine();
                    System.out.print("Email: ");
                    String emailConsumidor = scanner.nextLine();
                    Consumidor consumidor = new Consumidor(nomeConsumidor, emailConsumidor);
                    Cliente clienteConsumidor = new Cliente(consumidor.getNome(), consumidor.getEmail());
                    clientes = new ListaDuplaCliente(clienteConsumidor);

                    boolean continuarConsumidor = true;
                    while (continuarConsumidor) {
                        System.out.println("\nProdutos disponíveis:");
                        int index = 1;
                        for (Produto produto : produtos.getElementos()) {
                            System.out.println(index++ + ". " + produto);
                        }

                        System.out.print("Escolha o número do produto que deseja comprar (0 para sair): ");
                        int escolhaProduto = scanner.nextInt();
                        scanner.nextLine(); 

                        if (escolhaProduto == 0) {
                            continuarConsumidor = false;
                        } else if (escolhaProduto > 0 && escolhaProduto <= produtos.getTamanho()) {
                            Produto produtoEscolhido = produtos.get(escolhaProduto - 1);
                            Compra compra = new Compra(consumidor, produtoEscolhido);
                            compras.inserir(compra);
                            System.out.println("\nCompra realizada: " + produtoEscolhido);

                         
                            System.out.print("Avalie o produto " + produtoEscolhido.getNome() + " (de 0 a 10): ");
                            int notaProduto = scanner.nextInt();
                            scanner.nextLine(); 

                            Avaliacao avaliacaoProduto = new Avaliacao(produtoEscolhido, notaProduto);
                            filaAvaliacoes.adicionarAvaliacao(avaliacaoProduto);
                            System.out.println("Avaliação registrada para o produto.");
                        } else {
                            System.out.println("\nProduto inválido.");
                        }
                    }
                    break;
                case 2:
                    System.out.println("\nCadastrar Vendedor:");
                    System.out.print("Nome: ");
                    String nomeVendedor = scanner.nextLine();
                    System.out.print("Email: ");
                    String emailVendedor = scanner.nextLine();
                    Vendedor vendedor = new Vendedor(nomeVendedor, emailVendedor);
                    Cliente clienteVendedor = new Cliente(vendedor.getNome(), vendedor.getEmail());
                    clientes = new ListaDuplaCliente(clienteVendedor);

                    boolean continuarVendedor = true;
                    while (continuarVendedor) {
                        System.out.println("\nCadastrar Produto:");
                        System.out.print("Nome: ");
                        String nomeProduto = scanner.nextLine();
                        System.out.print("Preço: ");
                        double precoProduto = scanner.nextDouble();
                        scanner.nextLine(); 

                        Produto produto = new Produto(nomeProduto, precoProduto);
                        produtos.empilhar(produto);

                        System.out.print("Deseja cadastrar outro produto? (s/n): ");
                        String resposta = scanner.nextLine().trim().toLowerCase();
                        continuarVendedor = resposta.equals("s");
                    }
                    break;
                case 0:
                    System.out.println("\nEncerrando o programa.");
                    break;
                default:
                    System.out.println("\nOpção inválida. Escolha novamente.");
                    break;
            }

           
            if (clientes != null) {
             
            }

        } while (escolha != 0);

        scanner.close();
        System.out.println("\n<< AV3 Estrutura de Dados >>");
    }
}
