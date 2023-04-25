import java.util.HashMap;

public class BrowserStackHelper {

    // set your Username and Access Key as the variables
    static final String AUTOMATE_USERNAME = "nikhiltestology_JozyR3";
    static final String AUTOMATE_ACCESS_KEY = "gYbDHJwBq5VDMPGouq5M";

    public static void setupBrowserStackHelper() {


        // other commands...
        // Set your Access Key
        // You can also set an environment variable - "BROWSERSTACK_ACCESS_KEY".
        HashMap<String, String> bsLocalArgs = new HashMap<String, String>();
        bsLocalArgs.put("key", AUTOMATE_ACCESS_KEY);

        HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
        browserstackOptions.put("local", "true");

    }

}
