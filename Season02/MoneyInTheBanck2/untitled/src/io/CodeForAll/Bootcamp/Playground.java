
package io.CodeForAll.Bootcamp;

import io.CodeForAll.bootcamp.Bank;

public class Playground {
    public static void main(String[] args) {


        Client pessoa = new Client("João");

        pessoa.depositar(100);
        pessoa.levantar(50);
        System.out.println("Saldo Atual." + pessoa.consultarSaldo() + "euros");


        System.out.println("-------------------------");

        Client pessoa2 = new Client("David");
        pessoa2.depositar(30);
        pessoa2.levantar(50);
        System.out.println("Saldo Atual." + pessoa2.consultarSaldo() + "euros");

    }
}


