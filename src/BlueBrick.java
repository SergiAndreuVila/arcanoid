import java.awt.Color;
import java.awt.Graphics2D;

<<<<<<< HEAD
public class BlueBrick extends Brick implements Runnable {
  private int healthPoints =0;
=======
public class BlueBrick extends Brick {
  private int healthPoints = 0;
>>>>>>> 875277d9f9d13a84d814f1c7823bfa8c67113f5e

  public BlueBrick(Game game, int x, int Y, int height, int width) {
    super(game, x, Y, height, width);
  }

  public void assignHealthPoints(int healthPoints) {
    setHealthPoints(healthPoints);
  }

  @Override
  public void paint(Graphics2D g) {
    g.setColor(Color.decode("#109AE5"));
    g.fillRect(x, Y, WIDTH, HEIGHT);
  }

  public int getHealthPoints() {
    return healthPoints;
  }

  public void setHealthPoints(int healthPoints) {
    this.healthPoints = healthPoints;
  }

  public void reduceHealthPoints() {
    this.healthPoints--;
  }

  public void deadAction(int i) {

    game.brickList.remove(i);
  }

}
