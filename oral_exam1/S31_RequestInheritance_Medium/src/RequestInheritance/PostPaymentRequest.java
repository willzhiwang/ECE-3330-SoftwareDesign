package RequestInheritance;

import java.util.UUID;

/**
 * class request extends request to get inheritance
 *
 * @see PostRequest
 */
public class PostPaymentRequest extends PostRequest {

    public static int count;
    private Payment randPayment = getRandPayment();

    /**
     * inheritance from super class and get new variable
     *
     * @param randUUID    random UUID
     * @param randIP      random IP
     * @param randPayment random Pay
     */
    public PostPaymentRequest(UUID randUUID, String randIP, Payment randPayment) {
        super(randUUID, randIP);
        this.randPayment = randPayment;
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
        return super.toString() + "\nPayment Data\n" + randPayment;
    }
}
