
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 *
 * @author Cullen
 */
public class Main implements KeyListener, MouseListener {

    static int WIDTH, HEIGHT;
    static JFrame window;
    static Random die = new Random();
    static long time;
    static double delta;

    public static void main(String[] args) {
        new Main().start();
    }

    public void start() {
        try {
            WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
            HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        } catch (HeadlessException e) {
        }
        window = new JFrame();
        window.setBounds(0, 0, WIDTH, HEIGHT);
        window.setUndecorated(true);
        window.addKeyListener(this);
        window.add(new Painter());
        window.setVisible(true);
        updateDelta();
        updateDelta();
        while (true) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
            }
        }
    }

    public static void render(Graphics2D g) {
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        g.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        g.setColor(Color.BLACK);
        g.drawString("ESCAPE TO EXIT", 50, 50);
    }

    public void updateDelta() {
        delta = System.currentTimeMillis() - time;
        time = System.currentTimeMillis();
    }

    public static BufferedImage loadImage(String filePath) {
        try {
            return ImageIO.read(new File(filePath));
        } catch (IOException e) {
        }
        return null;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
