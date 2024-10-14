import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Game extends JPanel implements ActionListener, KeyListener, MouseListener {
    private Player player;
    private Map gameMap;
    private Timer timer;

    public Game() {
        this.player = new Player(100, 100); // Posição inicial do jogador
        this.gameMap = new Map();
        this.timer = new Timer(16, this); // Aproximadamente 60 FPS
        this.setFocusable(true);
        this.addKeyListener(this);
        this.addMouseListener(this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        gameMap.draw(g);
        player.draw(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player.update();
        gameMap.update(player);
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        player.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        player.keyReleased(e);
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void mouseClicked(MouseEvent e) {
        player.shoot(e.getX(), e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("2D Game");
        Game game = new Game();
        frame.add(game);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
