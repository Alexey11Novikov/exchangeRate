package config;

public class ConfigModule {
    private static ConfigModule instance;
    private ReadConfigImpl readConfigImpl;


    static public ConfigModule instance() {
        if (instance == null){
            instance = new ConfigModule();
            instance.init();
        }
        return instance;
    }

    private void init(){
        readConfigImpl = new ReadConfigImpl();
    }

    public String getURl() {
        return readConfigImpl.getApiUrl();
    }

    /**
     *
     */
    public String getTimeConfig() {
        return readConfigImpl.getTime();
    }




}
