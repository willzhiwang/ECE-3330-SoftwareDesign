/**
 * @author Zhi Wang
 *This is the main class set up the size, visible, resizable of
 * the jframe
 * All settings are here
 */
import javax.swing.*;

public class Main {
    /**
     * this is the main funciton, to call the GUI class and set up
     * @param args
     */
    public static void main(String[] args)
    {
        // Auto-generated method stub
        GUInumber translate=new GUInumber();
        translate.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        translate.setSize(500, 450);        //set values of the size the frame
        translate.setVisible(true);
        translate.setResizable(true);

    }
}
