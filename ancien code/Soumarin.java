import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

class Soumarin extends Forme implements Deplacement, ActionListener,  KeyListener{
	protected int dx, dy;
	protected int v;
	private KeyEvent ke;
	Timer chrono = new Timer(5, this);
	
		public Soumarin ( int x, int y, Color c, int v){
			super(x, y, c);
			chrono.start();
			this.dx = 0;
			this.dy = 0;
			addKeyListener(this);
			setFocusable(true);
			setFocusTraversalKeysEnabled(false);
		}
	/*	
		public boolean dispatchKeyEvent(KeyEvent e) {
			if (e.getID() == KeyEvent.KEY_PRESSED) {
				if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == 				KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_SPACE) ke = e;
				else ke = null;
	 	 	}
	 	 	return false;
	 		}

*/
		public void paintComponent(Graphics g) {
    			super.paintComponent(g);
    			g.setColor(Color.BLUE);
			g.fillRect(x, y, 10, 10);
  		}
		@Override
		public void actionPerformed(ActionEvent e) {
    			 x = dx + x;
			y =y + dy;
			
   			 repaint();
  		}
	public void keyPressed(KeyEvent e)
	{ 
		int c = e.getKeyCode();
		if(c == KeyEvent.VK_LEFT ){
			dx=-1;
			dy=0;
		}
		if (c == KeyEvent.VK_UP ){
			dx = 0;
			dy =-1;
			}  
		if (c == KeyEvent.VK_RIGHT){
			dx = 1;
			dy = 0;
		}
		if (c == KeyEvent.VK_DOWN)
		{
			dx = 0;
			dy = 1;
		}
	}
	

	public void keyTyped(KeyEvent e){}
	public void keyReleased(KeyEvent e){
		dx = 0;
		dy = 0;
	}	
		
}
	
