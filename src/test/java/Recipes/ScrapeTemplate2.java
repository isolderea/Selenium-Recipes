package Recipes;

import base.BaseTest;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class ScrapeTemplate2 extends BaseTest {


    @Test
    public void funnyWorkSaveImages() throws IOException {

        //Read the album links from Excel

        //Get the path to the file
        String path = "resources/FunnyWork.xlsx";

        //Create an FileInput Stream
        FileInputStream fileInputStream = new FileInputStream(path);

        //Create an Instance of a XLSX File
        Workbook testFile = new XSSFWorkbook(fileInputStream);
        Sheet testData = testFile.getSheetAt(0);

        //navigate to page
        String URL1 = testData.getRow(1).getCell(0).getStringCellValue();
        driver.get(URL1);

        //Get the WebElements
        List<WebElement> imagesLinks = driver.findElements(By.cssSelector("._2eea>a"));

        //Navigate to the images
        driver.get(imagesLinks.get(0).getAttribute("href"));

        //Download the image
        WebElement contextMenu = driver.findElement(By.cssSelector(".nqmvxvec.j83agx80.jnigpg78.cxgpxx05.dflh9lhu.sj5x9vvc.scb9dxdr.odw8uiq3"));
        contextMenu.click();

        List<WebElement> iconList = driver.findElements((By.cssSelector(".bp9cbjyn.tiyi1ipj.j83agx80.taijpn5t.tvfksri0")));
        iconList.get(0).click();

        System.out.println("Stop");


    }
}
