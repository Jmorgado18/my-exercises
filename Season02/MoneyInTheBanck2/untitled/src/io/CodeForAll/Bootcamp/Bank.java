package io.CodeForAll.bootcamp;

import io.CodeForAll.Bootcamp.Client;

public class Bank {
private Client client;
private double money;
// Construtor do banco
public Bank(Client client) {
this.client = client;
this.money = 0.0;
    }

    // Método para depositar dinheiro
    public void add(double howMuch) {
        if (howMuch > 0) {
            money += howMuch;
            System.out.println(client.getNome() + " depositou " + howMuch + " euros.");
        } else {
            System.out.println("Quantia inválida para depósito.");
        }

    }

    // Método para levantar dinheiro
    public void sub(double howMuch) {
        if (howMuch > 0 && howMuch <= money) {
            money -= howMuch;
            System.out.println(client.getNome() + " levantou " + howMuch + " euros.");
        } else {
            System.out.println("Quantia inválida ou saldo insuficiente.");
        }
    }

    // Método para consultar o saldo
    public double getSaldo() {
        System.out.println("Saldo atual: " + money + " euros");
        return money;
    }
}

