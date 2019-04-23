import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class Jeu {
  Fenetre fenetre;
  SousMarin sous_marin;
  BateauCommerce BateauxCommerces [][];
  NavireMilitaire navMil;
  Torpille t;
  int score;

  public Jeu() {
    this.sous_marin = new SousMarin(1100, 100, 4, Color.YELLOW, 30, 10, 3.0, 3);
    this.BateauxCommerces = new BateauCommerce[3][4];
    this.navMil = new NavireMilitaire(640, 360, 2, Color.BLACK, 30, 10, 3.0, 3);
    int x = 75;
    int y = 200;
    int cptX , cptY;
    for (int i = 0; i < BateauxCommerces.length; i++) {
      cptX = 0 + (i*-20);
      cptY = 0 + (i*40);
      for (int j = 0; j < BateauxCommerces[i].length; j++) {
        this.BateauxCommerces[i][j] = new BateauCommerce(x + cptX, y + cptY, 1, 1.0, 1.0, Color.RED, 30, 10, -100.0, 2);
        cptX = cptX + 75;
        cptY = cptY + 40;
      }
    }
    this.score = 0;
    this.fenetre = new Fenetre(this);
  }

  public void update() {
    for (int i = 0; i < BateauxCommerces.length; i++) {
      for (int j = 0; j < BateauxCommerces[i].length; j++) {
        if (this.BateauxCommerces[i][j] != null) this.BateauxCommerces[i][j].deplacement();
      }
    }
    this.sous_marin.deplacement();
    if (this.sous_marin.delai > 0) this.sous_marin.delai--;
    this.navMil.deplacement();
    for (int i = 0; i<this.sous_marin.tMarin.length; i++) {
      if (this.sous_marin.tMarin[i] != null) {
        for (int j=0; j<this.BateauxCommerces.length; j++) {
          for (int k=0; k<this.BateauxCommerces[j].length; k++) {
            if (this.BateauxCommerces[j][k] != null && this.sous_marin.tMarin[i] != null) {
              if (collision(this.sous_marin.tMarin[i].p, this.BateauxCommerces[j][k].p)) {
                this.BateauxCommerces[j][k] = null;
                this.sous_marin.tMarin[i] = null;
                this.score += 10;
              }
            }
          }
        }
        if (this.sous_marin.tMarin[i] != null) this.sous_marin.tMarin[i].deplacement();
      }
    }
    this.fenetre.panel.update();
  }

  public boolean collision(Polygon p1, Polygon p2) {
    int [] x = p1.xpoints;
    int [] y = p1.ypoints;
    for (int i = 0; i<x.length; i++) {
      if (p2.contains(x[i], y[i])) return true;
    }
    x = p2.xpoints;
    y = p2.ypoints;
    for (int i = 0; i<x.length; i++) {
      if (p1.contains(x[i], y[i])) return true;
    }

    return false;
  }
}
