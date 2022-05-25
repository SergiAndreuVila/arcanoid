import java.awt.Color;
import java.awt.Graphics2D;

public class BlueBrick extends Brick implements Runnable {
  private int healthPoints = 0;
  private int speedBuffTime = 10000;

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
    new Thread(new Runnable() {

      public void run() {

        game.racquet.alterRacquetSpeed(true);
        try {
          game.clock.wait(speedBuffTime);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        game.racquet.alterRacquetSpeed(false);

      }
    }).start();

    game.brickList.remove(i);
  }

  @Override
  public void run() {
    // TODO Auto-generated method stub

  }

}
