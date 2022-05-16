import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Game extends JPanel {

  int speed = 3;
  int brickPossX = 0;
  int brickPossY = 0;

  Ball ball = new Ball(this);
  Racquet racquet = new Racquet(this);
  Brick brick = new Brick(this, brickPossX, brickPossY);
  ArrayList<Brick> brickList = new ArrayList<Brick>();

  public static void main(String[] args) throws InterruptedException {
    Game a = new Game();
    a.principal();
  }

  public void principal() throws InterruptedException {
    JFrame frame = new JFrame("Mini Tennis");
    Game game = this;

    frame.add(game);
    frame.setSize(300, 400);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    for (int i = 0; i < 10; i++) {
      while (brickPossX < frame.getSize().getWidth()) {
        brickList.add(new RedBrick(game, brickPossX, brickPossY));

        brickPossX += 35;

        System.out.println("x: " + brickPossX);
      }
      brickPossX = 0;
      brickPossY += 15;
    }

    while (true) {
      game.move();
      game.repaint();
      Thread.sleep(10);
    }
  }

  private int getScore() {
    return speed - 1;
  }

  public Game() {
    addKeyListener(
      new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {}

        @Override
        public void keyReleased(KeyEvent e) {
          racquet.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
          racquet.keyPressed(e);
        }
      }
    );
    setFocusable(true);
    Sound.BACK.loop();
  }

  private void move() {
    ball.move();
    racquet.move();
  }

  @Override
  public void paint(Graphics g) {
    super.paint(g);
    Graphics2D g2d = (Graphics2D) g;
    g2d.setRenderingHint(
      RenderingHints.KEY_ANTIALIASING,
      RenderingHints.VALUE_ANTIALIAS_ON
    );
    ball.paint(g2d);
    racquet.paint(g2d);

    for (int i = 0; i < brickList.size(); i++) {
      System.out.println("i: " + i);
      brickList.get(i).paint(g2d);
    }

    g2d.setColor(Color.GRAY);
    g2d.setFont(new Font("Verdana", Font.BOLD, 30));
    g2d.drawString(String.valueOf(getScore()), 10, 30);
  }

  public void gameOver() {
    Sound.BACK.stop();
    Sound.GAMEOVER.play();
    JOptionPane.showMessageDialog(
      this,
      "your score is: " + getScore(),
      "Game Over",
      JOptionPane.YES_NO_OPTION
    );
    System.exit(ABORT);
  }
}
