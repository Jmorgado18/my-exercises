public class Hint {

    private int startRow;
    private int startCol;
    private String direction;

    public Hint(int startRow, int startCol, String direction) {
        this.startRow = startRow;
        this.startCol = startCol;
        this.direction = direction;
    }

    public void provideHint() {
        System.out.println("Dica: A palavra começa na linha " + (startRow + 1) + ", coluna " + (startCol + 1) +
                " e segue na direção: " + direction);
    }
}
