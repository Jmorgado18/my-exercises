package io.CodeForAll.Bootcamp;

public class Playground {
    public static void main(String[] args) {
        Hotel hotel = new Hotel(5); // Hotel com 5 quartos
        Client client1 = new Client("John Doe");
        Client client2 = new Client("Jane Smith");

        System.out.println("Attempting check-in for John Doe:");
        hotel.checkIn(client1);

        System.out.println("\nAttempting check-in for Jane Smith:");
        hotel.checkIn(client2);

        System.out.println("\nClient checking out:");
        hotel.checkOut(client1);

        System.out.println("\nAttempting check-in again for Jane Smith:");
        hotel.checkIn(client2);
    }
}

