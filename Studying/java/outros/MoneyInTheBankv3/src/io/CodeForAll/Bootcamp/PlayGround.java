package io.CodeForAll.Bootcamp;

public class PlayGround {
    public static void main(String[] args) {


        Client person1 = new Client("Toy");
        person1.getBalanceClient();
        person1.depositClient(100);
        person1.withdrawClient(50);
        person1.getBalanceClient();

        System.out.println("-----------------------------");

        Client person2 = new Client("Ada");
        person2.getBalanceClient();
        person2.depositClient(100);
        person2.withdrawClient(200);
        person2.getBalanceClient();

    }
}