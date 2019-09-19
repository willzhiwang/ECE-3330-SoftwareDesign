/**
 * @author Zhi Wang
 *This is the GUI class
 *
 * @param welcome           the welcome label
 * @param knownWordLabel    the known word label
 * @param MissesLabel       the missed word label
 * @param inputfield        the field to input
 * @param hangman           the BufferedImage hangman
 * @param hangmanPanel      the hangman panel
 * @param inputPanel        the input panel
 * @param input               the input word;
 * @param wrongcount        the count of wrong input
 * @param known             the known word
 * @param result            the result of win or lose as label
 * @param index             the index of the word
 * @param list              the arraylist of the string input
 *  @param set              the hashset of the wrong input
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.HashSet;
/**
 * This class is extending:
 * @see JFrame
 *
 */
public class GUI extends JFrame {
    private JLabel welcome , knownWordLabel, MissedLabel;
    private JLabel result;
    private JTextField inputfield = new JTextField(null,18);
    private BufferedImage hangman = new BufferedImage(250, 500, BufferedImage.TYPE_INT_ARGB);
    private JPanel hangmanPanel, inputPanel;
    private String input = null;
    private String known = null;
    private int wrongcount= 0;
    private int index;
    private ArrayList<String> list;
    private HashSet<String> set = new HashSet<String>();

    /**
     * the gui to create two panels, and ask user to guess the word
     * also set up everything include text field,labels.
     * And test the input is right or wrong
     */
    public GUI() {
        super("Will's Hangman");
        setLayout(new BorderLayout()); // using borderlayout
        //drawHangmanStand(hangmanImage);
        //wordTextField.setToolTipText("Net Connection: Leave Blank for Random Word");
        welcome = new JLabel("Please input a word: (1 letter)");
        knownWordLabel = new JLabel("  Guess the Word:");
        MissedLabel = new JLabel(  "    You have missed: ");
        result = new JLabel();
        //set the font for the label and field so that it would fill in there
        welcome.setFont(new Font("", Font.PLAIN, 25));
        knownWordLabel.setFont(new Font("", Font.PLAIN, 25));
        inputfield.setFont(new Font("", Font.PLAIN, 25));
        inputfield .setEditable(true);
        MissedLabel.setFont(new Font("", Font.PLAIN, 25));
        result.setFont(new Font("", Font.PLAIN, 45));
        inputPanel = new JPanel();
        inputPanel.add(welcome);
        inputPanel.add(inputfield);
        inputPanel.add(knownWordLabel);

        list = new ArrayList<>();

        add(inputPanel);

        inputfield.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (input == null)
                {
                    char temp;
                    String underline = "";
                    input = inputfield.getText().toLowerCase();
                    inputfield.setText(""); // clean the text field

                    welcome.setText("     Your word:");
                    for (int i = 0; i < input.length(); i++) {
                        known =known+  "_";
                        list.add ("_");
                        underline =underline + " _ ";
                    }

                    knownWordLabel = new JLabel(underline);
                    inputPanel.add(knownWordLabel);
                    inputPanel.add(MissedLabel);
                    inputPanel.add(result);

                    return;
                }
                 index = input.indexOf(inputfield.getText());// use index of to get the number of text
                System.out.print(index+"\n");

                if (index>= 0)
                {
                    Right();
                }
                if (index<0) {
                    Wrong();

                }
                else {

                }
            }
        });
        DrawHangmanframe();
        revalidate();
    }

    /**
     * the function to display the right answer and determine if it is win or not
     *
     */
    private void Right() {
        String answer = inputfield.getText().toLowerCase();
        //add right guess to word
        ArrayList<Integer> indexes = new ArrayList<>();
        int index = input.indexOf(answer);

        while ( index >= 0)
        {
            indexes.add(index);
            //System.out.println(indexes);
            index = input.indexOf(answer, index + 1);
        }

        String listString = "";
        for (int i = 0; i < indexes.size(); i++) {
            index = indexes.get(i);
            //System.out.println(index);
            list.set(index, answer);

            for (String s : list)
            {
                listString += s + " ";
            }
        }
        //System.out.println("after: "+ list);
        known = listString;
            knownWordLabel.setText(listString);
            //System.out.println(wordKnown);

        inputfield.setText("");

       if (known.indexOf("_") < 0) {
           inputfield.setEditable(false);// after result
           result.setText("        You Win!          ");
       }

    }

    /**
     * The function to display the wrong answer and determine if it is lose
     * and also draw the man of the hangman
     * https://docs.oracle.com/javase/7/docs/api/java/awt/Graphics.html
     */
    private void Wrong() {
        //use hashset to save the inputs
        //https://docs.oracle.com/javase/7/docs/api/java/util/HashSet.html
        String wrong = inputfield.getText();
        set.add(wrong);
        String replace=set.toString().replace("[","");
        String replace1=replace.replace("]","");
        MissedLabel.setText("You have missed: "+replace1);
        wrongcount=set.size();

        //Drawing:
        //https://docs.oracle.com/javase/7/docs/api/java/awt/Graphics.html
        //draw the actual hangman
        Graphics2D g = (Graphics2D) hangman.getGraphics();
        g.setStroke(new BasicStroke(4));//Set the size and color
        g.setColor(Color.BLACK);
        switch (wrongcount) {
            case 1:
                g.drawOval( 90, 100, 20, 20);//draw the head
                break;
            case 2:
                g.drawLine(100, 120, 100, 190);//draw body (just draw a vertical lane)
                break;
            case 3:
                g.drawLine(100,  140, 40, 120);//draw left arm

                break;
            case 4:
                g.drawLine(100, 140, 160, 120);//draw right arm
                break;
            case 5:
                g.drawLine(100, 190, 20, 250);// draw left leg

                break;
            case 6: //at case 6 you will lose
                g.drawLine(100, 190, 180, 250);// draw right leg
                inputfield.setEditable(false);// after result
                result.setText("       You Lose           ");
                break;
            default:
                System.out.println("Error");
                break;
        }

        hangmanPanel = new JPanel();
        hangmanPanel.add(new JLabel(new ImageIcon(hangman)));
        add(hangmanPanel, BorderLayout.EAST);
        //https://docs.oracle.com/javase/7/docs/api/java/awt/Window.html
        g.dispose();//clean the window
        inputfield.setText("");
    }

    /**
     * Draw the frame of the hangman graph, by using two vertical lanes and two
     * horizontal lanes
     * https://docs.oracle.com/javase/7/docs/api/java/awt/Window.html
     */
    private  void DrawHangmanframe(){
        //Drawing:
        //https://docs.oracle.com/javase/7/docs/api/java/awt/Graphics.html
        Graphics2D g = (Graphics2D) hangman.getGraphics();
        g.setStroke(new BasicStroke(4));
        g.setColor(Color.BLACK);
        // Draw the frame first
        g.drawLine(50, 350, 200, 350);//bottom vertical lane
        g.drawLine(200, 350, 200, 50);//Right Horizontal lane
        g.drawLine(100, 50, 200, 50);// top vertical lane
        g.drawLine(100, 50, 100, 100);//Left Horizontal lane

        hangmanPanel = new JPanel();
        hangmanPanel.add(new JLabel(new ImageIcon(hangman)));//add graphic
        add(hangmanPanel, BorderLayout.EAST);
        //https://docs.oracle.com/javase/7/docs/api/java/awt/Window.html
        g.dispose();//make the window destroyed and cleaned up by the operating system
    }

}
