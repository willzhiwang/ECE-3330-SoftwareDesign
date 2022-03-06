import java.util.Scanner;

public class Main {
    /**
     * @param input User input numbers
     * @param input User input k
     */
    public static double[] input = new double[5];
    public static int k;

    /**
     * @param args This is the Main function that set user interface on console
     */
    public static void main(String[] args) {

        System.out.println("-------------Please input your num (5 numerical features!)-----------");
        Scanner s = new Scanner(System.in);
        for (int i = 0; i < input.length; i++) {

            double in = s.nextDouble();
            input[i] = in;
        }
        System.out.println("You have entered: ");
        for (double t : input) {
            System.out.println(t + ", ");
        }

        System.out.println("------------------Your k: (an integer between 1 to 5)---------------------");
        k = s.nextInt();
        while (k > 5 || k < 1) {
            System.out.println(" k is a int between 1 to 5");
            k = s.nextInt();
        }
        System.out.println("Your k: " + k);

        Knearest kn = new Knearest();
    }
}
