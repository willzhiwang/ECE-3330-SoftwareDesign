package RequestInheritance;

/**
 * class payment to get payment and return
 */
public class Payment {
    private final String randName;
    private final int nextInt;
    private final String randName1;

    /**
     * get random values
     *
     * @param randName  get random Name
     * @param nextInt   get random integer
     * @param randName1 get random names
     */
    public Payment(String randName, int nextInt, String randName1) {
        this.randName = randName;
        this.nextInt = nextInt;
        this.randName1 = randName1;
    }

    /**
     * @return Payment String output
     */
    public String toString() {
        return "Payment sender: " + randName + "\nPayment amount: $" + nextInt + "\nPayment receiver: " + randName1;
    }
}
