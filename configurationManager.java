
public class configurationManager {

    private static configurationManager myConfigurationManager;
    //private static configuration myCurrenConfiguration;

    private configurationManager() {

    }

    public static configurationManager getInstance() {
        if(myConfigurationManager == null) {
            myConfigurationManager = new configurationManager();
            return myConfigurationManager;
        }
        return myConfigurationManager;
    }

    /**
     * Used to load a configuration file by path provided
     * @param FilePath
     */
    public void loadConfigurationFile(String FilePath) {

    }

    /**
     * Returns the Current loaded Configuration
     */
    public void getCurrentConfiguration() {

    }
}
