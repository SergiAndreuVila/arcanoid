import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Brick {

    private Game game;
    private int x = 1;
    private int Y = 1;
    private int HEIGHT = 5;
    private int WITH = 5;

    public Brick(Game game) {
        this.game = game;
    }

    public void paint(Graphics2D g) {
        g.fillRect(x, Y, WITH, HEIGHT);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, Y, WITH, HEIGHT);
    }
}
