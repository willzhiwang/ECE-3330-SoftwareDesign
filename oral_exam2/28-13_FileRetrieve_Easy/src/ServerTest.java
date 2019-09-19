import static javax.swing.JFrame.EXIT_ON_CLOSE;
/**
 * @author Zhi Wang
 * @version 11/18/2018
 * @see ServerTest
 * <p>
 * This class contain 1 main method which calls the server GUI
 */
public class ServerTest {
    /**
     * the main function set the gui and call server class
     * @param args
     */
    public static void main(String args[]){
        Server server = new Server();
        server.setDefaultCloseOperation(EXIT_ON_CLOSE);
        server.setSize(500,500);
        server.runServer();
    }
}
