package io.CodeForAll.bootcamp;
public class Bank {
    private Person cliente;
    private double saldo;

    // Construtor do banco
    public Bank(Person cliente) {
        this.cliente = cliente;
        this.saldo = 0.0;  // Saldo inicial é zero
    }

    // Método para depositar dinheiro
    public void depositar(double quantia) {
        if (quantia > 0) {
            saldo += quantia;
            System.out.println(cliente.getNome() + " depositou " + quantia + " euros.");
        } else {
            System.out.println("Quantia inválida para depósito.");
        }
    }

    // Método para levantar dinheiro
    public void levantar(double quantia) {
        if (quantia > 0 && quantia <= saldo) {
            saldo -= quantia;
            System.out.println(cliente.getNome() + " levantou " + quantia + " euros.");
        } else {
            System.out.println("Quantia inválida ou saldo insuficiente.");
        }
    }

    // Método para consultar o saldo
    public double getSaldo() {
        return saldo;
    }
}

