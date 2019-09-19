import java.util.HashMap;
/**
 * @author Zhi Wang
 * @version 11/07/2018
 * @see Player
 * <p>
 * This Player abstract class contain 5 methods, it cannot be instantiated but subclassed, and subclass can beinstantiated
 * an instance of an abstract class cannot be created
 */
public abstract class Player {
    /**
     * @param board         draw empty board
     * @param player        player number
     * @param x               x value
     * @param y               y value
     * @param winner       the winner
     */
    private static String[][] board = {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}} ;
    public int player;
    public int x, y;
    public int winner =0;
    /**
     * makeMove method the abstract function
     */
    public abstract void makeMove();

    /**
     * updateBoard method to print the new board
     * @param x                     x value
     * @param y                     y value
     * @param player               player number
     */
    public void updateBoard(int x, int y, int player)
    {
            if (player == 1)
            {
                board [x-1] [y-1] = "X";
                //System.out.println(board [x-1] [y-1]);
            }
            if (player == 2)
            {
                board [x-1] [y-1] = "O";
                //System.out.println(board [x-1] [y-1]);
            }
    }

    /**
     * checkRepeatInput method to check if the value is already input
     * @param x                             x vlaue of input
     * @param y                             y value of input
     * @return repeatStatus             to check if the input is repeated or not
     */
    public int checkRepeatInput (int x, int y)
    {
        int repeatStatus=0;
        if ( board [x-1] [y-1] != " ")
        {
            System.out.println("This is not possible");
            repeatStatus = 1;
        }
        return repeatStatus;
    }
    /**
     * printBoard method to print the board
     */
    public void printBoard ()
    {
        System.out.println("-------------------");
        System.out.println("|  "+board[0][0]+"  |  "+board[1][0]+"  |  "+board[2][0]+"  |");
        System.out.println("|  "+board[0][1]+"  |  "+board[1][1]+"  |  "+board[2][1]+"  |");
        System.out.println("|  "+board[0][2]+"  |  "+board[1][2]+"  |  "+board[2][2]+"  |");
        System.out.println("-------------------");
    }
    /**
     * checkWinPlayer method to check the winner
     * @return winner           the number of player who won
     */
    public int checkWinPlayer ()
    {
        for (int i=0;i<3;i++)
        {
            if (board[i][0]== board[i][1] && board[i][1] == board[i][2])
            {
                 if (board[i][0]== "X")
                 {
                     winner=1;
                 }
                 else if (board[i][0]== "O")
                 {
                     winner = 2;
                 }
            }
            if (board[0] [i]== board[1] [i] && board[1] [i] == board [2] [i])
            {
                if (board[0] [i]== "X")
                {
                    winner=1;
                }
                else if (board[0] [i]== "O")
                {
                    winner = 2;
                }
            }
        }
        if ((board[0] [0]== board[1] [1] && board[1] [1] == board [2] [2] )||(board[0] [2]== board[1] [1] && board[1] [1] == board [2] [0] ) )
        {
            if (board[1] [1]== "X")
            {
                winner=1;
            }
            else if (board[1] [1]== "O")
            {
                winner = 2;
            }
        }
        if (winner !=1 && winner != 2 ) {

                if (board[0][0]!= " " && board[0][1] != " "  && board[0][2] != " "&& board[1][0]!= " " && board[1][1] != " "  && board[1][2] != " " && board[2][0]!= " " && board[2][1] != " "  && board[2][2] != " " )
                {
                    winner =3;
                }
        }
        return  winner;
    }
    /**
     * emptyArray method to check if the array is empty which means that the player can use this spot on the board
     * @return int[] {row, col}         the spot that is empty
     */
    public int [] emptyArray ()
    {
        int row=0, col=0 ;
        for (int s=2; s>=0; s--)
        {
            for (int j= 2; j>=0 ; j--)
            {
                System.out.println("checking: "+ board[s] [j]);
                if (board[s] [j]== " ")
                {
                     row =s;
                     col = j;
                }
            }
        }
        System.out.println("Computer's Choice: "+ (row+1) +", "+(col+1) );
        return new int[] {row, col};
    }
}
