import java.awt.Color;

public class Torpille extends Bateau
{
public Torpille (int x, int y, int v, Color c, int lo, int la, double angle, int p){
    super(x, y, v, 0.0, 0.0, c, lo, la, angle, p, 2 );
    if (this.y1 < this.y3) this.dx += 0.03;
    else if (this.y1 > this.y3) this.dx -= 0.03;

    if (this.y1 < this.y) this.dy -= 0.03;
    else if (this.y1 > this.y) this.dy += 0.03;
    this.direction = 2;
  }
  public void deplacement(){
    this.x = this.x + (int) ((this.dx * this.vitesse * this.temps) / (Math.sqrt (Math.pow(this.dx, 2) + Math.pow(this.dy, 2))));
    this.y = this.y + (int) ((this.dy * this.vitesse * this.temps) / (Math.sqrt (Math.pow(this.dx, 2) + Math.pow(this.dy, 2))));
    this.setPointsPolygon(this.x, this.y);
  }
}
