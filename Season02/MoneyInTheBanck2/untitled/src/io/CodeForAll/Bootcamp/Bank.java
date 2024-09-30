package io.CodeForAll.bootcamp;

import io.CodeForAll.Bootcamp.Client;

public class Bank {
    private Client client;
    private double money;

    // Construtor do banco
    public Bank(Client client) {
        this.client = client;
        this.money = 0.0;  // Saldo inicial é zero
    }

    // Método para depositar dinheiro
    public void Add(double howMuch) {
        if (howMuch > 0) {
            money += howMuch;
            System.out.println(client.getNome() + " depositou " + howMuch + " euros.");
        } else {
            System.out.println("Quantia inválida para depósito.");
        }
    }

    // Método para levantar dinheiro
    public void Sub(double howMuch) {
        if (howMuch > 0 && howMuch <= money) {
            money -= howMuch;
            System.out.println(client.getNome() + " levantou " + howMuch + " euros.");
        } else {
            System.out.println("Quantia inválida ou saldo insuficiente.");
        }
    }

    // Método para consultar o saldo
    public double getSaldo() {
        return money;
    }
}

