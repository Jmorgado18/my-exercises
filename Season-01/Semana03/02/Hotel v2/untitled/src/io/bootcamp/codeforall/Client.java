package io.bootcamp.codeforall;

public class Client {
    private String name;
    private int roomNumber;

    public Client(String name) {
        this.name = name;// -1 indica que o cliente não está em nenhum quarto
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