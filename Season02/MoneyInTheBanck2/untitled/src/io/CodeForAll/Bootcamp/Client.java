package io.CodeForAll.Bootcamp;

import io.CodeForAll.bootcamp.Bank;

public class Client {
    private String nome;
    private Bank bank;

    public Client(String nome) {
        this.nome = nome;
        this.bank = new Bank(this);
    }

    public void depositar(double quantia) {
        bank.add(quantia);
    }
    public void levantar(double quantia) {
        bank.sub(quantia);
    }
    public double consultarSaldo() {
        return bank.getSaldo();
    }
    public String getNome() {
        return nome;

    }
}
