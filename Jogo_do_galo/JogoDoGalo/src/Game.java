import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

public class Game implements MouseHandler {
    private static final int GRID_SIZE = 3;
    private Rectangle[][] grid;
    private String[][] marks;
    private int currentPlayer;

    public Game() {
        this.grid = new Rectangle[GRID_SIZE][GRID_SIZE];
        this.marks = new String[GRID_SIZE][GRID_SIZE];
        this.currentPlayer = 0; // 0 for X, 1 for O
        initGrid();

        // Instancia o Mouse e registra o Game como handler
        new Mouse(this);
    }

    private void initGrid() {
        int rectSize = 150;
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                grid[i][j] = new Rectangle(10 + j * rectSize, 10 + i * rectSize, rectSize, rectSize);
                grid[i][j].draw();
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();

        // Verifica em qual quadrado o clique ocorreu
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if (isInsideRectangle(x, y, grid[i][j]) && marks[i][j] == null) {
                    placeMark(i, j); // Coloca X ou O
                    if (isWinningMove()) {
                        System.out.println("Jogador " + (currentPlayer == 0 ? "X" : "O") + " ganhou!");
                    }
                    currentPlayer = (currentPlayer + 1) % 2; // Alterna entre os jogadores
                }
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }

    // Verifica se o clique está dentro do retângulo
    private boolean isInsideRectangle(int x, int y, Rectangle rectangle) {
        return x >= rectangle.getX() && x <= rectangle.getX() + rectangle.getWidth() &&
                y >= rectangle.getY() && y <= rectangle.getY() + rectangle.getHeight();
    }

    // Coloca a marca no grid
    private void placeMark(int i, int j) {
        marks[i][j] = currentPlayer == 0 ? "X" : "O"; // Armazena a marca
        Text text = new Text(grid[i][j].getX() + 30, grid[i][j].getY() + 30, marks[i][j]);
        text.grow(20, 20);
        text.draw();
    }

    // Verifica se houve uma jogada vencedora
    private boolean isWinningMove() {
        // Lógica para verificar se alguém ganhou
        return false; // Implementar verificação de vitória
    }

    public static void main(String[] args) {
        new Game(); // Inicia o jogo
    }
}
