package io.CodeForAll.Bootcamp;

public class Playground {
    public static void main(String[] args) {
        Hotel hotel = new Hotel(1); // Hotel com 5 quartos
        Client client1 = new Client("João");
        Client client2 = new Client("Cristina");

        System.out.println("Attempting check-in for " + client1.getName());
        hotel.checkIn(client1);

        System.out.println("Attempting check-in for " +  client2.getName());
        hotel.checkIn(client2);

        System.out.println(client1.getName() + " checking out:");
        hotel.checkOut(client1);

        System.out.println("Attempting check-in again for " + client2.getName());
        hotel.checkIn(client2);
    }
}

