import java.awt.*;
import java.awt.event.*;

public class Player {
    private int x, y;
    private int speed = 5;
    private boolean up, down, left, right;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, 50, 50); // Desenha o jogador como um quadrado azul
    }

    public void update() {
        if (up) y -= speed;
        if (down) y += speed;
        if (left) x -= speed;
        if (right) x += speed;
    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W: up = true; break;
            case KeyEvent.VK_S: down = true; break;
            case KeyEvent.VK_A: left = true; break;
            case KeyEvent.VK_D: right = true; break;
            case KeyEvent.VK_SPACE: jump(); break;
        }
    }

    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W: up = false; break;
            case KeyEvent.VK_S: down = false; break;
            case KeyEvent.VK_A: left = false; break;
            case KeyEvent.VK_D: right = false; break;
        }
    }

    private void jump() {
        // Lógica para o salto (pode ser expandida)
    }

    public void shoot(int mouseX, int mouseY) {
        Bullet bullet = new Bullet(x + 25, y + 25, mouseX, mouseY);
        // Adicione lógica para gerenciar balas disparadas
    }
}
