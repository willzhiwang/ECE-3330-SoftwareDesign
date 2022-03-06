import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 20 years: 2001-2010
// Source:https://en.wikipedia.org/wiki/List_of_dates_for_Easter

/*******************Results *************************
 *2001	April 15
 *2002	March 31
 *2003	April 20
 *2004	April 11
 *2005	March 27
 *2006	April 16
 *2007	April 8
 *2008	March 23
 *2009	April 12
 *2010	April 4
 *2011	April 24
 *2012	April 8
 *2013	March 31
 *2014	April 20
 *2015	April 5
 *2016	March 27
 *2017	April 16
 *2018	April 1
 *2019	April 21
 *2020	April 12
 */
public class EasterCalTest {

    @Test
    public void main() {
        /**
         *  Using Junit5 Test to test an array of dates
         */
        // save 20 samples as array includes years, yeas wrote as numbers, the actually date
        int[] years = new int[20];
        int[] dates = {415, 331, 420, 411, 327, 416, 408, 323, 412, 404, 424, 408, 331, 420, 405, 327, 416, 401, 421, 412};
        String[] easterday = {"April 15", "March 31", "April 20", "April 11", "March 27", "April 16", "April 8", "March 23", "April 12", "April 4", "April 24", "April 8", "March 31", "April 20", "April 5", "March 27", "April 16", "April 1", "April 21", "April 12"};
        for (int i = 0; i < years.length; i++) {
            years[i] = 2001 + i;
            //Test
            //System.out.println(years[i]+" "+dates[i]+" "+ easterday[i]);
            EasterCal a = new EasterCal(dates[i]);
            // test the dates wrote as numbers
            assertEquals(dates[i], a.getEasternumber(years[i]));
            //test the actual dates
            assertEquals(easterday[i], a.getEasterdate(dates[i]));
        }
        System.out.print("All Passed!");
    }
}