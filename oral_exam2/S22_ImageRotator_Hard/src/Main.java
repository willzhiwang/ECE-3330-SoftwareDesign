import javax.swing.*;

/**
 * @author Zhi Wang
 * @version 11/15/2018
 * @see Main
 * <p>
 * This Board class contain 4 methods
 */
public class Main {
    /**
     * this is the main funciton, to call the RotatorGUI class and set up GUI
     *
     * @param args
     */
    public static void main(String[] args) {
        RotatorGUI a = new RotatorGUI();
        a.setVisible(true);
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a.setSize(400, 400);
        a.setVisible(true);
        a.setResizable(false);
    }
}
