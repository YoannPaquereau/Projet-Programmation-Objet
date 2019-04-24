import java.awt.Graphics;

public class Jouer {
  private Jeu jeu;

  // Méthode permettant de lancer le jeu
  private Jouer() {
    this.jeu = new Jeu();

    // Tant qu'on a pas fini les 2 "niveaux"
    while (this.jeu.niveau < 3) {

      // Délai entre chaque action du jeu (déplacement, rafraichissement de l'écran,...)
      try {
        Thread.sleep(20);
      } catch (InterruptedException e) {
        System.out.println("Erreur");
      }

      // On met à jour le jeu
      this.jeu.update();
    }
  }

  public static void main(String[] args) {
    new Jouer();
  }
}
