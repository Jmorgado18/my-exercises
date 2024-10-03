package io.bootcamp.codeforall;

public class Rooms {
    private boolean[] availableRooms;

    public Rooms(int totalRooms) {
        availableRooms = new boolean[totalRooms];
        for (int i = 0; i < totalRooms; i++) {
            availableRooms[i] = true;
        }
    }

    public int getAvailableRoom() {
        for (int i = 0; i < availableRooms.length; i++) {
            if (availableRooms[i]) {
                return i;
            }
        }
        return -1;
    }

    public void bookRoom(int roomNumber) {
        if (roomNumber >= 0 && roomNumber < availableRooms.length) {
            availableRooms[roomNumber] = false; // Marca o quarto como ocupado
        }
    }

    public void releaseRoom(int roomNumber) {
        if (roomNumber >= 0 && roomNumber < availableRooms.length) {
            availableRooms[roomNumber] = true; // Libera o quarto
        }
    }
}
