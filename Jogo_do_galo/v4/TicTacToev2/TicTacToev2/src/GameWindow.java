import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameWindow implements MouseHandler {

    private TicTacToe game;  // Instance of the game logic
    private final int cellSize = 300; // Size of each cell in the grid
    private final int PADDING = 10;
    private Text message; // To display game messages
    private Text scoreBoard1;
    private Text scoreBoard2; // To display the scoreboard
    private List<Picture> pictureList; // To track X and O pictures
    private Picture gridPicture; // To track the grid image
    private int player1Wins = 0; // Counter for Player 1 wins
    private int player2Wins = 0; // Counter for Player 2 wins
    private boolean gameOver = false; // Flag to track if the game is over
    private boolean isMenuActive = true; // Flag to track menu state
    private Clip clickClip;

    public GameWindow() {
        pictureList = new ArrayList<>(); // Initialize the list for tracking X and O pictures
        startNewGame(); // Start the game by initializing everything
        playBackgroundMusic("TicTacToev2/rsc/Backgroundmusic.wav"); // Start background music
        loadClickSound("TicTacToev2/rsc/Click.wav"); // Load click sound
    }

    // Start or reset the game
    private void startNewGame() {
        game = new TicTacToe(); // Create a new TicTacToe game instance
        drawGrid(); // Draw the grid only once at the start
        updateScoreBoard(); // Display the score
        gameOver = false; // Reset game over flag

        // Initialize mouse handling
        Mouse mouse = new Mouse(this);
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED); // Listen for mouse clicks
        drawBoard(); // Initial drawing of the board
    }


    // Update the scoreboard
    private void updateScoreBoard() {

        // Display the score at the top of the grid
        Picture picture = new Picture(1080, 420, "TicTacToev2/rsc/scoreboard.png");
        picture.draw();
        scoreBoard1 = new Text(PADDING + 1215, PADDING + 650, player1Wins + "");
        scoreBoard2 = new Text(PADDING + 1435, PADDING + 650, player2Wins + "");
        scoreBoard1.grow(40, 60);  // Adjust size for visibility
        scoreBoard1.setColor(Color.BLACK);
        scoreBoard1.draw();
        scoreBoard2.grow(40, 60);  // Adjust size for visibility
        scoreBoard2.setColor(Color.BLACK);
        scoreBoard2.draw();
    }

    // Handle mouse clicks
    @Override
    public void mouseClicked(MouseEvent event) {
        playClickSound(); // Play sound on click
        handleMouseClick((int) event.getX(), (int) event.getY());
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        // Not used
    }

    // Handle mouse clicks on the grid
    private void handleMouseClick(int x, int y) {
        // Do nothing if the game is over
        if (gameOver) {
            return;
        }

        int row = (y - PADDING) / cellSize; // Adjust to account for padding
        int col = (x - PADDING) / cellSize; // Adjust to account for padding

        // Check if the move is valid and update the game board
        if (row >= 0 && row < 3 && col >= 0 && col < 3 && game.makeMove(row, col)) {
            drawBoard();

            // Check for a winner or draw
            if (game.isWinner('X')) {
                player1Wins++;  // Increment Player 1's score
                displayMessage("Player 1 wins!");
                updateScoreBoard();  // Update the scoreboard
                gameOver = true; // Set game over
                delayReset();
            } else if (game.isWinner('O')) {
                player2Wins++;  // Increment Player 2's score
                displayMessage("Player 2 wins!");
                updateScoreBoard();  // Update the scoreboard
                gameOver = true; // Set game over
                delayReset();
            } else if (game.isBoardFull()) {
                displayMessage("Draw!");
                updateScoreBoard();
                gameOver = true;// Set game over
                delayReset();
            }
        }
    }

    private void drawGrid() {
        // Delete the old grid picture if it exists
        if (gridPicture != null) {
            gridPicture.delete();
        }

        // Redraw the grid using Rectangle objects (for interaction purposes)
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Rectangle cell = new Rectangle(j * cellSize + PADDING, i * cellSize + PADDING, cellSize, cellSize);
                cell.setColor(Color.WHITE); // Set color for the rectangle
                cell.draw(); // Draw the rectangle border
            }
        }

        // Draw the pretty grid as a picture on top
        Picture background = new Picture(PADDING,PADDING, "TicTacToev2/rsc/Background.jpg");
        background.draw();
        Picture titlex = new Picture(1100,50, "TicTacToev2/rsc/x.png");
        Picture titleo = new Picture(1360,50, "TicTacToev2/rsc/o.png");
        Picture title = new Picture(1160,0, "TicTacToev2/rsc/Title.png");
        titlex.draw();
        titleo.draw();
        title.draw();
        gridPicture = new Picture(50 + PADDING, 20 + PADDING, "TicTacToev2/rsc/Grid.png");
        gridPicture.draw(); // Draw the picture of the grid
    }

    // Draw the current state of the board
    private void drawBoard() {
        char[][] board = game.getBoard();

        // Draw only the X's and O's based on the current state of the board
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == 'X') {
                    drawX(row, col);
                } else if (board[row][col] == 'O') {
                    drawO(row, col);
                }
            }
        }
    }

    // Draw an X in the given cell
    private void drawX(int row, int col) {
        int padding = 40; // Padding for centering
        int x = col * cellSize + padding; // X coordinate for the picture's top-left corner
        int y = row * cellSize + padding; // Y coordinate for the picture's top-left corner

        Picture picture = new Picture(x + PADDING, y + PADDING, "TicTacToev2/rsc/x.png");
        picture.draw();
        pictureList.add(picture); // Track the picture for later deletion
    }

    // Draw an O in the given cell
    private void drawO(int row, int col) {
        int padding = 20; // Padding for centering
        int x = col * cellSize + padding; // X coordinate for the picture's top-left corner
        int y = row * cellSize + padding; // Y coordinate for the picture's top-left corner

        Picture picture = new Picture(x + PADDING, y + PADDING, "TicTacToev2/rsc/o.png");
        picture.draw();
        pictureList.add(picture); // Track the picture for later deletion
    }

    // Display a message on the canvas
    // Store a Picture object to track the current message
    private Picture messagePicture;

    // Display a message using an image
    private void displayMessage(String messageType) {
        // Delete the previous message picture if it exists
        if (messagePicture != null) {
            messagePicture.delete(); // Clear the previous message picture
        }

        // Calculate the center of the grid for message placement
        int centerX = (cellSize * 3 + PADDING * 2) / 2; // Total width of the grid divided by 2
        int centerY = (cellSize * 3 + PADDING * 2) / 2; // Total height of the grid divided by 2

        // Depending on the message type, select the corresponding image
        switch (messageType) {
            case "Player 1 wins!":
                messagePicture = new Picture(centerX - 485, centerY - 200, "TicTacToev2/rsc/Player1.png"); // Adjust coordinates and image path
                playMusic("TicTacToev2/rsc/Player1wins.wav");
                break;
            case "Player 2 wins!":
                messagePicture = new Picture(centerX - 485, centerY - 200, "TicTacToev2/rsc/Player2.png"); // Adjust coordinates and image path
                playMusic("TicTacToev2/rsc/Player2wins.wav");
                break;
            case "Draw!":
                messagePicture = new Picture(centerX - 500, centerY - 280, "TicTacToev2/rsc/Draw.png"); // Adjust coordinates and image path
                playMusic("TicTacToev2/rsc/Draw.wav");
                break;
        }

        // Draw the message image
        if (messagePicture != null) {
            messagePicture.draw();
        }
    }


    // Reset the game and clear everything
    public void resetGame() {
        // Clear the game state
        game.reset(); // Reset the TicTacToe game logic

        // Clear all the X and O pictures
        for (Picture picture : pictureList) {
            picture.delete(); // Delete the picture from the canvas
        }
        pictureList.clear(); // Clear the list of pictures

        // Redraw the grid and reset the grid picture
        drawGrid(); // Redraw the grid

        // Clear the message
        if (message != null) {
            message.delete();
            message = null;
        }

        // Reinitialize the game and mouse event listener after reset
        startNewGame(); // Restart everything after reset
    }

    // Create a new method to handle the reset with a delay
    private void delayReset() {
        // Use a separate thread to avoid blocking the main thread
        new Thread(() -> {
            try {
                // Wait for 2.5 seconds before resetting the game to allow the message to be visible
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Reset the game after the delay
            resetGame();
        }).start();
    }
    private Clip backgroundClip;

    public void playBackgroundMusic(String soundFile) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundFile));
            backgroundClip = AudioSystem.getClip();
            backgroundClip.open(audioInputStream);
            backgroundClip.loop(Clip.LOOP_CONTINUOUSLY); // Loop the music
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    // Method to stop the music
    public void stopBackgroundMusic() {
        if (backgroundClip != null && backgroundClip.isRunning()) {
            backgroundClip.stop();
        }
    }

    private Clip winClip;

    public void playMusic(String soundFile) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundFile));
            winClip = AudioSystem.getClip();
            winClip.open(audioInputStream);
            winClip.start();

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    private void loadClickSound(String soundFile) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundFile));
            clickClip = AudioSystem.getClip();
            clickClip.open(audioInputStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    private void playClickSound() {
        if (clickClip != null) {
            if (clickClip.isRunning()) {
                clickClip.stop(); // Stop if already playing
            }
            clickClip.setFramePosition(0); // Rewind to the beginning
            clickClip.start(); // Play the sound
        }
    }
}
