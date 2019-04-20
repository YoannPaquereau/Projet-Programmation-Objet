import java.awt.Color;
import java.awt.Graphics;


public abstract class Bateau {
  int x, y; // Position du bateau
  int x1, x2, x3, x4, y1, y2, y3, y4;   // Points pour le polygone
  int longueur, largeur, vitesse, angle_inclinaison, longueur_pointe;
  Color color;
  int dx, dy;
  int temps;
  int direction;

  public void setPosition(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }

  public void setVitesse(int v) {
    this.vitesse = v;
  }

  public void setDirection(int dx, int dy) {
    this.dx = dx;
    this.dy = dy;
  }

  public void setColor(Color c) {
    this.color = c;
  }

  public void setLongueurLargeur(int x, int y, int p) {
    this.longueur = x;
    this.largeur = y;
    this.longueur_pointe = p;
  }

  public void setPointsPolygon(int x, int y) {
    this.x1 = (int) (this.x + this.longueur * Math.cos(this.angle_inclinaison));
    this.y1 = (int) (this.y + this.longueur * Math.sin(this.angle_inclinaison));

    this.x3 = (int) (this.x1 - this.largeur * Math.cos((Math.PI/2) - this.angle_inclinaison));
    this.y3 = (int) (this.y1 + this.largeur * Math.sin((Math.PI/2) - this.angle_inclinaison));

    this.x4 = (int) (x - this.largeur * Math.cos((Math.PI/2) - this.angle_inclinaison));
   	this.y4 = (int) (y + this.largeur * Math.sin((Math.PI/2) - this.angle_inclinaison));

    this.x2 = (int) ((this.x1 + this.x3) / 2 + (Math.cos(this.angle_inclinaison) * (this.longueur / this.longueur_pointe)));
   	this.y2 = (int) ((this.y1 + this.y3) / 2 + (Math.sin(this.angle_inclinaison) * (this.longueur / this.longueur_pointe)));
  }

  public Bateau(int x, int y, int v, int dx, int dy, Color c, int lo, int la, int angle, int p, int tps) {
    this.setPosition(x, y);
    this.setVitesse(v);
    this.setDirection(dx, dy);
    this.setColor(c);
    this.setLongueurLargeur(lo, la, p);
    this.angle_inclinaison = angle;
    this.setPointsPolygon(x, y);
    this.temps = tps;
  }

  public void paint(Graphics g) {
    int [] x = {this.x, this.x1, this.x2, this.x3, this.x4};
    int [] y = {this.y, this.y1, this.y2, this.y3, this.y4};
    g.setColor(this.color);
    g.fillPolygon(x, y, x.length);
  }

  public void update(Graphics g) {
    this.paint(g);
  }

  public abstract void deplacement();
}
