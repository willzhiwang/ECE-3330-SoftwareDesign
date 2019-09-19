package RequestInheritance;
import java.util.UUID;
/**
 * class GetRequest extends Request to get randon data
 * @see Request
 */
public class GetRequest extends Request {
    private String randURL ;
    public static int count;
    /**
     *inheritance from super class and get new variable
     * @param randUUID random UUID
     * @param randURL random URL
     */
    public GetRequest(UUID randUUID, String randURL) {
        super (randUUID);
        this.randURL = randURL;
        count++;
    }
    /**
     *
     * @return The Stirng output
     */
    public String toString(){
        return super.toString() +"\n" + "Universal Resource Locator (URL): " + randURL;

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
