import java.awt.Color;

public class Jeu {

  // Création méthode torpille, méthode déplacement, collision, couleur dans cette classe


  public Jeu () {
    Fenetre fenetre = new Fenetre();
    Sous_marin sm = new Sous_marin(20, 20, 0,0,0,Color.BLUE, 20, 20);
  }

  public void jouer () {

  }
  void collision(int x,int y){
    //la position du sous marin et des navires militaire ne doivent pas etre identique

  }

  public static void main(String[] args) {
    Jeu j = new Jeu();
  }

}
