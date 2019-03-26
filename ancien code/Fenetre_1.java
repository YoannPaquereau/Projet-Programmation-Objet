import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;
public class Fenetre extends JFrame {
  Bateaux bat = new Bateaux(10, 10, Color.BLUE, 10);
  Soumarin bate = new Soumarin(10, 10, Color.RED, 10);
  JPanel tout = new JPanel();
  //JPanel p = new JPanel();
  /*	
  public void paintComponent(Graphics g) {
    			tout.paintComponent(g);
    			g.setColor(Color.BLUE);
			g.fillRect(x, y, 10, 10);
  		}
*/
  public Fenetre() {
    super();
    this.proprietesFenetre();
  }
  
  private void proprietesFenetre() {
    this.setSize(1200,700);
    this.setResizable(false);
    this.setAlwaysOnTop(true);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setContentPane(bat);
    this.setContentPane(bate);
   // tout.add(bat);
  //  tout.add(bate);
   // this.setContentPane(tout);
//setVisible(true);
  }
}
