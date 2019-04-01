import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math;


public class Sous_marin extends Bateau implements KeyListener{


  public Sous_marin(int x,int y,int v,int dx,int dy,Color c, int lo, int la){
    super(x,y,v,dx,dy,c,lo,la);
  }

    public void keyPressed(KeyEvent e)
    {
      int c = e.getKeyCode();
      if(c == KeyEvent.VK_LEFT ){
        this.dx=-1;
        this.dy=0;
      }
      if (c == KeyEvent.VK_UP ){
        this.dx = 0;
        this.dy =-1;
        }
      if (c == KeyEvent.VK_RIGHT){
        this.dx = 1;
        this.dy = 0;
      }
      if (c == KeyEvent.VK_DOWN)
      {
        this.dx = 0;
        if(this.y < 200){
          this.dy = 1;
        }
      }
    }


    public void keyTyped(KeyEvent e){}
    public void keyReleased(KeyEvent e){//quand on appuie pas
      this.dx = 0;
      this.dy = 0;
    }

}
