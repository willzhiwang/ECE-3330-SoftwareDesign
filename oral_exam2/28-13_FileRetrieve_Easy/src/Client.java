import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author Zhi Wang
 * @version 11/18/2018
 * @see Client
 * <p>
 * This class contain 1 main method which runs the client GUI
 */

public class Client extends JFrame {
    private static final int PORT = 12000; // port for this application
    /**
     * @param PORT                   server port
     * @param enterField             inputs message from user
     * @param output                   output stream to client
     * @param input                     input stream from client
     * @param client                    socket to communicate with server
     * @param connection            connection to client
     * @param displayArea           display information to user
     * @param message               message from server
     */
    private final JTextField enterField = new JTextField();// enters information from user
    private final JTextArea displayArea = new JTextArea();// display information to user
    private final String host;// host server for this application
    private ObjectOutputStream output;// output stream to server
    private ObjectInputStream input;// input stream from server
    private String message = "";// message from server
    private Socket client;// socket to communicate with server

    /**
     * This is the Client constructor which initialize chatServer and set up GUI
     */
    public Client(String host) {
        super("Will's Client");
        this.host = host;
        enterField.setEditable(true);
        enterField.addActionListener(new ActionListener() {
                                         // send message to server
                                         public void actionPerformed(ActionEvent event) {
                                             sendData(event.getActionCommand());
                                             enterField.setText("");
                                         } // end method actionPerformed
                                     } // end anonymous inner class
        );

        add(enterField, BorderLayout.NORTH);
        add(new JScrollPane(displayArea), BorderLayout.CENTER);
        setSize(300, 150); // set size of window
        setVisible(true); // show window
    }

    /**
     * This is the runClient method. This method connect to server and process messages from server
     */
    public void runClient() {
        try {
            connectToServer();
            getStreams();
            processConnection();

        } catch (EOFException eofException) {
            displayArea.append("\nNO File Found");
        } catch (IOException ioException) {
            //result.append("\nNO File Found");
            ioException.printStackTrace();
        } finally {
            displayArea.append("\nClosing connection");
            displayArea.append("\nPlease Restart");
            try {
                client.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }

    }

    /**
     * sendData method send message to server
     *
     * @param message
     */
    public void sendData(String message) //implements ActionListener
    {
        try // send object to server
        {
            output.writeObject(message);
            output.flush(); // flush data to output
            displayArea.append("\nCLIENT>>> " + message);
        } // end try
        catch (IOException ioException) {
            displayArea.append("\nError writing object");
        } // end catch
    }

    /**
     * connectTOServer method close streams and socket
     *
     * @throws IOException
     */
    private void connectToServer() throws IOException {
        //displayArea.append("Attempting connection\n");
        // create Socket to make connection to server
        client = new Socket(InetAddress.getByName(host), PORT);
        // display connection information
        displayArea.append("Connected to: " + client.getInetAddress().getHostName());
    }

    /**
     * getStreams method, get streams to send and receive data
     *
     * @throws IOException
     */
    private void getStreams() throws IOException {
        // set up output stream for objects
        output = new ObjectOutputStream(client.getOutputStream());
        output.flush(); // flush output buffer to send header information
        // set up input stream for objects
        input = new ObjectInputStream(client.getInputStream());
        displayArea.append("\nGot I/O streams\n");
    }

    /**
     * processConnection method which process connection with server
     *
     * @throws IOException
     */
    private void processConnection() throws IOException {
        // enable enterField so client user can send messages
        //setTextFieldEditable(true);
        do {
            try {
                message = (String) input.readObject(); // read new message
                displayArea.append("\n" + message); // display message
            } catch (ClassNotFoundException classNotFoundException) {
                displayArea.append("\nUnknown object type received");
            }
        } while (!message.equals("SERVER>>> TERMINATE"));
    }
}