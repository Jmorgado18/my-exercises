
package io.CodeForAll.Bootcamp;

import io.CodeForAll.bootcamp.Bank;

public class Playground {
    public static void main(String[] args) {


        Client pessoa = new Client("João");
        Bank bank = new Bank(pessoa);
        bank.Add(100);
        bank.Sub(50);
        System.out.println("Saldo atual: " + bank.getSaldo() + " euros");

        Client pessoa2 = new Client("David");
        Bank bank2 = new Bank(pessoa2);
        bank2.Add(20);
        bank2.Sub(12.5);
        System.out.println("Saldo atual: " + bank2.getSaldo() + " euros");
    }
}


