/**
 * @author Zhi Wang
 * @version 11/07/2018
 * @see Main
 * <p>
 * This Main class contain one main method
 */
public class Main {

    /**
     * The main method that calls other class and run the program.
     *
     * @param args
     */
    public static void main(String[] args) {
        MazeTraversal maze = new MazeTraversal(); // Call Mazetraversal
        maze.checkMazePossibility();
    }
}
