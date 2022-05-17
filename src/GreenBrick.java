import java.awt.Color;
import java.awt.Graphics2D;

public class GreenBrick extends Brick {

  public GreenBrick(Game game, int x, int Y) {
    super(game, x, Y);
    // TODO Auto-generated constructor stub
  }

  public void assignHealthPoints(int healthPoints) {
    setHealthPoints(healthPoints);
  }

  @Override
  public void paint(Graphics2D g) {
    g.setColor(Color.GREEN);
    g.fillRect(x, Y, WITH, HEIGHT);
  }
}
