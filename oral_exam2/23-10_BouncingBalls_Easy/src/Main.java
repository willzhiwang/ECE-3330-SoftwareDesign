/**
 * @author Zhi Wang
 * @version 11/08/2018
 * @see Main
 * <p>
 * This class contain 1 main method which runs the GUI
 */

import javax.swing.JFrame;

/**
 * @see GUIball this is the class to set size
 *
 */
public class Main {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        GUIball b = new GUIball();
        b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //b.add(Ball.updateball.getBall());
        b.setSize(500, 450);        //set values of the size the frame
        b.setVisible(true);
        b.setResizable(true);
    }
}
