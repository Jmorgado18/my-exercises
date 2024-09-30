package io.CodeForAll.Bootcamp;

public class Client {
private String nome; private Bank bank;
// Construtor
public Client (String nome) {
this.nome = nome;
this. bank = new
Bank(this); // Associa o banco ao cliente
}
// Métodos de depósito e levantamento, que interagem com o
Bank
public void depositar (double
quantia) {
bank. Add (quantia);
}
public void levantar(double
quantia) {
bank. Sub (quantia);
}
public double consultarSaldo ( {
return bank getSaldo ();
}
// Getter para o nome
public String getNome () {
return nome;