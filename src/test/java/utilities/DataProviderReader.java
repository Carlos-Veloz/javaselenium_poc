package utilities;

import java.io.*;
import java.util.InvalidPropertiesFormatException;
import java.util.Objects;
import java.util.Properties;

public class DataProviderReader {
    private static DataProviderReader INSTANCE;
    private Properties properties;

    private DataProviderReader() throws FileNotFoundException, InvalidPropertiesFormatException {
        properties = new Properties();
        String path = "src/main/resources/data.properties";

        InputStream initialStream = new FileInputStream(new File(path));

        try {
            properties.load(initialStream);
            properties.toString();
        } catch (IOException ioException) {
            throw new InvalidPropertiesFormatException("Could not read properties file");
        }
    }

    public static DataProviderReader getInstance(){
        if(Objects.isNull(INSTANCE)){
            try{
                INSTANCE = new DataProviderReader();
            }catch(FileNotFoundException | InvalidPropertiesFormatException exception){
                throw new RuntimeException("Could not initialize DataProviderReader object: "
                + exception.getMessage(), exception);
            }
        }
        return INSTANCE;
    }

    public String getValue(String propertyName){
        if(Objects.nonNull(properties)){
            return properties.getProperty(propertyName);
        }
        return null;
    }
}
