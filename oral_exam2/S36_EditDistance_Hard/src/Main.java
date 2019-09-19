/**
 * @author Zhi Wang
 * @version 11/18/2018
 * @see Main
 * <p>
 * This class contain 1 main method which runs the GUI
 */
import java.util.Scanner;
/**
 * @see Main this is the Main class contains 1 main method
 *
 */
public class Main {
    /**
     *The main method set inputs and call editdistance class to do calculation
     * @param args
     */
    public static void main (String [] args)
    {
        System.out.println("str1: ");
        Scanner input = new Scanner(System.in);
        String str1 = input.next();
        System.out.println("str2: ");
        String str2 = input.next();
        EditDistance e = new EditDistance(str1,str2);
    }
}
