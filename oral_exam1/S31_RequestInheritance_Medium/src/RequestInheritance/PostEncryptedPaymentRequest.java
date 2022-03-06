package RequestInheritance;

import java.util.UUID;

/**
 * class request extends request to get inheritance
 *
 * @see PostPaymentRequest
 */
public class PostEncryptedPaymentRequest extends PostPaymentRequest {

    private static int count;
    private String randEncryptionScheme = getRandEncryptionScheme();

    /**
     * inheritance from super class and get new variable
     *
     * @param randUUID             random UUID
     * @param randIP               random IP
     * @param randPayment          random Payment
     * @param randEncryptionScheme random Encryption Scheme
     */
    public PostEncryptedPaymentRequest(UUID randUUID, String randIP, Payment randPayment, String randEncryptionScheme) {
        super(randUUID, randIP, randPayment);
        this.randEncryptionScheme = randEncryptionScheme;
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
        return super.toString() + "\nThis payment was encrypted using: " + randEncryptionScheme;
    }
}
