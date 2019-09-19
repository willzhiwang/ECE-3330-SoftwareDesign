import java.util.*;
/**
 * @author Zhi Wang
 * @version 11/07/2018
 * @see Board
 * <p>
 * This Board class contain 4 methods
 */
public class Board {
    /**
     *@param winlose            the wining status
     * @param player1           the number of player 1
     * @param player2           the number of player 2
     */
    private static int winlose=0;
    private int player1=1;
    private int player2=2;
    /**
     * The is the constructor of Board prints the game options and ask inputs, and determine who the players are
     *
     */
    public Board() {
        System.out.println("Please enter a mode (1-3): \n 1. PVP 2.PVE 3.EVE ");
        Scanner option = new Scanner(System.in);
        int o = option.nextInt();
        switch (o)
        {
            case 1:
                System.out.println("PVP Mode");
                while (winlose == 0) {
                    humanPlayerPrint(player1);
                    if (winlose == 0)
                    {
                        humanPlayerPrint(player2);
                    }
                }
                printWinner(winlose);
                break;
            case 2:
                System.out.println("PVE Mode");
                while (winlose == 0) {
                    humanPlayerPrint(player1);
                    if (winlose == 0) {
                        computerPlayerPrint(player2);
                    }
                }
                printWinner(winlose);
                break;
            case 3:
                System.out.println("EVE Mode");
                while (winlose == 0) {
                    computerPlayerPrint(player1);
                    if (winlose == 0) {
                    computerPlayerPrint(player2);}
                }
                printWinner(winlose);
                break;
            default:
                System.out.println("invalid Mode");
        }

        //ComputerPlayer test = new ComputerPlayer(board, player);
    }
    /**
     * The is the humanPlayerPrint method input player's play process
     * @ param player       determien which player is playing
     */
    public void humanPlayerPrint( int player)
    {

        int repeat=0;
        do{
            System.out.println("Player" + player + ":");
            System.out.println("ROW (1-3):");
            Scanner in = new Scanner(System.in);
            int row = in.nextInt();
            while (row != 1 && row != 2 && row != 3) {
                System.out.println("Row Has to be 1,2 or 3:");
                row = in.nextInt();
            }
            System.out.println("COL(1-3):");
            Scanner in1 = new Scanner(System.in);
            int col = in1.nextInt();

            while (col != 1 && col != 2 && col != 3) {
                System.out.println("Col Has to be 1,2 or 3:");
                col = in1.nextInt();
            }
            HumanPlayer test = new HumanPlayer(row, col, player);
            repeat = test.checkRepeatInput(row,col);
            if (repeat!=1)
            {
                test.makeMove();
            }
            test.printBoard();
            winlose = test. checkWinPlayer ();

        }while (repeat==1 );

    }
    /**
     * The is the computerPlayerPrint method input player's play process
     * @ param player       determine which player is playing
     */
    public void computerPlayerPrint (int player)
    {
        System.out.println("(Computer) Player: " + player + ":");

        ComputerPlayer computerPlayer = new ComputerPlayer(player);
        computerPlayer.makeMove();
        computerPlayer.printBoard();
        winlose = computerPlayer. checkWinPlayer ();
    }
    /**
     * The is the printWinner method determine the game status, win lose or tie
     * @ param win              the value to determine the status
     */
    public void printWinner ( int win)
    {
        if (win ==1 )
        {
            System.out.println("Player1 Won");
        }
        if (win ==2 )
        {
            System.out.println("Player2 Won");
        }
        if (win ==3 )
        {
            System.out.println("Tie");
        }

    }

}
