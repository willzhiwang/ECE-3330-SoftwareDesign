/*
 * The following class contain the Anonymous Gregorian algorithm, easter calculation and
 * display the date.
 *
 */
import java.util.*;
// Create a class for last part in future use
public class EasterCal {

    private int a,b,c,d,e,f,g,h,i,j,k,l,m,n;
    private int day,year;
    private String month;

    EasterCal(int num)
    {
        year=num;
    }

    /**
     * The Following Calculation is from Wikipedia
     * Anonymous Gregorian algorithm
     *
     * @param year
     * @return          the date in int
     */
    public  int getEasternumber(int year) {

        a = year % 19;
        b = (int) Math.floor(year / 100);
        c = year % 100;
        d = (int) Math.floor(b / 4);
        e = b % 4;
        f = (int) Math.floor((b + 8) / 25);
        g = (int) Math.floor((b - f + 1) / 3);
        h = (19 * a + b - d - g + 15) % 30;
        i = (int) Math.floor(c / 4);
        k = c % 4;
        l = (32 + 2 * e + 2 * i - h - k) % 7;
        m = (int) Math.floor((a + 11 * h + 22 * l) / 451);
        n = (int) Math.floor((h + l - 7 * m + 114) / 31);//month
        day = (((h + l - (7 * m) + 114) % 31) + 1);// Get the result of day

        return (n * 100) + day;
    }

    public String getEasterdate(int n) {
        /**
         * @param n     the date in int
         * @return          the date in String
         */

        //The cases of n, switching it to a string
        switch (n / 100) {
            case 1:
                month = "January ";
                break;
            case 2:
                month = "February ";
                break;
            case 3:
                month = "March ";
                break;
            case 4:
                month = "April ";
                break;
            case 5:
                month = "May ";
                break;
            case 6:
                month = "June ";
                break;
            case 7:
                month = "July ";
                break;
            case 8:
                month = "August ";
                break;
            case 9:
                month = "September ";
                break;
            case 10:
                month = "October ";
                break;
            case 11:
                month = "November ";
                break;
            case 12:
                month = "December ";
                break;
            default:
                month = "none? or error"; //depends on the calculation, perhaps an error at this point
        }
        String stringday = Integer.toString(n % 100);
        String date = month + stringday;

        return date;
    }
    /**
     * This following class loops through the 5,700,000 cycle, and display the number of
     * times Easter occurred on each calendar day
     */
    public void getlist()
    {
        /**
         *      Using array list and Hash set to get all the date and year and match them together
         */
//Note: array is not working in this case, 5,700,000 is a huge number to compile by using array,
//      the program would stopped working or not showing anything
        // get a arraylist, it contains all the easter days as number
        List<Integer> list = new ArrayList<>();
        for (int k = 0; k < 5700000; k++)
        {
            list.add(getEasternumber(k));
        }
        //The following part was testing: that helped to find the range of the cycle in numbers
        Set<Integer> set = new HashSet<>(list); // change the numbers of date arraylist to a Hashset, preference:https://docs.oracle.com/javase/7/docs/api/java/util/HashSet.html
        List<Integer> newlist = new ArrayList<Integer>(set);//Back to arraylist
        //System.out.print(newlist);
        int min=newlist.get(0);// the first value which is min
        //System.out.println (min);
        Object[] range = newlist.toArray();// change the list to array, which is the range of dates

        int max  = (int) range[range.length-1];// find out the last value of the array which is the max

        List<Integer> count = new ArrayList<>();//arraylist for count

        for (int l = min; l <=max; l++)//Find out the range 322-425 of Easter by testing
        {
            int c = Collections.frequency(list, l);// preference:https://www.tutorialspoint.com/java/util/collections_frequency.htm
            if (c != 0) //take out few values equal 0,such as 332 to 400 which does not exist
            {
                count.add(c);//
            }
        }
        List<String> alldates = new ArrayList<>();
        // get the dates from
        for (int j = 0; j < range.length; j++)
        {
            int z = (int) range[j];//set the array to int
            String f = getEasterdate(z);
            alldates.add(f);
        }

        // The following part is printing lists side by side!
        for (int i = 0; i < count.size(); i++) {
            System.out.println(alldates.get(i) + " - " + count.get(i));
        }
    }
}