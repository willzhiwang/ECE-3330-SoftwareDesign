import java.util.ArrayList;
/**
 * @author Zhi Wang
 * @version 11/18/2018
 * @see EditDistance
 * <p>
 * This class contain 3 methods to find edit distance
 */
public class EditDistance {
    /**
     * @param arr1                      the array to save 1st word to char
     * @param arr2                      the array to save 2nd word to char
     * @param result                    the result of the matrix
     * @param prints                    the list of the steps
     * @param ed                        the edit distance value
     */
    private char[] arr1, arr2;
    static int[][] result;
    private static ArrayList<String> prints = new ArrayList<String>();
    private static int ed = 0;

    /**
     * the constructor of EditDistance to call minDistance and backtrace and print the final answer
     * @param str1  1st word
     * @param str2  2nd word
     */
    EditDistance(String str1, String str2) {
        arr1 = str1.toCharArray();
        arr2 = str2.toCharArray();
        ed = minDistance(str1, str2);
        backtrace(str1, str2);
        System.out.println("edit distance: " + ed + " --> " + prints.toString().replace(",", "").replace("[", "").replace("]", ""));
    }
    /**
     * minDistance method using DP edit distance solution
     * @param word1  1st word
     * @param word2  2nd word
     */
    //Reference of using matrix https://web.stanford.edu/class/cs124/lec/med.pdf
    public int minDistance(String word1, String word2) {
        //set up the table
        result = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) result[i][0] = i;// the row numbers
        for (int j = 0; j <= word2.length(); j++) result[0][j] = j;// the column

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                //System.out.print(result[i][j] + " ");
                int rem = result[i - 1][j] + 1;// remove when the matrix is shifting left
                int add = result[i][j - 1] + 1;// remove when the matrix is shifting down
                int rep = result[i - 1][j - 1];// replace when the matrix is shifting down left
                //If the char word1 doesn't have a match with char in word2 at all
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    rep += 1;
                }
                int min = Math.min(Math.min(rem, add), rep);// If the last character is different, consider all possibilities and find the minimum
                result[i][j] = min;
            }
            //System.out.println();
        }
        /*System.out.println("----------------");
        for (int i = 0; i <= word1.length(); i++) {
            for (int j = 0; j <= word2.length(); j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("----------------");*/
        return result[word1.length()][word2.length()];
    }

    /**
     *backtrace method to backtrace the result matrix from minDistance
     * @param word1         the 1st string
     * @param word2         the 2nd string
     */
    public void backtrace(String word1, String word2) {
        int dis =0;
        int i =word1.length();
        int j =word2.length();
        // keep finding the smaller value in the matrix until 0
        while (  result[i][j] != 0 ) {
            if (j >0 && i> 0&& result[i][j] > result[i - 1][j - 1]) {
                j--;
                i--;
                dis++;
                prints.add( dis + ". replace '" + arr1[i] + "' in str1 with a '" + arr2[j] +"'\n" );
            }
            else if (j >0 &&result[i][j] > result[i][j - 1]) {
                j--;
                dis++;
                prints.add( dis + ". add '" + arr2[j] + "' to str1\n");
            } else if (i> 0&& result[i][j] > result[i - 1][j]) {
                i--;
                dis++;
                prints.add(dis + ". remove '" + arr1[i] + "' from str1\n");
            }
            else if (j >0 && i> 0&&result[i][j] == result[i - 1][j - 1]) {// move to next char
                j--;
                i--;
            }
        }
    }
}