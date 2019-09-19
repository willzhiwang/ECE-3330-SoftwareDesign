/**
 * @author Zhi Wang
 * @version 11/07/2018
 * @see MazeTraversal
 * <p>
 * This MazeTraversal class contain 4 methods
 */
public class MazeTraversal {
    /**
     *@param initiCol
     * @param initiRow
     * @param moves
     * @param maze
     */
    private static final int initiCol = 0;
    private static final int initiRow = 2;
    private static int moves = 0;
    private static char maze[][] = {
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', '.', '.', '.', '#', '.', '.', '.', '.', '.', '.', '#'},
            {'.', '.', '#', '.', '#', '.', '#', '#', '#', '#', '.', '#'},
            {'#', '#', '#', '.', '#', '.', '.', '.', '.', '#', '.', '#'},
            {'#', '.', '.', '.', '.', '#', '#', '#', '.', '#', '.', '.'},
            {'#', '#', '#', '#', '.', '#', '.', '#', '.', '#', '.', '#'},
            {'#', '.', '.', '#', '.', '#', '.', '#', '.', '#', '.', '#'},
            {'#', '#', '.', '#', '.', '#', '.', '#', '.', '#', '.', '#'},
            {'#', '.', '.', '.', '.', '.', '.', '.', '.', '#', '.', '#'},
            {'#', '#', '#', '#', '#', '#', '.', '#', '#', '#', '.', '#'},
            {'#', '.', '.', '.', '.', '.', '.', '#', '.', '.', '.', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}};  // creating the maze

    /**
     * The mazeTraversal method to passing the new spot on the maze as the current spot
     * recursive function, every time check if it hit the wall and if it's keep going
     * @param maze
     * @param y
     * @param x
     * @teurn true/false
     */
    private boolean mazeTraversal(char maze[][], int y, int x) {
        this.maze = maze;
        maze[y][x] = 'x';
        printMaze();  // print maze
        moves++;
        // check if the maze is all the way done after moves
        if (mazeDone(y, x) && (moves > 1)) {
            return true;
        }
        // move up
        if (mazeRange(y - 1, x) && mazeTraversal(maze, y - 1, x)) {
            return true;
        }
        // move down
        if (mazeRange(y + 1, x) && mazeTraversal(maze, y + 1, x)) {
            return true;
        }
        // move left
        if (mazeRange(y, x - 1) && mazeTraversal(maze, y, x - 1)) {
            return true;
        }
        // move right
        if (mazeRange(y, x + 1) && mazeTraversal(maze, y, x + 1)) {
            return true;
        } else {
            maze[y][x] = '0';
            return false;
        }
    }
    /**
     * The printMaze method to print the 2D array as maze
     */
    private void printMaze() {
        // Use two for loops to print maze.
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze.length; j++) {
                System.out.print(" " + maze[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
    /**
     * The mazeDone method to check if maze is all the way to the wall
     * @return (row == 0) || (row == 11) || (col == 0) || (col == 11)
     */
    private static boolean mazeDone(int row, int col) {
        return ((row == 0) || (row == 11) || (col == 0) || (col == 11));
    }
    /**
     * The mazeRange method to check if maze is still able to move in the range
     * @return (row >= 0) && (row <= 11) && (col >= 0) && (col <= 11) && (maze[row][col] == '.')
     */
    private static boolean mazeRange(int row, int col) {
        return ((row >= 0) && (row <= 11) && (col >= 0) && (col <= 11) && (maze[row][col] == '.'));
    }
    /**
     * The checkMazePossibility method to check if maze has a solution
     */
    public void checkMazePossibility() {
        boolean result = mazeTraversal(maze, initiRow, initiCol); // set result
        if (result == false) {
            System.out.println("Not possible to solve this maze.");  // print out maze has no solution.
        } else {
            System.out.println("Maze has been solved successful!");
        }
    }
}