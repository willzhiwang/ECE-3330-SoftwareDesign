import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Zhi Wang
 * @version 11/08/2018
 * @see GUIball this is the calss extends jframe and implements mouselistener and runnable
 */
public class GUIball extends JFrame implements MouseListener, Runnable {
    private static boolean counter = false;
    /**
     * @param bouncingBall
     * @param counter
     */
    private final Bouncing bouncingBall;

    /**
     * This is the GUIball method. This method add functional ball to GUI.
     */
    public GUIball() {
        bouncingBall = new Bouncing();
        addMouseListener(this);
        add(bouncingBall);
    }

    /**
     * This is the default mouseClicked method
     */
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    /**
     * This is the mousePressed method. This method set execute of the ball when first time pressed.
     */
    @Override
    public void mousePressed(MouseEvent e) {
        //when first press start the ball
        if (counter == false) {
            ExecutorService ex = Executors.newCachedThreadPool();
            ex.execute(this);
            counter = true;
        }
    }

    /**
     * This is the default mouseReleased method
     */
    @Override
    public void mouseReleased(MouseEvent e) {
    }

    /**
     * This is the default mouseEntered method
     */
    @Override
    public void mouseEntered(MouseEvent e) {
    }

    /**
     * This is the default mouseExited method
     */
    @Override
    public void mouseExited(MouseEvent e) {
    }

    /**
     * This is the run method, a loop to keep run thread with a sleep time
     */
    public void run() {
        while (true) {
            try {
                Thread.sleep(2);
                bouncingBall.runSteps();
            } catch (Exception e) {

            }
        }
    }
}
