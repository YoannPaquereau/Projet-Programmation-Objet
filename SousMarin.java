import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;


public class SousMarin extends Bateau {

  int cpt;    // compteur de torpilles lancées
  Torpille[] tabTorpilles;  // tableau de torpilles
  int delai;

  public SousMarin(int x, int y, int v, Color c, int lo, int la, double angle, int p){
    super(x, y, v, 0.0, 0.0, c, lo, la, angle, p, 2);
    this.direction = 0;
    this.cpt=0;
    this.tabTorpilles=new Torpille[20];
    this.delai = 0;
  }

  void deplacement() {

    // Si on va à gauche, on va à bâbord
    if (this.direction==1) {
      this.angle_inclinaison -= 0.1;
    }

    // idem pour tribord
    else if (this.direction==3) {
      this.angle_inclinaison += 0.1;
    }

    // Si on avance
    else if (this.direction==2) {

      // Si notre bateau va à babord
      if (this.y1 < this.y3 && this.x2<1280) this.dx += 0.0005;

      // idem pour tribord
      else if (this.y1 > this.y3 && this.x2>0) this.dx -= 0.0005;

      // Si on va vers le haut
      if (this.y1 < this.y && this.y2>0) this.dy -= 0.0005;

      // idem pour le bas
      else if (this.y1 > this.y && this.y2<175) this.dy += 0.0005;
    }

    this.direction = 0;

    // On applique notre changement de direction à notre position
    this.x = this.x + (int) ((this.dx * this.vitesse * this.temps) / (Math.sqrt (Math.pow(this.dx, 2) + Math.pow(this.dy, 2))));
    this.y = this.y + (int) ((this.dy * this.vitesse * this.temps) / (Math.sqrt (Math.pow(this.dx, 2) + Math.pow(this.dy, 2))));

    // On refait les points de notre polygone
    this.setPointsPolygon(this.getX(), this.getY());

    // On met la direction à 0
    this.dx = 0;
    this.dy = 0;
  }
}
