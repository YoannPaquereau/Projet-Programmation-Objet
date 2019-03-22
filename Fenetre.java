import javax.swing.JFrame;

public class Fenetre extends JFrame {
  ConteneurFenetre pan = new ConteneurFenetre();

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
    this.setContentPane(pan);
  }
}
