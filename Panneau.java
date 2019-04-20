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
    g.setColor(Color.BLACK);
    g.fillRect(0,0,1280,720);
    for (int i=0; i<this.fenetre.jeu.BateauxCommerces.length; i++) {
      for (int j=0; j<this.fenetre.jeu.BateauxCommerces[i].length; j++) {
        this.fenetre.jeu.BateauxCommerces[i][j].update(g);
      }
    }
    fenetre.jeu.sous_marin.update(g);
    System.out.println("x2 = " +fenetre.jeu.sous_marin.x2 + ", y2 = " + fenetre.jeu.sous_marin.y2 + ", x = " + fenetre.jeu.sous_marin.x + ", y = " + fenetre.jeu.sous_marin.y);
    System.out.println("Angle = "+fenetre.jeu.sous_marin.angle_inclinaison);
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

    this.ke = null;
  }

  public void keyPressed(KeyEvent k){
        this.ke=k;
        pressedKey();
    }

  public void keyTyped(KeyEvent e){}
	public void keyReleased(KeyEvent e){
    this.ke = null;
		fenetre.jeu.sous_marin.dx = 0;
		fenetre.jeu.sous_marin.dy = 0;
	}
}
