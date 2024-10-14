import java.awt.*;

public class Bullet {
    private int x, y;
    private int speed = 10;

    public Bullet(int startX, int startY, int targetX, int targetY) {
        this.x = startX;
        this.y = startY;
        // Adicione lógica para direcionar a bala em direção ao alvo
    }

    public void update() {
        // Atualize a posição da bala
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(x, y, 10, 10); // Desenha a bala como um círculo vermelho
    }
}
