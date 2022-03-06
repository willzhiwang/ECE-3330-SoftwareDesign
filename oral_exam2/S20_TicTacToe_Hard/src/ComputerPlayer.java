/**
 * @author Zhi Wang
 * @version 11/07/2018
 * @see ComputerPlayer
 * <p>
 * This ComputerPlayer class contain 2 methods
 */
public class ComputerPlayer extends Player {
    /**
     * Constructor of ComputerPlayer to find value
     *
     * @param player determine the player
     */
    public ComputerPlayer(int player) {
        //this.x = x;
        //this.y=y;
        //tempList = new ArrayList<Integer>();
        this.player = player;
    }

    /**
     * makeMove method to move the step
     */
    @Override
    public void makeMove() {

        int[] result = emptyArray();
        //System.out.println(result[0]+", "+result[1]);
        x = result[0];
        y = result[1];
        updateBoard(x + 1, y + 1, player);
    }

}
