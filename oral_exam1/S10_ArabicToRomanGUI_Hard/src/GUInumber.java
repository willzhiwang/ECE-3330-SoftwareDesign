/**
 * @author Zhi Wang
 *This is the GUI class
 *
 */
import javax.swing.*;
import java.awt.*; // set layout, etc
import java.awt.event.*; // All key events

/**
 * This class is extending JFrame
 * @see JFrame
 *
 */
public class GUInumber extends JFrame
{
    private  JTextField textField1; // text field with set size
    private JTextField textField2; // text field with text
    private JLabel Arabic;
    private JLabel Roman;
    public String decimal;
    public  String roman, romantest;
    String roman_numbers[] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    int numbers[] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    //arabic to roman calculation
    public static int box;

    /**
     *  This GUInumber funcion set textfields and labels
     *  with addKeyListener method and KeyAdapter abstract class apply on textfield to read input
     */
    public GUInumber() {
        super("Great Arabic/Roman Numbers translator");
        setLayout(new FlowLayout()); // Using FlowLayout !!!!

        Arabic = new JLabel("Arabic Num/ Roman Num: (1-3999)");
        add(Arabic);
        textField1 = new JTextField(40);
        textField1.setPreferredSize(new Dimension(200, 50)); // Set Da Size, Easier to Read
        add(textField1); // add textField1 to JFrame

        Roman = new JLabel("Roman Num/ Arabic Num: (1-3999)");
        add(Roman);
        // construct textfield with default text
        textField2 = new JTextField(40);
        textField2.setPreferredSize(new Dimension(200, 50)); // Set Da Size, Easier to Read
        add(textField2); // add textField2 to JFrame

        //https://docs.oracle.com/javase/7/docs/api/java/awt/event/KeyAdapter.html
        //https://stackoverflow.com/questions/8498147/addkeylistener-doesnt-work-for-jpanel   (How addKeyListener works with JLable,Jpanel, etc
        textField1.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                String resultstring = textField1.getText();
                box =0;
                try {
                    arabic2roman(resultstring);
                    textField2.setText(roman);
                }
                catch (NumberFormatException error) {
                }
                try
                {
                        System.out.println(box);
                        roman2arabic(resultstring);
                }
                    catch (NumberFormatException error)
                    {
                        textField2.setText("invalid");
                    }

            }
        });
        textField2.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                box = 1;
                String result = textField2.getText();
                try {
                    arabic2roman(result);
                    textField1.setText(roman);
                } catch (NumberFormatException error) {
                    //textField2.setText("invalid");
                }
                try {
                    System.out.println(box);
                    roman2arabic(result);
                } catch (NumberFormatException error) {
                    textField1.setText("invalid");
                }
            }
        });
    }

    /**
     * translate arabic to roman
     * @param arabic the string input that are supposed to be int
     */
    private void arabic2roman ( String arabic)
    {
        int result = 0;
        String results;
        results = arabic;

        try {
            result = Integer.parseInt(results);
            roman = "";
            //int result = arabic;
            if (result >= 1 && result <= 3999) {
                //Value that will go in roman text field
                int temp = result;

                for (int j = 0; result > 0; j++) {
                    temp = result / numbers[j];

                    for (int i = 1; i <= temp; i++) {
                        roman = roman + roman_numbers[j];
                    }
                    result = result % numbers[j];

                    romantest = roman;
                }
            }
            else {
                if (box ==0)
                {
                    textField2.setText("invalid");
                }
                if (box ==1)
                {
                    textField1.setText("invalid");
                }
                System.out.print("Between 1 and 3999!");
            }

        }
        // if string is not int
        catch (NumberFormatException error)
        {

        }
    }
    /**
     * translate roman to arabic
     * @param r the string input that are supposed to be int
     */
    private void roman2arabic(String r) {
        String romanNumeral = r.toUpperCase();
        System.out.println(romanNumeral);

        if ((romanNumeral.contains("XXXX") || romanNumeral.contains("IIII") || romanNumeral.contains("CCCC") || romanNumeral.contains("MMMM")))
        {
            if (box ==0)
            {
                textField2.setText("invalid");
            }
            if (box ==1)
            {
                textField1.setText("invalid");
            }
        }
        else if (((romanNumeral.contains("M") || (romanNumeral.contains("C"))) || (romanNumeral.contains("D")) || (romanNumeral.contains("L")) || (romanNumeral.contains("X"))
                || (romanNumeral.contains("V")) || (romanNumeral.contains("I"))))
        {
            int decimalNum = 0;
            int len = romanNumeral.length();
            int num = 0;
            int previousNum = 0;
            // get all romans to char
            int check = 0;
            for (int i = len - 1; i >= 0; i--)
            {
                char x = romanNumeral.charAt(i);
                x = Character.toUpperCase(x);// all upper case

                if (x == 'I') {
                    previousNum = num;
                    num = 1;
                } else if (x == 'V') {
                    previousNum = num;
                    num = 5;
                } else if (x == 'X') {
                    previousNum = num;
                    num = 10;
                } else if (x == 'L') {
                    previousNum = num;
                    num = 50;
                } else if (x == 'C') {
                    previousNum = num;
                    num = 100;
                } else if (x == 'D') {
                    previousNum = num;
                    num = 500;
                } else if (x == 'M') {
                    previousNum = num;
                    num = 1000;
                }
                else {
                    //System.out.println("failed");
                    check = 1; //check fail
                    if (box ==0)
                    {
                        textField2.setText("invalid");
                    }
                    if (box ==1)
                    {
                        textField1.setText("invalid");
                    }

                }
                if (num < previousNum) {
                    decimalNum = decimalNum - num;
                }
                else {
                    decimalNum = decimalNum + num;
                }
            }
            if (check == 0)
            {
                arabic2roman(String.valueOf(decimalNum)); // check all invalid cases
                //System.out.println(romantest);
                //System.out.println(romanNumeral);
                if (romanNumeral.equals(romantest))
                {
                    decimal = Integer.toString(decimalNum);

                    if (box ==0)
                    {
                        textField2.setText(decimal);
                    }
                    if (box ==1)
                    {
                        textField1.setText(decimal);
                    }
                }
                else
                {
                    if (box ==0)
                    {
                        textField2.setText("invalid");
                    }
                    if (box ==1)
                    {
                        textField2.setText("invalid");
                    }
                }
            }
            else {
                //textField1.setText("invalid");
            }
        }
        else {
        }
    }

}


