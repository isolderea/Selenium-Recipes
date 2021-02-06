package Recipes;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ContextMenuTests extends BaseTest {


    @Test
    public void contextMenu() {

        //Identify the Webelement

        WebElement link = driver.findElement(By.partialLinkText("Autocomplete"));

        // Instanciate actions
        Actions actionToperform = new Actions(driver);

        //Open the context
        actionToperform.moveToElement(link);
        actionToperform.contextClick(link).build().perform();

        System.out.println("Stop");
        //Click on open in new tab
        actionToperform.contextClick(link)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.RETURN)
                .build().perform();

        System.out.println("Stop");
    }
}
