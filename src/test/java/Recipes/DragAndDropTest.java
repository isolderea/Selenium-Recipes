package Recipes;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DragAndDropTest extends BaseTest {

    @Test
    public void dragAndDropTest() {
    //THIS IS NOT WORKING YET
        //navigate to the Page
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");

        //Find the elements
        WebElement sourceObj = driver.findElement(By.id("column-a"));
        WebElement destinationObj = driver.findElement(By.id("column-b"));

        /* Do the action. */
        dragIT(sourceObj,destinationObj);

        /* Verify the drag and drop action success. */
        String dropStatusText = destinationObj.getText();
        Assert.assertEquals(dropStatusText, "A");
    }


    /* This method implement the drag and drop action use selenium webdriver. */
    public void dragIT (WebElement From, WebElement To){
        System.out.println("drag and drop started");

        int x = To.getLocation().x;
        int y = To.getLocation().y;

        Actions actions = new Actions(driver);
        actions.moveToElement(From)
                .pause(Duration.ofSeconds(1))
                .clickAndHold(From)
                .pause(Duration.ofSeconds(1))
                .moveByOffset(x, y)
                .moveToElement(To)
                .moveByOffset(x,y)
                .pause(Duration.ofSeconds(1))
                .release().build().perform();

        System.out.println("drag and drop ended");


    }


}
