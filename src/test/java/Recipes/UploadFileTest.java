package Recipes;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.File;

public class UploadFileTest extends BaseTest {

    @Test
    public void testSimpleAlert() {

    // Navigate to the page
    driver.get("https://formy-project.herokuapp.com/fileupload");

    //Identify our WebElements
    WebElement alertButton = driver.findElement(By.id("file-upload-field"));

        File file = new File("resources/UploadFILE.png");
        String absolutePath = file.getAbsolutePath();

        //Read File Content

    //    alertButton.sendKeys(absolutePath);
        alertButton.sendKeys("UploadFILE.png");
    System.out.println("adasd");
    }
}
