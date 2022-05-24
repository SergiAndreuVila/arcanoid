import java.awt.Color;
import java.awt.Graphics2D;

public class RedBrick extends Brick {
  private int healthPoints = 1;

  public RedBrick(Game game, int x, int Y, int height, int width) {
    super(game, x, Y, height, width);
  }

  public void assignHealthPoints(int healthPoints) {
    setHealthPoints(healthPoints);
  }

  @Override
  public void paint(Graphics2D g) {
    if (this.healthPoints == 1) {
      g.setColor(Color.decode("#AA160E"));
    } else {
      g.setColor(Color.decode("#ED271D"));
    }
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
