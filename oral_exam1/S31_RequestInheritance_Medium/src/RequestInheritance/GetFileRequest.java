package RequestInheritance;

import java.util.UUID;

/**
 * class GetFileRequest extends GetRequest to get inheritance
 *
 * @see GetRequest
 */
public class GetFileRequest extends GetRequest {
    private static int count;

    /**
     * inheritance from super class and get new variable
     *
     * @param randUUID random UUID
     * @param randFile random File
     */
    public GetFileRequest(UUID randUUID, File randFile) {
        super(randUUID, randFile.getURL());
        count++;
    }

    /**
     * @return count number
     */
    public static int count() {
        return count;
    }

    /**
     * @return The Stirng output
     */
    public String toString() {
        return super.toString();
    }
}
