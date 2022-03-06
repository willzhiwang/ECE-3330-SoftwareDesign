import java.util.Scanner;

// A class known as EasterCal

/**
 *
 */
class main {
    /**
     * This is main function to print and input for user
     *
     * @param args
     */
    public static void main(String[] args) {

        System.out.print("Please enter a year: ");
        Scanner a = new Scanner(System.in);

        int num = a.nextInt();

        // When the year is smaller than 0 (not sure the easter exists BC)
        while (num <= 0) {
            System.out.println("please give a positive number year");
            System.out.print("Please enter a year: ");
            num = a.nextInt();
        }
        // Finish loop until a positive number entered
        EasterCal e = new EasterCal(num);// Easier to last part,Accroding: "Later parts of this assignment will be easier if you have a constructor"
        int d = e.getEasternumber(num);//get number
        String date = e.getEasterdate(d);//Change the number to String
        System.out.println("Easter: " + date + "," + num);
        // Medium Part:
        System.out.println("---------------------");
        e.getlist();// This will calculate the dates of Easter over an entire cycle and display it
    }
}