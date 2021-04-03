package Recipes;

import base.BaseTest;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VideoPlayerTest extends BaseTest {

    static ExtentTest test;
    static ExtentReports report;

    @BeforeClass
    public static void startTest()
    {
        report = new ExtentReports("resources/ExtentReportResults.html");
        test = report.startTest("Selenium Recipes Demo");
    }

    @Test
    public void videoPlayerTest() {
        driver.get("https://plyr.io/");

// Get the HTML5 Video Element
        WebElement videoPlayer = driver.findElement(By.id("container"));
//Get the Button
        WebElement play = driver.findElement(By.cssSelector(("div.plyr__controls > button:nth-child(1)")));
        WebElement progress = driver.findElement(By.cssSelector("[id*='plyr-seek']"));
        WebElement captionON = driver.findElement(By.cssSelector("div.plyr__controls > button:nth-child(5)"));
        WebElement caption = driver.findElement(By.cssSelector(".plyr__captions"));

        captionON.click();
        progress.sendKeys("5.46");
        play.click();
        focusElement(videoPlayer);
        //play.click();
        String captionText = caption.getText();

        if (captionText == "This is a test") {
            test.log(LogStatus.PASS, "Test passed captions are ok");
            test.assignAuthor("author passed");
            test.assignCategory("regression");
        } else {
            test.log(LogStatus.FAIL, "Test failed captions are not ok");
            test.assignAuthor("author failed");
            test.assignCategory("regression");
            test.addScreenCapture("resources/image.png");
        }

        };


    public void focusElement(WebElement element){

        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();

    }

    @AfterClass
    public static void endTest()
    {
        report.endTest(test);
        report.flush();
    }

}
