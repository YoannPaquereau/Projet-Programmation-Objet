import java.awt.Color;
import java.awt.Graphics;



public class SousMarin extends Bateau {

  public SousMarin(int x, int y, int v, Color c, int lo, int la, double angle, int p){
    super(x, y, v, 0.0, 0.0, c, lo, la, angle, p, 3);
    this.direction = 0;
  }

  public void deplacement() {
    System.out.println("Déplacement sous-marin : " + this.direction);
    if (this.direction==1) {
      this.angle_inclinaison -= 0.2;
    }
    else if (this.direction==3) {
      this.angle_inclinaison += 0.2;
    }
    else if (this.direction==2) {
      if (this.y1 < this.y3) this.dx += 0.05;
      else if (this.y1 > this.y3) this.dx -= 0.05;

      if (this.y1 < this.y) this.dy -= 0.05;
      else if (this.y1 > this.y) this.dy += 0.05;
    }

    this.direction = 0;
    this.x = this.x + (int) ((this.dx * this.vitesse * this.temps) / (Math.sqrt (Math.pow(this.dx, 2) + Math.pow(this.dy, 2))));
    this.y = this.y + (int) ((this.dy * this.vitesse * this.temps) / (Math.sqrt (Math.pow(this.dx, 2) + Math.pow(this.dy, 2))));
    this.setPointsPolygon(this.getX(), this.getY());
    this.dx = 0;
    this.dy = 0;
  }
}
