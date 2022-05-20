import java.awt.Color;
import java.awt.Graphics2D;

public class RedBrick extends Brick {
  private Game game;
  private int healthPoints =1;

  public RedBrick(Game game, int x, int Y) {
    super(game, x, Y);
  }

  public void assignHealthPoints(int healthPoints) {
    setHealthPoints(healthPoints);
  }

  @Override
  public void paint(Graphics2D g) {
    if (this.healthPoints == 1){
      g.setColor(Color.RED);
    }else{
      g.setColor(Color.ORANGE);
    }
    g.fillRect(x, Y, WITH, HEIGHT);
  }

  public int getHealthPoints() {
    return healthPoints;
}

public void setHealthPoints(int healthPoints) {
    this.healthPoints = healthPoints;
}

public void reduceHealthPoints(){
  this.healthPoints --;
}

public void deadAction(){

}
}
