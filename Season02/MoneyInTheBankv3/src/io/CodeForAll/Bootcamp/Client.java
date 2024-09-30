package io.CodeForAll.Bootcamp;

public class Client {
    private String name;
    private Bank bank;

    // Constructer
    public Client(String name) {
        this.name = name;
        this.bank = new Bank(this);


    }
    //Methos that invoke other methods
    public void depositClient(double quantia) {
        bank.deposit(quantia);
    }

    public void withdrawClient(double quantia) {
        bank.withdraw(quantia);
    }

    public double getBalanceClient() {
        return bank.getBalance();
    }

    public String getNome() {
        return name;

    }
}
