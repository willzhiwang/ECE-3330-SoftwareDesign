package RequestInheritance;

import java.util.UUID;
/**
 * class request extends data generator to get randon data
 * @see DataGenerator
 */
public class Request extends DataGenerator {
    private UUID randUUID = getRandUUID();
    public static int count;

    /**
     *
     * @param randUUID random UUID
     */
    public Request(UUID randUUID)
    {
        this.randUUID = randUUID;
        count++;
    }

    /**
     *
     * @return The Stirng output
     */
    public String toString(){
       return (super.toString()+"\nUUID: " + randUUID);
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
