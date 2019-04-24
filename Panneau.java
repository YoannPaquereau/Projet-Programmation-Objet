import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.*;
import java.awt.Font;


public class Panneau extends JPanel implements KeyListener {
  Fenetre fenetre;
  private KeyEvent ke;
  private static final long serialVersionUID = 5161616516313168L;

  public Panneau(Fenetre f) {
    super();
    this.fenetre = f;
    addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
  }

  public void paint(Graphics g) {
    g.setColor(Color.BLUE);         // On met toute notre fenetre en bleue (pour supprimer tout ce qu'il y a avant)
    g.fillRect(0,0,1280,720);

    // Si le jeu n'est pas fini, on peint les bateaux de commerces restants
    if (this.fenetre.jeu.niveau < 3) {
      for (int i=0; i<this.fenetre.jeu.BateauxCommerces.length; i++) {
        for (int j=0; j<this.fenetre.jeu.BateauxCommerces[i].length; j++) {
          if (this.fenetre.jeu.BateauxCommerces[i][j] != null) this.fenetre.jeu.BateauxCommerces[i][j].update(g);
        }
      }

      // idem pour les torpilles lancées
      for (int i = 0; i<this.fenetre.jeu.sous_marin.tabTorpilles.length; i++) {
          if (this.fenetre.jeu.sous_marin.tabTorpilles[i] != null)
        this.fenetre.jeu.sous_marin.tabTorpilles[i].update(g);
      }

      // idem pour le sous-marin et le navire militaire
      fenetre.jeu.sous_marin.update(g);
      fenetre.jeu.navMil.update(g);

      // On met la couleur en blanche
      g.setColor(Color.WHITE);

      // On affiche les informations du jeu en haut à droite de notre fenêtre
      g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
      g.drawString("Profondeur : " + this.fenetre.jeu.sous_marin.y +"m", 5,20);
      g.drawString("Nombre torpille(s) : " + (20-this.fenetre.jeu.sous_marin.cpt), 5, 40);
      g.drawString("Score : " + this.fenetre.jeu.score, 5, 60);
    }

    // Si le jeu est fini
    else {
      g.setColor(Color.BLACK);
      g.setFont(new Font("TimesRoman", Font.PLAIN, 40));
      String s = "Merci d'avoir joue a notre jeu !";
      g.drawString(s, 375, 250);
      s = "Votre score : " + this.fenetre.jeu.score;
      g.drawString(s , 490, 320);
    }
  }

  public void update() {
    repaint();
  }


  // Si on appuit sur une touche du clavier
  public void keyPressed(KeyEvent k){
        this.ke=k;
        if (this.ke.getKeyCode()  == KeyEvent.VK_LEFT) {
            this.fenetre.jeu.sous_marin.direction = 1;
        }

        if (this.ke.getKeyCode() == KeyEvent.VK_UP) {
          this.fenetre.jeu.sous_marin.direction = 2;
        }

        if (this.ke.getKeyCode() == KeyEvent.VK_RIGHT) {
          this.fenetre.jeu.sous_marin.direction = 3;
        }

        if (this.ke.getKeyCode() == KeyEvent.VK_SPACE) {
          if (this.fenetre.jeu.sous_marin.cpt<20 && this.fenetre.jeu.sous_marin.delai == 0) {

            // On créé une torpille s'il en reste
            this.fenetre.jeu.sous_marin.tabTorpilles[this.fenetre.jeu.sous_marin.cpt] = new Torpille(this.fenetre.jeu.sous_marin.x2, this.fenetre.jeu.sous_marin.y2, this.fenetre.jeu.sous_marin.vitesse, Color.GRAY, 15, 5, this.fenetre.jeu.sous_marin.angle_inclinaison, 5);

            // On incrémente notre compteur de torpilles
            this.fenetre.jeu.sous_marin.cpt++;

            // On met un délai pour en relancer une nouvelle
            this.fenetre.jeu.sous_marin.delai = 25;
          }
        }
    }

  public void keyTyped(KeyEvent e){}
	public void keyReleased(KeyEvent e){
    this.ke = null;
	}
}
