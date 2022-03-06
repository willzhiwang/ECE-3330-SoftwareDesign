package RequestInheritance;

import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

/**
 * This class DataGenerator generate tons of different types of random data.
 */
class DataGenerator {
    // fields to hold example data
    private final Random rand;
    private final String[] names;
    private final String[] encryption;
    private final String[] videoTitles;
    private final String[] filePaths;
    private final String[] fileTypes;
    private final String[] colors;

    // Constructor

    /**
     * DataGenerator to set random data
     */
    DataGenerator() {
        // initialize with example data
        this.rand = new Random();
        this.names = new String[]{"Tom", "Guadalupe", "Tina", "Markus", "Michael", "Diego", "Mr. Patel", "Alex"};
        this.encryption = new String[]{"Vigenere", "One Time Pad", "RSA", "Diffie-Hellman"};
        this.videoTitles = new String[]{"Top 10 Cutest Cat Videos", "ONE Simple Trick to Pass SWD", "Java 101", "Pythonistas Pythoning with Pythons", "P == NP?!?!?!"};
        this.filePaths = new String[]{"/Users/abpwrs/puppies", "/Users/tomc/backstroke", "/Users/swd_student/question", "/Users/cie_student/question", "/Users/student/stress"};
        this.fileTypes = new String[]{"txt", "csv", "pptx", "pdf", "hs", "gif", "png", "h5"};
        this.colors = new String[]{"red", "orange", "yellow", "green", "blue", "indigo", "violet", "egg shell"};
    }

    // private utilities for data generation

    /**
     * @return random name
     */
    private String getRandName() {
        return this.names[this.rand.nextInt(this.names.length)];
    }

    /**
     * @return random color
     */
    private String getRandColor() {
        return this.colors[this.rand.nextInt(this.colors.length)];
    }

    /**
     * @return random video title
     */
    private String getRandVideoTitle() {
        return this.videoTitles[this.rand.nextInt(this.videoTitles.length)];
    }

    /**
     * @return random file type
     */
    private String getRandFileType() {
        return this.fileTypes[this.rand.nextInt(this.fileTypes.length)];
    }

    /**
     * @return random file path
     */
    private String getRandFilePath() {
        return this.filePaths[this.rand.nextInt(this.filePaths.length)];
    }

    // public data generation tools

    /**
     * @return random url
     */
    public String getRandURL() {
        return "localhost:" + (((this.rand.nextInt(9) + 1) * 1000) + this.rand.nextInt(999));
    }

    /**
     * @return random pay
     */
    public Payment getRandPayment() {
        return new Payment(this.getRandName(), this.rand.nextInt(10000), this.getRandName());
    }

    /**
     * @return random uuid
     */
    public UUID getRandUUID() {
        return UUID.randomUUID();
    }

    /**
     * @return random Encryption Scheme
     */
    public String getRandEncryptionScheme() {
        return this.encryption[this.rand.nextInt(this.encryption.length)];
    }

    /**
     * @return random video
     */
    public Video getRandVideo() {
        return new Video(this.getRandURL(), this.getRandVideoTitle(), this.getRandName());
    }

    /**
     * @return random file
     */
    public File getRandFile() {
        return new File(this.getRandFilePath(), this.getRandFileType());
    }

    /**
     * @return random form
     */
    public Form getRandForm() {
        HashMap<String, String> fields = new HashMap<>();
        fields.put("Favorite color", this.getRandColor());
        fields.put("Favorite encryption scheme", this.getRandEncryptionScheme());
        fields.put("Name", this.getRandName());
        return new Form(fields);
    }

    /**
     * @return random ip
     */
    public String getRandIP() {
        return rand.nextInt(256) + "." + rand.nextInt(256) + "." + rand.nextInt(256) + "." + rand.nextInt(256);
    }

}