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

public class ReadFromExcel extends BaseTest {


    @Test
    public void writeToExcel() throws IOException {

    //navigate to page
    driver.get("https://formy-project.herokuapp.com/autocomplete");

    //Identify the Webelements
        WebElement adress = driver.findElement(By.id("autocomplete"));
        WebElement str1 = driver.findElement(By.id("street_number"));
        WebElement str2 = driver.findElement(By.id("route"));
        WebElement city = driver.findElement(By.id("locality"));
        WebElement state = driver.findElement(By.id("administrative_area_level_1"));
        WebElement postalCode = driver.findElement(By.id("postal_code"));
        WebElement country = driver.findElement(By.id("country"));

    //Read the data from the Excel

        //Get the path of the file
        String path = "resources/TestDataRecipe.xlsx";

        //Create an FileInput Stream
        FileInputStream fileInputStream = new FileInputStream(path);

        //Create an Instance of a XLSX File
        Workbook testFile = new XSSFWorkbook(fileInputStream);
        Sheet testData = testFile.getSheetAt(0);

    //Store and send the values to the Webpage
        String adressTest = testData.getRow(0).getCell(1).getStringCellValue();
        String str1Test = testData.getRow(1).getCell(1).getStringCellValue();
        String str2Test = testData.getRow(2).getCell(1).getStringCellValue();
        String cityTest = testData.getRow(3).getCell(1).getStringCellValue();
        String stateTest = testData.getRow(4).getCell(1).getStringCellValue();
        String postalCodeTest = testData.getRow(5).getCell(1).getStringCellValue();
        String countryTest = testData.getRow(6).getCell(1).getStringCellValue();

        adress.sendKeys(adressTest);
        str1.sendKeys(str1Test);
        str2.sendKeys(str2Test);
        city.sendKeys(cityTest);
        state.sendKeys(stateTest);
        postalCode.sendKeys(postalCodeTest);
        country.sendKeys(countryTest);

        System.out.println("Stop");


    }
}
