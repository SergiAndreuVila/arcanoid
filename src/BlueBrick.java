import java.awt.Color;
import java.awt.Graphics2D;

public class BlueBrick extends Brick {

  public BlueBrick(Game game, int x, int Y) {
    super(game, x, Y);
  }

  public void assignHealthPoints(int healthPoints) {
    setHealthPoints(healthPoints);
  }

  @Override
  public void paint(Graphics2D g) {
    g.setColor(Color.BLUE);
    g.fillRect(x, Y, WITH, HEIGHT);
  }
}
