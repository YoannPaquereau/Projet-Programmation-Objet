import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;


public abstract class Bateau {
  protected int x, y; // Position du bateau
  protected int x1, x2, x3, x4, y1, y2, y3, y4;   // Points pour le polygone
  protected int longueur, largeur, vitesse, longueur_pointe;
  protected Color color;
  protected double dx, dy;  // Direction du bateau
  protected int temps;
  protected int direction;    // Gauche : 1 - Droite : 3 - Avancer : 2 - Immobile : 0 
  protected double angle_inclinaison;
  protected Polygon p;

  protected void setPosition(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }

  protected void setVitesse(int v) {
    this.vitesse = v;
  }

  protected void setDirection(double dx, double dy) {
    this.dx = dx;
    this.dy = dy;
  }

  protected void setColor(Color c) {
    this.color = c;
  }

  protected void setLongueurLargeur(int x, int y, int p) {
    this.longueur = x;
    this.largeur = y;
    this.longueur_pointe = p;
  }

  // On créé les points de notre polygone par rapport à notre position x,y
  protected void setPointsPolygon(int x, int y) {
    this.x1 = (int) (this.x + this.longueur * Math.cos(this.angle_inclinaison));
    this.y1 = (int) (this.y + this.longueur * Math.sin(this.angle_inclinaison));

    this.x3 = (int) (this.x1 - this.largeur * Math.cos((Math.PI/2) - this.angle_inclinaison));
    this.y3 = (int) (this.y1 + this.largeur * Math.sin((Math.PI/2) - this.angle_inclinaison));

    this.x4 = (int) (x - this.largeur * Math.cos((Math.PI/2) - this.angle_inclinaison));
   	this.y4 = (int) (y + this.largeur * Math.sin((Math.PI/2) - this.angle_inclinaison));

    this.x2 = (int) ((this.x1 + this.x3) / 2 + (Math.cos(this.angle_inclinaison) * (this.longueur / this.longueur_pointe)));
   	this.y2 = (int) ((this.y1 + this.y3) / 2 + (Math.sin(this.angle_inclinaison) * (this.longueur / this.longueur_pointe)));
  }

  // Constructeur du bateau
  public Bateau(int x, int y, int v, double dx, double dy, Color c, int lo, int la, double angle, int p, int tps) {
    this.setPosition(x, y);
    this.setVitesse(v);
    this.setDirection(dx, dy);
    this.setColor(c);
    this.setLongueurLargeur(lo, la, p);
    this.angle_inclinaison = angle;
    this.setPointsPolygon(x, y);
    int [] pointX = {this.x, this.x1, this.x2, this.x3, this.x4};
    int [] pointY = {this.y, this.y1, this.y2, this.y3, this.y4};
    this.p = new Polygon(pointX, pointY, pointX.length);
    this.temps = tps;
  }

  // Méthode permettant de peindre notre bateau sur notre panneau
  protected void paint(Graphics g) {
    int [] x = {this.x, this.x1, this.x2, this.x3, this.x4};
    int [] y = {this.y, this.y1, this.y2, this.y3, this.y4};
    g.setColor(this.color);
    this.p = new Polygon(x, y, x.length);
    g.fillPolygon(p);
  }

  // Met à jour notre bateau sur notre écran (pas vraiment utile)
  public void update(Graphics g) {
    this.paint(g);
  }

  // Méthode abstraite pour le déplacement (dépend de chaque type de bateau)
  abstract void deplacement();
}
