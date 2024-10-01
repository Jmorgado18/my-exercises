package io.CodeForAll.Bootcamp;

public class Rooms {
    private boolean[] availableRooms;

    public Rooms(int totalRooms) {
        availableRooms = new boolean[totalRooms];
        for (int i = 0; i < totalRooms; i++) {
            availableRooms[i] = true; // Inicializa todos os quartos como disponíveis
        }
    }

    public int getAvailableRoom() {
        for (int i = 0; i < availableRooms.length; i++) {
            if (availableRooms[i]) {
                return i; // Retorna o número do quarto disponível
            }
        }
        return -1; // Retorna -1 se não houver quartos disponíveis
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

