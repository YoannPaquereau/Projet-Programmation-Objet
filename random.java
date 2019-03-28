import java.util.Random;


class random {

public static void main(String[] args) {
  Random r = new Random();
  int valeur = -1 + r.nextInt(2 - (-1));
  System.out.println(valeur);
}
}
