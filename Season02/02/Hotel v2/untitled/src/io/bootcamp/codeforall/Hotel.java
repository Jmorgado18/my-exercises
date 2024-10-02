package io.bootcamp.codeforall;

public class Hotel {
    private Rooms rooms;

    public Hotel(int totalRooms) {
        this.rooms = new Rooms(totalRooms);
    }

    public void checkIn(Client client) {
        int availableRoom = rooms.getAvailableRoom();
        if (availableRoom != -1) {
            client.setRoomNumber(availableRoom);
            rooms.bookRoom(availableRoom);
            System.out.println(client.getName() + " checked into room " + availableRoom);
        } else {
            System.out.println("Sorry, no rooms available.");
        }
    }

    public void checkOut(Client client) {
        int roomNumber = client.getRoomNumber();
        if (roomNumber != -1) {
            rooms.releaseRoom(roomNumber);
            System.out.println(client.getName() + " checked out from room " + roomNumber);
            client.setRoomNumber(-1); // Libera o quarto do cliente
        } else {
            System.out.println(client.getName() + " is not checked into any room.");
        }
    }
}
