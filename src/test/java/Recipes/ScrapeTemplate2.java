package Recipes;

import base.BaseTest;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ScrapeTemplate2 extends BaseTest {


    @Test
    public void funnyWork() throws IOException {

    //Get all Links from the albums
    driver.get("https://www.facebook.com/pg/workfunny/photos/?tab=albums&ref=page_internal");

    WebDriverWait wait = new WebDriverWait(driver, 40);
    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("._3rte")));

    List<WebElement> albums = driver.findElements(By.cssSelector("._3rte > a"));
    List<String> al = new ArrayList<String>();

        for(int i=0;i<albums.size(); i++){
            al.add(albums.get(i).getAttribute("href"));
        }

    List<String> listWithoutDuplicates = new ArrayList<>(new HashSet<>(al));


     // Navigate to the page
    driver.get("https://www.facebook.com/pg/workfunny/photos/?tab=album&album_id=2159099824209900&ref=page_internal");

    //Identify our WebElements
    List<WebElement> listofLinks = driver.findElements(By.cssSelector("._2eea > a"));

        //Get the path to the file
        String path = "resources/FunnyWork.xlsx";

        //Read the file
        FileInputStream fis = new FileInputStream(path);
        Workbook workbook = new XSSFWorkbook(fis);

        //Open the first Excel sheet
        Sheet sheet = workbook.getSheetAt(0);

        for(int i=0;i<listofLinks.size(); i++){
            Row row = sheet.getRow(i);
            String value = listofLinks.get(i).getAttribute("href");
            Cell cell = row.createCell(0);
            cell.setCellValue(value);
        }
        //Write to file and close the stream
        FileOutputStream fos = new FileOutputStream(path);
        workbook.write(fos);

        //Read from File
        //Create an FileInput Stream
        FileInputStream fileInputStream = new FileInputStream(path);

        //Create an Instance of a XLSX File
        Workbook testFile = new XSSFWorkbook(fileInputStream);
        Sheet testData = testFile.getSheetAt(0);

        //navigate to page
        String URL1 = testData.getRow(1).getCell(0).getStringCellValue();
        driver.get(URL1);

        //WebElement
        WebElement image = driver.findElement(By.xpath("//img"));
        WebElement dots = driver.findElement(By.cssSelector(".nqmvxvec.j83agx80.jnigpg78.cxgpxx05.dflh9lhu.sj5x9vvc.scb9dxdr.odw8uiq3"));
        dots.click();
        List<WebElement> download = driver.findElements(By.cssSelector(".bp9cbjyn.tiyi1ipj.j83agx80.taijpn5t.tvfksri0"));


    download.get(0).click();



    }
}
