package RequestInheritance;

/**
 * class video to get video and return
 *
 */
public class Video {
    private String randURL ;
    private String randVideoTitle ;
    private String randName ;

    /**
     * get random values
     * @param randURL get random URL
     * @param randVideoTitle get random titles
     * @param randName get random names
     */
    public Video(String randURL, String randVideoTitle, String randName) {
        this.randName=randName;
        this.randURL=randURL;
        this.randVideoTitle=randVideoTitle;
    }

    /**
     *
     * @return video
     */
    public String getVideo()
    {
        String video;
        video = randURL+"\nVideo: " + randVideoTitle +"\nBy: " +randName;
        return video;
    }

}
