
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
public abstract class Forme extends JPanel{
		 Color c;
		 int x,y;
		
		Forme ( int x, int y, Color c ){
			this.x = x;
			this.y = y;
			this.c = c;
		}
	 
		void setposition( int x, int y){
			this.x = x;
			this.y = y;
		}
		
		Color getcolor(){
			return this.c;
		}
 		 
		//public abstract void paintComponent(Graphics g);
	}
