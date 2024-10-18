import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Menu implements MouseHandler {

    private Picture background;
    private boolean gameStarted = false;
    private boolean isMenuActive = true; // Flag to track menu state
    private Clip clickClip;





    public Menu() {
        // Display the menu options
        showMenu();


        // Register mouse handler
        Mouse mouse = new Mouse(this);
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
    }

    private void showMenu() {
        background = new Picture(10,10, "TicTacToev2/rsc/Background2.jpg");
        background.draw();
        playBackgroundMusic("TicTacToev2/rsc/Backgroundmusic.wav");
        loadClickSound("TicTacToev2/rsc/Click.wav"); // Load click sound



    }

    @Override
    public void mouseClicked(MouseEvent event) {
        playClickSound(); // Play sound on click
        int x = (int) event.getX();
        int y = (int) event.getY();

        // Adjust click areas for "Start Game"
        // Further widening the clickable area
        if (isMenuActive) {
            if (x >= 740 && x <= 950 && y >= 570 && y <= 620) { // Increased width and height range
                startGame();
            }

            // Adjust click areas for "Exit"
            if (x >= 800 && x <= 880 && y >= 680 && y <= 710) {
                System.exit(0);
            }
        }
    }



    private void startGame() {
        gameStarted = true;
        clearMenu(); // Clear the menu screen
        new GameWindow();// Start the game by initializing the game window
        isMenuActive = false;
    }

    private void clearMenu() {
        stopBackgroundMusic();
        background.delete();
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        // Not used
    }

    public boolean isGameStarted() {
        return gameStarted;
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
