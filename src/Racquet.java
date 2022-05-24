import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Racquet {

  private static final int Y = 630;
  private static final int WITH = 90;
  private static final int HEIGHT = 10;
  int x = 0;
  int xa = 0;
  private static int racquetSpeed = 3;
  private Game game;

  public Racquet(Game game) {
    this.game = game;
  }

  public void move() {
    if (x + xa > 0 && x + xa < game.getWidth() - WITH)
      x = x + xa;
  }

  public void paint(Graphics2D g) {
    g.setColor(Color.GRAY);
    g.fillRect(x, Y, WITH, HEIGHT);
  }

  public void keyReleased(KeyEvent e) {
    xa = 0;
  }

  public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_LEFT)
      xa = -racquetSpeed;
    if (e.getKeyCode() == KeyEvent.VK_RIGHT)
      xa = racquetSpeed;
  }

  public Rectangle getBounds() {
    return new Rectangle(x, Y, WITH, HEIGHT);
  }

  public int getTopY() {
    return Y - HEIGHT;
  }

  public void alterRacquetSpeed( boolean modSpeed) {
    if (modSpeed){
      Racquet.racquetSpeed += 3;
    }
    else if (!modSpeed){
      Racquet.racquetSpeed -= 3;
    }
    
  }
}
