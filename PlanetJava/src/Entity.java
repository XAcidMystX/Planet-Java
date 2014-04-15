
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

/**
 *
 * @author Cullen
 */
public abstract class Entity {

    double x, y, theta, velocity;
    int width, height;
    BufferedImage i;

    public Entity(double x, double y, double theta, double velocity, int width, int height, BufferedImage i) {
        this.x = x;
        this.y = y;
        this.theta = theta;
        this.velocity = velocity;
        this.width = width;
        this.height = height;
        this.i = i;
    }

    public void paint(Graphics2D g) {
        AffineTransform old = g.getTransform();
        g.rotate(theta, (int) x + width / 2, (int) y + height / 2);
        g.drawImage(i, (int) x, (int) y, null);
//        g.setColor(Color.RED);
//        g.fillRect((int) x, (int) y, width, height);
        g.setTransform(old);
    }

    public void move(double delta) {
        x += delta * velocity * Math.cos(theta);
        y += delta * velocity * Math.sin(theta);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public double getTheta() {
        return theta;
    }

    public double getVelocity(){
        return velocity;
    }
    
}
