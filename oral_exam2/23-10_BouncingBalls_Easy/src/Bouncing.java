import javax.swing.*;
import java.awt.*;

/**
 * @author Zhi Wang
 * @version 11/08/2018
 * @see Bouncing
 * <p>
 * this class extends JPanel and includes 2 methods
 */

public class Bouncing extends JPanel {
    /**
     * @param diameter
     * @param speed
     * @param xSpeed
     * @param ySpeed
     * @param x
     * @param y
     */
    private final int diameter = 100;
    private final int speed = 1;
    private int ySpeed = 1, xSpeed = 1;
    private int x = 0;
    private int y = 0;

    /**
     * This is the paint method. This method will paint ball.
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLUE);
        g.fillOval(this.x, this.y, this.diameter, this.diameter);
    }

    /**
     * This is the runSteps method. This method configures directions for the ball.
     */
    public void runSteps() {
        // if the ball hit the left.
        if (this.x <= 0) {
            this.xSpeed = this.speed;
        }
        // if the ball hit the right
        else if ((this.x + this.diameter) >= this.getWidth()) {
            this.xSpeed = -this.speed;
        }
        // if the ball hit the top
        if (this.y <= 0) {
            this.ySpeed = this.speed;
        }
        // if the ball hit the bottom
        else if ((this.y + this.diameter) >= this.getHeight()) {
            this.ySpeed = -this.speed;
        }
        this.x = this.xSpeed + this.x;
        this.y = this.ySpeed + this.y;
        this.repaint();
    }
}
