/**
 * @author Zhi Wang
 *This is the main class set up the size, visible, resizable of
 * the jframe
 */
import javax.swing.*;

public class Main {
    /**
     * this is the main funciton
     * @param args
     */
    public static void main(String[] args)
    {
        // Auto-generated method stub


        GUI hangman=new GUI();
        //set values of the size the frame
        hangman.setSize(700, 450);
        //calc.setLocationRelativeTo(null);
        hangman.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        hangman.setVisible(true);
        hangman.setResizable(true);

    }
}
