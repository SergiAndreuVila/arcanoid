import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball {

  private static final int DIAMETER = 30;
  private int healthPoints = 3;

  int x = (Game.windowWidth / 2) - (DIAMETER / 2);
  int y = (Game.windowHeight / 2) - (DIAMETER / 2);
  int xa = 1;
  int ya = 1;

  int ballSpeed = 3;
  private Game game;

  public Ball(Game game) {
    this.game = game;
  }

  public int getHealthPoints() {
    return healthPoints;
  }

  public void setHealthPoints(int healthPoints) {
    this.healthPoints = healthPoints;
  }

  void move() {
    boolean changeDirection = true;
    if (x + xa < 0) {
      xa = ballSpeed;
    } else if (x + xa > game.getWidth() - DIAMETER) {
      xa = -ballSpeed;
    } else if (y + ya < 0) {
      ya = ballSpeed;
    } else if (y + ya > game.getHeight() - DIAMETER) {
      if (this.healthPoints > 0) {
        this.healthPoints--;
        y = (Game.windowHeight / 2) - (DIAMETER / 2);

      } else {
        game.gameOver();
      }

    } else if (collisionBall()) {
      ya = -ballSpeed;
      y = game.racquet.getTopY() - DIAMETER;
    } else if (collisionBrick()) {
      ya = -ya;
      xa = -xa;
    } else
      changeDirection = false;

    if (changeDirection)
      Sound.BALL.play();
    x = x + xa;
    y = y + ya;
  }

  private boolean collisionBall() {
    return game.racquet.getBounds().intersects(getBounds());
  }

  private boolean collisionBrick() {
    for (int i = 0; i < game.brickList.size(); i++) {
      if (game.brickList.get(i).getBounds().intersects(getBounds())) {
        if (game.brickList.get(i).getHealthPoints() > 0) {
          game.brickList.get(i).reduceHealthPoints();
          game.puntuation += 10;
        } else {
          game.brickList.get(i).deadAction(i);

          game.puntuation += 100;

        }

        return true;
      }
    }
    return false;
  }

  public void paint(Graphics2D g) {
    g.setColor(Color.BLUE);
    g.fillOval(x, y, DIAMETER, DIAMETER);
  }

  public Rectangle getBounds() {
    return new Rectangle(x, y, DIAMETER, DIAMETER);
  }
}
