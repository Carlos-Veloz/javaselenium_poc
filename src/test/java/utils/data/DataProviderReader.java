package utils.data;

import org.apache.poi.ss.usermodel.Row;
import org.testng.annotations.DataProvider;
import utils.PropertiesConfig;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * This class contains the methods required to set up the data provider.
 *
 * @lastmodifier Cecilia Ocampo
 */
public class DataProviderReader {

    @DataProvider(name = "product-provider")
    public static Object[][] createData() throws FileNotFoundException {
        ExcelReader reader = new ExcelReader();
        Iterator<Row> rowIterator = reader.getRowsFromSheet(PropertiesConfig.PRODUCTS_SHEET_PATH, PropertiesConfig.PRODUCTS_SHEET_NAME);
        List<List<String>> productList = new ArrayList<>();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            ArrayList<String> product = new ArrayList<>();
            product.add(reader.getCellValueAsString(row.getCell(0)));
            product.add(reader.getCellValueAsString(row.getCell(1)));
            product.add(reader.getCellValueAsString(row.getCell(2)));
            productList.add(product);
        }

        return productList.stream().map(List::toArray).toArray(Object[][]::new);
    }

}
