import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
//import Deplacement.java;
public class Bateaux extends Forme implements ActionListener, Deplacement{
		int dx, dy;

		Timer chrono = new Timer(5, this);

		public Bateaux ( int x, int y, Color c, int v){
			super( x, y, c);
			chrono.start();
			this.dx = 0;
			this.dy = 0;
		}
		@Override
		public void paintComponent(Graphics g) {
    			super.paintComponent(g);
    			g.setColor(Color.BLUE);
    			g.fillRect(10 + dx, 10, 70, 70);
  		}
		@Override
		public void actionPerformed(ActionEvent e) {
    			 dx = dx + 1;
   			 repaint();
  		}
		

	}

	
