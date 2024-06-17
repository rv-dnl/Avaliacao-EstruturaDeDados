package application;

public class Vendedor {
    private Cliente cliente;

    public Vendedor(String nome, String email) {
        this.cliente = new Cliente(nome, email);
    }

    public String getNome() {
        return cliente.getNome();
    }

    public String getEmail() {
        return cliente.getEmail();
    }
}
