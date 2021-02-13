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
import java.util.ArrayList;
import java.util.List;

public class ScrapeTemplate1 extends BaseTest {


    @Test
    public void funnyWorkGetAlbumLinks() throws InterruptedException, IOException {

        //Navigate to Facebook
        driver.get("https://www.facebook.com/pg/workfunny/photos/?tab=albums&ref=page_internal");

        //Wait for X time
        Thread.sleep(5000);

        //Get the WebElement
        List<WebElement> albumList = driver.findElements(By.cssSelector("._3rte>a"));
        List<String> al = new ArrayList<String>();

        for (int i=0; i<albumList.size();i+=2){

            al.add(albumList.get(i).getAttribute("href"));

        }

       //SAve the link of the Webelements to FunnyWorks.xlsx

        //Get the path to the file
        String path = "resources/FunnyWork.xlsx";

        //Read the file
        FileInputStream fis = new FileInputStream(path);
        Workbook workbook = new XSSFWorkbook(fis);

        //Open the first Excel sheet
        Sheet sheet = workbook.getSheet("Album_Links");

        //Write the data to the Excel
        for(int i=0;i<al.size(); i++){
            Row row = sheet.getRow(i);
            Cell cell = row.createCell(0);
            String value = al.get(i);
            cell.setCellValue(value);
        }

        FileOutputStream fos = new FileOutputStream(path);
        workbook.write(fos);
        //Close the Excel
        fos.close();
    }
}
