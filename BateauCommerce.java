import java.awt.Color;
import java.awt.Graphics;

public class BateauCommerce extends Bateau {

  // Constructeur de notre bateau de commerce
  public BateauCommerce(int x, int y, int v, double dx, double dy, Color c, int lo, int la, double angle, int p) {
    super(x, y, v, dx, dy, c, lo, la, angle, p, 2);
  }

  // Méthode permettant le déplacement de notre bateau de commerce
  void deplacement() {
    this.x = this.x + (int) ((this.dx * this.vitesse * this.temps) / (Math.sqrt (Math.pow(this.dx, 2) + Math.pow(this.dy, 2))));
    this.y = this.y + (int) ((this.dy * this.vitesse * this.temps) / (Math.sqrt (Math.pow(this.dx, 2) + Math.pow(this.dy, 2))));
    this.setPointsPolygon(this.x, this.y);    // On refait tous les points de notre polygone
  }


}
