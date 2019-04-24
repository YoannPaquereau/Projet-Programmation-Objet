import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;


public class SousMarin extends Bateau {

  int cpt;
  Torpille[] tabTorpilles;
  int delai;

  public SousMarin(int x, int y, int v, Color c, int lo, int la, double angle, int p){
    super(x, y, v, 0.0, 0.0, c, lo, la, angle, p, 2);
    this.direction = 0;
    this.cpt=0;
    this.tabTorpilles=new Torpille[20];
    this.delai = 0;
  }

  public void deplacement() {
    if (this.direction==1) {
      this.angle_inclinaison -= 0.1;
    }
    else if (this.direction==3) {
      this.angle_inclinaison += 0.1;
    }
    else if (this.direction==2) {
      if (this.y1 < this.y3 && this.x2<1280) this.dx += 0.03;
      else if (this.y1 > this.y3 && this.x2>0) this.dx -= 0.03;

      if (this.y1 < this.y && this.y2>0) this.dy -= 0.03;
      else if (this.y1 > this.y && this.y2<175) this.dy += 0.03;
    }

    this.direction = 0;
    this.x = this.x + (int) ((this.dx * this.vitesse * this.temps) / (Math.sqrt (Math.pow(this.dx, 2) + Math.pow(this.dy, 2))));
    this.y = this.y + (int) ((this.dy * this.vitesse * this.temps) / (Math.sqrt (Math.pow(this.dx, 2) + Math.pow(this.dy, 2))));
    this.setPointsPolygon(this.getX(), this.getY());
    this.dx = 0;
    this.dy = 0;
  }
}
