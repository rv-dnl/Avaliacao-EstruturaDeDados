package application;

public class Consumidor {
    private Cliente cliente;

    public Consumidor(String nome, String email) {
        this.cliente = new Cliente(nome, email);
    }

    public String getNome() {
        return cliente.getNome();
    }

    public String getEmail() {
        return cliente.getEmail();
    }
}


