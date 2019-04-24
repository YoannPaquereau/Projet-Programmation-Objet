import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class Jeu {

  // Création des éléments de notre jeu
  Fenetre fenetre;
  SousMarin sous_marin;
  BateauCommerce BateauxCommerces [][];
  NavireMilitaire navMil;
  int score;
  int niveau;

  // Constructeur
  public Jeu() {
    this.sous_marin = new SousMarin(1100, 100, 4, Color.YELLOW, 30, 10, 3.0, 3);
    this.BateauxCommerces = new BateauCommerce[3][4];
    this.navMil = new NavireMilitaire(640, 360, 2, Color.BLACK, 30, 10, 3.0, 3);

    // Compteur position x et y pour le convoi de bateaux de commerces
    int x = 25;
    int y = 200;
    int cptX , cptY;
    for (int i = 0; i < this.BateauxCommerces.length; i++) {
      cptX = 0 + (i*-20);
      cptY = 0 + (i*40);
      for (int j = 0; j < this.BateauxCommerces[i].length; j++) {
        this.BateauxCommerces[i][j] = new BateauCommerce(x + cptX, y + cptY, 1, 1.0, 1.0, Color.RED, 30, 10, -100.0, 2);
        cptX = cptX + 75;
        cptY = cptY + 40;
      }
    }
    this.score = 0;
    this.fenetre = new Fenetre(this);
    this.niveau = 1;
  }




  // Méthode mettant à jour les éléments de notre jeu
  public void update() {
    boolean finNiveau = true;
    sortieEcran();

    // On fait déplacer notre convoi
    for (int i = 0; i < this.BateauxCommerces.length; i++) {
      for (int j = 0; j < this.BateauxCommerces[i].length; j++) {
        if (this.BateauxCommerces[i][j] != null) {    // !=null : Si le bateau n'a pas été détruit
          finNiveau = false;
          this.BateauxCommerces[i][j].deplacement();
        }

      }
    }

    if (finNiveau) {
      this.niveau += 1;
      if (this.niveau > 1) {
        int x = 1255;
        int y = 200;
        int cptX , cptY;
        for (int i = 0; i < this.BateauxCommerces.length; i++) {
          cptX = 0 + (i*-20);
          cptY = 0 + (i*40);
          for (int j = 0; j < this.BateauxCommerces[i].length; j++) {
            this.BateauxCommerces[i][j] = new BateauCommerce(x + cptX, y + cptY, 1, -1.0, 1.0, Color.RED, 30, 10, 90.5, 2);
            cptX = cptX - 75;
            cptY = cptY + 40;
          }
        }
      }
    }

    // On déplace le sous-marin
    this.sous_marin.deplacement();

    // Si on a lancé une torpille, on a un délai pour en relancer une (on décrémente le délai)
    if (this.sous_marin.delai > 0) this.sous_marin.delai--;

    // On fait déplacer le bateau militaire
    this.navMil.deplacement();

    // On vérifie les collisions entre les torpilles du sous-marin avec les bateaux militaires
    for (int i = 0; i<this.sous_marin.tabTorpilles.length; i++) {
      if (this.sous_marin.tabTorpilles[i] != null) {
        for (int j=0; j<this.BateauxCommerces.length; j++) {
          for (int k=0; k<this.BateauxCommerces[j].length; k++) {
            if (this.BateauxCommerces[j][k] != null && this.sous_marin.tabTorpilles[i] != null) {
              if (collision(this.sous_marin.tabTorpilles[i].p, this.BateauxCommerces[j][k].p)) {
                this.BateauxCommerces[j][k] = null;
                this.sous_marin.tabTorpilles[i] = null;
                this.score += 10;
              }
            }
          }
        }


        if (this.sous_marin.tabTorpilles[i] != null) this.sous_marin.tabTorpilles[i].deplacement();
      }
    }

    // On rafraichit notre panneau
    this.fenetre.panel.update();
  }






  // Méthode permettant de renvoyer vrai s'il y a une collision entre 2 bateaux (ou torpille)
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

  // Méthode permettant de mettre à null les bateaux de commerces sortis de l'écran
  public void sortieEcran() {
    int [] x;
    int [] y;
    int cpt;
    boolean sortie;
    for (int i = 0; i<this.BateauxCommerces.length; i++) {
      cpt = 0;
      sortie = true;
      for (int j = 0; j < this.BateauxCommerces[i].length; j++) {
        if (this.BateauxCommerces[i][j] != null) {
          x = this.BateauxCommerces[i][j].p.xpoints;
          y = this.BateauxCommerces[i][j].p.ypoints;
          while (cpt < x.length && sortie) {
            if ((x[i] > 0 && x[i] < 1280) && (y[i] > 0 && y[i] < 720)) sortie = false;
            cpt++;
          }
          if (sortie) {
            this.BateauxCommerces[i][j] = null;
          }
        }
      }
    }
  }
}
