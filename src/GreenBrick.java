import java.awt.Color;
import java.awt.Graphics2D;

public class GreenBrick extends Brick {

  private int healthPoints = 2;

  public GreenBrick(Game game, int x, int Y, int height, int width) {
    super(game, x, Y, height, width);
  }

  public void assignHealthPoints(int healthPoints) {
    setHealthPoints(healthPoints);
  }

  @Override
  public void paint(Graphics2D g) {

    if (this.healthPoints == 2) {
      g.setColor(Color.decode("#417C3C"));
    } else if (this.healthPoints == 1) {
      g.setColor(Color.decode("#57A550"));
    } else {
      g.setColor(Color.decode("#88C383"));
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
