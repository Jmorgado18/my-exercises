package io.CodeForAll.Bootcamp;

public class Client {
    private String name;
    private int roomNumber;

    public Client(String name) {
        this.name = name;
        this.roomNumber = -1; // -1 indica que o cliente não está em nenhum quarto
    }

    public String getName() {
        return name;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
}

