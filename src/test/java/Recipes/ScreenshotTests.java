package Recipes;

import base.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ScreenshotTests extends BaseTest {

    @Test
    public void screenshotTest() throws IOException {

        //Take screenshot
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        //Save the file to our code
        FileUtils.copyFile(scrFile, new File("target/main_page.png"));

        // Navigate to the page
        driver.get("https://formy-project.herokuapp.com/datepicker");

        //Take screenshot
        File scrFile2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        //Save another file to our code
        FileUtils.copyFile(scrFile2, new File("target/datepicker.png"));
    }
}
