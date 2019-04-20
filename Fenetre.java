import javax.swing.JFrame;

public class Fenetre extends JFrame {
  Panneau panel;
  Jeu jeu;

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

    this.panel = new Panneau(this);
    this.setContentPane(this.panel);

    //Et enfin, la rendre visible
    this.setVisible(true);

    this.setResizable(false);

  }
}
