import java.awt.Color;
import java.awt.Graphics2D;

public class BlueBrick extends Brick {
  private int healthPoints = 0;

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
