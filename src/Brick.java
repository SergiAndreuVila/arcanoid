import java.awt.Graphics2D;
import java.awt.Rectangle;

public abstract class Brick {

    protected Game game;
    protected int x;
    protected int Y;    
    protected int HEIGHT = 30;
    protected int WITH = 90;
    private int healthPoints;

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

   public abstract void paint(Graphics2D g);

    public Rectangle getBounds() {
        return new Rectangle(x, Y, WITH, HEIGHT);
    }

    public int getHealthPoints() {
        return healthPoints;
    }
    
    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }
    
    public void reduceHealthPoints(){
      this.healthPoints --;
    }
    public void deadAction(){
  
    }
 

}
