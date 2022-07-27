package utils.data;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.IOException;

public class ExcelReader {

    public Workbook getWorkbook(String filePath) throws IOException {
        File excelFile = new File(filePath);

        return WorkbookFactory.create(excelFile);
    }

    public Sheet getSheet(Workbook excelFile, String sheetName) {
        return excelFile.getSheet(sheetName);
    }


}
