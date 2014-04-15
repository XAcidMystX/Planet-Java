import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author Cullen
 */
public class Painter extends JPanel {
    
    @Override
    public void paintComponent(Graphics g){
        g.clearRect(0, 0, Main.WIDTH, Main.HEIGHT);
        Main.render((Graphics2D) g);
        g.dispose();
    }
}