package io.CodeForAll.Bootcamp;

public class Bank {

     private Client client;
    private double money;

    //Constructer
    public Bank(Client client) {
        this.client = client;
        this.money = 0.0;
    }

    // Method to Deposit
    public void deposit(double howMuch) {
        if (howMuch > 0) {
            money += howMuch;
            System.out.println(client.getName() + " deposited " + howMuch + " euros.");
            return;
        }
        System.out.println("Invalid quantity for deposit.");
    }

    // Method to withdraw
    public void withdraw(double howMuch) {
        if (howMuch > 0 && howMuch <= money) {
            money -= howMuch;
            System.out.println(client.getName() + " withdrew  " + howMuch + " euros.");
        } else {
            System.out.println("Invalid amount or insufficient balance.");
        }
    }

    // Method to see balance
    public double getBalance() {
        System.out.println("Actual balance: " + money + " euros.");
        return money;
    }
}