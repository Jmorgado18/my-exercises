package io.BootCamp.CodeForAll;

public class Bank {
    private Client client;
    private double money;

    public Bank(Client client) {
        this.client = client;

    }

    public double Add(double howMuch){
        money+=howMuch;
        return money;
    }

    public double Sub (Double howMuch){
        money-=howMuch;
        System.out.println("");
        return money;
    }

    public void getSaldo(){
        System.out.println("Saldo Atual: " + money + " euros");

    }

}