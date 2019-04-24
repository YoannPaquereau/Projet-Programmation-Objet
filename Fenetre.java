import javax.swing.JFrame;

public class Fenetre extends JFrame {
  Panneau panel;
  Jeu jeu;
  private static final long serialVersionUID = 3540651654054054L;

  public Fenetre(Jeu j) {
    this.jeu = j;

    //Définit un titre pour notre fenêtre
    this.setTitle("Sous-Marin");

    //Définit sa taille : 400 pixels de large et 100 pixels de haut
    this.setSize(1280, 720);

    //Nous demandons maintenant à notre objet de se positionner au centre
    this.setLocationRelativeTo(null);


    //Termine le processus lorsqu'on clique sur la croix rouge
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Création de notre panneau
    this.panel = new Panneau(this);

    // On l'affiche dans notre fenêtre
    this.setContentPane(this.panel);

    //Et enfin, la rendre visible
    this.setVisible(true);

    // On empêche le redimensionnement de notre fenêtre
    this.setResizable(false);

  }
}
