package RequestInheritance;

import java.util.UUID;

/**
 * class PostEncryptedFormRequest extends PostFormRequest to get inheritance
 * @see PostFormRequest
 */
public class PostEncryptedFormRequest extends PostFormRequest {

    private String randEncryptionScheme = getRandEncryptionScheme();
    private static int count;

    /**
     * inheritance from super class and get new variable
     * @param randUUID random UUID
     * @param randIP random IP
     * @param randForm random Form
     * @param randEncryptionScheme random EncryptionScheme
     */
    public PostEncryptedFormRequest(UUID randUUID, String randIP, Form randForm, String randEncryptionScheme) {
        super (randUUID,randIP, randForm);
        this.randEncryptionScheme=randEncryptionScheme;
        count++;
    }
    /**
     *
     * @return The Stirng output
     */
    public String toString(){
        return super.toString() + "\nThis form was encrypted using: " +randEncryptionScheme;
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
