package RequestInheritance;

import java.util.UUID;
/**
 * class request extends request to get inheritance
 * @see PostRequest
 */
public class PostFormRequest extends PostRequest {

    private Form randForm = getRandForm();
    public static int count;
    /**
     *inheritance from super class and get new variable
     * @param randUUID random UUID
     * @param randIP  random IP
     * @param randForm  randomForm
     */
    public PostFormRequest(UUID randUUID, String randIP, Form randForm) {
        super (randUUID,randIP);
        this.randForm =randForm;
        count++;
        //System.out.println(randForm);
    }
    /**
     *
     * @return The Stirng output
     */
    public String toString(){
        return super.toString() + "\nForm Data" + randForm;
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
