package RequestInheritance;

import java.util.UUID;

/**
 * class request extends data generator to get randon data
 *
 * @see DataGenerator
 */
public class Request extends DataGenerator {
    public static int count;
    private UUID randUUID = getRandUUID();

    /**
     * @param randUUID random UUID
     */
    public Request(UUID randUUID) {
        this.randUUID = randUUID;
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
        return (super.toString() + "\nUUID: " + randUUID);
    }
}
