
package io.CodeForAll.Bootcamp;

import io.CodeForAll.bootcamp.Bank;

public class Playground {


    public static void main(String[] args) {

        Client pessoa3 = new Client("Ze");

        //Duas pessoas a partilhar o mesmo banco

        Client pessoa = new Client("João");

        pessoa.consultarSaldo();
        pessoa.depositar(100);
        pessoa.levantar(50);
        pessoa.consultarSaldo();

        System.out.println("-------------------------");

        Client pessoa2 = new Client("David");

        pessoa.consultarSaldo();
        pessoa2.depositar(30);
        pessoa2.levantar(50);
        pessoa2.consultarSaldo();

    }
}


