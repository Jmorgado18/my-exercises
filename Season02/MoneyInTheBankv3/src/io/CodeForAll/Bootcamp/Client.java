package io.CodeForAll.Bootcamp;

public class Client {
    private String name;
    private Bank bank;

    // Constructer
    public Client(String name) {
        this.name = name;
        this.bank = new Bank(this);


    }
    //Method that invoke other methods
    public void depositClient(double howMuch) {
        bank.deposit(howMuch);
    }

    public void withdrawClient(double howMuch) {
        bank.withdraw(howMuch);
    }

    public double getBalanceClient() {
        return bank.getBalance();
    }

    public String getName() {
        return name;

    }
}
