package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesConfig {
    public static Properties properties;

    public static final String URL = getProperties().getProperty("url");
    public static final Long WAIT_TIME = Long.valueOf(getProperties().getProperty("wait.time"));
    //TODO place in data file
    public static final String VALID_USER = getProperties().getProperty("valid.username");
    public static final String VALID_PASSWORD = getProperties().getProperty("valid.pwd");
    public static final String SORT = getProperties().getProperty("sort.LoToHi");

    public static Properties getProperties() {
        if (properties == null) {

            try {
                FileInputStream file = new FileInputStream("./src/main/resources/data.properties");
                properties = new Properties(System.getProperties());
                properties.load(file);

                return properties;
            } catch (FileNotFoundException e) {
                //TODO Log exception
            } catch (IOException e) {
                //TODO Log exception
            }
        } else {
            return properties;
        }

        return null;
    }
}
