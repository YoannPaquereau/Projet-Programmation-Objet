import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class ConteneurFenetre extends JPanel implements ActionListener {
  Timer chrono = new Timer(5, this);

  int dx = 0;

  public ConteneurFenetre() {
    super();
    chrono.start();
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.BLUE);
    g.fillRect(10 + dx, 10, 70, 70);
System.out.println("paintComponent");
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    dx = dx + 1;
	System.out.println("action");
    repaint();
  }

}
