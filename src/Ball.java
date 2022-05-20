import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball {

  private static final int DIAMETER = 30;

  int x = 200;
  int y = 200;
  int xa = 1;
  int ya = 1;
  private Game game;

  public Ball(Game game) {
    this.game = game;
  }

  void move() {
    boolean changeDirection = true;
    if (x + xa < 0) xa = game.speed; else if (
      x + xa > game.getWidth() - DIAMETER
    ) xa = -game.speed; else if (y + ya < 0) ya = game.speed; else if (
      y + ya > game.getHeight() - DIAMETER
    ) game.gameOver(); else if (collisionBall()) {
      ya = -game.speed;
      y = game.racquet.getTopY() - DIAMETER;
    } else if (collisionBrick()) {
      ya = -ya;
      xa = -xa;
    } else changeDirection = false;

    if (changeDirection) Sound.BALL.play();
    x = x + xa;
    y = y + ya;
  }

  private boolean collisionBall() {
    return game.racquet.getBounds().intersects(getBounds());
  }

  private boolean collisionBrick() {
    for (int i = 0; i < game.brickList.size(); i++) {
      if (game.brickList.get(i).getBounds().intersects(getBounds())) {
        if (game.brickList.get(i).getHealthPoints()> 0){
          game.brickList.get(i).reduceHealthPoints();
        }else{
          game.brickList.get(i).deadAction();
          
          game.brickList.remove(i);
          
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
