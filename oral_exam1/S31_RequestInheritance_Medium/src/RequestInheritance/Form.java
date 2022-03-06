package RequestInheritance;

import java.util.HashMap;

/**
 * class form to get from and return
 */
public class Form {
    private final HashMap<String, String> fields;
    private String key;
    private String output = "";

    /**
     * @param fields the form in Hashmap
     *               get output of the keys and values one by one
     */
    public Form(HashMap<String, String> fields) {
        this.fields = fields;
        for (HashMap.Entry<String, String> entry : fields.entrySet()) {
            key = ("\n" + "Label:  " + entry.getKey() + "\nValue:  " + entry.getValue());
            output = output + key;
        }
    }

    /**
     * @return Form String output
     */
    public String toString() {
        return output;
    }
}
