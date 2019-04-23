import java.awt.Graphics;

public class Jouer {

  Jeu jeu;

  public Jouer() {
    this.jeu = new Jeu();
    while (true) {
      try {
        Thread.sleep(20);
      } catch (InterruptedException e) {
        System.out.println("Erreur");
      }
      this.jeu.update();
    }
  }

  public static void main(String[] args) {
    new Jouer();
  }
}
