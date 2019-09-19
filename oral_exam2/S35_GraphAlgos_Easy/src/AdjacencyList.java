/**
 * @author Zhi Wang
 * @version 11/10/2018
 * @see AdjacencyList
 * <p>
 * This AdjacencyList class contain 1 method
 */

public class AdjacencyList {
    /**
    * @param edages         the total edges
     */
    private int edages = 0;
    /**
     *indexOfDifference method compare two words and return the edges between them
     * @return the edges between two words
     */
    public int indexOfDifference(String a, String b) {
        //System.out.println(a+" "+b);
        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();
        int counter = 0;
        for (int i = 0; i < charsA.length; i++) {
            if (charsA[i] != charsB[i]) {
                counter++;
            }
        }
        //System.out.println(counter);
        if (counter == 1) {
            edages = 1;
            //System.out.println("+1");
        } else {
            edages = 0;
        }
        //System.out.println(counter);
        return edages;
    }
}
