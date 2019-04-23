import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.*;

public class Panneau extends JPanel implements KeyListener {
  Fenetre fenetre;
  KeyEvent ke;

  public Panneau(Fenetre f) {
    super();
    this.fenetre = f;
    addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
  }

  public void paint(Graphics g) {
    g.setColor(Color.BLUE);
    g.fillRect(0,0,1280,720);
    for (int i=0; i<this.fenetre.jeu.BateauxCommerces.length; i++) {
      for (int j=0; j<this.fenetre.jeu.BateauxCommerces[i].length; j++) {
        this.fenetre.jeu.BateauxCommerces[i][j].update(g);
      }
    }
    for (int i = 0; i<this.fenetre.jeu.sous_marin.tMarin.length; i++) {
        if (this.fenetre.jeu.sous_marin.tMarin[i] != null)
      this.fenetre.jeu.sous_marin.tMarin[i].update(g);
    }
    fenetre.jeu.sous_marin.update(g);
    fenetre.jeu.navMil.update(g);
    g.setColor(Color.WHITE);
    g.drawString("Profondeur : " + this.fenetre.jeu.sous_marin.y +"m", 5,20);
    g.drawString("Nombre torpille(s) : " + (20-this.fenetre.jeu.sous_marin.cpt), 5, 40);
    g.drawString("Score : " + this.fenetre.jeu.score, 5, 60);
  }

  public void update() {
    repaint();
  }



  public void pressedKey() {
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
        this.fenetre.jeu.sous_marin.tMarin[this.fenetre.jeu.sous_marin.cpt]=new Torpille(this.fenetre.jeu.sous_marin.x2,this.fenetre.jeu.sous_marin.y2,this.fenetre.jeu.sous_marin.vitesse,Color.GRAY,15,5,this.fenetre.jeu.sous_marin.angle_inclinaison,5);
        this.fenetre.jeu.sous_marin.cpt++;
        this.fenetre.jeu.sous_marin.delai = 25;
      }

    }

    this.ke = null;
  }

  public void keyPressed(KeyEvent k){
        this.ke=k;
        pressedKey();
    }

  public void keyTyped(KeyEvent e){}
	public void keyReleased(KeyEvent e){
    this.ke = null;
	}
}
