package utils.data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * This class contains the methods required to set up the data provider.
 *
 * @lastmodifier Cecilia Ocampo
 */
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
