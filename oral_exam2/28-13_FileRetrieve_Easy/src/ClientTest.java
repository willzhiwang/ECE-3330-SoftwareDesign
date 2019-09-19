import javax.swing.*;

/**
 * @author Zhi Wang
 * @version 11/18/2018
 * @see ClientTest
 * <p>
 * This class contain 1 main method which calls the client GUI
 */
public class ClientTest {
    /**
     * main function to set gui and host
     * @param args
     */
    public static void main(String[] args) {
        Client client;
        if (args.length == 0)
            client = new Client("127.0.0.1"); // connect to localhost
        else
            client = new Client(args[0]); // use args to connect
        client.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        client.setSize(500, 500);
        client.setVisible(true);
        client.runClient();//operate connection
    }
}
