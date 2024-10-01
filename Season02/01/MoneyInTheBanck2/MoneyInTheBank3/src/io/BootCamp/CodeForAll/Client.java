package io.BootCamp.CodeForAll;

public class Client {
    private String nome;
    private double money;
    private Bank bank1;

    public Client(String nome, double money, Bank bank) {
        this.nome = nome;
        this.money = money;
        this.bank1=bank;

        bank.Add(19);

    }


    }
}
