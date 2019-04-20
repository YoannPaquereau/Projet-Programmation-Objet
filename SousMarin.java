import java.awt.Color;
import java.awt.Graphics;



public class SousMarin extends Bateau {

  public SousMarin(int x, int y, int v, Color c, int lo, int la, int angle, int p){
    super(x, y, v, 0, 0, c, lo, la, angle, p, 3);
    this.direction = 0;
  }

  public void deplacement() {
    int addX = 0, addY = 0, addD = 0;
    switch (this.direction) {
      case(1):
        addX = -1;
        addY = -1;
        break;

      case(2):
        addX = 1;
        addY = 1;
        break;

      case(3):
        if (this.y > this.y1) {
          if (this.direction == 1) {
            addX = -1;
            addY = -1;
          }
          else {
            addX = 1;
            addY = 1;
          }
        }
        else if (this.y < this.y1) {
          if (this.direction == 2) {
            addX = 1;
            addY = 1;
          }
          else {
            addX = -1;
            addY = -1;
          }
        }
        if (this.direction == 1) {
          this.dx = -1;
        }
        else {
          this.dx = 1;
        }
        break;
      }


      this.x1 += addX;
      this.y1 += addY;

      this.x2 += addX;
      this.y2 += addY;

      this.x3 += addX;
      this.y3 += addY;

      this.x4 += addX;
      this.y4 += addY;

      if (this.dx != 0) {


        this.x = this.x + (int) ((this.dx * this.vitesse * this.temps) / (Math.sqrt (Math.pow(this.dx, 2) + Math.pow(this.dy, 2))));
        this.y = this.y + (int) ((this.dy * this.vitesse * this.temps) / (Math.sqrt (Math.pow(this.dx, 2) + Math.pow(this.dy, 2))));
      }

      this.dx = 0;
      this.dy = 0;
      this.direction = 0;


    }
  }
