import java.awt.Graphics;

public class Jouer {
  Jeu jeu;

  public Jouer() {
    this.jeu = new Jeu();
    while (this.jeu.niveau < 3) {
      try {
        Thread.sleep(20);
      } catch (InterruptedException e) {
        System.out.println("Erreur");
      }
      this.jeu.update();
    }
    //System.out.println("Fin du jeu !");
  }

  public static void main(String[] args) {
    new Jouer();
  }
}
