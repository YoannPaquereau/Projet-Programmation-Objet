import java.awt.Color;
import java.util.Random;

public class Navire_militaire extends Bateau
{
  void setDirectionMilitaire() {
    Random r = new Random();
    int valeur;
    valeur = -1 + r.nextInt(2 - (-1));
    this.dx = this.dx + valeur;
    valeur = -1 + r.nextInt(2 - (-1));
    this.dy = this.dy + valeur;
}

  Navire_militaire(int x, int y, int v, Color c)
  {
    super(x,y,v,dx,dy,c);
  }
}
