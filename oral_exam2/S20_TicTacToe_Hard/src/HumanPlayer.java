/**
 * @author Zhi Wang
 * @version 11/07/2018
 * @see HumanPlayer
 * <p>
 * This HumanPlayer class contain 2 methods
 */

public class HumanPlayer extends Player {
    /**
     * Constructor of ComputerPlayer to find value
     * @param player            determine the player
     * @param y                   determine x location
     *@param x                      determine y location
     */
    public HumanPlayer(int x, int y,int player)
    {
        this.x = x;
        this.y=y;
        //tempList = new ArrayList<Integer>();
        this.player=player;
    }
    /**
     * makeMove method to move the step
     */
    @Override
    public void makeMove() {
        updateBoard(x,y,player);
    }
}
