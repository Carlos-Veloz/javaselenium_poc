package utils.data;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import utils.PropertiesConfig;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

/**
 * This class contains the methods to read an excel sheet using apache poi library.
 *
 * @lastmodifier Cecilia Ocampo
 */
public class ExcelReader {

    public Iterator<Row> getRowsFromSheet(String filePath, String sheetName) throws FileNotFoundException {
        FileInputStream excelFile = new FileInputStream(PropertiesConfig.PRODUCTS_SHEET_PATH);

        Iterator<Row> rowIterator = null;
        try {

            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet sheet = workbook.getSheet(sheetName);
            rowIterator = sheet.iterator();
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return rowIterator;
    }

    public String getCellValueAsString(Cell cell){
        String cellContent = "";
        switch (cell.getCellType()){
            case NUMERIC:
                cellContent = String.valueOf(cell.getNumericCellValue());
                break;
            case STRING:
                cellContent = cell.getStringCellValue();
                break;
        }
        return cellContent;
    }


}
