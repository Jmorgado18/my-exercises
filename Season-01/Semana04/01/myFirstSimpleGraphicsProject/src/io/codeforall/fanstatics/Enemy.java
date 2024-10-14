import java.awt.*;

public class Enemy {
    private int x, y;

    public Enemy(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(x, y, 50, 50); // Desenha o inimigo como um quadrado verde
    }
}
