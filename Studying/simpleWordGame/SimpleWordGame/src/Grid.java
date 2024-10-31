import java.util.Random;

public class Grid {

    private static final char[] LETTERS = {'D', 'O', 'G'};
    private char[][] grid;
    private int rows, cols;
    private Random random = new Random();

    public Grid(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.grid = new char[rows][cols];
    }

    public void fillWithRandomLetters() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = LETTERS[random.nextInt(LETTERS.length)];
            }
        }
    }

    public Hint placeWord(String word) {
        int wordLength = word.length();
        boolean placed = false;
        int startRow = 0, startCol = 0;
        String directionPlaced = "";

        while (!placed) {
            startRow = random.nextInt(rows);
            startCol = random.nextInt(cols);

            String[] directions = {"Horizontal direita", "Vertical para baixo", "Diagonal para baixo e à direita",
                    "Diagonal para baixo e à esquerda", "Horizontal esquerda", "Vertical para cima",
                    "Diagonal para cima e à esquerda", "Diagonal para cima e à direita"};
            int[][] moves = {
                    {0, 1}, {1, 0}, {1, 1}, {1, -1},
                    {0, -1}, {-1, 0}, {-1, -1}, {-1, 1}
            };
            int choice = random.nextInt(directions.length);
            int[] direction = moves[choice];

            int endRow = startRow + direction[0] * (wordLength - 1);
            int endCol = startCol + direction[1] * (wordLength - 1);

            if (endRow >= 0 && endRow < rows && endCol >= 0 && endCol < cols) {
                for (int i = 0; i < wordLength; i++) {
                    int row = startRow + i * direction[0];
                    int col = startCol + i * direction[1];
                    grid[row][col] = word.charAt(i);
                }
                directionPlaced = directions[choice];
                placed = true;
            }
        }
        return new Hint(startRow, startCol, directionPlaced);
    }

    public void printGrid() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
