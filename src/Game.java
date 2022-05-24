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

  // Brick parameters
  int brickPossX = 0;
  int brickPossY = 0;
  int brickRows = 7;
  int brickHeight = 30;
  int brickWidth = 90;
  int spaceBetweenBrick = 5;

  // Puntuation
  int puntuation = 0;

  // Window settings
  int windowWidth = 600;
  int windowHeight = 800;

  int refreshRate = 10;

  Ball ball = new Ball(this);
  Racquet racquet = new Racquet(this);
  ArrayList<Brick> brickList = new ArrayList<Brick>();
  Clock clock = new Clock();

  public static void main(String[] args) throws InterruptedException {
    Game a = new Game();
    a.principal();
  }

  public void principal() throws InterruptedException {
    JFrame frame = new JFrame("Mini Tennis");
    Game game = this;

    this.setBackground(Color.decode("#FFFFFF"));
    frame.add(game);
    frame.setSize(windowWidth, windowHeight);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    createBrick(game, frame);

    while (true) {
      game.move();
      game.repaint();
      if (brickList.isEmpty()) {
        gameOver();
      }
      clock.wait(refreshRate);
    }
  }

  private void createBrick(Game game, JFrame frame) {
    for (int i = 0; i < brickRows; i++) {
      while (brickPossX < frame.getSize().getWidth() - brickWidth) {
        switch (getRandomNumber(1, 4)) {
          case 1:
            brickList.add(new RedBrick(game, brickPossX, brickPossY, brickHeight, brickWidth));
            break;
          case 2:
            brickList.add(new BlueBrick(game, brickPossX, brickPossY, brickHeight, brickWidth));
            break;
          case 3:
            brickList.add(new GreenBrick(game, brickPossX, brickPossY, brickHeight, brickWidth));
            break;
        }

        brickPossX += (brickWidth + spaceBetweenBrick);

        System.out.println("x: " + brickPossX);
      }
      brickPossX = 0;
      brickPossY += (brickHeight + spaceBetweenBrick);
    }
  }

  public int getRandomNumber(int min, int max) {
    return (int) ((Math.random() * (max - min)) + min);
  }

  private int getScore() {
    return puntuation;
  }

  public Game() {
    addKeyListener(
        new KeyListener() {
          @Override
          public void keyTyped(KeyEvent e) {
          }

          @Override
          public void keyReleased(KeyEvent e) {
            racquet.keyReleased(e);
          }

          @Override
          public void keyPressed(KeyEvent e) {
            racquet.keyPressed(e);
          }
        });
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
        RenderingHints.VALUE_ANTIALIAS_ON);
    ball.paint(g2d);
    racquet.paint(g2d);

    for (int i = 0; i < brickList.size(); i++) {
      System.out.println("i: " + i);
      brickList.get(i).paint(g2d);
    }
    g.setColor(Color.BLACK);
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
        JOptionPane.YES_NO_OPTION);

    System.exit(ABORT);
  }
}
