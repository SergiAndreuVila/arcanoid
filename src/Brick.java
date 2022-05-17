import java.awt.Graphics2D;
import java.awt.Rectangle;

public abstract class Brick {

    private Game game;
    protected int x;
    protected int Y;
    private int healthPoints;
    protected int HEIGHT = 30;
    protected int WITH = 90;

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

   public abstract void paint(Graphics2D g);

    public Rectangle getBounds() {
        return new Rectangle(x, Y, WITH, HEIGHT);
    }
 

}
