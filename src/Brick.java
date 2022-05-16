import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Brick {

    private Game game;
    private int x;
    private int Y;
    private int healthPoints;
    private int HEIGHT = 10;
    private int WITH = 30;

    public Brick(Game game, int x, int Y) {
        this.game = game;
        this.setX(x);
        this.setY(Y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int Y) {
        this.Y = Y;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public void assignHealthPoints(int healthPoints) {
        setHealthPoints(healthPoints);
    }

    public void paint(Graphics2D g) {
        g.fillRect(x, Y, WITH, HEIGHT);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, Y, WITH, HEIGHT);
    }
}
