import java.awt.Color;
import java.awt.Graphics2D;

public class GreenBrick extends Brick {
  private Game game;
  private int healthPoints =2;

  public GreenBrick(Game game, int x, int Y) {
    super(game, x, Y);
    // TODO Auto-generated constructor stub
  }

  public void assignHealthPoints(int healthPoints) {
    setHealthPoints(healthPoints);
  }

  @Override
  public void paint(Graphics2D g) {

    if (this.healthPoints == 2){
      g.setColor(Color.GREEN);
    }else if (this.healthPoints == 1){
      g.setColor(Color.LIGHT_GRAY);
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
