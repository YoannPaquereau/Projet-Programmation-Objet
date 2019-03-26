import java.awt.Color;

public abstract class Bateau {
  int x, y, vitesse;
  Color color;
  int dx, dy; //(direction)

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

  Bateau(int x, int y, int v, int dx, int dy, Color c) {
    this.setPosition(x, y);
    this.setVitesse(v);
    this.setDirection(dx, dy);
    this.setColor(c);
  }
}
