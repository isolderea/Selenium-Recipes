package Recipes;

import base.BaseTest;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class WriteToExcelTest extends BaseTest {


    @Test
    public void writeToExcel() throws IOException {

    // WebElement list
    List<WebElement> listofLinks = driver.findElements(By.cssSelector(".btn.btn-lg"));

    //Get the path to the file
    String path = "resources/ExportRecipe.xlsx";

    //Read the file
    FileInputStream fis = new FileInputStream(path);
    Workbook workbook = new XSSFWorkbook(fis);

    //Open the first Excel sheet
    Sheet sheet = workbook.getSheetAt(0);

        for(int i=0;i<listofLinks.size(); i++){
            Row row = sheet.getRow(i);
            String value = listofLinks.get(i).getText();
            Cell cell = row.createCell(0);
            cell.setCellValue(value);
        }
    //Write to file and close the stream
    FileOutputStream fos = new FileOutputStream(path);
    workbook.write(fos);
    fos.close();
    }
}
