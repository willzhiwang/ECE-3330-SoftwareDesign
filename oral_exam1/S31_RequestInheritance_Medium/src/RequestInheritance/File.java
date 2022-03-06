package RequestInheritance;

/**
 * class file to get file and return
 */
public class File {
    private final String randFilePath;
    private final String randFileType;
    private String url;

    /**
     * @param randFilePath random file path
     * @param randFileType random file type
     */
    public File(String randFilePath, String randFileType) {
        this.randFilePath = randFilePath;
        this.randFileType = randFileType;
    }

    /**
     * @return url      by combine path with type
     */
    public String getURL() {
        url = "file://" + randFilePath + "." + randFileType + "\nFile Path: " + randFilePath + "\nFile Type: " + randFileType;
        return url;
    }

}
