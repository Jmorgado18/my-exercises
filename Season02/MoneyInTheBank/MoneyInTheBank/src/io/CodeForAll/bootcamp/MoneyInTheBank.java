package io.CodeForAll.bootcamp;

public class MoneyInTheBank {
    public static void main(String[] args) {
        // Criar uma pessoa
        Person pessoa = new Person("João");

        // Criar um banco para essa pessoa
        Bank banco = new Bank(pessoa);

        // Depositar e levantar dinheiro
        banco.depositar(100);
        banco.levantar(50);

        // Mostrar saldo atual
        System.out.println("Saldo atual: " + banco.getSaldo() + " euros");
    }
}

