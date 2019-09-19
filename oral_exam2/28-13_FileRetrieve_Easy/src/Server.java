import javax.swing.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author Zhi Wang
 * @version 11/18/2018
 * @see Server
 * <p>
 * This class contain methods which run the server GUI
 */

public class Server extends JFrame {
    /**
     * @param PORT                  server port
     * @param enterField             inputs message from user
     * @param output                  output stream to client
     * @param input                    input stream from client
     * @param server                   server socket
     * @param connection            connection to client
     */
    private static final int PORT = 12000;
    private JTextArea enterField;// inputs message from user

    private ObjectOutputStream output; // output stream to client
    private ObjectInputStream input; // input stream from client

    private ServerSocket server; // server socket
    private Socket connection; //

    /**
     * Server constructor set up GUI
     */
    public Server() {
        super("Will's Server");
        enterField = new JTextArea();
        add(new JScrollPane(enterField));
        enterField.setEnabled(false);
        setVisible(true);
    }

    /**
     * runServer method set up and run server
     */
    public void runServer() {
        try {
            server = new ServerSocket(PORT, 100);
            while (true) {
                try {
                    waitForConnection(); // wait for a connection
                    getStreams(); // get input & output streams
                    processConnection(); // process connection
                } catch (EOFException eofException) {
                    enterField.append("\nServer terminated connect");
                } finally {
                    closeConection();
                }
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    /**
     * processConnection method that process connection with client
     * @throws IOException
     */
    private void processConnection() throws IOException {
        String message = "Connection successful";
        sendData(message); // send connection successful message

        // enable enterField so server user can send messages
        do // process messages sent from client
        {
            try // read message and display it
            {
                // read files
                message = (String) input.readObject(); // read new
                ClassLoader classLoader = getClass().getClassLoader();// load current directory
                File file = new File(classLoader.getResource(message).getFile());
                try {
                    Scanner reader = new Scanner((file));
                    while (reader.hasNextLine()) {
                        sendData(reader.nextLine());
                    }
                } catch (IOException e) {
                    sendData(message + "\nFile does not exist");
                }

            } catch (ClassNotFoundException classNotFoundException) {
                enterField.append("\nUnknown object type received");
            }

        } while (!message.equals("CLIENT>>> TERMINATE"));
    }

    /**
     * waitForConnection method, wait for connection to arrive, then display connection info
     * @throws IOException
     */
    private void waitForConnection() throws IOException {
        enterField.append("Waiting connection\n");
        connection = server.accept(); // allow server to accept connection
        enterField.append("Connected!\n");
    }

    /**
     * getStreams method, get streams to send and receive data
     * @throws IOException
     */
    public void getStreams() throws IOException {
        output = new ObjectOutputStream(connection.getOutputStream());
        output.flush();
        input = new ObjectInputStream(connection.getInputStream());
        enterField.append("\nGot I/O streams\n");
    }

    /**
     * sendData method, wait for connection to arrive, then display connection info
     * @throws IOException
     */
    public void sendData(String message) {
        try {
            output.writeObject("SERVER>>> " + message);
            output.flush();
        } catch (IOException ioException) {
            enterField.append("\nError writing object");
        }
    }

    /**
     * closeConnection method, wait for connection to arrive, then display connection info
     * @throws IOException
     */
    public void closeConection() {
        enterField.append("\nTerminating connect\n");
        try {
            connection.close();
            input.close();
            output.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
