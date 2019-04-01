import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.lang.Math;

public abstract class Bateau extends Panneau{
  int x, y, vitesse;
  Color color;
  int dx, dy; //(direction)
  Polygon p;
  int longueur, largeur;
  int pointX[] = new int[5];
  int pointY[] = new int[5];

  void setPosition(int x, int y) {
    this.x = x;
    this.y = y;
  }

  void setVitesse(int v) {
    this.vitesse = v;
  }

  void setDirection(int dx, int dy) {
    this.dx = dx;
    this.dy = dy;
  }

  void setColor(Color c) {
    this.color = c;
  }

  public void mouvement(){
    /*int x1, x2, x3, x4;
    int y1, y2, y3, y4;

    x1 =(int) (this.x + this.longueur * Math.cos(180));
    x3 =(int) (x1 - this.largeur * Math.cos(90));
    x2 =(int) ((x1 + x3) / 2 + Math.cos(180) * this.longueur/2);
    x4 =(int) (this.x - this.largeur * Math.cos(90));

    y1 =(int) (this.y + this.longueur * Math.sin(180));
    y3 =(int) (y1 + this.largeur * Math.sin(90));
    y2 =(int) ((y1 + y3) / 2 + Math.sin(180) * this.longueur/2);
    y4 =(int) (this.y + this.largeur * Math.sin(90));*/
    this.pointX[0] = this.x;

    this.pointX[1] = (int) (this.x + this.longueur * Math.cos(180));
    this.pointX[2] = (int) (this.pointX[1] - this.largeur * Math.cos(90));
    this.pointX[3] = (int) ((this.pointX[1] + this.pointX[2]) / 2 + Math.cos(180) * this.longueur/2);
    this.pointX[4] = (int) (this.x - this.largeur * Math.cos(90));

    this.pointY[0] = this.y;
    this.pointY[1] = (int) (this.y + this.longueur * Math.sin(180));
    this.pointY[2] = (int) (this.pointY[1] + this.largeur * Math.sin(90));
    this.pointY[3] = (int) ((this.pointY[1] + this.pointY[2]) / 2 + Math.sin(180) * this.longueur/2);
    this.pointY[4] = (int) (this.y + this.largeur * Math.sin(90));

  }

  void setLongueurLargeur(int x, int y) {
    this.longueur = x;
    this.largeur = y;
  }

  Bateau(int x, int y, int v, int dx, int dy, Color c, int lo, int la) {
    this.setPosition(x, y);
    this.setVitesse(v);
    this.setDirection(dx, dy);
    this.setColor(c);
    this.setLongueurLargeur(lo, la);
  }
}
