package utils.data;

import java.io.*;
import java.util.InvalidPropertiesFormatException;
import java.util.Objects;

public class DataProviderReader {
    private static DataProviderReader INSTANCE;

    private DataProviderReader() {
        String path = "src/test/java/data/data.json";

        try {
            FileInputStream file = new FileInputStream(path);

        } catch (FileNotFoundException e) {
            //TODO Log exception
        } catch (IOException e) {
            //TODO Log exception
        }

    }

    //Read file

    public static DataProviderReader getInstance() {
        return null;
    }

}
