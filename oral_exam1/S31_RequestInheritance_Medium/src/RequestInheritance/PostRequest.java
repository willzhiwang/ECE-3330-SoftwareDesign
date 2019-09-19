package RequestInheritance;

import java.util.UUID;
/**
 * class request extends request to get inheritance
 * @see Request
 */
public class PostRequest extends Request {
    private String randIP = getRandIP();
    public static int count;
    /**
     *inheritance from super class and get new variable
     * @param randUUID random UUID
     * @param randIP  random IP
     */

    public PostRequest(UUID randUUID, String randIP) {
        super (randUUID);
        this.randIP=randIP;
        count++;

    }
    /**
     *
     * @return The Stirng output
     */
    public String toString(){
        return (super.toString() + "\n" + "Post request to server with IP address: " + randIP);

    }
    /**
     *
     * @return count number
     */
    public static int count()
    {
        return count;
    }
}
