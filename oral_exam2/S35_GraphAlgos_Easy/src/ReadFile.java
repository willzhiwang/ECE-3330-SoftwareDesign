import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Zhi Wang
 * @version 11/10/2018
 * @see ReadFile
 * <p>
 * This ReadFile class contain 1 constructor
 */
public class ReadFile {
    private static int differs = 0;
    private static int no = 0;
    private static double avg = 0;
    private static int max = 0;
    /**
     * @param maxWords                  hashmap to store the max number of words
     * @param words                         hashmap to store words and edges
     * @param differs                       find the difference between words
     * @param no                              the total number that doesn't have edges
     * @param avg                             the average value of edges
     * @param max                            the max value of edges
     * @param maxResults                  the list to store all words with max edges
     */
    private final HashMap<String, Integer> maxWords = new HashMap<>();
    private final HashMap<String, Integer> words = new HashMap<>();
    private final ArrayList<String> maxResults = new ArrayList<String>();

    /**
     * ReadFile constructor read through the file and find max, avg and 0 value of edges
     */
    public ReadFile() {
        //Get file from resources folder
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("words.dat").getFile());

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String data = scanner.nextLine();
                String[] values = data.split("/n");
                for (String s : values) {
                    words.put(s, 0);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        AdjacencyList g = new AdjacencyList();
        for (String key : words.keySet()) {
            // System.out.println(words.keySet());
            differs = 0;
            for (String keys : words.keySet()) {
                differs = g.indexOfDifference(key, keys);
                words.put(key, (words.get(key) + differs));
            }
        }
        System.out.println(words);
        double vals = 0;
        for (String key : words.keySet()) {

            if (words.get(key) == 0) {
                no++;
            }
            if (words.get(key) >= max) {
                max = words.get(key);
                maxWords.put(key, max);
            }
            vals = vals + words.get(key);
        }
        for (String s : maxWords.keySet()) {
            if (maxWords.get(s) == max) {
                maxResults.add(s);
            }
        }
        avg = vals / words.size();
        System.out.printf("avg num of connections: %.2f \n", avg);
        System.out.println("num nodes with no edges: " + no);
        System.out.println("nodes with the most edges: " + maxResults + " " + max);
    }

}
