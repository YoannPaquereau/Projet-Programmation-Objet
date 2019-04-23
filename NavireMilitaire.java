import java.awt.Color;
import java.awt.Graphics;

public class NavireMilitaire extends Bateau {
  int cmpt,sauvegardeX,sauvegardeY;

public NavireMilitaire(int x, int y, int v, Color c, int lo, int la, double angle, int p){
  super(x,y,v,0.0,0.0,c,lo,la,angle,p,1);
  this.direction=0;
  this.cmpt=0;



}
public void deplacement(){
  if (this.cmpt<30){
    this.direction=2;
    this.cmpt++;
    sauvegardeX=this.x1;
    sauvegardeY=this.y1;
  }

  else if(this.sauvegardeX!=this.x3 && this.sauvegardeY!=this.y3 && this.cmpt == 30)
  {
    this.direction=3;
  }


  else if (this.cmpt < 60){
    this.direction=2;
    this.cmpt++;
  }

  if (this.direction==1) {
    this.angle_inclinaison -= 0.2;
  }
  else if (this.direction==3) {
    this.angle_inclinaison += 0.2;
  }
  else if (this.direction==2) {
    if (this.y1 < this.y3) this.dx += 0.05;
    else if (this.y1 > this.y3) this.dx -= 0.05;

    if (this.y1 < this.y) this.dy -= 0.05;
    else if (this.y1 > this.y) this.dy += 0.05;
  }

  this.direction = 0;
  this.x = this.x + (int) ((this.dx * this.vitesse * this.temps) / (Math.sqrt (Math.pow(this.dx, 2) + Math.pow(this.dy, 2))));
  this.y = this.y + (int) ((this.dy * this.vitesse * this.temps) / (Math.sqrt (Math.pow(this.dx, 2) + Math.pow(this.dy, 2))));
  this.setPointsPolygon(this.getX(), this.getY());
  this.dx = 0;
  this.dy = 0;




  }


}
