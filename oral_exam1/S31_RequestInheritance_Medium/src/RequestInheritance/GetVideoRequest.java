package RequestInheritance;

import java.util.UUID;

/**
 * class GetVideoRequest extends GetRequest to get inheritance
 *
 * @see GetRequest
 */
public class GetVideoRequest extends GetRequest {

    private static int count;

    /**
     * inheritance from super class and get new variable
     *
     * @param randUUID  random UUID
     * @param randVideo random Video
     */
    public GetVideoRequest(UUID randUUID, Video randVideo) {

        super(randUUID, randVideo.getVideo());
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
